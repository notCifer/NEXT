package com.app.controller;

import java.util.List;

import javax.validation.Valid;
import com.app.controller.dto.TokenDto;
import com.app.controller.form.LoginForm;
import com.app.model.Conta;
import com.app.repository.ContaRepository;
import com.app.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private AuthenticationManager AM;

    @Autowired
    private TokenService TS;

    @Autowired
    private ContaRepository CR;

    @GetMapping
    public String Load() {
        return "login";
    }
    
    // @GetMapping
    // public List<Conta> findAllConta() {
    //     return CR.findAll();
    // }

    // @PostMapping
    // public ResponseEntity<TokenDto> Autenticar(@RequestBody @Valid LoginForm form){   
    //     UsernamePasswordAuthenticationToken DadosLogin = form.converter();
    //     try {
    //         Authentication AUTH = AM.authenticate(DadosLogin);   
    //         String token = TokenService.gerarToken(AUTH);
    //         System.out.println("logou");
    //         return ResponseEntity.ok(new TokenDto(token,"Bearer")) ;
    //     } catch (AuthenticationException e) {
    //         return ResponseEntity.badRequest().build();
    //     }      
    // }

    // @PostMapping("/Login/register")
    // public ResponseEntity<Conta> Cadastrar(@RequestBody @Valid Conta C){
    //     try {
    //          CR.save(C);
    //         return ResponseEntity.ok().body(C);
    //     } catch (Exception e) {
    //         return ResponseEntity.badRequest().body(null);
    //     }
    // }

}