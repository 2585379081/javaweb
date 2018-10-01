package com.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class stuTabel extends AbstractTableModel{
   
	  Vector columndata;
	    Vector rowdata;
	    Connection ct = null;
	    PreparedStatement ps = null;
	    ResultSet rs= null;
	    

	
	public void init(String sql)
	{
		
		if(sql == "")
		{
			sql = "select * from stu";
		}
		 columndata = new Vector();
	     rowdata = new Vector();
	     columndata.add("学号");
	     columndata.add("性别");
	     columndata.add("姓名");
	     columndata.add("住址");
	     
	     

    	 //1加载驱动
    	 try {
    		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename = demo","sa","");
            ps = ct.prepareStatement(sql);
            rs = ps.executeQuery();
			
			while(rs.next())
			{
				 Vector hang = new Vector();
				 hang.add(rs.getString(1));
				 hang.add(rs.getString(2));
				 hang.add(rs.getString(3));
				 hang.add(rs.getString(4));
		         rowdata.add(hang);

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    	 
    
	
	
	
	}
	    
	    
	public stuTabel()
	{
		init("");
		
	}
	
	
	
	
	public stuTabel(String sql)
	{
		init(sql);
		
	}
	
	//写一个构造函数创建表格


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
		
		return columndata.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowdata.size();
	}

	@Override
	public Object getValueAt(int row ,int column) {
		// TODO Auto-generated method stub
		return ((Vector)rowdata.get(row)).get(column);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
	
//	public void addStu(String sql)
//	{
//		 columndata = new Vector();
//	     rowdata = new Vector();
//	     columndata.add("学号");
//	     columndata.add("性别");
//	     columndata.add("姓名");
//	     columndata.add("住址");
//	     
//	     
//
//    	 //1加载驱动
//    	 try {
//    		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename = demo","sa","");
//            ps = ct.prepareStatement(sql);
//            rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				 Vector hang = new Vector();
//				 hang.add(rs.getString(1));
//				 hang.add(rs.getString(2));
//				 hang.add(rs.getString(3));
//				 hang.add(rs.getString(4));
//		         rowdata.add(hang);
//
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//	}
//}
