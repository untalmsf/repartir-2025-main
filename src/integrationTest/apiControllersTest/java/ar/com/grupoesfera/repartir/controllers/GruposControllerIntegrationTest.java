package ar.com.grupoesfera.repartir.controllers;

import ar.com.grupoesfera.repartir.itest.apiControllers.fixtures.GruposFixture;
import ar.com.grupoesfera.repartir.services.GruposService;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static net.javacrumbs.jsonunit.JsonMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationTestWithControllers")
public class GruposControllerIntegrationTest {

    final GruposFixture GRUPOS = new GruposFixture();

    @MockBean
    GruposService gruposService;

    @LocalServerPort
    int randomServerPort;

    @Test
    @Tag("api")
    void listarCuandoNoExistenGrupos() {

        when(gruposService.listarGrupos()).thenReturn(emptyList());

        given()
                .accept(ContentType.JSON)
                .port(randomServerPort)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/grupos")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(equalTo("[]"));
    }

    @Test
    void listarCuandoExistenUnUnicoGrupo() {

        when(gruposService.listarGrupos())
                .thenReturn(asList(GRUPOS.ALMUERZO));

        given()
                .accept(ContentType.JSON)
                .port(randomServerPort)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/grupos")
                .then()
                .statusCode(200)
                .body(jsonEquals("""
                        [
                            {
                                "id": 101,
                                "nombre": "Almuerzo",
                                "miembros": ["martin",  "tatiana", "mariano"],
                                "total": 1500.33
                            }
                        ]
                        """));
    }

    @Test
    void listarCuandoExistenDosGrupos() {

        when(gruposService.listarGrupos())
                .thenReturn(asList(GRUPOS.ALMUERZO, GRUPOS.REGALO_PARA_LUCAS));

        given()
                .accept(ContentType.JSON)
                .port(randomServerPort)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/grupos")
                .then()
                .statusCode(200)
                .body("id", contains(101, 102))
                .body("nombre", contains("Almuerzo", "Regalo para Lucas"))
                .body("total", contains(1500.33f, 4000.0f));
    }

}
