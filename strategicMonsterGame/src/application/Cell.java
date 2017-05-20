package application;
//That's probably necessary for JavaFX

import java.util.ArrayList;
import java.util.Random;
//I recall that arraylists are a kind of resizeable array.


public class Cell{
	

	int destX;
	int destY;
	
	Cell[][] globalCell;
	
	
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
	//public Cell[][] fillGrid(Cell[][] globalCell)
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
		cell[Monster.getxPos()][Monster.getyPos()] = new Monster(Monster.getxPos() ,Monster.getyPos());
		
		
		cell[Hero.getxPos()][Hero.getyPos()] = new Hero(Hero.getxPos() ,Hero.getyPos()); //It was 6,6 orginally
		
		//Should I "re-call" the constructor and pass the new yPos/xPos variables as a arguments and make it re-render/re-fill? Or do some alternative solution?
		
		//Test2
		
		//this.Cell[][] filledGrid = 
		
		//reutrn 
		
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
		//Cell[][] cell = new Cell[10][10];
		
		
		return cellGrid2;
		//return globalCell;
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
				else if (cell[i][j].id.equals("BLOCK"))
				{
					System.out.print("|");
					System.out.print("0");
				}
			}
		
			System.out.print("|");
			System.out.println(""); //Endcaps.
		}
	}
	
	
	//Cell[][] cellRef;
	
	public void heroMoveUp(Cell[][] cell) //Try passing the cell array as an argument! //Try not using an argument!
	{
		destY = (Hero.getyPos() - 1);
		//checkYdir(cellRef);
		
		//Insert checking functionality here rather than making separate functions? Because that doesn't work?
		
		//The reactions to the cell contents go here in each movement function. It is clunky and requires us to copy and paste, but it works.
		//The next step is to make the responses to the cell contents, i.e. if it's a block, no movement happens. If it's a monster, the kill player function happens, etc.
		if (cell[Hero.getxPos()][destY].id.equals("EMPTY"))
		{
			System.out.println("Empty cell registered! Movement possible!");
		}
		
		Hero.setypos(destY);
		//printGrid
	}
	
	void heroMoveDown(Cell[][] cell)
	{
		destY = (Hero.getyPos() + 1);
		
		if (cell[Hero.getxPos()][destY].id.equals("EMPTY"))
		{
			System.out.println("Empty cell registered! Movement possible!");
		}
			
			
		Hero.setypos(destY);
		//printGrid
	}
	
	void heroMoveLeft(Cell[][] cell)
	{
		destX = (Hero.getxPos() - 1);
		
		if (cell[destX][Hero.getyPos()].id.equals("EMPTY"))
		{
			System.out.println("Empty cell registered! Movement possible!");
		}
		
		Hero.setxpos(destX);
	}
	
	void heroMoveRight(Cell[][] cell)
	{
		destX = (Hero.getxPos() + 1);
		
		if (cell[destX][Hero.getyPos()].id.equals("EMPTY"))
		{
			System.out.println("Empty cell registered! Movement possible!");
		}
		
		Hero.setxpos(destX);
	}
	
	/*
	void checkYdir(Cell[][] cellRef)
	{
		if (cellRef[Hero.getxPos()][destY].id.equals("EMPTY"))
		{
			System.out.println("Empty cell registered! Movement possible!");
		}
	}
	*/
	
	void checkXdir()
	{
		
	}


	
	
	
	
	
	
}
//test