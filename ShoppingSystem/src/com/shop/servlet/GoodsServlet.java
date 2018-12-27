package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http11.filters.VoidInputFilter;

import com.shop.pojo.Goods;
import com.shop.service.GoodsService;
import com.shop.tool.BaseServlet;
import com.shop.tool.urlTrsBase64;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private GoodsService goodsService = new GoodsService();
       
    /**
     * @see BaseServlet#BaseServlet()
     */
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    //通锟斤拷锟斤拷锟斤拷模锟斤拷锟斤拷询锟斤拷品
    public void queryByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String goodsName = request.getParameter("goodsName");
    	//锟斤拷锟斤拷goods Service锟叫碉拷通锟斤拷锟斤拷品锟斤拷锟狡诧拷询锟斤拷品
    	Goods goods = new Goods();
    	goods.setGoodsName(goodsName);
    	List<Goods> goodsList = goodsService.queryGoods(goods);
    	
    	request.setAttribute("goodsList",goodsList);
    	
    	/*return "f:/main.jsp";*/
    	request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
    
    
    //通锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟絠d锟斤拷锟斤拷询锟斤拷品锟斤拷锟斤拷细锟斤拷息
    public void queryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String goodsId = request.getParameter("goodsId");
    	int gi = 0;
    	if(goodsId!=null) {
    		 gi = Integer.parseInt(goodsId);
    	}
    	
    	//锟斤拷锟斤拷goods Service锟叫碉拷通锟斤拷锟斤拷品id锟斤拷询锟斤拷品
    	Goods goods = new Goods();
    	goods.setGoodsId(gi);
    	List<Goods> goodsList = goodsService.queryGoods(goods);
    	
    	//锟斤拷锟斤拷只锟斤拷一锟斤拷goods
    	if(goodsList!=null)
    	goods = goodsList.get(0);
    	
    	request.setAttribute("goods",goods);
    	
    	//return "f:/goodsdetail.jsp";
    	request.getRequestDispatcher("/goodsdetail.jsp").forward(request, response);
    }
    
    //跳转至修改页面
    public void alterGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String goodsId = request.getParameter("goodsId");
    	int gi = 0;
    	if(goodsId!=null) {
    		 gi = Integer.parseInt(goodsId);
    	}
    	
    	//锟斤拷锟斤拷goods Service锟叫碉拷通锟斤拷锟斤拷品id锟斤拷询锟斤拷品
    	Goods goods = new Goods();
    	goods.setGoodsId(gi);
    	List<Goods> goodsList = goodsService.queryGoods(goods);
    	
    	//锟斤拷锟斤拷只锟斤拷一锟斤拷goods
    	if(goodsList!=null)
    	goods = goodsList.get(0);
    	
    	request.setAttribute("goods",goods);
    	
    	//return "f:/goodsdetail.jsp";
    	request.getRequestDispatcher("/goodsmeneger.jsp").forward(request, response);
    }
    
    
    
    public String addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	String goodsId = request.getParameter("goodsId");
    	String goodsName = request.getParameter("goodsName");
    	String goodsPrice = request.getParameter("goodsPrice");
    	String goodsNum = request.getParameter("goodsNum");
    	String goodsBrief = request.getParameter("goodsBrief");
    	String goodsCat = request.getParameter("goodsCat");
    	String path = request.getParameter("src");
    	int index = path.indexOf(",");
    	String base64 = path.substring(index+1);
    	
    	System.out.println(goodsId+","+goodsName+","+goodsPrice+","+goodsNum+","+goodsBrief+","+goodsCat);
    	byte[] bytes =urlTrsBase64.base64ToByte(base64);
    	Goods goods = new Goods();
    	goods.setGoodsId(Integer.parseInt(goodsId));
    	goods.setGoodsName(goodsName);
    	goods.setGoodsCat(goodsCat);
    	goods.setGoodsBrief(goodsBrief);
    	goods.setGoodsNum(Integer.parseInt(goodsNum));
    	goods.setGoodsPrice(Integer.parseInt(goodsPrice));
    	goods.setGoodsImage(bytes);
    	
    	int result = goodsService.updateGoods(goods,"add");
    	PrintWriter out = response.getWriter();
    	if(result ==1) {
    		//表明成功
    		out.print(1);
    	}else {
    		out.print(-1);
    	}
    	
    	
    	return null;
    }
    
    
    public String updateGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	String goodsId = request.getParameter("goodsId");
    	String goodsName = request.getParameter("goodsName");
    	String goodsPrice = request.getParameter("goodsPrice");
    	String goodsNum = request.getParameter("goodsNum");
    	String goodsBrief = request.getParameter("goodsBrief");
    	String goodsCat = request.getParameter("goodsCat");
    	String path = request.getParameter("src");
    	Goods goods = new Goods();
    	String base64 ;
    	if(path!=null) {
    		int index = path.indexOf(",");
    		base64 = path.substring(index+1);
    		byte[] bytes =urlTrsBase64.base64ToByte(base64);
    		goods.setGoodsImage(bytes);
    		
    	}else {
    		Goods g = new Goods();
    		g.setGoodsId(Integer.parseInt(goodsId));
    		g = goodsService.queryGoods(g).get(0);
    		goods.setGoodsImage(g.getGoodsImage());
    		
    	}
    	
    	System.out.println(goodsId+","+goodsName+","+goodsPrice+","+goodsNum+","+goodsBrief+","+goodsCat);
//    	byte[] bytes =urlTrsBase64.base64ToByte(base64);
    	goods.setGoodsId(Integer.parseInt(goodsId));
    	goods.setGoodsName(goodsName);
    	goods.setGoodsCat(goodsCat);
    	goods.setGoodsBrief(goodsBrief);
    	goods.setGoodsNum(Integer.parseInt(goodsNum));
    	goods.setGoodsPrice(Float.parseFloat(goodsPrice));
//    	goods.setGoodsImage(bytes);
    	
    	 int result = goodsService.updateGoods(goods,"update");
    	
    	PrintWriter out = response.getWriter();
    	
    	out.print(result);
    	out.flush();
    	out.close();
    	return null;
    }
    
    public void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	String goodsId = request.getParameter("goodsId");
    	Goods goods = new Goods();
    	goods.setGoodsId(Integer.parseInt(goodsId));
    	goodsService.updateGoods(goods,"delete");
    	List<Goods> goodsList = goodsService.showAllGoods();
		
		request.setAttribute("goodsList", goodsList);
		request.getRequestDispatcher("servermain.jsp").forward(request,response);
    	
    }
    
    
    public void getAllGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	List<Goods> goodsList = goodsService.showAllGoods();
		
		request.setAttribute("goodsList", goodsList);
		request.getRequestDispatcher("servermain.jsp").forward(request,response);
    	
    	
    }
    
   /* public String test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String path = request.getParameter("src");
    	int index = path.indexOf(",");
    	String base64 = path.substring(index+1);
    	
    	
    	byte[] bytes =urlTrsBase64.base64ToByte(base64);
    	Goods goods = new Goods();
    	goods.setGoodsId(2);
    	goods.setGoodsName("yifu");
    	goods.setGoodsCat("锟铰凤拷");
    	goods.setGoodsBrief("123");
    	goods.setGoodsNum(1);
    	goods.setGoodsPrice(12);
    	goods.setGoodsImage(bytes);

    	goodsService.updateGoods(goods, "update");
    	
    	urlTrsBase64 utb = new urlTrsBase64();
    	byte[] bytes = urlTrsBase64.urlToByte(path);
    	Goods goods = new Goods();
    	goods.setGoodsId(1);
    	goods.setGoodsImage(bytes);
    	
    	
    	goodsService.updateGoods(goods, "update");
    	
    	return null;
    }*/
    
    
    /*public String showImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	Goods g= new Goods();
    	g.setGoodsId(1);
    	List<Goods> list =  goodsService.queryGoods(g);
    	byte[] bytes =list.get(0).getGoodsImage();
    	String base64=urlTrsBase64.byteToBase64(bytes);
    	
    	request.setAttribute("base64" ,base64);
    	request.getRequestDispatcher("/test.jsp?base="+base64).forward(request,response);
    	return "f:/test.jsp";
    }
    */
 
}
