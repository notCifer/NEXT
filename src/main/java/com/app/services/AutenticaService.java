package com.app.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.app.models.Conta;
import com.app.models.Perfil;
import com.app.repositories.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutenticaService implements UserDetailsService {
    
    @Autowired
    private ContaRepository CR;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Conta conta = CR.findByusuario(username);

        if (conta == null) throw new UsernameNotFoundException("Usuário ou Senha inválidos");
        Set<GrantedAuthority> gSet = new HashSet<>();
        for (Perfil perfil : conta.getPerfis()) {
            gSet.add(new SimpleGrantedAuthority(perfil.getAuthority()));
        }
        return new User(conta.getUsername(),conta.getPassword(),gSet);

        // if (usuario.isPresent()) {
        //     return usuario.get();
        // } else {
        //     throw new UsernameNotFoundException("Usuário ou Senha inválidos");
        // }
    }
}