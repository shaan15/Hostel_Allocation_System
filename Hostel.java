import java.util.*;

public class Hostel{
	private String hname;
	private int hid;
	private String phone_num;

	Hostel(String h, int i, String p){
		hname=h;
		hid=i;
		phone_num=p;
	}

	public String getHname(){
		return hname;
	}

	public int getHid(){
		return hid;
	}

	public String getPhone_num(){
		return phone_num;
	}

	public void setHname(String hname){
		this.hname=hname;
	}

	public void setHid(int hid){
		this.hid=hid;
	}

	public void setPhone_num(String phone_num){
		this.phone_num=phone_num;
	}
}