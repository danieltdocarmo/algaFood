package com.algaworks.api.algafood;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class KitchenIntTest {
    
    @LocalServerPort
    private int port;

    @Autowired
    private Flyway flyway;

    @BeforeEach
    public void prepare() {
        RestAssured.port = port;
        RestAssured.basePath = "/kitchen";
        flyway.migrate();
    }

    @Test
    public void shouldFindAllKitchensAndReturnWithStatus200() {
        RestAssured.given()
        .accept(ContentType.JSON)
        .when()
            .get()
        .then()
            .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void shouldBeAbleToCreateKitchen() {
        RestAssured.given()
                .body("{\"name\": \"China\"}")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }



}
