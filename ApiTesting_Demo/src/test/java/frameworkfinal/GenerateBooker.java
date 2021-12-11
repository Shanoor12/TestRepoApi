package frameworkfinal;


public class GenerateBooker {
	
	
	
	public static BookingDetails getObjbookingDetails(String firstname, String lastname, String totalprice,
			String depositpaid,String additionalneeds)
	{
		Bookingdates bkgdates=new Bookingdates();
		BookingDetails bkgdetails =new BookingDetails();
		bkgdetails.setFirstname(firstname);
		bkgdetails.setLastname(lastname);
		bkgdetails.setTotalprice(111);
		bkgdetails.setDepositpaid(true);
		bkgdetails.setAdditionalneeds("Breakfast");
		bkgdates.setCheckin("2018-01-01");
		bkgdates.setCheckout("2019-01-01");
		
		
		return bkgdetails;
		
	}
	
	public static String CreateBook() 
	{
		return "{\r\n"
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
		
	}
	
	public static String UpdateBook() {
		
		return"{\r\n"
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
	
	

}
