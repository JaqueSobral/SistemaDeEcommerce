package com.catalisa.zup.SistemaDeEcommerce.services;


import com.catalisa.zup.SistemaDeEcommerce.DTO.CompraDTO;
import com.catalisa.zup.SistemaDeEcommerce.models.Cliente;
import com.catalisa.zup.SistemaDeEcommerce.models.Compra;
import com.catalisa.zup.SistemaDeEcommerce.models.Produto;
import com.catalisa.zup.SistemaDeEcommerce.repositories.ClienteRepository;
import com.catalisa.zup.SistemaDeEcommerce.repositories.CompraRepository;
import com.catalisa.zup.SistemaDeEcommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    private CompraRepository compraRepository;
    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;

    @Autowired
    public CompraService(CompraRepository compraRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.compraRepository = compraRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public ResponseEntity<?> registrarCompra(CompraDTO compraDto) {
        Cliente cliente = this.clienteRepository.findByCpf(compraDto.getCpf());
        if (cliente == null) {
            return ResponseEntity.badRequest().body("Cliente não encontrado.");
        } else {
            List<String> produtosEmFalta = this.verificarProdutosEmFalta(compraDto);
            if (!produtosEmFalta.isEmpty()) {
                return ResponseEntity.badRequest().body("Produtos em falta: " + produtosEmFalta);
            } else {
                try {
                    this.atualizarEstoqueProdutos(compraDto);
                    Compra compra = new Compra();
                    compra.setProdutos(compraDto.getProdutos());
                    this.compraRepository.save(compra);
                    return ResponseEntity.ok(compra);
                } catch (IllegalArgumentException e) {
                    return ResponseEntity.badRequest().body(e.getMessage());
                }
            }
        }
    }

    private List<String> verificarProdutosEmFalta(CompraDTO compraDTO) {
        List<String> produtosEmFalta = new ArrayList();
        compraDTO.getProdutos().forEach((nomeProduto) -> {
            Optional<Produto> produtoOptional = this.produtoRepository.findByNome(nomeProduto);
            if (produtoOptional.isEmpty()) {
                produtosEmFalta.add(nomeProduto);
            } else {
                Produto produto = (Produto)produtoOptional.get();
                if (produto.getQuantidade() < 1) {
                    produtosEmFalta.add(produto.getNome() + " (quantidade insuficiente)");
                }
            }

        });
        return produtosEmFalta;
    }

    private void atualizarEstoqueProdutos(CompraDTO compraDTO) {
        compraDTO.getProdutos().forEach((nomeProduto) -> {
            Optional<Produto> produtoOptional = this.produtoRepository.findByNome(nomeProduto);
            if (produtoOptional.isPresent()) {
                Produto produto = (Produto)produtoOptional.get();
                if (produto.getQuantidade() > 0) {
                    produto.setQuantidade(produto.getQuantidade() - 1);
                    this.produtoRepository.save(produto);
                } else {
                    throw new IllegalArgumentException("Estoque insuficiente para o produto: " + nomeProduto);
                }
            } else {
                throw new IllegalArgumentException("Produto não encontrado: " + nomeProduto);
            }
        });
    }
}