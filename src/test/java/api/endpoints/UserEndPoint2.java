package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Created for perform CRUD Operation

public class UserEndPoint2 {
	
//	Method created for getting Url from properties file
	
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");  // Load properties file
		return routes;
		
		
	}
	

	public static Response createUser(User payload) {
		
		String post_url = getURL().getString("post_url");

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(post_url);

		return response;
	}

	public static Response readUser(String userName) {
		
		String get_url = getURL().getString("get_url");

		Response response = given()
				.pathParam("userName", userName)

				.when()
				.get(get_url);

		return response;
	}

	public static Response updateUser(User payload,String userName) {
		
		String update_url = getURL().getString("update_url");

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("userName", userName)	
				.body(payload)
				.when()
				.put(update_url);

		return response;
	}

	public static Response deleteUser(String userName) {
		
		String delete_url = getURL().getString("delete_url");

		Response response = given()

				.pathParam("userName", userName)	

				.when()
				.delete(delete_url);

		return response;



	}
	
	public static Response getRoles() {
		String url = getURL().getString("get_roles");
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Il9pZCI6IjYzNGQ2YTMwYTNkZGZmODk0NTkyZTlkNiIsInVzZXJGdWxsTmFtZSI6Ik1vaGQgVXNtYW4iLCJ1c2VyUGFzc3dvcmQiOm51bGwsInVzZXJDb250YWN0IjoiKzkxOTY1MDAxMjE4MCIsInVzZXJFbWFpbCI6InZlbmRlcm9mZkBnbWFpbC5jb20iLCJzYWNoVXNlcklkIjoiU0FDSC00MTgiLCJzdGF0dXMiOiJhY3RpdmUiLCJjcmVhdGVkQXQiOiIyMDIyLTEwLTE3VDE0OjQ0OjAwLjgyNFoiLCJ1cGRhdGVkQXQiOiIyMDIzLTA2LTA3VDA1OjQzOjU5LjQ4OVoiLCJyb2xlSWQiOiI2MmY5NTEwZDkwNjAwNDk4NWQ4YmIzODEifSwicm9sZSI6eyJfaWQiOiI2MmY5NTEwZDkwNjAwNDk4NWQ4YmIzODEiLCJyb2xlSWQiOiI2MmY5NTEwZDkwNjAwNDk4NWQ4YmIzODEiLCJyb2xlTmFtZSI6IlN1cGVyIEFkbWluIiwiYWNjZXNzaWJsZUxpc3QiOlt7ImlkIjoidXNlck1uZ210IiwibmFtZSI6IlVzZXIgTWFuYWdlbWVudCIsInJlYWQiOnRydWUsIndyaXRlIjp0cnVlfSx7ImlkIjoiY2F0ZWdvcnlNbmdtdCIsIm5hbWUiOiJDYXRlZ29yeSBNYW5hZ2VtZW50IiwicmVhZCI6ZmFsc2UsIndyaXRlIjp0cnVlfSx7ImlkIjoiZXZlbnRNbmdtdCIsIm5hbWUiOiJFdmVudCBNYW5hZ2VtZW50IiwicmVhZCI6ZmFsc2UsIndyaXRlIjp0cnVlfSx7ImlkIjoiYmxvZ01uZ210IiwibmFtZSI6IkJsb2dzIE1hbmFnZW1lbnQiLCJyZWFkIjpmYWxzZSwid3JpdGUiOnRydWV9LHsiaWQiOiJ0ZXN0aW1vbmlhbCIsIm5hbWUiOiJUZXN0aW1vbmlhbCIsInJlYWQiOmZhbHNlLCJ3cml0ZSI6dHJ1ZX0seyJpZCI6InJlcXVlc3RUb3BpYyIsIm5hbWUiOiJUb3BpYyBSZXF1ZXN0IiwicmVhZCI6ZmFsc2UsIndyaXRlIjp0cnVlfSx7ImlkIjoibXVsdGlMYW5nIiwibmFtZSI6IkNNUyIsInJlYWQiOnRydWUsIndyaXRlIjp0cnVlfSx7ImlkIjoiY29udHJpYnV0aW9uX21nbXQiLCJuYW1lIjoiQ29udHJpYnV0aW9uIiwicmVhZCI6ZmFsc2UsIndyaXRlIjp0cnVlfV0sImNyZWF0ZWRBdCI6IjIwMjItMDgtMTRUMTk6NDY6MjAuODg1WiIsInVwZGF0ZWRBdCI6IjIwMjItMDktMjJUMDc6MTg6MDUuMjMzWiJ9LCJzdWIiOiI2MzRkNmEzMGEzZGRmZjg5NDU5MmU5ZDYiLCJpYXQiOjE2ODk4Mzc1MjcsImV4cCI6MTc0OTgzNzUyN30.WAluSm6uQ-MEIwWTbmlbdKq4oj32wYQSVziZo806sbA";
		Response response = given()
				.header("Authorization", "Bearer " + token)
				
				.when()
				.get(url);
		return response;
	}
}
