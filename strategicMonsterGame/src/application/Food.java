package application;

public class Food extends Cell
{
	private static int xFood;
	private static int yFood;
	private static int timeFood = 3;
	static boolean foodActive = true;
	
	
	public Food (int x, int y)
	{	
		this.id = "FOOD";
		xFood = x;
		yFood = y;	
		//timeFood = time;
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




	
	/*
	public void setEmpty()
	{
		this.id = "EMPTY";
	}
	*/
}