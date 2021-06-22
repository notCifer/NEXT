package com.app.models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double valor;
    private LocalDateTime hoje;
    @ManyToOne
    private Usuario usuario;

    public Historico() {
    } 

    public Historico(Double valor, LocalDateTime hoje, Usuario usuario) {
        this.valor = valor;
        this.hoje = hoje;
        this.usuario = usuario;
    }

    public Historico(Double valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getHoje() {
        return hoje;
    }

    public void setHoje(LocalDateTime hoje) {
        this.hoje = hoje;
    }

    

}