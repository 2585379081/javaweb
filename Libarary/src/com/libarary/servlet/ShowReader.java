package com.libarary.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.libarary.mapper.ReaderMapper;
import com.libarary.mapper.ReaderTypeMapper;
import com.libarary.model.Reader;
import com.libarary.model.ReaderType;
import com.libarary.po.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class ShowReader
 */
@WebServlet("/ShowReader")
public class ShowReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowReader() {
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
		response.setContentType("text;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String readerType = request.getParameter("readerType");
		String dept = request.getParameter("dept");
		String name = request.getParameter("name");
		
		
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		
		//先根据系的名称找到系的编号
		ReaderTypeMapper rtm = (ReaderTypeMapper) applicationContext.getBean("readerTypeMapper");
		int rdTypeNo=0;
		try {
			rdTypeNo = rtm.noOfName(readerType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ReaderMapper rm = (ReaderMapper) applicationContext.getBean("readerMapper");
		QueryCondition qc = new QueryCondition();
		qc.setDept(dept);
		qc.setName(name);
		qc.setReaderType(rdTypeNo);
		List<Reader> list =null;
		try {
			 list = rm.queryReader(qc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*request.setAttribute("list", list);
		request.getRequestDispatcher("/ReaderManager.jsp").forward(request,response);*/
		request.getSession().setAttribute("list",list);
		response.sendRedirect("/Libarary/ReaderManager.jsp");
		
	
		
		
		
		
		
		

		
	}

}
