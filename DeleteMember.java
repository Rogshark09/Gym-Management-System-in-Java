import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.Color;

class DeleteMemmberF extends JFrame implements ActionListener
{
	JLabel lb2,lb3,lb4,lb5;
	JTextField tf2,tf3,tf5;
	JTextArea tf4;
	JButton b1,b2,b3;
	String name,address,contact;
	int Member_Id;

	public DeleteMemmberF()
	{
		setTitle("Delete Member");
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(Color.GRAY);
		
		lb2=new JLabel("Member ID");
		lb3=new JLabel("Name");
		lb4=new JLabel("Address");
		lb5=new JLabel("Contact");

		
		tf2=new JTextField("");
		tf3=new JTextField("");
		tf4=new JTextArea("");
		tf5=new JTextField("");

		b1=new JButton("Delete");
		b2=new JButton("Home Page");
		b3=new JButton("Enter");

		

		lb2.setBounds(250,300,100,30);
		tf2.setBounds(250,350,100,30);

		b3.setBounds(250,400,100,30);

		lb3.setBounds(250,450,100,30);
		tf3.setBounds(250,500,200,40);

		lb4.setBounds(250,550,100,30);
		tf4.setBounds(250,600,200,60);

		lb5.setBounds(250,650,100,30);
		tf5.setBounds(250,700,200,40);

		b1.setBounds(250,800,100,30);
		b2.setBounds(400,800,100,30);


		setBounds(0,0,1920,1080);
		
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);

		
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);

		add(b1);
		add(b2);
		add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		

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
				String q="delete from  member_table  where member_id="+Member_Id+"";
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
			if(ae.getSource()==b2)
		        {
			     new HomepageF();
			     setVisible(false);
                }

		}
	
	}



class myDeleteMember
{
	public static void main(String [] args)
	{
		new DeleteMemmberF();
	}
}