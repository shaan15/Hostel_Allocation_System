import java.util.*;

public class Admin{
	private String name;
	private int id;
	private String phone_num;
	Admin(int n,int i,int p){
		name=n;
		id=i;
		phone_num=p;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getPhone_num(){
		return phone_num;
	}

	public void setName(String name){
		this.name=name;
	}

	public void setId(int id){
		this.id=id;
	}

	public void setPhone_num(String phone_num){
		this.phone_num=phone_num;
	}

	public String toString(){
		return "Name: " + getName() + "\n" + "ID: " + getId() + "\n" + "Phone Number: " + getPhone_num() + "\n";
	}
}