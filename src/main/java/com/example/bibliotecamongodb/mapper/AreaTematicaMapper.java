package com.example.bibliotecamongodb.mapper;

import com.example.bibliotecamongodb.DTOs.AreaTematicaDTO;
import com.example.bibliotecamongodb.model.Area;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AreaTematicaMapper {

    public Area fromDTO(AreaTematicaDTO dto){
        Area area = new Area();
        area.setIdArea(dto.getIdAreaTematica());
        area.setCategoriaArea(dto.getCategoriaAreaTematica());

        return area;
    }
    public AreaTematicaDTO fromCollection(Area area){
        AreaTematicaDTO areaTematicaDTO = new AreaTematicaDTO();
        areaTematicaDTO.setIdAreaTematica(area.getIdArea());
        areaTematicaDTO.setCategoriaAreaTematica(area.getCategoriaArea());

        return areaTematicaDTO;
    }
    public List<AreaTematicaDTO> fromCollectionList(List<Area> collection){
        if(collection == null){
            return null;
        }
        List<AreaTematicaDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Area area =(Area) listTracks.next();
            list.add(fromCollection(area));
        }
        return list;
    }
}
