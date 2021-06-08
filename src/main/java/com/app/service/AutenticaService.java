package com.app.service;

import java.util.Optional;
import com.app.model.Conta;
import com.app.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticaService implements UserDetailsService {
    
    @Autowired
    private ContaRepository CR;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Conta> usuario = CR.findByusuario(username);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new UsernameNotFoundException("Usuário ou Senha inválidos");
        }
    }
}