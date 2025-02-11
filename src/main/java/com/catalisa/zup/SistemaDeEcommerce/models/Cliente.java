package com.catalisa.zup.SistemaDeEcommerce.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Generated;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private @NotBlank(
            message = "O nome do cliente é obrigatório."
    ) String nome;
    @Column(
            unique = true
    )
    private @Pattern(
            regexp = "^[0-9]{11}$",
            message = "CPF deve conter 11 dígitos numéricos"
    ) String cpf;
    @Column(
            unique = true
    )
    private @Email(
            message = "O email deve ser válido."
    ) String email;

    public Cliente() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getNome() {
        return this.nome;
    }

    @Generated
    public String getCpf() {
        return this.cpf;
    }

    @Generated
    public String getEmail() {
        return this.email;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setNome(final String nome) {
        this.nome = nome;
    }

    @Generated
    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    @Generated
    public void setEmail(final String email) {
        this.email = email;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Cliente)) {
            return false;
        } else {
            Cliente other = (Cliente)o;
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

                Object this$nome = this.getNome();
                Object other$nome = other.getNome();
                if (this$nome == null) {
                    if (other$nome != null) {
                        return false;
                    }
                } else if (!this$nome.equals(other$nome)) {
                    return false;
                }

                Object this$cpf = this.getCpf();
                Object other$cpf = other.getCpf();
                if (this$cpf == null) {
                    if (other$cpf != null) {
                        return false;
                    }
                } else if (!this$cpf.equals(other$cpf)) {
                    return false;
                }

                Object this$email = this.getEmail();
                Object other$email = other.getEmail();
                if (this$email == null) {
                    if (other$email != null) {
                        return false;
                    }
                } else if (!this$email.equals(other$email)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Cliente;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $nome = this.getNome();
        result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
        Object $cpf = this.getCpf();
        result = result * 59 + ($cpf == null ? 43 : $cpf.hashCode());
        Object $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "Cliente(id=" + var10000 + ", nome=" + this.getNome() + ", cpf=" + this.getCpf() + ", email=" + this.getEmail() + ")";
    }
}