package frameworkfinal;

public enum RequestType {
	
	ADDBOOKING("/booking"),
	GETBOOKING("/booking/{id}"),
	UPDATEBOOKING("/booking/{id}"),
	DELETEBOOKING("/booking/{id}");
	
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
