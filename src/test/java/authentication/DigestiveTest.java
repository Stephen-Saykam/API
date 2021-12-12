package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DigestiveTest {
	
	@Test
	public void digestiveTest()
	{
		given().auth().digest("rmgyantra", "rmgy@9999")
		.when().get("http://localhost:8084/login").then().assertThat().statusCode(202).log().all();
	}

}
