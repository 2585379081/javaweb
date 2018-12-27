package com.libarary.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.libarary.mapper.BookMapper;
import com.libarary.model.Book;
import com.libarary.po.ComQuery;
import com.libarary.po.SimpleQuery;

/**
 * Servlet implementation class QueryBook
 */
@WebServlet("/QueryBook")
public class QueryBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String queryType = request.getParameter("queryType");
		String queryName= request.getParameter("queryName");
		String bkName = request.getParameter("bkName");
		String bkAuthor =request.getParameter("bkAuthor");
		String bkBrief = request.getParameter("bkBrief");
		String bkPress = request.getParameter("bkPress");
		String bkCatalog = request.getParameter("bkCatalog");
		String bkPressYear = request.getParameter("bkPressYear");
		
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		BookMapper bm = (BookMapper) applicationContext.getBean("bookMapper");
		List<Book> list = null;
		if(queryType!=null) {
			//进行简单查询
			SimpleQuery simpleQuery = new SimpleQuery();
			simpleQuery.setQueryType(queryType);
			simpleQuery.setQueryName(queryName);
			try {
				list = bm.simpleQuery(simpleQuery);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			//进行复杂查询
			ComQuery comQuery = new ComQuery();
			comQuery.setBkName(bkName);
			comQuery.setBkAuthor(bkAuthor);
			comQuery.setBkPress(bkPress);
			comQuery.setBkCatalog(bkCatalog);
			comQuery.setBkBrief(bkBrief);
			comQuery.setBkPressYear(bkPressYear);
			
			try {
				list = bm.comQuery(comQuery);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		request.setAttribute("list",list);
		request.getRequestDispatcher("/QueryManager.jsp").forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
