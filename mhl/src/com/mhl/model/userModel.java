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
		//构建sql语句和参数集，然后调用sqlHelper中的query方法
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
			//跳到window2
			System.out.println("应该跳到收款的界面");
		}
		else {
			JOptionPane.showMessageDialog(null,"没有权限");
		}
	}
}
