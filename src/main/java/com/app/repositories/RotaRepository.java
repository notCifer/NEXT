package com.app.repositories;

import java.util.List;
import com.app.models.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {

    @Query(value = "SELECT * FROM ROTA WHERE conta_id = ?1", 
    nativeQuery = true)
    List<Rota> findAllRota(Long id);
}