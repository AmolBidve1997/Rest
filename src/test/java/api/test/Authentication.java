package api.test;



import static io.restassured.RestAssured.given;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

import io.restassured.response.Response;



public class Authentication {
	Response response;

	@BeforeClass
	public void beforeclass() {

		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
				setBaseUri("https://api.sach.org.in").
				setContentType(ContentType.JSON).
				log(LogDetail.ALL);


		RestAssured .requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
				expectStatusCode(201).
				expectContentType(ContentType.JSON).
				log(LogDetail.ALL);

		RestAssured .responseSpecification = responseSpecBuilder.build();
	

	}
	@Test
	public void createToken() {
		String payload = "{\r\n"
				+ "    \"userId\": \"SACH-418\",\r\n"
				+ "    \"password\": \"Asdf@123\",\r\n"
				+ "    \"redirectUrl\": null\r\n"
				+ "}";
		given()
		.body(payload).

		when().
		post("/api/login").

		then().
		log().all();

//		String BearerToken = response.getBody().asPrettyString();
//		String GeneratedToken = JsonPath.from(BearerToken).get("access_token");
//		System.out.println(GeneratedToken);


	}

}	












