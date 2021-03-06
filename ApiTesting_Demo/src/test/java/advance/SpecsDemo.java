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

public class SpecsDemo {
	
	public static void main(String[] args) {
		
		//Create a common spec which can be re-used by multiple requests
		
		RequestSpecification reqspec=new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON)
				.addQueryParam("key","qaclick123")
				.build();
		
		//Create Response specs
		
		ResponseSpecification resspec= new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		
		
		//send the spec in the req
		
		String response =given().log().all().spec(reqspec).body(Payload.GoglePayload())
						.when().post("/maps/api/place/add/json")
						.then().log().all().spec(resspec).extract().asString();
						assertEquals(Commons.getJSON(response, "status"), "OK");
						
						String placeid=Commons.getJSON(response, "place_id");
						
						response =given().spec(reqspec).queryParam("place_id", placeid)
								.when().get("/maps/api/place/get/json")
								.then().log().all().spec(resspec).extract().asString();
						assertEquals(Commons.getJSON(response, "name"), "Frontline house");
						
						response =given().spec(reqspec).queryParam("place_id", placeid)
								.body(Payload.UpdatePayload(placeid))
								.when().put("/maps/api/place/update/json")
								.then().log().all().spec(resspec).extract().asString();
						assertEquals(Commons.getJSON(response, "msg"), "Address successfully updated");
						
						given().spec(reqspec).body(Payload.DeletePayload(placeid))
						.when().delete("/maps/api/place/delete/json")
						.then().log().all().spec(resspec);
		
		
		
		
						
						
						
						
		
	}

}
