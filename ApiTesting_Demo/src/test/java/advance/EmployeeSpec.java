package advance;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import util.Commons;
import util.Payload;

public class EmployeeSpec {

	public static void main(String[] args) {
		
		//Create a common spec which can be re-used by multiple requests
		
				RequestSpecification reqspec=new RequestSpecBuilder()
						.setBaseUri("https://reqres.in")
						.setContentType(ContentType.JSON)
//						.addQueryParam("page","2")
						
						.build();
				
				//Create Response specs
				
				ResponseSpecification resspec= new ResponseSpecBuilder()
						.expectStatusCode(200)
						.expectContentType(ContentType.JSON).build();
				
				//create employee
				
				//send the spec in the req
				
				String response =given().log().all().spec(reqspec).body("{\r\n"
						+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
						+ "    \"password\": \"pistol\"\r\n"
						+ "}")
								.when().post("/api/register")
								.then().log().all().extract().asString();
								assertEquals(Commons.getJSON(response, "id"), "4");
								
								String token=Commons.getJSON(response, "token");
								
				String response1 =given().log().all().spec(reqspec).body("{\r\n"
										+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
										+ "    \"password\": \"cityslicka\"\r\n"
										+ "}")
									.when().post("/api/login")
									.then().log().all().spec(resspec).extract().asString();
									assertEquals(Commons.getJSON(response1, "token"), "QpwL5tke4Pnpja7X4");
												
									String token1=Commons.getJSON(response1, "token");
									
							String response2 =given().log().all().spec(reqspec).pathParam("id", 2).body("{\r\n"
											+ "    \"name\": \"morpheus\",\r\n"
											+ "    \"job\": \"zion resident\"\r\n"
											+ "}")
										.when().put("/api/users/{id}")
										.then().log().all().spec(resspec).extract().asString();
										assertEquals(Commons.getJSON(response2, "name"), "morpheus");
										
							String response3 =given().log().all().spec(reqspec).pathParam("id", 1)
											.when().get("/api/users/{id}")
											.then().log().all().spec(resspec).extract().asString();
											assertEquals(Commons.getJSON(response3, "data.id"), "1");			
										
										
										
													
										
				
												
								
								
								
								
								
		
		
		

	}

}
