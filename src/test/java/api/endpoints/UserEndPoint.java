package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Created for perform CRUD Operation

public class UserEndPoint {

	public static Response createUser(User payload) {

		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.post_url);

		return response;
	}

	public static Response readUser(String userName) {

		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("userName", userName)

				.when()
				.get(Routes.get_url);

		return response;
	}

	public static Response updateUser(User payload,String userName) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("userName", userName)	
				.body(payload)
				.when()
				.put(Routes.update_url);

		return response;
	}

	public static Response deleteUser(String userName) {

		Response response = given()

				.pathParam("userName", userName)	

				.when()
				.delete(Routes.delete_url);

		return response;
	}





}
