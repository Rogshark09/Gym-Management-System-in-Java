import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.Color;

class HomepageF extends JFrame implements ActionListener
{
	JMenuBar mb;
	JMenu m1,m2,m3,m4,m5,m6,m7,m8;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi13,mi14,mi15,mi16,mi17,mi18,mi19,mi20,mi21,mi22,mi23;

	public HomepageF()
	{
	      setTitle("Home Page");
	      setVisible(true);
	      setLayout(null);
	      getContentPane().setBackground(Color.GRAY);
	      mb=new JMenuBar();
	      m1=new JMenu("Member tab");
	      m2=new JMenu("Trainer tab");
	      m3=new JMenu("Staff tab");
	      m4=new JMenu("Plans");
	      
	      m5=new JMenu("Maintenance");
	      m6=new JMenu("Attendance");
	      m7=new JMenu("Report");

	      mi1=new JMenuItem("Add Member");
	      mi2=new JMenuItem("Update Member");
	      mi3=new JMenuItem("Remove Member");

	      mi4=new JMenuItem("Add Trainer");
	      mi5=new JMenuItem("Update Trainer");
	      mi6=new JMenuItem("Remove Trainer");

	      mi7=new JMenuItem("Add Staff");
	      mi8=new JMenuItem("Update Staff");
	      mi9=new JMenuItem("Remove Staff");

	      mi10=new JMenuItem("Plan Details");

            mi11=new JMenuItem("Maintenance Reports");

	     
	      mi13=new JMenuItem("Member Attendance");
	      mi14=new JMenuItem("Staff Trainer");
	      mi15=new JMenuItem("Trainer Attendance");

	      mi16=new JMenuItem("Member Reports");
	      mi17=new JMenuItem("Trainer Reports");
	      mi18=new JMenuItem("Staff Reports");
	      mi19=new JMenuItem("Plans Reports");
	      mi20=new JMenuItem("Maintenance Reports");
	      mi21=new JMenuItem("Member Attendance Reports");
	      mi22=new JMenuItem("Staff Attendance Reports");
	      mi23=new JMenuItem("TrainerAttendance Reports");

	     mb.add(m1); mb.add(m2); mb.add(m3); mb.add(m4); mb.add(m5); mb.add(m6); mb.add(m7);

	     m1.add(mi1); m1.add(mi2); m1.add(mi3);

	     m2.add(mi4); m2.add(mi5); m2.add(mi6);

	     m3.add(mi7); m3.add(mi8); m3.add(mi9);

	     m4.add(mi10);

	     m5.add(mi11);

	     m6.add(mi13); m6.add(mi14); m6.add(mi15);

	     m7.add(mi16); m7.add(mi17); m7.add(mi18); m7.add(mi19); m7.add(mi20); m7.add(mi21); m7.add(mi22); m7.add(mi23);

	     setJMenuBar(mb);
	     setBounds(0,0,1920,1080);
	     mi1.addActionListener(this);
	     mi2.addActionListener(this);
	     mi3.addActionListener(this);
	     mi4.addActionListener(this);
	     mi5.addActionListener(this);
	     mi6.addActionListener(this);
	     mi7.addActionListener(this);
	     mi8.addActionListener(this);
	     mi9.addActionListener(this);
	     mi10.addActionListener(this);
	     mi11.addActionListener(this);
	     mi13.addActionListener(this);
	     mi14.addActionListener(this);
	     mi15.addActionListener(this);
	     mi16.addActionListener(this);
	     mi17.addActionListener(this);
	     mi18.addActionListener(this);
	     mi19.addActionListener(this);
	     mi20.addActionListener(this);
	     mi21.addActionListener(this);
	     mi22.addActionListener(this);
	     mi23.addActionListener(this);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==mi1)
		{
			new AddMemmberF();
			setVisible(false);
		}
		if(ae.getSource()==mi2)
		{
			new UpdateMemberF();
			setVisible(false);
		}
		if(ae.getSource()==mi3)
		{
			new DeleteMemmberF();
			setVisible(false);
		}
		if(ae.getSource()==mi4)
		{
			new AddTrainerF();
			setVisible(false);
		}
		if(ae.getSource()==mi5)
		{
			new UpdateTrainerF();
			setVisible(false);
		}
		if(ae.getSource()==mi6)
		{
			new DeleteTrainerF();
			setVisible(false);
		}
		if(ae.getSource()==mi7)
		{
			new AddStaffF();
			setVisible(false);
		}
		if(ae.getSource()==mi8)
		{
			new UpdateStaffF();
			setVisible(false);
		}
		if(ae.getSource()==mi9)
		{
			new DeleteStaffF();
			setVisible(false);
		}
		if(ae.getSource()==mi10)
		{
			  new planFrame();
			setVisible(false);
		}
		if(ae.getSource()==mi11)
		{
			  new Maintenanceframe();
			setVisible(false);
		}
		if(ae.getSource()==mi13)
		{
			  new MemberAttendanceF();
			setVisible(false);
		}
		if(ae.getSource()==mi14)
		{
			  new StaffAttendanceF();
			setVisible(false);
		}
		if(ae.getSource()==mi15)
		{
			  new TrainerAttendanceF();
			setVisible(false);
		}
		if(ae.getSource()==mi16)
		{
			 new memberreports();
			setVisible(false);
		}
		if(ae.getSource()==mi17)
		{
			 new trainerreports();
			setVisible(false);
		}
		if(ae.getSource()==mi18)
		{
			new staffreports();
			setVisible(false);
		}
		if(ae.getSource()==mi19)
		{
			new planreports();
			setVisible(false);
		}
		if(ae.getSource()==mi20)
		{
			new Maintenanceframe();
			setVisible(false);
		}
		if(ae.getSource()==mi21)
		{
			new memberattenreports();
			setVisible(false);
		}
		if(ae.getSource()==mi22)
		{
			new staffattenreports();
			setVisible(false);
		}
		if(ae.getSource()==mi22)
		{
			new trainerattenreports();
			setVisible(false);
		}
	}
}
class myHomePage
{
      public static void main(String[] args) 
      {
      	new HomepageF();
      }
}