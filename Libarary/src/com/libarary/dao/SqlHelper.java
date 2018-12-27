package com.libarary.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.websocket.Decoder.BinaryStream;

public class SqlHelper {
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url ="jdbc:sqlserver://localhost:1433;databasename=Libarary";
	private String user="sa";
	private String pwd="";

	private Connection ct;
	private PreparedStatement ps = null;
	private ResultSet rs =null;


	public  SqlHelper()
	{
	    try {
	    	Class.forName(driver);
			ct = DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ResultSet query(String sql,String [] param)
	{
	    
	    try{
	    ps = ct.prepareStatement(sql);
	    for(int i = 0;i<param.length;i++)
	    {
	    	ps.setString(i+1,param[i]);
	    }
	    rs = ps.executeQuery();
	    
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    }finally
	    {
	    	
	    }
	    return rs;
	}

	
	public Boolean writeImage(String sql ,InputStream bs,String []param) {
		Boolean b = false;

		 try{
			    ps = ct.prepareStatement(sql);
			    ps.setBinaryStream(1,bs);
			    for(int i = 0;i<param.length;i++)
				 {
				   	ps.setString(i+2,param[i]);
				 }
			    
				if(ps.executeUpdate()>0)
				 {
				    b= true;
				 }
				
			    }catch(Exception e)
			    {
			    	e.printStackTrace();
			    }finally
			    {
			    	
			    }	
		
		
		return b;
	}

	public Boolean update(String sql,String [] param)
	{
		Boolean flag = false;
		
		 try{
			    ps = ct.prepareStatement(sql);
			    for(int i = 0;i<param.length;i++)
				 {
				   	ps.setString(i+1,param[i]);
				 }
			    
				if(ps.executeUpdate()>0)
				 {
				    flag = true;
				 }
				
			    }catch(Exception e)
			    {
			    	e.printStackTrace();
			    }finally
			    {
			    	
			    }	
		
		return flag;
	}



	   public void close()
	   {
		   try{
		   if(rs!=null) rs.close();
		   if(ps!=null) ps.close();
		   if(ct!= null) ct.close();
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	   }

}