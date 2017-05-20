package application;

import java.util.Random;

public class Monster extends Cell 
{
	private static int xPos = 3;
	private static int yPos = 3;
	static Random r = new Random();
	private static int right = 0;
	private static int left = 1;
	private static int up =2;
	private static int down = 3;
	private static int dir = -1;
	private static int newY;
	private static int newX;
	
	
	public Monster(int Xinput , int Yinput) //Hero is the return type here. This is a constructor I'm pretty sure.
	{
		this.id = "MONSTER";
		int xPos = Xinput;
		int yPos = Yinput;
	}
	
	
	
	
		//Encapsulation time!
		//Be mindful as I go: That strange hero method(?) 
		//above may just be representative of position.
	
	
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
			newX = (Monster.getxPos()+1);
			Monster.setxpos(newX);
		}
		if(dir==left)
		{
			newX = (Monster.getxPos()-1);
			Monster.setxpos(newX);
		}
		if(dir==up)
		{
			newY = (Monster.getyPos()-1);
			Monster.setypos(newY);
		}
		if(dir==down)
		{
			newY = (Monster.getyPos()+1);
			Monster.setypos(newY);
		}
		
		
		
		
		
		
	}


	
	
	
	
}
