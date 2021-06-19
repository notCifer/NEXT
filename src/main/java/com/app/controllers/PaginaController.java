package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nextpoint")
public class PaginaController {

    @GetMapping
    public String pagina() {
        return "page";
    }

}