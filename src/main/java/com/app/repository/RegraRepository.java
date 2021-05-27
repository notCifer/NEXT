package com.app.repository;

import com.app.model.Regras;
import org.springframework.data.repository.CrudRepository;

public interface RegraRepository extends CrudRepository<Regras,Long> {

    Regras findByREGRA(String regra);
    
}