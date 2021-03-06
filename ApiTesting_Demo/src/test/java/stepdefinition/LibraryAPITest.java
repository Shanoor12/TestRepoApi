package stepdefinition;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.nio.file.Path;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.Payload;

import static io.restassured.RestAssured.given;

public class LibraryAPITest 
{
	RequestSpecification request;
	Response response;
	String res;
	static String id;
	JsonPath js;
	
	@Before
	
	public void initialize()
	{
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI="http://216.10.245.166";
				
	}
	
	@Given("Payload1 for AddBook api")
	public void payload1_for_AddBook_api() {
			request=given().log().all().header("Content-Type","application/json").
			body(Payload.AddBook1("88765","hgjhgtftd"));
	    
	}

	@When("User1 calls Addbook api using http POST request")
	public void user1_calls_Addbook_api_using_http_POST_request() {
	response= request.when().post("Library/Addbook.php");
	    
	}

	@Then("Status1 code is {int}")
	public void status1_code_is(int expstatuscode) {
			response.then().log().all().
			assertThat().statusCode(expstatuscode);
	    
	}

	@Then("{string} in the response is {string}")
	public void in_the_response_is(String param, String expvalue) {

			res =response.then().extract().asString();
			js =new JsonPath(res);
			String actvalue =js.getString(param);
			assertEquals(actvalue,expvalue);
	    
	}

	@Then("id is fethced")
	public void id_is_fethced() {

			res =response.then().extract().asString();
			id = js.getString("ID");
			
			System.out.println(id);
	   
	}

	@Given("Payload1 for GetBook api")
	public void payload1_for_GetBook_api() {

			request=given().log().all().header("Accept","*/*").
			queryParam("ID",id);
	  
	}

	@When("User1 calls Getbook api using http GET request")
	public void user1_calls_Getbook_api_using_http_GET_request() {
	response=request.when().get("/Library/GetBook.php");
	}

	@Given("Payload1 for DeleteBook api")
	public void payload1_for_DeleteBook_api() {
				request=given().log().all().header("Content-Type","application/json").
				body(Payload.DeleteBook1(id));
	    
	}

	
	@When("User1 calls DeleteBook api using http POST request")
	public void user1_calls_DeleteBook_api_using_http_POST_request() {
		
		response= request.when().post("/Library/DeleteBook.php");
	    
	}


	    
}


