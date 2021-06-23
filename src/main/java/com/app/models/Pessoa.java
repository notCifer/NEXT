package com.app.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String cpf;
    @Column(name = "data_nascimento")
    private LocalDate DTNASCIMENTO;
    @OneToOne(fetch = FetchType.LAZY)
    private Usuario conta;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome, String cpf, LocalDate dTNASCIMENTO, Usuario conta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        DTNASCIMENTO = dTNASCIMENTO;
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDTNASCIMENTO() {
        return DTNASCIMENTO;
    }

    public void setDTNASCIMENTO(LocalDate dTNASCIMENTO) {
        DTNASCIMENTO = dTNASCIMENTO;
    }

    public Usuario getConta() {
        return conta;
    }

    public void setConta(Usuario conta) {
        this.conta = conta;
    }

}
