package com.app.controller;

import com.app.model.Conta;
import com.app.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ContaRepository CR;

    @GetMapping
    public String Load() {
        return "login";
    }

}