import java.util.*;

public class RoomType{
	private int type;
	private String price;
	RoomType(int t,int p){
		type=t;
		price=p;
	}

	public int getType(){
		return type;
	}
	public String getPrice(){
		return price;
	}
	public void setType(int type){
		this.type=type;
	}
	public void setPrice(String price){
		this.price=price;
	}
}