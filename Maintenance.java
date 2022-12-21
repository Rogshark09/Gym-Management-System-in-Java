import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.Color;

class Maintenanceframe extends JFrame implements ActionListener
{
	JButton b1,b2;
	JLabel lb1, lb2, lb3, lb4, lb5;
	JTextField tf1,tf2,tf3,tf4;
	public Maintenanceframe()
	{
		setLayout(null);
		getContentPane().setBackground(Color.GRAY);
		b1 = new JButton("Insert");
		b2 = new JButton("HomePage");
		lb1 = new JLabel("Item Name");
		lb1.setBounds(100,200,100,40);
		add(lb1);
		lb2 = new JLabel("Charges");
		lb2.setBounds(100,300,100,40);
		add(lb2);
		lb3 = new JLabel("Date of Service");
		lb3.setBounds(100,400,100,30);
		add(lb3);
		lb4 = new JLabel("Person Responsible");
		lb4.setBounds(100,500,150,40);
		add(lb4);
		lb5 = new JLabel("Maintenance Details");
		lb5.setBounds(100,100,200,50);
		add(lb5);
		tf1 = new JTextField();
		tf1.setBounds(250,200,200,40);
	    add(tf1);
	    tf2 = new JTextField();
	    tf2.setBounds(250,300,200,40);
	    add(tf2);
	    tf3 = new JTextField();
	    tf3.setBounds(250,400,200,40);
	    add(tf3);
	    tf4 = new JTextField();
	    tf4.setBounds(250,500,200,40);
	    add(tf4);
		
		b1.setBounds(100,650,200,40);
		b2.setBounds(350,650,200,40);
		
		add(b1);
		add(b2);
		
		setTitle("Maintenance");
		setVisible(true);
		setBounds(0,0,1980,1080);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
				{
					String a="'"+tf1.getText()+"'";
					int b=Integer.parseInt(tf2.getText());
					String c="'"+tf3.getText()+"'";
					String d="'"+tf4.getText()+"'";
					try
					{
						System.out.println("1");

					   Class.forName("com.mysql.jdbc.Driver");
			           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","");
			            Statement st=con.createStatement();
			            st.executeUpdate("insert into maintenance (ItemName,Charges,DateofP,PersonResponsible)values("+a+","+b+","+c+","+d+")");
			            st.close();
			            con.close();
			            Frame f=new Frame();
			            JOptionPane.showMessageDialog(f,"Record Inserted Successfully");
			            tf1.setText("");
			            tf2.setText("");
			            tf3.setText("");
			            tf4.setText("");
				
			}
			catch(Exception g)
			{
				System.out.println(g);
			}
		}
		if(ae.getSource()==b2)
			{
				new HomepageF();
			}
	}	
}
class mymaintenance
{
	public static void main(String cp [])
	{
		new Maintenanceframe();
	}
}