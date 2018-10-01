/**
 * ����������ʵemp����������jTable
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
      //�ȹ���jp1
	  jp1 =new JPanel(new FlowLayout(FlowLayout.CENTER));
	  jp1_jl1 = new JLabel("������Ҫ��ѯ��Ա����");
	  jp1_jtf1 = new JTextField(20);
	  jp1_jb1= new JButton("��ѯ");
	  
	  //��������ӵ�Jp1
	  jp1.add(jp1_jl1);
	  jp1.add(jp1_jtf1);
	  jp1.add(jp1_jb1);
	  
	  //����Jp2
	  jp2 = new JPanel(new BorderLayout());
	  em = new EmpModel(); 
	  String [] param = {"1"};
	  em.query("select id,name,age,address from rs where 1 =?", param);
	  jt1 = new JTable(em);
	  jp2.add(jt1);
	  
	  
	  //����jp3,��jp4
	  jp3 = new JPanel();
	  jp3_jl1 = new JLabel("��ǰ��������");
	  jp3.add(jp3_jl1);
	  jp4 = new JPanel();
	  jp4_jb1 = new JButton("��ϸ��Ϣ");
	  jp4_jb2= new JButton("���");
	  jp4_jb3 = new JButton("ɾ��");
	  jp4_jb3.addActionListener(this);
	  jp4_jb4 = new JButton("�޸�");
	  jp4.add(jp4_jb1);
	  jp4.add(jp4_jb2);
	  jp4.add(jp4_jb3);
	  jp4.add(jp4_jb4);
	  
	  jp5 = new JPanel();
	  jp5.setLayout(new BorderLayout());
	  jp5.add(jp3,"West");
	  jp5.add(jp4,"East");
	  
	  
	  //��ӵ���jpanel
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
		//�����¼������ɾ��ʱ
		int rowNo = jt1.getSelectedRow();
		String id =(String) em.getValueAt(rowNo, 0);
		System.out.println(id);
		//����empModel�е�ɾ������
		String [] param = {id};
		em.deleteByNo("delete from rs where id = ?", param);
		em = new EmpModel();
		String[] param2 = {"1"};
		em.query("select id,name,age,address from rs where 1 =?", param2);
		jt1.setModel(em);
	}
}
}
