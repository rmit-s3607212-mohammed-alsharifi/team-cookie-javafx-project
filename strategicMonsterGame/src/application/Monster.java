package application;

import java.util.Random;

public class Monster extends Cell 
{
	private static int xPos = 3;
	private static int yPos = 3;
	private static int abc = 1;
	
	static Random r = new Random();
	
	
	private static int right = 0;
	private static int left = 1;
	private static int up =2;
	private static int down = 3;
	private static int dir = -1;
	
	
	private static int newY;
	private static int newX;
	
	
	public Monster(int x , int y) 
	{
		this.id = "MONSTER";
		
	}
	
	public static int getxPos()
	{
		return xPos;
	}
	
	public static int getyPos()
	{
		return yPos;
	}
	
	public static void setxpos(int newx)
	{
		xPos = newx;
	}
	
	
	public static void setypos(int newy)
	{
		yPos = newy;
	}

	static void MonsterMove()
	{
		dir= r.nextInt(4);
		if(dir == right)
		{
			newX = (Monster.getxPos()+abc);
			Monster.setxpos(newX);
		}
		if(dir==left)
		{
			newX = (Monster.getxPos()-abc);
			Monster.setxpos(newX);
		}
		if(dir==up)
		{
			newY = (Monster.getyPos()-abc);
			Monster.setypos(newY);
		}
		if(dir==down)
		{
			newY = (Monster.getyPos()+abc);
			Monster.setypos(newY);
		}
		
		
		
		if(xPos<=1 ) xPos = 1;
		if(yPos>=9) yPos =9 ;
		if(yPos<=1) yPos=1;
		if(xPos>=9) xPos =9;
		
		
		
		
		
	}


	
	
	
	
}
