package com.example.bibliotecamongodb.mapper;

import com.example.bibliotecamongodb.DTOs.RecursoBibliotecaDTO;
import com.example.bibliotecamongodb.model.Recurso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecursoBibliotecaMapper {

    public Recurso fromDTO(RecursoBibliotecaDTO dto){
        Recurso recurso = new Recurso();
        recurso.setId(dto.getIdRecurso());
        recurso.setTipoRecurso(dto.getTipoRecursoBiblioteca());
        recurso.setDisponible(dto.getRecursoDisponible());
        recurso.setFechaPrestamo(dto.getFechaPrestamoRecurso());
        recurso.setNombre(dto.getNombreRecurso());
        recurso.setIdArea(dto.getIdAreaTematica());
        return recurso;
    }

    public RecursoBibliotecaDTO fromCollection(Recurso recurso){
        RecursoBibliotecaDTO recursoBibliotecaDTO = new RecursoBibliotecaDTO();
        recursoBibliotecaDTO.setIdRecurso(recurso.getId());
        recursoBibliotecaDTO.setTipoRecursoBiblioteca(recurso.getTipoRecurso());
        recursoBibliotecaDTO.setRecursoDisponible(recurso.getDisponible());
        recursoBibliotecaDTO.setFechaPrestamoRecurso(recurso.getFechaPrestamo());
        recursoBibliotecaDTO.setNombreRecurso(recurso.getNombre());
        recursoBibliotecaDTO.setIdAreaTematica(recurso.getIdArea());
        return  recursoBibliotecaDTO;

    }

    public List<RecursoBibliotecaDTO> fromCollectionList(List<Recurso> collection){
        if(collection == null) {
            return null;
        }
        List<RecursoBibliotecaDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Recurso recurso = (Recurso) listTracks.next();
            list.add(fromCollection(recurso));
        }
        return list;
    }

}

