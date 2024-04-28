package com.example.myservicecrud.service.implementations;

import java.beans.PropertyDescriptor;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.myservicecrud.entity.Candidato;
import com.example.myservicecrud.repository.CandidatoRepository;
import com.example.myservicecrud.service.ICandidatoService;

@Service
public class CandidatoService implements ICandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;
    
    @Override
    public Candidato create(Candidato candidato) {
        return candidatoRepository.save(candidato);        
    }
    
    @Override
    public List<Candidato> getAll(
        String nome, 
        Date nascimento,
            String sexo,
            Integer nota,
            String sortById,
            String sortByName) {       
                
            Specification<Candidato> spec = Specification.where(null);    
            Sort sort = Sort.unsorted();
                
            if (nome != null) {
                spec = spec.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%"));
            }
    
            if (nascimento != null) {
                spec = spec.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("nascimento"), nascimento));
            }
    
            if (sexo != null) {
                spec = spec.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("sexo"), sexo));
            }
    
            if (nota != null) {
                spec = spec.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("nota"), nota));
            }
            
            if (sortById != null) {
                sort = sort.and(Sort.by(sortById.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, "id"));
            }

            if (sortByName != null) {
                sort = sort.and(Sort.by(sortByName.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, "nome"));
            }
           
            return candidatoRepository.findAll(spec, sort);
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
