package com.shop.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.UserDao;
import com.shop.pojo.User;
import com.shop.service.UserService;
import com.shop.tool.BaseServlet;
import com.shop.tool.SQLHelper;
import com.shop.tool.urlTrsBase64;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see BaseServlet#BaseServlet()
     */
    public UserServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    //鐢ㄦ埛鐧婚檰鐨勫疄鐜颁笌鍒ゆ柇
	protected void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ,SQLException{
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		PrintWriter in = null;
		//璋冪敤service灞傛柟娉曡幏鍙栫櫥闄嗚繑鍥炲��
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");		
		UserService service = new UserService();
		
		//鐧婚檰鐘舵�佹爣蹇楋紝鎴愬姛涓�1澶辫触涓�0
		int status = service.login(userId,userPwd);
		//status 0:瀵嗙爜閿欒 锛�1锛氭纭�
		if(status == 0)
		{
			//鐧婚檰澶辫触,杩斿洖鐧婚檰鐘舵��
			in = response.getWriter();
			in.println(status);
			in.flush();
			in.close();
		}
		else
		{
			//鐧婚檰鎴愬姛,灏嗙敤鎴稩d瀛樺叆session
			//根据userId来查询user,保存在session 中
			UserDao dao = new UserDao();
			User user=null;
			try {
				user = dao.getUserById(userId);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			request.getSession().setAttribute("userId", userId);
			if(user.getPhone() != null && user.getUserAddress() != null)
			{
				request.getSession().setAttribute("user",user);
			}
			in = response.getWriter();
			in.println(status);
			in.flush();
			in.close();
		}
	}
	
	
	//鐢ㄦ埛娉ㄥ唽璋冪敤
	protected void userReigster(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		PrintWriter in = null;
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		UserService service = new UserService();
		//娉ㄥ唽鐘舵�佹爣蹇楋紝鎴愬姛涓�1澶辫触涓�0锛堝凡瀛樺湪鐢ㄦ埛鍚嶇浉鍚岀殑鐢ㄦ埛锛�
		int status = service.reigster(userId,userPwd);
		if(status == 0)
		{
			//鐧婚檰澶辫触,杩斿洖鐧婚檰鐘舵��
			in = response.getWriter();
			in.println(status);
			in.flush();
			in.close();
		}
		else
		{
			//娉ㄥ唽鎴愬姛锛岃繑鍥炴敞鍐岀姸鎬�
			in = response.getWriter();
			in.println(status);
			in.flush();
			in.close();
		}
		
	}
	
	//修改用户信息
	protected void userAlterInf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter in = null;
		Object inf[] = new Object[4];
		String userId = request.getParameter("userId");
		
		inf[0] = request.getParameter("nickName");//鏄电О
		inf[1] = request.getParameter("userAddress");//鍦板潃
		inf[2] = request.getParameter("phone");//鐢佃瘽
		
		//浠庡墠绔紶鏉ュ浘鐗噓rl鐨勭粷瀵硅矾寰�
		String path = request.getParameter("src");//鑾峰緱鐨勫ご鍍忕殑url
		
		//如果用户重新选择图片的话
		if(path!=null) {
			int index = path.indexOf(",");
	    	String base64 = path.substring(index+1);
			byte[] image = urlTrsBase64.base64ToByte(base64);
			//url = "C:/Users/YY/Desktop/temp/photo/001.jpg";
			inf[3] = image;
		}
		
		//如果用户不重新选择图片，通过id查询以前的图片
		UserDao dao = new UserDao();
		User user=null;
		try {
			user = dao.getUserById(userId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(path==null) {
			inf[3] = user.getUserImage();
		}	
		
		String sql = "update Tb_User set nickName=?, userAddress=?, phone=?,userImage=? where userId = '"+userId+"'";
		try
		{
			SQLHelper.ExecSql(sql, inf); 
			//鎵ц娌℃湁閿欒锛屽皢user瀵硅薄瀛樺叆session瑕嗙洊
			user = dao.getUserById(userId);
			request.getSession().setAttribute("user", user);			
			//杩斿洖鐧婚檰鎴愬姛鐘舵��
			in = response.getWriter();
			in.println(1);
			in.flush();
			in.close();
			
		}
		catch(Exception e)
		{
			in = response.getWriter();
			in.println(-1);
			in.flush();
			in.close();
		}
		
	}
	
	//鐢ㄦ埛瀹夊叏淇℃伅淇敼锛堢櫥闄嗗瘑鐮侊級鐧婚檰瀵嗙爜閿欒杩斿洖-1锛屼慨鏀规垚鍔�1锛屼咯娆″瘑鐮佷竴鑷�0锛屾湇鍔″櫒鍑洪敊-2
	protected void userAlterPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter in = null;
		String userId = request.getParameter("userId");	
		try
		{
			//鍏堝彇鍑鸿鐢ㄦ埛鐨勫瘑鐮侊紝鐒跺悗鍒ゆ柇鏂拌緭鍏ョ殑鍜屽師鍏堝瘑鐮佷笉鑳戒竴鑷�
			UserDao dao = new UserDao();
			User user = dao.getUserById(userId);
			//鍘熷厛鐨勫瘑鐮�
			String bfPwd = user.getUserPwd();
			//浠庢涓鍑轰互鍓嶇殑瀵嗙爜,涓嶄竴鑷寸洿鎺ヨ繑鍥�-1
			String input_bfPwd = request.getParameter("bfPwd");
			if(!input_bfPwd.equals(bfPwd))
			{
				in = response.getWriter();
				in.println(-1);
				in.flush();
				in.close();
				return;
			}
			//鐜板湪鐨勫瘑鐮�
			String afPwd = request.getParameter("afPwd");
			//鍒ゆ柇
			if(bfPwd.equals(afPwd))
			{
				//淇╂瀵嗙爜涓�鑷�
				in = response.getWriter();
				in.println(0);
				in.flush();
				in.close();
				return;
			}
			
			//淇╂瀵嗙爜涓嶄竴鑷达紝瀛樺叆
			String sql = "update Tb_User set userpwd = ? where userId = ?";
			Object[] object = {afPwd,userId};
			SQLHelper.ExecSql(sql,object);
			//鎵ц娌℃湁閿欒锛屽皢user瀵硅薄瀛樺叆session瑕嗙洊
			user = dao.getUserById(userId);
			request.getSession().setAttribute("user", user);
			
			//杩斿洖鐧婚檰鎴愬姛鐘舵��
			in = response.getWriter();
			in.println(1);
			in.flush();
			in.close();
		}
		catch(Exception e)
		{
			in = response.getWriter();
			in.println(-2);
			in.flush();
			in.close();
		}
	}
	
	//鐐瑰嚮鏍规嵁鐢ㄦ埛鏄惁寮�閫氭潵澧炲姞澶╂暟锛岃皟鐢ㄥ瓨鍌ㄨ繃绋�
	protected void userOpenVip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");	
		int days = Integer.parseInt(request.getParameter("days"));
		
		
		//根据userId把user查出来
		//然后重新设置session
		UserDao dao = new UserDao();
		User user=null;
		try {
			user = dao.getUserById(userId);
			request.getSession().setAttribute("user",user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		UserService service = new UserService();
		int result = service.userOpenVip(userId,days);
		PrintWriter in = response.getWriter();
		in.println(result);
		in.flush();
		in.close();

	}
	
	protected void userPayPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter in = null;
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userPayPwd = request.getParameter("userPayPwd");
		UserService service = new UserService();
		//鍏堝彇鍑鸿鐢ㄦ埛鐨勫瘑鐮侊紝鐒跺悗鍒ゆ柇鏂拌緭鍏ョ殑鍜屽師鍏堢櫥闄嗗瘑鐮佷笉涓�鑷寸洿鎺ヨ繑鍥�-1
		UserDao dao = new UserDao();
		User user = null;
		
		try {
			user = dao.getUserById(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!user.getUserPwd().equals(userPwd))
		{
			in = response.getWriter();
			in.println(-1);
			in.flush();
			in.close();
			return;
		}
		service.userPayPwd(userId,userPayPwd);
		//浼犻�掔粰Servlet
		in = response.getWriter();
		in.println(1);
		in.flush();
		in.close();
	}
	
	
	public void showBaseInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//要从数据库里面查询user
		//然后保存到session中
		 String userId = (String)request.getSession().getAttribute("userId");
		 
			UserDao dao = new UserDao();
			User user = null;
			
			try {
				user = dao.getUserById(userId);
				//保存到session中
				request.getSession().setAttribute("user",user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//跳转到myinfo.jsp
		request.getRequestDispatcher("/myinfo.jsp").forward(request,response);
	}
	
	//判断个人信息是否完整，从而可以知道是否可以生成订单
	public void judgeBaseInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("UserServlet:judgeBaseInfo:开始判断用户信息是否完整");
		//先得到userId
		 String userId = (String)request.getSession().getAttribute("userId");
		 PrintWriter in = null;
			UserDao dao = new UserDao();
			User user = null;
			in = response.getWriter();
			try {
				user = dao.getUserById(userId);
				//判断电话和地址是否为空
				if(user.getPhone()!=null&&user.getUserAddress()!=null) {
					in.println(1);
					in.flush();
					in.close();
				}else {
					in.println(0);
					in.flush();
					in.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
