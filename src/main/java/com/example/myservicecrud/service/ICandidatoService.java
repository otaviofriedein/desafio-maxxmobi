package com.example.myservicecrud.service;

import com.example.myservicecrud.entity.Candidato;

public interface ICandidatoService {

    Candidato create(Candidato candidato);

    Iterable<Candidato> getAll();

    Candidato get(Integer id);

    Candidato update(Integer id, Candidato candidato);
    
    void delete(Integer id);

    Candidato patch(Integer id, Candidato candidatoDTO);
}
