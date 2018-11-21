import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


class Back1 extends Thread implements ActionListener{

static JFrame k,dlf,jk;
static JLabel l1,dll,iconl;
JFrame j;
JLabel l,n,i,u,u1,jkl;
static TextField tfn,tfi,m,m1,dlt,jkt;
JButton b1,b2,b3,b4,b5;
static JTable jt;
static JButton dlb,jkb;
Icon io;

public void run(){
	
	
	//JFrame
	System.out.println(Thread.currentThread().getName());
	j=new JFrame("DOCTOR MANAGEMENT SOFTWARE");
	j.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	b1=new JButton("SHOW");
	b2=new JButton("CLOSE");
	b3=new JButton("INSERT");
	b4=new JButton("DELETE");
	b5=new JButton("UPDATE");
	io=new ImageIcon("SHARDA.jpg");
	JLabel iconl=new JLabel(io);
	iconl.setBounds(600,100,525,346);
	l=new JLabel("WELCOME TO SHARDA HOSPITAL");
	n=new JLabel("DOCTOR ID:");
	i=new JLabel("DOCTOR NAME:");
	u=new JLabel("GENDER:");
	u1=new JLabel("AILMENT TYPE:");
	tfn=new TextField("ENTER ID");
	tfi=new TextField("ENTER NAME");
	m=new TextField("ENTER GENDER");
	m1=new TextField();
	tfn.setBounds(240,130,200,30);
	tfi.setBounds(240,210,200,30);
	m.setBounds(240,290,200,30);
	m1.setBounds(240,370,200,30);
	n.setBounds(100,120,100,60);
	i.setBounds(100,200,100,60);
	l.setBounds(350,20,800,100);
	u.setBounds(100,270,100,60);
	u1.setBounds(100,360,130,60);
	b1.setBounds(200,500,100,60);
	b3.setBounds(400,500,100,60);
	b2.setBounds(600,500,100,60);
	b4.setBounds(800,500,100,60);
	b5.setBounds(1000,500,100,60);
	Container c=j.getContentPane();
	l.setFont(new Font("Serif", Font.BOLD, 40));
	l.setForeground(Color.RED);
	c.add(tfn);
	c.add(tfi);
	c.add(b1);
	c.add(iconl);
	c.add(b2);
	c.add(u);
	c.add(u1);
	c.add(m);
	c.add(m1);
	c.add(b3);
	c.add(b4);
	c.add(b5);
	c.add(l);
	c.add(n);
	c.add(i);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	//j.addWindowListener(new WindowEventListener());
	j.setSize(1600,700);
	c.setLayout(null);
	j.setVisible(true);
}
class Get extends Thread{
public void run(){
	try{
	get();}catch (Exception e){}
}	
public void get() throws Exception
{
System.out.println(Thread.currentThread().getName());
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","welcome");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from doctor1");
ResultSetMetaData rsmt=rs.getMetaData();
int c=rsmt.getColumnCount();
Vector column=new Vector(c);
for(int i=1;i<=c;i++){
	column.add(rsmt.getColumnName(i));
}
Vector data=new Vector();
Vector row=new Vector();
while(rs.next())
{
	
	row=new Vector(c);
	for(int i=1;i<=c;i++){
		row.add(rs.getString(i));
	}
	data.add(row); 
//System.out.println(rs.getString(1)+" "+rs.getInt(2));
}
k=new JFrame("front Frame");
k.setSize(500,500);
k.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
JPanel panel =new JPanel();
jt=new JTable(data,column);
JScrollPane jsp=new JScrollPane(jt);
panel.setLayout(new BorderLayout());
panel.add(jsp,BorderLayout.CENTER);
k.setContentPane(panel);
k.setVisible(true);
rs.close();
st.close();
}
}
public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;
}
public static void set()throws Exception
{	
	String id=tfn.getText();
	String name=tfi.getText();
	String gender=m.getText();
	String Address=m1.getText();
	String check1="male";
	String check2="female";
	if(isInteger(id) &&( (gender.equalsIgnoreCase(check1)) || (gender.equalsIgnoreCase(check2)))){
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","welcome");
	Statement st=con.createStatement();
 String q1 = "insert into doctor1 values('" +id+ "', '" +name+ "', '" +gender+ "', '" +Address+ "')"; 
            int x = st.executeUpdate(q1); 
            if (x > 0) {            
                System.out.println("Successfully Inserted");
			JOptionPane.showMessageDialog(null, "INSERTED");}
            else            
                System.out.println("Insert Failed");	
}
else{JOptionPane.showMessageDialog(null, "Wrong input!");}
}

public static void delete(){
	dlf=new JFrame("delete frame");
	Container cc=dlf.getContentPane();
	dll=new JLabel("ENTER ID:");
	dlt=new TextField("enter id");
	dlb=new JButton("delete");
	dll.setBounds(50,50,60,30);
	dlt.setBounds(130,50,80,30);
	dlb.setBounds(120,150,80,40);
	dlb.addActionListener(new Del0());
	cc.add(dll);
	cc.add(dlt);
	cc.add(dlb);
	dlf.setSize(300,300);
	dlf.setLayout(null);
	dlf.setVisible(true);
	
	
}

public static void update(){
	String name1=tfi.getText();
	String gender1=m.getText();
	String Address1=m1.getText();
	String check11="male";
	String check22="female";
	//int rid=Integer.parseInt(Back.jkt.getText());
	String rid=tfn.getText();
	
	if(isInteger(rid) && (gender1.equalsIgnoreCase(check11)) || (gender1.equalsIgnoreCase(check22))){
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","welcome");
	
            PreparedStatement ps = con.prepareStatement("UPDATE doctor1 SET NAME = ?, GENDER=?, ADDRESS= ? WHERE ID = ?");
			
			ps.setString(1,name1);
			ps.setString(2,gender1);
			ps.setString(3,Address1);
			ps.setString(4,rid);
			int x=ps.executeUpdate(); 
			//st.executeUpdate(q1);
			/*int x=st.executeUpdate(q1);
            */if (x > 0) {            
                System.out.println("Successfully Updated");
				JOptionPane.showMessageDialog(null, "UPDATED");}
            else            
			{System.out.println("Updation failed Failed");
			JOptionPane.showMessageDialog(null, "UPDATION FAILED");}

	}	catch(Exception exp){}
	
}else {JOptionPane.showMessageDialog(null, "wrong input!");}
	
}	



public void actionPerformed(ActionEvent e){
	
	try{
	if (e.getSource()==b1){
	System.out.println("hi!");
	Get ge=new Get();
	Thread t6=new Thread(ge,"Third Thread");
	t6.start();
	//Back.get();
	
	}
	if(e.getSource()==b2){
		System.out.println("program terminated sucessfully");
		System.exit(0);
	}
	if(e.getSource()==b3){
		Back1.set();
		
	}
	if (e.getSource()==b4){delete();}
	if (e.getSource()==b5){update();}
	
}catch (Exception ee){}
}
}




class Del0 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
		String did=Back1.dlt.getText();
		System.out.println("working!");
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","welcome");
		Statement st=con.createStatement();
		String q2 = "delete doctor1 where D_id=('"+did+"')"; 
            int x = st.executeUpdate(q2); 
            if (x > 0) {            
                System.out.println("Successfully Deleted!");
			JOptionPane.showMessageDialog(null, "DELETED");}
            else            
			{System.out.println("DELETION FAILED");
			JOptionPane.showMessageDialog(null, "DELETION FAILED");}			
		}catch (Exception eeee){}
		
	
	}
}