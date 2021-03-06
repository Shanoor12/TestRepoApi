package advance;

import static org.testng.Assert.assertEquals;

import java.util.List;

import io.restassured.path.json.JsonPath;
import util.ComplexJson;

public class JSONValidationgroovy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String response= ComplexJson.GetStoreDetails();
		JsonPath js= new JsonPath(response);
		
		
		List<String> titles= js.getList("store.book.findAll{it.category=='fiction'}.title");
		System.out.println(titles);
		
		String name =js.getString("store.book.find{it}.title");
		System.out.println(name);
			
				
				//Sum of prices, min max price
				
				double totalprice= js.getDouble("store.book.price.sum()");
				System.out.println(totalprice);
				double minprice= js.getDouble("store.book.price.min()");
				System.out.println(minprice);
				double maxprice= js.getDouble("store.book.price.max()");
				System.out.println(maxprice);
				
				//Details of book The lord of the ring
				
				String author= js.getString("store.book.find{it.title=='The Lord of the Rings'}.author");
				System.out.println(author);
				
				float price= js.getFloat("store.book.find{it.title=='The Lord of the Rings'}.price");
				System.out.println(price);
				
				String category= js.getString("store.book.find{it.title=='The Lord of the Rings'}.category");
						System.out.println(category);
				
						
				System.out.println("=========Second json=========");
				
				
				 response= ComplexJson.CourseDetails();
				 js= new JsonPath(response);
				
				//no of courses
				System.out.println(js.getInt("courses.size()"));
				//purchase amount
				int purchaseamount=js.getInt("dashboard.purchaseAmount");
				System.out.println(purchaseamount);
				//print all course titles
				titles =js.getList("courses.findAll{it}.title");
				System.out.println(titles);
				//no of copies sold by RPA courses
				int copies =js.getInt("courses.find{it.title=='RPA'}.copies");
				System.out.println(copies);
				//Verify if sum of all course prices matches with Purchase Amount
				int totalamount =js.getInt("courses.price.sum()");
				assertEquals(totalamount,  purchaseamount);
				
				System.out.println("=========Third json=========");
				
				
				 response= ComplexJson.GetEmpDetails();
				 js= new JsonPath(response);
				 
				 System.out.println(js.getInt("data.employee_name.size()"));
				 
				 //Names of all employees
				List<String> Employeename= js.getList("data.findAll{it}.employee_name");
				System.out.println(Employeename);
				
				//salary of granitee
				
				long salary= js.getLong("data.find{it.employee_name=='Garrett Winters'}.employee_salary");
				System.out.println(salary);
				
				
				String Employeenameandage= js.getString("data.find{it.employee_name=='Garrett Winters'}.employee_age");
				System.out.println(Employeenameandage);
				
				
				
				
				 
				
				
				
				
				
		

	}

}
