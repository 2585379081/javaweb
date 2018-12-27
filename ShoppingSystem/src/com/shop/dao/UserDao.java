package com.shop.dao;
import java.sql.*;
import com.shop.pojo.User;
import com.shop.tool.*;

public class UserDao {
	
	public User getUserById(String userId) throws SQLException
	{
		ResultSet rSet = SQLHelper.getResultSet("select * from TB_User where userId = '"+userId+"'");
		//没找到返回0，找到返回User
		if(rSet!=null) 
		{
			 try 
			 {
				 while(rSet.next()) 
					{
						User user = new User();
						
						user.setIsVip(rSet.getInt("isVip"));
						user.setNickName(rSet.getString("nickName"));
						user.setPayPwd(rSet.getString("payPwd"));
						user.setPhone(rSet.getString("phone"));
						user.setUserAddress(rSet.getString("userAddress"));
						user.setUserId(rSet.getString("userId"));
						user.setUserImage(rSet.getBytes("userImage"));
						user.setUserPwd(rSet.getString("userPwd"));	
						return user;
					}
			 }
			catch (Exception e) 
			{
				e.printStackTrace();
			}//catch
		}//if
		else
		{
			return null;
		}
		return null;
	}
	
	public void Reigster(String userId,String userPwd)
	{
		String sql="insert into TB_User (userId,userPwd) values(?,?)";

		Object[] params=new Object[2];
		params[0]=userId;
		params[1]=userPwd;
		SQLHelper.ExecSql(sql,params);
	}
	
	public int userOpenVip(String userId,int days)
	{
		String sql = "exec userOpenVip ?,?";
		Object[] params=new Object[2];
		params[0]=userId;
		params[1]=days;
		return SQLHelper.ExecSql(sql,params);
	}
	
	public void userPayPwd(String userId,String userPayPwd)
	{
		String sql="update TB_User set payPwd='"+userPayPwd+"' where userId = '"+userId+"'";
		SQLHelper.ExecSql(sql);
	}
}
