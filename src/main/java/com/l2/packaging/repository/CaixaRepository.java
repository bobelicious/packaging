package com.l2.packaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.l2.packaging.model.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Long> {
    
}
