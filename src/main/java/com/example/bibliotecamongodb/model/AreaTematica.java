package com.example.bibliotecamongodb.model;

import org.springframework.data.annotation.Id;

public class AreaTematica {
    @Id
    private String idArea;
    private String categoriaArea;

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getCategoriaArea() {
        return categoriaArea;
    }

    public void setCategoriaArea(String categoriaArea) {
        this.categoriaArea = categoriaArea;
    }
}
