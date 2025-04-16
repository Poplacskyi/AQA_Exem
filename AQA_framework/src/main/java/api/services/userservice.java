package api.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class userservice {
    private static final String BASE_URL = "https://reqres.in/api";

    public Response getUserById(String userId) {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .get("/users/" + userId)
                .then()
                .extract().response();
    }

    public Response createUser(api.models.User user) {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(user)
                .when()
                .post("/users")
                .then()
                .extract().response();
    }
}
