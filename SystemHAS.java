import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;

public class SystemHAS{
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASSWORD = "shaan@18";
	public static JFrame frame;
	JPanel panel;
	JLabel label;
	JButton bttn_str, bttn_exit, bttn_register, query1, query2, query3, query4, query5;
	String stream_select="";
	int room_select=0;
	String sex_select="";
	int room_type1=0;
	int room_type2=0;
	public static String type_1_login="";
	Connection con=null;
	SystemHAS(){
		

		frame=new JFrame();
		//frame.setContentPane(new StudentLoggedIn(Integer.toString(5)));
		panel=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		JLabel label=new JLabel("Hostel Allocation System");
		bttn_str=new JButton("Login");
		bttn_exit=new JButton("Exit");
		bttn_register=new JButton("Register");
		query1=new JButton("Query 1");
		query2=new JButton("Query 2");
		query3=new JButton("Query 3");
		query4=new JButton("Query 4");
		query5=new JButton("Query 5");

		bttn_str.setBackground(Color.CYAN);
		bttn_str.setOpaque(true);
		bttn_str.setBorderPainted(false);

		bttn_exit.setBackground(Color.CYAN);
		bttn_exit.setOpaque(true);
		bttn_exit.setBorderPainted(false);

		bttn_register.setBackground(Color.CYAN);
		bttn_register.setOpaque(true);
		bttn_register.setBorderPainted(false);

		query1.setBackground(Color.CYAN);
		query1.setOpaque(true);
		query1.setBorderPainted(false);

		query2.setBackground(Color.CYAN);
		query2.setOpaque(true);
		query2.setBorderPainted(false);

		query3.setBackground(Color.CYAN);
		query3.setOpaque(true);
		query3.setBorderPainted(false);

		query4.setBackground(Color.CYAN);
		query4.setOpaque(true);
		query4.setBorderPainted(false);

		query5.setBackground(Color.CYAN);
		query5.setOpaque(true);
		query5.setBorderPainted(false);

		panel.setLayout(null);
		label.setBounds(200,120,500,40);
		label.setFont(new Font("Arial",Font.BOLD,30));
		//bttn_str.setBounds(330,250,150,40);
		bttn_str.setBounds(330,250,150,40);
		bttn_register.setBounds(350,300,100,40);
		query1.setBounds(350,350,100,40);
		query2.setBounds(350,400,100,40);
		query3.setBounds(350,450,100,40);
		query4.setBounds(350,500,100,40);
		query5.setBounds(350,550,100,40);
		bttn_exit.setBounds(350,600,100,40);
		panel.add(label);
		panel.add(bttn_str);
		panel.add(bttn_register);
		panel.add(query1);
		panel.add(query2);
		panel.add(query3);
		panel.add(query4);
		panel.add(query5);
		panel.add(bttn_exit);
		panel.setBackground(new Color(255,255,244));
		bttn_str.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				new Login_Form();
			}
		});
		bttn_register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				new Register_Form();
			}
		});
		query1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				new Query1_form();
			}
		});
		query2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				new Query2_form();
			}
		});
		query3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				new Query3_form();
			}
		});
		query4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				new Query4_form();
			}
		});
		query5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				new Query5_form();
			}
		});
		bttn_exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				System.exit(0);
			}
		});
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,900);
		frame.setVisible(true);

	}

	public class Login_Form{
		
		Login_Form(){
			panel.removeAll();
		panel.updateUI();
		panel.setLayout(new FlowLayout());
		JPanel panel2=new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.setBackground(new Color(255,255,244));
		JPanel panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel1.setBackground(new Color(255,255,244));
		JPanel panel3=new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
		panel3.setBackground(new Color(255,255,244));
		panel2.setPreferredSize(new Dimension(130, 130));
		panel1.setPreferredSize(new Dimension(130, 130));
		JButton username=new JButton("ID");
		JButton password=new JButton("Password");
		JButton type =new JButton("Type");
		JButton back1=new JButton ("Back");
		JTextField txt=new JTextField();
		JTextField txt5=new JPasswordField();
		JRadioButton admin = new JRadioButton("Admin");
		JRadioButton student = new JRadioButton("Student");
		ButtonGroup bg =new ButtonGroup();
		bg.add(admin);
		bg.add(student);
		panel2.add(username);
		panel2.add(password);
		panel2.add(type);
		panel1.add(txt);
		panel1.add(txt5);
		panel1.add(admin);
		panel1.add(student);
		panel3.add(back1);
		panel.add(panel2);
		panel.add(panel1);
		panel.add(panel3);
		back1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) { 
         	new SystemHAS();
         }}); 
		admin.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent e) {         
            	if(e.getStateChange()==1){
            		type_1_login="admin";
            	}
         	}           
     	});	
		student.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {         
            	if(e.getStateChange()==1){
            		type_1_login="student";
            	}
         	}           
     	});

     	JButton submit = new JButton("Submit");
     	JLabel error = new JLabel();

     	submit.addActionListener(new ActionListener(){
     		public void actionPerformed(ActionEvent ev){
     			String un=txt.getText();
     			String pass=txt5.getText();
     			System.out.println(type_1_login);
     			if(un.equals("") || pass.equals("")){
     				JOptionPane.showMessageDialog(frame,"Invalid or empty field");
     				new Login_Form();
     			}
     			else{
     				if(type_1_login=="admin"){
     					ResultSet rs;
     					PreparedStatement ps;
     					try{
     						Class.forName(DRIVER);
     			            con = DriverManager.getConnection("jdbc:mysql://localhost/hostel_allocation_system",USER,PASSWORD);
     			            ps = con.prepareStatement("select id,password from admin where id=?");
     			            ps.setInt(1,Integer.parseInt(un));
     			            rs=ps.executeQuery();
     			            if(!rs.next()){
     			            	JOptionPane.showMessageDialog(null,"Enter a valid username.","Invalid username",JOptionPane.WARNING_MESSAGE);
     			            	new Login_Form();
     			            }
     			            else if(Integer.toString(rs.getInt(1)).equals(un)){
     			            	if(!(rs.getString(2).equals(pass)))
     			            		JOptionPane.showMessageDialog(null,"Enter a valid password.","Invalid password",JOptionPane.WARNING_MESSAGE);
     			            	else{
     			            		frame.setContentPane(new AdminLoggedIn());
     			            	}
     			            }
     			            rs.close();
     			            ps.close();
     					}catch(ClassNotFoundException e){
     						e.printStackTrace();
     					}catch(SQLException e){
     						e.printStackTrace();
     					}
    

     				}
     				else if(type_1_login=="student"){
     					ResultSet rs;
     					PreparedStatement ps;
     					try{
     						Class.forName(DRIVER);
     			            con = DriverManager.getConnection("jdbc:mysql://localhost/hostel_allocation_system",USER,PASSWORD);
     			            ps = con.prepareStatement("select sid,password from student_password where sid=?");
     			            ps.setInt(1,Integer.parseInt(un));
     			            rs=ps.executeQuery();
     			            if(!rs.next()){
     			            	JOptionPane.showMessageDialog(null,"Enter a valid username.","Invalid username",JOptionPane.WARNING_MESSAGE);
     			            	new Login_Form();
     			            }
     			            else if(Integer.toString(rs.getInt(1)).equals(un)){
     			            	if(!(rs.getString(2).equals(pass)))
     			            		JOptionPane.showMessageDialog(null,"Enter a valid password.","Invalid password",JOptionPane.WARNING_MESSAGE);
     			            	else{
     			            		frame.setContentPane(new StudentLoggedIn(un));
     			            	}
     			            }
     			            rs.close();
     			            ps.close();
     					}catch(ClassNotFoundException e){
     						e.printStackTrace();
     					}catch(SQLException e){
     						e.printStackTrace();
     					}

     				}

     			}
     		}
     	});
     	panel.add(submit);
     	frame.getContentPane().add(panel,BorderLayout.CENTER);
     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	public class Register_Form{
		int x;
		int ID=0;
		Register_Form(){
			panel.removeAll();
			panel.updateUI();
			panel.setLayout(new FlowLayout());
			JPanel panel2=new JPanel();
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
			panel2.setBackground(new Color(255,255,244));
			JPanel panel1=new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
			panel1.setBackground(new Color(255,255,244));
			panel2.setPreferredSize(new Dimension(200, 350));
			panel1.setPreferredSize(new Dimension(300, 350));
			JButton name=new JButton("Name");
			JButton rollnum=new JButton("Roll Number");
			JButton password=new JButton("Password");
			JButton sex=new JButton("Sex");
			JButton address=new JButton("Address");
			JButton phone_num=new JButton("Phone Number");
			JButton email=new JButton("Email");
			JButton stream=new JButton("Stream");
			JButton back=new JButton("Back");
			JTextField txt=new JTextField();
			JTextField txt2=new JTextField();
			JTextField txt3=new JPasswordField();
			JTextField txt4=new JTextField();
			JTextField txt5=new JTextField();
			JTextField txt6=new JTextField();
			JTextField txt7=new JTextField();

			txt.setPreferredSize(new Dimension(50, 120));
			txt2.setPreferredSize(new Dimension(40, 100)); txt2.setEditable(false);
			txt3.setPreferredSize(new Dimension(50, 120));
			txt4.setPreferredSize(new Dimension(50, 120));
			txt5.setPreferredSize(new Dimension(50, 120));
			txt6.setPreferredSize(new Dimension(50, 120));
			txt7.setPreferredSize(new Dimension(50, 120));
			ResultSet rs;
			PreparedStatement ps;
			//int ID=0;
			try{			
	            Class.forName(DRIVER);
	            con = DriverManager.getConnection("jdbc:mysql://localhost/hostel_allocation_system",USER,PASSWORD);
	            ps = con.prepareStatement("select max(sid) from student");
	            rs=ps.executeQuery();
	            if(rs.next()){
	            	ID=rs.getInt(1);
	            }
	            else{
	            	ID=0;
	            }
	            rs.close();
	            ps.close();
			}catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        } 
		        catch (SQLException e) {
		            e.printStackTrace();
		        }
			txt2.setText(Integer.toString(ID+1));
			JRadioButton bcse = new JRadioButton("B.Tech(CSE)");
			JRadioButton bece = new JRadioButton("B.Tech(ECE)");
      		JRadioButton bcsam = new JRadioButton("B.Tech(CSAM)");
      		JRadioButton mcse = new JRadioButton("M.Tech(CSE)");
      		JRadioButton mece = new JRadioButton("M.Tech(ECE)");
      		JRadioButton mcb = new JRadioButton("M.Tech(CB)");
      		JRadioButton phd = new JRadioButton("PhD");
			ButtonGroup group=new ButtonGroup();
			group.add(bcse);
			group.add(bece);
			group.add(bcsam);
			group.add(mcse);
			group.add(mece);
			group.add(mcb);
			group.add(phd);
			panel2.add(name);
			panel2.add(rollnum);
			panel2.add(password);
			panel2.add(sex);
			panel2.add(address);
			panel2.add(phone_num);
			panel2.add(email);
			panel2.add(stream);
			panel1.add(txt);
			panel1.add(txt2);
			panel1.add(txt3);
			panel1.add(txt4);
			panel1.add(txt5);
			panel1.add(txt6);
			panel1.add(txt7);
			panel1.add(bcse);
			panel1.add(bece);
			panel1.add(bcsam);
			panel1.add(mcse);
			panel1.add(mece);
			panel1.add(mcb);
			panel1.add(phd);
			panel.add(panel2);
			panel.add(panel1);

			back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
					new SystemHAS();
				}
			});
			bcse.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			stream_select="B.Tech(CSE)";
         		}           
      		});
      		bece.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			stream_select="B.Tech(ECE)";
         		}           
      		});
      		bcsam.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			stream_select="B.Tech(CSAM)";
         		}           
      		});
      		mcse.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			stream_select="M.Tech(CSE)";
         		}           
      		});
      		mece.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			stream_select="M.Tech(ECE)";
         		}           
      		});
      		mcb.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			stream_select="M.Tech(CB)";
         		}           
      		});
      		phd.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			stream_select="PhD";
         		}           
      		});

      		JButton submit=new JButton("Submit");
      		submit.addActionListener(new ActionListener(){
      			public void actionPerformed(ActionEvent ev){
      				ResultSet rs;
      				PreparedStatement ps;
      				try {
      					if(txt.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("")){
      						JOptionPane.showMessageDialog(null,"Can not leave Username, Password and/or Name empty.","Empty Fields",JOptionPane.WARNING_MESSAGE);
      						new Register_Form();
      					}
      					Class.forName(DRIVER);
      		            con = DriverManager.getConnection("jdbc:mysql://localhost/hostel_allocation_system",USER,PASSWORD);
      		            ps=con.prepareStatement("insert into student values(?,?,?,?,?,?)");
      		            ps.setInt(1, ID+1);
      		            ps.setString(2, txt.getText());
      		            ps.setString(3, txt4.getText());
      		            ps.setString(4, txt7.getText());
      		            ps.setString(5,txt5.getText());
      		            ps.setString(6,stream_select);
      		            ps.executeUpdate();
      		            //rs.close();
      		            ps.close();
      		            String s;
      		            s=txt6.getText();
      		            String[] arr = s.split(",");
      		            int len=arr.length;
      		            
      		            for(int i=0;i<len;i++){
      		            	ps=con.prepareStatement("insert into student_number  values(?,?)");
      		            	ps.setInt(1, ID+1);
      		            	ps.setLong(2, Long.parseLong(arr[i].trim()));
      		            	ps.executeUpdate();
      		            	//rs.close();
      		            	ps.close();
      		            }
      		            ps=con.prepareStatement("insert into student_password values(?,?)");
      		            ps.setInt(1, ID+1);
      		            ps.setString(2, txt3.getText());
      		            ps.executeUpdate();
      		            ps.close();
      		            new SystemHAS();
      		            
      		        }catch (ClassNotFoundException e) {
      		            e.printStackTrace();
      		        } 
      		        catch (SQLException e) {
      		            e.printStackTrace();
      		        }
      			}
      		});
      		panel.add(submit);
      		panel.add(back);
      		frame.getContentPane().add(panel,BorderLayout.CENTER);

		}
		

		public int check_email(String name){
			int count=0;
			for(int i=0;i<name.length();i++){
    			if(name.charAt(i)=='@' && i!=0){
    				for(int j=i+1;j<name.length();j++){
    					if(name.charAt(j)=='.' && j<(name.length()-1)){
    						count++;
    						break;
    					}
    				}
    			}
    		}
    		System.out.println(count);
    		if(count==1)
    			return 1;
    		else
    			 return 0;

		}

		public int check_date(String name){
    		if(name.length()==10){	
    			if(name.charAt(2)=='/' && name.charAt(5)=='/' ){	
    					if((name.charAt(3)=='0' && name.charAt(4)<='9' && name.charAt(4)>'0' ) ||(name.charAt(3)=='1' && name.charAt(4)<='2' && name.charAt(4)>'0')){	
    						if(name.charAt(6)=='1' && name.charAt(7)=='9'){	
    							return 1;
    						}
    						else{
    							return 0;
    						}
    					}
    					else{
    						return 0;
    					}

    				}
    				else{
    					return 0;		
    				}
    		}
    		else{
    			return 0;
    		}
    	}


	}


	public class Query1_form{
		Query1_form(){
			panel.removeAll();
			panel.updateUI();
			panel.setLayout(new FlowLayout());
			JPanel panel2=new JPanel();
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
			panel2.setBackground(new Color(255,255,244));
			JPanel panel1=new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
			panel1.setBackground(new Color(255,255,244));
			panel2.setPreferredSize(new Dimension(200, 100));
			panel1.setPreferredSize(new Dimension(300, 100));
			JButton hname=new JButton("Hostel Name");
			JButton type=new JButton("Room Type");
			JButton back=new JButton("Back");

			JTextField f=new JTextField();
			f.setPreferredSize(new Dimension(50, 120));

			JRadioButton single_s = new JRadioButton("Single");
      		JRadioButton double_s = new JRadioButton("Double Sharing");
      		JRadioButton triple_s = new JRadioButton("Triple Sharing");
			ButtonGroup group=new ButtonGroup();
			group.add(single_s);
			group.add(double_s);
			group.add(triple_s);
			
			panel2.add(hname);
			panel2.add(type);
			panel1.add(f);
			panel1.add(single_s);
			panel1.add(double_s);
			panel1.add(triple_s);
			panel.add(panel2);
			panel.add(panel1);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					new SystemHAS();
				}
			});
			single_s.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			room_select=1;
         		}           
      		});
      		double_s.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			room_select=2;
         		}           
      		});
      		triple_s.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			room_select=3;
         		}           
      		});

      		JButton submit=new JButton("Submit");
      		submit.addActionListener(new ActionListener(){
      			public void actionPerformed(ActionEvent ev){
      				String r=f.getText();
      				System.out.println(r);
      				frame.setContentPane(new Submit_query1(r));
      			}
      		});
      		panel.add(submit);
      		panel.add(back);
      		frame.getContentPane().add(panel,BorderLayout.CENTER);
		}
		public int check_hname_in_database(String h){
			
			//if(hi is present in the hostel database)
			//return 1
			//else
			return 0;
		}
	}
	public class Submit_query1 extends JPanel{
		String i;
		Submit_query1(String i){
			super();
			this.i=i;
			createSubmitQuery1();
			
		}
		public void createSubmitQuery1(){
			this.setSize(900,900);
			this.setVisible(true);
			JButton back=new JButton("Back");
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					new SystemHAS();
				}
			});
			System.out.println(i);
			System.out.println(room_select);
			String[] columns={"Mess ID"};
			Object[][] data=null;
			ResultSet rs;
			PreparedStatement ps;
			try{
				Class.forName(DRIVER);
		        con = DriverManager.getConnection("jdbc:mysql://localhost/hostel_allocation_system",USER,PASSWORD);
		        ps=con.prepareStatement("select distinct messid from room natural join mess natural join application natural join hostel where hname=? and type=?");
		        ps.setString(1, i);
		        ps.setInt(2, room_select);
		        rs=ps.executeQuery();
		        int len=0;
		        while(rs.next())
		        	len++;
		        rs.absolute(0);
		        data=new Object[len][1];
		        for(int i=0;i<len;i++){
		        	rs.next();
		        	data[i][0]=rs.getInt(1);
		        }
		        rs.close();
		        ps.close();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
			JTable table = new JTable(data, columns);
	        this.add(new JScrollPane(table));
	        this.add(back);
				
			
		}
		
		
	}
	public class Query2_form{
		Query2_form(){
			panel.removeAll();
			panel.updateUI();
			panel.setLayout(new FlowLayout());
			JPanel panel2=new JPanel();
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
			panel2.setBackground(new Color(255,255,244));
			JPanel panel1=new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
			panel1.setBackground(new Color(255,255,244));
			panel2.setPreferredSize(new Dimension(200, 100));
			panel1.setPreferredSize(new Dimension(300, 100));
			JButton floor=new JButton("Floor");
			JButton sex1=new JButton("Sex");
			JButton back=new JButton("Back");

			JTextField f=new JTextField();
			f.setPreferredSize(new Dimension(50, 120));
			JRadioButton male = new JRadioButton("Male");
      		JRadioButton female = new JRadioButton("Female");
      		JRadioButton other = new JRadioButton("Other");
			ButtonGroup group=new ButtonGroup();
			group.add(male);
			group.add(female);
			group.add(other);

			panel2.add(floor);
			panel2.add(sex1);
			panel1.add(f);
			panel1.add(male);
			panel1.add(female);
			panel1.add(other);
			panel.add(panel2);
			panel.add(panel1);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					new SystemHAS();
				}
			});
			male.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			sex_select="male";
         		}           
      		});
      		female.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			sex_select="female";
         		}           
      		});
      		other.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			sex_select="other";
         		}           
      		});
			JButton submit=new JButton("Submit");
      		submit.addActionListener(new ActionListener(){
      			public void actionPerformed(ActionEvent ev){
      				String r=f.getText();
      				frame.setContentPane(new Submit_query2(r));
      			}
      		});
      		panel.add(submit);
      		panel.add(back);
      		frame.getContentPane().add(panel,BorderLayout.CENTER);
		}

		public int check_floor(String fl){
			int flo=Integer.parseInt(fl);
			//apply check if exists in database or not
			return 0;
		}

	}
	public class Submit_query2 extends JPanel{
		String f;
		Submit_query2(String f){
			super();
			this.f=f;
			createSubmitQuery1();
			
		}
		public void createSubmitQuery1(){
			this.setSize(900,900);
			this.setVisible(true);
			JButton back=new JButton("Back");
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					new SystemHAS();
				}
			});
			String[] columns={"Room ID"};
			Object[][] data=null;
			ResultSet rs;
			PreparedStatement ps;
			try{
				Class.forName(DRIVER);
		        con = DriverManager.getConnection("jdbc:mysql://localhost/hostel_allocation_system",USER,PASSWORD);
		        ps=con.prepareStatement("select distinct roomid from room natural join application natural join student where (response=? or response=?) and floor=? and (sex=?)");
		        ps.setString(1, "pending");
		        ps.setString(2, "rejected");
		        ps.setInt(3,Integer.parseInt(f));
		        ps.setString(4, sex_select);
		            rs=ps.executeQuery();
		        int len=0;
		        while(rs.next())
		        	len++;
		        rs.absolute(0);
		        data=new Object[len][1];
		        for(int i=0;i<len;i++){
		        	rs.next();
		        	data[i][0]=rs.getInt(1);
		        }
		        rs.close();
		        ps.close();
		            
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
			JTable table = new JTable(data, columns);
	        this.add(new JScrollPane(table));
	        this.add(back);
				
			
		}
	}
	
	public class Query3_form{
		Query3_form(){
			panel.removeAll();
			panel.updateUI();
			panel.setLayout(new FlowLayout());
			JPanel panel2=new JPanel();
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
			panel2.setBackground(new Color(255,255,244));
			JPanel panel1=new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
			panel1.setBackground(new Color(255,255,244));
			panel2.setPreferredSize(new Dimension(200, 30));
			panel1.setPreferredSize(new Dimension(300, 30));
			JButton mess1=new JButton("Mess ID");
			JButton submit=new JButton("Submit");
			JButton back=new JButton("Back");
			JTextField f=new JTextField();
			f.setPreferredSize(new Dimension(50, 120));

			panel2.add(mess1);
			panel1.add(f);
			panel.add(panel2);
			panel.add(panel1);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					new SystemHAS();
				}
			});
      		submit.addActionListener(new ActionListener(){
      			public void actionPerformed(ActionEvent ev){
      				String r=f.getText();
      				frame.setContentPane(new Submit_query3(r));
      			}
      		});
      		panel.add(submit);
      		panel.add(back);
      		frame.getContentPane().add(panel,BorderLayout.CENTER);

		}
		public int check_messid_in_database(String m){
			int mi=Integer.parseInt(m);
			//if(mi is present in the mess database)
			//return 1
			//else
			return 0;
		}

	}
	public class Submit_query3 extends JPanel{
		String f;
		Submit_query3(String f){
			super();
			this.f=f;
			createSubmitQuery3();
		}
		public void createSubmitQuery3(){
			this.setSize(900,900);
			this.setVisible(true);
			JButton back=new JButton("Back");
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					new SystemHAS();
				}
			});
			String[] columns={"Increase in students"};
			Object[][] data=null;
			ResultSet rs;
			PreparedStatement ps;
				try{
					Class.forName(DRIVER);
		            con = DriverManager.getConnection("jdbc:mysql://localhost/hostel_allocation_system",USER,PASSWORD);
		            ps=con.prepareStatement("select count(sid) from student natural join application natural join room natural join mess where response=? and messid=?");
		            ps.setString(1, "pending");
		            ps.setInt(2, Integer.parseInt(f));
		            rs=ps.executeQuery();
		          //  rs=ps.executeQuery();
			        int len=0;
			        while(rs.next())
			        	len++;
			        rs.absolute(0);
			        data=new Object[len][1];
			        for(int i=0;i<len;i++){
			        	rs.next();
			        	data[i][0]=rs.getInt(1);
			        }
			        rs.close();
			        ps.close();
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}catch(SQLException e){
					e.printStackTrace();
				}
				JTable table = new JTable(data, columns);
		        this.add(new JScrollPane(table));
		        this.add(back);
		}
	}
	public class Query4_form{
		Query4_form(){
			panel.removeAll();
			panel.updateUI();
			panel.setLayout(new FlowLayout());
			JPanel panel2=new JPanel();
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
			panel2.setBackground(new Color(255,255,244));
			JPanel panel1=new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
			panel1.setBackground(new Color(255,255,244));
			panel2.setPreferredSize(new Dimension(200, 100));
			panel1.setPreferredSize(new Dimension(300, 150));
			JButton type1=new JButton("Room 1 Type");
			JButton type2=new JButton("Room 2 Type");
			JButton submit=new JButton("Submit");
			JButton back=new JButton("Back");

			JRadioButton single_s1 = new JRadioButton("Single");
      		JRadioButton double_s1 = new JRadioButton("Double Sharing");
      		JRadioButton triple_s1 = new JRadioButton("Triple Sharing");
			ButtonGroup group1=new ButtonGroup();
			group1.add(single_s1);
			group1.add(double_s1);
			group1.add(triple_s1);

			JRadioButton single_s2 = new JRadioButton("Single");
      		JRadioButton double_s2 = new JRadioButton("Double Sharing");
      		JRadioButton triple_s2 = new JRadioButton("Triple Sharing");
      		ButtonGroup group2=new ButtonGroup();
			group2.add(single_s2);
			group2.add(double_s2);
			group2.add(triple_s2);

			panel2.add(type1);
			panel2.add(type2);
			panel1.add(single_s1);
			panel1.add(double_s1);
			panel1.add(triple_s1);
			panel1.add(single_s2);
			panel1.add(double_s2);
			panel1.add(triple_s2);
			panel.add(panel2);
			panel.add(panel1);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					new SystemHAS();
				}
			});
			single_s1.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			room_type1=1;
         		}           
      		});
      		double_s1.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			room_type1=2;
         		}           
      		});
      		triple_s1.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			room_type1=3;
         		}           
      		});
      		single_s2.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			room_type2=1;
         		}           
      		});
      		double_s2.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			room_type2=2;
         		}           
      		});
      		triple_s2.addItemListener(new ItemListener() {
         		public void itemStateChanged(ItemEvent ev) {         
            		if(ev.getStateChange()==1)
            			room_type2=3;
         		}           
      		});
      		submit.addActionListener(new ActionListener(){
      			public void actionPerformed(ActionEvent ev){
      				if(room_type1==room_type2){
      					JOptionPane.showMessageDialog(null,"You have given two same room types","Same Types",JOptionPane.WARNING_MESSAGE);
      					new Query4_form();
      				}
      				else{
      					frame.setContentPane(new Submit_query4());
      				}
      			}
      		});
      		panel.add(submit);
      		panel.add(back);
      		frame.getContentPane().add(panel,BorderLayout.CENTER);
		}
		public int check_same_type(String a, String b){
			if(a.equals(b)){
				return 1;
			}
			else{
				return 0;
			}
		}

	}
	public class Submit_query4 extends JPanel{
		
		Submit_query4(){
			super();
			createSubmitQuery4();
		}
		public void createSubmitQuery4(){
			this.setSize(900,900);
			this.setVisible(true);
			JButton back=new JButton("Back");
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					new SystemHAS();
				}
			});
			String[] columns={"Hostel Name"};
			Object[][] data=null;
			ResultSet rs;
			PreparedStatement ps;
				try{
					Class.forName(DRIVER);
		            con = DriverManager.getConnection("jdbc:mysql://localhost/hostel_allocation_system",USER,PASSWORD);
		            ps=con.prepareStatement("select t1.hname from (select hid,hname,type,count(*) as value from hostel natural join room where status=? group by hid, type) as t1, (select hid,hname,type,count(*) as value from hostel natural join room where status=? group by hid,type) as t2 where t1.hid=t2.hid and t1.type=? And t2.type=? And t1.value>t2.value;");
		            ps.setString(1,"Occupied");
		            ps.setString(2, "Occupied");
		            ps.setInt(3, room_type1);
		            ps.setInt(4, room_type2);
		            rs=ps.executeQuery();
		          //  rs=ps.executeQuery();
			        int len=0;
			        while(rs.next())
			        	len++;
			        rs.absolute(0);
			        data=new Object[len][1];
			        for(int i=0;i<len;i++){
			        	rs.next();
			        	data[i][0]=rs.getString(1);
			        }
			        rs.close();
			        ps.close();
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}catch(SQLException e){
					e.printStackTrace();
				}
				JTable table = new JTable(data, columns);
		        this.add(new JScrollPane(table));
		        this.add(back);
		}
	}
	public class Query5_form{
		Query5_form(){
			panel.removeAll();
			panel.updateUI();
			panel.setLayout(new FlowLayout());
			JPanel panel2=new JPanel();
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
			panel2.setBackground(new Color(255,255,244));
			JPanel panel1=new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
			panel1.setBackground(new Color(255,255,244));
			panel2.setPreferredSize(new Dimension(200, 30));
			panel1.setPreferredSize(new Dimension(300, 30));
			JButton hid=new JButton("Hostel ID");
			JButton submit=new JButton("Submit");
			JButton back=new JButton("Back");

			JTextField f=new JTextField();
			f.setPreferredSize(new Dimension(50, 120));

			panel2.add(hid);
			panel1.add(f);
			panel.add(panel2);
			panel.add(panel1);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					new SystemHAS();
				}
			});
      		submit.addActionListener(new ActionListener(){
      			public void actionPerformed(ActionEvent ev){
      				String r=f.getText();
      				frame.setContentPane(new Submit_query5(r));
      			}
      		});
      		panel.add(submit);
      		panel.add(back);
      		frame.getContentPane().add(panel,BorderLayout.CENTER);

		}

		public int check_hid_in_database(String h){
			int hi=Integer.parseInt(h);
			//if(hi is present in the hostel database)
			//return 1
			//else
			return 0;
		}

	}
	
	public class Submit_query5 extends JPanel{
		String f;
		Submit_query5(String f){			
			super();
			this.f=f;
			createSubmitQuery5();
		}
		public void createSubmitQuery5(){
			this.setSize(900,900);
			this.setVisible(true);
			JButton back=new JButton("Back");
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					new SystemHAS();
				}
			});
			String[] columns={"Student Name"};
			Object[][] data=null;
			ResultSet rs;
			PreparedStatement ps;
				try{
					Class.forName(DRIVER);
		            con = DriverManager.getConnection("jdbc:mysql://localhost/hostel_allocation_system",USER,PASSWORD);
		            ps=con.prepareStatement("select sname,response from student natural join application natural join room natural join mess  where (messid in (select messid  from (select count(roomid) as total,messid  from room natural join mess  group by floor,messid) as t1,(select max(total) as max from (select count(roomid) as total,messid from room natural join mess group by floor,messid) as t3) as t2   where t1.total=t2.max and response=? and hid=?))");
		            ps.setString(1, "accepted");
		            ps.setInt(2, Integer.parseInt(f));
		            rs=ps.executeQuery();
		          //  rs=ps.executeQuery();
			        int len=0;
			        while(rs.next())
			        	len++;
			        rs.absolute(0);
			        data=new Object[len][1];
			        for(int i=0;i<len;i++){
			        	rs.next();
			        	data[i][0]=rs.getString(1);
			        }
			        rs.close();
			        ps.close();
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}catch(SQLException e){
					e.printStackTrace();
				}
				JTable table = new JTable(data, columns);
		        this.add(new JScrollPane(table));
		        this.add(back);
		}
	}

			
public static void main(String[] args){
		new SystemHAS();
	}

}
