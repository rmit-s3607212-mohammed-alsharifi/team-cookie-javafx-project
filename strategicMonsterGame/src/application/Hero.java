package application;

public class Hero extends Cell 
{
	private static int xPos = 1;
	private static int yPos = 1;
	
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
	
	public static void setxpos(int newx)
	{
		xPos = newx;
	}
	
	public static void setypos(int newy)
	{
		yPos = newy;
	}
	
}
/////