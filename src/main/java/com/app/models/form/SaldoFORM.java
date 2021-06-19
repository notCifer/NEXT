package com.app.models.form;

import javax.validation.constraints.NotNull;
import com.app.models.Saldo;
import com.app.models.Usuario;
import com.app.repositories.SaldoRepository;

public class SaldoFORM {

    @NotNull
    private Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Saldo toForm(SaldoRepository saldoR, Usuario usuario) {
        Saldo saldo = new Saldo(valor, usuario);
        saldoR.save(saldo);
        return saldo;
    }

}