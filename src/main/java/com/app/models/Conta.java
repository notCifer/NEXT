package com.app.models;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Conta {

    public Conta() {
    }

    public Conta(@NotEmpty @NotNull String usuario, @NotEmpty @NotNull String email, @NotEmpty @NotNull String senha,
            Collection<Regra> regras) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.regras = regras;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String usuario;

    @NotEmpty
    @NotNull
    @Column
    private String senha;

    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "contas_regras", joinColumns = @JoinColumn(name = "conta_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "regra_id", referencedColumnName = "id"))
    private Collection<Regra> regras;

    @OneToOne(mappedBy = "conta", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Regra> getRegras() {
        return regras;
    }

    public void setRegras(Collection<Regra> regras) {
        this.regras = regras;
    }

}