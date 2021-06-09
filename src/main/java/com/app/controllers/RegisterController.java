package com.app.controllers;

import com.app.interfaces.UserService;
import com.app.models.dto.CadastroDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService US;

    public RegisterController(UserService uS) {
        US = uS;
    }

    @ModelAttribute("conta")
    public CadastroDTO cadastroDTO() {
        return new CadastroDTO();
    }

    @GetMapping
    public String Load() {
        return "register";
    }

    @PostMapping
    public String Register(@ModelAttribute("conta") CadastroDTO DTO) {
        US.save(DTO);
        return "redirect:/register?sucess";

    }
}