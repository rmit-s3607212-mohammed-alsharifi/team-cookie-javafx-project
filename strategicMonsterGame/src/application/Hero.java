package application;

public class Hero extends Cell 
{
	public static int xPos = 1; //private
	public static int yPos = 1;  //private
	private static boolean heroSlowed = false; 
	
	public Hero(int Xinput , int Yinput)
	{
		this.id = "HERO";
		int xPos = Xinput;
		int yPos = Yinput;
	}
	
	//Encapsulation methods that ensure compatibility and workability.
	public static int getxPos()
	{
		return xPos;
	}
	
	public static int getyPos()
	{
		return yPos;
	}
	
	public static void setxPos(int newx)
	{
		xPos = newx;
	}
	
	public static void setyPos(int newy)
	{
		yPos = newy;
	}
	
	public boolean getHeroSlowed()
	{
		return heroSlowed;
	}
	
	public void setHeroSlowed(boolean newValue)
	{
		heroSlowed = newValue;
	}
	
	
	
}
/////