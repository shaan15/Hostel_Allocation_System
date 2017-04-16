import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
public class AdminLoggedIn extends JPanel{
	Connection con=null;
	public  AdminLoggedIn(){
		super();
		createAdminLoggedIn();
	}
	public Box createStructure(Component ID, Component IDField, Component name, Component nameField, Component phone_number, Component phoneField){
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
		box7.add(phone_number);box7.add(Box.createVerticalStrut(20));
		box8.add(IDField); box8.add(Box.createVerticalStrut(20));
		box8.add(nameField); box8.add(Box.createVerticalStrut(20));
		box8.add(phoneField);box8.add(Box.createVerticalStrut(20));
		box9.add(box7); box9.add(box8);
		//box8.add(Box.createVerticalStrut(30)); box8.add(box1); box8.add(Box.createVerticalStrut(20)); box8.add(box2); box8.add(Box.createVerticalStrut(20));box8.add(box3);box8.add(Box.createVerticalStrut(20)); box8.add(box4);box8.add(Box.createVerticalStrut(20));
		return box9;
	}
	public void createAdminLoggedIn(){
		this.setSize(900,900);
		this.setVisible(true);
		JButton home = new JButton("Home");
		//apply.setSize(200,80); 
		//apply.setFont(new Font("Arial",Font.PLAIN,30));
		JButton viewPendingApp=new JButton("View Pending Applications");
		JButton respondPendingApp = new JButton("Respond to Pending Applications");
		JButton details = new JButton("Check Details of Rooms");
		//details.setSize(200,80); 
		//details.setFont(new Font("Arial",Font.PLAIN,30));
	//	JButton profile = new JButton("View Profile");
	//	profile.setSize(200,80); profile.setFont(new Font("Arial",Font.PLAIN,30));
		JButton logout = new JButton("Logout");
		//logout.setSize(200,80); 
		//logout.setFont(new Font("Arial",Font.PLAIN,30));
		
		JLabel ID = new JLabel("ID: ");
		ID.setFont(new Font("Arial", Font.PLAIN, 20));
		JTextField IDField = new JTextField(30);
		IDField.setEditable(false);
		JLabel name = new JLabel("Name: ");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		JTextField nameField = new JTextField(30);
		nameField.setEditable(false);
		JLabel phone_number = new JLabel("Phone number: ");
		phone_number.setFont(new Font("Arial",Font.PLAIN,20));
		JTextField phoneField = new JTextField(30);
		phoneField.setEditable(false);
		PreparedStatement ps;
		ResultSet rs;
		try{
			Class.forName(SystemHAS.DRIVER);
	        con = DriverManager.getConnection("jdbc:mysql://localhost/hostel_allocation_system",SystemHAS.USER,SystemHAS.PASSWORD);
	        ps=con.prepareStatement("select id,name,phone_num from admin where id=?");
	        ps.setInt(1,0);
	        rs=ps.executeQuery();
	        rs.next();
	        IDField.setText(Integer.toString(rs.getInt(1)));
	        nameField.setText(rs.getString(2));
	        phoneField.setText(rs.getString(3));
	        rs.close();
	        ps.close();
		}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		this.add(home);
		//this.add(supervisors);
		this.add(viewPendingApp);
		this.add(respondPendingApp);
		this.add(details);
		//this.add(profile);
		this.add(logout);
		this.add(createStructure(ID,IDField,name,nameField,phone_number,phoneField));
		
		
		home.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			//	SystemHAS sys = new SystemHAS();
				SystemHAS.frame.setContentPane(new AdminLoggedIn());
			}
		});

		viewPendingApp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ViewPanel dp = new ViewPanel();
				SystemHAS.frame.setContentPane(dp);
			}
		});
			
		respondPendingApp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				RespondPanel dp = new RespondPanel();
				SystemHAS.frame.setContentPane(dp);
			}
		});	
		details.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				DetailsPanel dp = new DetailsPanel(Integer.toString(1));
				SystemHAS.frame.setContentPane(dp);
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

