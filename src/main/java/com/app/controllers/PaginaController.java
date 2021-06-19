package com.app.controllers;

import java.util.List;
import java.util.Optional;
import com.app.models.Historico;
import com.app.models.Usuario;
import com.app.repositories.HistoricoRepository;
import com.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/nextpoint")
public class PaginaController {

    @Autowired
    private HistoricoRepository historicoR;

    @Autowired
    private UsuarioRepository usuarioR;

    @GetMapping
    public ModelAndView home() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Optional<Usuario> usuario = usuarioR.findByEmail(name);
        if (usuario.isPresent()) {
            Usuario us = usuario.get();
            List<Historico> list = historicoR.findAllList(us.getId());
            ModelAndView mav = new ModelAndView("page");
            mav.addObject("historicos", list);
            return mav;
        }   
        return null;
    }

}