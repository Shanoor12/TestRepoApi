package util;

import io.restassured.path.json.JsonPath;

public class Commons {
	
	
	public static String getJSON(String response, String path)
	{
		JsonPath js= new JsonPath(response);
		return js.getString(path);
	}

}
