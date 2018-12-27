package com.shop.tool;


import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Method method = null;
		String methodname = request.getParameter("method");
		
		try {
			method = this.getClass().getDeclaredMethod(methodname, HttpServletRequest.class,HttpServletResponse.class);
			
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("您调用的方法"+methodname+"不存在!");
			e.printStackTrace();
		}
		
		
		try {
			method.setAccessible(true);
			method.invoke(this,request,response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


    

}
