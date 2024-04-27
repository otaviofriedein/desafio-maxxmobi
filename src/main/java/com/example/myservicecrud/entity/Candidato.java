package com.example.myservicecrud.entity;

import java.sql.Date;
import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidato")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 100)
    private String nome;

    private Date nascimento;

    @CreationTimestamp(source = SourceType.DB)
    private Instant data_criacao;

    @Column(length = 1)
    private String sexo = "M";

    private Integer nota;

    @Column(length = 200, nullable = true)
    private String logradouro;

    @Column(length = 50, nullable = true)
    private String bairro;

    @Column(length = 50, nullable = true)
    private String cidade;

    @Column(length = 2, nullable = true)
    private String uf;

}
