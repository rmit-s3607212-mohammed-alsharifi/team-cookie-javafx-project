package application;

public class Hero extends Cell
{
	public static int xPos = 1;
	public static int yPos = 1; 
	public static int poisonTime;
	
	//Redha: This constructer method is used in Cell for the initial position.
	public Hero(int Xinput , int Yinput)
	{
		this.id = "HERO";
		int xPos = Xinput;
		int yPos = Yinput;
	}
	
	//Angus: These encapsulation methods ensure compatibility and workability.
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
}
/////