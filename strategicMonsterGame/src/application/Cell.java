package application;
//That's probably necessary for JavaFX

import java.util.ArrayList;
//I recall that arraylists are a kind of resizeable array.


public class Cell{

	private final int GRID_WIDTH = 10;
	private final int GRID_HEIGHT = 10;
	//A sample grid length. The default.
	
	//What Id is for, idk.
	String id; //This is what id was. A string!
	int xPosition;
	int yPosition;
	//Who is using these values? The player? Maybe its intended for all.
	
	//Empty empty;
	Monster monster;
	Empty empty;
	//Monster must be defined here.
	
	
	ArrayList<Empty> emptyArray = new ArrayList<Empty>();
	//emptyArray must be for later use.
	
	public Cell[][] fillGrid(Cell[][] cell)
	//fillGrid function.
	{
		for ( int j = 0; j < GRID_HEIGHT; j++)
		{
			for (int  i = 0 ; i < 10 ; i++)
				//Iterate through the two.
			{
				cell[i][j] = new Empty( i , j);
				//System.out.println("Empty cell created at i ="  + i + "j: " +j);	
			}
		}
		cell[5][5] = new Monster(5 ,5);
		//New monster is created at 5,5. This is an example of many possible functions.
		
		cell[Hero.getxPos()][Hero.getyPos()] = new Hero(Hero.getxPos() ,Hero.getyPos()); //It was 6,6 orginally
		
		//Should I "re-call" the constructor and pass the new yPos/xPos variables as a arguments and make it re-render/re-fill? Or do some alternative solution?
		
		//Test
		
		return cell;
	}
	
	
	
	
	
	
	public Cell[][] initGrid(){
		//Instantiate a new 2d array for the world to share.
		/*
	Cell[][] cellGrid = new Cell[][] { 
		{empty, empty , empty, empty , empty, empty , empty, empty , empty, empty},
		{empty, empty , empty, empty , empty, empty , empty, empty , empty, empty},
		{empty, empty , empty, empty , empty, empty , empty, empty , empty, empty},
		{empty, empty , empty, empty , empty, empty , empty, empty , empty, empty},
		{empty, empty , empty, empty , empty, empty , empty, empty , empty, empty},
		{empty, empty , empty, empty , empty, empty , empty, empty , empty, empty},
		{empty, empty , empty, empty , empty, empty , empty, empty , empty, empty},
		{empty, empty , empty, empty , empty, empty , empty, empty , empty, empty},
		{empty, empty , empty, empty , empty, empty , empty, empty , empty, empty},
		{empty, empty , empty, empty , empty, empty , empty, empty , empty, empty},
		};
	*/
		Cell[][] cellGrid2 = new Cell[10][10];
		
		
		
		return cellGrid2;
	}
	
	
	
	
	public void printGrid(Cell[][] cell)
	{
		for ( int j = 0; j < GRID_HEIGHT; j++)
		{
			System.out.print("|");
			System.out.print(j);
			for (int  i = 0 ; i < 10 ; i++)
			{
			//Iterate and print out the row.
				
				if ( cell[i][j].id.equals("EMPTY"))
				{
					System.out.print("|"); // "| " represents empty.
					System.out.print(" ");
				}
				else if (cell[i][j].id.equals("MONSTER")) // Just like my code.
				{
					System.out.print("|");
					System.out.print("*");
				}
				else if (cell[i][j].id.equals("HERO"))
				{
					System.out.print("|");
					System.out.print("H");
				}
			}
		
			System.out.print("|");
			System.out.println(""); //Endcaps.
		}
	}
	
	void heroMoveUp()
	{
		int destY = (Hero.getyPos() + 1);

		Hero.setypos(destY);
		//printGrid
	}
	
	
}
