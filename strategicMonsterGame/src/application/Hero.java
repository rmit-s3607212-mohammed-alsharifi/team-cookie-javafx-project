package application;

public class Hero extends Cell 
{
	private static int xPos = 6;
	private static int yPos = 6;
	
	
	public Hero(int Xinput , int Yinput) //Hero is the return type here. This is a constructor I'm pretty sure.
	{
		this.id = "HERO";
		int xPos = Xinput;
		int yPos = Yinput;
	}
		//Encapsulation time!
		//Be mindful as I go: That strange hero method(?) 
		//above may just be representative of position.
	
	
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
	
	
	/*
	void moveUp()
	{
		
		int destY = yPos++;
		xPos = xPos;
		
		yPos = destY;
		
		
		
	}
	*/
	//test
}
