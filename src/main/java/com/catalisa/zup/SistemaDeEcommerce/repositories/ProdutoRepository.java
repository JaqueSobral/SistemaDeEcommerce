package com.catalisa.zup.SistemaDeEcommerce.repositories;

import com.catalisa.zup.SistemaDeEcommerce.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNome(String nome);
}
