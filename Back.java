/*~by:ASHUTOSH AND SYED ATIF
	SECTION CSE A
	2017009226 and 201700
	
	DBMS PROJECT
	TOPIC-PATIENT MANAGEMENT SOFTWARE

*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class Login extends Thread implements ActionListener{
	static private String un="ashutosh";
	static private String pw="atif";
	JFrame jf;
	static Connection con;
	JLabel jl,jl1;
	JTextField jtf;
	JPasswordField jpf;
	JButton jb,jb1;
	public void run(){
		System.out.println(Thread.currentThread().getName());
		jf=new JFrame("LOGIN PAGE");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jf.addWindowListener(new WindowEventListener());
		Container cn=jf.getContentPane();
		jl=new JLabel("USERID:");
		jl1=new JLabel("PASSWORD:");
		jtf=new JTextField("");
		jpf=new JPasswordField();
		jb=new JButton("LOGIN");
		jb1=new JButton("CANCEL");
		jb.addActionListener(this);
		jb1.addActionListener(this);
		jl.setBounds(60,60,90,30);
		jl1.setBounds(60,150,90,30);
		jtf.setBounds(210,70,120,30);
		jpf.setBounds(210,160,120,30);
		jb.setBounds(150,360,120,60);
		jb1.setBounds(360,360,120,60);
		cn.add(jl);
		cn.add(jl1);
		cn.add(jtf);
		cn.add(jpf);
		cn.add(jb);
		cn.add(jb1);
		/*
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		jf.setLocation(dim.width/8-jf.getSize().width/8, dim.height/4-jf.getSize().height/4);
		*/
		//jf.setLocationRelativeTo(null); 
		jf.setSize(600,600);
		jf.setLayout(null);
		jf.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource()==jb){
			if(jtf.getText().equals(un) &&jpf.getText().equals(pw)){
				try{
					
					
					Select bb=new Select();
					Thread t0=new Thread(bb,"Second thread");
					t0.start();}catch (Exception eee){}
				//new Back();
				
				//maybe bug
			}
			else{
				JOptionPane.showMessageDialog(null, "LOGIN FAILED!!");
			}
		}
		if(ee.getSource()==jb1){
			System.exit(0);
		}
	}
}

class Back extends Thread implements ActionListener{
static JFrame k,dlf,jk;
static JLabel l1,dll,iconl;
JFrame j;
JLabel l,n,i,u,u1,jkl,al;
static TextField tfn,tfi,m,m1,dlt,jkt,at;
JButton b1,b2,b3,b4,b5;
static JTable jt;
static JButton dlb,jkb;
Icon io;

public void run(){
	
	
	//JFrame
	System.out.println(Thread.currentThread().getName());
	j=new JFrame("PATIENT MANAGEMENT SOFTWARE");
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
	n=new JLabel("PATIENT ID:");
	i=new JLabel("PATIENT NAME:");
	u=new JLabel("GENDER:");
	u1=new JLabel("PATIENT ADDRESS:");
	al=new JLabel("AILMENT TYPE:");
	tfn=new TextField("ENTER ID");
	tfi=new TextField("ENTER NAME");
	m=new TextField("ENTER GENDER");
	m1=new TextField("ENTER ADDRESS");
	at=new TextField("ENTER AILMENT");
	tfn.setBounds(240,130,200,30);
	tfi.setBounds(240,210,200,30);
	m.setBounds(240,290,200,30);
	m1.setBounds(240,370,200,30);
	n.setBounds(100,120,100,60);
	i.setBounds(100,200,100,60);
	l.setBounds(350,20,800,100);
	u.setBounds(100,270,100,60);
	u1.setBounds(100,360,130,60);
	al.setBounds(100,450,130,60);
	at.setBounds(240,450,200,30);
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
	c.add(al);
	c.add(at);
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
ResultSet rs=st.executeQuery("select * from patient1");
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
	String ailment=at.getText();
	String check1="male";
	String check2="female";
	if(isInteger(id) &&( (gender.equalsIgnoreCase(check1)) || (gender.equalsIgnoreCase(check2)))){
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","welcome");
	Statement st=con.createStatement();
 String q1 = "insert into patient1 values('" +id+ "', '" +name+ "', '" +gender+ "', '" +Address+ "', '" +ailment+ "')"; 
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
	dlb.addActionListener(new Del());
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
	String ailment=at.getText();
	String check11="male";
	String check22="female";
	//int rid=Integer.parseInt(Back.jkt.getText());
	String rid=tfn.getText();
	
	if(isInteger(rid) && (gender1.equalsIgnoreCase(check11)) || (gender1.equalsIgnoreCase(check22))){
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","welcome");
	
            PreparedStatement ps = con.prepareStatement("UPDATE patient1 SET NAME = ?, GENDER=?, ADDRESS= ?, ailment_type= ? WHERE ID = ?");
			
			ps.setString(1,name1);
			ps.setString(2,gender1);
			ps.setString(3,Address1);
			ps.setString(4,ailment);
			ps.setString(5,rid);
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
	Thread t2=new Thread(ge,"Third Thread");
	t2.start();
	//Back.get();
	
	}
	if(e.getSource()==b2){
		System.out.println("program terminated sucessfully");
		System.exit(0);
	}
	if(e.getSource()==b3){
		Back.set();
		
	}
	if (e.getSource()==b4){delete();}
	if (e.getSource()==b5){update();}
	
}catch (Exception ee){}
}
public static void main(String... s)throws Exception{
Login li=new Login();
Thread t1=new Thread(li,"First Thread");
t1.start();
//new Back();
//new Login();
}

}

class Del implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
		String did=Back.dlt.getText();
		System.out.println("working!");
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","welcome");
		Statement st=con.createStatement();
		String q2 = "delete patient1 where id=('"+did+"')"; 
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
/*class Upd implements ActionListener{
	public void actionPerformed(ActionEvent eeeee){
		
	//String id=Back.tfn.getText();
	Back bo=new Back();
	String name1=bo.tfi.getText();
	String gender1=bo.m.getText();
	String Address1=Bo.m1.getText();
	String check11="male";
	String check22="female";
	//int rid=Integer.parseInt(Back.jkt.getText());
	String rid=Back.jkt.getText();
	
	if( (gender1.equalsIgnoreCase(check11)) || (gender1.equalsIgnoreCase(check22))){
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","welcome");
	//Statement st=con.createStatement();
	//String q1 = "update patient1 set name=('" +name+ "')"+",gender=('" +gender+ "')"+",address=('" +Address+ "')"+"where id=('" +rid+ "')"; 
            PreparedStatement ps = con.prepareStatement("UPDATE patient1 SET NAME = ?, GENDER=?, ADDRESS= ? WHERE ID = ?");
			//ps.setString(1,id);
			ps.setString(1,name1);
			ps.setString(2,gender1);
			ps.setString(3,Address1);
			ps.setString(4,rid);
			ps.executeUpdate(); 
			//st.executeUpdate(q1);
			/*int x=st.executeUpdate(q1);
            if (x > 0) {            
                System.out.println("Successfully Updated");
				JOptionPane.showMessageDialog(null, "UPDATED");}
            /*else            
                System.out.println("Updation failed Failed");
				JOptionPane.showMessageDialog(null, "UPDATION FAILED");

		catch(Exception exp){}
	}
}
}
/*class WindowEventListener extends WindowAdapter
{
	public void windowClosing(WindowEvent e1)
	{
		System.out.println("program terminated sucessfully");
		
		System.exit(0);
		
	}
}*/