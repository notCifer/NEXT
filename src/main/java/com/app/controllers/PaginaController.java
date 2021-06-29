package com.app.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.validation.Valid;
import com.app.models.Historico;
import com.app.models.Linha;
import com.app.models.Parada;
import com.app.models.Pessoa;
import com.app.models.Rota;
import com.app.models.Usuario;
import com.app.models.dto.HistoricoDTO;
import com.app.models.form.HistoricoFORM;
import com.app.models.form.PessoaFORM;
import com.app.models.form.RotaFORM;
import com.app.repositories.HistoricoRepository;
import com.app.repositories.LinhaRepository;
import com.app.repositories.ParadaRepository;
import com.app.repositories.PessoaRepository;
import com.app.repositories.RotaRepository;
import com.app.repositories.UsuarioRepository;
import com.app.services.ServicesTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    private LinhaRepository linhaR;

    @Autowired
    private RotaRepository rotaR;

    @RequestMapping(value = "/nextpoint", method = RequestMethod.GET)
    public ModelAndView home(Model model) throws IOException {
        HistoricoDTO DTO = new HistoricoDTO();
        loadPessoa();
        loadHistorico();
        loadLinhas();
        loadParadas();
        loadRota();
        Usuario logado = usuarioS.getLogado(usuarioR);
        if (logado != null) {
            Pessoa pessoa = pessoaR.findByConta(logado);
            if (pessoa != null) {
                byte[] bytes = pessoa.getImage();
                String imageBase64 = Base64.getEncoder().encodeToString(bytes);
                model.addAttribute("imagem", imageBase64);
                model.addAttribute("pessoaform", pessoa);
            }

            List<Rota> rotas = rotaR.findAllRota(logado.getId());
            model.addAttribute("rotas", rotas);
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

        Resource resource = new ClassPathResource("userimage.gif");
        File fi = resource.getFile();
        byte[] imagebyte = Files.readAllBytes(fi.toPath());

        Usuario logado = usuarioS.getLogado(usuarioR);
        Pessoa pessoa = pessoaR.findByConta(logado);
        if (pessoa != null) {
            pessoa.setNome(FORM.getNome());
            pessoa.setSobrenome(FORM.getSobrenome());
            pessoa.setCpf(FORM.getCpf());
            if (!myfile.isEmpty()) {
                pessoa.setImage(myfile.getBytes());
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate convertDate = LocalDate.parse(FORM.getDtNasc(), formatter);
            pessoa.setDtNasc(convertDate);
            pessoaR.save(pessoa);
            return "redirect:/nextpoint#Perfil";
        } else {
            if (myfile.isEmpty()) {
                if (errors.hasErrors()) {
                    return "redirect:/nextpoint?pessoaerror#Perfil";
                }

                FORM.toFORM(pessoaR, logado, imagebyte);
                return "redirect:/nextpoint#Perfil";
            } else {
                byte[] image = myfile.getBytes();
                if (errors.hasErrors()) {
                    return "redirect:/nextpoint?pessoaerror#Perfil";
                }
                FORM.toFORM(pessoaR, logado, image);
                return "redirect:/nextpoint#Perfil";
            }

        }

    }

    @RequestMapping(value = "/Rota", method = RequestMethod.POST)
    public String addRota(@ModelAttribute RotaFORM FORM, Errors errors) throws InterruptedException {
        Usuario logado = usuarioS.getLogado(usuarioR);
        if (errors.hasErrors()) {
            return "redirect:/nextpoint?rotaerror#CriarRota";
        }
        FORM.toFORM(rotaR, logado);
        TimeUnit.SECONDS.sleep(2);
        return "redirect:/nextpoint#CriarRota";
    }

    @GetMapping("/Rota/Delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) throws InterruptedException {
        rotaR.deleteById(id);
        return "redirect:/nextpoint#MinhasRotas";
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

    @ModelAttribute("rotaform")
    public RotaFORM loadRota() {
        return new RotaFORM();
    }

    @ModelAttribute("linhas")
    public List<Linha> loadLinhas() {
        List<Linha> linhas = linhaR.findAll();
        return linhas;
    }

    @ModelAttribute("paradas")
    public List<Parada> loadParadas() {
        List<Parada> paradas = paradaR.findAll();
        return paradas;
    }

    @ModelAttribute("imagem")
    public String loadImage() throws IOException {
        Resource resource = new ClassPathResource("userimage.gif");
        File fi = resource.getFile();
        byte[] bytes = Files.readAllBytes(fi.toPath());
        String imageBase64 = Base64.getEncoder().encodeToString(bytes);
        return imageBase64;
    }

}