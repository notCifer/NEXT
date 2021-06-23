package com.app.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private byte[] image;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String cpf;
    private LocalDate dtNasc;
    @OneToOne(fetch = FetchType.LAZY)
    private Usuario conta;

    public Pessoa() {
    }

    public Pessoa(byte[] image, String nome, String sobrenome, String cpf, LocalDate dtNasc, Usuario conta) {
        this.image = image;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public Usuario getConta() {
        return conta;
    }

    public void setConta(Usuario conta) {
        this.conta = conta;
    }

}
