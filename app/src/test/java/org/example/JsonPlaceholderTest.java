package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class ApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://reqres.in"; // Free demo API
    }

    @Test
    void getUser_shouldReturn200AndData() {
        given()
            .when()
             .header("x-api-key", "reqres-free-v1")
                .get("/api/users/2")
            .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", containsString("@reqres.in"));
    }

    @Test
    void getUser_notFoundShouldReturn404() {
    given()
        .header("x-api-key", "reqres-free-v1")
    .when()
        .get("/api/users/23")
    .then()
        .statusCode(404)
        .body(anyOf(equalTo("{}"), is(emptyOrNullString())));
}

}
