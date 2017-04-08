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

public class SystemHAS{
	JFrame frame;
	JPanel panel;
	JLabel label;
	JButton bttn_str, bttn_exit, bttn_register;
	String stream_select="";
	SystemHAS(){
		frame=new JFrame();
		panel=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		JLabel label=new JLabel("Hostel Allocation System");
		bttn_str=new JButton("Login");
		bttn_exit=new JButton("Exit");
		bttn_register=new JButton("Register");

		bttn_str.setBackground(Color.CYAN);
		bttn_str.setOpaque(true);
		bttn_str.setBorderPainted(false);

		bttn_exit.setBackground(Color.CYAN);
		bttn_exit.setOpaque(true);
		bttn_exit.setBorderPainted(false);

		bttn_register.setBackground(Color.CYAN);
		bttn_register.setOpaque(true);
		bttn_register.setBorderPainted(false);

		panel.setLayout(null);
		label.setBounds(200,120,500,40);
		label.setFont(new Font("Arial",Font.BOLD,30));
		//bttn_str.setBounds(330,250,150,40);
		bttn_str.setBounds(330,250,150,40);
		bttn_register.setBounds(350,350,100,40);
		bttn_exit.setBounds(350,450,100,40);
		panel.add(label);
		panel.add(bttn_str);
		panel.add(bttn_register);
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
		String type_1_login;
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
		JButton username=new JButton("Username");
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
            		type_1_login="Admin";
            	}
         	}           
     	});	
		student.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {         
            	if(e.getStateChange()==1){
            		type_1_login="Student";
            	}
         	}           
     	});

     	JButton submit = new JButton("Submit");
     	JLabel error = new JLabel();

     	submit.addActionListener(new ActionListener(){
     		public void actionPerformed(ActionEvent ev){
     			String un=txt.getText();
     			String pass=txt5.getText();

     			if(un.equals("") || pass.equals("")){
     				JOptionPane.showMessageDialog(frame,"Invalid or empty field");
     				new Login_Form();
     			}
     			else{
     				if(type_1_login=="Admin"){
     					//access Admin database
     					//if(authenticate username and password)
     						new View_Admin();
     					//otherwise throw and error
     		// 			else{
     		// 				JOptionPane.showMessageDialog(frame,"wrong username or password");
							// new Login_Form();
     		// 			}

     				}
     				else if(type_1_login=="Student"){
     					//access student database
     					//if(authenticate username and password)
     						new View_Student();
     					//otherwise throw and error
     		// 			else{
     		// 				JOptionPane.showMessageDialog(frame,"wrong username or password");
							// new Login_Form();
     		// 			}

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
			txt2.setPreferredSize(new Dimension(40, 100));
			txt3.setPreferredSize(new Dimension(50, 120));
			txt4.setPreferredSize(new Dimension(50, 120));
			txt5.setPreferredSize(new Dimension(50, 120));
			txt6.setPreferredSize(new Dimension(50, 120));
			txt7.setPreferredSize(new Dimension(50, 120));

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

	public class View_Admin{

	}

	public class View_Student{

	}

			
public static void main(String[] args){
		new SystemHAS();
	}

}