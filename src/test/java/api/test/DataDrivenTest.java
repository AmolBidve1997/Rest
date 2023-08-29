package api.test;


import org.testng.Assert;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoint;
import api.payload.User;
import api.utilites.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {
	

	@Test(priority=1, dataProvider="Data", dataProviderClass= DataProviders.class)
	public void testPostUser(String userid, String userName, String fName, String lName, String email, String pwd, String ph) {
		
		User userPayload = new User();
		
		
		userPayload.setId(Integer.parseInt(userid));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response = UserEndPoint.createUser(userPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=3, dataProvider="UserNames", dataProviderClass = DataProviders.class)
	public void deleteUserByNames(String userName) {
		
		Response response = UserEndPoint.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	@Test(priority=2,dataProvider="UserNames", dataProviderClass = DataProviders.class)
	public void getuser(String userName) {
		Response response = UserEndPoint.readUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		}
	}


