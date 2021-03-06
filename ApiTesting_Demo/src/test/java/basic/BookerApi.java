package basic;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.path.json.JsonPath;
import util.Payload;

public class BookerApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		//to Ignore all the certification errors
		RestAssured.useRelaxedHTTPSValidation();
		
		given().log().all().header("Content-Type","application/json").
		body(Payload.BookerApiPayload()).
		when().post("/booking").
		then().log().all().assertThat().statusCode(200).body("booking.firstname", equalTo("Jim"));
		
		
		given().log().all().header("Content-Type","application/json").pathParam("id", 1).
		when().get("/booking/{id}").
		then().log().ifValidationFails(LogDetail.BODY).assertThat().statusCode(200).body("firstname", equalTo("Susan"));
		
		//Get Bookings
		given().log().all().header("Content-Type","application/json").
		when().get("/booking").
		then().log().ifValidationFails(LogDetail.BODY).assertThat().statusCode(200).
		body("bookingid", hasItems(14,19,9,11));
		
		//Auth
		
		String RepAuth=given().header("Content-Type","application/json").
		body(Payload.Auth()).
		when().post("/auth").
		then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(RepAuth);
		
		
		
		JsonPath js= new JsonPath(RepAuth);
		String Token=js.getString("token");
		System.out.println(Token);
		
		//Udate Booking
		String UpdResp=given().header("Content-Type","application/json").header("Cookie",Token).pathParam("id", 11).
		body(Payload.UpadateBooking()).
		when().put("booking/{id}").
		then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(UpdResp);
		
		//deleteBooking
		
		String delResp=given().header("Accept","*/*").header("Cookie",Token).pathParam("id", 7).
		when().delete("booking/{id}").
		then().assertThat().statusCode(200).extract().response().asString();
				
		System.out.println(delResp);
		
		
		

	}

}
