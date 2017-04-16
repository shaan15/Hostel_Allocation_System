import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class DetailsPanel extends JPanel{
	String un;
	Connection con=null;
	public DetailsPanel(String un){
		super();
		createDetailsPanel(un);
		this.un=un;
	}
	public void createDetailsPanel(String un){
		this.setSize(1000,1500);
		this.setVisible(true);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,600,50));
		JTextField roomID = new JTextField(10); 
		JButton submit = new JButton("Submit");
		JButton back = new JButton("Back");
		//submit.setSize(150,40); submit.setFont(new Font("Arial",Font.PLAIN,30));
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("Room ID: ")); box1.add(Box.createHorizontalStrut(10)); box1.add(roomID);
		this.add(box1);
		this.add(submit);
		this.add(back);
	
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String rid = roomID.getText();
				
				SystemHAS.frame.setContentPane(new SubmittedPanel(rid));
			}
		});
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if((SystemHAS.type_1_login).equals("student")){
					SystemHAS.frame.setContentPane(new StudentLoggedIn(un));
				}
				else if((SystemHAS.type_1_login).equals("admin")){
					SystemHAS.frame.setContentPane(new AdminLoggedIn());
				}
			}
		});
	}
	class SubmittedPanel extends JPanel{
		public SubmittedPanel(String rid){
			super();
			createSubmittedPanel(rid);
		}
		public void createSubmittedPanel(String rid){
			this.setSize(1000,1500);
			this.setVisible(true);
			this.setLayout(new FlowLayout(FlowLayout.CENTER,600,50));
			
			JTextField hostel = new JTextField(10); hostel.setEditable(false);
			JTextField floor = new JTextField(10); floor.setEditable(false);
			JTextField mess = new JTextField(10); mess.setEditable(false);
			JTextField type = new JTextField(10); type.setEditable(false);
			JTextField price = new JTextField(10); price.setEditable(false);
			JTextField description = new JTextField(20); description.setEditable(false);
			JTextField status = new JTextField(10); status.setEditable(false);
			ResultSet rs;
			try{
				Class.forName(SystemHAS.DRIVER);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_allocation_system",SystemHAS.USER,SystemHAS.PASSWORD); 
				PreparedStatement ps = con.prepareStatement("select hid,floor,type,description,status from room where roomid=?");
				ps.setInt(1, Integer.parseInt(rid));
				rs=ps.executeQuery();
				if(!rs.next()){

					JOptionPane.showMessageDialog(null,"This room does not exist.","No Room",JOptionPane.WARNING_MESSAGE);

					if(Integer.parseInt(un)==0)
						SystemHAS.frame.setContentPane(new AdminLoggedIn());
					else{
						SystemHAS.frame.setContentPane(new StudentLoggedIn(un));
					}
					
					return;
					}
				
					int room_type = rs.getInt(3);
					int room_floor = rs.getInt(2);
					floor.setText(Integer.toString(rs.getInt(2)));
					type.setText(Integer.toString(rs.getInt(3))+" people sharing");
					description.setText(rs.getString(4));
					status.setText(rs.getString(5));
					int hid=rs.getInt(1);
					rs.close();
					ps.close();
					ps=con.prepareStatement("select hname from hostel where hid=?");
					ps.setInt(1, hid);
					rs=ps.executeQuery();
					if(rs.next())
						hostel.setText(rs.getString(1));
					rs.close();
					ps.close();
					ps=con.prepareStatement("select price from room_type where type=?");
					ps.setInt(1, room_type);
					rs=ps.executeQuery();
					if(rs.next()){
						price.setText(Double.toString(rs.getDouble(1)));
					}
					rs.close();
					ps.close();
					ps=con.prepareStatement("select messid from mess where floor=?");
					ps.setInt(1, room_floor);
					rs=ps.executeQuery();
					if(rs.next())
						mess.setText(Integer.toString(rs.getInt(1)));
					rs.close();
					ps.close();
					
				
			}catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } 
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
			Box box1 = Box.createHorizontalBox(); Box box2 = Box.createHorizontalBox(); Box box3 = Box.createHorizontalBox(); Box box4 =Box.createHorizontalBox(); Box box5 = Box.createHorizontalBox(); Box box7 = Box.createHorizontalBox(); Box box8 = Box.createHorizontalBox(); Box box6 = Box.createVerticalBox(); 
			box1.add(new JLabel("Hostel: ")); box1.add(Box.createHorizontalStrut(10)); box1.add(hostel);
			box2.add(new JLabel("Floor: ")); box2.add(Box.createHorizontalStrut(10)); box2.add(floor);
			box3.add(new JLabel("Mess: ")); box3.add(Box.createHorizontalStrut(10)); box3.add(mess);
			box4.add(new JLabel("Type: ")); box4.add(Box.createHorizontalStrut(10)); box4.add(type);
			box5.add(new JLabel("Price: ")); box5.add(Box.createHorizontalStrut(10)); box5.add(price);
			box8.add(new JLabel("Description: ")); box8.add(Box.createHorizontalStrut(10)); box8.add(description);
			box7.add(new JLabel("Status: ")); box7.add(Box.createHorizontalStrut(10)); box7.add(status);
			box6.add(box1); box6.add(Box.createVerticalStrut(10));box6.add(box2); box6.add(Box.createVerticalStrut(10));box6.add(box3); box6.add(Box.createVerticalStrut(10));box6.add(box4); box6.add(Box.createVerticalStrut(10));box6.add(box5); box6.add(Box.createVerticalStrut(10));box6.add(box7); box6.add(Box.createVerticalStrut(10));box6.add(box7);
			this.add(box6);
			JButton back = new JButton("Back");
			back.setSize(200,80);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if((SystemHAS.type_1_login).equals("student")){
						SystemHAS.frame.setContentPane(new StudentLoggedIn(un));
					}
					else if((SystemHAS.type_1_login).equals("admin")){
						SystemHAS.frame.setContentPane(new AdminLoggedIn());
					}
				}
			});
			this.add(back);
			//set text using sql
		}
	}
}