package framework;


 public class GenerateData {
	
	public static place getObjPlacedata(String name, String address, String phoneno, String website, String language)
	{
		place place=new place();
		Location loc =new Location();
		loc.setLat(-38.383494);
		loc.setLat(33.427362);
		place.setLocation(loc);
		place.setAccuracy(50);
		place.setName(name);
		place.setPhone_number(phoneno);
		place.setAddress(address);
		place.setLanguage(language);
		place.setWebsite(website);
		return place;
	}
	
	public static String getJSONPlaceData(String name, String address, String phoneno)
	{
		String Addplace="{\r\n"
				+ " \"location\": {\r\n"
				+ " \"lat\": -38.383494,\r\n"
				+ " \"lng\": 33.427362\r\n"
				+ " },\r\n"
				+ " \"accuracy\": 50,\r\n"
				+ " \"name\": \""+name+"\",\r\n"
				+ " \"phone_number\": \""+address+"\",\r\n"
				+ " \"address\": \"\",\r\n"
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
	
	public static String getUpdatePlaceData(String placeid)
	{
		return " { \r\n"
				+ "\"place_id\":\""+placeid+"\", \r\n"
				+ "\"address\":\"70 winter walk, USA\", \r\n"
				+ "\"key\":\"qaclick123\" \r\n"
				+ "} \r\n"
				+ "";
	}

}
