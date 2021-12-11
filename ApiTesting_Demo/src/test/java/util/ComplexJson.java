package util;

public class ComplexJson {
	
	public static String GetStoreDetails() {
		
		return "{  \r\n"
				+ "   \"store\":{  \r\n"
				+ "      \"book\":[  \r\n"
				+ "         {  \r\n"
				+ "            \"author\":\"Nigel Rees\",\r\n"
				+ "            \"category\":\"reference\",\r\n"
				+ "            \"price\":8.95,\r\n"
				+ "            \"title\":\"Sayings of the Century\"\r\n"
				+ "         },\r\n"
				+ "         {  \r\n"
				+ "            \"author\":\"Evelyn Waugh\",\r\n"
				+ "            \"category\":\"fiction\",\r\n"
				+ "            \"price\":12.99,\r\n"
				+ "            \"title\":\"Sword of Honour\"\r\n"
				+ "         },\r\n"
				+ "         {  \r\n"
				+ "            \"author\":\"Herman Melville\",\r\n"
				+ "            \"category\":\"fiction\",\r\n"
				+ "            \"isbn\":\"0-553-21311-3\",\r\n"
				+ "            \"price\":8.99,\r\n"
				+ "            \"title\":\"Moby Dick\"\r\n"
				+ "         },\r\n"
				+ "         {  \r\n"
				+ "            \"author\":\"J. R. R. Tolkien\",\r\n"
				+ "            \"category\":\"fiction\",\r\n"
				+ "            \"isbn\":\"0-395-19395-8\",\r\n"
				+ "            \"price\":22.99,\r\n"
				+ "            \"title\":\"The Lord of the Rings\"\r\n"
				+ "         }\r\n"
				+ "      ]\r\n"
				+ "   }\r\n"
				+ "}";
		
	}
	
	public static String CourseDetails()
	{
		return "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 135,\r\n"
				+ "\"website\": \"testapi.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}";
	}
	
	public static String GetEmpDetails() {
		
		return "{\r\n"
				+ "  \"status\": \"success\",\r\n"
				+ "  \"data\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": \"1\",\r\n"
				+ "      \"employee_name\": \"Tiger Nixon\",\r\n"
				+ "      \"employee_salary\": \"320800\",\r\n"
				+ "      \"employee_age\": \"61\",\r\n"
				+ "      \"profile_image\": \"\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"id\": \"2\",\r\n"
				+ "      \"employee_name\": \"Garrett Winters\",\r\n"
				+ "      \"employee_salary\": \"170750\",\r\n"
				+ "      \"employee_age\": \"63\",\r\n"
				+ "      \"profile_image\": \"\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"id\": \"3\",\r\n"
				+ "      \"employee_name\": \"Ashton Cox\",\r\n"
				+ "      \"employee_salary\": \"86000\",\r\n"
				+ "      \"employee_age\": \"66\",\r\n"
				+ "      \"profile_image\": \"\"\r\n"
				+ "    }\r\n"
				+ "    ]\r\n"
				+ "}";		
	}

}
