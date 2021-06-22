package com.app.controllers;

import java.util.List;
import java.util.Optional;
import com.app.models.Historico;
import com.app.models.Usuario;
import com.app.models.dto.HistoricoDTO;
import com.app.models.form.HistoricoFORM;
import com.app.repositories.HistoricoRepository;
import com.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginaController {

    @Autowired
    private HistoricoRepository historicoR;

    @Autowired
    private UsuarioRepository usuarioR;

    @RequestMapping(value = "/nextpoint", method = RequestMethod.GET)
    public ModelAndView home(Model model) {
        HistoricoDTO DTO = new HistoricoDTO();
        HistoricoFORM FORM = new HistoricoFORM();
        model.addAttribute("historicoform", FORM);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Optional<Usuario> usuario = usuarioR.findByEmail(name);

        if (usuario.isPresent()) {
            Usuario us = usuario.get();
            List<Historico> list = historicoR.findAllList(us.getId());
            List<HistoricoDTO> listDTO = DTO.EntidDTO(list);
            ModelAndView mav = new ModelAndView("page");
            mav.addObject("historicos", listDTO);
            return mav;
        }
        return null;
    }

    @RequestMapping(value = "/Saldo", method = RequestMethod.POST)
    public String Add(@ModelAttribute HistoricoFORM FORM , Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "redirect:/nextpoint#Saldo?error";
        }
        System.out.println(FORM);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Optional<Usuario> usuario = usuarioR.findByEmail(name);
        Usuario us = usuario.get();
        FORM.toFORM(historicoR, us);
        return "redirect:/nextpoint#Saldo";

    }

}