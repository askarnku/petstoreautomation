package api.endpoints;

import static io.restassured.RestAssured.*;
import api.payload.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Created to perform CRUD operations to the user APIs

public class UserEndPoints {

	public static Response createUser(User payload) {

        return given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
                .post(Routes.post_url);
	}

	public static Response readUser(String userName) {
        return given().pathParam("username", userName).when().get(Routes.get_url);
	}

	public static Response updateUser(String username, User payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
                .when()
                .put(Routes.update_url);
	}

	public static Response deleteUser(String userName) {
        return given().pathParam("username", userName).when().delete(Routes.delete_url);
	}

}
