import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.Color;
   class planreports extends JFrame implements ActionListener
{
	JLabel l0,l1,l2;
	JButton b1,btnBack;
	JComboBox c1;
	Connection con;
	Statement st;
	ResultSet rs,rs1;
	String ids;
	static JTable table;
	String[] columnnames={"Plan ID","Plan Name","Duration","Fees"};
	String from;
	JFrame frame1;
	public planreports()
	{
		getContentPane().setBackground(Color.GRAY);
		l0=new JLabel("Fetching Plan Information");
		l0.setForeground(Color.RED);
		l0.setFont(new Font("Elephant",Font.BOLD,25));
		l1=new JLabel(" Plan Name");
		b1=new JButton("Submit");
		btnBack=new JButton("Home");
		l0.setBounds(500,40,400,60);
     l1.setBounds(400,200,200,40);
	   	b1.setBounds(400,350,200,40);
		btnBack.setBounds(650,350,200,40);
		c1.setBounds(500,200,200,40);
	   	b1.addActionListener(this);
		btnBack.addActionListener(this);
	     	setTitle("PLan Report ");
		setLayout(null);
	   	setVisible(true);
	   	setSize(1920,1080);
	   	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
           		add(l0);
	   	add(l1);
	   	add(b1);
		add(btnBack);
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
                                  
                                  	     	ids=rs.getString("plan_name") ;
                                  
			 v.add(ids);	
                              

		}
	                	c1 =new JComboBox(v);
			c1.setBounds(500,200,200,40);
		add(c1);
		st.close();
		rs.close();

               }catch(Exception e){}  
		}
		public void actionPerformed(ActionEvent ae)
		{
                                                   if(ae.getSource()==b1)
			showTableData();
			if(ae.getSource()==btnBack)
			{
				setVisible(false);
				new HomepageF();
				//btnUpdate.setEnabled(false);
			}

		 }
		public void showTableData()
		{
		  frame1=new JFrame("Plan Information from Database Search");
		  frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 		 frame1.setLayout(new BorderLayout());
		  DefaultTableModel model=new  DefaultTableModel();
		  model.setColumnIdentifiers(columnnames);
		  table = new JTable();
		  table.setModel(model);
		  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		  //table.setFillsViewportHeight(true);
                                       //  table.getScrollableTracksViewportHeight();
		  JScrollPane scroll = new JScrollPane(table);
		  scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		  scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                  from = (String)c1.getSelectedItem();
		  
		 String i2,i3,i4;
		  try
		  {
		   PreparedStatement pst=con.prepareStatement("select * from plan_table where plan_name='"+from+"' " );
	           rs=pst.executeQuery();
		   int i=0;int i1;
		   while(rs.next())
		   {
		     i1=rs.getInt(1);     i2=rs.getString(2);    i3=rs.getString(3);    i4=rs.getString(4);	
		     

		      model.addRow(new Object[]{i1,i2,i3,i4});		
		      i++;			      

                      }	 
                     if(i<1)
		      JOptionPane.showMessageDialog(null,"No Record Found","Error",JOptionPane.ERROR_MESSAGE);

                      }catch(Exception e){
                    		      JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                             }
                       frame1.add(scroll);
		       frame1.setVisible(true);
		       frame1.setSize(1920,1080); 	


			}
  }
class PlanRep
{
  public static void main(String cp[])
  {
      new planreports();
    }
}