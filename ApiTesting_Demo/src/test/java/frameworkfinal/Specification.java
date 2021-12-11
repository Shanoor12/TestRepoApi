package frameworkfinal;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
	
	
	public static RequestSpecification getRequestSpec() 
	 {
		 
		 RequestSpecification reqspec = new RequestSpecBuilder()
				 .setBaseUri("https://restful-booker.herokuapp.com")
					.setContentType(ContentType.JSON)
					.build();
		 return reqspec; 
		
	}
	 
	 public static ResponseSpecification getResponseSpec() 
	 
	 {
		 ResponseSpecification resspec= new ResponseSpecBuilder()
				 .expectStatusCode(200)
					.expectContentType(ContentType.JSON).build();
		 return resspec;
	}
}
