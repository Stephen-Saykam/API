package com.TestCases;

import com.RMGYantra_Generic_Librery.BaseClass;
import com.RMGYantra_Generic_Librery.DataBaseUtility;
import com.RMGYantra_Generic_Librery.EndPoints;
import com.RMGYantra_Generic_Librery.JavaUtility;
import com.RMGYantra_POJO_Library.Pojo_Librery;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

public class EndToEndTest extends DataBaseUtility{//BaseClass implements EndPoints {
	
	@Test
	public void endToEndTest() throws Throwable
	{
		JavaUtility jUtil = new JavaUtility();
		DataBaseUtility dbUtil = new DataBaseUtility();
		
		
		Pojo_Librery pl = new Pojo_Librery("Satya", "Mechino"+jUtil.randomNum(), "Created", 10);
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(pl)
		.when()
		.post("http://localhost:8084/addProject");
		
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		
		Response resp1 = given()
		.pathParam("projectId", proId)
		.when()
		.get("http://localhost:8084/projects/{projectId}");
		
		String proName = resp1.jsonPath().get("projectName");
		System.out.println(proName);
		
		//JDBC code for verifying in DataBase
		
		dbUtil.connectToDB();
		
		res=dbUtil.executeQuery("select * from project");
		while(res.next())
		{
			if(res.getString(4).equals(proName))
			{
				System.out.println(proName+" is matching");
			}
		}
			
		dbUtil.closeDB();
		
	}

}
