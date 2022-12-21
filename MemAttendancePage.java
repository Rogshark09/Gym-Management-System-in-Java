import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.Color;
class MemberAttendanceF extends JFrame implements ActionListener
{
	JRadioButton rb1,rb2;
	ButtonGroup bg;
	JButton b1,b2; 
	JLabel lb1,lb2,lb3,lb4,lb5;
	JTextField tf1,tf2,tf5;

	public MemberAttendanceF()
	{
		setTitle("Member Attendance");
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(Color.GRAY);
		rb1=new JRadioButton("Present");
		rb2=new JRadioButton("Absent");

		bg=new ButtonGroup();

		b1=new JButton("Save");
		b2=new JButton("Home Page");

		lb1=new JLabel("Member Attendance");
		lb2=new JLabel("Member ID");
		lb3=new JLabel("Member Name");
		lb4=new JLabel("Select  Present/Absent");
		lb5=new JLabel("Date");

		tf1=new JTextField("");
		tf2=new JTextField("");
		tf5=new JTextField("");
		

		lb1.setBounds(250,200,200,30);
		lb2.setBounds(150,300,100,30);
		lb3.setBounds(150,400,100,30);
		lb4.setBounds(150,500,200,30);
		lb5.setBounds(150,600,100,30);

		tf1.setBounds(250,300,100,40);
		tf2.setBounds(250,400,200,40);
		tf5.setBounds(250,600,100,40);

		b1.setBounds(150,700,100,30);
		b2.setBounds(270,700,100,30);

	    rb1.setBounds(350,500,100,30);
        rb2.setBounds(480,500,100,30);

		bg.add(rb1);
		bg.add(rb2);

		add(rb1);
		add(rb2);

		add(b1);
		add(b2);

		add(lb1);
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);

		add(tf1);
		add(tf2);
		add(tf5);
		setBounds(0,0,1920,1080);
		b1.addActionListener(this);
		b2.addActionListener(this);


	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{
				int flag=0;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				String a="'"+tf1.getText()+"'";
				String b="'"+tf2.getText()+"'";
				String c="";
				if(rb1.isSelected())
				{
					c="'"+"present"+"'";
				}
				if(rb2.isSelected())
				{
					c="'"+"absent"+"'";
				}
				String d="'"+tf5.getText()+"'";
				String q="insert into attendance_table(Member_Id,Member_Name,A_Record,Date)values("+a+","+b+","+c+","+d+")";
				System.out.println(q);
				st.executeUpdate(q);
				st.close();
				con.close();
				JFrame f1=new JFrame();
				JOptionPane.showMessageDialog(f1,"Record Inserted Successfully");
				tf1.setText("");
				tf2.setText("");
				tf5.setText("");
				b1.setEnabled(false);
			
		}
			catch(Exception e){ System.out.println(e);}
}
			if(ae.getSource()==b2)
			{
				new HomepageF();
				setVisible(false);
			}
			}
		}
	


class myMemAttendance
{
	public static void main(String [] args)
	{
		new MemberAttendanceF();
	}
}