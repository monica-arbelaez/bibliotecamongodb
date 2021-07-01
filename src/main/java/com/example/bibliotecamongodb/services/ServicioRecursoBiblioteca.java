package com.example.bibliotecamongodb.services;

import com.example.bibliotecamongodb.DTOs.*;
import com.example.bibliotecamongodb.mapper.RecursoBibliotecaMapper;
import com.example.bibliotecamongodb.model.Recurso;
import com.example.bibliotecamongodb.repository.RepositorioAreaTematica;
import com.example.bibliotecamongodb.repository.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ServicioRecursoBiblioteca {

    @Autowired
    private RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;

    @Autowired
    private RepositorioAreaTematica repositorioAreaTematica;

    private RecursoBibliotecaMapper mapper = new RecursoBibliotecaMapper();

    private Date objDate = new Date();
    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

    private RespuestaDTO disponibilidadRecurso(String id){
        RespuestaDTO respuestaRecurso = new RespuestaDTO();
        var recursoBiblioteca =repositorioRecursoBiblioteca.findById(id);
        if(recursoBiblioteca.get().getDisponible()){
            respuestaRecurso.setRespuesta("el recurso "+ mapper.fromCollection(recursoBiblioteca.get()).getNombreRecurso()+"esta disponible para prestamo");
            respuestaRecurso.setDisponible(true);
            respuestaRecurso.setFechaPrestamo(null);
            return  respuestaRecurso;
        }
        respuestaRecurso.setRespuesta("el recurso no esta disponible. La ultima gfecha de prestamo es: ".toString());
        respuestaRecurso.setDisponible(false);
        respuestaRecurso.setFechaPrestamo(mapper.fromCollection(recursoBiblioteca.get()).getFechaPrestamoRecurso());
        return respuestaRecurso;
    }


    public RespuestaDTO prestarRecursoBiblioteca(String id){

        RespuestaDTO respuestaDTO = new RespuestaDTO();
        Recurso recursoBiblioteca = repositorioRecursoBiblioteca.findById(id).orElseThrow(()->new RuntimeException("Recurso no encontado"));
        if (recursoBiblioteca.getDisponible()){
            recursoBiblioteca.setDisponible(false);
            recursoBiblioteca.setFechaPrestamo(objSDF.format(objDate));
            repositorioRecursoBiblioteca.save(recursoBiblioteca);
            respuestaDTO.setRespuesta("El recurso te fue prestado");
            respuestaDTO.setDisponible(false);
            respuestaDTO.setFechaPrestamo(objSDF.format(objDate));
            return respuestaDTO;
        }
        respuestaDTO.setRespuesta("El recurso se encuentra presatdo en el momento");
        respuestaDTO.setDisponible(false);
        respuestaDTO.setFechaPrestamo(objSDF.format(objDate));
        return respuestaDTO;
    }

    public RespuestaDTO devolverRecursoBiblioteca(String id){

        RespuestaDTO respuestaDTO =new RespuestaDTO();
        var recursoBiblioteca = repositorioRecursoBiblioteca.findById(id);
        if (!recursoBiblioteca.get().getDisponible()){
            recursoBiblioteca.get().setDisponible(true);
            recursoBiblioteca.get().setFechaPrestamo(objSDF.format(objDate));
            repositorioRecursoBiblioteca.save(recursoBiblioteca.get());
            respuestaDTO.setFechaPrestamo(objSDF.format(objDate));
            respuestaDTO.setDisponible(true);
            respuestaDTO.setRespuesta("El recurso fue devuelto");
            return respuestaDTO;
        }

        respuestaDTO.setFechaPrestamo(objSDF.format(objDate));
        respuestaDTO.setDisponible(false);
        respuestaDTO.setRespuesta("El recurso se encuentra en la lista de inventario");
        return respuestaDTO;
    }
    public ListarRecursosAreasDTO recomendar(String idArea){
       ListarRecursosAreasDTO recursosArea = new ListarRecursosAreasDTO();
       var areaTematica = repositorioAreaTematica.findById(idArea).orElseThrow(()-> new RuntimeException("No se encontro el area"));
       var list = repositorioRecursoBiblioteca.findRecursoByidArea(idArea);
       recursosArea.setTipoArea(areaTematica.getCategoriaArea());
       recursosArea.setRecursos(mapper.fromCollectionList(list));
       return recursosArea;

    }
    public ListaAreaDTO recomendarPorCondicion(boolean condicion){
        ListaAreaDTO listaAreaDTO = new ListaAreaDTO();
        var list = repositorioRecursoBiblioteca.findRecursoBydisponible(condicion);
        String estado = condicion ? "Disponibles" : "No disponibles";
        listaAreaDTO.setRecursosArea(mapper.fromCollectionList(list));
        listaAreaDTO.setAreaTematica(estado);
        return listaAreaDTO;

    }

//    public RespuestaDTO recomendarTipoRecurso(String tipoRecursoBiblioteca){
//
//        RespuestaDTO respuestaDTO = new RespuestaDTO();
//        var list =repositorioRecursoBiblioteca.findRecursoBytipoRecursoBiblioteca(tipoRecursoBiblioteca);
//
//    }

}
