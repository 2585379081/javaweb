/**
 * 用来更新读者的信息
 */
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
import com.libarary.model.Reader;

/**
 * Servlet implementation class UpdateReader
 */
@WebServlet("/UpdateReader")
public class UpdateReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReader() {
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
		
		

		String rdID = request.getParameter("rdID");
		String rdName = request.getParameter("rdName");
		String rdPwd = request.getParameter("rdPwd");
		String rdSex = request.getParameter("rdSex");
		String rdTypeName = request.getParameter("rdType");
		
		
		ReaderMapper rm = (ReaderMapper) applicationContext.getBean("readerMapper");
		Reader r=null;
		try {
			r = rm.noOfReader(rdID);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		//根据rdTypeName 找到rdType
		int rdType=0;
		try {
			rdType = rtm.noOfName(rdTypeName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String rdDept = request.getParameter("rdDept");
		String rdPhone =request.getParameter("rdPhone");
		String rdEmail= request.getParameter("rdEmail");
		String rdPhoto = request.getParameter("rdPhoto");
		
		//得到的是C:\fakepath\2.png
		if(rdPhoto!=null & rdPhoto !="") {
			String[] infos = rdPhoto.split("\\\\");
			rdPhoto = "image"+"/"+"reader"+"/"+infos[2];
			
		}else {
			rdPhoto = r.getRdPhoto();
		}
		

		
		
		
		
		
		
		Reader reader =new Reader();
		reader.setRdID(Integer.parseInt(rdID));
		reader.setRdName(rdName);
		reader.setRdPwd(rdPwd);
		reader.setRdSex(rdSex);
		reader.setRdType(rdType);
		reader.setRdDept(rdDept);
		reader.setRdPhone(rdPhone);
		reader.setRdEmail(rdEmail);
		reader.setRdPhoto(rdPhoto);
		
		try {
			rm.updateReader(reader);
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
