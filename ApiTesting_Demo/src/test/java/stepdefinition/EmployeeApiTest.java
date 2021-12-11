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


public class EmployeeApiTest {
	
	RequestSpecification request;
	Response response;
	String res;
	static String id;
	JsonPath js;
	
	@Before
	public void initialize123()
	{
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI= "https://reqres.in/";
	}
	
	
	@Given("Payload for CreateEmp api")
	public void payload_for_CreateEmp_api() {
		request=given().log().all().header("Content-Type","application/json").
		body(Payload.EmployeePayload());
	    
	}

	@When("User calls Create api using http POST request")
	public void user_calls_Create_api_using_http_POST_request() {
		response=request.when().post("/api/users");
	    
	}

	@Then("Status2 code is {int}")
	public void status2_code_is(int expcode) {
		response.then().log().all().assertThat().statusCode(expcode);
		
	    
	}
	
	@Then("{string} in the response is like {string}")
	public void in_the_response_is_like(String param, String expvalue) {
		res =response.then().extract().asString();
		js =new JsonPath(res);
		String actvalue =js.getString(param);
		assertEquals(actvalue,expvalue);
	    
	}

	@Given("Payload for UpdateEmp api")
	public void payload_for_UpdateEmp_api() {
		
		request=given().log().all().header("Content-Type","application/json").pathParam("id", 2).
				body("{\r\n"
						+ "    \"name\": \"shanoor\",\r\n"
						+ "    \"job\": \"zion resident\"\r\n"
						+ "}");
		
		
	    
	}

	@When("User calls Update api using http PUT request")
	public void user_calls_Update_api_using_http_PUT_request() {
		response=request.when().put("/api/users/{id}");
	    
	}

	@Given("Payload for SingleUserEmp api")
	public void payload_for_SingleUserEmp_api() {
		
		request=given().log().all().header("Content-Type","application/json").pathParam("id", 2);
	    
	}

	@When("User calls SingleUserEmp api using http GET request")
	public void user_calls_SingleUserEmp_api_using_http_GET_request() {
	
		response=request.when().get("/api/users/{id}");
	
	}


	@Given("Payload for DeleteEmp api")
	public void payload_for_DeleteEmp_api() {
		
		request=given().log().all().header("Content-Type","application/json").pathParam("id", 2);
	    
	}

	@When("User calls DeleteE api using http DELETE request")
	public void user_calls_DeleteE_api_using_http_DELETE_request() {
		
		response=request.when().delete("/api/users/{id}");
	  
	}

}
