package requestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestChainingTest {
	
	@Test
	public void getToDelete()
	{
		Response resp = given().get("http://localhost:8084/projects");
		resp.then().assertThat().statusCode(200);
		
		String proID = resp.jsonPath().get("[0].projectId");
		
		given().pathParam("pId", proID)
		.when().delete("http://localhost:8084/projects/{pId}")
		.then().assertThat().statusCode(204).log().all();
		
	}

}
