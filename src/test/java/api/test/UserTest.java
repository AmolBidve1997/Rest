package api.test;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoint;
import api.endpoints.UserEndPoint2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setup() {
	
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		
	}
	
	@Test(priority=1)
	
	public void testPostUser() {
		
		
		
		Response response = UserEndPoint.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=2)
	public void testgetUserByName() {
		
	Response response =	UserEndPoint.readUser(this.userpayload.getUsername());
	
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	@Test(priority=3)
	public void testUpadteUserByName() {
		
//		Upadte data using payload
		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoint.updateUser(userpayload, this.userpayload.getUsername());
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
//		Checking data after user update
		
		Response responseAfterUpdate =	UserEndPoint.readUser(this.userpayload.getUsername());
		
		responseAfterUpdate.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName() {
		
		
		Response response =	UserEndPoint.deleteUser(this.userpayload.getUsername());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	
		}
	
	@Test
	public void testRoles() {
		
		Response response = UserEndPoint2.getRoles();
		response.then().log().all();
//		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
		
	}


