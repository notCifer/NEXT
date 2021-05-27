package com.app.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Regras {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(unique = true)
    private String REGRA;

    @ManyToMany(mappedBy = "REGRAS", fetch = FetchType.LAZY)
    private Collection<Conta> CONTA;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getREGRA() {
        return REGRA;
    }

    public void setREGRA(String REGRA) {
        this.REGRA = REGRA;
    }

    public Collection<Conta> getCONTA() {
        return CONTA;
    }

    public void setCONTA(Collection<Conta> CONTA) {
        this.CONTA = CONTA;
    }

}
