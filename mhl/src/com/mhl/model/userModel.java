package com.mhl.model;

import com.mhl.*;
import com.mhl.dao.*;
import com.mhl.view.mainMenu;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class userModel {

	public ResultSet rs = null;
	
	
	public String getPos(String id,String pwd)
	{
		String pos ="";
		
		
		sqlHelper sh = new sqlHelper();
		//����sql���Ͳ�������Ȼ�����sqlHelper�е�query����
		String sql = "select pos from login,emp where login.id=emp.id and login.id = ? and login.pwd = ?";
		String [] param = {id,pwd};
		rs =sh.query(sql, param);
		try {
			if(rs.next())
				pos = rs.getString(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sh.close();
		}
		
		return pos;
	}
	
	
	public void checkUser(String pos)
	{
		if(pos.equals("manager")||pos.equals("admin"))
		{
			new mainMenu();
		}else if(pos.equals("saler"))
		{
			//����window2
			System.out.println("Ӧ�������տ�Ľ���");
		}
		else {
			JOptionPane.showMessageDialog(null,"û��Ȩ��");
		}
	}
}
