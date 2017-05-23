package application;


import java.util.Random;



public class Monster2 extends Cell 
{
	private static int xxPos = 3;  // start point of monster is 3-5;
	private static int yyPos = 5;
	
	
	static Random t = new Random();
	
	
	private static int right = 0;        //Random function will chose randomly from 0 to 3 ( 4 directions )
	private static int left = 1;
	private static int up =2;
	private static int down = 3;        
	private static int dir2 = -1;		
	
	
	private static int newYY;
	private static int newXX;
	
	
	public Monster2(int x , int y) 
	{
		this.id = "MONSTER2";
		
		
	}
	
	public static int getxxPos()     //get x position
	{
		return xxPos;
	}
	
	public static int getyyPos()     //get y position
	{
		return yyPos;
	}
	
	public static void setxxPos(int newx)    // change x position
	{
		xxPos = newx;
	}
	
	
	public static void setyyPos(int newy)    // change y position
	{
		yyPos = newy;
	}

	static void MonsterMove()
	{
		
		dir2 = t.nextInt(4);
		if(dir2 == right)
		{
			if(checkMove())
			{
				newXX = (Monster2.getxxPos()+1);   //turn right --> x changed (plus 1)
				Monster2.setxxPos(newXX);
			}
			else
			{
				
				System.out.println("Can not step on Block");
				dir2 = t.nextInt(4);
			}
		}
		
		
		if(dir2==left)
		{
			if(checkMove())
			{
				newXX = (Monster2.getxxPos()-1);   //turn left --> x changed (minus 1)
				Monster2.setxxPos(newXX);
			}
			else
			{
				System.out.println("Can not step on Block");
				dir2=t.nextInt(4);
			}
		}
		
			
		if(dir2==up)
		{
			if(checkMove())
			{
				newYY = (Monster2.getyyPos()-1);  //go up ---> y changed ( minus 1)
				Monster2.setyyPos(newYY);
			}
			else
			{
				System.out.println("Can not step on Block");
				dir2=t.nextInt(4);
			}
		}
		
		if(dir2==down)
		{
			if(checkMove())
			{
				newYY = (Monster2.getyyPos()+1);   //go down ---> y changed ( plus 1 )
				Monster2.setyyPos(newYY);
			}
			else
			{
				System.out.println("Can not step on Block");
				dir2=t.nextInt(4);
			}
		}
		
		if(xxPos<=1) xxPos=1;     		//Make sure that the monster wont move out the grid.
		if(yyPos>=8) yyPos=8;				//Make sure that the monster wont move out the grid.
		if(yyPos<=1) yyPos=1;				//Make sure that the monster wont move out the grid.
		if(xxPos>=8) xxPos=8;				//Make sure that the monster wont move out the grid.
		
		
	}
	
	public static boolean checkMove()     //tried to do by other ways but failed so i used this stupid function.
	{
		
		
		if	(xxPos == 2 && yyPos ==1 && dir2==3)        //monster wont go down if the position is [2][1];
		{	
	
			return false;
		}
		
		if(xxPos == 4 && yyPos ==1 && dir2==3)			 //monster wont go down if the position is [4][1];
		{
			
			return false;
		}
		
		if(xxPos == 5 && yyPos ==1 && dir2==3)			 //monster wont go down if the position is [5][1];
		{
			
			return false;
		}
		
		if(xxPos == 7 && yyPos ==1 && dir2==3)			 //monster wont go down if the position is [7][1];
		{
		
			return false;
		}
		
		
		if(xxPos == 1 && yyPos ==2 && dir2==0)
		{	
			return false;
		}
		
		if(xxPos == 3 && yyPos ==2 && (dir2==1 || dir2==0))
		{	
			return false;
		}

		if(xxPos == 6 && yyPos ==2 && (dir2==1 || dir2==0))
		{
			return false;
		}

		if(xxPos == 8 && yyPos ==2 && (dir2==1 || dir2==0))
		{	
			return false;
		}
		
		if(xxPos == 1 && yyPos ==3 && (dir2==1 || dir2==0))
		{
			return false;
		}
		
		if(xxPos == 3 && yyPos ==3 && (dir2==1 || dir2==0))
		{
			return false;
		}
		
		if(xxPos == 6 && yyPos ==3 && (dir2==1 || dir2==0))
		{
			return false;
		}
		
		if(xxPos == 8 && yyPos ==3 && (dir2==1 || dir2==0))
		{
			return false;
		}
		
		if(xxPos == 1 && yyPos ==4 && (dir2==1 || dir2==0))
		{
			return false;
		}
		
		if(xxPos == 3 && yyPos ==4 && dir2 ==1)
		{	
			return false;
		}
		
		
		
		if(xxPos == 4 && yyPos ==4 && (dir2==2 || dir2==3))
		{
			return false;
		}
		
		if(xxPos == 5 && yyPos ==4 && (dir2==2 || dir2==3))
		{
			return false;
		}
		
		if(xxPos == 6 && yyPos ==4 && dir2 ==0)
		{
			return false;
		}
		
		if(xxPos == 8 && yyPos ==4 && (dir2==1 || dir2==0))
		{
			return false;
		}
		
		if(xxPos == 2 && yyPos ==5 && dir2 ==2)
		{
			return false;
		}
		
		if(xxPos == 3 && yyPos ==5 && dir2 ==0)
		{
			return false;
		}
		
		if(xxPos == 6 && yyPos ==5 && dir2 ==1)
		{
			return false;
		}
		
		if(xxPos == 7 && yyPos ==5 && dir2 ==2)
		{
			return false;
		}
		
					
		if(xxPos == 2 && yyPos ==6 && dir2 ==3)
		{
			return false;
		}
		
		if(xxPos == 3 && yyPos ==6 && dir2 ==3)
		{
			return false;
		}
		
		if(xxPos == 4 && yyPos ==6 && dir2 ==2)
		{
			return false;
		}
		
		if(xxPos == 5 && yyPos ==6 && dir2 ==2)
		{
			return false;
		}
		
		if(xxPos == 6 && yyPos ==6 && dir2 ==3)
		{
			return false;
		}
		
		if(xxPos == 7 && yyPos ==6 && dir2 ==3)
		{
			return false;
		}
		
		
		if(xxPos == 1 && yyPos ==7 && (dir2==1 || dir2==0))
		{
			return false;
		}
		
		
		if(xxPos == 4 && yyPos ==7 && dir2 ==1)
		{
			return false;
		}
		
		
		if(xxPos == 5 && yyPos ==7 && dir2 ==0)
		{
			return false;
		}
		
		
		if(xxPos == 8 && yyPos ==7 && (dir2==1 || dir2==0))
		{
			return false;
		}
		
		
		if(xxPos == 2 && yyPos ==8 && (dir2==2 || dir2==3))
		{
			return false;
		}
		
		
		if(xxPos == 3 && yyPos ==8 && (dir2==2 || dir2==3))
		{
			return false;
		}
		
		if(xxPos == 6 && yyPos ==8 && (dir2==2 || dir2==3))
		{
			return false;
		}
		
		if(xxPos == 7 && yyPos ==8 && (dir2==2 || dir2==3))
		{
			return false;
		}
		
		return true;
	}
	
	
	
}
