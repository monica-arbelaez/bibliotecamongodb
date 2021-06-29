package com.example.bibliotecamongodb.services;

import com.example.bibliotecamongodb.mapper.RecursoBibliotecaMapper;
import com.example.bibliotecamongodb.model.RecursoBiblioteca;
import com.example.bibliotecamongodb.repository.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class ServicioRecursoBiblioteca {

    @Autowired
    private RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;

    private Date objDate = new Date();
    private String strDateFormat = "dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

    private RecursoBibliotecaMapper mapper = new RecursoBibliotecaMapper();


    private String prestarRecursoBiblioteca(String id){
        Optional<RecursoBiblioteca> recursoBiblioteca = repositorioRecursoBiblioteca.findById(id);
        if (recursoBiblioteca.get().getDisponible()){
            recursoBiblioteca.get().setDisponible(false);
            recursoBiblioteca.get().setFechaPrestamo(objSDF.format(objDate));
            repositorioRecursoBiblioteca.save(recursoBiblioteca.get());
            return "El recurso te fue prestado";
        }
        return "El recurso se encuentra presatdo en el momento";
    }

    private String devolverRecursoBiblioteca(String id){
        Optional<RecursoBiblioteca> recursoBiblioteca = repositorioRecursoBiblioteca.findById(id);
        if (recursoBiblioteca.get().getDisponible()){
            recursoBiblioteca.get().setDisponible(true);
            recursoBiblioteca.get().setFechaPrestamo(objSDF.format(objDate));
            repositorioRecursoBiblioteca.save(recursoBiblioteca.get());
            return "El recurso fue devuelto";
        }
        return "El recurso se encuentra en la lista de inventario";
    }
}
