package com.app.models.form;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.app.models.Pessoa;
import com.app.models.Usuario;
import com.app.repositories.PessoaRepository;

public class PessoaFORM {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String dtNasc;

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

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    public Pessoa toFORM(PessoaRepository pessoaR, Usuario usuario, byte[] image) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate convertDate = LocalDate.parse(dtNasc, formatter);
        Pessoa pessoa = new Pessoa(image, nome, sobrenome, cpf, convertDate, usuario);
        try {
            System.out.println(image);
            pessoaR.save(pessoa);
        } catch (Exception e) {
            e.getCause();
        }  
        return pessoa;
    }

}
