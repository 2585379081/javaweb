package com.test.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketFileServer {
	
	public static void main(String[] args) {
		ServerSocket ss = null;
		//1����һ��ServerSocket��ȷ��һ���˿�
		try {
			ss = new ServerSocket(7070);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���һ��socket
		if(ss ==null) {
			System.out.println("����������ʧ��");
			return ;
			
		}
		System.out.println("�������Ѿ�����");
		
		while(true) {
			
			
			//���һ��socket
			try {
				System.out.print("�ȴ��ͻ������ӡ�����");
				Socket socket = ss.accept();
				ServerThread serverThread = new ServerThread(socket);
				new Thread(serverThread).start();
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("�������򿪿ͻ���ʧ��");
				e.printStackTrace();
			}
			
			
		}
		
	}

}
