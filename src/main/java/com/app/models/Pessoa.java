package com.app.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column(unique = true)
    private String cpf;

    @Column(name = "data_nascimento")
    private Date DTNASCIMENTO;
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Usuario conta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getConta() {
        return conta;
    }

    public void setConta(Usuario conta) {
        this.conta = conta;
    }

}
