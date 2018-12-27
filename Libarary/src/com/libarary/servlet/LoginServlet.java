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
	//���spirng����
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
		
		//��ô������
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
		//����reader��rdType ���rdTypeName
		try {
			 rt = rtm.rdIDofReaderType(Integer.parseInt(rdID));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(rt ==null) {
			//�û�������
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
		
		
		 if(pwd.equals(rdPwd) & rdStatus.equals("��ʧ")) {
			
			//��ʧ�������¼
			response.sendRedirect("/Libarary/login.jsp?error=1");
			
		}else if(pwd.equals(rdPwd) & rdStatus.equals("ע��")) {
			//ע�������¼
			response.sendRedirect("/Libarary/login.jsp?error=2");
			
		}else if(pwd.equals(rdPwd) & rdStatus.equals("��Ч")) {
			//��Ч
			
			if(rdAdminRoles ==0) {
				//��ͨ�û�
				request.getSession().setAttribute("reader",reader);
				response.sendRedirect("/Libarary/CommonReader.jsp");
			}else {
				//����Ա
				request.getSession().setAttribute("reader",reader);
				response.sendRedirect("/Libarary/ReaderManager.jsp");
			}
			
			
		}else {
			//�û������������
			response.sendRedirect("/Libarary/login.jsp?error=3");
			
		}
		
		

		
	}
	

}
