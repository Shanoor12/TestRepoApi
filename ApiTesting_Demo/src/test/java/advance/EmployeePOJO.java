package advance;
import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.List;


import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoclasses.EData;
import pojoclasses.Employee;
import pojoclasses.ResEmp;
import pojoclasses.emp;

public class EmployeePOJO {
	public static void main(String[] args) {
		
		emp emp1 =new emp();
		emp1.setName("morpheus");
		emp1.setJob("leader");
		
		RequestSpecification reqspec = new RequestSpecBuilder().log(LogDetail.ALL)
		.setBaseUri("https://reqres.in")
		.setContentType(ContentType.JSON).build();
		
		//serialization
		
		ResponseSpecification resspec= given().spec(reqspec).body(emp1)
				.expect().defaultParser(Parser.JSON);
		
	Response response=resspec.when().post("/api/users");
	assertEquals(response.getStatusCode(),201);
	
	//de-serialization
	
	ResEmp remp =response.as(ResEmp.class);
			assertEquals(remp.getName(),"morpheus");
			
			
			//Get Employee
			
			resspec = given().spec(reqspec).queryParam("page", 2)
					.expect().defaultParser(Parser.JSON);
			
			response = resspec.when().get("/api/users");
			assertEquals(response.getStatusCode(), 200);
			
			Employee employee =response.as(Employee.class);
			assertEquals(employee.getPage(),2);
			List<EData> data=employee.getData();
			
			for(EData ed :data)
			{
				System.out.println(ed.getId() +"-"+ ed.getFirst_name() +"-"+ ed.getLast_name());
			}
			
				

}

}
