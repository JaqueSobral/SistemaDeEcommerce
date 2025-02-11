package com.catalisa.zup.SistemaDeEcommerce.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Generated;

@Entity
public class Produto {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            unique = true
    )
    private @NotBlank(
            message = "O nome do produto é obrigatório."
    ) String nome;
    private @Min(
            value = 0L,
            message = "O preço deve ser maior que 0."
    ) Double preco;
    private @Min(
            value = 0L,
            message = "A quantidade deve ser maior ou igual a 0."
    ) int quantidade;

    @Generated
    public Produto() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Produto)) {
            return false;
        } else {
            Produto other = (Produto)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getQuantidade() != other.getQuantidade()) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$preco = this.getPreco();
                Object other$preco = other.getPreco();
                if (this$preco == null) {
                    if (other$preco != null) {
                        return false;
                    }
                } else if (!this$preco.equals(other$preco)) {
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
        return other instanceof Produto;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getQuantidade();
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $preco = this.getPreco();
        result = result * 59 + ($preco == null ? 43 : $preco.hashCode());
        Object $nome = this.getNome();
        result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "Produto(id=" + var10000 + ", nome=" + this.getNome() + ", preco=" + this.getPreco() + ", quantidade=" + this.getQuantidade() + ")";
    }

    @Generated
    public void setNome(final String nome) {
        this.nome = nome;
    }

    @Generated
    public String getNome() {
        return this.nome;
    }

    @Generated
    public void setPreco(final Double preco) {
        this.preco = preco;
    }

    @Generated
    public Double getPreco() {
        return this.preco;
    }

    @Generated
    public void setQuantidade(final int quantidade) {
        this.quantidade = quantidade;
    }

    @Generated
    public int getQuantidade() {
        return this.quantidade;
    }
}