import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
public class StudentLoggedIn extends JPanel{
	Connection con=null;
	String un;
	int application_id=0;
	public  StudentLoggedIn(String ID){
		super();
		createStudentLoggedIn(ID);
		this.un=ID;
	}
	public Box createStructure(Component ID, Component IDField, Component name, Component nameField, Component sex, Component sexField, Component email, Component emailField, Component address, Component addressField, Component phone_number, Component phoneField, Component stream, Component streamField){
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		Box box3 = Box.createHorizontalBox();
		Box box4 = Box.createHorizontalBox();
		Box box7 = Box.createVerticalBox();
		Box box8 = Box.createVerticalBox();
		Box box9 = Box.createHorizontalBox();
		box7.add(Box.createVerticalStrut(40)); box8.add(Box.createVerticalStrut(40));
		box7.add(ID); box7.add(Box.createVerticalStrut(20));
		box7.add(name); box7.add(Box.createVerticalStrut(20));
		box7.add(sex);box7.add(Box.createVerticalStrut(20));
		box7.add(email);box7.add(Box.createVerticalStrut(20));
		box7.add(address);box7.add(Box.createVerticalStrut(20));
		box7.add(phone_number);box7.add(Box.createVerticalStrut(20));
		box7.add(stream);box7.add(Box.createVerticalStrut(20));
		box8.add(IDField); box8.add(Box.createVerticalStrut(20));
		box8.add(nameField); box8.add(Box.createVerticalStrut(20));
		box8.add(sexField);box8.add(Box.createVerticalStrut(20));
		box8.add(emailField);box8.add(Box.createVerticalStrut(20));
		box8.add(addressField);box8.add(Box.createVerticalStrut(20));
		box8.add(phoneField);box8.add(Box.createVerticalStrut(20));
		box8.add(streamField);box8.add(Box.createVerticalStrut(20));
		box9.add(box7); box9.add(box8);
		//box8.add(Box.createVerticalStrut(30)); box8.add(box1); box8.add(Box.createVerticalStrut(20)); box8.add(box2); box8.add(Box.createVerticalStrut(20));box8.add(box3);box8.add(Box.createVerticalStrut(20)); box8.add(box4);box8.add(Box.createVerticalStrut(20));
		return box9;
	}
	public void createStudentLoggedIn(String un){
		this.setSize(900,900);
		this.setVisible(true);
		JButton home = new JButton("Home");
		//home.setSize(200,80); 
		//home.setFont(new Font("Arial",Font.PLAIN,30));
		JButton update = new JButton("Update Profile");
		JButton checkstatus = new JButton("Check Status");
		//checkstatus.setSize(200,80); 
		//checkstatus.setFont(new Font("Arial",Font.PLAIN,30));
		JButton apply = new JButton("Apply for Room");
		//apply.setSize(200,80); 
		//apply.setFont(new Font("Arial",Font.PLAIN,30));
		JButton details = new JButton("Check Details of Rooms");
		JButton filter = new JButton("Filter Rooms");
		//details.setSize(200,80); 
		//details.setFont(new Font("Arial",Font.PLAIN,30));
	//	JButton profile = new JButton("View Profile");
	//	profile.setSize(200,80); profile.setFont(new Font("Arial",Font.PLAIN,30));
		JButton logout = new JButton("Logout");
		//logout.setSize(200,80); 
		//logout.setFont(new Font("Arial",Font.PLAIN,30));
		ResultSet rs;
		try{
			Class.forName(SystemHAS.DRIVER);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_allocation_system",SystemHAS.USER,SystemHAS.PASSWORD); 
			PreparedStatement ps = con.prepareStatement("select sid,sname,sex,email,address,stream from student where sid=?");
			ps.setInt(1, Integer.parseInt(un));
			rs = ps.executeQuery();
			
			JLabel ID = new JLabel("ID: ");
			ID.setFont(new Font("Arial", Font.PLAIN, 20));
			JTextField IDField = new JTextField(30);
			IDField.setEditable(false);
			JLabel name = new JLabel("Name: ");
			name.setFont(new Font("Arial", Font.PLAIN, 20));
			JTextField nameField = new JTextField(30);
			nameField.setEditable(false);
			JLabel sex = new JLabel("Sex: ");
			sex.setFont(new Font("Arial",Font.PLAIN,20));
			JTextField sexField = new JTextField(30);
			sexField.setEditable(false);
			JLabel email = new JLabel("Email ID: ");
			email.setFont(new Font("Arial",Font.PLAIN,20));
			JTextField emailField = new JTextField(30);
			emailField.setEditable(false);
			JLabel address = new JLabel("Address: ");
			address.setFont(new Font("Arial", Font.PLAIN, 20));
			JTextField addressField = new JTextField(30);
			addressField.setEditable(false);
			JLabel phone_number = new JLabel("Phone number(s): ");
			phone_number.setFont(new Font("Arial",Font.PLAIN,20));
			JTextField phoneField = new JTextField(30);
			phoneField.setEditable(false);
			JLabel stream = new JLabel("Stream: ");
			stream.setFont(new Font("Arial",Font.PLAIN,20));
			JTextField streamField = new JTextField(30);
			streamField.setEditable(false);
			if(rs.next()){
				IDField.setText(rs.getString(1));
				nameField.setText(rs.getString(2));
				sexField.setText(rs.getString(3));
				emailField.setText(rs.getString(4));
				addressField.setText(rs.getString(5));
				streamField.setText(rs.getString(6));}
			rs.close();
			ps.close();
			ps=con.prepareStatement("select sid,phone_number from student_number where sid=?");
			ps.setInt(1, Integer.parseInt(un));
			rs = ps.executeQuery();
			int i=0;
			while(rs.next()){
				i++;
				if(i!=1)
					phoneField.setText(phoneField.getText()+", "+rs.getString(2));
				else
					phoneField.setText(phoneField.getText()+" "+rs.getString(2));
			}
			rs.close();
			ps.close();
			this.add(home);
			this.add(update);
			//this.add(supervisors);
			this.add(checkstatus);
			this.add(apply);
			this.add(details);
			this.add(filter);
			//this.add(profile);
			this.add(logout);
			this.add(createStructure(ID,IDField,name,nameField,sex,sexField,email,emailField,address,addressField,phone_number,phoneField,stream,streamField));
		}catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
		
		home.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			//	SystemHAS sys = new SystemHAS();
				SystemHAS.frame.setContentPane(new StudentLoggedIn(un));
			}
		});
		update.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
		
				JTextField name = new JTextField(10); 
				JTextField sex = new JTextField(10);
				JTextField email = new JTextField(10);
				JTextField address = new JTextField(10);
				JTextField phone_num = new JTextField(10);
				JTextField stream = new JTextField(10);
				
//				try{
//					Class.forName(SystemHAS.DRIVER);
//					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_allocation_system",SystemHAS.USER,SystemHAS.PASSWORD); 
//					ps=con.preparedStatement()
//				}
				
				Box box2 = Box.createHorizontalBox(); Box box3 = Box.createHorizontalBox(); Box box4 =Box.createHorizontalBox();Box box5 =Box.createHorizontalBox(); Box box6 = Box.createVerticalBox(); Box box7 =Box.createHorizontalBox(); Box box8 =Box.createHorizontalBox();
			
				box2.add(new JLabel("Name: ")); box2.add(Box.createHorizontalStrut(10)); box2.add(name);
				box3.add(new JLabel("Sex: ")); box3.add(Box.createHorizontalStrut(10)); box3.add(sex);
				box4.add(new JLabel("Email: ")); box4.add(Box.createHorizontalStrut(10)); box4.add(email);
				box5.add(new JLabel("Address: ")); box5.add(Box.createHorizontalStrut(10)); box5.add(address);
				box6.add(new JLabel("Phone no.: ")); box6.add(Box.createHorizontalStrut(10)); box6.add(phone_num);
				box7.add(new JLabel("Stream: ")); box7.add(Box.createHorizontalStrut(10)); box7.add(stream);
				box8.add(box2); box8.add(Box.createVerticalStrut(10));box8.add(box3); box8.add(Box.createVerticalStrut(10));box8.add(box4); box8.add(Box.createVerticalStrut(10));box8.add(box5);box8.add(Box.createVerticalStrut(10));box8.add(box6);box8.add(Box.createVerticalStrut(10));box8.add(box7); 
				
				int result = JOptionPane.showConfirmDialog(null, box8 ,"Update details: ", JOptionPane.OK_CANCEL_OPTION);
				if(result==JOptionPane.OK_OPTION){
					ResultSet rs;
					PreparedStatement ps;
					try{
						Class.forName(SystemHAS.DRIVER);
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_allocation_system",SystemHAS.USER,SystemHAS.PASSWORD); 
						if(!name.getText().equals("")){
							ps=con.prepareStatement("update student set sname=? where sid=?");
							ps.setString(1, name.getText());
							ps.setInt(2, Integer.parseInt(un));
							ps.executeUpdate();
							ps.close();
						}
						if(!sex.getText().equals("")){
							ps=con.prepareStatement("update student set sex=? where sid=?");
							ps.setString(1, sex.getText());
							ps.setInt(2, Integer.parseInt(un));
							ps.executeUpdate();
							ps.close();
						}
						if(!email.getText().equals("")){
							ps=con.prepareStatement("update student set email=? where sid=?");
							ps.setString(1, email.getText());
							ps.setInt(2, Integer.parseInt(un));
							ps.executeUpdate();
							ps.close();
						}
						if(!address.getText().equals("")){
							ps=con.prepareStatement("update student set address=? where sid=?");
							ps.setString(1, address.getText());
							ps.setInt(2, Integer.parseInt(un));
							ps.executeUpdate();
							ps.close();
						}
						if(!stream.getText().equals("")){
							ps=con.prepareStatement("update student set stream=? where sid=?");
							ps.setString(1, stream.getText());
							ps.setInt(2, Integer.parseInt(un));
							ps.executeUpdate();
							ps.close();
						}
						if(!phone_num.getText().equals("")){
							ps=con.prepareStatement("insert into student_number values(?,?)");
							ps.setInt(1, Integer.parseInt(un));
							ps.setLong(2, Long.parseLong(phone_num.getText()));
							ps.executeUpdate();
							ps.close();
						}
					}catch(ClassNotFoundException ex){
						ex.printStackTrace();
					}catch(SQLException ex){
						ex.printStackTrace();
					}
				}
			}
		});
		JButton delete =  new JButton("Delete Application");
		checkstatus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ResultSet rs;
				ResultSet rs2;
				JTextField appID = new JTextField(10); appID.setEditable(false);
				JTextField hostel = new JTextField(10); hostel.setEditable(false);
				JTextField room = new JTextField(10); room.setEditable(false);
				JTextField status = new JTextField(10); status.setEditable(false);
				
				PreparedStatement ps;
				try{
					Class.forName(SystemHAS.DRIVER);
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_allocation_system",SystemHAS.USER,SystemHAS.PASSWORD); 
					ps = con.prepareStatement("select appid,roomid,response,hid from application natural join room where sid=?");
					ps.setInt(1, Integer.parseInt(un));
					rs=ps.executeQuery();
					if(!rs.next()){
						JOptionPane.showMessageDialog(null,"You have currently not applied for any room.","No application",JOptionPane.WARNING_MESSAGE);
						return;
					}
					appID.setText(Integer.toString(rs.getInt(1)));
					room.setText(Integer.toString(rs.getInt(2)));
					status.setText(rs.getString(3));
					int roomid=rs.getInt(2);
					rs.close();
					ps.close();
					ps = con.prepareStatement("select hname from hostel where hid in (select hid from room where roomid=?)");
					
					ps.setInt(1, roomid);
					rs=ps.executeQuery();
					
					if(rs.next()){
						hostel.setText(rs.getString(1));
						}
					rs.close();
					ps.close();
				}catch (ClassNotFoundException ex) {
		            ex.printStackTrace();
		        } 
		        catch (SQLException ex) {
		            ex.printStackTrace();
		        }
				
				Box box1 = Box.createHorizontalBox(); Box box2 = Box.createHorizontalBox(); Box box3 = Box.createHorizontalBox(); Box box4 =Box.createHorizontalBox(); Box box5 =Box.createHorizontalBox(); Box box6 = Box.createVerticalBox();
				box1.add(new JLabel("Application ID: ")); box1.add(Box.createHorizontalStrut(10)); box1.add(appID);
				box2.add(new JLabel("Hostel: ")); box2.add(Box.createHorizontalStrut(10)); box2.add(hostel);
				box3.add(new JLabel("Room: ")); box3.add(Box.createHorizontalStrut(10)); box3.add(room);
				box4.add(new JLabel("Status: ")); box4.add(Box.createHorizontalStrut(10)); box4.add(status);
				box5.add(Box.createHorizontalStrut(10)); box5.add(delete);
				box6.add(box1); box6.add(Box.createVerticalStrut(10));box6.add(box2); box6.add(Box.createVerticalStrut(10));box6.add(box3); box6.add(Box.createVerticalStrut(10));box6.add(box4); box6.add(Box.createVerticalStrut(10));box6.add(box5);
				
				int result = JOptionPane.showConfirmDialog(null, box6 ,"Your current application details: ", JOptionPane.OK_CANCEL_OPTION);
				
				
			}
		});
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				ResultSet rs;
				PreparedStatement ps;
				try{
					Class.forName(SystemHAS.DRIVER);
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_allocation_system",SystemHAS.USER,SystemHAS.PASSWORD);			
					ps=con.prepareStatement("select appid,response from application where sid=?");
					ps.setInt(1, Integer.parseInt(un));
					rs=ps.executeQuery();
					rs.next();
					int aid=rs.getInt(1);
					if(rs.getString(2).equals("accepted")){
						JOptionPane.showMessageDialog(null,"Can't delete already accepted application","Can't Delete",JOptionPane.WARNING_MESSAGE);
						return;
					}
					rs.close();
					ps.close();
					ps=con.prepareStatement("delete from application where appid=?");
					ps.setInt(1, aid);
					ps.executeUpdate();
					rs.close();
					ps.close();
					
					JOptionPane.getRootFrame().dispose();
					JOptionPane.showMessageDialog(null, "Your Application has been deleted!","Application Deleted", JOptionPane.INFORMATION_MESSAGE);
					
				}catch(ClassNotFoundException ex){
					ex.printStackTrace();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		});
		apply.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//check using sql if already applied
				ResultSet rs;
				ResultSet rs2;
				JTextField appID = new JTextField(10); appID.setEditable(false);
				JTextField hostel = new JTextField(10); hostel.setEditable(true);
				JTextField room = new JTextField(10); room.setEditable(true);
				PreparedStatement ps;
				try{
					Class.forName(SystemHAS.DRIVER);
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_allocation_system",SystemHAS.USER,SystemHAS.PASSWORD);
					ps = con.prepareStatement("select roomid from application where sid=?");
					ps.setInt(1,Integer.parseInt(un));
					rs=ps.executeQuery();
					if(rs.first()){
						JOptionPane.showMessageDialog(null,"You have already applied for a room.","Already Applied",JOptionPane.WARNING_MESSAGE);
						return;
					}
					rs.close();
					ps.close();
					ps=con.prepareStatement("select max(appid) from application");
					rs2=ps.executeQuery();
					if(rs2.next())
						appID.setText(Integer.toString(rs2.getInt(1)+1));
					else
						appID.setText("1");
					rs2.close();
					ps.close();
					Box box1 = Box.createHorizontalBox(); Box box2 = Box.createHorizontalBox(); Box box3 = Box.createHorizontalBox(); Box box6 = Box.createVerticalBox();
					box1.add(new JLabel("Application ID: ")); box1.add(Box.createHorizontalStrut(10)); box1.add(appID);
					box2.add(new JLabel("Hostel: ")); box2.add(Box.createHorizontalStrut(10)); box2.add(hostel);
					box3.add(new JLabel("Room: ")); box3.add(Box.createHorizontalStrut(10)); box3.add(room);
					box6.add(box1); box6.add(Box.createVerticalStrut(10));box6.add(box2); box6.add(Box.createVerticalStrut(10));box6.add(box3); 
					int result = JOptionPane.showConfirmDialog(null, box6 ,"Please fill the application form: ", JOptionPane.OK_CANCEL_OPTION);
					if(result==JOptionPane.OK_OPTION){
						//First check if there is a tuple in Room entity with the given hid and roomID
						//If not then error
						//Else add the given tuple to Application with status=pending
						ps=con.prepareStatement("select roomid from room where roomid=? and hid=?");
						ps.setInt(1, Integer.parseInt(room.getText()));
						ps.setInt(2, Integer.parseInt(hostel.getText()));
						rs=ps.executeQuery();
						if(!rs.first()){
							JOptionPane.showMessageDialog(null,"You haven't entered valid room and/or hostel ID(s)","Not valid",JOptionPane.WARNING_MESSAGE);
							return;
						}
						rs.close();
						ps.close();
						ps=con.prepareStatement("insert into application values(?,?,?,?)");
						ps.setInt(1, Integer.parseInt(appID.getText()));
						ps.setInt(2, Integer.parseInt(un));
						ps.setInt(3, Integer.parseInt(room.getText()));
						ps.setString(4, "pending");
						int i=ps.executeUpdate();
						ps.close();
						con.close();
						//rs.next();
						
					}				
				}catch (ClassNotFoundException ex) {
		            ex.printStackTrace();
		        } 
		        catch (SQLException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		details.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				DetailsPanel dp = new DetailsPanel(un);
				SystemHAS.frame.setContentPane(dp);
			}
		});
		filter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				FilterPanel fp = new FilterPanel(un);
				SystemHAS.frame.setContentPane(fp);
			}
		});
		logout.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//MySystem.currently_logged_in=null;
				new SystemHAS();
			}
		});
	}

}

