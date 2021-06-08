package com.app.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id 
    @GeneratedValue
    private Long id;  
    @Column @NotEmpty @NotNull
    private String nome;
    @Column @NotEmpty @NotNull
    private String sobrenome;
    @Column(unique = true) @NotEmpty @NotNull
    private String cpf;
    @Column(name = "data_nascimento") @NotEmpty @NotNull
    private Date DTNASCIMENTO;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Conta conta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
