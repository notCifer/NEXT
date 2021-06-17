package com.app.controllers;

import com.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nextpoint")
public class PaginaController {

    @Autowired
    private UsuarioRepository UsuarioR;

    @GetMapping
    public String pagina() {
        return "page";
    }

}