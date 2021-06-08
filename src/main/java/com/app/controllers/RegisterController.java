package com.app.controllers;

import com.app.components.UserValidator;
import com.app.interfaces.SecurityService;
import com.app.interfaces.UserService;
import com.app.models.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Register")
public class RegisterController {
    @Autowired
    private UserService US;

    @Autowired
    private SecurityService SS;
    
    @Autowired
    private UserValidator UV;

    @GetMapping
    public String Load() {
        return "register";
    }

    @PostMapping
    public String Register(@ModelAttribute("contaForm") Conta contaForm, BindingResult bResult){
        UV.validate(contaForm, bResult);

        if (bResult.hasErrors()) {
            return "register";
        }

        US.save(contaForm);

        SS.autoLogin(contaForm.getUsername(), contaForm.getPassword());

        return "redirect:/Login";

    }
}