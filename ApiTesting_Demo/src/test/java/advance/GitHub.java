package advance;
import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
public class GitHub {
	

	public static void main(String[] args) {
		
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI ="https://api.github.com";
		
		//create repo
		
		given().log().all()
		.auth().oauth2("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")
		
		.body("{\"name\" : \"TestRepoApi2\"}").
		when().post("/user/repos").
		then().log().all().assertThat().statusCode(201);
		
		
		//list repo
		given().log().all()
		.auth().oauth2("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")
		.pathParam("username", "Shanoor12")
		.when().get("/users/{username}/repos")
		.then().log().all().assertThat().statusCode(200);
		
		
	}
	

}
