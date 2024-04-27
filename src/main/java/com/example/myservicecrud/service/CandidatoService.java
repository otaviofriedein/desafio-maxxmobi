package com.example.myservicecrud.service;

import java.beans.PropertyDescriptor;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.myservicecrud.entity.Candidato;
import com.example.myservicecrud.repository.CandidatoRepository;

@Service
public class CandidatoService implements ICandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;
    
    @Override
    public Candidato create(Candidato candidato) {
        return candidatoRepository.save(candidato);        
    }

    @Override
    public Iterable<Candidato> getAll() {
        return candidatoRepository.findAll();
    }

    @Override
    public Candidato get(Integer id) {
        Candidato candidato = candidatoRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado: " + id));

        return candidato;
    }

    @Override
    public Candidato update(Integer id, Candidato candidato) {
        candidatoRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado: " + id));

       candidato.setId(id);

       return candidatoRepository.save(candidato);
    }

    @Override
    public void delete(Integer id) {
        Candidato candidato = candidatoRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado: " + id));

        candidatoRepository.delete(candidato);
    }

    @Override
    public Candidato patch(Integer id, Candidato candidato) {
        Candidato candidato_record = candidatoRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado: " + id));      
        
        BeanWrapper sourceWrapper = new BeanWrapperImpl(candidato);
        BeanWrapper targetWrapper = new BeanWrapperImpl(candidato_record);
        for (PropertyDescriptor property : sourceWrapper.getPropertyDescriptors()) {
            if (property.getWriteMethod() != null) {
                Object sourceValue = sourceWrapper.getPropertyValue(property.getName());
                if (sourceValue != null) {
                    targetWrapper.setPropertyValue(property.getName(), sourceValue);
                }
            }
        }
            
        return candidatoRepository.save(candidato_record);
    }
    
}
