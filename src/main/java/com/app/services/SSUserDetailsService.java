package com.app.services;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import com.app.model.Conta;
import com.app.model.Regras;
import com.app.repository.ContaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {

    private ContaRepository UR;

    public SSUserDetailsService(ContaRepository UR2){
        this.UR = UR2;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Conta C = UR.findByUSUARIO(username);
            if (C == null) {
                return null;
            }
            return new org.springframework.security.core.userdetails.User(C.getUSUARIO(),C.getSENHA(), getAuthories(C));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usuario não foi encontrado");
        }
    }

    private Set<GrantedAuthority> getAuthories(Conta C2){
        Set<GrantedAuthority> auth = new HashSet<>();
        for (Regras R : C2.getREGRAS()) {
            GrantedAuthority GA = new SimpleGrantedAuthority(R.getREGRA());
            auth.add(GA);
        }
        return auth;
    }
    
}