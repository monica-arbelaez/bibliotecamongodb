package com.example.bibliotecamongodb.repository;

import com.example.bibliotecamongodb.model.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioRecursoBiblioteca extends MongoRepository<Recurso, String>{
    @Transactional(readOnly = true)
    Optional<List<Recurso>> BuscarPorArea(String areaTematicaId);
}
