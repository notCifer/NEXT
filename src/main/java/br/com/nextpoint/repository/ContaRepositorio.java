package br.com.nextpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nextpoint.jpa.model.Conta;

public interface ContaRepositorio extends JpaRepository<Conta, Long> {

}