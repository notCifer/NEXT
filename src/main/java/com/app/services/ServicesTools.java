package com.app.services;

import java.util.Optional;
import com.app.models.Usuario;
import com.app.repositories.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ServicesTools {

    public Usuario getLogado(UsuarioRepository usuarioR) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Optional<Usuario> usuario = usuarioR.findByEmail(name);
        Usuario us = usuario.get();
        return us;
    }
}