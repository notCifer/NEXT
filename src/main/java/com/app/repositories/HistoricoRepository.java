package com.app.repositories;

import java.util.List;

import com.app.models.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    @Query(value = "SELECT * FROM historico WHERE usuario_id = ?1", 
    nativeQuery = true)
    List<Historico> findAllList(Long id);
}