package com.shop.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.OrderDao;
import com.shop.pojo.Goods;
import com.shop.pojo.Order;
import com.shop.pojo.OrderDetails;

public class OrderService {

	//得到客户所有订单
	public Order[] getAllOrder(String userId) throws SQLException{
		OrderDao dao = new OrderDao();
		Order[] orders = null;
		orders = dao.getAllOrder(userId);
		return orders;
	}
	
	//得到所有订单
	public Order[] getAllOrder() throws SQLException{
		OrderDao dao = new OrderDao();
		Order[] orders = null;
		orders = dao.getAllOrder();
		return orders;
	}

	
	//删除指定订单，删除时先把订单详情删除
	public int deleteOrder(int orderId) {
		OrderDao dao = new OrderDao();
		int flag = dao.deleteOrder(orderId);
		return flag;
	}
	
	//加入订单
	public int addOrder(ArrayList<OrderDetails> orderDetailsList, String userId) throws SQLException{
		OrderDao dao = new OrderDao();
		int flag = dao.addOrder(orderDetailsList, userId);
		return flag;
	}
	
	//支付订单
	public int pay(int orderId) {
		OrderDao dao = new OrderDao();
		int flag = dao.pay(orderId);
		return flag;
	}

	
	//计算每个订单的总价
	public float getSumPrice(int orderId) {
		OrderDetailsService orderDetailsService = new OrderDetailsService();
		ArrayList<OrderDetails> list = (ArrayList<OrderDetails>)orderDetailsService.getOrderDetailsById(orderId);
		float sum = 0;
		for(OrderDetails e: list) {
			int goodsId = e.getGoodsId();
			int goodsQty = e.getGoodsQty();
			Goods goods = new Goods();
			goods.setGoodsId(goodsId);
			ArrayList<Goods> goodsList = (ArrayList<Goods>)new GoodsService().queryGoods(goods);
			float price = goodsList.get(0).getGoodsPrice();
			sum += price*goodsQty;
		}
		return sum;
	}
}
