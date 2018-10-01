package com.test2;

import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.*;
public class MyFrame extends JFrame {
JPanel pan;
Image image1 =null;
Image image2 = null;
Image image3= null;


MyFrame()
{
	pan = new JPanel();
	image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src/bomb_1.gif"));
	 image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src/bomb_2.gif"));
     image3= Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src/bomb_3.gif"));
     this.setSize(400,300);
     this.setLocationRelativeTo(null);
     this.add(pan);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);

}

public static void main(String []args)
{
	MyFrame mf= new MyFrame();
}
}
