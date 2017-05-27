package application;


import java.util.ArrayList;

import java.util.Random;

public class Cell{

	
	int destX;
	int destY;

	Random r = new Random();   //Josh: create a random number which be set automatically by system
	
	int destX2;
	int destY2;
	int destX3;
	int destY3;
	
	int right = 0;
	int left = 1;
	int up =2;
	int down=3;
	int dir = -1;
	
	//Angus: A global reference to the cell class for use in later methods.
	Cell[][] globalCell;

	//Redha: These finals set the grid width and height in stone.
	private final int GRID_WIDTH = 10;
	private final int GRID_HEIGHT = 10;

	//Danny: variables for monster
	String id;
	int xPosition;
	int yPosition;
	
	Monster monster;
	Empty empty;

	
	ArrayList<Empty> emptyArray = new ArrayList<Empty>();
	//emptyArray must be for later use.

	public Cell[][] fillGrid(Cell[][] cell)
	//Redha: This function fills the previously initialized grid with all of the predetermined wall, hero and monster locations.
	//Angus: This wall configuration was considered to give ample room for experimentation.
	{
		for ( int j = 0; j < GRID_HEIGHT; j++)
		{
			for (int  i = 0 ; i < GRID_WIDTH ; i++)
				//Iterate through the two.
			{
				cell[i][j] = new Empty( i , j);
				//System.out.println("Empty cell created at i ="  + i + "j: " +j);
			}

			for(int a =0; a<10; a++)
			{
				cell[a][0] = new Block();
			}

			for(int a =1; a<9; a++)
			{
				cell[a][9] = new Block();
			}

			for(int a =1; a<10; a++)
			{
				cell[0][a] = new Block();
			}

			for(int a =1; a<10; a++)
			{
				cell[9][a] = new Block();
			}

			for(int a =2; a<5; a++)
			{
				cell[2][a] = new Block();
			}

			for(int a =2; a<5; a++)
			{
				cell[7][a] = new Block();
			}

			for(int a =2; a<4; a++)
			{
				for(int b =4;b<6;b++)
				{
					cell[b][a]=new Block();
				}
			}

			for(int a =4; a<6; a++)
			{
				cell[a][5] = new Block();
			}

			for(int a =2; a<4; a++)
			{
				cell[a][7] = new Block();
			}

			for(int a =6; a<8; a++)
			{
				cell[a][7] = new Block();
			}





		}

		cell[Monster.getxPos()][Monster.getyPos()] = new Monster(Monster.getxPos() ,Monster.getyPos());
		cell[Monster2.getxxPos()][Monster2.getyyPos()] = new Monster2(Monster2.getxxPos() ,Monster2.getyyPos());
		cell[Hero.getxPos()][Hero.getyPos()] = new Hero(Hero.getxPos() ,Hero.getyPos()); //It was 6,6 orginally

		

		if (Food.spawner == true)
		{
			cell[Hero.xPos][Hero.yPos] = new Food(Hero.xPos,Hero.yPos, 21);
		}
		//sets the food spawn to hero location and food time to 20 time units after hero moves places it
		
		if(Food.timeFood <= 0)
		{
			Food.xFood = -1;
			Food.yFood = -1;
		}
		//despawns the food after its time reaches 0
		
		else
		{
			cell[Food.xFood][Food.yFood] = new Food(Food.xFood,Food.yFood, Food.timeFood);
		}
		//makes sure the food stays in the same location for each iteration of the grid
		
		
		return cell;
	}

	//Redha: This function creates a 2d array of the type Cell, and returns it for future use.
	public Cell[][] initGrid(){
		
		Cell[][] cellGrid2 = new Cell[GRID_WIDTH][GRID_HEIGHT];

		return cellGrid2;
	}



	//Redha and Angus: This function iterates through the aforementioned 2d array and renders them with ascii-style graphics. 
	public void printGrid(Cell[][] cell)
	{
		for ( int j = 0; j < GRID_HEIGHT; j++)
		{
			System.out.print("|");
			System.out.print(j);
			for (int  i = 0 ; i < GRID_WIDTH ; i++)
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
					System.out.print("&");
				}
				
				else if (cell[i][j].id.equals("MONSTER2")) // Just like my code.
				{
					System.out.print("|");
					System.out.print("$");
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
				else if (cell[i][j].id.equals("FOOD"))
				{
					System.out.print("|");
					System.out.print("F");
				}
			}

			System.out.print("|");
			System.out.println("");
		}
	}

	public void heroMoveUp(Cell[][] cell) //Angus: The other hero movement functions are identical in principle.
	{
		destY = (Hero.getyPos() - 1);
		//Angus: The y-axial destination is returned from the hero class.

		//Angus: The contents of the destination cell are checked, and the possible types, and their responses, are iterated with if statements.
		if (cell[Hero.getxPos()][destY].id.equals("EMPTY"))
		{
			System.out.println("Empty cell registered! Movement possible!");
			Hero.setyPos(destY);
		}
		if (cell[Hero.getxPos()][destY].id.equals("BLOCK"))
		{
			System.out.println("Block registered! No move for you!");
			Hero.setyPos(Hero.getyPos()); //Angus: The position stays the same.
		}
		if (cell[Hero.getxPos()][destY].id.equals("FOOD"))
		{
			System.out.println("Poisoned");
			Hero.poisonTime = 21;	//Josh: sets duration of player slow
			Food.xFood = 0;			//despawning of food
			Food.yFood = 0;			//^
			Food.timeFood = 0;		//^^
			Hero.setyPos(destY);
		}
	}

	void heroMoveDown(Cell[][] cell)
	{
		destY = (Hero.getyPos() + 1);

		if (cell[Hero.getxPos()][destY].id.equals("EMPTY"))
		{
			System.out.println("Empty cell registered! Movement possible!");
			Hero.setyPos(destY);
		}
		if (cell[Hero.getxPos()][destY].id.equals("BLOCK"))
		{
			System.out.println("Block registered! No move for you!");
			Hero.setyPos(Hero.getyPos());
		}
		if (cell[Hero.getxPos()][destY].id.equals("FOOD"))
		{
			System.out.println("Poisoned");
			Hero.poisonTime = 21;
			Food.xFood = 0; 		
			Food.yFood = 0;			
			Food.timeFood = 0;		
			Hero.setyPos(destY);
		}
	}

	
	void heroMoveLeft(Cell[][] cell)
	{
		destX = (Hero.getxPos() - 1); //Angus: The x position is returned from Hero, similarly to y-axial movement.

		if (cell[destX][Hero.getyPos()].id.equals("EMPTY"))
		{
			System.out.println("Empty cell registered! Movement possible!");
			Hero.setxPos(destX);
		}
		if (cell[destX][Hero.getyPos()].id.equals("BLOCK"))
		{
			System.out.println("Block registered! No move for you!");
			Hero.setxPos(Hero.getxPos());
		}
		if (cell[destX][Hero.getyPos()].id.equals("FOOD"))
		{
			System.out.println("Poisoned");
			Hero.poisonTime = 21;
			Food.xFood = 0;
			Food.yFood = 0;
			Food.timeFood = 0;
			Hero.setxPos(destX);
		}

	}

	void heroMoveRight(Cell[][] cell)
	{
		destX = (Hero.getxPos() + 1);

		if (cell[destX][Hero.getyPos()].id.equals("EMPTY"))
		{
			System.out.println("Empty cell registered! Movement possible!");
			Hero.setxPos(destX);
		}
		if (cell[destX][Hero.getyPos()].id.equals("BLOCK"))
		{
			System.out.println("Block registered! No move for you!");
			Hero.setxPos(Hero.getxPos());
		}
		if (cell[destX][Hero.getyPos()].id.equals("FOOD"))
		{
			System.out.println("Poisoned");
			Hero.poisonTime = 21;
			Food.xFood = 0;
			Food.yFood = 0;
			Food.timeFood = 0;
			Hero.setxPos(destX);
		}


	}

	void heroStill(Cell[][] cell)
	{
		Hero.setyPos(Hero.getyPos());
		Hero.setxPos(Hero.getxPos());
		//Angus: The hero stays stationary because of the above two lines.
	}

	
	
	//Movement of Monster 1 Start from here
	public void MonsterMove(Cell[][] cell)
	{
		dir=r.nextInt(4);                         	//System will chose randomly from 0 -> 3 
		if(dir==right)						    	//When system let monster 1 turn right
		{
			destX2 = (Monster.getxPos() + 1);
			if (cell[destX2][Monster.getyPos()].id.equals("HERO"))    //Check if next step is Hero(player)
			{
				System.out.println("Player has been eaten by monster 1");
				Monster.setxPos(destX2);
			}
			else if (cell[destX2][Monster.getyPos()].id.equals("EMPTY"))  // check if next step is Empty
			{
				System.out.println("Monster 1 Moved");
				Monster.setxPos(destX2);
			}
			else if (cell[destX2][Monster.getyPos()].id.equals("BLOCK"))    // Check if next step is Block
			{
				System.out.println("Monster 1 can not step on block");
				Monster.setxPos(Monster.getxPos());
			}
			
			else if (cell[destX2][Monster.getyPos()].id.equals("FOOD"))    // Check if next step is Food
			{
				System.out.println("Monster 1 Poisoned");	
			}
		}
		
		if(dir==left) //If system let monster turn left
		{
			destX2 = (Monster.getxPos() - 1);
			
			if (cell[destX2][Monster.getyPos()].id.equals("HERO"))   //Check if next step is Hero
			{
				System.out.println("Player has been eaten by monster 1");
				Monster.setxPos(destX2);
				
				
			}
			else if (cell[destX2][Monster.getyPos()].id.equals("EMPTY"))   //check if next step is Empty
			{
				System.out.println("Monster 1 Moved");
				Monster.setxPos(destX2);
			}
			else if (cell[destX2][Monster.getyPos()].id.equals("BLOCK"))   //Check if next step is Block
			{
				System.out.println("Monster 1 can not step on block");
				Monster.setxPos(Monster.getxPos());
			}
			else if (cell[destX2][Monster.getyPos()].id.equals("FOOD"))    //Check if next Step is Food
			{
				System.out.println("Monster 1 Poisoned");
			}
			
			
		}
		
		if(dir==up)                               //If system let monster go up
		{
			destY2 = (Monster.getyPos() - 1);
			
			if (cell[Monster.getxPos()][destY2].id.equals("HERO"))    //check if next step is Player
			{
				System.out.println("Player has been eaten by monster 1");
				Monster.setyPos(destY2);
				
				
			}
			else if (cell[Monster.getxPos()][destY2].id.equals("EMPTY"))   //check if next step is Empty
			{
				System.out.println("Monster 1 Moved");
				Monster.setyPos(destY2);
			}
			else if (cell[Monster.getxPos()][destY2].id.equals("BLOCK"))  // check if next step is Block
			{
				System.out.println("Monster 1 can not step on block");
				Monster.setyPos(Monster.getyPos());
			}
			else if (cell[Monster.getxPos()][destY2].id.equals("FOOD"))   //check if next step is Food
			{
				System.out.println("Monster 1 Poisoned");
			}
			
			
		}
		
		if(dir==down)										//if system let monster go down
		{
			destY2 = (Monster.getyPos() + 1);
			
			if (cell[Monster.getxPos()][destY2].id.equals("HERO"))     //check if next step is player
			{
				System.out.println("Player has been eaten by monster 1");
				Monster.setyPos(destY2);
				
				
			}
			else if (cell[Monster.getxPos()][destY2].id.equals("EMPTY")) //check if next step is Empty
			{
				System.out.println("Monster 1 Moved");
				Monster.setyPos(destY2);
			}
			else if (cell[Monster.getxPos()][destY2].id.equals("BLOCK"))  //check if next step is Block
			{
				System.out.println("Monster 1 can not step on block");
				Monster.setyPos(Monster.getyPos()); 
			}
			else if (cell[Monster.getxPos()][destY2].id.equals("FOOD"))    //check if next step is food
			{
				System.out.println("Monster 1 Poisoned");		
			}
			
		}
	}
	
	//Movement of Monster 2 Start from here     The Structure is same as Monster 1
	
		public void MonsterMove2(Cell[][] cell)
		{
			dir=r.nextInt(4);
			if(dir==right)
			{
				destX3 = (Monster.getxxPos() + 1);
				
				if (cell[destX3][Monster.getyyPos()].id.equals("HERO"))
				{
					System.out.println("Player has been eaten by monster 2");
					Monster.setxxPos(destX3);
					
					
				}
				else if (cell[destX3][Monster.getyyPos()].id.equals("EMPTY"))
				{
					System.out.println("Monster 2 moved");
					Monster.setxxPos(destX3);
				}
				else if (cell[destX3][Monster.getyyPos()].id.equals("BLOCK"))
				{
					System.out.println("Monster 2 can not step on block");
					Monster.setxxPos(Monster.getxxPos());
				}
				else if (cell[destX3][Monster.getyyPos()].id.equals("FOOD"))
				{
					System.out.println("Monster 2 Poisoned");
					
				}
				
			}
			
			if(dir==left)
			{
				destX3 = (Monster.getxxPos() - 1);
				
				if (cell[destX3][Monster.getyyPos()].id.equals("HERO"))
				{
					System.out.println("Player has been eaten by monster 2");
					Monster.setxxPos(destX3);
					
					
				}
				else if (cell[destX3][Monster.getyyPos()].id.equals("EMPTY"))
				{
					System.out.println("Monster 2 moved");
					Monster.setxxPos(destX3);
				}
				else if (cell[destX3][Monster.getyyPos()].id.equals("BLOCK"))
				{
					System.out.println("Monster 2 can not step on block");
					Monster.setxxPos(Monster.getxxPos());
				}
				else if (cell[destX3][Monster.getyyPos()].id.equals("FOOD"))
				{
					System.out.println("Monster 2 Poisoned");
				}
				
			}
			
			if(dir==up)
			{
				destY3 = (Monster.getyyPos() - 1);
				
				if (cell[Monster.getxxPos()][destY3].id.equals("HERO"))
				{
					System.out.println("Player has been eaten by monster 2");
					Monster.setyyPos(destY3);
					
					
				}
				else if (cell[Monster.getxxPos()][destY3].id.equals("EMPTY"))
				{
					System.out.println("Monster 2 moved");
					Monster.setyyPos(destY3);
				}
				else if (cell[Monster.getxxPos()][destY3].id.equals("BLOCK"))
				{
					System.out.println("Monster 2 can not step on block");
					Monster.setyyPos(Monster.getyyPos());
				}
				else if (cell[Monster.getxxPos()][destY3].id.equals("FOOD"))
				{
					System.out.println("Monster 2 Poisoned");
				}
				
			}
			
			if(dir==down)
			{
				destY3 = (Monster.getyyPos() + 1);
				
				if (cell[Monster.getxxPos()][destY3].id.equals("HERO"))
				{
					System.out.println("Player has been eaten by monster 2");
					Monster.setyyPos(destY3);
					
					
				}
				else if (cell[Monster.getxxPos()][destY3].id.equals("EMPTY"))
				{
					System.out.println("Monster 2 moved");
					Monster.setyyPos(destY3);
				}
				else if (cell[Monster.getxxPos()][destY3].id.equals("BLOCK"))
				{
					System.out.println("Monster 2 can not step on block");
					Monster.setyyPos(Monster.getyyPos());
				}
				else if (cell[Monster.getxxPos()][destY3].id.equals("FOOD"))
				{
					System.out.println("Monster 2 Poisoned");
				}
				
				
			}
		}
	
}