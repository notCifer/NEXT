package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String USUARIO;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String CPF;

    @NotNull
    @NotEmpty
    private String SENHA;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String EMAIL;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getUsuario() {
        return USUARIO;
    }

    public void setUsuario(String usuario) {
        this.USUARIO = usuario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return SENHA;
    }

    public void setSenha(String Senha) {
        this.SENHA = Senha;
    }

    public String getEmail() {
        return EMAIL;
    }

    public void setEmail(String Email) {
        this.EMAIL = Email;
    }

    public Conta() {
    }

    public Conta(String usuario, String cpf, String senha, String email) {
        USUARIO = usuario;
        CPF = cpf;
        SENHA = senha;
        EMAIL = email;
    }
}