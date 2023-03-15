package api.test;

import java.util.Random;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.endpoints.OrderEndPoints;
import api.payload.Order;
import io.restassured.response.Response;

public class OrderTests {

	/*
	 * "id": 0, "petId": 0, "quantity": 0, "shipDate": "2023-03-14T23:20:01.501Z",
	 * "status": "placed", "complete": true
	 */

	Random r;
	Order order;

	@BeforeMethod
	@BeforeClass
	public void setUp() {
		r = new Random();
		order = new Order();
		order.setId(r.nextInt(1, 10));
		order.setPetId(r.nextInt(101, 199));
		order.setQuantity(r.nextInt(1, 6));
		order.setDateTime("2023-03-14T23:20:01.501Z");
		order.setStatus("placed");
		order.setComplete(true);
	}

	@Test(priority = 1)
	public void testPostOrder() {
		Response response = OrderEndPoints.createOrder(order);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		System.out.println("Printing ------- response body here: ");
		System.out.println(response.body().asString());
	}

	@Test(priority = 2)
	public void testGetOrder() {
		Response response = OrderEndPoints.readOrder(order.getId());
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		System.out.println("Printing ------- GET response body here: ");
		System.out.println(response.body().asString());
	}

	@Test(priority = 3)
	public void testReadAllOrder() {
		Response response = OrderEndPoints.readAllOrder();
		response.then().log().all();
	}

	@Test(priority = 4)
	public void testDeleteOrder() {
		Response response = OrderEndPoints.deleteOrder(order.getId());
		response.then().log().all();
	}

}
