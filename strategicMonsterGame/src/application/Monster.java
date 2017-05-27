package application;

public class Monster extends Cell       //Vinh: This class has all function of setting position for Monsters
{
	private static int xPos=3; 			 //Vinh: start point of monster is 3-3;
	private static int yPos=3;
	
	private static int xxPos=3;  			//Vinh: start point of monster is 3-5;
	private static int yyPos=5;
	
	public static int monsterPoisonTime;         //Poisontime of M1
	public static int monsterPoisonTime2;		//Poisontime of M2
	
	public static boolean MonsterSlowed;
	
	
	public Monster(int Xinput , int Yinput) //Vinh: I tried something like Monster monster 1 = new Monster() but failed
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
	
	public static void setxPos(int newx)    // change x position
	{
		xPos = newx;
	}
	
	
	public static void setyPos(int newy)    // change y position
	{
		yPos = newy;
	}
	
	
	
	
	
	
	public static int getxxPos()     //get xx position
	{
		return xxPos;
	}
	
	public static int getyyPos()     //get yy position
	{
		return yyPos;
	}
	
	public static void setxxPos(int newx)    // change xx position
	{
		xxPos = newx;
	}
	
	
	public static void setyyPos(int newy)    // change yy position
	{
		yyPos = newy;
	}
	
	
	
}
