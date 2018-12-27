package com.shop.servlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.pojo.Goods;
import com.shop.pojo.Order;
import com.shop.pojo.OrderDetails;
import com.shop.service.GoodsService;
import com.shop.service.OrderDetailsService;
import com.shop.service.OrderService;
import com.shop.tool.BaseServlet;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see BaseServlet#BaseServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //得到客户所有的订单
	public void getAllOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderService orderService = new OrderService();
		Order[] orders = null;
		String userId = (String) request.getSession().getAttribute("userId");
		orders = orderService.getAllOrder(userId);
		ArrayList<HashMap> orderList = new ArrayList<>();
		OrderDetailsService orderDetailsService = new OrderDetailsService();
		GoodsService goodsService = new GoodsService();
		for (int i = 0; i < orders.length; i++) {
			ArrayList<OrderDetails> orderDetailsList = (ArrayList<OrderDetails>) orderDetailsService
					.getOrderDetailsById(orders[i].getOrderId());
			ArrayList<byte[]> goodsImageList = new ArrayList<>();
			for (int j = 0; j < orderDetailsList.size(); j++) {
				Goods goods = new Goods();
				goods.setGoodsId(orderDetailsList.get(j).getGoodsId());
				Goods goodsRet = (Goods)goodsService.queryGoods(goods).get(0);
				goodsImageList.add(goodsRet.getGoodsImage());
				
			}
			HashMap hashMap = new HashMap();
			float sumPrice = orderService.getSumPrice(orders[i].getOrderId());
			hashMap.put("orderId", orders[i].getOrderId());
			hashMap.put("isPay", orders[i].isPay());
			hashMap.put("goodsNumber", orderDetailsList.size());
			hashMap.put("sumPrice", sumPrice);
			hashMap.put("goodsImageList", goodsImageList);
			orderList.add(hashMap);
		}

		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

	//通过用户名查找订单
	public void searchOrderById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderService orderService = new OrderService();
		Order[] orders = null;
		String userId = (String) request.getParameter("userId");
		orders = orderService.getAllOrder(userId);
		ArrayList<HashMap> orderList = new ArrayList<>();
		OrderDetailsService orderDetailsService = new OrderDetailsService();
		GoodsService goodsService = new GoodsService();
		for (int i = 0; i < orders.length; i++) {
			ArrayList<OrderDetails> orderDetailsList = (ArrayList<OrderDetails>) orderDetailsService
					.getOrderDetailsById(orders[i].getOrderId());
			for (int j = 0; j < orderDetailsList.size(); j++) {
				Goods goods = new Goods();
				goods.setGoodsId(orderDetailsList.get(j).getGoodsId());
				Goods goodsRet = (Goods)goodsService.queryGoods(goods).get(0);
				
			}
			HashMap hashMap = new HashMap();
			float sumPrice = orderService.getSumPrice(orders[i].getOrderId());
			hashMap.put("orderId", orders[i].getOrderId());
			hashMap.put("isPay", orders[i].isPay());
			hashMap.put("goodsNumber", orderDetailsList.size());
			hashMap.put("sumPrice", sumPrice);
			hashMap.put("userId", orders[i].getUserId());
			orderList.add(hashMap);
		}

		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("serverorder.jsp").forward(request, response);
	}

	//得到所有订单
	public void getAllOrders(HttpServletRequest request, HttpServletResponse response) throws Exception{
		OrderService orderService = new OrderService();
		Order[] orders = null;
		orders = orderService.getAllOrder();
		ArrayList<HashMap> orderList = new ArrayList<>();
		OrderDetailsService orderDetailsService = new OrderDetailsService();
		GoodsService goodsService = new GoodsService();
		for (int i = 0; i < orders.length; i++) {
			ArrayList<OrderDetails> orderDetailsList = (ArrayList<OrderDetails>) orderDetailsService
					.getOrderDetailsById(orders[i].getOrderId());
			for (int j = 0; j < orderDetailsList.size(); j++) {
				Goods goods = new Goods();
				goods.setGoodsId(orderDetailsList.get(j).getGoodsId());
				Goods goodsRet = (Goods)goodsService.queryGoods(goods).get(0);
			}
			HashMap hashMap = new HashMap();
			float sumPrice = orderService.getSumPrice(orders[i].getOrderId());
			hashMap.put("orderId", orders[i].getOrderId());
			hashMap.put("isPay", orders[i].isPay());
			hashMap.put("goodsNumber", orderDetailsList.size());
			hashMap.put("sumPrice", sumPrice);
			hashMap.put("userId", orders[i].getUserId());
			orderList.add(hashMap);
		}
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("serverorder.jsp").forward(request, response);

	}

    
    //删除指定订单
    public void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	OrderService orderService = new OrderService();
    	int orderId = Integer.valueOf(request.getParameter("orderId"));
    	int flag = orderService.deleteOrder(orderId);
    }
    
    //添加订单
    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	OrderService orderService = new OrderService();
    	String userId = (String)request.getSession().getAttribute("userId");
    	String[] goodsId = request.getParameterValues("goodsIdList");
    	String[] goodsQty = request.getParameterValues("goodsQtyList");
    	ArrayList<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
    	for(int i=0; i<goodsId.length; i++) {
    		OrderDetails orderDetails = new OrderDetails();
    		orderDetails.setGoodsId(Integer.valueOf(goodsId[i]));
    		orderDetails.setGoodsQty(Integer.valueOf(goodsQty[i]));
    		orderDetailsList.add(orderDetails);
    	}
    	int flag = orderService.addOrder(orderDetailsList, userId);
    }
    
    public void payOrder(HttpServletRequest request, HttpServletResponse response) {
    	OrderService orderService = new OrderService();
    	int orderId = Integer.valueOf(request.getParameter("orderId"));
    	int flag = orderService.pay(orderId);
    	
    }

    
    //测试
    public void test(HttpServletRequest request, HttpServletResponse response) throws SQLException{
//    	OrderService orderService = new OrderService();
//    	Order[] orders = null;
//    	orders = orderService.getAllOrder("1001");
//		for (int i = 0; i < orders.length; i++) {
//			System.out.println("OrderService:orderId:" + orders[i].getOrderId() + "userId:" 
//					+ orders[i].getUserId() + "isPay" + orders[i].isPay());
//    	OrderService orderService = new OrderService();
//    	orderService.deleteOrder(1);
//    	Order[] orders = null;
//    	orders = orderService.getAllOrder("1001");
//		for (int i = 0; i < orders.length; i++) {
//			System.out.println("OrderService:orderId:" + orders[i].getOrderId() + "userId:" 
//					+ orders[i].getUserId() + "isPay" + orders[i].isPay());
//		}
    	OrderService orderService = new OrderService();
    	String userId = (String)request.getSession().getAttribute("userId");
    	ArrayList<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
    	OrderDetails orderDetails = new OrderDetails();
    	orderDetails.setGoodsId(3);
    	orderDetails.setGoodsQty(4);
    	orderDetailsList.add(orderDetails);
    	int flag = orderService.addOrder(orderDetailsList, userId);
    }

}
