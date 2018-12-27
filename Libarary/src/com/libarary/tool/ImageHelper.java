/**
 * 用来写入图片
 *
 */
package com.libarary.tool;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;

import javax.imageio.ImageIO;

import com.libarary.dao.SqlHelper;

public class ImageHelper {
	
	public void writeImage(String rdID ) {
		File file = new File("C:\\Users\\25853\\Desktop\\wo\\db\\libarary\\reader\\2.png");
		FileInputStream fis=null;
		
		try {
			 fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SqlHelper sh = new SqlHelper();
		String sql ="update Reader set rdPhoto = ? where rdID = ?";
		String[] param = {rdID};
		if(sh.writeImage(sql,fis,param)) {
			System.out.println("成功");
		}else {
			System.out.println("失败");
		}
		
		
	}
	
	
	public  InputStream readerImage(String rdID) {
		Image image = null;
		SqlHelper sh = new SqlHelper();
		String sql ="select rdPhoto from Reader where rdID = ?";
		String[] param = {rdID};
		ResultSet rs = sh.query(sql, param);
		InputStream is=null;
		try {
	
			rs.next();
			is = rs.getBinaryStream(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return is;
		
		
	}
	public static void main(String[] args) {
		new ImageHelper().writeImage("222");
	
	}
}
