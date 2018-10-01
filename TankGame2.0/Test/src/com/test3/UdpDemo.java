package com.test3;

import java.net.*;
import java.io.*;


class UdpSend  implements Runnable
{
	DatagramSocket ds;


     UdpSend(DatagramSocket ds)
	{
		 this.ds = ds;
	}


	public void run(){
		try{
      BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
	  String line = null;
	   while((line=bufr.readLine()) !=null){

			if(line.equals("886"))
				break;

             byte[] buf= line.getBytes();

			DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.182.1"),8888);
			ds.send(dp);
	   }
	   ds.close();
	}
	catch(Exception e)
		{
		throw new RuntimeException("1");
		}
 }
}

class UdpRece implements Runnable
{
	DatagramSocket ds;
	UdpRece(DatagramSocket ds){
	   this.ds = ds;
	}


	public void run(){
		try{
		while(true){
		      byte[] buf = new byte[1024];
			  DatagramPacket dp = new DatagramPacket(buf,buf.length);
			  ds.receive(dp);

			  String ip = dp.getAddress().getHostAddress();
			  String data = new String (dp.getData(),0,dp.getLength());
			  System.out.println(ip+":"+data);
		 }
		}
		catch(Exception e)
		{
			throw new RuntimeException("1");
		}
   }
}

class UdpDemo 
{
	public static void main(String [] args) throws Exception{

	     DatagramSocket sendSocket =new DatagramSocket();
		 DatagramSocket receSocket = new DatagramSocket(8888);

		 new Thread(new UdpSend(sendSocket)).start();
		 new Thread(new UdpRece(receSocket)).start();
	}
}
