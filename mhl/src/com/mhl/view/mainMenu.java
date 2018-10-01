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
	//创建jp1底下的7个标签
	JLabel jp1_jl1,jp1_jl2,jp1_jl3,jp1_jl4,jp1_jl5,jp1_jl6,jp1_jl7;
	//创建jp2底下的2个标签
	JLabel jp2_jl1,jp2_jl2;
	JLabel jl1;
	//创建jp3底下的7个jlabel
    JLabel jp3_jl1,jp3_jl2,jp3_jl3,jp3_jl4,jp3_jl5,jp3_jl6,jp3_jl7;
	//构建一个拆分窗口用来装jp2和jp3
	JSplitPane jsp = null;
	//定义两个卡片布局的对象
	CardLayout c1 ,c2;
	//创建一个鼠标的对象
	Cursor mycursor = new Cursor(Cursor.HAND_CURSOR );
	javax.swing.Timer t;                   //这是一个计数器，t.start()启动，现实ActionLister中的actionperform方法
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        mainMenu m = new mainMenu();
	}
	
	
	
	public void initMenu()
	{
      jmb = new JMenuBar();
		
		
		//创建二级菜单
		jmm1 = new JMenuItem("切换用户");
		jmm2= new JMenuItem("切换收款界面");
		jmm3= new JMenuItem("登陆管理");
		jmm4 = new JMenuItem("万历年");
		jmm5 = new JMenuItem("退出");
		
		//创建一级菜单
		jm1 =new JMenu("系统管理");
		//把二级菜单添加到这个一级菜单下
		jm1.add(jmm1);
		jm1.add(jmm2);
		jm1.add(jmm3);
		jm1.add(jmm4);
		jm1.add(jmm5);
		jm2 = new JMenu("人事管理");
		jm3 = new JMenu("菜单服务");
		jm4 = new JMenu("报表统计");
		jm5 = new JMenu("成本和库房");
		jm6 = new JMenu("帮助");
		
		
				
		//把一级菜单添加到jmenubar中
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
	}
	
	public void initToolBar()
	{
		//创建工具栏
				jtb = new JToolBar();
				jtb.setFloatable(false);
				jb1= new JButton("jb1");
				jb2 = new JButton("jb2");
				jb3 = new JButton("jb3");
				jb4 = new JButton("jb4");
				jb5 = new JButton("jb5");
				//把工具添加到工具栏
				jtb.add(jb1);
				jtb.add(jb2);
				jtb.add(jb3);
				jtb.add(jb4);
				jtb.add(jb5);
	}
	
	public void initPanel()
	{
		//创建jp4,jp1
				jp1 = new JPanel(new GridLayout(7,1));
				//创建jp1的7个标签
				jp1_jl1= new JLabel("餐饮系统",0);
				jp1_jl1.setEnabled(false);
				//更改鼠标的形状，在标签中设置
				jp1_jl1.setCursor(mycursor);
				//添加监听
		        jp1_jl1.addMouseListener(new MouseAdapter() {
		        	public void mouseClicked(MouseEvent e)
		        	{
		        		//鼠标点击时
		        		c2.show(jp3, "0");
		        	}
		        	
		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//鼠标触碰时
		        		jp1_jl1.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//鼠标离开时
		        		jp1_jl1.setEnabled(false);
		        	}
		        });
				jp1_jl2= new JLabel("系统管理",0);
				jp1_jl2.setEnabled(false);
				jp1_jl2.setCursor(mycursor);
				jp1_jl2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						c2.show(jp3, "1");
					}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//鼠标触碰时
		        		jp1_jl2.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//鼠标离开时
		        		jp1_jl2.setEnabled(false);
		        	}
				});
				jp1_jl3= new JLabel("人事管理",0);
				jp1_jl3.setEnabled(false);
				jp1_jl3.setCursor(mycursor);
				jp1_jl3.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						c2.show(jp3,"2");
					}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//鼠标触碰时
		        		jp1_jl3.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//鼠标离开时
		        		jp1_jl3.setEnabled(false);
		        	}
				});
				jp1_jl4 = new JLabel("菜单服务",0);
				jp1_jl4.setEnabled(false);
				jp1_jl4.setCursor(mycursor);
				jp1_jl4.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						c2.show(jp3, "3");
					}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//鼠标触碰时
		        		jp1_jl4.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//鼠标离开时
		        		jp1_jl4.setEnabled(false);
		        	}
				});
				jp1_jl5 = new JLabel("报表统计",0);
				jp1_jl5.setEnabled(false);
				jp1_jl5.setCursor(mycursor);
				jp1_jl5.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						c2.show(jp3, "4");
					}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//鼠标触碰时
		        		jp1_jl5.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//鼠标离开时
		        		jp1_jl5.setEnabled(false);
		        	}
				});
				jp1_jl6 = new JLabel("成本和库房",0);
				jp1_jl6.setEnabled(false);
				jp1_jl6.setCursor(mycursor);
				jp1_jl6.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						c2.show (jp3,"5");
					}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//鼠标触碰时
		        		jp1_jl6.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//鼠标离开时
		        		jp1_jl6.setEnabled(false);
		        	}
				});
				jp1_jl7 =new JLabel("帮助",0);
				jp1_jl7.setEnabled(false);
				jp1_jl7.setCursor(mycursor);
			    jp1_jl7.addMouseListener(new MouseAdapter() {
			    	public void mouseClicked(MouseEvent e)
			    	{
			    		c2.show (jp3,"6");
			    	}

		        	public void mouseEntered(MouseEvent e)
		        	{
		        		//鼠标触碰时
		        		jp1_jl7.setEnabled(true);
		        	}
		        	public void mouseExited(MouseEvent e)
		        	{
		        		//鼠标离开时
		        		jp1_jl7.setEnabled(false);
		        	}
			    });
				//把标签添加到jp1下
				jp1.add(jp1_jl1);
				jp1.add(jp1_jl2);
				jp1.add(jp1_jl3);
				jp1.add(jp1_jl4);
				jp1.add(jp1_jl5);
				jp1.add(jp1_jl6);
				jp1.add(jp1_jl7);
				
				jp4 = new JPanel(new BorderLayout());
				//jp2,jp3是卡片布局
				c1 = new CardLayout();
				jp2= new JPanel(c1);
				jp2_jl1 = new JLabel("右");
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
				jp2_jl2 = new JLabel("左");
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
				//把两个标签加入到jp2中,0和1是卡片的编号
				jp2.add(jp2_jl1,"0");
				jp2.add(jp2_jl2,"1");
				c2 = new CardLayout();
				jp3= new JPanel(c2);
				
				//创建jp3底下的7个jlabel
				jp3_jl1 = new JLabel("欢迎来到满汉楼餐饮系统",0);
				//jp3_jl2 = new JLabel("系统管理界面",0);
				EmpInfo emp = new EmpInfo();
				jp3_jl3 = new JLabel("人事管理界面",0);
				jp3_jl4 = new JLabel("菜单服务",0);
				jp3_jl5 = new JLabel("报表统计",0);
				jp3_jl6 = new JLabel("成本和库房",0);
				jp3_jl7= new JLabel("帮助",0);
				jp3.add(jp3_jl1,"0");
				jp3.add(emp,"1");
				jp3.add(jp3_jl3,"2");
				jp3.add(jp3_jl4,"3");
				jp3.add(jp3_jl4,"3");
				jp3.add(jp3_jl5,"4");
				jp3.add(jp3_jl6,"5");
				jp3.add(jp3_jl7,"6");
				//将jp2,jp3转入到jp4中
				jp4.add(jp2,"West");
				jp4.add(jp3,"Center");
				jsp= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT ,true,jp1,jp4);
				//设置jp1的宽度
				jsp.setDividerLocation(120);
				//设置边框的宽度
				jsp.setDividerSize(0);
				
				
				//创建状态栏,jp5上放jl1,jp6上放jp5，都是boderlayout
				jp5 = new JPanel();
				jp6 = new JPanel();
				jp6.setLayout(new BorderLayout());
				jl1 = new JLabel(new java.util.Date().toString());
				//创建一个计时器,每一秒触发一次
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
		
		//把工具栏添加到jframe上
		this.add(jtb,"North");
		this.add(jsp, "Center");
		this.add(jp6,"South");
		this.setJMenuBar(jmb);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("满汉楼餐饮");
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
