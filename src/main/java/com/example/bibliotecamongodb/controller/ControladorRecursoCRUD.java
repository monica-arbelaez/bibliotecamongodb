package com.example.bibliotecamongodb.controller;


import com.example.bibliotecamongodb.DTOs.AreaTematicaDTO;
import com.example.bibliotecamongodb.DTOs.RecursoBibliotecaDTO;
import com.example.bibliotecamongodb.services.ServicioRecursoBibliotecaCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recurso")
public class ControladorRecursoCRUD {

    @Autowired
    private ServicioRecursoBibliotecaCRUD servicioRecursoBibliotecaCRUD;

    @PostMapping("/crearRecurso")
    public ResponseEntity<RecursoBibliotecaDTO> crear (@RequestBody RecursoBibliotecaDTO recursoBibliotecaDTO){

        return new ResponseEntity(servicioRecursoBibliotecaCRUD.crearRecursoBiblioteca(recursoBibliotecaDTO),HttpStatus.CREATED);
    }


    @GetMapping("/concultarRecurso/{id}")
    public ResponseEntity<String> concultarRecusoBiblioteca(@PathVariable("id") String id){
        var respuesta = servicioRecursoBibliotecaCRUD.concultarRecursoBiblioteca(id);
        if(respuesta != null){
            return new ResponseEntity(respuesta, HttpStatus.OK);
        }
        return new ResponseEntity(respuesta, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/consultarTodos")
    public ResponseEntity<List<RecursoBibliotecaDTO>> obtenerRecursosBiblioteca(){
        return new ResponseEntity(servicioRecursoBibliotecaCRUD.obtenerRecursosBiblioteca(), HttpStatus.OK);
    }
    @PutMapping("/modificarBiblioteca")
    public ResponseEntity<RecursoBibliotecaDTO> modificarRecursoBiblioteca(@RequestBody RecursoBibliotecaDTO recursoBibliotecaDTO){
        if(recursoBibliotecaDTO.getIdRecurso() != null){
            return new ResponseEntity(servicioRecursoBibliotecaCRUD.modificarRecursoBiblioteca(recursoBibliotecaDTO),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/borrarRecurso")
    public ResponseEntity borrarRecursoBiblioteca(@PathVariable("id") String id){
        try {
            servicioRecursoBibliotecaCRUD.borrarRecursoBiblioteca(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/crearArea")
    public  ResponseEntity<AreaTematicaDTO> crearAreaTematica(@RequestBody AreaTematicaDTO areaTematicaDTO){
        return new ResponseEntity(servicioRecursoBibliotecaCRUD.crearAreaTematica(areaTematicaDTO),HttpStatus.CREATED);
    }
    @GetMapping("/listar")
    public  ResponseEntity<List<RecursoBibliotecaDTO>> obtenerTodos(){
        return new ResponseEntity(servicioRecursoBibliotecaCRUD.obtenerRecursosBiblioteca(),HttpStatus.OK);
    }
    @GetMapping("/listarAreas")
    public ResponseEntity<List<AreaTematicaDTO>> obtenerAreas(){
        return new ResponseEntity(servicioRecursoBibliotecaCRUD.obtenerAreaTematica(),HttpStatus.OK);

    }

}
