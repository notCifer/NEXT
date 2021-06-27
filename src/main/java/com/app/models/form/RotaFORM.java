package com.app.models.form;

import javax.validation.constraints.NotBlank;

import com.app.models.Rota;
import com.app.models.Usuario;
import com.app.repositories.RotaRepository;

public class RotaFORM {

    @NotBlank
    private String linha;
    @NotBlank
    private String paradaInicial;
    @NotBlank
    private String paradaFinal;

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public String getParadaInicial() {
        return paradaInicial;
    }

    public void setParadaInicial(String paradaInicial) {
        this.paradaInicial = paradaInicial;
    }

    public String getParadaFinal() {
        return paradaFinal;
    }

    public void setParadaFinal(String paradaFinal) {
        this.paradaFinal = paradaFinal;
    }

    public Rota toFORM(RotaRepository rotaR, Usuario conta) {
        Rota rota = new Rota(linha, paradaInicial, paradaFinal, conta);
        rotaR.save(rota);
        return rota;
    }

}