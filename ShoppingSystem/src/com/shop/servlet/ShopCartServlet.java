package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.pojo.Goods;
import com.shop.pojo.ShopCart;
import com.shop.service.GoodsService;
import com.shop.service.ShopCartService;
import com.shop.tool.BaseServlet;
import com.shop.tool.urlTrsBase64;

/**
 * Servlet implementation class ShopCartServlet
 */
@WebServlet("/ShopCartServlet")
public class ShopCartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see BaseServlet#BaseServlet()
	 */
	public ShopCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 获取客户购物车中的所有商品
	public void getAllShopCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = (String) request.getSession().getAttribute("userId");
		ShopCartService service = new ShopCartService();
		ShopCart[] shopCarts = service.getAllShopCart(userId);
		ArrayList<HashMap> list = new ArrayList<>();
		for (int i = 0; i < shopCarts.length; i++) {
			Goods goods = new Goods();
			goods.setGoodsId(shopCarts[i].getGoodsId());
			Goods goodsRet = new GoodsService().queryGoods(goods).get(0);
			HashMap hashMap = new HashMap();
			hashMap.put("goodsId", goodsRet.getGoodsId());
			hashMap.put("goodsName", goodsRet.getGoodsName());
			hashMap.put("goodsPrice", goodsRet.getGoodsPrice());
			hashMap.put("goodsQty", shopCarts[i].getGoodsQty());
			hashMap.put("goodsImage", goodsRet.getGoodsImage());
			list.add(hashMap);
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("shopcart.jsp").forward(request, response);
	}
	
	//测试将图片写入商品
	public void test(HttpServletRequest request, HttpServletResponse response) throws IOException{
		GoodsService service = new GoodsService();
		Goods goods = new Goods();
		goods.setGoodsId(4);
		goods.setGoodsName("商品4");
		goods.setGoodsNum(10);
		String url = "E:\\web商品图片\\c语言程序设计.jpg";
		byte[] goodsImage = urlTrsBase64.urlToByte(url);
		goods.setGoodsImage(goodsImage);
		service.updateGoods(goods, "add");
	}

	// 修改商品的数量
	public void alterGoodsNumber(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = (String) request.getSession().getAttribute("userId");
		int goodsId = Integer.valueOf(request.getParameter("goodsId").toString());
		int goodsQty = Integer.valueOf(request.getParameter("goodsQty").toString());
		//int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		//int goodsQty = Integer.parseInt(request.getParameter("goodsQty"));
		System.out.println("ShopCartServlet:alterGoodsNumber:商品id:"+goodsId);
		ShopCartService service = new ShopCartService();
		int flag = service.alterGoodsNumber(userId, goodsId, goodsQty);
		PrintWriter out = response.getWriter();
		out.println(flag);
		out.flush();
		out.close();
	}
	
	//删除购物车中的指定商品
	public void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userId = (String) request.getSession().getAttribute("userId");
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		ShopCartService service = new ShopCartService();
		int flag = service.deleteGoods(userId, goodsId);
		PrintWriter out = response.getWriter();
		out.println(flag);
		out.flush();
		out.close();
		//response.sendRedirect("shopcart.jsp");
	}
	
	//加商品到购物车
	public void addGoods(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userId = (String) request.getSession().getAttribute("userId");
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int goodsQty = Integer.parseInt(request.getParameter("goodsQty"));
		ShopCartService service = new ShopCartService();
		int flag = service.addGoods(userId, goodsId, goodsQty);
		PrintWriter out = response.getWriter();
		out.println(flag);
		out.flush();
		out.close();
	}

}
