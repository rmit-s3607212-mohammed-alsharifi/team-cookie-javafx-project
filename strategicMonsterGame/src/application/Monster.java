package application;


import java.util.Random;



public class Monster extends Cell 
{
	private static int xPos = 3;  // start point of monster is 3-3;
	private static int yPos = 3;
	
	
	static Random r = new Random();
	
	
	private static int right = 0;        //Random function will chose randomly from 0 to 3 ( 4 directions )
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
	
	public static int getxPos()     //get x position
	{
		return xPos;
	}
	
	public static int getyPos()     //get y position
	{
		return yPos;
	}
	
	public static void setxpos(int newx)    // change x position
	{
		xPos = newx;
	}
	
	
	public static void setypos(int newy)    // change y position
	{
		yPos = newy;
	}

	static void MonsterMove()
	{
		
		dir = r.nextInt(4);
		if(dir == right)
		{
			if(checkMove())
			{
				newX = (Monster.getxPos()+1);   //turn right --> x changed (plus 1)
				Monster.setxpos(newX);
			}
			else
			{
				
				System.out.println("Can not step on Block");
				dir = r.nextInt(4);
			}
		}
		
		
		if(dir==left)
		{
			if(checkMove())
			{
				newX = (Monster.getxPos()-1);   //turn left --> x changed (minus 1)
				Monster.setxpos(newX);
			}
			else
			{
				System.out.println("Can not step on Block");
				dir=r.nextInt(4);
			}
		}
		
			
		if(dir==up)
		{
			if(checkMove())
			{
				newY = (Monster.getyPos()-1);  //go up ---> y changed ( minus 1)
				Monster.setypos(newY);
			}
			else
			{
				System.out.println("Can not step on Block");
				dir=r.nextInt(4);
			}
		}
		
		if(dir==down)
		{
			if(checkMove())
			{
				newY = (Monster.getyPos()+1);   //go down ---> y changed ( plus 1 )
				Monster.setypos(newY);
			}
			else
			{
				System.out.println("Can not step on Block");
				dir=r.nextInt(4);
			}
		}
		
		if(xPos<=1) xPos=1;     		//Make sure that the monster wont move out the grid.
		if(yPos>=8) yPos=8;				//Make sure that the monster wont move out the grid.
		if(yPos<=1) yPos=1;				//Make sure that the monster wont move out the grid.
		if(xPos>=8) xPos=8;				//Make sure that the monster wont move out the grid.
		
		
	}
	
	public static boolean checkMove()     //tried to do by other ways but failed so i used this stupid function.
	{
		
		
		if	(xPos == 2 && yPos ==1 && dir==3)        //monster wont go down if the position is [2][1];
		{	
	
			return false;
		}
		
		if(xPos == 4 && yPos ==1 && dir==3)			 //monster wont go down if the position is [4][1];
		{
			
			return false;
		}
		
		if(xPos == 5 && yPos ==1 && dir==3)			 //monster wont go down if the position is [5][1];
		{
			
			return false;
		}
		
		if(xPos == 7 && yPos ==1 && dir==3)			 //monster wont go down if the position is [7][1];
		{
		
			return false;
		}
		
		
		if(xPos == 1 && yPos ==2 && dir==0)
		{	
			return false;
		}
		
		if(xPos == 3 && yPos ==2 && (dir==1 || dir==0))
		{	
			return false;
		}

		if(xPos == 6 && yPos ==2 && (dir==1 || dir==0))
		{
			return false;
		}

		if(xPos == 8 && yPos ==2 && (dir==1 || dir==0))
		{	
			return false;
		}
		
		if(xPos == 1 && yPos ==3 && (dir==1 || dir==0))
		{
			return false;
		}
		
		if(xPos == 3 && yPos ==3 && (dir==1 || dir==0))
		{
			return false;
		}
		
		if(xPos == 6 && yPos ==3 && (dir==1 || dir==0))
		{
			return false;
		}
		
		if(xPos == 8 && yPos ==3 && (dir==1 || dir==0))
		{
			return false;
		}
		
		if(xPos == 1 && yPos ==4 && (dir==1 || dir==0))
		{
			return false;
		}
		
		if(xPos == 3 && yPos ==4 && dir ==1)
		{	
			return false;
		}
		
		
		
		if(xPos == 4 && yPos ==4 && (dir==2 || dir==3))
		{
			return false;
		}
		
		if(xPos == 5 && yPos ==4 && (dir==2 || dir==3))
		{
			return false;
		}
		
		if(xPos == 6 && yPos ==4 && dir ==0)
		{
			return false;
		}
		
		if(xPos == 8 && yPos ==4 && (dir==1 || dir==0))
		{
			return false;
		}
		
		if(xPos == 2 && yPos ==5 && dir ==2)
		{
			return false;
		}
		
		if(xPos == 3 && yPos ==5 && dir ==0)
		{
			return false;
		}
		
		if(xPos == 6 && yPos ==5 && dir ==1)
		{
			return false;
		}
		
		if(xPos == 7 && yPos ==5 && dir ==2)
		{
			return false;
		}
		
					
		if(xPos == 2 && yPos ==6 && dir ==3)
		{
			return false;
		}
		
		if(xPos == 3 && yPos ==6 && dir ==3)
		{
			return false;
		}
		
		if(xPos == 4 && yPos ==6 && dir ==2)
		{
			return false;
		}
		
		if(xPos == 5 && yPos ==6 && dir ==2)
		{
			return false;
		}
		
		if(xPos == 6 && yPos ==6 && dir ==3)
		{
			return false;
		}
		
		if(xPos == 7 && yPos ==6 && dir ==3)
		{
			return false;
		}
		
		
		if(xPos == 1 && yPos ==7 && (dir==1 || dir==0))
		{
			return false;
		}
		
		
		if(xPos == 4 && yPos ==7 && dir ==1)
		{
			return false;
		}
		
		
		if(xPos == 5 && yPos ==7 && dir ==0)
		{
			return false;
		}
		
		
		if(xPos == 8 && yPos ==7 && (dir==1 || dir==0))
		{
			return false;
		}
		
		
		if(xPos == 2 && yPos ==8 && (dir==2 || dir==3))
		{
			return false;
		}
		
		
		if(xPos == 3 && yPos ==8 && (dir==2 || dir==3))
		{
			return false;
		}
		
		if(xPos == 6 && yPos ==8 && (dir==2 || dir==3))
		{
			return false;
		}
		
		if(xPos == 7 && yPos ==8 && (dir==2 || dir==3))
		{
			return false;
		}
		
		return true;
	}
	
	
	
}
