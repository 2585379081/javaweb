package com.shop.tool;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class urlTrsBase64 
{
	//url转化为base64
	public static String urlToBase64(String url) throws IOException
	{
		FileInputStream fis = new FileInputStream(url);
        byte[] b = new byte[fis.available()];
        StringBuilder str = new StringBuilder();//不建议用String

        fis.read(b);
       for(byte bs:b)
          {
           str.append(Integer.toBinaryString(bs));//转换为二进制
          }
//        BASE64Encoder encode = new BASE64Encoder();
//        String base64 = encode.encode(b);

       	String base64 = Base64.getEncoder().encodeToString(b);
        return base64;
	}
	
	//url转化为byte
	public static byte[] urlToByte(String url) throws IOException
	{
		FileInputStream fis = new FileInputStream(url);
        byte[] b = new byte[fis.available()];
        StringBuilder str = new StringBuilder();//不建议用String

        fis.read(b);
       for(byte bs:b)
          {
           str.append(Integer.toBinaryString(bs));//转换为二进制
          }
       return b; 
	}
	
	//base64转化为byte
	public static byte[] base64ToByte(String base64) 
	{
//		BASE64Decoder decode = new BASE64Decoder();
//		byte[] b = null;
//		
//		try {
//			b = decode.decodeBuffer(base64);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		byte[] b = Base64.getDecoder().decode(base64);
		return b;
	}
	
	//base64转化为byte
	public static String byteToBase64(byte[] image)
	{
//		 BASE64Encoder encode = new BASE64Encoder();
//         String base64 = encode.encode(image);
		String base64 = Base64.getEncoder().encodeToString(image);
		
        return base64;
	}
}
