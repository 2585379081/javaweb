/**
 * �����һ��emp�ĳ���ģ�ͣ�ʵ����abstractTableModel
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
	
	//����id�Ա����ɾ��
	public void deleteByNo(String sql,String [] param){
		sqlHelper sh = new sqlHelper();
		if(sh.update(sql,param))
		{
			JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
		}
	}
	
	
	public void query(String sql,String [] param) 
	{
	     sqlHelper sh = new sqlHelper();
	     ResultSet rs = sh.query(sql, param);
	     
	     try {
	    	 //��취�õ��еĸ�������������
	    	 ResultSetMetaData rsmd = rs.getMetaData();
	    	 cols = new Vector();
	    	 for(int i = 0;i<rsmd.getColumnCount();i++)
	    	 {
	    		 cols.add(rsmd.getColumnName(i+1));
	    	 }
	    	 rows = new Vector();
	    	 rows.add(cols);
	    	 //�����ǽ���ȡ����
			while(rs.next()) 
			 {
				//temp��һ������
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
