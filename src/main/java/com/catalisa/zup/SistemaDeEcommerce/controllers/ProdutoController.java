package com.catalisa.zup.SistemaDeEcommerce.controllers;

import com.catalisa.zup.SistemaDeEcommerce.models.Produto;
import com.catalisa.zup.SistemaDeEcommerce.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/produtos"})
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarProduto(@org.jetbrains.annotations.NotNull @Validated @RequestBody Produto produto) {
        return this.produtoService.existsByNome(produto.getNome()) ? ResponseEntity.badRequest().body("Produto com este nome já cadastrado") : ResponseEntity.ok(this.produtoService.criarProduto(produto));
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {
        try {
            Produto produto = this.produtoService.getProductById(id);
            return ResponseEntity.ok(produto);
        } catch (Exception var3) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodosProdutos() {
        try {
            List<Produto> listaDeProdutos = this.produtoService.getAllProducts();
            return ResponseEntity.ok(listaDeProdutos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao buscar produtos: " + e.getMessage());
        }
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto informacaoDoProduto, @PathVariable Long id) throws Exception {
        Produto produto = this.produtoService.updateProduto(informacaoDoProduto, id);
        return produto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(produto);
    }
}