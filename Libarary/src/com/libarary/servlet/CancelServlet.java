package com.libarary.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class CancelServlet
 */
@WebServlet("/CancelServlet")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelServlet() {
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
		String id = request.getParameter("id");
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		ReaderMapper rm = (ReaderMapper) applicationContext.getBean("readerMapper");
		Reader reader = null;
			
		
		if(id.equals("2")) {
			lost(rdID,rm);
			
		}else if(id.equals("3")) {
			removeLost(rdID,rm);
			
		}else if(id.equals("4")) {
			cancel(rdID,rm);
			
		}else if(id.equals("5")) {
			delete(rdID,rm);
		}
		
		 try {
			reader = rm.noOfReader(rdID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 if(!id.equals("5")) {
			PrintWriter out = response.getWriter();
			String str ="";
			str = str + reader.getRdID()+","+reader.getRdName()+","+reader.getRdSex()+","+reader.getRdType()+","+reader.getRdStatus()+","+reader.getRdAdminRoles();
			out.write(str);
		 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void delete(String rdID,ReaderMapper rm) {
		try {
			rm.deleteById(Integer.parseInt(rdID));
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void cancel(String rdID,ReaderMapper rm) {
		//把数据库中的rdID的状态改为注销
		Reader reader = new Reader();
		reader.setRdID(Integer.parseInt(rdID));
		reader.setRdStatus("注销");
		try {
			rm.updateByID(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void removeLost(String rdID,ReaderMapper rm) {
		//把数据库中的rdID的状态改为有效。如果是注销就不能改
		Reader reader = new Reader();
		reader.setRdID(Integer.parseInt(rdID));
		reader.setRdStatus("有效");
		try {
			rm.updateByID(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void lost(String rdID,ReaderMapper rm) {
		//把数据库中的rdId 的状态给为挂失，如果是注销就不能改
		Reader reader = new Reader();
		reader.setRdID(Integer.parseInt(rdID));
		reader.setRdStatus("挂失");
		try {
			rm.updateByID(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
