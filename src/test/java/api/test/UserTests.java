package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass public void 
	setupData() {
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		// logs
		
		logger = LogManager.getLogger(this.getClass());
		
		
		
	}
	
	@Test public void
	testPostUser() {
		logger.info("-------------POST USER METHOD start-----------------");
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		System.out.println(response.getBody().asPrettyString());
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("-------------POST USER METHOD end-----------------");

		
	}
	
	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("-------------GET USER METHOD start-----------------");
		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		logger.info("-------------GET USER METHOD end-----------------");
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		logger.info("-------------UPDATE USER METHOD start-----------------");
		// new data using faker
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		
		System.out.println("------------Updated names and email-------------");
		System.out.println(userPayload.getFirstName() + " " + userPayload.getLastName() + " " + userPayload.getEmail());
		System.out.println("------------------------------------------------");
		
		Response response = UserEndPoints.updateUser(userPayload.getUsername(), this.userPayload);		
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		// Checking data after update
		
		Response resAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
		resAfterUpdate.then().log().all();
		AssertJUnit.assertEquals(resAfterUpdate.getStatusCode(), 200);
		
		logger.info("-------------UPDATE USER METHOD start-----------------");
		
	}
	
	
	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("-------------DELETE USER METHOD start-----------------");
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		logger.info("-------------DELETE USER METHOD start-----------------");
	}
	

}
