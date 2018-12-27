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
import com.libarary.model.Reader;

/**
 * Servlet implementation class ReaderTypeManager
 */
@WebServlet("/ReaderTypeManager")
public class ReaderTypeManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReaderTypeManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String rdID = request.getParameter("rdID");
		String rdName = request.getParameter("rdName");
		String rdSex = request.getParameter("rdSex");
		String rdType = request.getParameter("rdType");
		String rdAdminRoles = request.getParameter("rdAdminRoles");
		
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		ReaderMapper rm = (ReaderMapper) applicationContext.getBean("readerMapper");
		Reader reader = new Reader();
		reader.setRdID(Integer.parseInt(rdID));
		reader.setRdName(rdName);
		reader.setRdSex(rdSex);
		reader.setRdType(Integer.parseInt(rdType));
		reader.setRdAdminRoles(Integer.parseInt(rdAdminRoles));
		
		try {
			rm.changeLevel(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
