package com.example.myservicecrud.service.implementations;

import java.beans.PropertyDescriptor;
import java.time.LocalDate;
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
            String nascimento,
            String sexo,
            Integer nota,
            String sortBy,
            String order) {

        Specification<Candidato> spec = Specification.where(null);
        Sort sort = Sort.unsorted();

        if (nome != null && nome.length() > 0) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder
                    .like(criteriaBuilder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%"));
        }

        if (nascimento != null && nascimento.length() > 0) {
            LocalDate date = LocalDate.parse(nascimento);
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nascimento"), date));
        }

        if (sexo != null && sexo.length() > 0) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("sexo"), sexo));
        }

        if (nota != null && nota != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nota"), nota));
        }

        if (sortBy != null) {
            sort = sort.and(Sort.by(order.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));
        }

        return candidatoRepository.findAll(spec, sort);
    }

    @Override
    public Candidato get(Integer id) {
        Candidato candidato = candidatoRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato nao encontrado: " + id));

        return candidato;
    }

    @Override
    public Candidato update(Integer id, Candidato candidato) {
        candidatoRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato nao encontrado: " + id));

        candidato.setId(id);

        return candidatoRepository.save(candidato);
    }

    @Override
    public void delete(Integer id) {
        Candidato candidato = candidatoRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato nao encontrado: " + id));

        candidatoRepository.delete(candidato);
    }

    @Override
    public Candidato patch(Integer id, Candidato candidato) {
        Candidato candidato_record = candidatoRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato nao encontrado: " + id));

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
