package com.shop.servlet;

import com.shop.tool.BaseServlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shop.tool.*;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	//从客户端1传来的信息
	private String msg ;
	
	//从客户端2传来的信息
	private String info;
       
    /**
     * @see BaseServlet#BaseServlet()
     */
    public ChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /* public void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	String msg = request.getParameter("msg");
    	
    	Socket s = new Socket(ip,port);
		OutputStream out = s.getOutputStream();
		InputStream in = s.getInputStream();
		
		DataOutputStream dout = new DataOutputStream(out);
		DataInputStream din = new DataInputStream(in);
		
		SendThread it = new SendThread(dout,msg);
		PrintThread ot = new PrintThread(din,ip);
		
		new Thread(ot).start();
		new Thread(it).start();
    	
    }*/
    
    
    
    public void getClient1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	//获得从客户端1传来的消息
    	String msg = request.getParameter("msg");
//    	System.out.println(msg);
    	this.msg = msg;
    	/*sendClient1(request,response,msg);*/
    	
    	/*if(msg !=null) {
    		PrintWriter out = response.getWriter();
    		System.out.println(msg);
    		out.println(msg);
    		out.flush();
    		out.close();
    	}*/
    	//b客户端过一段时间就监听，如果有消息的话就发给b
    	
    /*	request.setAttribute("msg", msg);
    	request.getRequestDispatcher("/ServiceServlet?method=getMsg").forward(request,response);*/
    	
    	
    }
    
    public void  sendClient1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	
    	if(msg !=null && msg != "") {
    		PrintWriter out = response.getWriter();
    		System.out.println(msg);
    		out.println(msg);
    		out.flush();
    		out.close();
    		msg =null;
    	}
    	
    }
    
    
    
    
    public void getClient2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//获得从客户端2传来的消息
    	String info = request.getParameter("info");
    	this.info = info;    	
    	//把消息显示到页面上
    	/*request.setAttribute("info",msg);
    	request.getRequestDispatcher("/test.jsp").forward(request,response);*/
    	
    	
    	/*request.getSession().setAttribute("info", msg);*/
    	
    /*	PrintWriter out =  response.getWriter();
    	out.print(msg);*/
    }
    
    
   public void  sendClient2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	
    	if(info !=null && info != "") {
    		PrintWriter out = response.getWriter();
    		System.out.println(info);
    		out.println(info);
    		out.flush();
    		out.close();
    		info =null;
    	}
    	
    }
    
}
