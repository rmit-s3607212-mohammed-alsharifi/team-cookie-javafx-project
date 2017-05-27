package application;
//That's probably necessary for JavaFX

import java.util.ArrayList;
//I recall that arraylists are a kind of resizeable array.

import java.util.Random;

public class Cell{

	//A global representation of destX and destY for use in the hero method.
	int destX;
	int destY;

	Random r = new Random();   // create a random number which be set automatically by system
	
	int destX2;
	int destY2;
	int destX3;
	int destY3;
	
	int right = 0;
	int left = 1;
	int up =2;
	int down=3;
	int dir = -1;
	
	//A global reference to the cell class for use in later methods.
	Cell[][] globalCell;

	//boolean foodActiveLocal = Food.getFoodActive();

	private final int GRID_WIDTH = 10;
	private final int GRID_HEIGHT = 10;
	//A sample grid length. The default.

	//variables for monster
	String id;
	int xPosition;
	int yPosition;
	

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

		//New monster is created at 5,5. This is an example of many possible functions

		cell[Monster.getxPos()][Monster.getyPos()] = new Monster(Monster.getxPos() ,Monster.getyPos());
		cell[Monster2.getxxPos()][Monster2.getyyPos()] = new Monster2(Monster2.getxxPos() ,Monster2.getyyPos());
		cell[Hero.getxPos()][Hero.getyPos()] = new Hero(Hero.getxPos() ,Hero.getyPos()); //It was 6,6 orginally

		//A simple test for food.

		if (Food.spawner == true)
		{
			cell[Hero.xPos][Hero.yPos] = new Food(Hero.xPos,Hero.yPos, 21);
		}

		if(Food.timeFood <= 0)
		{
			Food.xFood = -1;
			Food.yFood = -1;
		}
		else
		{
			cell[Food.xFood][Food.yFood] = new Food(Food.xFood,Food.yFood, Food.timeFood);
		}

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
		Cell[][] cellGrid2 = new Cell[GRID_WIDTH][GRID_HEIGHT];
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
					System.out.print("*");
				}
				
				else if (cell[i][j].id.equals("MONSTER2")) // Just like my code.
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
				else if (cell[i][j].id.equals("FOOD"))
				{
					System.out.print("|");
					System.out.print("F");
				}
			}

			System.out.print("|");
			System.out.println(""); //Endcaps.
		}
	}

	public void heroMoveUp(Cell[][] cell) //Try passing the cell array as an argument! //Try not using an argument!
	{
		destY = (Hero.getyPos() - 1);


		//The reactions to the cell contents go here in each movement function. It is clunky and requires us to copy and paste, but it works.
		//The next step is to make the responses to the cell contents, i.e. if it's a block, no movement happens. If it's a monster, the kill player function happens, etc.
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




		//printGrid
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
		//printGrid
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
		destX = (Hero.getxPos() - 1);

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
		
		if(dir==left)                                   //If system let monster turn left
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