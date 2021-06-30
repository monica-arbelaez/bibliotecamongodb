package com.example.bibliotecamongodb.services;

import com.example.bibliotecamongodb.model.Recurso;
import com.example.bibliotecamongodb.repository.RepositorioRecursoBiblioteca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;


@SpringBootTest
class ServicioRecursoBibliotecaCRUDTest {

    @MockBean
    private RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;
    @Autowired
    private ServicioRecursoBibliotecaCRUD servicioRecursoBibliotecaCRUD;

    @Test
    @DisplayName("Happy case")
    public  void obtenerRecursosBiblioteca(){
        var recurso1 = new Recurso();
        recurso1.setId("8765");
        recurso1.setTipoRecurso("libro");
        recurso1.setDisponible(true);
        recurso1.setFechaPrestamo(LocalDate.now());
        recurso1.setNombre("El amor en los tiempos del colera");
        recurso1.setIdArea("6789900");

        var recurso2 = new Recurso();
        recurso2.setId("87552");
        recurso2.setTipoRecurso("revista");
        recurso2.setDisponible(true);
        recurso2.setFechaPrestamo(LocalDate.now());
        recurso2.setNombre("Matematica aplicadas");
        recurso2.setIdArea("6789955");

        var recurso3 = new Recurso();
        recurso3.setId("87552");
        recurso3.setTipoRecurso("libro");
        recurso3.setDisponible(false);
        recurso3.setFechaPrestamo(LocalDate.now());
        recurso3.setNombre("El principito");
        recurso3.setIdArea("6789955");

        var lista = new ArrayList<Recurso>();
        lista.add(recurso1);
        lista.add(recurso2);
        lista.add(recurso3);
        Mockito.when(repositorioRecursoBiblioteca.findAll()).thenReturn(lista);
        var respuesta = servicioRecursoBibliotecaCRUD.obtenerRecursosBiblioteca();

        Assertions.assertEquals(3,respuesta.size());
        Assertions.assertEquals(recurso1.getNombre(),respuesta.get(0).getNombreRecurso());
        Assertions.assertEquals(recurso2.getNombre(),respuesta.get(1).getNombreRecurso());
        Assertions.assertEquals(recurso3.getNombre(),respuesta.get(2).getNombreRecurso());
    }


}