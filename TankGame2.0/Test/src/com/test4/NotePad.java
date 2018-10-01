package com.test4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotePad extends JFrame implements ActionListener{

	private JTextArea ta;
	private JMenuBar jb=null;
	private JMenu jm;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	
	
	public static void main(String [] args) {
	    NotePad np = new NotePad();
		
	}
	
	
	
	NotePad()
	{
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		ta = new JTextArea();
		jb = new JMenuBar();
		jm = new JMenu("文件");
		openItem =new JMenuItem("打开");
		openItem.addActionListener(this);
		saveItem = new JMenuItem("保存");
		saveItem.addActionListener(this);
		
		
		this.setJMenuBar(jb);
		this.add(ta);
		jb.add(jm);
		jm.add(openItem);
		jm.add(saveItem);
		

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==openItem)
		{
			JFileChooser jfc = new JFileChooser();
			jfc.setToolTipText("打开文件");
			jfc.showOpenDialog(null);
			jfc.setVisible(true);
			
			String  str = jfc.getSelectedFile().getAbsolutePath();
			BufferedReader bufr= null;
			String line = null;
			String allLine= null;
			try {
				 bufr = new BufferedReader(new FileReader(str));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			try {
				while((line=bufr.readLine())!=null)
				{
				   allLine +=line+"\r\n";
				   
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ta.setText(allLine);
		   
			try {
				bufr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		else if(e.getSource()==saveItem)
		{
			JFileChooser jfc =new JFileChooser();
			jfc.setToolTipText("另存为");
			jfc.showSaveDialog(null);
			jfc.setVisible(true);
			
			String str = jfc.getSelectedFile().getAbsolutePath();
			
			BufferedWriter bufw= null;
			try {
				bufw = new BufferedWriter(new FileWriter(str));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				bufw.write(this.ta.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				bufw.close();                                //记得要关闭文件，不关闭的话会出错
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
