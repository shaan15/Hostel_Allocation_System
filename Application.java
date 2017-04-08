import java.util.*;

public class Application{
	private int appId;
	private String response;
	Room room;
	Application(int appId, String response){
		this.appId=appId;
		this.response=response;
	}

	public int getAppId(){
		return appId;
	}
	public void setAppId(int appId){
		this.appId=appId;
	}

	public String getResponse(){
		return response;
	}
	public void setResponse(String response){
		this.response=response;
	}
}