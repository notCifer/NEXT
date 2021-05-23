package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

    public Conta() {
    }

    public Conta(String usuario, String cpf, String senha, String email) {
        Usuario = usuario;
        CPF = cpf;
        Senha = senha;
        Email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Usuario;
    private String CPF;
    private String Senha;
    private String Email;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getUsuário() {
        return Usuario;
    }

    public void setUsuário(String Usuário) {
        this.Usuario = Usuário;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}