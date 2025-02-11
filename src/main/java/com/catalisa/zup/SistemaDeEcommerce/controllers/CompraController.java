package com.catalisa.zup.SistemaDeEcommerce.controllers;

import com.catalisa.zup.SistemaDeEcommerce.DTO.CompraDTO;
import com.catalisa.zup.SistemaDeEcommerce.services.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/compras"})
public class CompraController {
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<?> registrarCompra(@RequestBody CompraDTO compraDTO) {
        try {
            ResponseEntity<?> compraSalva = this.compraService.registrarCompra(compraDTO);
            return ResponseEntity.ok(compraSalva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}