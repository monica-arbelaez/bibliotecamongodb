package com.example.bibliotecamongodb.DTOs;

import java.time.LocalDate;
import java.util.Date;

public class RecursoBibliotecaDTO {
    private String idRecurso;
    private String tipoRecursoBiblioteca;
    private Boolean recursoDisponible;
    private LocalDate fechaPrestamoRecurso;
    private String nombreRecurso;
    private String idAreaTematica;

    public RecursoBibliotecaDTO() {
    }

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTipoRecursoBiblioteca() {
        return tipoRecursoBiblioteca;
    }

    public void setTipoRecursoBiblioteca(String tipoRecursoBiblioteca) {
        this.tipoRecursoBiblioteca = tipoRecursoBiblioteca;
    }

    public Boolean getRecursoDisponible() {
        return recursoDisponible;
    }

    public void setRecursoDisponible(Boolean recursoDisponible) {
        this.recursoDisponible = recursoDisponible;
    }

    public LocalDate getFechaPrestamoRecurso() {
        return fechaPrestamoRecurso;
    }

    public void setFechaPrestamoRecurso(LocalDate fechaPrestamoRecurso) {
        this.fechaPrestamoRecurso = fechaPrestamoRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getIdAreaTematica() {
        return idAreaTematica;
    }

    public void setIdAreaTematica(String idAreaTematica) {
        this.idAreaTematica = idAreaTematica;
    }
}
