package com.example.myservicecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myservicecrud.entity.Candidato;
import com.example.myservicecrud.service.ICandidatoService;

@RestController
@RequestMapping("/candidato")
public class CandidatoController  {

        @Autowired
        private ICandidatoService candidatoService;

        @PostMapping("")
        public String create(@RequestBody Candidato candidato){
            candidatoService.create(candidato);

            return "Candidato criado com sucesso!";
        }
}
