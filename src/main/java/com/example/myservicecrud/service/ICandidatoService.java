package com.example.myservicecrud.service;

import com.example.myservicecrud.dto.CandidatoDTO;
import com.example.myservicecrud.entity.Candidato;

public interface ICandidatoService {

    Candidato create(Candidato candidato);

    Iterable<Candidato> getAll();

    Candidato get(Integer id);

    Candidato update(Integer id, Candidato candidato);
    
    void delete(Integer id);

    void patch(Integer id, CandidatoDTO candidatoDTO);
}
