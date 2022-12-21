import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.Color;
import java.util.*;



class UpdateMemberF extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
	JTextField tf1,tf2,tf3,tf5,tf6,tf7;
	JTextArea tf4;
	JButton b1,b2,b3,b4;
	String name,address,contact;
	int Member_Id;
	Connection con;
	Statement st;
	ResultSet rs;
	JComboBox c1;

	public UpdateMemberF()
	{
		setTitle("Update Member");
		setVisible(true);
		setLayout(null);
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
		tf7=new JTextField("");

		b1=new JButton("Update ");
		b2=new JButton("HomePage");
		b3=new JButton("Enter");
		b4=new JButton("Compute");

		lb1.setBounds(250,200,100,30);
		tf1.setBounds(250,250,150,40);

		lb2.setBounds(480,200,100,30);
		tf2.setBounds(480,250,150,40);

		b3.setBounds(370,350,150,40);

		lb3.setBounds(250,400,100,30);
		tf3.setBounds(250,450,400,40);

		lb4.setBounds(250,500,100,30);
		tf4.setBounds(250,550,600,60);

		lb5.setBounds(250,620,100,30);
		tf5.setBounds(250,670,300,40);

		lb6.setBounds(650,650,100,30);

		lb7.setBounds(870,650,100,30);
		tf6.setBounds(920,650,150,40);
		



		b1.setBounds(250,780,150,40);
		b2.setBounds(450,780,150,40);
		b4.setBounds(1100,650,150,40);


		setBounds(0,0,1280,720);
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
		add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
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
		c1.setBounds(700,650,150,50);
		add(c1);
		st.close();
		rs.close();

               }catch(Exception e){}  
		

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b3)
		{
			try
			{
				int u=Integer.parseInt(tf2.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from member_table");
				int flag=0;
				System.out.println("1");
				while(rs.next())
				{
					System.out.println("2");
					Member_Id=rs.getInt(3);
					System.out.println("memberid"+Member_Id);
					if(u==Member_Id)
					{
						System.out.println("3");
						name=rs.getString(4);
						address=rs.getString(5);
						contact=rs.getString(6);
						tf3.setText(name);
						tf4.setText(address);
						tf5.setText(contact);
						flag=1;
						break;
					}
				}
				JFrame f1=new JFrame();
				if(flag==1)
				{
					JOptionPane.showMessageDialog(f1,"Member Record Found");
				}
				else
				{
					JOptionPane.showMessageDialog(f1,"Member record not found");
				}
				st.close();
				con.close();
			}
			catch(Exception g)
			{
				System.out.println(g);
			}
		}
			if(ae.getSource()==b1)
			{
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				int Member_Id=Integer.parseInt(tf2.getText());
				String a="'"+tf3.getText()+"'";
				String b="'"+tf4.getText()+"'";
				String c=tf5.getText();
				String d=tf6.getText();
				String q="update member_table set name="+a+",address="+b+",contact="+c+",fees="+d+" where member_id="+Member_Id+"";
				System.out.println(q);
				st.executeUpdate(q);
				JFrame f2=new JFrame();
				JOptionPane.showMessageDialog(f2,"member record updated");
				setVisible(false);
				new HomepageF();
				st.close();
				con.close();
				}
				catch(Exception g1)
				{
					System.out.println(g1);
				}
			}

				if(ae.getSource()==b4)
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
			if(ae.getSource()==b2)
		        {
			     new HomepageF();
			     setVisible(false);
                }
                

		}
	}



class myUpdateMember
{
	public static void main(String [] args)
	{
		new UpdateMemberF();
	}
}