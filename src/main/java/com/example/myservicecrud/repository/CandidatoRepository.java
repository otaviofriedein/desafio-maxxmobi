package com.example.myservicecrud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.myservicecrud.entity.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer>, JpaSpecificationExecutor<Candidato> {
}
