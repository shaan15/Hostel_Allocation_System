import java.util.*;

public class Student{
	private String name;
	private int roll_num;
	private String password;
	private String sex;
	private String email;
	private String address;
	private String phone_num;
	private String stream;
	private int appId;
	Application app;

	Student(String n, int r, String pass, String s, String e, String a, String p,String sn, int ai){
		name=n;
		roll_num=r;
		password=pass;
		sex=s;
		email=e;
		address=a;
		phone_num=p;
		stream=s;
	}

	public String getName(){
		return name;
	}

	public int getRoll_num(){
		return roll_num;
	}
	public String getPassword(){
		return password;
	}
	public String getSex(){
		return sex;
	}
	public String getEmail(){
		return email;
	}
	public String getAddress(){
		return address;
	}
	public String getPhone_num(){
		return phone_num;
	}
	public String getStream(){
		return stream;
	}
	public int getAppId(){
		return appId;
	}

	public void setName(String name){
		this.name=name;
	}
	public void setRoll_num(int roll_num){
		this.roll_num=roll_num;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public void setPhone_num(String phone_num){
		this.phone_num=phone_num;
	}
	public void setStream(String stream){
		this.stream=stream;
	}
	public void setAppId(int appId){
		this.appId=appId;
	}

	public String toString(){
		return "Name: " + getName() + "\n" + "Roll Number : " + getRoll_num() + "\n" + "Sex : " + getSex() + "\n" + "Email : " + getEmail() + "\n" + "Address : " + getAddress() + "\n" + "Phone Number : " + getPhone_num() + "\n" + "Stream: " + getStream() + "\n" + "Application ID: " + getAppId() + "\n";
	}


}