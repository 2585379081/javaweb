/**
 * 
 */
/**
 * @author ��
 *
 */
package com.test1;


class test{
	public static void main(String [] args) {
		SoldWindow sw = new SoldWindow();                     //һ����������ж�����̵���һ������ֻ��startһ��
		Thread t1= new Thread(sw);
		Thread t2= new Thread(sw);
		Thread t3 = new Thread(sw);
		t1.start();
		t2.start();
		t3.start();
	}
}

class SoldWindow implements Runnable{
private int num=2000;	

	
	public void run() {
		while(true) { 
	
              synchronized(this) {                     //ͬ����
					if(num>0) {
					System.out.println("����"+num+"��Ʊ");	     //�������Ի�û��1��Ľ��̾��������
					  try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					num--;
					}else {
						break;
					}
              }
		}	
			
	}
}






