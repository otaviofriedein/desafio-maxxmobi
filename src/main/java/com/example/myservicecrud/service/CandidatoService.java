package com.example.myservicecrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myservicecrud.entity.Candidato;
import com.example.myservicecrud.repository.CandidatoRepository;

@Service
public class CandidatoService implements ICandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;
    
    @Override
    public void create(Candidato candidato) {
        candidatoRepository.save(candidato);        
    }
    
}
