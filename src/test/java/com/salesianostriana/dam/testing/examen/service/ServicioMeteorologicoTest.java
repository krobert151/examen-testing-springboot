package com.salesianostriana.dam.testing.examen.service;

import com.salesianostriana.dam.testing.examen.model.DatoMeteorologico;
import com.salesianostriana.dam.testing.examen.model.DatoMeterologicoPK;
import com.salesianostriana.dam.testing.examen.repo.DatoMeteorologicoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ServicioMeteorologicoTest {

    @InjectMocks
    private ServicioMeteorologico servicioMeteorologico;

    @Mock
    private DatoMeteorologicoRepository datoMeteorologicoRepository;

    @Test
    void mediaDiaSemana() {

        String poblacion = "Cuenca";

        DatoMeterologicoPK pk1 = new DatoMeterologicoPK(poblacion, LocalDate.of(2024,2,9));
        DatoMeterologicoPK pk2 = new DatoMeterologicoPK(poblacion, LocalDate.of(2024,2,8));
        DatoMeterologicoPK pk3 = new DatoMeterologicoPK(poblacion, LocalDate.of(2024,2,7));
        DatoMeterologicoPK pk4 = new DatoMeterologicoPK(poblacion, LocalDate.of(2024,2,6));

        DatoMeteorologico datoMeteorologico1 = new DatoMeteorologico(pk1, 34);
        DatoMeteorologico datoMeteorologico2 = new DatoMeteorologico(pk1, 540);
        DatoMeteorologico datoMeteorologico3 = new DatoMeteorologico(pk1, 32);
        DatoMeteorologico datoMeteorologico4 = new DatoMeteorologico(pk1, 50);


        List<DatoMeteorologico> datosMet = new ArrayList<>(List.of(
                datoMeteorologico1,
                datoMeteorologico2,
                datoMeteorologico3,
                datoMeteorologico4
        ));

        Mockito.when(datoMeteorologicoRepository.buscarPorPoblacion(poblacion)).thenReturn(datosMet);

        Map<String, Double> result = servicioMeteorologico.mediaDiaSemana(poblacion);

        Assertions.assertEquals(result.keySet().toString(),"[VIERNES]");
        Assertions.assertEquals(result.values().toString(),"[164.0]");

        System.out.println(result);


    }


    @Test
    void mediaDiaSemana_ReturnVoid() {

        String poblacion = "Cuenca";


        List<DatoMeteorologico> datosMet = new ArrayList<>(List.of(

        ));

        Mockito.when(datoMeteorologicoRepository.buscarPorPoblacion(poblacion)).thenReturn(datosMet);

        Map<String, Double> result = servicioMeteorologico.mediaDiaSemana(poblacion);
        Map<String,Double> vacio = new HashMap<>();

        Assertions.assertEquals(result,vacio);

        System.out.println(result);


    }


    @ParameterizedTest
    @CsvSource()
    void mediaDiaSemanaParam() {

        String poblacion = "Cuenca";

        DatoMeterologicoPK pk1 = new DatoMeterologicoPK(poblacion, LocalDate.of(2024,2,9));
        DatoMeterologicoPK pk2 = new DatoMeterologicoPK(poblacion, LocalDate.of(2024,2,8));
        DatoMeterologicoPK pk3 = new DatoMeterologicoPK(poblacion, LocalDate.of(2024,2,7));
        DatoMeterologicoPK pk4 = new DatoMeterologicoPK(poblacion, LocalDate.of(2024,2,6));

        DatoMeteorologico datoMeteorologico1 = new DatoMeteorologico(pk1, 34);
        DatoMeteorologico datoMeteorologico2 = new DatoMeteorologico(pk1, 540);
        DatoMeteorologico datoMeteorologico3 = new DatoMeteorologico(pk1, 32);
        DatoMeteorologico datoMeteorologico4 = new DatoMeteorologico(pk1, 50);


        List<DatoMeteorologico> datosMet = new ArrayList<>(List.of(
                datoMeteorologico1,
                datoMeteorologico2,
                datoMeteorologico3,
                datoMeteorologico4
        ));

        Mockito.when(datoMeteorologicoRepository.buscarPorPoblacion(poblacion)).thenReturn(datosMet);

        Map<String, Double> result = servicioMeteorologico.mediaDiaSemana(poblacion);

        Assertions.assertEquals(result.keySet().toString(),"[VIERNES]");
        Assertions.assertEquals(result.values().toString(),"[164.0]");

        System.out.println(result);


    }


}