import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
public class RespondPanel extends JPanel{
	Connection con=null;
	public RespondPanel(){
		super();
		createRespondPanel();
	}
	public void createRespondPanel(){
		this.setSize(1000,1500);
		this.setVisible(true);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,600,50));
		JTextField appID = new JTextField(10); 
		JTextField response = new JTextField(10);
		JButton submit = new JButton("Submit");
		//submit.setSize(150,40); submit.setFont(new Font("Arial",Font.PLAIN,30));
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		box1.add(new JLabel("Application ID: ")); box1.add(Box.createHorizontalStrut(10)); box1.add(appID);
		box2.add(new JLabel("Response (Accepted/Rejected): ")); box2.add(Box.createHorizontalStrut(10)); box2.add(response);
		this.add(box1);
		this.add(box2);
		this.add(submit);
	
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String aid = appID.getText();
				String re = response.getText();
				SystemHAS.frame.setContentPane(new SubmittedPanel(aid,re));
			}
		});
		JButton back = new JButton("Back");
			back.setSize(200,80);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					SystemHAS.frame.setContentPane(new AdminLoggedIn());
				}
			});
			this.add(back);
	}
	class SubmittedPanel extends JPanel{
		public SubmittedPanel(String aid,String re){
			super();
			createSubmittedPanel(aid,re);
		}
		public void createSubmittedPanel(String aid, String re){
			this.setSize(1000,1500);
			this.setVisible(true);
			this.setLayout(new FlowLayout(FlowLayout.CENTER,600,50));
			JTextField txt = new JTextField(15); 
			txt.setText("Application "+aid+" "+re+"!");
			this.add(txt);
			ResultSet rs;
			PreparedStatement ps;
			try{
				Class.forName(SystemHAS.DRIVER);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_allocation_system",SystemHAS.USER,SystemHAS.PASSWORD);			
				ps=con.prepareStatement("update application set response=? where appid=?");
				ps.setString(1, re.toLowerCase());
				ps.setInt(2, Integer.parseInt(aid));
				ps.executeUpdate();
				//rs.close();
				ps.close();
				ps=con.prepareStatement("select roomid,count from room natural join application where appid=?");
				ps.setInt(1, Integer.parseInt(aid));
				rs=ps.executeQuery();
				rs.next();
				int rid=rs.getInt(1);
				int count=rs.getInt(2);
				rs.close();
				ps.close();
				ps=con.prepareStatement("update room set count=? where roomid=?");
				ps.setInt(1,count+1);
				ps.setInt(2, rid);
				ps.executeUpdate();
				//rs.close();
				ps.close();
				ps=con.prepareStatement("select count,type from room where roomid=?");
				ps.setInt(1, rid);
				rs=ps.executeQuery(); rs.next();
				count=rs.getInt(1);
				int type = rs.getInt(2);
				rs.close();
				ps.close();
				if(count==type){
					ps=con.prepareStatement("update room set status=? where roomid=?");
					ps.setString(1, "occupied");
					ps.setInt(2, rid);
					ps.executeUpdate();
//					rs.close();
					ps.close();
				}
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
			txt.setEditable(false);
			JButton back = new JButton("Back");
			back.setSize(200,80);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					SystemHAS.frame.setContentPane(new AdminLoggedIn());
				}
			});
			this.add(back);
			//Update response in database
			//check if type of room == count, set status of room as occupied
		}
	}
}