package com.salesianostriana.dam.testing.examen.controller;

import com.salesianostriana.dam.testing.examen.security.jwt.JwtAuthenticationFilter;
import com.salesianostriana.dam.testing.examen.service.ServicioMeteorologico;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ControladorMeteorologico.class)
class ControladorMeteorologicoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @MockBean
    private ServicioMeteorologico servicioMeteorologico;

    @Test
    @WithMockUser(username = "roberto", roles = "{USER}")
    void mediaSemanalPorPoblacion() throws Exception {

        Mockito.when(servicioMeteorologico.mediaDiaSemana("Sevilla")).thenReturn(Map.of("Sevilla",0.1));

        mockMvc.perform(MockMvcRequestBuilders.get("/media/semana/Sevilla")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    void mediaSemanalPorPoblacion_401() throws Exception {

        Mockito.when(servicioMeteorologico.mediaDiaSemana("Sevilla")).thenReturn(Map.of("Sevilla",0.1));

        mockMvc.perform(MockMvcRequestBuilders.get("/media/semana/Sevilla")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());


    }



}