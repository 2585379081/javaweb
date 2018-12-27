package com.shop.service;

import java.sql.SQLException;
import java.util.List;

import com.shop.dao.OrderDetailsDao;
import com.shop.pojo.OrderDetails;

public class OrderDetailsService {
	private OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
	
	public List<OrderDetails> getOrderDetailsById(int orderId){
		try {
			return orderDetailsDao.getOrderDetailsById(orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int deleteById(int orderId) {
		try {
			return orderDetailsDao.deleteById(orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

}
