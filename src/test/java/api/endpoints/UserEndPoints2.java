package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Using properties to read routes

public class UserEndPoints2 {
	
	
	
	// method created for getting URL's from properties file
	static ResourceBundle getURL() {

        return ResourceBundle.getBundle("routes");
	}
	
	

	public static Response createUser(User payload) {
		
		String post_url = getURL().getString("post_url");

        return given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
        .when()
            .post(post_url);
	}

	public static Response readUser(String userName) {
		
		String get_url = getURL().getString("get_url");

        return given()
            .pathParam("username", userName)
        .when()
            .get(get_url);
	}

	public static Response updateUser(String username, User payload) {
		
		String update_url = getURL().getString("update_url");

        return given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .pathParam("username", username)
            .body(payload)
        .when()
            .put(update_url);
	}

	public static Response deleteUser(String userName) {
		String delete_url = getURL().getString("delete_url");
        return given()
            .pathParam("username", userName)
        .when()
            .delete(delete_url);
	}

}
