package com.test1;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class test extends JFrame implements ActionListener{
	
    JTable jt= null;
    JPanel jsp =null;
    JLabel jl = null;
    JTextField jtf = null;
    JButton jb1,jb2,jb3,jb4;
    JPanel jp1,jp2;
    stuTabel st= new stuTabel();
    
    
    Vector columndata;
    Vector rowdata;
    Connection ct = null;
    PreparedStatement ps = null;
    ResultSet rs= null;
  
	
 public static void main(String []args)
 {
	 test ts = new test();
 }
 
 public test()
 {
	 jp1 = new JPanel();
	 jp2 = new JPanel();
	 jl = new JLabel("�û���");
	 jtf = new JTextField(10);
	 jp1 = new JPanel();
	 jp2 = new JPanel();
	 jb1 =new JButton("��ѯ");
	 jb2 = new JButton("���");
	 jb3 = new JButton("�޸�");
	 jb4 = new JButton("ɾ��");
	 
	 jb1.addActionListener(this);
	 jb2.addActionListener(this);
	 jb3.addActionListener(this);
	 jb4.addActionListener(this);
	 
	 
     jsp = new JPanel();
   
     
     
    	 
    	 
    	 
   //  Vector hang = new Vector();
     //    rowdata.add(hang);
   
     
     jt = new JTable(new stuTabel());
      jsp.add(jt);

     jp1.add(jl);
     jp1.add(jtf);
     jp1.add(jb1);
     
     jp2.add(jb2);
     jp2.add(jb3);
     jp2.add(jb4);
     

     this.add(jsp,"Center");
     this.add(jp1,"North");
     this.add(jp2,"South");
     
     this.setSize(400,300);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
     this.setVisible(true);
 }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() ==jb1)
	{
	   //��ѯѧ��
		String str = jtf.getText().trim();
		String sql = "select * from stu where stuName = '"+ str+"'";
		 st = new stuTabel(sql);
	   jt.setModel(st);  //����setmodel������
		
	}
	else if(e.getSource() == jb2){
		//���ѧ��
		stuDialog std =new stuDialog();
	    //��stuTabel����Ӻ������е���
		
		//������ҳ���б�
		st=new stuTabel();
		jt.setModel(st);
		
		
	}
	else if(e.getSource() ==jb3)
	{
		//�޸�ѧ��������ѧ����ѧ�Ų��ܸ�
		
		
		int row = jt.getSelectedRow();
		if(row == -1)
		{
			JOptionPane.showMessageDialog(this, "��ѡ��һ��");
			
		}
		String stuId = (String)st.getValueAt(row,0);
		String stuSex = (String )st.getValueAt(row,1);
		String stuName =(String )st.getValueAt(row,2);
		String stuHome = (String )st.getValueAt(row,3);
		
		stuUpdDialog stud = new stuUpdDialog(stuId,stuSex,stuName,stuHome);
		
		st = new stuTabel();
		jt.setModel(st);
		
		
	}
	else if(e.getSource() ==jb4)
	{
		//ɾ��ѧ��
	 int row = jt.getSelectedRow();
	 if(row == -1)
	 {
		 JOptionPane.showMessageDialog(this,"��ѡ��һ��");
		 return;
	 }
	 String stuId = (String)st.getValueAt(row,0);
	 
	    
	 
	 //�������ݿ����ɾ��
	
     
    String  sql = "delete from stu where stuId = ?";

	 //1��������
	 try {
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename = demo","sa","");
        ps = ct.prepareStatement(sql);
        ps.setString(1, stuId);
        ps.executeUpdate();
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 
	 st = new stuTabel();
	 jt.setModel(st);
		
	}
	
	
	
}


 
}
