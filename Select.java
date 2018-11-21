import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


class Select extends Thread implements ActionListener{

JFrame jj;
JButton bb1,bb2;

Select(){
	
	jj=new JFrame("select");
	Container cc=jj.getContentPane();
	bb1=new JButton("PATIENT");
	bb2=new JButton("DOCTOR");
	bb1.setBounds(50,100,100,100);
	bb2.setBounds(200,100,100,100);
	bb1.addActionListener(this);
	bb2.addActionListener(this);
	
	cc.add(bb1);
	cc.add(bb2);
	jj.setSize(350,350);
	jj.setLayout(null);
	jj.setVisible(true);
	
	
}

public void actionPerformed(ActionEvent e ){
	if(e.getSource()==bb1){
		Back bbo=new Back();
		Thread t4=new Thread(bbo,"fourth thread");
		t4.start();
	}
	if(e.getSource()==bb2){
		Back1 bbo=new Back1();
		Thread t5=new Thread(bbo,"final thread");
		t5.start();
		
	}
	
	
}

}