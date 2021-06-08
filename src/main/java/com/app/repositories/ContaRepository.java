package com.app.repositories;

import java.util.Optional;

import com.app.models.Conta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Conta findByusuario(String usuario);
}