package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Column(name = "nome")
    private String NOME;
    @Column(name = "sobrenome")
    private String SOBRENOME;
    @Column(name = "cpf", unique = true)
    private String CPF;
    @Column(name = "data_nascimento")
    private Date DTNASCIMENTO;
    @OneToOne(mappedBy = "PESSOA")
    private Conta CONTA;


}
