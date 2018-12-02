package com.test.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketFileServer {
	
	public static void main(String[] args) {
		ServerSocket ss = null;
		//1创建一个ServerSocket，确定一个端口
		try {
			ss = new ServerSocket(7070);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获得一个socket
		if(ss ==null) {
			System.out.println("服务器启动失败");
			return ;
			
		}
		System.out.println("服务器已经启动");
		
		while(true) {
			
			
			//获得一个socket
			try {
				System.out.print("等待客户端连接。。。");
				Socket socket = ss.accept();
				ServerThread serverThread = new ServerThread(socket);
				new Thread(serverThread).start();
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("服务器打开客户端失败");
				e.printStackTrace();
			}
			
			
		}
		
	}

}
