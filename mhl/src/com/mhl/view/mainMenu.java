package com.mhl.view;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import com.mhl.view.*;

public class mainMenu extends JFrame implements ActionListener{

	JMenuBar jmb;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	JMenuItem jmm1,jmm2,jmm3,jmm4,jmm5;
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5;
	JPanel jp1,jp2,jp3,jp4,jp5,jp6;
	//����jp1���µ�7����ǩ
	JLabel jp1_jl1,jp1_jl2,jp1_jl3,jp1_jl4,jp1_jl5,jp1_jl6,jp1_jl7;
	//����jp2���µ�2����ǩ
	JLabel jp2_jl1,jp2_jl2;
	JLabel jl1;
	//����jp3���µ�7��jlabel
    JLabel jp3_jl1,jp3_jl2,jp3_jl3,jp3_jl4,jp3_jl5,jp3_jl6,jp3_jl7;
	//����һ����ִ�������װjp2��jp3
	JSplitPane jsp = null;
	//����������Ƭ���ֵĶ���
	CardLayout c1 ,c2;
	//����һ�����Ķ���
	Cursor mycursor = new Cursor(Cursor.HAND_CURSOR );
	javax.swing.Timer t;                   //����һ����������t.start()��������ʵActionLister�е�actionperform����
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        mainMenu m = new mainMenu();
	}
	
	
	
	public void initMenu()
	{
      jmb = new JMenuBar();
		
		
		//���������˵�
		jmm1 = new JMenuItem("�л��û�");
		jmm2= new JMenuItem("�л��տ����");
		jmm3= new JMenuItem("��½����");
		jmm4 = new JMenuItem("������");
		jmm5 = new JMenuItem("�˳�");
		
		//����һ���˵�
		jm1 =new JMenu("ϵͳ����");
		//�Ѷ����˵���ӵ����һ���˵���
		jm1.add(jmm1);
		jm1.add(jmm2);
		jm1.add(jmm3);
		jm1.add(jmm4);
		jm1.add(jmm5);
		jm2 = new JMenu("���¹���");
		jm3 = new JMenu("�˵�����");
		jm4 = new JMenu("����ͳ��");
		jm5 = new JMenu("�ɱ��Ϳⷿ");
		jm6 = new JMenu("����");
		
		
				
		//��һ���˵���ӵ�jmenubar��
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
	}
	
	public void initToolBar()
	{
		//����������
				jtb = new JToolBar();
				jtb.setFloatable(false);
				jb1= new JButton("jb1");
				jb2 = new JButton("jb2");
				jb3 = new JButton("jb3");
				jb4 = new JButton("jb4");
				jb5 = new JButton("jb5");
				//�ѹ�����ӵ�������
				jtb.add(jb1);
				jtb.add(jb2);
				jtb.add(jb3);
				jtb.add(jb4);
				jtb.add(jb5);
	}
	
	public void initPanel()
	{
		//����jp4,jp1
				jp1 = new JPanel(new GridLayout(7,1));
				//����jp1��7����ǩ
				jp1_jl1= new JLabel("����ϵͳ",0);
				jp1_jl1.setEnabled(false);
				//����������״���ڱ�ǩ������
				jp1_jl1.setCursor(mycursor);
				//��Ӽ���
		        jp1_jl1.addMouseListener(new MouseAdapter() {
		        	public void mouseClicked(MouseEvent e)
		        	{
		        		//�����ʱ
		        		c2.show(jp3, "0");
		        	}
		        	
		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//��괥��ʱ
		        		jp1_jl1.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//����뿪ʱ
		        		jp1_jl1.setEnabled(false);
		        	}
		        });
				jp1_jl2= new JLabel("ϵͳ����",0);
				jp1_jl2.setEnabled(false);
				jp1_jl2.setCursor(mycursor);
				jp1_jl2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						c2.show(jp3, "1");
					}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//��괥��ʱ
		        		jp1_jl2.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//����뿪ʱ
		        		jp1_jl2.setEnabled(false);
		        	}
				});
				jp1_jl3= new JLabel("���¹���",0);
				jp1_jl3.setEnabled(false);
				jp1_jl3.setCursor(mycursor);
				jp1_jl3.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						c2.show(jp3,"2");
					}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//��괥��ʱ
		        		jp1_jl3.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//����뿪ʱ
		        		jp1_jl3.setEnabled(false);
		        	}
				});
				jp1_jl4 = new JLabel("�˵�����",0);
				jp1_jl4.setEnabled(false);
				jp1_jl4.setCursor(mycursor);
				jp1_jl4.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						c2.show(jp3, "3");
					}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//��괥��ʱ
		        		jp1_jl4.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//����뿪ʱ
		        		jp1_jl4.setEnabled(false);
		        	}
				});
				jp1_jl5 = new JLabel("����ͳ��",0);
				jp1_jl5.setEnabled(false);
				jp1_jl5.setCursor(mycursor);
				jp1_jl5.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						c2.show(jp3, "4");
					}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//��괥��ʱ
		        		jp1_jl5.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//����뿪ʱ
		        		jp1_jl5.setEnabled(false);
		        	}
				});
				jp1_jl6 = new JLabel("�ɱ��Ϳⷿ",0);
				jp1_jl6.setEnabled(false);
				jp1_jl6.setCursor(mycursor);
				jp1_jl6.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						c2.show (jp3,"5");
					}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//��괥��ʱ
		        		jp1_jl6.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//����뿪ʱ
		        		jp1_jl6.setEnabled(false);
		        	}
				});
				jp1_jl7 =new JLabel("����",0);
				jp1_jl7.setEnabled(false);
				jp1_jl7.setCursor(mycursor);
			    jp1_jl7.addMouseListener(new MouseAdapter() {
			    	public void mouseClicked(MouseEvent e)
			    	{
			    		c2.show (jp3,"6");
			    	}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//��괥��ʱ
		        		jp1_jl7.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//����뿪ʱ
		        		jp1_jl7.setEnabled(false);
		        	}
			    });
				//�ѱ�ǩ��ӵ�jp1��
				jp1.add(jp1_jl1);
				jp1.add(jp1_jl2);
				jp1.add(jp1_jl3);
				jp1.add(jp1_jl4);
				jp1.add(jp1_jl5);
				jp1.add(jp1_jl6);
				jp1.add(jp1_jl7);
				
				jp4 = new JPanel(new BorderLayout());
				//jp2,jp3�ǿ�Ƭ����
				c1 = new CardLayout();
				jp2= new JPanel(c1);
				jp2_jl1 = new JLabel("��");
				jp2_jl1.setEnabled(false);
				jp2_jl1.setCursor(mycursor);
				jp2_jl1.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						jsp.setDividerLocation(1250);
						c1.show(jp2, "1");
					}
					public void mouseEntered(MouseEvent e)
					{
						jp2_jl1.setEnabled(true);
					}
					public void mouseExited(MouseEvent e)
					{
						jp2_jl1.setEnabled(false);
					}
				});
				jp2_jl2 = new JLabel("��");
				jp2_jl2.setEnabled(false);
				jp2_jl2.setCursor(mycursor);
				jp2_jl2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						jsp.setDividerLocation(120);
						c1.show(jp2, "0");
					}
					public void mouseEntered(MouseEvent e)
					{
						jp2_jl2.setEnabled(true);
					}
					public void mouseExited(MouseEvent e)
					{
						jp2_jl2.setEnabled(false);
					}
				});
				//��������ǩ���뵽jp2��,0��1�ǿ�Ƭ�ı��
				jp2.add(jp2_jl1,"0");
				jp2.add(jp2_jl2,"1");
				c2 = new CardLayout();
				jp3= new JPanel(c2);
				
				//����jp3���µ�7��jlabel
				jp3_jl1 = new JLabel("��ӭ��������¥����ϵͳ",0);
				//jp3_jl2 = new JLabel("ϵͳ�������",0);
				EmpInfo emp = new EmpInfo();
				jp3_jl3 = new JLabel("���¹������",0);
				jp3_jl4 = new JLabel("�˵�����",0);
				jp3_jl5 = new JLabel("����ͳ��",0);
				jp3_jl6 = new JLabel("�ɱ��Ϳⷿ",0);
				jp3_jl7= new JLabel("����",0);
				jp3.add(jp3_jl1,"0");
				jp3.add(emp,"1");
				jp3.add(jp3_jl3,"2");
				jp3.add(jp3_jl4,"3");
				jp3.add(jp3_jl4,"3");
				jp3.add(jp3_jl5,"4");
				jp3.add(jp3_jl6,"5");
				jp3.add(jp3_jl7,"6");
				//��jp2,jp3ת�뵽jp4��
				jp4.add(jp2,"West");
				jp4.add(jp3,"Center");
				jsp= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT ,true,jp1,jp4);
				//����jp1�Ŀ��
				jsp.setDividerLocation(120);
				//���ñ߿�Ŀ��
				jsp.setDividerSize(0);
				
				
				//����״̬��,jp5�Ϸ�jl1,jp6�Ϸ�jp5������boderlayout
				jp5 = new JPanel();
				jp6 = new JPanel();
				jp6.setLayout(new BorderLayout());
				jl1 = new JLabel(new java.util.Date().toString());
				//����һ����ʱ��,ÿһ�봥��һ��
				 t= new javax.swing.Timer(1000,this);
				 t.start();
				jp5.add(jl1);
				jp6.add(jp5,"East");
	}
	
	public mainMenu()
	{
		this.initMenu();
		
		this.initToolBar();
		
		this.initPanel();
		
		//�ѹ�������ӵ�jframe��
		this.add(jtb,"North");
		this.add(jsp, "Center");
		this.add(jp6,"South");
		this.setJMenuBar(jmb);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("����¥����");
		this.setSize(width, height-25);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		jl1.setText( new java.util.Date().toString());
		
	}



}
