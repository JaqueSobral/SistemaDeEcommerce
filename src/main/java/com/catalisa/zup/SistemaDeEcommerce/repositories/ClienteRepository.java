package com.catalisa.zup.SistemaDeEcommerce.repositories;


import com.catalisa.zup.SistemaDeEcommerce.models.Cliente;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCpf(String cpf);

    boolean existsByCpf(String cpf);

    boolean existsByEmail(@Email(
            message = "O email deve ser válido."
    ) String email);
}