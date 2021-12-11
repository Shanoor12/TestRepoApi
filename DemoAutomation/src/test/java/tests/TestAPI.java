package tests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.path.json.JsonPath;
import static io.restassured.path.json.JsonPath.*;

public class TestAPI {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "https://reqres.in";
		
		given().log().all().header("content-type" ,"application/json")
		.body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}")
		.when().post("/api/users")
		.then().log().all().assertThat().statusCode(201)
		.body("name", equalTo("morpheus"));
		
		
		given().log().all().header("content-type" ,"application/json")
		.queryParam("page", 2)
		.when().get("/api/users")
		.then().log().all().assertThat().statusCode(200)
		.body("data.id", hasItems(7,8,9,10,11,12)).extract().asString();
		

	}

}
