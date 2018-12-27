package com.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.pojo.OrderDetails;
import com.shop.tool.SQLHelper;

public class OrderDetailsDao {
	
	//根据订单的id来查询订单详情的数量和goodsID
	public List<OrderDetails> getOrderDetailsById(int orderId) throws SQLException{
		String sql = "select * from TB_OrderDetails where orderId = ?";
		Object[] object = {orderId};
		List<OrderDetails> list = new ArrayList<OrderDetails>();
		
		ResultSet rs  =  SQLHelper.getResultSet(sql, object);
		
		while(rs.next()) {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setGoodsId(rs.getInt("goodsId"));
			orderDetails.setGoodsQty(rs.getInt("goodsQty"));
			list.add(orderDetails);
		}
		
		if(list.size()==0) return null;
		return list;
	}
	
	
	//根据订单的id来删除订单详情
	public int deleteById(int orderId) throws SQLException {
		String sql  = "delete from TB_OrderDetails where orderId =? ";
		Object[] object = {orderId};
		return SQLHelper.ExecSql(sql, object);
	}
	
	

}
