package com.app.repository;

import java.util.List;

import com.app.model.Conta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, String> {

    List<Conta> findByNome(String nome);

}