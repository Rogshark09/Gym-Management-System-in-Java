import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
class planFrame extends JFrame implements ActionListener
{
  JLabel lb1,lb2,lb3,lb4,lb5;
  JTextField tf1,tf2,tf3,tf4,tf5;
  JButton b1,b2,b3,b4,b5;

  public planFrame()
  {
    setLayout(null);
    getContentPane().setBackground(Color.GRAY);
    lb1=new JLabel("Plan Id");
    lb2=new JLabel("Plan Name");
    lb3=new JLabel("Plan Duration(M)");
    lb4=new JLabel("Plan Fees");
    tf1=new JTextField();
    tf2=new JTextField();
    tf3=new JTextField();
    tf4=new JTextField();
    b1=new JButton("save");
    b2=new JButton("update");
    b3=new JButton("delete");
    b4=new JButton("homepage");
    b5=new JButton("cancel");
    lb1.setBounds(180,100,200,40);
    lb2.setBounds(180,170,200,40);
    lb3.setBounds(180,240,200,40);
    lb4.setBounds(180,310,200,40);
    tf1.setBounds(320,100,200,40);
    tf2.setBounds(320,170,200,40);
    tf3.setBounds(320,240,200,40);
    tf4.setBounds(320,310,200,40);
    
    b1.setBounds(80,400,150,40);
    b2.setBounds(260,400,150,40);
    b3.setBounds(450,400,150,40);
    b4.setBounds(150,480,150,40);
    b5.setBounds(330,480,150,40);
    add(lb1);add(lb2);add(lb3);add(lb4);
    add(b1);add(b2);add(b3);add(b4);add(b5);
    add(tf1);add(tf2);add(tf3);add(tf4);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    setBounds(0,0,1920,1080);
    setTitle("Plans");
    setVisible(true);
  }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==b1)
    {
      try
      {
        int a=Integer.parseInt(tf1.getText());
        String b="'"+tf2.getText()+"'";
        String c="'"+tf3.getText()+"'";
        int d=Integer.parseInt(tf4.getText());
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
        Statement st=con.createStatement();
        st.executeUpdate("insert into plan_table values("+a+","+b+","+c+","+d+")");
        st.close();
        con.close();
        JFrame f1=new JFrame();
        JOptionPane.showMessageDialog(f1,"Plan Added Successfully");
        setVisible(false);
        new planFrame();
      } catch(Exception e){System.out.println(e);}
    }
    if(ae.getSource()==b2)
    {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
        Statement st=con.createStatement();
        int id=Integer.parseInt(tf1.getText());
        String a="'"+tf2.getText()+"'";
        String b="'"+tf3.getText()+"'";
        int c=Integer.parseInt(tf4.getText());
        st.executeUpdate("update plan_table set plan_name="+a+",duration="+b+",fees="+c+" where plan_id="+id+"");
        JFrame f2=new JFrame();
        JOptionPane.showMessageDialog(f2,"Plan Updated Successfully");
        setVisible(false);
        new planFrame();
        st.close();
        con.close();
      } catch(Exception e1){System.out.println(e1);}
    }
    if(ae.getSource()==b3)
    {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
        Statement st=con.createStatement();
        int x=Integer.parseInt(tf1.getText());
        
        st.executeUpdate("delete from plan_table where plan_id="+x+"");
        JFrame f2=new JFrame();
        JOptionPane.showMessageDialog(f2,"Plan Deleted Successfully");
        setVisible(false);
        new planFrame();
        st.close();
        con.close();
      } catch(Exception e1){System.out.println(e1);}
    }
    if(ae.getSource()==b4)
    {
      new HomepageF();
      setVisible(false);
    }
    if(ae.getSource()==b5)
    {
      System.exit(0);
    }
    
  }
}
class myplan
{
  public static void main(String cp[])
  {
    new planFrame();
  }
}