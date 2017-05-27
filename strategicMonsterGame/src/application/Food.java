package application;

public class Food extends Cell
{
	public static int xFood;
	public static int yFood;
	public static int timeFood;
	private static int foodDestX;
	private static int foodDestY;
	public static boolean spawner = false;

	public Food (int x, int y, int time)
	{
		this.id = "FOOD";
		xFood = x;
		yFood = y;
		timeFood = time;
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
	public static int getFoodTime()
	{
		return timeFood;
	}

	public static void setFoodSpawnX()
	{
		foodDestX = Hero.xPos;
	}

	public static void setFoodSpawnY()
	{
		foodDestY = Hero.yPos;
	}

	public static int getFoodSpawnX()
	{
		return foodDestX;
	}

	public static int getFoodSpawnY()
	{
		return foodDestY;
	}
}/////