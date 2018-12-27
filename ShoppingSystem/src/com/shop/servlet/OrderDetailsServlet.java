package com.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.pojo.Goods;
import com.shop.pojo.OrderDetails;
import com.shop.service.GoodsService;
import com.shop.service.OrderDetailsService;
import com.shop.tool.BaseServlet;

/**
 * Servlet implementation class OrderDetailsServlet
 */
@WebServlet("/OrderDetailsServlet")
public class OrderDetailsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderDetailsService orderDetailsService = new OrderDetailsService();
       
    /**
     * @see BaseServlet#BaseServlet()
     */
    public OrderDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public void getOrderDetailsById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String orderId = request.getParameter("orderId");
    	
    	List<OrderDetails> list  = null;
    	List<HashMap<String,Object>> allList= new ArrayList<HashMap<String,Object>>(); 
    	//调用service的方法
    	if(orderId!=null) {
    		list = orderDetailsService.getOrderDetailsById(Integer.parseInt(orderId));
    		
    		for(OrderDetails orderDetails :list) {
    			HashMap<String,Object> map = new HashMap<String,Object>();
    			Goods goods = new Goods();
    			goods.setGoodsId(orderDetails.getGoodsId());
    			GoodsService goodsService = new GoodsService();
    			goods = goodsService.queryGoods(goods).get(0);
    			map.put("goodsPrice",goods.getGoodsPrice()+"");
    			map.put("goodsQty", orderDetails.getGoodsQty()+"");
    			map.put("goodsName",goods.getGoodsName());
    			map.put("goodsImage",goods.getGoodsImage());
    			allList.add(map);
    			
    			
    		}
    	}
    	
    	//要根据每个商品的id查询出他们的单价和名称
    	request.setAttribute("allList", allList);
    	request.setAttribute("orderId", orderId);
    	request.getRequestDispatcher("/orderdetail.jsp").forward(request,response);
    	
    }
    
    
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String orderId = request.getParameter("orderId");
    	
    	//调用service的方法
    	if(orderId!=null)
    	orderDetailsService.deleteById(Integer.parseInt(orderId));
    }


}
