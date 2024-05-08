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
    
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false) 
    private Date nascimento;    

    @Column(nullable = false, length = 1)
    private String sexo = "M";

    @Column(nullable = false) 
    private Integer nota;

    @Column(nullable = true, length = 200)
    private String logradouro;

    @Column(nullable = true, length = 50)
    private String bairro;

    @Column(nullable = true, length = 50)
    private String cidade;

    @Column(nullable = true, length = 2)
    private String uf;

    @CreationTimestamp(source = SourceType.DB)
    private Instant data_criacao;
}
