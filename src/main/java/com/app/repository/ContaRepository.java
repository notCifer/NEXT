package com.app.repository;

import java.util.Optional;

import com.app.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findByusuario(String usuario);
}