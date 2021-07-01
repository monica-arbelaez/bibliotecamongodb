package com.example.bibliotecamongodb.DTOs;

import java.util.List;

public class ListaAreaDTO {

    private String AreaTematica;
    private List<RecursoBibliotecaDTO> recursosArea;

    public String getAreaTematica() {
        return AreaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        AreaTematica = areaTematica;
    }

    public List<RecursoBibliotecaDTO> getRecursosArea() {
        return recursosArea;
    }

    public void setRecursosArea(List<RecursoBibliotecaDTO> recursosArea) {
        this.recursosArea = recursosArea;
    }

}
