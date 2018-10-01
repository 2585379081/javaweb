package com.mhl.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class index extends JWindow implements Runnable{

	JPanel jp = null;
	JLabel jl = null;
	Font f = new Font("宋体",ABORT,16);
	JProgressBar jpb =null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		index i =new index();
		Thread t = new Thread(i);
		t.start();

	}
	
	
	public index()
	{
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heigh = Toolkit.getDefaultToolkit().getScreenSize().height;
		jl = new JLabel("                 正在加载");
		jl.setFont(f);
		
		//创建进度条
		jpb=new JProgressBar();
		//设置进度条属性
		jpb.setStringPainted(true);//显示当前进度值信息
		jpb.setIndeterminate(false);//确定进度条执行完成后不来回滚动
		jpb.setBorderPainted(false);//设置进度条边框不显示
		jpb.setBackground(Color.darkGray);//设置进度条的背景色

		
		
		this.setSize(400,300);
		this.setLocation(width/2-200,heigh/2-150);
		this.add(jl,BorderLayout.CENTER);
		this.add(jpb,BorderLayout.SOUTH);       
		this.setVisible(true);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		int []progressValue={0,14,17,26,35,75,86,94,100};
		while(true)
		{
			for(int i = 0;i<progressValue.length;i++)
			{
			    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    jpb.setValue(progressValue[i]);
		    }
		    //关闭这个窗口，跳转到登陆界面
		    this.dispose();
		    System.out.close();
		    new login();
		    break;
		    
		}
		
	}

}
