/**
 * 这是用来现实emp的类里面有jTable
 */


package com.mhl.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.mhl.dao.*;
import com.mhl.model.*;


public class EmpInfo extends JPanel implements ActionListener {
	
	public JPanel jp1,jp2,jp3,jp4,jp5;
	public JLabel jp1_jl1,jp3_jl1;
	public JTextField jp1_jtf1;
	public JButton jp1_jb1,jp4_jb1,jp4_jb2,jp4_jb3,jp4_jb4;
	JTable jt1;
	EmpModel em;
	
  public EmpInfo()
  {
      //先构建jp1
	  jp1 =new JPanel(new FlowLayout(FlowLayout.CENTER));
	  jp1_jl1 = new JLabel("请输入要查询的员工号");
	  jp1_jtf1 = new JTextField(20);
	  jp1_jb1= new JButton("查询");
	  
	  //将他们添加到Jp1
	  jp1.add(jp1_jl1);
	  jp1.add(jp1_jtf1);
	  jp1.add(jp1_jb1);
	  
	  //构建Jp2
	  jp2 = new JPanel(new BorderLayout());
	  em = new EmpModel(); 
	  String [] param = {"1"};
	  em.query("select id,name,age,address from rs where 1 =?", param);
	  jt1 = new JTable(em);
	  jp2.add(jt1);
	  
	  
	  //构建jp3,和jp4
	  jp3 = new JPanel();
	  jp3_jl1 = new JLabel("当前在线人数");
	  jp3.add(jp3_jl1);
	  jp4 = new JPanel();
	  jp4_jb1 = new JButton("详细信息");
	  jp4_jb2= new JButton("添加");
	  jp4_jb3 = new JButton("删除");
	  jp4_jb3.addActionListener(this);
	  jp4_jb4 = new JButton("修改");
	  jp4.add(jp4_jb1);
	  jp4.add(jp4_jb2);
	  jp4.add(jp4_jb3);
	  jp4.add(jp4_jb4);
	  
	  jp5 = new JPanel();
	  jp5.setLayout(new BorderLayout());
	  jp5.add(jp3,"West");
	  jp5.add(jp4,"East");
	  
	  
	  //添加到主jpanel
	  this.setLayout(new BorderLayout());
	  this.add(jp1, "North");
	  this.add(jp2, "Center");
	  this.add(jp5, "South");
	  this.setVisible(true);
  }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	if(e.getSource()==jp4_jb3){
		//监听事件当点击删除时
		int rowNo = jt1.getSelectedRow();
		String id =(String) em.getValueAt(rowNo, 0);
		System.out.println(id);
		//调用empModel中的删除方法
		String [] param = {id};
		em.deleteByNo("delete from rs where id = ?", param);
		em = new EmpModel();
		String[] param2 = {"1"};
		em.query("select id,name,age,address from rs where 1 =?", param2);
		jt1.setModel(em);
	}
}
}
