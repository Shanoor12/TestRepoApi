package basic;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import util.Payload;

public class LibraryApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="http://216.10.245.166";
		
		//to Ignore all the certification errors
		RestAssured.useRelaxedHTTPSValidation();
		
		given().log().all().header("Content-Type","application/json").
		body(Payload.AddBook1("sha77n5","7875")).
		when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added"));
		
		
		given().log().all().header("Accept","*/*").
		queryParam("ID","sha77n57875").
		when().get("/Library/GetBook.php").
		then().log().all().assertThat().statusCode(200).body("book_name", equalTo("[Learn Appium Automation with Java]"));
		
		
		

	}

}
