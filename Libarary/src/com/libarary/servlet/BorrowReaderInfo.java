/**
 * 借阅页面的查询用户信息
 */
package com.libarary.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.libarary.mapper.BookMapper;
import com.libarary.mapper.BorrowMapper;
import com.libarary.mapper.ReaderTypeMapper;
import com.libarary.model.Book;
import com.libarary.po.BookInfo;
import com.libarary.po.BookVo;
import com.libarary.po.ReaderInfo;

/**
 * Servlet implementation class BorrowReaderInfo
 */
@WebServlet("/BorrowReaderInfo")
public class BorrowReaderInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowReaderInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		BorrowMapper bm = (BorrowMapper) applicationContext.getBean("borrowMapper");
		ReaderTypeMapper rtm = (ReaderTypeMapper) applicationContext.getBean("readerTypeMapper");
		//获得用户的rdid
		String rdID= request.getParameter("rdID");
		String bkID = request.getParameter("bkID");
		String bkName = request.getParameter("bkName");
		String level = request.getParameter("level");
		
	
		//根据id查询借书的信息和用户的信息 reader表    readerType表中的可借天数和数量      boroow表中借书的总
			if(rdID !=null) {
				ReaderInfo readerInfo = null;
				int lendedNum=0;
				//查询其他的读者信息
				try {
					 readerInfo = bm.queryReaderVo(Integer.parseInt(rdID));
					 lendedNum = bm.queryLendedNum(Integer.parseInt(rdID));
					 readerInfo.setLendedNum(lendedNum);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"没有该用户");
					request.getRequestDispatcher("/Borrow.jsp").forward(request,response);
					
				}
					
				
					readerInfo.setLendedNum(lendedNum);
				
				
				//查询书的信息
				List<BookInfo> bookInfoList = null;
				
				try {
					bookInfoList = (List) bm.queryBookVo(Integer.parseInt(rdID));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				request.getSession().setAttribute("readerInfo",readerInfo);
				request.getSession().setAttribute("bookInfoList",bookInfoList);
				if(level!=null) {
					request.getRequestDispatcher("/CommonQuery.jsp").forward(request,response);
				}else {
					request.getRequestDispatcher("/Borrow.jsp").forward(request,response);
				
				}
			}
			
			
			List<Book> bookList = null;
			if(bkID!=null) {
				
				bookList = this.bookQuery(bkID, bkName,applicationContext);
				request.setAttribute("bookList",bookList);
				if(level!=null) {
					request.getRequestDispatcher("/CommonQuery.jsp?info=1").forward(request,response);
				}else {
					request.getRequestDispatcher("/Borrow.jsp?info=1").forward(request,response);
				
				}
				
			}
	
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	public List<Book> bookQuery(String bkID, String bkName,ApplicationContext applicationContext) {
		List<Book> bl = null;
		BookMapper bm = (BookMapper) applicationContext.getBean("bookMapper");
		BookVo bookVo = new BookVo();
		bookVo.setBkID(bkID);
		bookVo.setBkName(bkName);
		
		
		try {
			bl = bm.bookQuery(bookVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bl;
	}

}
