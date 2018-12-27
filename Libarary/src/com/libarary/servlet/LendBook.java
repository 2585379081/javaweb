package com.libarary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.libarary.mapper.BorrowMapper;
import com.libarary.mapper.ReaderTypeMapper;
import com.libarary.model.ReaderType;
import com.libarary.po.LendVo;

/**
 * Servlet implementation class LendBook
 */
@WebServlet("/LendBook")
public class LendBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LendBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operatorLend = request.getParameter("operatorLend");
		String bkID =  request.getParameter("bkID");
		String rdID = request.getParameter("rdID");
		String id = request.getParameter("id");
		
		
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		BorrowMapper bm = (BorrowMapper) applicationContext.getBean("borrowMapper");
		
		//先从读者类型中查询出可借次数，可借的天数
		if(id==null) {
			//执行借书
			lendBook(bm,rdID,bkID,operatorLend,response);
		}else {
			//执行续借的操作
			contitueLend(bm,rdID,bkID,operatorLend,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public void contitueLend(BorrowMapper bm,String rdID,String bkID,String operatorLend,HttpServletResponse response) {
		ReaderTypeMapper btm  = (ReaderTypeMapper) applicationContext.getBean("readerTypeMapper");
		ReaderType rt=null;
		try {
			rt = btm.rdIDofReaderType(Integer.parseInt(rdID));
		}  catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Date date =new Date();
		DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		
		//字符串转化为date
		try {
			date =format.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int canLendDay = rt.getCanLendDay();
		Calendar cal = Calendar.getInstance();   
        cal.setTime(date);   
        cal.add(Calendar.DAY_OF_YEAR, rt.getCanLendDay());
        date = cal.getTime();
		
		
		LendVo lendVo = new LendVo();
		lendVo.setRdID(rdID);
		lendVo.setBkID(bkID);
		lendVo.setIdDateRetPlan(format.format(date));
		lendVo.setOperatorLend(operatorLend);
		
		
		try {
			bm.contitueLend(lendVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				PrintWriter out = response.getWriter();
				out.write("1");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
	}

	
	public void lendBook(BorrowMapper bm,String rdID,String bkID,String operatorLend,HttpServletResponse response) {
		ReaderTypeMapper btm  = (ReaderTypeMapper) applicationContext.getBean("readerTypeMapper");
		ReaderType rt=null;
		try {
			rt = btm.rdIDofReaderType(Integer.parseInt(rdID));
		}  catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Date date =new Date();
		DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		
		//字符串转化为date
		try {
			date =format.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int canLendDay = rt.getCanLendDay();
		Calendar cal = Calendar.getInstance();   
        cal.setTime(date);   
        cal.add(Calendar.DAY_OF_YEAR, rt.getCanLendDay());
        date = cal.getTime();
        
		
		LendVo lendVo = new LendVo();
		lendVo.setBkID(bkID);
		lendVo.setRdID(rdID);
		lendVo.setIdDateOut(time);
		lendVo.setIdDateRetPlan(format.format(date));
		lendVo.setOperatorLend(operatorLend);
		try {
			bm.lendBook(lendVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			PrintWriter out;
			try {
				out = response.getWriter();
				out.write("1");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
}
