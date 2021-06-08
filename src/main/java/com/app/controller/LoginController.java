package com.app.controller;

import com.app.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private AuthenticationManager AM;

    @Autowired
    private ContaRepository CR;

    @GetMapping
    public String Load() {
        return "login";
    }

}