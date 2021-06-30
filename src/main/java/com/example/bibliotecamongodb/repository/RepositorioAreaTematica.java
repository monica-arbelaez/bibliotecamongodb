package com.example.bibliotecamongodb.repository;

import com.example.bibliotecamongodb.DTOs.AreaTematicaDTO;
import com.example.bibliotecamongodb.model.Area;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioAreaTematica extends MongoRepository<AreaTematicaDTO,String> {
}
