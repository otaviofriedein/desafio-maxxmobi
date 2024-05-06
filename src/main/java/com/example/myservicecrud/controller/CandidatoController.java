package com.example.myservicecrud.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.myservicecrud.entity.Candidato;
import com.example.myservicecrud.service.ICandidatoService;

@RestController
@RequestMapping("/candidato")
public class CandidatoController  {

        @Autowired
        private ICandidatoService candidatoService;

        @PostMapping("")
        public ResponseEntity<Candidato> create(@RequestBody Candidato candidato){
            Candidato candidato_created = candidatoService.create(candidato);

            return ResponseEntity.status(HttpStatus.CREATED).body(candidato_created);
        }

        @GetMapping
        public Iterable<Candidato> getAll(
            @RequestParam(required = false) String nome, 
            @RequestParam(required = false) Date nascimento,
            @RequestParam(required = false) String sexo,
            @RequestParam(required = false) Integer nota,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String order
        ){
            return candidatoService.getAll(nome, nascimento, sexo, nota, sortBy, order);
        }

        @GetMapping("/{id}")
        public Candidato get(@PathVariable Integer id){
            return candidatoService.get(id);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Candidato> put(@PathVariable Integer id, @RequestBody Candidato candidato){   
          
            Candidato candidato_updated =  candidatoService.update(id, candidato);

            return ResponseEntity.status(HttpStatus.OK).body(candidato_updated);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
            candidatoService.delete(id); 
            
            return ResponseEntity.ok().build();
        }

        @PatchMapping("/{id}")
        public ResponseEntity<Candidato> patch(@PathVariable Integer id, @RequestBody Candidato candidato){
            Candidato candidato_updated = candidatoService.patch(id, candidato);

            return ResponseEntity.status(HttpStatus.OK).body(candidato_updated);
        }

}
