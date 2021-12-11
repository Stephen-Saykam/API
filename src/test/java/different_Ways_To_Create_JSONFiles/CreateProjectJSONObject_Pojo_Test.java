package different_Ways_To_Create_JSONFiles;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.RMGYantra_POJO_Library.Pojo_Librery;

import io.restassured.http.ContentType;

public class CreateProjectJSONObject_Pojo_Test {
	
	@Test
	public void createProjectJSONObject_Pojo_Test()
	{
		Random rd = new Random();
		int rnum = rd.nextInt(2000);
		
		Pojo_Librery pl = new Pojo_Librery("Raj", "Enternals"+rnum, "Completed", 5);
		
		given()
		.contentType(ContentType.JSON)
		.body(pl)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
