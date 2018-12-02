package com.test.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable{
	private Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		System.out.println("服务器转送线程已开启");
		
		while(true) {
			try {
				Reader reader = new InputStreamReader(socket.getInputStream());
				BufferedReader in = new BufferedReader(reader);
				
				//获得线程流中的数据
				String message = in.readLine();
				
				System.out.println("客户端传来的信息"+message);
				
				//回送消息给客户端
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				
				Scanner sc = new Scanner(System.in);
				String info = sc.next();
				writer.println(info);
				writer.flush();
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				if(socket!=null) {
					try {
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	/*public List<String> getFile(BufferedReader in) throws IOException{
		List<String> context = new ArrayList<>();
		while(true) {
			String tempStr = in.readLine();
			if(tempStr.equals("endendend")) {
				break;
			}
			context.add(tempStr);
			
		}
		
		return context;
	}*/

}
