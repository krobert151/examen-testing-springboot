package com.salesianostriana.dam.testing.examen.repo;

import com.salesianostriana.dam.testing.examen.model.DatoMeteorologico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(value = "classpath:data/import.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "classpath:data/delete.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class DatoMeteorologicoRepositoryTest {

    @Autowired
    private DatoMeteorologicoRepository datoMeteorologicoRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>("postgres:16-alpine")
            .withPassword("12345678")
            .withUsername("postgres")
            .withDatabaseName("testing");



    @Test
    void buscarPorPoblacion() {

        List<DatoMeteorologico> list = datoMeteorologicoRepository.buscarPorPoblacion("Sevilla");
        Assertions.assertEquals(7,list.size());

    }
}