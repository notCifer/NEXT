package com.app.controller;

import java.util.List;
import javax.validation.Valid;
import com.app.model.Conta;
import com.app.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contas")
public class PostmanController {

    @Autowired
    private ContaRepository CR;

    @GetMapping
    public ResponseEntity<List<Conta>> getConta() {
        List<Conta> C = CR.findAll();
        return ResponseEntity.ok().body(C);
    }

    @PostMapping
    public ResponseEntity<?> postProduct(@RequestBody @Valid Conta C) {
        CR.save(C);
        return ResponseEntity.ok().body(C);
    }

}