package com.app.services;

import java.util.HashSet;

import com.app.interfaces.UserService;
import com.app.models.Conta;
import com.app.repositories.ContaRepository;
import com.app.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ContaRepository CR;

    @Autowired
    private PerfilRepository PR;

    @Override
    public void save(Conta C) {
        C.setPerfis(new HashSet<>(PR.findAll()));
        CR.save(C);
    }

    @Override
    public Conta findByusuario(String usuario) {
        return CR.findByusuario(usuario);
    }
    
}