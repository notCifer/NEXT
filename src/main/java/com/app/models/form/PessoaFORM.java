package com.app.models.form;

import java.time.LocalDate;
import com.app.models.Pessoa;
import com.app.models.Usuario;
import com.app.repositories.PessoaRepository;

public class PessoaFORM {

    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDate DTNASCIMENTO;

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

    public Pessoa toFORM(PessoaRepository pessoaR, Usuario usuario) {
        Pessoa pessoa = new Pessoa(nome, sobrenome, cpf, DTNASCIMENTO, usuario);
        pessoaR.save(pessoa);
        return pessoa;
    }

}