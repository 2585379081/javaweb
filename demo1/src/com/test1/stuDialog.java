package com.test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class stuDialog extends JDialog implements ActionListener {

	JLabel jl1,jl2,jl3,jl4;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JPanel jp1,jp2;
	JButton jb;
	
	  Vector columndata;
	    Vector rowdata;
	    Connection ct = null;
	    PreparedStatement ps = null;
	    ResultSet rs= null;
	
	public stuDialog ()
	{
		jl1 = new JLabel ("学号");
		jl2 = new JLabel ("性别");
		jl3 = new JLabel("姓名");
		jl4 = new JLabel("家庭");
		
		
		jtf1 = new JTextField(38);
		jtf2= new JTextField(38);
		jtf3 = new JTextField(38);
		jtf4 = new JTextField(38);
		
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jb = new JButton("确定");
		jb.addActionListener(this);
		
		
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jl2);
		jp1.add(jtf2);
		jp1.add(jl3);
		jp1.add(jtf3);
		jp1.add(jl4);
		jp1.add(jtf4);
		
		jp2.add(jb);
		
		this.add(jp1);
		this.add(jp2, "South");
		this.setSize(400,300);
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		
		if(a.getSource() ==jb) {
			
			columndata = new Vector();
		     rowdata = new Vector();
		     columndata.add("学号");
		     columndata.add("性别");
		     columndata.add("姓名");
		     columndata.add("住址");
		     
		 	
				String stuId= jtf1.getText();
				String stuSex = jtf2.getText();
				String stuName = jtf3.getText();
				String stuHome = jtf4.getText();
				String sql = "insert into stu values(?,?,?,?)";
				
				//System.out.println(sql);

	    	 //1加载驱动
	    	 try {
	    		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename = demo","sa","");
	            ps = ct.prepareStatement(sql);
	            ps.setString(1, stuId);
	            ps.setString(2, stuSex);
	            ps.setString(3,stuName);
	            ps.setString(4, stuHome);
	           // ps.executeQuery();   ExecuteQuery()是来查询的，返回结果集
	            ps.executeUpdate();
	            
	            this.dispose(); //关闭对话框
	            
	            
				
//				while(rs.next())
//				{
//					 Vector hang = new Vector();
//					 hang.add(rs.getString(1));
//					 hang.add(rs.getString(2));
//					 hang.add(rs.getString(3));
//					 hang.add(rs.getString(4));
//			         rowdata.add(hang);
//
//				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		}
		
	}
	
	
	
	
}
