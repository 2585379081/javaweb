/**
������һ������Ȼ�������������һ�������Ƚ��������ǲ������
*/

import java.lang.*;
import java.util.*;



class Player 
{
//�û�Ҫ�µ������
   public  int num; 

    public void guess()
	{
		//����һ��0-9֮�����
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
      //����GuessGame�еķ���
	  System.out.println("����������0-9������ֵ");
	  Scanner sc = new Scanner(System.in);
	  int num1 = sc.nextInt();
	  int num2 = sc.nextInt();
	  int num3 = sc.nextInt();
 
      //����Guessgame
	  GuessGame gg = new GuessGame();
	  gg.startGame();

	  if(num1 ==gg.player1.num)
		{
		  System.out.println("��ϲ��һ����Ҳ¶���");
		}else
		{
			System.out.println("���ź�����һ����Ҳ´���"+gg.player1.num);
		}

		if(num2 ==gg.player2.num)
		{
		  System.out.println("��ϲ�ڶ�����Ҳ¶���");
		}else
		{
			System.out.println("���ź����ڶ�����Ҳ´���"+gg.player2.num);
		}

		if(num3 ==gg.player3.num)
		{
		  System.out.println("��ϲ��������Ҳ¶���");
		}else
		{
			System.out.println("���ź�����������Ҳ´���"+gg.player3.num);
		}
	}
}





