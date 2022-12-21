import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
import java.awt.Color;

class AddMemmberF extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
	JTextField tf1,tf2,tf3,tf5,tf6;
	JTextArea tf4;
	JButton b1,b2,b3;
	Connection con;
	Statement st;
	ResultSet rs;
	JComboBox c1;
	public AddMemmberF()
	{
		setTitle("Add Member");

		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.GRAY);
		lb1=new JLabel("Date");
		lb2=new JLabel("Member ID");
		lb3=new JLabel("Name");
		lb4=new JLabel("Address");
		lb5=new JLabel("Contact");
		lb6=new JLabel("Plan");
		lb7=new JLabel("Fees");
		tf1=new JTextField("");
		tf2=new JTextField("");
		tf3=new JTextField("");
		tf4=new JTextArea("");
		tf5=new JTextField("");
		tf6=new JTextField("");
		b1=new JButton("Save");
		b2=new JButton("HomePage");
		b3=new JButton("Compute");
		lb1.setBounds(250,100,100,30);
		tf1.setBounds(250,150,150,40);

		lb2.setBounds(250,250,100,30);
		tf2.setBounds(250,300,150,40);

		lb3.setBounds(550,250,100,30);
		tf3.setBounds(550,300,400,40);

		lb4.setBounds(250,360,100,30);
		tf4.setBounds(250,400,600,60);

		lb5.setBounds(250,480,100,30);
		tf5.setBounds(250,520,300,40);

		lb6.setBounds(250,630,150,40);

		lb7.setBounds(550,630,150,40);
		tf6.setBounds(620,630,150,50);

		b1.setBounds(350,850,150,40);
		b2.setBounds(550,850,150,40);
		b3.setBounds(800,630,150,50);
		
		
		setBounds(0,0,1920,1080);
		
		
		add(lb1);
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);
		add(lb6);
		add(lb7);

		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);

		add(b1);
		add(b2);
		add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		java.util.Date d=new java.util.Date();
		int dd=d.getDate();
		int m=d.getMonth()+1;
		int y=d.getYear()-100;
		String dat=dd+"-"+m+"-"+"20"+y;
		tf1.setText(dat);
		tf1.setEnabled(false);
		           		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                                  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                                  
			st=con.createStatement();
                                  		System.out.println("1");
			rs=st.executeQuery("select distinct(plan_name) from plan_table");
                                  		System.out.println("2");
                                      		if(rs==null)
                                     		System.out.println("null");
                                                                    		System.out.println("3");
			Vector v=new Vector();
                                  
			while(rs.next()){
                                  
                                  	 String    	ids=rs.getString(1) ;
                                  
			 v.add(ids);	
                              

		}
	                	c1 =new JComboBox(v);
		c1.setBounds(300,630,150,50);
		add(c1);
		st.close();
		rs.close();

               }catch(Exception e){}  

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
			String f=tf6.getText();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				st.executeUpdate("insert into member_table(Date,Member_Id,Name,Address,Contact,Fees)values("+a+","+b+","+c+","+d+","+e+","+f+")");
				st.close();
				con.close();
				Frame f1=new Frame();
				JOptionPane.showMessageDialog(f1,"Information Saved Successfully");
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
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
		if(ae.getSource()==b3)
		{
			    try
				{
						Class.forName("com.mysql.jdbc.Driver");
                                  
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                                  
						st=con.createStatement();
                                  		System.out.println("1");
                                  		String from = "'"+(String)c1.getSelectedItem()+"'";
						rs=st.executeQuery("select fees from plan_table where plan_name="+from+"");
						rs.next();
						tf6.setText(rs.getString(1)+"");
						rs.close();
						st.close();
						con.close();
            	}
            	catch(Exception e){

            	}
		}
	}
}
class MyMember
{
	public static void main(String [] args)
	{
		new AddMemmberF();
	}
}