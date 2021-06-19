package com.app.controllers;

import java.util.List;
import javax.validation.Valid;
import com.app.models.Usuario;
import com.app.models.dto.UsuarioDTO;
import com.app.models.form.UsuarioFORM;
import com.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class Rest {

    @Autowired
    private UsuarioRepository usuarioR;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> FindAll() {
        List<Usuario> usuarios = usuarioR.findAll();
        UsuarioDTO DTO = new UsuarioDTO();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(DTO.EntidDTO(usuarios));
    }

    @PostMapping
    public Usuario Add(@RequestBody @Valid UsuarioFORM FORM) {

        Usuario usuario = FORM.toForm(usuarioR);
        return usuario;

    }

}