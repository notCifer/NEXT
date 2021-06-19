package com.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Saldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    @OneToOne
    private Usuario usuario;

    public Saldo() {
    }

    public Saldo(Double saldo, Usuario usuario) {
        this.valor = saldo;
        this.usuario = usuario;
    }

    public Double getSaldo() {
        return valor;
    }

    public void setSaldo(Double saldo) {
        this.valor = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}