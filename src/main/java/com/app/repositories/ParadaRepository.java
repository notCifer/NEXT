package com.app.repositories;

import com.app.models.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParadaRepository  extends JpaRepository<Parada,Long>{
    
}