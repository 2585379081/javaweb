/**
先输入一个数，然后计算机随机产生一个数，比较两个数是不是相等
*/

import java.lang.*;
import java.util.*;



class Player 
{
//用户要猜的随机数
   public  int num; 

    public void guess()
	{
		//产生一个0-9之间的数
		num =(int) (Math.random()*10);
	}
}

class GuessGame
{
	public  Player player1;
	public  Player player2;
	public  Player player3;

	public GuessGame()
	{
		player1 = new Player();
		player2 = new Player();
		player3 = new Player();
	}


	public void startGame()
	{
       player1.guess();
	   player2.guess();
	   player3.guess();
	}
}


public class test1
{

	public static void main(String [] args)
	{
      //调用GuessGame中的方法
	  System.out.println("请输入三个0-9的整数值");
	  Scanner sc = new Scanner(System.in);
	  int num1 = sc.nextInt();
	  int num2 = sc.nextInt();
	  int num3 = sc.nextInt();
 
      //调用Guessgame
	  GuessGame gg = new GuessGame();
	  gg.startGame();

	  if(num1 ==gg.player1.num)
		{
		  System.out.println("恭喜第一个玩家猜对了");
		}else
		{
			System.out.println("很遗憾，第一个玩家猜错了"+gg.player1.num);
		}

		if(num2 ==gg.player2.num)
		{
		  System.out.println("恭喜第二个玩家猜对了");
		}else
		{
			System.out.println("很遗憾，第二个玩家猜错了"+gg.player2.num);
		}

		if(num3 ==gg.player3.num)
		{
		  System.out.println("恭喜第三个玩家猜对了");
		}else
		{
			System.out.println("很遗憾，第三个玩家猜错了"+gg.player3.num);
		}
	}
}





