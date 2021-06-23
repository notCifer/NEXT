package com.app.controllers;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.validation.Valid;
import com.app.models.Historico;
import com.app.models.Usuario;
import com.app.models.dto.HistoricoDTO;
import com.app.models.form.HistoricoFORM;
import com.app.models.form.PessoaFORM;
import com.app.repositories.HistoricoRepository;
import com.app.repositories.PessoaRepository;
import com.app.repositories.UsuarioRepository;
import com.app.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PessoaRepository pessoaR;

    @Autowired
    private UsuarioServices usuarioS;

    @RequestMapping(value = "/nextpoint", method = RequestMethod.GET)
    public ModelAndView home(Model model) {
        HistoricoDTO DTO = new HistoricoDTO();
        loadPessoa();
        loadHistorico();
        Usuario logado = usuarioS.getLogado(usuarioR);
        if (logado != null) {
            List<Historico> list = historicoR.findAllList(logado.getId());
            Double total = 0.0;
            for (Historico historico : list) {
                total += historico.getValor();
            }
            Locale ptBr = new Locale("pt", "BR");
            String valorString = NumberFormat.getCurrencyInstance(ptBr).format(total);
            model.addAttribute("total", valorString);
            List<HistoricoDTO> listDTO = DTO.EntidDTO(list);
            ModelAndView mav = new ModelAndView("page");
            mav.addObject("historicos", listDTO);
            return mav;
        }
        return null;
    }

    @RequestMapping(value = "/Saldo", method = RequestMethod.POST)
    public String AddSaldo(@ModelAttribute @Valid HistoricoFORM FORM, Errors errors) throws InterruptedException {
        Usuario logado = usuarioS.getLogado(usuarioR);
        if (errors.hasErrors()) {
            return "redirect:/nextpoint?saldoerror#Saldo";
        }
        FORM.toFORM(historicoR, logado);
        TimeUnit.SECONDS.sleep(2);
        return "redirect:/nextpoint#Saldo";
    }

    // --------------PERFIL NÃO ESTA FUNCIONANDO--------------

    @RequestMapping(value = "/Perfil", method = RequestMethod.POST)
    public String AddPessoa(@ModelAttribute PessoaFORM FORM, Errors errors) {

        Usuario logado = usuarioS.getLogado(usuarioR);

        if (errors.hasErrors()) {
            return "redirect:/nextpoint?pessoaerror#Perfil";
        }
        FORM.toFORM(pessoaR, logado);
        return "redirect:/nextpoint#Perfil";
    }

    // ------------------ MODEL ATRIBUTTES ------------------

    @ModelAttribute("historicoform")
    public HistoricoFORM loadHistorico() {
        return new HistoricoFORM();
    }

    @ModelAttribute("pessoaform")
    public PessoaFORM loadPessoa() {
        return new PessoaFORM();
    }

}