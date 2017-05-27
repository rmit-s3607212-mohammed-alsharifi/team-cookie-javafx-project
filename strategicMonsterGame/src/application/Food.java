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
	//allows placement in grid and sets the despawn time

	
	//setting food spawn location to hero location
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
}