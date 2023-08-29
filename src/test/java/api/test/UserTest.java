package api.test;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	public static Logger  logger;

	@BeforeClass
	public void generateTestData() {

		faker = new Faker();
		userpayload = new User();

		userpayload.setId(faker.idNumber().hashCode()); // Unique id generation
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());

		//logs
//		obtain logger
		logger = LogManager.getLogger("SACH_API_Automation");
	}

	@Test(priority=1)

	public void testPostUser() {

		Response response = UserEndPoint.createUser(userpayload);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("Create user");
	}
	@Test(priority=2)
	public void testgetUserByName() {

		Response response =	UserEndPoint.readUser(this.userpayload.getUsername());

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("get user");
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

		logger.info("update user");
	}

	@Test(priority=4)
	public void testDeleteUserByName() {


		Response response =	UserEndPoint.deleteUser(this.userpayload.getUsername());

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("delete user");
	}

//	@Test
	public void testRoles() {

		Response response = UserEndPoint2.getRoles();
		response.then().log().all();
		//		Assert.assertEquals(response.getStatusCode(), 200);

	}


}


