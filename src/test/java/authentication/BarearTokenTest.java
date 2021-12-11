package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BarearTokenTest {
	
	@Test
	public void barearTokenTest()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.log().all();
	}

}
