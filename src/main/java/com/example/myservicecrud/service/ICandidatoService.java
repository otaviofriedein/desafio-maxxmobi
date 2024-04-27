package com.example.myservicecrud.service;

import java.sql.Date;
import com.example.myservicecrud.entity.Candidato;

public interface ICandidatoService {

    Candidato create(Candidato candidato);
    
    Iterable<Candidato> getAll( String nome, 
            Date nascimento,
            String sexo,
            Integer nota,
            String sortById,
            String sortByName);

    Candidato get(Integer id);

    Candidato update(Integer id, Candidato candidato);
    
    void delete(Integer id);

    Candidato patch(Integer id, Candidato candidatoDTO);
}
