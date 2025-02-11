package com.catalisa.zup.SistemaDeEcommerce.DTO;

import com.catalisa.zup.SistemaDeEcommerce.models.Produto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Generated;

public class ProdutoDTO {
    private @NotBlank(
            message = "O nome do produto é obrigatório."
    ) String nome;
    private @NotNull(
            message = "O preço do produto é obrigatório."
    ) @DecimalMin(
            value = "0.01",
            message = "O preço deve ser maior que 0."
    ) Double preco;
    private @NotNull(
            message = "A quantidade do produto é obrigatória."
    ) @Min(
            value = 0L,
            message = "A quantidade deve ser maior ou igual a 0."
    ) Integer quantidade;

    public Produto toEntity() {
        Produto produto = new Produto();
        produto.setNome(this.nome);
        produto.setPreco(this.preco);
        produto.setQuantidade(this.quantidade);
        return produto;
    }

    @Generated
    public ProdutoDTO() {
    }

    @Generated
    public String getNome() {
        return this.nome;
    }

    @Generated
    public Double getPreco() {
        return this.preco;
    }

    @Generated
    public Integer getQuantidade() {
        return this.quantidade;
    }

    @Generated
    public void setNome(final String nome) {
        this.nome = nome;
    }

    @Generated
    public void setPreco(final Double preco) {
        this.preco = preco;
    }

    @Generated
    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ProdutoDTO)) {
            return false;
        } else {
            ProdutoDTO other = (ProdutoDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$preco = this.getPreco();
                Object other$preco = other.getPreco();
                if (this$preco == null) {
                    if (other$preco != null) {
                        return false;
                    }
                } else if (!this$preco.equals(other$preco)) {
                    return false;
                }

                Object this$quantidade = this.getQuantidade();
                Object other$quantidade = other.getQuantidade();
                if (this$quantidade == null) {
                    if (other$quantidade != null) {
                        return false;
                    }
                } else if (!this$quantidade.equals(other$quantidade)) {
                    return false;
                }

                Object this$nome = this.getNome();
                Object other$nome = other.getNome();
                if (this$nome == null) {
                    if (other$nome != null) {
                        return false;
                    }
                } else if (!this$nome.equals(other$nome)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof ProdutoDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $preco = this.getPreco();
        result = result * 59 + ($preco == null ? 43 : $preco.hashCode());
        Object $quantidade = this.getQuantidade();
        result = result * 59 + ($quantidade == null ? 43 : $quantidade.hashCode());
        Object $nome = this.getNome();
        result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getNome();
        return "ProdutoDTO(nome=" + var10000 + ", preco=" + this.getPreco() + ", quantidade=" + this.getQuantidade() + ")";
    }
}
