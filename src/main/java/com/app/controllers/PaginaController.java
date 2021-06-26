package com.app.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.validation.Valid;
import com.app.models.Historico;
import com.app.models.Linha;
import com.app.models.Onibus;
import com.app.models.Parada;
import com.app.models.Pessoa;
import com.app.models.Usuario;
import com.app.models.dto.HistoricoDTO;
import com.app.models.form.HistoricoFORM;
import com.app.models.form.PessoaFORM;
import com.app.repositories.HistoricoRepository;
import com.app.repositories.LinhaRepository;
import com.app.repositories.OnibusRepository;
import com.app.repositories.ParadaRepository;
import com.app.repositories.PessoaRepository;
import com.app.repositories.UsuarioRepository;
import com.app.services.ServicesTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    private ServicesTools usuarioS;

    @Autowired
    private ParadaRepository paradaR;

    @Autowired
    private OnibusRepository onibusR;

    @Autowired
    private LinhaRepository linhaR;

    @RequestMapping(value = "/nextpoint", method = RequestMethod.GET)
    public ModelAndView home(Model model) throws IOException {
        HistoricoDTO DTO = new HistoricoDTO();
        loadPessoa();
        loadHistorico();
        loadLinhas();
        loadParadas();

        Usuario logado = usuarioS.getLogado(usuarioR);
        if (logado != null) {
            Pessoa pessoa = pessoaR.findByConta(logado);
            if (pessoa != null) {
                byte[] bytes = pessoa.getImage();
                String imageBase64 = Base64.getEncoder().encodeToString(bytes);
                model.addAttribute("imagem", imageBase64);
                model.addAttribute("pessoaform", pessoa);
            }
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

    @RequestMapping(value = "/Perfil", method = RequestMethod.POST)
    public String AddPessoa(@ModelAttribute PessoaFORM FORM, @RequestParam("myfile") MultipartFile myfile,
            Errors errors) throws IOException {
        byte[] imagebyte = myfile.getBytes();
        Usuario logado = usuarioS.getLogado(usuarioR);
        if (errors.hasErrors()) {
            return "redirect:/nextpoint?pessoaerror#Perfil";
        }
        FORM.toFORM(pessoaR, logado, imagebyte);
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

    @ModelAttribute("linhas")
    public List<Linha> loadLinhas() {
        List<Linha> linhas = linhaR.findAll();
        return linhas;
    }

    @ModelAttribute("paradas")
    public List<Parada> loadParadas(){
        List<Parada> paradas = paradaR.findAll();
        return paradas;
    }

    @ModelAttribute("imagem")
    public String loadImage() throws IOException {
        File fi = new File(
                "C:/Users/Allan/Desktop/WORKSPACE/NextPoint/src/main/resources/static/css/img/userimage.gif");
        byte[] bytes = Files.readAllBytes(fi.toPath());
        String imageBase64 = Base64.getEncoder().encodeToString(bytes);
        return imageBase64;
    }

}