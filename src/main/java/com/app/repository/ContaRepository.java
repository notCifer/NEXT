package com.app.repository;

import com.app.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaRepository extends JpaRepository<Conta, String> {

    @Query("FROM Conta WHERE usuario = ?1")
    Conta findByUsuario(String usuario);

}