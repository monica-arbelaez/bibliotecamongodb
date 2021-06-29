package com.example.bibliotecamongodb.mapper;

import com.example.bibliotecamongodb.DTOs.RecursoBibliotecaDTO;
import com.example.bibliotecamongodb.model.RecursoBiblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecursoBibliotecaMapper {

    public RecursoBiblioteca fromDTO(RecursoBibliotecaDTO dto){
        RecursoBiblioteca recursoBiblioteca = new RecursoBiblioteca();
        recursoBiblioteca.setId(dto.getIdRecurso());
        recursoBiblioteca.setTipoRecurso(dto.getTipoRecursoBiblioteca());
        recursoBiblioteca.setDisponible(dto.getRecursoDisponible());
        recursoBiblioteca.setFechaPrestamo(dto.getFechaPrestamoRecurso());
        recursoBiblioteca.setNombre(dto.getNombreRecurso());
        recursoBiblioteca.setIdArea(dto.getIdAreaTematica());
        return recursoBiblioteca;
    }

    public RecursoBibliotecaDTO fromCollection(RecursoBiblioteca recursoBiblioteca){
        RecursoBibliotecaDTO recursoBibliotecaDTO = new RecursoBibliotecaDTO();
        recursoBibliotecaDTO.setIdRecurso(recursoBiblioteca.getId());
        recursoBibliotecaDTO.setTipoRecursoBiblioteca(recursoBiblioteca.getTipoRecurso());
        recursoBibliotecaDTO.setRecursoDisponible(recursoBiblioteca.getDisponible());
        recursoBibliotecaDTO.setFechaPrestamoRecurso(recursoBiblioteca.getFechaPrestamo());
        recursoBibliotecaDTO.setNombreRecurso(recursoBiblioteca.getNombre());
        recursoBibliotecaDTO.setIdAreaTematica(recursoBiblioteca.getIdArea());
        return  recursoBibliotecaDTO;

    }

    public List<RecursoBibliotecaDTO> fromCollectionList(List<RecursoBiblioteca> collection){
        if(collection == null) {
            return null;
        }
        List<RecursoBibliotecaDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            RecursoBiblioteca recursoBiblioteca = (RecursoBiblioteca) listTracks.next();
            list.add(fromCollection(recursoBiblioteca));
        }
        return list;
    }

}

