/**
 * 
 */
/**
 * @author 金畅
 *
 */
package com.test1;


class test{
	public static void main(String [] args) {
		SoldWindow sw = new SoldWindow();                     //一个对象可以有多个进程但是一个进程只能start一次
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
	
              synchronized(this) {                     //同步锁
					if(num>0) {
					System.out.println("还有"+num+"张票");	     //输出后可以还没减1别的进程就又输出了
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






