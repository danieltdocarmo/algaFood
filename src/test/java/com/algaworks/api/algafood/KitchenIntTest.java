package com.algaworks.api.algafood;


import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.domain.service.kitchen.CreateKitchenService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.flywaydb.core.Flyway;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class KitchenIntTest {
    
    @LocalServerPort
    private int port;

    @Autowired
    private Flyway flyway;

    @Autowired
    private CreateKitchenService createKitchenService;

    @BeforeEach
    public void prepare() {
        RestAssured.port = port;
        RestAssured.basePath = "/kitchen";
        flyway.migrate();
    }

    @AfterEach
    public void end() {
        //clean all migrations on db after tests
        flyway.clean();
    }

    @Test
    public void shouldTryFindAllKitchenAndReturnStatus200() {
        RestAssured.given()
        .accept(ContentType.JSON)
        .when()
            .get()
        .then()
            .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void shouldFindAllKitchenAndReturn2Kitchens() {
        prepareDbData();
        RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .body("name", Matchers.hasItems("Brasileira", "Chinesa"));
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

    @Test
    public void shouldBeAbleToFindSpecificKitchen() {
        final var kitchen = createKitchenService.execute(new Kitchen("Brasileira"));
        RestAssured.given()
                .pathParam("id", kitchen.getId())
                .accept(ContentType.JSON)
                .when()
                .get("/{id}")
                .then()
                .body("name", Matchers.is("Brasileira"));
    }

    @Test
    public void shouldReturnNotFoundWhenIdNotExist() {
       RestAssured.given()
                .accept(ContentType.JSON)
                .pathParam("id", UUID.randomUUID())
                .when()
                .get("/{id}")
               .then()
               .statusCode(404);
    }

    public void prepareDbData() {
        createKitchenService.execute(new Kitchen("Brasileira"));
        createKitchenService.execute(new Kitchen("Chinesa"));
    }


}
