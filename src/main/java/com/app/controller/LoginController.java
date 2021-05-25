package com.app.controller;

import javax.transaction.Transactional;

import com.app.model.Conta;
import com.app.repository.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LoginController {

    @Autowired
    private ContaRepository CR;

    @RequestMapping("/Login")
    public String Load() {
        return "login";
    }

    @RequestMapping("salvar")
    @Transactional
    public String Add(@RequestBody @RequestParam("Usuario") String Usuario, @RequestParam("Senha") String Senha,
            @RequestParam("Email") String Email, @RequestParam("CPF") String CPF) {
        Conta NewC = new Conta(Usuario, CPF, Senha, Email);

        Conta C = CR.findByUsuario(Usuario);

        if (C == null) {
            try {
                CR.save(NewC);
                return "salvar";
            } catch (Exception e) {
                e.toString();
                return "/Login";
            }
        } else {
            System.out.println("Usuário já existe");
            return "/Login";
        }
    }
}