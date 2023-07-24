package api.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.Sach_API;
import api.payload.Blog;
import io.restassured.response.Response;

public class API {
	Blog Blogpayload = new Blog();
	@BeforeClass
	public void setupu() {
		Blogpayload = new Blog();
		Blogpayload.setBlogBody("First Blog Creation Using Rest-Assured");
		Blogpayload.setBlogTitle("RestAssured FrameWork Blog");
		Blogpayload.setBlogThumnail("7a31097e-8f2b-443c-80a4-1a21c149c44b.png");
		Blogpayload.setBlogCategory("636267c831231928af965604");
		Blogpayload.setBlogSubCategory("636268e331231928af965626");
		Blogpayload.setStatus("pending");
		Blogpayload.setTableContent(null);
		Blogpayload.setUserId("SACH-819");
	}

	@Test
	public void CreateBlog() {
		
		Response response = Sach_API.createBlog(Blogpayload);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 201);
		assertThat(response.path("message").toString(),equalTo("Successfully requeste"));

	}
	@Test
	public void Roles() {

		Response response = Sach_API.getRoles();
		response.then().log().all();
				Assert.assertEquals(response.getStatusCode(), 200);
			

	}



}
