package com.example.myservicecrud.service;

import com.example.myservicecrud.entity.Candidato;

public interface ICandidatoService {

    Candidato create(Candidato candidato);

    Iterable<Candidato> getAll(
            String nome,
            String nascimento,
            String sexo,
            Integer nota,
            String sortBy,
            String order);

    Candidato get(Integer id);

    Candidato update(Integer id, Candidato candidato);

    void delete(Integer id);

    Candidato patch(Integer id, Candidato candidatoDTO);
}
