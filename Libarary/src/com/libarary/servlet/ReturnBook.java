package com.libarary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.libarary.model.Borrow;
import com.libarary.model.ReaderType;
import com.libarary.po.LendVo;
import com.libarary.po.ReturnVo;

/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bkID =  request.getParameter("bkID");
		String rdID = request.getParameter("rdID");
		String operatorRet = request.getParameter("operatorRet");
		//这里要调用存储过程
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		BorrowMapper bm = (BorrowMapper) applicationContext.getBean("borrowMapper");
		ReaderTypeMapper rtm = (ReaderTypeMapper) applicationContext.getBean("readerTypeMapper");
		
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		

		
		//overDay 就是用当前的事件减去借出的时间（到数据库中查询）
       LendVo lendVo = new LendVo();
       lendVo.setBkID(bkID);
       lendVo.setRdID(rdID);
       Borrow borrow = null;
       
       try {
    	   borrow = bm.queryBorrow(lendVo);
		
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
       
      
       
       String idDateRetPlan = borrow.getIdDateRetPlan();
       String nowDay = format.format(new Date());
       
       
      
       long idrp = getDaySub(idDateRetPlan,nowDay);

       
	    int idOverDay = (int)idrp;
	    
	    if(idOverDay< 0) {
	    	idOverDay =0;
	    }
	    
	    
	    //从ReaderType 中去获得超期的rate
	    ReaderType reader=null;
		try {
			reader = rtm.rdIDofReaderType(Integer.parseInt(rdID));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    float punishRate = reader.getPunishRate();
	    
	    
		ReturnVo  returnVo = new ReturnVo();
		returnVo.setBkID(bkID);
		returnVo.setRdID(rdID);
		returnVo.setIdOverDay(idOverDay+"");
		returnVo.setIdOverMoney(punishRate*idOverDay);
		returnVo.setOperatorRet(operatorRet);
		
		//更改borrow表中的数据
		try {
			bm.updateBorrow(returnVo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		
		try {
			bm.returnBook(returnVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			PrintWriter out = response.getWriter();
			out.write("1");
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
	
	 public static long getDaySub(String beginDateStr,String endDateStr){
	       long day=0;
	       java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");    
	       java.util.Date beginDate;
	       java.util.Date endDate;
	       try {
	           beginDate = format.parse(beginDateStr);
	           endDate= format.parse(endDateStr);    
	           day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);    
	          //System.out.println("相隔的天数="+day);   
	       } catch (ParseException e){
	           // TODO 自动生成 catch 块
	           e.printStackTrace();
	       }   
	       return day;
	   }

}
