package com.example.bibliotecamongodb.services;

import com.example.bibliotecamongodb.DTOs.AreaTematicaDTO;
import com.example.bibliotecamongodb.DTOs.RecursoBibliotecaDTO;
import com.example.bibliotecamongodb.mapper.AreaTematicaMapper;
import com.example.bibliotecamongodb.mapper.RecursoBibliotecaMapper;
import com.example.bibliotecamongodb.model.AreaTematica;
import com.example.bibliotecamongodb.model.RecursoBiblioteca;
import com.example.bibliotecamongodb.repository.RepositorioAreaTematica;
import com.example.bibliotecamongodb.repository.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioRecursoBibliotecaCRUD {

    @Autowired
    private RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;

    @Autowired
    private RepositorioAreaTematica repositorioAreaTematica;


    private RecursoBibliotecaMapper recursoMapper = new RecursoBibliotecaMapper();
    private AreaTematicaMapper areaMapper = new AreaTematicaMapper();

    private AreaTematicaDTO crearAreaTematica(AreaTematicaDTO dto){
        AreaTematica areaTematica1 = areaMapper.fromDTO(dto);
        return areaMapper.fromCollection(repositorioAreaTematica.save(areaTematica1));

    }
    private RecursoBibliotecaDTO crearRecursoBiblioteca(RecursoBibliotecaDTO dto){
        RecursoBiblioteca recursoBiblioteca1 = recursoMapper.fromDTO(dto);
        return recursoMapper.fromCollection(repositorioRecursoBiblioteca.save(recursoBiblioteca1));
    }

    public RecursoBibliotecaDTO modificarRecursoBiblioteca(RecursoBibliotecaDTO dto){
        if(dto.getTipoRecursoBiblioteca()== null){
            throw new RuntimeException("El tipo del recurso no puede ser nulo");
        }
        RecursoBiblioteca recursoBiblioteca = repositorioRecursoBiblioteca.save(recursoMapper.fromDTO(dto));
        return recursoMapper.fromCollection(recursoBiblioteca);
    }
    public List<RecursoBibliotecaDTO> ObtenerRecursosBiblioteca(){
        List<RecursoBiblioteca> recursoBibliotecas = (List<RecursoBiblioteca>) repositorioRecursoBiblioteca.findAll();
        return recursoMapper.fromCollectionList(recursoBibliotecas);
    }

    public String concultarRecusoBiblioteca( String id){
        Optional<RecursoBiblioteca> recursoBiblioteca = repositorioRecursoBiblioteca.findById(id);
        if(recursoBiblioteca.get().getDisponible()){
            return "El recurso esta disponible para prestamo";
        }
        return "el recurso fue prestado. Fecha de prestamo: " + recursoBiblioteca.get().getFechaPrestamo();
    }

    public void borrarRecursoBiblioteca(String id){
        if(id == null){
            throw new RuntimeException("Debe de tener un Id para borrar");
        }
        repositorioRecursoBiblioteca.deleteById(id);
    }
}
