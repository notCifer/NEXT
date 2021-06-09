package com.app.repositories;

import com.app.models.Regra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegraRepository extends JpaRepository<Regra,Long>{
    Regra findByName(String name);
}