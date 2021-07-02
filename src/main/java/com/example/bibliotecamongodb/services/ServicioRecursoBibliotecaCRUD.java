package com.example.bibliotecamongodb.services;
import com.example.bibliotecamongodb.DTOs.AreaTematicaDTO;
import com.example.bibliotecamongodb.DTOs.RecursoBibliotecaDTO;
import com.example.bibliotecamongodb.mapper.AreaTematicaMapper;
import com.example.bibliotecamongodb.mapper.RecursoBibliotecaMapper;
import com.example.bibliotecamongodb.model.Area;
import com.example.bibliotecamongodb.model.Recurso;
import com.example.bibliotecamongodb.repository.RepositorioAreaTematica;
import com.example.bibliotecamongodb.repository.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioRecursoBibliotecaCRUD {

    @Autowired
    private RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;

    @Autowired
    private RepositorioAreaTematica repositorioAreaTematica;


    private RecursoBibliotecaMapper recursoMapper = new RecursoBibliotecaMapper();
    private AreaTematicaMapper areaMapper = new AreaTematicaMapper();

    public AreaTematicaDTO crearAreaTematica(AreaTematicaDTO dto){
        Area area1 = areaMapper.fromDTO(dto);
        return areaMapper.fromCollection(repositorioAreaTematica.save(area1));

    }
    public RecursoBibliotecaDTO crearRecursoBiblioteca(RecursoBibliotecaDTO dto){
        Recurso recurso1 = recursoMapper.fromDTO(dto);
        return recursoMapper.fromCollection(repositorioRecursoBiblioteca.save(recurso1));
    }

    public RecursoBibliotecaDTO modificarRecursoBiblioteca(RecursoBibliotecaDTO dto){
        if(dto.getTipoRecursoBiblioteca()== null){
            throw new RuntimeException("El tipo del recurso no puede ser nulo");
        }
        Recurso recurso = repositorioRecursoBiblioteca.save(recursoMapper.fromDTO(dto));
        return recursoMapper.fromCollection(recurso);
    }
    public List<RecursoBibliotecaDTO> obtenerRecursosBiblioteca(){
        List<Recurso> recursos = (List<Recurso>) repositorioRecursoBiblioteca.findAll();
        return recursoMapper.fromCollectionList(recursos);
    }
    public List<AreaTematicaDTO>obtenerAreaTematica(){
        List<Area> areas = (List<Area>) repositorioAreaTematica.findAll();
        return areaMapper.fromCollectionList(areas);
    }

    public String concultarRecursoBiblioteca( String id){
        var recursoBiblioteca = repositorioRecursoBiblioteca.findById(id);
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
