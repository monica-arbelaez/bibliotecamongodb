package com.example.bibliotecamongodb.DTOs;

import java.time.LocalDate;
import java.util.Date;

public class RespuestaDTO {
    private String respuesta;
    private Boolean disponible;
    private LocalDate fechaPrestamo;

    public RespuestaDTO() {
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
