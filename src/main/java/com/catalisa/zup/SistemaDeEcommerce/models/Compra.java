package com.catalisa.zup.SistemaDeEcommerce.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import lombok.Generated;

@Entity
public class Compra {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ElementCollection
    private List<String> produtos;

    @Generated
    public Compra() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public List<String> getProdutos() {
        return this.produtos;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setProdutos(final List<String> produtos) {
        this.produtos = produtos;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Compra)) {
            return false;
        } else {
            Compra other = (Compra)o;
            if (!other.canEqual(this)) {
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

                Object this$produtos = this.getProdutos();
                Object other$produtos = other.getProdutos();
                if (this$produtos == null) {
                    if (other$produtos != null) {
                        return false;
                    }
                } else if (!this$produtos.equals(other$produtos)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Compra;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $produtos = this.getProdutos();
        result = result * 59 + ($produtos == null ? 43 : $produtos.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "Compra(id=" + var10000 + ", produtos=" + this.getProdutos() + ")";
    }
}