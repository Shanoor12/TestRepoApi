package framework;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationsUtils 
{
	 public static RequestSpecification getRequestSpec() 
	 {
		 
		 RequestSpecification reqspec = new RequestSpecBuilder()
				 .setBaseUri("https://rahulshettyacademy.com")
					.setContentType(ContentType.JSON)
					.addQueryParam("key","qaclick123")
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
