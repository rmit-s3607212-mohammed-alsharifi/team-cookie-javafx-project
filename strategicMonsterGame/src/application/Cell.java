package application;

import java.util.ArrayList;

public class Cell{

	private final int GRID_WIDTH = 10;
	private final int GRID_HEIGHT = 10;
	
	String id;
	int xPosition;
	int yPosition;
	
	
	//Empty empty;
	Monster monster;
	
	
	ArrayList<Empty> emptyArray = new ArrayList<Empty>();
	
	public Cell[][] fillGrid(Cell[][] cell)
	{
		for ( int j = 0; j < GRID_HEIGHT; j++)
		{
		
			for (int  i = 0 ; i < 10 ; i++)
			{
				cell[i][j] = new Empty( i , j);
				//System.out.println("Empty cell created at i ="  + i + "j: " +j);	
			}
			
		}
		cell[5][5] = new Monster(5 ,5);
		
		return cell;
	}
	
	
	
	
	
	
	public Cell[][] initGrid(){
		
/*	Cell[][] cellGrid = new Cell[][] { 
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
		};*/
	
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
			
				if ( cell[i][j].id.equals("EMPTY"))
				{
					System.out.print("|");
				System.out.print(" ");
				}
				else if (cell[i][j].id.equals("MONSTER"))
				{
					System.out.print("|");
					System.out.print("*");
				}
			}
		
			System.out.print("|");
			System.out.println("");
		}
	}
	
	
	
	
}
