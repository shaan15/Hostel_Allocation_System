import java.util.*;

public class Room{
	private int roomid;
	private int floor;
	private String description;
	private String status;
	RoomType type;
	Hostel hostel;
	Mess mess;
	ArrayList<Applications> app_list;

	Hostel(int i, int f, String d, String s){
		roomid=id;
		floor=f;
		description=d;
		status=s;
	}

	public String getDescription(){
		return description;
	}

	public int getRoomid(){
		return roomid;
	}

	public int getFloor(){
		return floor;
	}

	public String getStatus(){
		return status;
	}

	public void setDescription(String description){
		this.description=description;
	}

	public void setRoomid(int roomid){
		this.roomid=roomid;
	}

	public void setFloor(int floor){
		this.floor=floor;
	}

	public void setStatus(String status){
		this.status=status;
	}
}