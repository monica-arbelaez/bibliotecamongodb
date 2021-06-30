package com.example.bibliotecamongodb.services;

import com.example.bibliotecamongodb.DTOs.AreaTematicaDTO;
import com.example.bibliotecamongodb.DTOs.ListarRecursosAreasDTO;
import com.example.bibliotecamongodb.DTOs.RecursoBibliotecaDTO;
import com.example.bibliotecamongodb.DTOs.RespuestaDTO;
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
//    private Date objDate = new Date();
//    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
//    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);



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
        LocalDate fecha = LocalDate.now();
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        Recurso recursoBiblioteca = repositorioRecursoBiblioteca.findById(id).orElseThrow(()->new RuntimeException("Recurso no encontado"));
        if (recursoBiblioteca.getDisponible()){
            recursoBiblioteca.setDisponible(false);
            recursoBiblioteca.setFechaPrestamo(fecha);
            repositorioRecursoBiblioteca.save(recursoBiblioteca);
            respuestaDTO.setRespuesta("El recurso te fue prestado");
            respuestaDTO.setDisponible(false);
            respuestaDTO.setFechaPrestamo(mapper.fromCollection(recursoBiblioteca).getFechaPrestamoRecurso());
            return respuestaDTO;
        }
        respuestaDTO.setRespuesta("El recurso se encuentra presatdo en el momento");
        respuestaDTO.setDisponible(false);
        respuestaDTO.setFechaPrestamo(mapper.fromCollection(recursoBiblioteca).getFechaPrestamoRecurso());
        return respuestaDTO;
    }

    public RespuestaDTO devolverRecursoBiblioteca(String id){
        LocalDate fecha = LocalDate.now();
        RespuestaDTO respuestaDTO =new RespuestaDTO();
        var recursoBiblioteca = repositorioRecursoBiblioteca.findById(id);
        if (!recursoBiblioteca.get().getDisponible()){
            recursoBiblioteca.get().setDisponible(true);
            recursoBiblioteca.get().setFechaPrestamo(fecha);
            repositorioRecursoBiblioteca.save(recursoBiblioteca.get());
            respuestaDTO.setFechaPrestamo(fecha);
            respuestaDTO.setDisponible(true);
            respuestaDTO.setRespuesta("El recurso fue devuelto");
            return respuestaDTO;
        }

        respuestaDTO.setFechaPrestamo(fecha);
        respuestaDTO.setDisponible(false);
        respuestaDTO.setRespuesta("El recurso se encuentra en la lista de inventario");
        return respuestaDTO;
    }

}
