import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
public class ViewPanel extends JPanel{
	Connection con=null;
	public ViewPanel(){
		
		this.setSize(1000,1500);
		this.setVisible(true);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,600,50));
		//submit.setSize(150,40); submit.setFont(new Font("Arial",Font.PLAIN,30));


		
		String[] columns = new String[]{
            "Application ID", "Name", "Roll No.", "Room ID", "Hostel ID","Status", "Sex","Email","Stream"
        };
		int len=0;
		ResultSet rs;
    	PreparedStatement ps;
    	Object[][] data = null;
    	try{
    		Class.forName(SystemHAS.DRIVER);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_allocation_system",SystemHAS.USER,SystemHAS.PASSWORD); 
			ps = con.prepareStatement("select appid,sname,sid,roomid,hid,status,sex,email,stream from student natural join application natural join room where response=?");
			ps.setString(1, "pending");
			rs=ps.executeQuery();			
			while(rs.next()){
				len++;
			}
			rs.absolute(0);
			data = new Object[len][9];
			for(int i=0;i<len;i++){
				rs.next();
				//System.out.println("*");
				data[i][0] = rs.getInt(1);
				data[i][1] = rs.getString(2);
				data[i][2] = rs.getInt(3);
				data[i][3] = rs.getInt(4);
				data[i][4] = rs.getInt(5);
				data[i][5] = rs.getString(6);
				data[i][6] = rs.getString(7);
				data[i][7] = rs.getString(8);
				data[i][8] = rs.getString(9);
			}
			rs.close();
			ps.close();
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	//int i=5;
        
        JTable table = new JTable(data, columns);
        this.add(new JScrollPane(table));
	
		JButton back = new JButton("Back");
			back.setSize(200,80);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					SystemHAS.frame.setContentPane(new AdminLoggedIn());
				}
			});
			this.add(back);		

	}
	
}