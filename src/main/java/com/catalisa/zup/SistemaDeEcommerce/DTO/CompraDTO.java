package com.catalisa.zup.SistemaDeEcommerce.DTO;

import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Generated;

public class CompraDTO {
    private @NotBlank(
            message = "O CPF é obrigatório."
    ) String cpf;
    private List<String> produtos;

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CompraDTO)) {
            return false;
        } else {
            CompraDTO other = (CompraDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$cpf = this.getCpf();
                Object other$cpf = other.getCpf();
                if (this$cpf == null) {
                    if (other$cpf != null) {
                        return false;
                    }
                } else if (!this$cpf.equals(other$cpf)) {
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
        return other instanceof CompraDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $cpf = this.getCpf();
        result = result * 59 + ($cpf == null ? 43 : $cpf.hashCode());
        Object $produtos = this.getProdutos();
        result = result * 59 + ($produtos == null ? 43 : $produtos.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getCpf();
        return "CompraDTO(cpf=" + var10000 + ", produtos=" + this.getProdutos() + ")";
    }

    @Generated
    public String getCpf() {
        return this.cpf;
    }

    @Generated
    public List<String> getProdutos() {
        return this.produtos;
    }

    @Generated
    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    @Generated
    public void setProdutos(final List<String> produtos) {
        this.produtos = produtos;
    }

    @Generated
    public CompraDTO() {
    }
}