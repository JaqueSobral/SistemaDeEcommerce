package com.catalisa.zup.SistemaDeEcommerce.services;

import com.catalisa.zup.SistemaDeEcommerce.models.Cliente;
import com.catalisa.zup.SistemaDeEcommerce.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public boolean existsByCpf(String cpf) {
        return this.clienteRepository.existsByCpf(cpf);
    }

    public boolean existsByEmail(String email) {
        return this.clienteRepository.existsByEmail(email);
    }

    public Cliente save(Cliente cliente) {
        return (Cliente)this.clienteRepository.save(cliente);
    }

    public Cliente findByCpf(String cpf) {
        return this.clienteRepository.findByCpf(cpf);
    }
}
