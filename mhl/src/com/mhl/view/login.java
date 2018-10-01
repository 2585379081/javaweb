package com.mhl.view;

import javax.print.attribute.standard.JobName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.mhl.*;
import com.mhl.model.*;



public class login extends JDialog implements ActionListener{

	JPanel jp = null;
	JLabel jName ,JPwd;
	JTextField jtf;
	JPasswordField jpf;
	JButton jb1 ,jb2;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       login l = new login();
	}
	
	
	public login()
	{
		jp = new JPanel();
		jName = new JLabel("用户名");
		JPwd =new JLabel("密码");
		jtf =new JTextField();
		jpf = new JPasswordField();
		jb1 =new JButton("确定");
		jb1.addActionListener(this);
		jb2 = new JButton("取消");
		
		this.add(jp);
		jp.setLayout(null);
		//this.setUndecorated(true);
		
		jp.add(jName);
		jName.setBounds(100,100,100,20);
		jp.add(jtf);
		jtf.setBounds(200,100,100,20);
		jp.add(JPwd);
		JPwd.setBounds(100,130,100,20);
		jp.add(jpf);
		jpf.setBounds(200,130,100,20);
		jp.add(jb1);
		jb1.setBounds(100,200,80,30);
		jp.add(jb2);
		jb2.setBounds(200,200,80,30);
		
		
		
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heigh = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(400, 300);
		this.setVisible(true);
		this.setLocation(width/2-200, heigh/2-150);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==jb1){
			//如果按下确定键
			userModel um = new userModel();
			String id = jtf.getText().trim();
			String pwd =String.valueOf( jpf.getPassword() );
			//System.out.println(id+""+pwd);
			String pos = um.getPos(id, pwd);
			um.checkUser(pos);
			this.dispose();
		}
	}
	

}
