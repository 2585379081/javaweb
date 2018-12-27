package com.libarary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class BookUpdate
 */
@WebServlet("/BookUpdate")
public class BookUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdate() {
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
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		BookMapper bm = (BookMapper) applicationContext.getBean("bookMapper");
		
		String bkID = request.getParameter("bkID");
		String select = request.getParameter("select");
		String update = request.getParameter("update");
		
		if(select !=null) {
			//执行查询书的操作
			//写回书的内容
			
			Book book  = null;
			try {
				 book = bm.selectById(Integer.parseInt(bkID));
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String bkDatePress = book.getBkDatePress();
			String bkDateIn = book.getBkDateIn();
			
			PrintWriter out = response.getWriter();
			String str = "";
			str = str + book.getBkID()+","+book.getBkCode()+","+book.getBkName()+","+book.getBkAuthor()+","+book.getBkPress()+","+bkDatePress+","+book.getBkISBN()+
					","+book.getBkCatalog()+","+book.getBkClassName()+","+book.getBkLanguage()+","+book.getBkPages()+","+book.getBkPrice()+","+bkDateIn+","+book.getBkNum()+
					","+book.getBkBrief()+","+book.getBkCover();
			out.write(str);
			
			
			
			
			
			
			
		}else if(update !=null) {
			//执行update操作
			update(request,response,bkID,bm);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	
	
	public void update(HttpServletRequest request, HttpServletResponse response,String bkID,BookMapper bm) {
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
		
		
		Book b=null;
		try {
			b = bm.selectById(Integer.parseInt(bkID));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(bkCover !=null & bkCover !="") {
			String[] infos = bkCover.split("\\\\");
			bkCover = "image"+"/"+"book"+"/"+infos[2];
		}else {
			bkCover  = b.getBkCover();
		}
		
		Book book = new Book();
		book.setBkID(Integer.parseInt(bkID));
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
			bm.updateBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
