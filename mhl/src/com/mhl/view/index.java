package com.mhl.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class index extends JWindow implements Runnable{

	JPanel jp = null;
	JLabel jl = null;
	Font f = new Font("����",ABORT,16);
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
		jl = new JLabel("                 ���ڼ���");
		jl.setFont(f);
		
		//����������
		jpb=new JProgressBar();
		//���ý���������
		jpb.setStringPainted(true);//��ʾ��ǰ����ֵ��Ϣ
		jpb.setIndeterminate(false);//ȷ��������ִ����ɺ����ع���
		jpb.setBorderPainted(false);//���ý������߿���ʾ
		jpb.setBackground(Color.darkGray);//���ý������ı���ɫ

		
		
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
		    //�ر�������ڣ���ת����½����
		    this.dispose();
		    System.out.close();
		    new login();
		    break;
		    
		}
		
	}

}
