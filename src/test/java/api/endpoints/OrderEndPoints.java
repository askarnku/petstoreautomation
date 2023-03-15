package api.endpoints;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import api.payload.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrderEndPoints {

	@Test
	public static Response createOrder(Order payload) {
        return given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
                .post(Routes.order_post);
	}

	@Test
	public static Response readOrder(int orderId) {
        return given().pathParam("orderId", orderId).when().get(Routes.order_get);
	}

	@Test
	public static Response readAllOrder() {
        return when().get(Routes.orders_all_get);
	}

	@Test
	public static Response deleteOrder(int orderId) {
        return given().pathParam("orderId", orderId).when().delete(Routes.order_delete);
	}

}
