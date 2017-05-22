package application;

public class Food extends Cell
{
	private static int xFood;
	private static int yFood;
	private static int timeFood = 20;
	static boolean foodActive = true;
	private static int foodDestX;
	private static int foodDestY;
	
	public Food (int x, int y)
	{	
		this.id = "FOOD";
		xFood = x;
		yFood = y;	
		int foodDestX;
		int foodDestY;
	}
	
	
	
	public static int getxFood()
	{
		return xFood;
	}
	
	public static int getyFood()
	{
		return yFood;
	}
	
	//This code runs and has been documented to work with the timeAdvance function.
	public static int foodMinus()
	{
		timeFood--;
		return timeFood;
		//foodDestroyCheck();
	}
	
	//public 
	
	//encapsulated foodTime
	public static int getFoodTime()
	{
		return timeFood;
	}
	
	//Part of a trial of destroying food which has failed to work. Delete or comment this out if it doesn't work.
	public void foodDestroy()
	{
		if (timeFood <= 0)
		{
			foodActive = false;
		}
	}
	
	
	public static boolean getFoodActive()
	{
		return foodActive;
	}


	public static void setFoodSpawnX()
	{
		foodDestX = Hero.xPos;
		//return foodDestX;
	}
	
	public static void setFoodSpawnY()
	{
		foodDestY = Hero.yPos;
		//return foodDestY;
	}
	
	public static int getFoodSpawnX()
	{
		return foodDestX;
	}
	
	public static int getFoodSpawnY()
	{
		return foodDestY;
	}
	
	/*
	public void setEmpty()
	{
		this.id = "EMPTY";
	}
	*/
}/////