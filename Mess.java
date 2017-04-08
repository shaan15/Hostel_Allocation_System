import java.util.*;

public class Mess{
	private int messId;
	Hostel hostel;
	Mess(int messId){
		this.messId=messId;
	}
	public int getMessId(){
		return messId;
	}
	public void setMessId(int messId){
		this.messId=messId;
	}
}