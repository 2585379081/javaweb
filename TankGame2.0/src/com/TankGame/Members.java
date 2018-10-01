package com.TankGame;

import java.util.*;
import java.io.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

//������������


class AePlayWave extends Thread {

	private String filename;           //�ļ���
	public AePlayWave(String wavfile) {
		filename = wavfile;

	}

	public void run() {

		File soundFile = new File(filename);       //�������ļ�����

		AudioInputStream audioInputStream = null;       //��Ƶ���ļ��ֽ�������
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}

		AudioFormat format = audioInputStream.getFormat();    //�������ݵĸ�ʽ
		//���һ��Դ�����У����п������� AudioFormat ����ָ���ĸ�ʽ�ط���Ƶ���ݡ�
		SourceDataLine auline = null;                       //
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		auline.start();
		int nBytesRead = 0;
		//���ǻ���
		byte[] abData = new byte[512];

		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}

	}

	
}

//��¼��,ͬʱҲ���Ա�����ҵ�����
class Recorder
{
	//��¼ÿ���ж��ٵ���
	private static int enNum=20;
	//�������ж��ٿ����õ���
	private static int myLife=3;
	//��¼�ܹ������˶��ٵ���
	private static int allEnNum=0;
	
	//����̹�˵�����
	static Vector<EnemyTank>  ets= new Vector<EnemyTank>();
	
	//���ļ��лָ���¼��
   static FileWriter fw = null;
    static BufferedWriter bfw = null;
    static FileReader fr = null;
    static BufferedReader bfr = null;
    
    
    //������ets���������ets������
    public static void setEnemyTank(Vector<EnemyTank> vv)
    {
    	ets = vv;
    }
	
	public static void keepRecording()
	{
		try {
			fw = new FileWriter("D:\\java code\\TankGame2.0\\abc.txt");
			bfw =new BufferedWriter(fw);
			bfw.write(allEnNum+"\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				bfw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	public static void getRecording()
	{
		try {
			fr= new FileReader("D:\\java code\\TankGame2.0\\abc.txt");
			bfr = new BufferedReader(fr);
			
			try {
				allEnNum =Integer.parseInt(bfr.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bfr.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	//������Ϸ
	public static Vector<EnemyTank> getRecAndEnemyTank()
	{
		try {
			fr= new FileReader("D:\\java code\\TankGame2.0\\abc.txt");
			bfr = new BufferedReader(fr);
			
			try {
				allEnNum =Integer.parseInt(bfr.readLine());
				String str = "";
				while((str=bfr.readLine())!=null)
				{
					String xyz[] = str.split(" ");
				    EnemyTank et = new EnemyTank(Integer.parseInt(xyz[0]),Integer.parseInt(xyz[1]));
				    ets.add(et);
					
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bfr.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ets;
	}
	
	//�����˳�������ɼ����͵���̹�˵�����ͷ���
	
	public static void keepRecAndEnemyTank()
	{
		try {
			fw = new FileWriter("D:\\java code\\TankGame2.0\\abc.txt");
			bfw =new BufferedWriter(fw);
			bfw.write(allEnNum+"\r\n");
			for(int i = 0;i<ets.size();i++)
			{
				EnemyTank et = ets.get(i);
				if(et.isLive) 
				{
				bfw.write(et.x+" "+et.y+" "+et.direct+"\r\n");
				}
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				bfw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	
	
	
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	public static int getMyLife() {
		return myLife;
	}
	public static void setMyLife(int myLife) {
		Recorder.myLife = myLife;
	}
	
	//���ٵ�����
	public static void reduceEnNum()
	{
		enNum--;
	}
	//�������
	public static void addEnNumRec()
	{
		allEnNum++;
	}
	public static int getAllEnNum() {
		return allEnNum;
	}
	public static void setAllEnNum(int allEnNum) {
		Recorder.allEnNum = allEnNum;
	}






}

//ը����
class Bomb 
{
	//����ը��������
	int x,y;
	//ը��������
	int life=9;
	boolean isLive=true;
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	//��������ֵ
	public void lifeDown()
	{
		if(life>0)
		{
			life--;
		}else{
			this.isLive=false;
		}
		
	}
	
	
	
}

//�ӵ���
class Shot implements Runnable  {
	int x;
	int y;
	int direct;
	int speed=1;
	//�Ƿ񻹻���
	boolean isLive=true;
	public Shot(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	public void run() {
		
		while(true)
		{
			
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			switch(direct)
			{
			case 0:
				//��
				y-=speed;
				break;
			case 1:
				x+=speed;
				break;
			case 2:
				y+=speed;
				break;
			case 3:
				x-=speed;
				break;
			}
			
		//	System.out.println("�ӵ�����x="+x+" y="+y);
			//�ӵ���ʱ����???
			
			//�жϸ��ӵ��Ƿ�������Ե.
			if(x<0||x>400||y<0||y>300)
			{
				this.isLive=false;
				break;
			}
		}
	}
}


//̹����
class Tank
{
	//��ʾ̹�˵ĺ�����
	int x=0;
	//̹��������
	int y=0;
	
	//̹�˷���
	//0��ʾ�� 1��ʾ �� 2��ʾ��  3��ʾ��
	int direct=0;
	int color;
	
	boolean isLive=true;
	
	//̹�˵��ٶ�
	int speed=1;
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
}

//���˵�̹��,�ѵ��������߳���
class EnemyTank extends Tank implements Runnable
{
	
	int times=0;
	
	//����һ�����������Է��ʵ�MyPanel�����е��˵�̹��
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	//����һ�����������Դ�ŵ��˵��ӵ�
	Vector<Shot> ss=new Vector<Shot>();
	//��������ӵ���Ӧ���ڸոմ���̹�˺͵��˵�̹���ӵ�������
	public EnemyTank(int x,int y)
	{
		super(x,y);	
	}
	
	//�õ�MyPanel�ĵ���̹������
	public void setEts(Vector<EnemyTank> vv)
	{
		this.ets=vv;
	}

	//�ж��Ƿ������˱�ĵ���̹��
	public boolean isTouchOtherEnemy()
	{
		boolean b=false;
		
		
		switch(this.direct)
		{
		case 0:
			//�ҵ�̹������
			//ȡ�����еĵ���̹��
			for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				EnemyTank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					//������˵ķ��������»�������
					if(et.direct==0||et.direct==2)
					{
						//���
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 1:
			//̹������
			//ȡ�����еĵ���̹��
			for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				EnemyTank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					//������˵ķ��������»�������
					if(et.direct==0||et.direct==2)
					{
						//�ϵ�
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						//�µ� 
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 2:
			//̹������
			//ȡ�����еĵ���̹��
			for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				EnemyTank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					//������˵ķ��������»�������
					if(et.direct==0||et.direct==2)
					{
						//�ҵ����
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
						{
							return true;
						}
						//�ҵ��ҵ�
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
						{
							return true;
						}
						
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 3:
			//����
			//ȡ�����еĵ���̹��
			for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				EnemyTank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					//������˵ķ��������»�������
					if(et.direct==0||et.direct==2)
					{
						//�ҵ���һ��
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						//��һ��
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						//��һ��
						if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		}
		
		
		return b;
	}
	
	
	
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			
		
			switch(this.direct)
			{
			case 0:
				//˵��̹����������
				for(int i=0;i<30;i++)
				{
					if(y>0&&!this.isTouchOtherEnemy())
					{
						y-=speed;
					}
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			case 1:
				//����
				for(int i=0;i<30;i++)
				{
					//��֤̹�˲����߽�
					if(x<400&&!this.isTouchOtherEnemy())
					{
						x+=speed;
					}
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			case 2:
				//����
				for(int i=0;i<30;i++)
				{
					if(y<300&&!this.isTouchOtherEnemy())
					{
						y+=speed;
					}
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			case 3:
				//����
				for(int i=0;i<30;i++)
				{
					if(x>0&&!this.isTouchOtherEnemy())
					{
						x-=speed;
					}
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			
			}
			
			this.times++;
			
			if(times%2==0)
			{
				if(isLive)
				{
					if(ss.size()<5)
					{
						//System.out.println("et.ss.size()<5="+et.ss.size());
						Shot s=null;
						//û���ӵ�
						//���
						switch(direct)
						{
						case 0:
							//����һ���ӵ�
							 s=new Shot(x+10,y,0);
							//���ӵ���������
							ss.add(s);
							break;
						case 1:
							s=new Shot(x+30,y+10,1);
							ss.add(s);
							break;
						case 2:
							 s=new Shot(x+10,y+30,2);
							ss.add(s);
							break;
						case 3:
							s=new Shot(x,y+10,3);
							ss.add(s);
							break;
						}
						
						//�����ӵ�
						Thread t=new Thread(s);
						t.start();
					}
				}
			}
			
			
			//��̹���������һ���µķ���
			this.direct=(int)(Math.random()*4);
			
			//�жϵ���̹���Ƿ�����
			if(this.isLive==false)
			{
				//��̹���������˳��߳�.
				break;
			}
			
			
			
			
			
		}
		
	}
}

//�ҵ�̹��
class Hero extends Tank
{
	
	//�ӵ�
	
	//Shot s=null;
	Vector<Shot> ss=new Vector<Shot>();
	Shot s=null;
	public Hero(int x,int y)
	{
		super(x,y);
		
		
	}
	
	//����
	public void shotEnemy()
	{
		
		
		switch(this.direct)
		{
		case 0:
			//����һ���ӵ�
			 s=new Shot(x+10,y,0);
			//���ӵ���������
			ss.add(s);
			break;
		case 1:
			s=new Shot(x+30,y+10,1);
			ss.add(s);
			break;
		case 2:
			 s=new Shot(x+10,y+30,2);
			ss.add(s);
			break;
		case 3:
			s=new Shot(x,y+10,3);
			ss.add(s);
			break;
			
		}
		//�����ӵ��߳�
		Thread t=new Thread(s);
		t.start();
		
	}
	
	
	//̹�������ƶ�
	public void moveUp()
	{
		y-=speed;
	}
	//̹�������ƶ�
	public void moveRight()
	{
		x+=speed;
	}
	
	//̹�������ƶ�
	public void moveDown()
	{
		y+=speed;
	}
	
	//����
	public void moveLeft()
	{
		x-=speed;
	}
}