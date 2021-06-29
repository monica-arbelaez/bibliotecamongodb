package com.example.bibliotecamongodb.mapper;

import com.example.bibliotecamongodb.DTOs.AreaTematicaDTO;
import com.example.bibliotecamongodb.model.AreaTematica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AreaTematicaMapper {

    public AreaTematica fromDTO(AreaTematicaDTO dto){
        AreaTematica areaTematica = new AreaTematica();
        areaTematica.setIdArea(dto.getIdAreaTematica());
        areaTematica.setCategoriaArea(dto.getCategoriaAreaTematica());

        return areaTematica;
    }
    public AreaTematicaDTO fromCollection(AreaTematica areaTematica){
        AreaTematicaDTO areaTematicaDTO = new AreaTematicaDTO();
        areaTematicaDTO.setIdAreaTematica(areaTematica.getIdArea());
        areaTematicaDTO.setCategoriaAreaTematica(areaTematica.getCategoriaArea());

        return areaTematicaDTO;
    }
    public List<AreaTematicaDTO> fromCollectionList(List<AreaTematica> collection){
        if(collection == null){
            return null;
        }
        List<AreaTematicaDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            AreaTematica areaTematica =(AreaTematica) listTracks.next();
            list.add(fromCollection(areaTematica));
        }
        return list;
    }
}
