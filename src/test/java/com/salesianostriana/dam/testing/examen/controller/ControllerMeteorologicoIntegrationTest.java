package com.salesianostriana.dam.testing.examen.controller;

import com.salesianostriana.dam.testing.examen.dto.EditDatoMeteorologicoDto;
import com.salesianostriana.dam.testing.examen.dto.GetDatoMeteoDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerMeteorologicoIntegrationTest {


    @Test
    void edit(){

        TestRestTemplate testRestTemplate = new TestRestTemplate();
        EditDatoMeteorologicoDto edit = new EditDatoMeteorologicoDto("Sevilla","08/01/2020",9);
        HttpEntity httpEntity = new HttpEntity<>(edit);


        ResponseEntity<GetDatoMeteoDto> getDatoMeteoDto = testRestTemplate.exchange("/meteo/edit", HttpMethod.PUT,httpEntity ,GetDatoMeteoDto.class);

        Assertions.assertEquals(getDatoMeteoDto.getBody().ciudad(),"Sevilla");


    }

}
