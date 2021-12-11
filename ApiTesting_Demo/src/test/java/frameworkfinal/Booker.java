package frameworkfinal;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.Map;

import framework.GenerateData;
import framework.RequestType;
import framework.SpecificationsUtils;
import framework.place;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Booker {
	
	RequestSpecification reqspec;
	ResponseSpecification resspec;
	Response response;
	String res;
	JsonPath js;
	static String i;
	
	@Before
	
	public void CreateSpecs()
	{
		RestAssured.useRelaxedHTTPSValidation();
		reqspec =SpecificationsUtils.getRequestSpec();
		resspec =SpecificationsUtils.getResponseSpec();
	}
	
	@Given("Payload for Add Booking api with")
	public void payload_for_Add_Booking_api_with(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		   
		BookingDetails Book = GenerateBooker.getObjbookingDetails(data.get("firstname"), data.get("lastname"),
				   data.get("totalprice"), data.get("depositpaid"), data.get("additionalneeds"));
		   
		   reqspec = given().spec(reqspec).body(Book);
		
		
	    
	}

	@When("User calls {string} api using http {string} request")
	public void user_calls_api_using_http_request(String resource, String httpmethod) {
		
		RequestType reqtype=RequestType.valueOf(resource);
		String resourcepath = reqtype.getResource();
		switch (httpmethod) {
		case "POST":
			response = reqspec.when().post(resourcepath);
			break;
		case "GET":
			response = reqspec.when().get(resourcepath);
			break;
		case "PUT":
			response = reqspec.when().put(resourcepath);
			break;
		case "DELETE":
			response = reqspec.when().delete(resourcepath);
			break;
		default:
			break;
		}
	   
	}

	@Then("Status code is {int}")
	public void status_code_is(int expstatuscode) {
	    
		response.then().log().all()
		 .assertThat().statusCode(expstatuscode);
	    
	}

	@Then("{string} in response is {string}")
	public void in_response_is(String param, String expvalue) {
		
		res = response.getBody().asString();
		   js= new JsonPath(res);
		   String actvalue = js.getString(param);
		   assertEquals(actvalue, expvalue);
	    
	}

	@Given("Payload for Get Booking By Id api")
	public void payload_for_Get_Booking_By_Id_api() {
		
		reqspec = given().spec(reqspec).pathParam("id", 1);
	    
	}

	@Given("Payload for Update Booking api")
	public void payload_for_Update_Booking_api() {
		
		String payload = GenerateBooker.UpdateBook();
		reqspec = given().spec(reqspec).queryParam("id", 1)
				.body(payload);
	   
	}




}
