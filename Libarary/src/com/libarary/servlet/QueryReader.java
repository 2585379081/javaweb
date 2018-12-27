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

import com.libarary.mapper.ReaderMapper;
import com.libarary.mapper.ReaderTypeMapper;
import com.libarary.model.Reader;
import com.libarary.model.ReaderType;

/**
 * Servlet implementation class QueryReader
 */
@WebServlet("/QueryReader")
public class QueryReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryReader() {
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
		String rdID = request.getParameter("rdID");
		
		ReaderMapper rm = (ReaderMapper) applicationContext.getBean("readerMapper");
		ReaderTypeMapper rtm = (ReaderTypeMapper) applicationContext.getBean("readerTypeMapper");
		
		Reader reader =null;
		try {
			 reader = rm.noOfReader(rdID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ReaderType readerType=null;
		try {
			readerType = rtm.rdIDofReaderType(Integer.parseInt(rdID));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reader.setRdTypeName(readerType.getRdTypeName());
		
		DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String rdDateReg = format.format(reader.getRdDateReg());
		
		PrintWriter out = response.getWriter();
		String str = "";
		str = str + reader.getRdID()+","+reader.getRdName()+","+reader.getRdPwd()+","+reader.getRdSex()+","+reader.getRdBorrowNum()+","+reader.getRdStatus()+","+reader.getRdAdminRoles()+
				","+reader.getRdTypeName()+","+reader.getRdDept()+","+reader.getRdPhone()+","+reader.getRdEmail()+","+rdDateReg+","+reader.getRdPhoto();
		out.write(str);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
