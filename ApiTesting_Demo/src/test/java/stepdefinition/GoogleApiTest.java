package stepdefinition;
import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.given;



import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.Payload;


public class GoogleApiTest {
	
	RequestSpecification request;
	Response response;
	String res;
	static String placeid;
	JsonPath js;
	
	@Before
	
	public void initialize()
	{
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI="https://rahulshettyacademy.com";
	}
	
	
	@Given("Payload for Add Place api")
	public void payload_for_Add_Place_api() {
		request = given().log().all().header("Content-Type","application/json").
				queryParam("key", "qaclick123").
				body(Payload.GoglePayload());
	    
	}

	@When("User calls Add Place api using http POST request")
	public void user_calls_Add_Place_api_using_http_POST_request() {
		
		response= request.when().post("/maps/api/place/add/json");
	    
	}

	@Then("Status code is {int}")
	public void status_code_is(int expstatuscode) {
		response.then().log().all().
		assertThat().statusCode(expstatuscode);
	}

	@Then("{string} in response is {string}")
	public void in_response_is(String param, String expvalue) {
		
		res =response.then().extract().asString();
		js =new JsonPath(res);
		String actvalue =js.getString(param);
		assertEquals(actvalue,expvalue);
	    
	}

	@Then("placeid is fetched")
	public void placeid_is_fetched() {
		
		res =response.then().extract().asString();
		placeid = js.getString("place_id");
	    
	}

	@Given("Payload for Get place api")
	public void payload_for_Get_place_api() {
		
		request = given().log().all().header("content-type", "application/json")
				.queryParam("key", "qaclick123")
				.queryParam("place_id", placeid);
	    
	}

	@When("User calls Get Place api using http GET request")
	public void user_calls_Get_Place_api_using_http_GET_request() {
		
		response =request.when().get("/maps/api/place/get/json");
	    
	}

	@Given("Payload for Update place api")
	public void payload_for_Update_place_api() {
		
		request= given().log().all().header("content-type", "application/json")
				.queryParam("key", "qaclick123")
				.queryParam("place_id", placeid)
				.body(Payload.UpdatePayload(placeid));
	    
	}

	@When("User calls Get Place api using http PUT request")
	public void user_calls_Get_Place_api_using_http_PUT_request() {
		
		response = request.when().put("/maps/api/place/update/json");
	    
	}

	@Given("Payload for Delete place api")
	public void payload_for_Delete_place_api() {
		
		request= given().log().all().header("content-type","application/json")
				.queryParam("key", "qaclick123")
				.body(Payload.DeletePayload(placeid));
	    
	}

	@When("User calls Get Place api using http DELETE request")
	public void user_calls_Get_Place_api_using_http_DELETE_request() {
		
		response= request.when().delete("/maps/api/place/delete/json");
	   
	}
	
	
	    
	

}
