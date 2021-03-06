package util;

public class Payload {
	
	public static String BookerApiPayload()
	{
		String Book = "{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		return Book ;
		
	}
	public static String EmployeePayload() 
	{
		String Emp= "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
				
		return Emp;
		
		
	}
	
	public static String GoglePayload()
	{
		String Addplace="{\r\n"
				+ " \"location\": {\r\n"
				+ " \"lat\": -38.383494,\r\n"
				+ " \"lng\": 33.427362\r\n"
				+ " },\r\n"
				+ " \"accuracy\": 50,\r\n"
				+ " \"name\": \"Frontline house\",\r\n"
				+ " \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ " \"address\": \"29, side layout, cohen 09\",\r\n"
				+ " \"types\": [\r\n"
				+ " \"shoe park\",\r\n"
				+ " \"shop\"\r\n"
				+ " ],\r\n"
				+ " \"website\": \"http://google.com\",\r\n"
				+ " \"language\": \"French-IN\"\r\n"
				+ "} \r\n"
				+ "";
		return Addplace;
	}
	
	public static String UpdatePayload(String placeid)
	{
		return " {\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\"70 winter walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
	}
	
	public static String DeletePayload(String placeid)
	{
		return "{\r\n"
                + "\"place_id\":\""+placeid+"\"\r\n"
                + "}";
	}
	
	public static String Auth()
	{
		return "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
	}
	
	public static String UpadateBooking()
	{
		return "{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		
	}
	
	public static String DeleteBooking()
	{
		return "{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		
		
	}
	
	public static String AddBook1(String isbn, String aisle)
	{
		return "{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}";
	}
	
	public static String DeleteBook1(String id)
	{
		return "{\r\n"
				+ "\"ID\" : \""+id+"\"\r\n"
				+ " }";
	}
	
	
	

}
