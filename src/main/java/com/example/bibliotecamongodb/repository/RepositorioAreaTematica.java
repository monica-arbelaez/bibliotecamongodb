package com.example.bibliotecamongodb.repository;

import com.example.bibliotecamongodb.model.AreaTematica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioAreaTematica extends MongoRepository<AreaTematica,String> {
}
