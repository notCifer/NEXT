package br.com.nextpoint.maincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.nextpoint.jpa.model.Conta;
import br.com.nextpoint.repository.ContaRepositorio;

@Controller
public class maincontroller {

    @Autowired
    private ContaRepositorio CR;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("conta", new Conta());
        return "login";
    }

    @PostMapping("/cadastrado")
    public String cadastro(Conta CONTA) {
        CR.save(CONTA);
        return "Logado";

    }
}