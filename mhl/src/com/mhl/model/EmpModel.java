/**
 * 这个是一个emp的抽象模型，实现了abstractTableModel
 */

package com.mhl.model;
import javax.swing.*;
import javax.swing.table.*;
import com.mhl.dao.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class EmpModel extends AbstractTableModel {

	public Vector cols ;
	public Vector  rows;
	
	//根据id对表进行删除
	public void deleteByNo(String sql,String [] param){
		sqlHelper sh = new sqlHelper();
		if(sh.update(sql,param))
		{
			JOptionPane.showMessageDialog(null,"删除成功");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "删除失败");
		}
	}
	
	
	public void query(String sql,String [] param) 
	{
	     sqlHelper sh = new sqlHelper();
	     ResultSet rs = sh.query(sql, param);
	     
	     try {
	    	 //想办法得到列的个数，和属性名
	    	 ResultSetMetaData rsmd = rs.getMetaData();
	    	 cols = new Vector();
	    	 for(int i = 0;i<rsmd.getColumnCount();i++)
	    	 {
	    		 cols.add(rsmd.getColumnName(i+1));
	    	 }
	    	 rows = new Vector();
	    	 rows.add(cols);
	    	 //这里是进行取数据
			while(rs.next()) 
			 {
				//temp是一行数据
				 Vector temp = new Vector();
				 for(int i = 0;i<rsmd.getColumnCount();i++)
				 {
					 temp.add(rs.getString(i+1));
				 }
				 rows.add(temp);
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sh.close();
		}
	}
	
	
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows.size();
	}

	@Override
	public Object getValueAt(int a1, int a2) {
		// TODO Auto-generated method stub
		return ((Vector)rows.get(a1)).get(a2).toString();
	}




//	@Override
//	public String getColumnName(int arg0) {
//		// TODO Auto-generated method stub
//		return  cols.get(arg0).toString();
//	}
//	
//	
	

}
