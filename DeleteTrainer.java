import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.Color;

class DeleteTrainerF extends JFrame implements ActionListener
{
	JLabel lb2,lb3,lb4,lb5,lb6;
	JTextField tf2,tf3,tf4,tf6;
	JTextArea tf5;
	JButton b1,b2,b3;
	String name,address,contact,experience;
	int Trainer_Id;

	public DeleteTrainerF()
	{
		setTitle("Delete Trainer");
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(Color.GRAY);
		
		lb2=new JLabel("Trainer ID");
		lb3=new JLabel("Name");
		lb4=new JLabel("Experience");
		lb5=new JLabel("Address");
		lb6=new JLabel("Contact");

		
		tf2=new JTextField("");
		tf3=new JTextField("");
		tf4=new JTextField("");
		tf5=new JTextArea("");
		tf6=new JTextField("");

		b1=new JButton("Delete");
		b2=new JButton("Home Page");
		b3=new JButton("Enter");

	

		lb2.setBounds(250,300,100,30);
		tf2.setBounds(250,350,100,30);

		b3.setBounds(250,400,100,30);

		lb3.setBounds(250,450,100,30);
		tf3.setBounds(250,500,200,40);

		lb4.setBounds(250,550,100,30);
		tf4.setBounds(250,600,100,30);

		lb5.setBounds(250,650,100,30);
		tf5.setBounds(250,700,200,60);

		lb6.setBounds(250,750,100,30);
		tf6.setBounds(250,800,200,40);


		b1.setBounds(250,870,100,30);
		b2.setBounds(400,870,100,30);

		setBounds(0,0,1920,1080);
		
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);
		add(lb6);

	
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
				ResultSet rs=st.executeQuery("select * from trainer_table");
				int flag=0;
				System.out.println("1");
				while(rs.next())
				{
					System.out.println("2");
					Trainer_Id=rs.getInt(3);
					System.out.println("trainerid"+Trainer_Id);
					if(u==Trainer_Id)
					{
						System.out.println("3");
						name=rs.getString(4);
						experience=rs.getString(5);
						address=rs.getString(6);
						contact=rs.getString(7);
						tf3.setText(name);
						tf4.setText(experience+"");
						tf5.setText(address);
						tf6.setText(contact+"");
						flag=1;
						break;
					}
				}
				JFrame f1=new JFrame();
				if(flag==1)
				{
					JOptionPane.showMessageDialog(f1,"Trainer Record Found");
				}
				else
				{
					JOptionPane.showMessageDialog(f1,"Trainer record not found");
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
				int Trainer_Id=Integer.parseInt(tf2.getText());
				String a="'"+tf3.getText()+"'";
				String b="'"+tf4.getText()+"'";
				String c="'"+tf5.getText()+"'";
				String d=tf6.getText();
				String q="delete from  trainer_table  where trainer_id="+Trainer_Id+"";
				System.out.println(q);
				st.executeUpdate(q);
				JFrame f2=new JFrame();
				JOptionPane.showMessageDialog(f2,"Trainer record deleted");
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
class myTrainerDelete
{
	public static void main(String [] args)
	{
		new DeleteTrainerF();
	}
}