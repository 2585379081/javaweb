package com.mhl.dao;
import java.sql.*;
import javax.swing.*;
import java.awt.*;


public class sqlHelper {
   public Connection ct= null;
   public PreparedStatement ps = null;
   public ResultSet rs =null;
   String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   String url = "jdbc:sqlserver://localhost:1433;databasename=res";
   String username = "sa";
   String pwd = "";
   
   
   
   public sqlHelper()
   {
	   try {
		Class.forName(driver);
		ct = DriverManager.getConnection(url,username,pwd);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		
	}
	   
   }
   
   
   public ResultSet query(String sql,String []param)
   {
	   try {
		ps= ct.prepareStatement(sql);
		for( int i = 0;i<param.length;i++)
		{
			ps.setString(i+1, param[i]);
		}
		rs = ps.executeQuery();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   return rs;
   }
   
   
   
   
   public Boolean update(String sql,String [] param) {
	   Boolean flag = false;
	   
	   
	   try {
		   ps= ct.prepareStatement(sql);
			for( int i = 0;i<param.length;i++)
			{
				ps.setString(i+1, param[i]);
			}
		   int i = ps.executeUpdate();
		   if(i ==1)
		   {
			   flag = true;
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	      
	   
	   return flag;
   }
   
   public void close()
   {
		try {
			  if(rs!=null)  rs.close();
			  if(ps!= null) ps.close();
			   if(ct!= null) ct.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   
   
   
   
   
   
   
   
}
