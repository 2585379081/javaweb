package com.shop.service;
import com.shop.pojo.*;

import java.sql.SQLException;

import com.shop.dao.*;

public class UserService {
	
	public int login(String userId,String userPwd) throws SQLException//用户登录函数，登陆成功返回1，失败返回0
	{
		//获取数据库中已保存的用户数据
		UserDao dao = new UserDao();
		//根据用户id得到信息
		User user = dao.getUserById(userId);
		if (user == null)
		{
			//为空,不存在该用户，直接返回0
			return 0;
		}
		else
		{
			//不为空，判断密码是否不正确
			if (!userPwd.equals(user.getUserPwd()))
			{
				//密码错误，返回0
				
				return 0;
			}
			else
			{
				//登陆成功
				return 1;
			}
		}
	}
	
	public int reigster(String userId,String UserPwd) throws SQLException
	{
		//先判断数据库中是否有该用户名
		//根据用户名获取用户信息
		UserDao dao = new UserDao();
		//根据用户id得到信息
		User user = dao.getUserById(userId);
		if (user != null)
		{
			//不为空,存在该用户，直接返回0
			return 0;
		}
		
		//调用dao层操作数据库
		try
		{
			dao.Reigster(userId, UserPwd);
			//操作成功返回1
			return 1;
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
		//直接返回0
		return 0;
	}
	
//	public static String showImage() throws SQLException
//	{
//		String userId = "1002";
//		UserDao dao = new UserDao();
//		//根据用户id得到信息
//		User user = dao.getUserById(userId);
//		return urlTrsBase64.byteToBase64(user.getUserImage());
//	}
	
	//调用Dao层完成开通vip
	public int userOpenVip(String userId,int days)
	{
		UserDao dao = new UserDao();
		return dao.userOpenVip(userId, days);
	}
	
	public void userPayPwd(String userId,String userPayPwd)
	{
		UserDao dao = new UserDao();
		dao.userPayPwd(userId, userPayPwd);
		
	}
}
