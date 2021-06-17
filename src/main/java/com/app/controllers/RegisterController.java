package com.app.controllers;

import com.app.models.form.UsuarioFORM;
import com.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UsuarioRepository usuarioR;

    @ModelAttribute("usuario")
    public UsuarioFORM uForm() {
        return new UsuarioFORM();
    }

    @GetMapping
    public String Load() {
        return "register";
    }

    @PostMapping
    public String Register(@ModelAttribute("usuario") UsuarioFORM FORM) {
        FORM.toForm(usuarioR);
        return "redirect:/register?sucess";
    }

}