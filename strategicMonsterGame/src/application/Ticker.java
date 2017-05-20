


package application;

/*
//This class functions in a similar principle to a chess timer that changes turns every 500
//milliseconds. When the timer ticks over, a command, such as a movement, is "queued"  to this method
//after the command is sent, and its corresponding function is then exected when 
public class Ticker
{
	


	//This boolean determines whether or not the ticker counts up. (i.e. only during gameplay.
	private static boolean ticking = false;
	public static boolean getTicking()
	{
		return ticking;
	}
	
	public static void setTickingTrue()
	{
		ticking = true;
	}
	
	long startTime = System.nanoTime();
	private long elapsedTime = 0;
	private long turnCounter;
	private int tickCount = 0;
	
	public int getTickCount()
	{
		return tickCount;
	}
	
	
	public long getElapsedTime()
	{
		return elapsedTime;
	}
	
	
	
	
	public void setTickCount()
	{
		
	}
	
	
	void addTime(){
		while (ticking == true)
		{
			turnCounter += elapsedTime;
		}
		
		if(turnCounter >= 500000000)
		{
			int tickCount = 0;
			System.out.println(tickCount + " tick");
			tickCount++;
			resetTurnCounter();
		}
	}
	
	


	public void countUp()
	{
		elapsedTime = System.nanoTime();
		//Nano time will begin ticking up as soon as this function is executed.
		resetTurnCounter();
	}
	
	
	public void resetTurnCounter()
	{
		turnCounter = 0;
	}
	
	
	
	
}
	


//Ununsed
/*
	long startTime = System.nanoTime();
	long elapsedTime = 0;
	long turnCounter;

	public void countUp()
	{
		elapsedTime = System.nanoTime();
		//Nano time will begin ticking up as soon as this function is executed.
		public void resetTurnCounter();
	}
	
	
	while (ticking == true)
	{
		turnCounter += elapsedTime;//
	}
	
	
	public void resetTurnCounter()
	{
		turnCounter = 0;
	}
	
}
	
}
*/

	
	/*
	
//The hero movement booleans.
	private static boolean heroMoveLeft;
	private static boolean heroMoveRight;
	private static boolean heroMoveUp;
	private static boolean heroMoveDown;
	
	public static boolean getheroMoveLeft()
	{
		return heroMoveLeft;
	}
	public static void setheroMoveLeft(boolean newState)
	{
		heroMoveLeft = newState;
	}
	
	public static boolean getheroMoveRight()
	{
		return heroMoveRight;
	}
	public static void setheroMoveRight(boolean newState)
	{
		heroMoveRight = newState;
	}
	
	public static boolean getheroMoveUp()
	{
		return heroMoveUp;
	}
	public static void setheroMoveUp(boolean newState)
	{
		heroMoveUp = newState;
	}
	
	public static boolean getheroMoveDown()
	{
		return heroMoveDown;
	}
	public static void setheroMoveDown(boolean newState)
	{
		heroMoveDown = newState;
	}
	
	
	
	
	
	
//These if statements ensure that only one direction change can be true.
	if (HeroMoveLeft == true)
	{
		heroMoveUp = false;
		heroMoveRight = false;
		heroMoveDown = false;
	}
	
	if (HeroMoveRight == true)
	{
		heroMoveUp = false;
		heroMoveLeft = false;
		heroMoveDown = false;
	}
	
	if (HeroMoveUp == true)
	{
		heroMoveDown = false;
		heroMoveLeft = false;
		heroMoveRight = false;
	}
	
	if (HeroMoveDown == true)
	{
		heroMoveUp = false;
		heroMoveLeft = false;
		heroMoveRight = false;
	}
	
	if (heroMoveUp && heroMoveDown && heroMoveLeft && heroMoveRight == false)
	{
		//Time continues ti king but thee player doesn't move at the next turn.
	}
	
}
}

}

}

*///