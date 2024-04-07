package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PostmanEchoTest {

    @Test
    public void shouldPostToPostmanEcho() {

    // Given - When - Then
    // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("The topic of the meeting")
                // отправляемые данные (заголовки и query можно выставлять аналогично)

    // Выполняемые действия
        .when()
                .post("/post")

    // Проверки
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("The theme of the party"))
                .body("headers.content-length", equalTo("24"));
        ;
    }
}
