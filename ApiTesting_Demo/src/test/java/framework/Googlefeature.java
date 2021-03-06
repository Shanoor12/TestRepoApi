package framework;
import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Googlefeature {
	
	RequestSpecification reqspec;
	ResponseSpecification resspec;
	Response response;
	String res;
	JsonPath js;
	static String placeid;
	
	@Before
	
	public void CreateSpecs()
	{
		RestAssured.useRelaxedHTTPSValidation();
		reqspec =SpecificationsUtils.getRequestSpec();
		resspec =SpecificationsUtils.getResponseSpec();
	}
	
	
	
	@Given("Payload for Add Place api with")
	public void payload_for_Add_Place_api_with(io.cucumber.datatable.DataTable dataTable) {
		
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		   
		   place place = GenerateData.getObjPlacedata(data.get("name"), data.get("address"),
				   data.get("phoneno"), data.get("website"), data.get("language"));
		   
		   reqspec = given().spec(reqspec).body(place);
	    
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

	@Then("placeid is fetched")
	public void placeid_is_fetched() {
		
		res = response.getBody().asString();
		 js= new JsonPath(res);
		 placeid = js.getString("place_id");
	    
	}

	@Given("Payload for Get Place api")
	public void payload_for_Get_Place_api() {
		
		reqspec = given().spec(reqspec).queryParam("place_id", placeid);
	   
	}

	@Given("Payload for Update Place api")
	public void payload_for_Update_Place_api() {
		
		String payload = GenerateData.getUpdatePlaceData(placeid);
		reqspec = given().spec(reqspec).queryParam("place_id", placeid)
				.body(payload);
	    
	}

	@Given("Payload for Add Place api with {string}, {string}, {string}")
	public void payload_for_Add_Place_api_with(String name, String address, String phoneno) {
		
		String payload = GenerateData.getJSONPlaceData(name, address, phoneno);
		reqspec = given().spec(reqspec).body(payload);
	    
	}





}
