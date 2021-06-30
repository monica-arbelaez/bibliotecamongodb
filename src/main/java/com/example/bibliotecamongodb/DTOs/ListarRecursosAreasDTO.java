package com.example.bibliotecamongodb.DTOs;

import com.example.bibliotecamongodb.model.Recurso;

import java.util.List;

public class ListarRecursosAreasDTO {
    private String TipoArea;
    private List<RecursoBibliotecaDTO> recursos;

    public ListarRecursosAreasDTO() {
    }

    public String getTipoArea() {
        return TipoArea;
    }

    public void setTipoArea(String tipoArea) {
        TipoArea = tipoArea;
    }

    public List<RecursoBibliotecaDTO> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<RecursoBibliotecaDTO> recursos) {
        this.recursos = recursos;
    }
}
