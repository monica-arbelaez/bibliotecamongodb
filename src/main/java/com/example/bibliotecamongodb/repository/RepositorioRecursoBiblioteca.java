package com.example.bibliotecamongodb.repository;

import com.example.bibliotecamongodb.model.RecursoBiblioteca;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioRecursoBiblioteca extends MongoRepository<RecursoBiblioteca, String>{
}
