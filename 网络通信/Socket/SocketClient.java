package com.test.Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;

public class SocketClient {

	
	public static void main(String[] args) {
		//创建一个socket
		Socket client = null;
		
		try {
			client = new Socket("127.0.0.1",8080);
			PrintWriter out = new PrintWriter(client.getOutputStream());
			out.println("呼叫金畅");
			out.flush();
			
			
			
			//获得从服务器传回的信息
			Reader reader = new InputStreamReader(client.getInputStream());
			BufferedReader in = new BufferedReader(reader);
			String info = in.readLine();
			System.out.println("回送的消息为"+info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
