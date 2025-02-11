package com.catalisa.zup.SistemaDeEcommerce.services;

import com.catalisa.zup.SistemaDeEcommerce.models.Produto;
import com.catalisa.zup.SistemaDeEcommerce.repositories.ProdutoRepository;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto criarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        } else {
            return (Produto)this.repository.save(produto);
        }
    }

    public Produto getProductById(Long id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("O ID do produto não pode ser nulo.");
        } else {
            return (Produto)this.repository.findById(id).orElseThrow(() -> new Exception("Produto não encontrado com o ID: " + id));
        }
    }

    public List<Produto> getAllProducts() {
        return this.repository.findAll();
    }

    public Produto updateProduto(Produto updatedProduto, Long id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("O ID do produto não pode ser nulo.");
        } else if (updatedProduto == null) {
            throw new IllegalArgumentException("O produto atualizado não pode ser nulo.");
        } else {
            Produto existingProduct = (Produto)this.repository.findById(id).orElseThrow(() -> new Exception("Produto não encontrado com o ID: " + id));
            existingProduct.setNome(updatedProduto.getNome());
            existingProduct.setPreco(updatedProduto.getPreco());
            existingProduct.setQuantidade(updatedProduto.getQuantidade());
            return (Produto)this.repository.save(existingProduct);
        }
    }

    public void deleteProduct(Long id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("O ID do produto não pode ser nulo.");
        } else if (!this.repository.existsById(id)) {
            throw new Exception("Produto não encontrado com o ID: " + id);
        } else {
            this.repository.deleteById(id);
        }
    }

    public boolean existsByNome(@NotBlank(
            message = "O nome do produto é obrigatório."
    ) String nome) {
        boolean existsByNome = false;
        return existsByNome;
    }
}