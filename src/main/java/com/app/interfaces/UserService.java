package com.app.interfaces;

import com.app.models.Conta;

public interface UserService {
    void save(Conta C);

    Conta findByusuario(String usuario);
}