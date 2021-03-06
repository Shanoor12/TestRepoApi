package framework;

public enum RequestType {
	
	ADDPLACE("/maps/api/place/add/json"),
	GETPLACE("/maps/api/place/get/json"),
	UPDATEPLACE("/maps/api/place/update/json"),
	DELETEPLACE("/maps/api/place/delete/json");
	
	private String resource;
	
	private RequestType(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
