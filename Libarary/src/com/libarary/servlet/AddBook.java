package com.libarary.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.libarary.mapper.BookMapper;
import com.libarary.model.Book;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//接受从js传来的数据
		
		response.setContentType("text;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		BookMapper bm = (BookMapper) applicationContext.getBean("bookMapper");
		
		
		String bkCode = request.getParameter("bkCode");
		String bkName = request.getParameter("bkName");
		String bkAuthor = request.getParameter("bkAuthor");
		String bkPress = request.getParameter("bkPress");
		String bkDatePress = request.getParameter("bkDatePress");
		String bkISBN =request.getParameter("bkISBN");
		String bkCatalog = request.getParameter("bkCatalog");
		String bkLanguage= request.getParameter("bkLanguage");
		String[] languages = bkLanguage.split("-");
		int bkLanguageNo = Integer.parseInt(languages[0]);
		int bkPages = Integer.parseInt(request.getParameter("bkPages"));
		Float bkPrice = Float.parseFloat(request.getParameter("bkPrice"));
		String bkBrief = request.getParameter("bkBrief");
		String bkDateIn = request.getParameter("bkDateIn");
		int bkNum =Integer.parseInt(request.getParameter("bkNum"));
		String bkClassName= request.getParameter("bkClassName");
		String bkCover = request.getParameter("bkCover");
		
		
		
		if(bkCover !=null & bkCover !="") {
			String[] infos = bkCover.split("\\\\");
			bkCover = "image"+"/"+"book"+"/"+infos[2];
		}
		//写进数据库中
		Book book = new Book();
		book.setBkCode(bkCode);
		book.setBkName(bkName);
		book.setBkAuthor(bkAuthor);
		book.setBkPress(bkPress);
		book.setBkDatePress(bkDatePress);
		book.setBkISBN(bkISBN);
		book.setBkCatalog(bkCatalog);
		book.setBkLanguage(bkLanguageNo);
		book.setBkPages(bkPages);
		book.setBkPrice(bkPrice);
		book.setBkDateIn(bkDateIn);
		book.setBkBrief(bkBrief);
		book.setBkNum(bkNum);
		book.setBkClassName(bkClassName);
		book.setBkCover(bkCover);
		
		try {
			bm.addBook(book);
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
