/**
 * 读者注册的页面
 */
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
import com.libarary.mapper.ReaderTypeMapper;
import com.libarary.model.Reader;

/**
 * Servlet implementation class RegisterReader
 */
@WebServlet("/RegisterReader")
public class RegisterReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterReader() {
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
		ReaderTypeMapper rtm = (ReaderTypeMapper) applicationContext.getBean("readerTypeMapper");
		
		
		int rdID = Integer.parseInt(request.getParameter("rdID"));
		String rdName = request.getParameter("rdName");
		String rdPwd = request.getParameter("rdPwd");
		String rdSex = request.getParameter("rdSex");
		String rdType = request.getParameter("rdType");
		String rdDept = request.getParameter("rdDept");
		String rdPhone =request.getParameter("rdPhone");
		String rdEmail= request.getParameter("rdEmail");
		String rdPhoto = request.getParameter("rdPhoto");
		
		//得到的是C:\fakepath\2.png
		if(rdPhoto!=null & rdPhoto !="") {
			String[] infos = rdPhoto.split("\\\\");
			rdPhoto = "image"+"/"+"reader"+"/"+infos[2];
			
		}
		//根据rdTypede的名称查询编号
		
		int rdTypeNo=0;
		try {
			rdTypeNo = rtm.noOfName(rdType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//把信息插入到数据库中
		Reader reader =new Reader();
		reader.setRdID(rdID);
		reader.setRdName(rdName);
		reader.setRdPwd(rdPwd);
		reader.setRdSex(rdSex);
		reader.setRdType(rdTypeNo);
		reader.setRdDept(rdDept);
		reader.setRdPhone(rdPhone);
		reader.setRdEmail(rdEmail);
		reader.setRdPhoto(rdPhoto);
		
		ReaderMapper rm = (ReaderMapper) applicationContext.getBean("readerMapper");
		try {
			rm.insertReader(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	/*	PrintWriter out = response.getWriter();
		out.print(reader);
		*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
