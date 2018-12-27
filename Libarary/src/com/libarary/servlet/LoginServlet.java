package com.libarary.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.libarary.mapper.ReaderMapper;
import com.libarary.mapper.ReaderTypeMapper;
import com.libarary.model.ReaderType;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//获得spirng容器
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	

		String rdID = request.getParameter("rdID");
		String rdPwd = request.getParameter("rdPwd");
		
		//获得代理对象
		ReaderMapper rm = (ReaderMapper) applicationContext.getBean("readerMapper");
		ReaderTypeMapper rtm = (ReaderTypeMapper) applicationContext.getBean("readerTypeMapper");
		
		
		String pwd =null;
		com.libarary.model.Reader reader=null;
		
		try {
			reader = rm.noOfReader(rdID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ReaderType rt =null;
		//根据reader的rdType 查出rdTypeName
		try {
			 rt = rtm.rdIDofReaderType(Integer.parseInt(rdID));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(rt ==null) {
			//用户不存在
			response.sendRedirect("/Libarary/login.jsp?error=4");
			return;
		}
		
		reader.setRdTypeName(rt.getRdTypeName());
		
		int rdAdminRoles = reader.getRdAdminRoles();
		String rdStatus = reader.getRdStatus();
		
		try {
			pwd = rm.loginCheck(rdID);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 if(pwd.equals(rdPwd) & rdStatus.equals("挂失")) {
			
			//挂失，不许登录
			response.sendRedirect("/Libarary/login.jsp?error=1");
			
		}else if(pwd.equals(rdPwd) & rdStatus.equals("注销")) {
			//注销不许登录
			response.sendRedirect("/Libarary/login.jsp?error=2");
			
		}else if(pwd.equals(rdPwd) & rdStatus.equals("有效")) {
			//有效
			
			if(rdAdminRoles ==0) {
				//普通用户
				request.getSession().setAttribute("reader",reader);
				response.sendRedirect("/Libarary/CommonReader.jsp");
			}else {
				//管理员
				request.getSession().setAttribute("reader",reader);
				response.sendRedirect("/Libarary/ReaderManager.jsp");
			}
			
			
		}else {
			//用户名或密码错误
			response.sendRedirect("/Libarary/login.jsp?error=3");
			
		}
		
		

		
	}
	

}
