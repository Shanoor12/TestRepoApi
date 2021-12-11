package advance;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoclasses.Getplace;
import pojoclasses.Location;
import pojoclasses.ResPlace;
import pojoclasses.place;
import util.Payload;

public class GoogleApiPOJO {
	
	public static void main(String[] args) {
		
		Location loc =new Location();
		loc.setLat(-38.383494);
		loc.setLat(33.427362);
		
		place place=new place();
		
		place.setLocation(loc);
		place.setAccuracy(50);
		place.setName("Frontline house");
		place.setPhone_number("(+91) 983 893 3937");
		place.setAddress("29, side layout, cohen 09");
		
		List<String> type =new ArrayList<String>();
		
		type.add("shpo park");
		type.add("shop");
		place.setTypes(type);
		
		place.setWebsite("http://google.com");
		place.setLanguage("French-IN");
		
		
		RequestSpecification reqspec=new RequestSpecBuilder().log(LogDetail.ALL)
				.setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON)
				.addQueryParam("key","qaclick123")
				.build();
		//passing java object as request payload(JSON)
		
		//reqspec= given().spec(reqspec).body(place);
		
		ResponseSpecification resspec = given().spec(reqspec).body(place).expect().defaultParser(Parser.JSON);
		
		//response is recieved in json
		
		Response response =resspec.when().post("/maps/api/place/add/json");
		assertEquals(response.statusCode(), 200);
		
		//convert json response into java object
		ResPlace rplace =response.as(ResPlace.class);
		
		String placeid =rplace.getPlace_id();
		System.out.println(placeid);
		
		
		//get place
		
		resspec = given().spec(reqspec).queryParam("place_id", placeid).expect().defaultParser(Parser.JSON);
        //get response
        response = resspec.when().get("/maps/api/place/get/json");   
        System.out.println(response.getBody().asString());
        //De -serialize the response
        Getplace getplace = response.as(Getplace.class); 
        
        assertEquals(getplace.getName(), "Frontline house");
        
        
		
		
	}

}
