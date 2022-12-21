import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.Color;
class AddStaffF extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3,lb4,lb5;
	JTextField tf1,tf2,tf3,tf5;
	JTextArea tf4;
	JButton b1,b2;

	public AddStaffF()
	{
		setTitle("Add Staff");
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.GRAY);
		lb1=new JLabel("Date");
		lb2=new JLabel("Staff ID");
		lb3=new JLabel("Name");
		lb4=new JLabel("Address");
		lb5=new JLabel("Contact");

		tf1=new JTextField("");
		tf2=new JTextField("");
		tf3=new JTextField("");
		tf4=new JTextArea("");
		tf5=new JTextField("");

		b1=new JButton("Save");
		b2=new JButton("Home Page");

		
		lb1.setBounds(250,200,100,30);
		tf1.setBounds(250,250,100,40);

		lb2.setBounds(250,300,100,30);
		tf2.setBounds(250,350,100,40);

		lb3.setBounds(250,400,100,30);
		tf3.setBounds(250,450,200,40);

		lb4.setBounds(250,500,100,30);
		tf4.setBounds(250,550,200,60);

		lb5.setBounds(250,620,100,30);
		tf5.setBounds(250,650,200,40);

		b1.setBounds(250,750,100,30);
		b2.setBounds(400,750,100,30);

		setBounds(0,0,1920,1080);
		add(lb1);
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);

		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);

		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		java.util.Date d=new java.util.Date();
		int dd=d.getDate();
		int m=d.getMonth()+1;
		int y=d.getYear()-100;
		String dat=dd+"-"+m+"-"+"20"+y;
		tf1.setText(dat);
		tf1.setEnabled(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()==b1)
		{
			String a="'"+tf1.getText()+"'";
			int b=Integer.parseInt(tf2.getText());
			String c="'"+tf3.getText()+"'";
			String d="'"+tf4.getText()+"'";
			String e=tf5.getText();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				st.executeUpdate("insert into staff_table(Date,Staff_Id,Name,Address,Contact)values("+a+","+b+","+c+","+d+","+e+")");
				st.close();
				con.close();
				Frame f1=new Frame();
				JOptionPane.showMessageDialog(f1,"Information Saved Successfully");
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
			}
			catch(Exception g)
			{
				System.out.println(g);
			}
		}
		if(ae.getSource()==b2);
		{
			new HomepageF();
		}
	}
}
class MyStaff
{
	public static void main(String [] args)
	{
		new AddStaffF();
	}
}