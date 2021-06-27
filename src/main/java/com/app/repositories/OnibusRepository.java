package com.app.repositories;

import java.util.List;

import com.app.models.Onibus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OnibusRepository extends JpaRepository<Onibus,Long> {

    @Query(value = "SELECT * FROM ONIBUS WHERE LINHA_ID = ?1", nativeQuery = true)
    List<Onibus> findAllOnibusByLinha(Long id);
    
}