package com.app.models.form;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import com.app.models.Historico;
import com.app.models.Usuario;
import com.app.repositories.HistoricoRepository;

public class HistoricoFORM {

    @NotNull(message = "Valor inserido")
    private Double valor;
    @NotNull
    private Usuario usuario;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Historico toFORM(HistoricoRepository historicoR, Usuario usuario) {
        LocalDateTime atual = LocalDateTime.now();
        Historico historico = new Historico(valor, atual, usuario);
        historicoR.save(historico);
        return historico;
    }

}