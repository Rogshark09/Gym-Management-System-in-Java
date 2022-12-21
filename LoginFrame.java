import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.Color;
	class LoginF extends JFrame implements ActionListener
	{
	
    		JButton b1;
    		JButton b2;
    	      JTextField tf1;
    	      JPasswordField tf2;
    		JLabel lb1;
    		JLabel lb2;
    		
		public LoginF()
		{
			setTitle("Login Form");
			setLayout(null);
			setVisible(true);
			getContentPane().setBackground(Color.GRAY);
			b1=new JButton("Login");
			b2=new JButton("Cancel");
			tf1=new JTextField();
			tf2=new JPasswordField();
                  lb1=new JLabel("Username");
                  lb2=new JLabel("Password");


			lb1.setBounds(350,220,200,30);
			tf1.setBounds(350,270,250,45);
		      lb2.setBounds(350,420,200,30);
		      tf2.setBounds(350,470,250,45);
			b1.setBounds(350,650,200,50);
			b2.setBounds(600,650,200,50);

			add(b1);
			add(b2);
			add(lb1);
			add(lb2);
			add(tf1);
			add(tf2);				
			setBounds(0,0,1920,1080);
			b1.addActionListener(this);
			b2.addActionListener(this);


		}
		public void actionPerformed(ActionEvent ae)
		{
			try
			{
				String u=tf1.getText();
				String p=tf2.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from admin");
				int flag=0;
				while(rs.next())
				{
					String uname=rs.getString("username");
					String pass=rs.getString(2);
					if(u.equals(uname)&&p.equals(pass))
					{
						flag=1;
						break;
					}
				}
				if(flag==1)
				{
					Frame f=new Frame();
					JOptionPane.showMessageDialog(f,"Login Successfull");
					setVisible(false);
					new HomepageF();
				}
				else
				{
					Frame f1=new Frame();
					JOptionPane.showMessageDialog(f1,"Invalid Login Details");
					tf1.setText("");
					tf2.setText("");
				}
			if(ae.getSource()==b2)
			{
				System.exit(0);
			}
		}
		catch(Exception e)
		{
			Frame f2=new Frame();
			JOptionPane.showMessageDialog(f2,"Transcation Failed"+e.getMessage());
			System.out.println(e);
		}
		}
		}
	

class myLogin
{
      public static void main(String[] args) 
      {
      	new LoginF();
      }
}