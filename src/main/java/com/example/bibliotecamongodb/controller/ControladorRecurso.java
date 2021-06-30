package com.example.bibliotecamongodb.controller;

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
//    @PutMapping("/develver/{id}")
//    public  ResponseEntity<String>devolverRecursoBiblioteca(@PathVariable String id){
//        var respuesta = servicioRecursoBiblioteca.devolverRecursoBiblioteca(id);
//        if (respuesta != null){
//            return new ResponseEntity(respuesta,HttpStatus.OK);
//        }
//        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//    }


}
