package com.example.bibliotecamongodb.repository;

import com.example.bibliotecamongodb.DTOs.RecursoBibliotecaDTO;
import com.example.bibliotecamongodb.model.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RepositorioRecursoBiblioteca extends MongoRepository<Recurso, String>{

    List<Recurso> findRecursoByidArea(String idArea);
    List<Recurso> findRecursoBydisponible(boolean condicion);
//    List<Recurso> findRecursoBytipoRecursoBiblioteca(String tipoRecursoBiblioteca);
}
