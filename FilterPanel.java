
import javax.swing.*;

//import FilterPanel.SubmittedPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class FilterPanel extends JPanel{
	String un;
	Connection con=null;
	String option_chosen="";
	public FilterPanel(String un){
		super();
		this.un=un;
		createFilterPanel(un);
	}
	public void createFilterPanel(String un){
		this.setSize(1000,1500);
		this.setVisible(true);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,600,50));
		JRadioButton availability = new JRadioButton("Availability");
  		JRadioButton type = new JRadioButton("Type");
  		JRadioButton floor = new JRadioButton("Floor");
		ButtonGroup group=new ButtonGroup();
		group.add(availability);
		group.add(type);
		group.add(floor);
		JButton submit = new JButton("Submit");
		JButton back = new JButton("Back");
		this.add(availability);
		this.add(type);
		this.add(floor);
		this.add(submit);
		this.add(back);
		availability.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent e) {         
            	if(e.getStateChange()==1){
            		option_chosen="availability";
            	}
         	}           
     	});
		type.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent e) {         
            	if(e.getStateChange()==1){
            		option_chosen="type";
            	}
         	}           
     	});
		floor.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent e) {         
            	if(e.getStateChange()==1){
            		option_chosen="floor";
            	}
         	}           
     	});
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!option_chosen.equals("")){
					SystemHAS.frame.setContentPane(new ChosingPanel(un,option_chosen));
				}
				
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
	
	class ChosingPanel extends JPanel{
		String un;
		String option_chosen;
		Connection con=null;
		public ChosingPanel(String un, String option_chosen){
			super();
			createChosingPanel(un);
			this.un=un;
			this.option_chosen=option_chosen;
		}
		public void createChosingPanel(String un){
			this.setSize(1000,1500);
			this.setVisible(true);
			this.setLayout(new FlowLayout(FlowLayout.CENTER,600,50));
			JTextField attr = new JTextField(10); 
			JButton submit = new JButton("Submit");
			JButton back = new JButton("Back");
			//submit.setSize(150,40); submit.setFont(new Font("Arial",Font.PLAIN,30));
			Box box1 = Box.createHorizontalBox();
			box1.add(new JLabel("Enter status/type or floor: ")); box1.add(Box.createHorizontalStrut(10)); box1.add(attr);
			
		
			submit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String rid = attr.getText();
					
					SystemHAS.frame.setContentPane(new SubmittedPanel(rid,un,option_chosen));
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
			this.add(box1);
			this.add(submit);
			this.add(back);
		
		}
	}
	class SubmittedPanel extends JPanel{
		String un;
		public SubmittedPanel(String rid,String un,String option_chosen){			
			super();
			this.un=un;
			createSubmittedPanel(rid,option_chosen);
		}
		public void createSubmittedPanel(String r,String option_chosen){
			this.setSize(1000,1500);
			this.setVisible(true);
			this.setLayout(new FlowLayout(FlowLayout.CENTER,600,50));
			
			
			String[] columns = new String[]{
		            "Room ID", "Hostel ID", "Floor", "Type", "Price","Description", "Status"
		        };
				int len=0;
				ResultSet rs;
		    	PreparedStatement ps;
		    	Object[][] data = null;
		    	try{
		    		Class.forName(SystemHAS.DRIVER);
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_allocation_system",SystemHAS.USER,SystemHAS.PASSWORD); 
					
					if(option_chosen.equals("availability")){
						ps = con.prepareStatement("select roomid,hid,floor,type,price,description,status from room natural join room_type where status=?");
						ps.setString(1, r);
						len=0;
						rs=ps.executeQuery();			
						while(rs.next()){
							len++;
						}
						System.out.println(len);
						rs.absolute(0);
						data = new Object[len][7];
						for(int i=0;i<len;i++){
							rs.next();
							System.out.println("*");
							data[i][0] = rs.getInt(1);
							data[i][1] = rs.getInt(2);
							data[i][2] = rs.getInt(3);
							data[i][3] = rs.getInt(4);
							data[i][4] = rs.getDouble(5);
							data[i][5] = rs.getString(6);
							data[i][6] = rs.getString(7);
							
						}
						rs.close();
						ps.close();
					}
					else if(option_chosen.equals("type")){
						ps = con.prepareStatement("select roomid,hid,floor,type,price,description,status from room natural join room_type where room.type=?");
						ps.setInt(1, Integer.parseInt(r));
						len=0;
						rs=ps.executeQuery();			
						while(rs.next()){
							len++;
						}
						System.out.println(len);
						rs.absolute(0);
						data = new Object[len][7];
						for(int i=0;i<len;i++){
							rs.next();
							System.out.println("*");
							data[i][0] = rs.getInt(1);
							data[i][1] = rs.getInt(2);
							data[i][2] = rs.getInt(3);
							data[i][3] = rs.getInt(4);
							data[i][4] = rs.getDouble(5);
							data[i][5] = rs.getString(6);
							data[i][6] = rs.getString(7);
							
						}
						rs.close();
						ps.close();
					}
					else if(option_chosen.equals("floor")){
						ps = con.prepareStatement("select roomid,hid,floor,type,price,description,status from room natural join room_type where room.floor=?");
						ps.setInt(1, Integer.parseInt(r));
						len=0;
						rs=ps.executeQuery();			
						while(rs.next()){
							len++;
						}
						System.out.println(len);
						rs.absolute(0);
						data = new Object[len][7];
						for(int i=0;i<len;i++){
							if(!rs.next())
								break;
						//	rs.next();
							System.out.println("*");
							data[i][0] = rs.getInt(1);
							data[i][1] = rs.getInt(2);
							data[i][2] = rs.getInt(3);
							data[i][3] = rs.getInt(4);
							data[i][4] = rs.getDouble(5);
							data[i][5] = rs.getString(6);
							data[i][6] = rs.getString(6);
							
						}
						rs.close();
						ps.close();
					}
					
		    	}catch(ClassNotFoundException e){
		    		e.printStackTrace();
		    	}catch(SQLException e){
		    		e.printStackTrace();
		    	}
		    	//int i=5;
		        
		        JTable table = new JTable(data, columns);
		        table.setVisible(true);
		        this.add(new JScrollPane(table));
		
						
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
