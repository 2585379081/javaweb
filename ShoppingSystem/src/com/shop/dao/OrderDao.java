package com.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.pojo.Order;
import com.shop.pojo.OrderDetails;
import com.shop.pojo.ShopCart;
import com.shop.tool.SQLHelper;

public class OrderDao {
	
	//得到客户所有的订单
	public Order[] getAllOrder(String userId) throws SQLException{
		ArrayList<Order> objects = new ArrayList<>();
		ResultSet rSet = SQLHelper.getResultSet("select * from TB_Order where userId = " + userId);
		if (rSet != null) {
			while (rSet.next()) {
				Order order = initOrder(rSet);
				objects.add(order);
			}
			rSet.close();
		}
		Order[] orders = new Order[objects.size()];
		objects.toArray(orders);
		return orders;
	}
	
	//得到所有订单
	public Order[] getAllOrder() throws SQLException{
		ArrayList<Order> objects = new ArrayList<>();
		ResultSet rSet = SQLHelper.getResultSet("select * from TB_Order");
		if (rSet != null) {
			while (rSet.next()) {
				Order order = initOrder(rSet);
				objects.add(order);
			}
			rSet.close();
		}
		Order[] orders = new Order[objects.size()];
		objects.toArray(orders);
		return orders;
	}

	
	//删除指定订单，删除时先把订单详情删除
	public int deleteOrder(int orderId) {
		String sql = "exec deleteOrder ?";
		Object[] params=new Object[1];
		params[0] = orderId;
		return SQLHelper.ExecSql(sql,params);
	}
	
	//添加订单
	public int addOrder(ArrayList<OrderDetails> orderDetailsList, String userId) throws SQLException{
		String sql = "exec addOrder ?,?";
		Object[] params=new Object[1];
		int orderId = 0;
		int flag = 0;
		params[0] = userId;
		orderId = SQLHelper.execProcInOrder(sql, params);
//		System.out.println(orderId);
		for(OrderDetails e:orderDetailsList) {
			e.setOrderId(orderId);
			String sql1 = "exec addOrderDetails ?,?,?";
			Object[] params1=new Object[3];
			params1[0] = orderId;
			params1[1] = e.getGoodsId();
			params1[2] = e.getGoodsQty();
			SQLHelper.ExecSql(sql1,params1);
		}
		return flag;
	}
	
	//改变支付状态
	public int pay(int orderId) {
		String sql = "update TB_Order set isPay = 1 where orderId = ?";
		Object[] params=new Object[1];
		params[0] = orderId;
		return SQLHelper.ExecSql(sql,params);
	}


	
	//初始化订单
	private Order initOrder(ResultSet rSet) throws SQLException{
		Order order = new Order();
		order.setOrderId(rSet.getInt("orderId"));
		order.setUserId(rSet.getString("userId"));
		order.setPay(rSet.getBoolean("isPay"));
		return order;
	}
}
