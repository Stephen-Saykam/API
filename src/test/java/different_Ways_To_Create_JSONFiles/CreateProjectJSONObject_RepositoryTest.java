package different_Ways_To_Create_JSONFiles;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RMGYantra_POJO_Library.Pojo_Librery;

import io.restassured.http.ContentType;

public class CreateProjectJSONObject_RepositoryTest {
	
	@Test(dataProvider="provideData")
	public void createProjectJSONObject_RepositoryTest(String createdBy, String projectName, String status, int teamSize)
	{
		Random rd = new Random();
		int rnum = rd.nextInt(2000);
		
		Pojo_Librery pl = new Pojo_Librery(createdBy, projectName+rnum, status, teamSize);
		
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
	
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] ob = new Object[2][4];
		
		ob[0][0]="Raj";
		ob[0][1]="Enternals";
		ob[0][2]="Completed";
		ob[0][3]=10;
		
		ob[1][0]="Raj";
		ob[1][1]="Spieces";
		ob[1][2]="On Going";
		ob[1][3]=10;
		
		return ob;
		
	}

}
