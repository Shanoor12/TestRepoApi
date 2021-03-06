package basic;
import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import util.Payload;
public class GoogleApi {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//to Ignore all the certification errors
		RestAssured.useRelaxedHTTPSValidation();
		
		//AddPlace
		
		String response=given().log().all().header("Content-Type","application/json").
		body(Payload.GoglePayload()).
		when().post("/maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200).
		extract().response().asString();
		
		JsonPath js= new JsonPath(response);
		String placeid= js.getString("place_id");
		
		
		System.out.println(placeid);
		
		System.out.println("====Done====");
		
		//Get place
		
		response =given().log().all().header("content-type", "application/json")
				.queryParam("key", "qaclick123")
				.queryParam("place_id", placeid)
				.when().get("/maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200)
				.extract().asString();

				js = new JsonPath(response);
				String name = js.getString("name");
				assertEquals(name, "Frontline house");

		
		System.out.println("====Done====");
		
		
		//Update place
		given().log().all().header("content-type", "application/json")
		.queryParam("key", "qaclick123")
		.queryParam("place_id", placeid)
		.body(Payload.UpdatePayload(placeid))
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
				
				System.out.println("====Done====");
				
		//Deleteplace
				
				given().log().all().header("Content-Type","application/json").
				queryParam("key","qaclick123").
				body(Payload.DeletePayload(placeid)).
				
				when().put("/maps/api/place/delete").
				then().log().all().assertThat().statusCode(200).
				body("status", equalTo("OK"));
				
		
				System.out.println("====Done====");
		
		
		
		
	}
}
