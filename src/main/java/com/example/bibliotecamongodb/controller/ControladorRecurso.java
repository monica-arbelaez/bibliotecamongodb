package com.example.bibliotecamongodb.controller;

import com.example.bibliotecamongodb.DTOs.ListaAreaDTO;
import com.example.bibliotecamongodb.DTOs.ListarRecursosAreasDTO;
import com.example.bibliotecamongodb.DTOs.RespuestaDTO;
import com.example.bibliotecamongodb.services.ServicioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recurso")
public class ControladorRecurso {
    @Autowired
    private ServicioRecursoBiblioteca servicioRecursoBiblioteca;

    @PutMapping("/prestar/{id}")
    public ResponseEntity<RespuestaDTO> prestarRecursoBiblioteca(@PathVariable("id") String id){
        var respuesta = servicioRecursoBiblioteca.prestarRecursoBiblioteca(id);
        if(respuesta != null){
            return new ResponseEntity(respuesta, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/develver/{id}")
    public  ResponseEntity<String>devolverRecursoBiblioteca(@PathVariable String id){
        var respuesta = servicioRecursoBiblioteca.devolverRecursoBiblioteca(id);
        if (respuesta != null){
            return new ResponseEntity(respuesta,HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
    @GetMapping("/listar/{id}")
    public  ResponseEntity<ListarRecursosAreasDTO> listarRecursosArea(@PathVariable("id") String id){
        var respuesta = servicioRecursoBiblioteca.recomendar(id);
        if(respuesta != null){
            return  new ResponseEntity(respuesta, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
    @GetMapping("/listarDisponibilidad/{id}")
    public ResponseEntity<ListaAreaDTO> listarDisponibilidad(@PathVariable("id") boolean condicion){
        var respuesta = servicioRecursoBiblioteca.recomendarPorCondicion(condicion);
        if(respuesta.getRecursosArea().size()==0){
           return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }


}
