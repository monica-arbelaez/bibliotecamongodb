package com.example.bibliotecamongodb.DTOs;

public class AreaTematicaDTO {

    private String idAreaTematica;
    private String categoriaAreaTematica;

    public AreaTematicaDTO() {
    }

    public String getIdAreaTematica() {
        return idAreaTematica;
    }

    public void setIdAreaTematica(String idAreaTematica) {
        this.idAreaTematica = idAreaTematica;
    }

    public String getCategoriaAreaTematica() {
        return categoriaAreaTematica;
    }

    public void setCategoriaAreaTematica(String categoriaAreaTematica) {
        this.categoriaAreaTematica = categoriaAreaTematica;
    }
}
