package com.app;

import java.util.List;
import com.app.model.Conta;
import com.app.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private ContaRepository CR;

    @RequestMapping("/home")
    public String index() {
        return "index";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public String salvar(@RequestParam("Usuario") String Usuario, @RequestParam("Senha") String Senha,
            @RequestParam("Email") String Email, @RequestParam("CPF") String CPF) {
        Conta NewC = new Conta(Usuario, CPF, Senha, Email);
        try {
            CR.save(NewC);
            return "salvar";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping("/contas")
    public ResponseEntity<List<Conta>> getConta() {
        List<Conta> C = CR.findAll();
        return ResponseEntity.ok().body(C);
    }

    @PostMapping("/contas")
    public ResponseEntity<?> postProduct(@RequestBody Conta C) {
        CR.save(C);
        return ResponseEntity.ok().body(C);
    }

}