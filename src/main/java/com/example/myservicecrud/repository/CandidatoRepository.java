package com.example.myservicecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myservicecrud.entity.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

}
