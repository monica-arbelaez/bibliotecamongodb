package com.example.bibliotecamongodb.controller;

import com.example.bibliotecamongodb.DTOs.RecursoBibliotecaDTO;
import com.example.bibliotecamongodb.services.ServicioRecursoBibliotecaCRUD;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class ControladorRecursoCRUDTest {


    @MockBean
    private ServicioRecursoBibliotecaCRUD servicioRecursoBibliotecaCRUD;

    @Autowired
    private MockMvc mockMvc1;

    @Test
    @DisplayName("Post /Happy case  create")
    public void crear() throws Exception {


        RecursoBibliotecaDTO recursoToReturn = new RecursoBibliotecaDTO();
        RecursoBibliotecaDTO recursoBibliotecaDTO = new RecursoBibliotecaDTO();

        recursoToReturn.setTipoRecursoBiblioteca("libro");
        recursoToReturn.setRecursoDisponible(true);
        recursoToReturn.setFechaPrestamoRecurso("30/06/2021");
        recursoToReturn.setNombreRecurso("El amor en los tiempos del colera");
        recursoToReturn.setIdAreaTematica("76654");


        recursoBibliotecaDTO.setIdRecurso("1234");
        recursoBibliotecaDTO.setTipoRecursoBiblioteca("libro");
        recursoBibliotecaDTO.setRecursoDisponible(true);
        recursoBibliotecaDTO.setFechaPrestamoRecurso("30/06/2021");
        recursoBibliotecaDTO.setNombreRecurso("El amor en los tiempos del colera");
        recursoBibliotecaDTO.setIdAreaTematica("76654");

        doReturn(recursoBibliotecaDTO).when(servicioRecursoBibliotecaCRUD).crearRecursoBiblioteca(any());


        mockMvc1.perform(post("/recurso/crearRecurso")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(recursoToReturn)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idRecurso", is("1234")));

    }



    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}