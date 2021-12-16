package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth2_Test {
	
	@Test
	public void oauth2Test()
	{
		Response resp = given()
		.formParam("client_id", "Damro")
		.formParam("client_secret", "91e44c0820406bbdc56b2458a4bb5415")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://disney.com")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(resp.prettyPrint());
		
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", "2573")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then()
		.log().all();
	}

}
