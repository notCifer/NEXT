package com.app.repositories;

import com.app.models.Pessoa;
import com.app.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByConta(Usuario conta);
}