package basic;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import util.Payload;

public class Employee {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in/api";
		
		//to Ignore all the certification errors
		RestAssured.useRelaxedHTTPSValidation();
		
		//Create an employee
		given().log().all().header("Content-Type","application/json").
		body(Payload.EmployeePayload()).
		when().post("/users").
		then().log().all().assertThat().statusCode(201).body("name", equalTo("morpheus"));
		
		//Single user
		given().log().all().header("Content-Type","application/json").pathParam("id", 1).
		when().get("users/{id}").
		then().log().ifValidationFails(LogDetail.BODY).assertThat().statusCode(200).body("data.id", equalTo(1));
		
		//get users
		
		given().log().all().header("Content-Type","application/json").queryParam("page", 2).
		when().get("/users").
		then().log().all().assertThat().statusCode(200).
		body("data.id", hasItems(7,8,9,10,11,12)).
		body("data.first_name", hasItems("Michael", "Lindsay"));
		
		//Error Code
		
		given().log().all().header("Content-Type","application/json").pathParam("id", 23).
		when().get("unknown/{id}").
		then().log().all().assertThat().statusCode(404);
		
		
		
		
	}
	
	

}
