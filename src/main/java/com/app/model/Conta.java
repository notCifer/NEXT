package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

    public Conta() {
    }

    public Conta(String usuario, String cpf, String senha, String email) {
        USUARIO = usuario;
        CPF = cpf;
        SENHA = senha;
        EMAIL = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(unique = true)
    private String USUARIO;
    private String CPF;
    private String SENHA;
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
}