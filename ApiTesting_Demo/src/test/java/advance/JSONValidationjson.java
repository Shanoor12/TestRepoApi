package advance;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import io.restassured.path.json.JsonPath;
import util.ComplexJson;

public class JSONValidationjson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double price=0.0;
		String response= ComplexJson.GetStoreDetails();
		JsonPath js= new JsonPath(response);
		
		List<String> titles= new  ArrayList<String>();
		
		//Book titles with category fiction
		
		int cnt = js.getInt("store.book.size()");
		
		for(int i=0; i<cnt; i++)
		{
			if(js.getString("store.book["+i+"].category").equals("fiction"))
			{
				titles.add(js.getString("store.book["+i+"].title"));
			}
			System.out.println(titles);
		}
		
		//price
		for(int i=0;i<cnt;i++)
		{
			price=js.getDouble("store.book["+i+"].price");
		}
		System.out.println(price);
		
		//Details of book with title the lord of the Rings
		for(int i=0; i<cnt; i++)
		{
			if(js.getString("store.book["+i+"].title").equals("the lord of the Rings"))
			{
				System.out.println(js.getString("srore.book["+i+"].author"));
				System.out.println(js.getString("srore.book["+i+"].price"));
				System.out.println(js.getString("srore.book["+i+"].category"));
			}
		}
		
		System.out.println("=========Second json=========");
		
		List<String> ctitles =new ArrayList<String>();
		int totalprice=0;
		response= ComplexJson.CourseDetails();
		 js= new JsonPath(response);
		//no of course
		 cnt=js.getInt("courses.size()");
		 
		//purchase Amount
		 int purchaseamount=js.getInt("dashboard.purchaseAmount");
			System.out.println(purchaseamount);
			
			//print all course titles
			for(int i=0; i<cnt; i++)
			{
				ctitles.add(js.getString("courses["+i+"].title"));
				
			}
			System.out.println(ctitles);
			
			//no of copies sold byRPA Course
			
			for(int i=0; i<cnt; i++)
			{
				if(js.getString("courses["+i+"].title").equals("RPA"))
				{
				System.out.println(js.getString("courses["+i+"].copies"));
				}
			}
				
			//verify if sum of all Course price matches with Purchase amount

				for(int i=0;i<cnt;i++)
				{
					totalprice+=js.getInt("courses["+i+"].price");
				}
				assertEquals(totalprice, purchaseamount);
				
				
				System.out.println("=========Third json=========");
				
				List<String> Employee =new ArrayList<String>();
				
				response= ComplexJson.GetEmpDetails();
				 js= new JsonPath(response);
				 
				 //No of employees returned
				 cnt=js.getInt("data.size()");
				 System.out.println(cnt);
				 
				// Names of all employees
				 
				List<String> names=(js.getList("data.employee_name")); 
				 System.out.println(names);
				 
				 // Salary of Garrett Winters
				 for(int i=0;i<cnt;i++)
				 {
					if((js.getString("data["+i+"].employee_name").equals("Garrett Winters")))
						
						
						{
						System.out.println(js.getString("data["+i+"].employee_salary"));
						}
					
				 }
				 
				 //Employee and There ages
				 
				 for(int i=0;i<cnt;i++)
				 {
					System.out.println(js.getString("data["+i+"].employee_name")); 
					System.out.println(js.getString("data["+i+"].employee_age"));
				 }
				 
				 
				 
				 
				 
				 
				 
				 
				


}
				
		
		
		
	}

