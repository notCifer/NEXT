package com.app.repository;

import com.app.model.Conta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Conta findByUSUARIO(String usuario);
}