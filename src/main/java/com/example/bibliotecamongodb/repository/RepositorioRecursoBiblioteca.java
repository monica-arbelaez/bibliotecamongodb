package com.example.bibliotecamongodb.repository;

import com.example.bibliotecamongodb.model.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRecursoBiblioteca extends MongoRepository<Recurso, String>{
}
