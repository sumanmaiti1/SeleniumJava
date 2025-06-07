//---------------- Inorder to Run this an FREE API KEY is to be generated from https://reqres.in/ -----------------
//---------- Click GET FREE API KEY for he same ---------------


package testNG.testNG;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;


public class TestNGWithRestAssured {
	
	private JSONObject json = new JSONObject();;
	private String currentdatetime = new SimpleDateFormat("ddMMYYhhmmss").format(new Date());
	private int userID = -1;
	private String baseURI = "https://reqres.in/api" ;

	@Test
	private void createUserPOST() {
		RestAssured.baseURI= baseURI;
		
		//------------ Create Json Object -----------
		json.put("name", "Jay Shree Ram" + currentdatetime);
		json.put("job", "Avatar");
		
		System.out.println("\nRequest Body :\n" + json.toString());
		
		//-------------- Doing POST request -----------
		Response response = given().header("Content-Type", "application/json")
				.header("x-api-key" , "reqres-free-v1") //---------- This has to be generated at runtime else Inauthorised message to be generated
				.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(json.toString())
                .when().post("/users");
		
		//--------- asserting status code ----------
		assertTrue(response.getStatusCode() == 201);
		assertTrue(response.jsonPath().getString("name").equalsIgnoreCase(json.getString("name")));
		
		userID = response.jsonPath().getInt("id");
		
		System.out.println("\nStatus Code :\n" + response.getStatusCode());
		System.out.println("\n" + response.getStatusLine());
		System.out.println("\nResponse Body :\n" + response.getBody().asString());		
		System.out.println(userID);
		
	}
	
	@Test
	private void viewNewlyCreatedUser() {
		
		RestAssured.baseURI= baseURI;
		Response response = given().header("x-api-key" , "reqres-free-v1")
				.when().get("/users/10");
		
		//--------- asserting status code ----------
		assertTrue(response.getStatusCode() == 200,"Status Code validation failed");
		assertTrue(response.jsonPath().getString("data.first_name").equalsIgnoreCase("Byron"),"First Name Code validation failed");
		assertTrue(response.jsonPath().getString("data.last_name").equalsIgnoreCase("Fields"),"Last Name Code validation failed");
		assertTrue(response.jsonPath().getString("support.text").equalsIgnoreCase("Tired of writing endless social media content? Let Content Caddy generate it for you."));
		
		System.out.println(response.getBody().asString());
	}
	
}
