package com.catalisa.zup.SistemaDeEcommerce.controllers;

import com.catalisa.zup.SistemaDeEcommerce.models.Cliente;
import com.catalisa.zup.SistemaDeEcommerce.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/clientes"})
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid Cliente cliente) {
        if (this.clienteService.existsByCpf(cliente.getCpf())) {
            return ResponseEntity.badRequest().body("CPF já cadastrado");
        } else {
            return this.clienteService.existsByEmail(cliente.getEmail()) ? ResponseEntity.badRequest().body("Email já cadastrado") : ResponseEntity.ok(this.clienteService.save(cliente));
        }
    }

    @GetMapping({"/{cpf}"})
    public ResponseEntity<?> buscarCliente(@PathVariable String cpf) {
        Cliente cliente = this.clienteService.findByCpf(cpf);
        return cliente == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(cliente);
    }

    @PutMapping({"/{cpf}"})
    public ResponseEntity<?> atualizarCliente(@PathVariable String cpf, @RequestBody Cliente clienteAtualizado) {
        Cliente cliente = this.clienteService.findByCpf(cpf);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        } else {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            return ResponseEntity.ok(this.clienteService.save(cliente));
        }
    }
}