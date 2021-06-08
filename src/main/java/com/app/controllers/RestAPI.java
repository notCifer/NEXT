package com.app.controllers;

import java.util.List;
import javax.validation.Valid;

import com.app.models.Conta;
import com.app.repositories.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class RestAPI {

    @Autowired
    private ContaRepository CR;

    @GetMapping
    public List<Conta> findAllConta() {
        return CR.findAll();
    }

    @PostMapping
    public Conta addConta(@RequestBody @Valid Conta C) {
        CR.save(C);
        return C;
    }

}