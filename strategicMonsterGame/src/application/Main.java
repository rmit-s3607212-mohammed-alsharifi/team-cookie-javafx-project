package application;

import java.util.Scanner;


	public class Main
	{
		static int timeCount = 0;

		public static int getTimeCount()
		{
			return timeCount;
		}

	static User user = new User();
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args)
	{

	int choice;
		do
		{
			System.out.println("------------------------------");
			System.out.println("Single Player Strategic Game");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Login as Admin");
			System.out.println("4. Play Game");
			System.out.println("5. print accounts");
			System.out.println("6. exit");
			System.out.println("------------------------------");

			choice = Integer.parseInt(reader.nextLine());

        switch (choice) {
            case 1:  registerUser();
                     break;
            case 2:  if (userLogin())
            			{
            					loadGameMenu();
            			}
                     else
                     	{
                    	 continue;
                     	}
                     break;
            case 3:  adminLogin();
            		 break;
            case 4:  //System.out.println("Game Started :)");
            		runGame();
                     break;
            case 5:  System.out.println("Good Bye!");
            		 user.printUsers();
            	     break;
            case 6:  System.out.println("Good Bye!");
					 break;
            default: System.out.println("-----------)");
            		 break;

        }


		}while(choice !=6 || userLogin());

	}


private static void registerUser()
	{

	// Initialize variables
	boolean check = true;

	String username;
	String password;
	String verifyPassword;



		while (check)
		{
		System.out.println("Enter username:");
		username = reader.nextLine();

		// check user has input correct character amount.
		if (username.length() < 5 || username.length() > 10)
			{
			System.out.println("The username must be between 5 and 10 charachters long");
			continue;
			}

		// prompt user for password input
			System.out.println("Enter Password");
			password = reader.nextLine();

		// check user has input correct character amount.
		if (password.length() < 5 || username.length() > 10)
			{
			System.out.println("The password must be between 5 and 10 charachters long");
			continue;
			}

		// prompt user to re-enter password
			System.out.println("Re-enter Password");
			verifyPassword = reader.nextLine();

		// check user has input correct character amount.
		if (!verifyPassword.equals(password))
			{
			System.out.println("password does not match");
			continue;
			}
		// check username is not already in user
		if(user.authenticateUser(username))
			{
			// add new account to HashMap users
			user.users.put(username, password);

			System.out.println("account created successfully, your username: "  + username + " password: "  + user.users.get(username));
		// save to file storedAccounts.csv
			user.saveUsers(username);
			check = false;
			}
		else
			{
			System.out.println("username already exists ,  please enter different username");
			}
		}
	}


private static boolean userLogin()
	{

		String username;
		String password;
		int choice;
		Scanner readerTwo = new Scanner(System.in);


		// create 1 function for userLogin
		// create 1 function for admin login

		System.out.println("Login");
		System.out.println("Enter username: ");
		username = readerTwo.nextLine();

		System.out.println("password: ");
		password = readerTwo.nextLine();

		// call userLogin class
		if(user.accountLogin(username, password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}



	private static boolean adminLogin()
	{

		String username;
		String password;
		int choice;
		Scanner readerTwo = new Scanner(System.in);


	// create 1 function for userLogin
		// create 1 function for admin login

		System.out.println("Login");
		System.out.println("Enter username: ");
		username = readerTwo.nextLine();

		System.out.println("password: ");
		password = readerTwo.nextLine();

		// call adminLogin class
		if (user.adminLogin(username, password))
		{
			System.out.println("Login Successful");
			return true;
		}
		else
		{
			System.out.println("Login failed");
			return false;
		}

	}


	public static void loadGameMenu()
	{
		// declare Variables
		int choice;

		System.out.println("------------------------------");
		System.out.println("Single Player Strategic Game");
		System.out.println("1. Play Game");
		System.out.println("2. View Scores");
		System.out.println("3. Game controls");
		System.out.println("4. Quit");
		System.out.println("------------------------------");

		choice = Integer.parseInt(reader.nextLine());

        switch (choice)
        {
            case 1:  runGame();
                     break;
            case 2:  System.out.println("View Results");
            	     break;
            case 3:  System.out.println("Press one 1 for up, 2 for left, 3 for right, 4 for down! 5 to stay stationary!, 6 to place food, 7 to exit!");
            		 break;
            default: break;
        }
	}

	public static void runGame()
	{
		//Angus: A reference to the cell class.
		Cell cellRunGame = new Cell();

		//Angus: integer used for operating the menu.
		int dirChoice;

		//Angus: A reference to the initilized grid from Cell is created here.
		Cell[][] playArea = cellRunGame.fillGrid(cellRunGame.initGrid());
		
		//Mohammed: The grid is printed to the console with every movement.
		cellRunGame.printGrid(cellRunGame.fillGrid(cellRunGame.initGrid()));

		//Angus: These instructions are printed to the user every turn.
		System.out.println("Press one 1 for up, 2 for left, 3 for right, 4 for down! 5 to stay stationary!, 6 to place food, 7 to exit!");

		//Temporary method of obtaining the direction choice.
		dirChoice = Integer.parseInt(reader.nextLine());


		
		
		
		
		
		
		
		
		//===============================================//
		//ANGUD+JOSH:  CASE 1 -- ONLY PLAYER POISONED //
			if((Hero.poisonTime > 0) && (Monster.monsterPoisonTime == 0) && (Monster.monsterPoisonTime2 == 0))	//Josh: if poison has been stood on
			{
				if(Hero.poisonTime%2 == 1)	//Josh: when poison time is an odd number, Hero won't move
				{
					Food.spawner = false;
					cellRunGame.heroStill(playArea);
					System.out.println("PLAYER IS POISONED, CAN NOT MOVE THIS TURN");
					cellRunGame.MonsterMove(playArea);
					cellRunGame.MonsterMove2(playArea);
					timeAdvance();
					runGame();
				} 
		
				else 
				{
					switch(dirChoice) 
					{
						case 1:
							//Angus: Each case will trigger a Hero movement command. The other directions are identical in principle.
							
							Food.spawner = false;
							
							//Runs the "heroMoveUp method within the cell class.
							cellRunGame.heroMoveUp(playArea);
							
							//Vinh: The movement functions of each monster are executed.
							cellRunGame.MonsterMove(playArea);
							cellRunGame.MonsterMove2(playArea);
					
							//Angus: timeAdvance is a function that increments the time count by 1, and will later run other methods such as food degredation and monster movement.
							timeAdvance();

							//Angus: Runs the runGame function again (which this command is currently inside), continuing the game until the player dies, wins or quits.
							runGame();

							break;

						case 2:
							Food.spawner = false;              //Vinh: From Case 2, all character move normally
							cellRunGame.heroMoveLeft(playArea);
							cellRunGame.MonsterMove(playArea);
							cellRunGame.MonsterMove2(playArea);
							timeAdvance();
							runGame();
							break;
						case 3:
							Food.spawner = false;
							cellRunGame.heroMoveRight(playArea);
							cellRunGame.MonsterMove(playArea);
							cellRunGame.MonsterMove2(playArea);
							timeAdvance();
							runGame();
							break;
						case 4:
							Food.spawner = false;
							cellRunGame.heroMoveDown(playArea);
							cellRunGame.MonsterMove(playArea);
							cellRunGame.MonsterMove2(playArea);
							timeAdvance();
							runGame();
							break;
						case 5 :
							Food.spawner = false;
							cellRunGame.heroStill(playArea);
							cellRunGame.MonsterMove(playArea);
							cellRunGame.MonsterMove2(playArea);
							timeAdvance();
							runGame();
							break;
						case 6 :
							cellRunGame.heroStill(playArea);
							cellRunGame.MonsterMove(playArea);
							cellRunGame.MonsterMove2(playArea);
							Food.spawner = true;
							timeAdvance();
							runGame();
							break;



						case 7 :
							//Quit the game.
							loadGameMenu();
						default : break;
					}
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			//====================================================//
			//Vinh+JOSH:  CASE 2 - ONLY MONSTER 1 POISONED //
			if((Hero.poisonTime == 0) && (Monster.monsterPoisonTime > 0) && (Monster.monsterPoisonTime2 == 0))	
			{
				
				switch(dirChoice) 
					{
						case 1:
							
							if(Monster.monsterPoisonTime%2 == 1)              //Vinh: If time = odd number, Player and Monster 2 can move but Monster 1 have to stop
							{
								Food.spawner = false;
								cellRunGame.heroMoveUp(playArea);
								System.out.println("MONSTER IS POISONED, CAN NOT MOVE THIS TURN");
								cellRunGame.MonsterMove2(playArea);
								
								timeAdvance();
								runGame();
								break;
							}
							else											//Vinh: If time = even number, Player and both monsters can move
							{
								Food.spawner = false;
								cellRunGame.heroMoveUp(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();
								break;
							}

						case 2:												//Vinh: From case 2, all is similar to case 1
							if(Monster.monsterPoisonTime%2 == 1)
							{
								Food.spawner = false;
								cellRunGame.heroMoveLeft(playArea);
								System.out.println("MONSTER IS POISONED, CAN NOT MOVE THIS TURN");
								cellRunGame.MonsterMove2(playArea);
								
								timeAdvance();
								runGame();
								break;
							}
							else
							{
								Food.spawner = false;
								cellRunGame.heroMoveLeft(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();
								break;
							}
						case 3:
							
							if(Monster.monsterPoisonTime%2 == 1)
							{
								Food.spawner = false;
								cellRunGame.heroMoveRight(playArea);
								System.out.println("MONSTER IS POISONED, CAN NOT MOVE THIS TURN");
								cellRunGame.MonsterMove2(playArea);
						
								timeAdvance();
								runGame();
								break;
							}
							else
							{
								Food.spawner = false;
								cellRunGame.heroMoveRight(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();
								break;
							}
						case 4:
							
							if(Monster.monsterPoisonTime%2 == 1)
							{
								Food.spawner = false;
								cellRunGame.heroMoveDown(playArea);
								System.out.println("MONSTER IS POISONED, CAN NOT MOVE THIS TURN");
								cellRunGame.MonsterMove2(playArea);
								
								timeAdvance();
								runGame();
								break;
							}
							else
							{
								Food.spawner = false;
								cellRunGame.heroMoveDown(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();
								break;
							}
						case 5 :
							
							if(Monster.monsterPoisonTime%2 == 1)
							{
								Food.spawner = false;
								cellRunGame.heroStill(playArea);
								System.out.println("MONSTER IS POISONED, CAN NOT MOVE THIS TURN");
								cellRunGame.MonsterMove2(playArea);
								
								timeAdvance();
								runGame();

								break;
							}
							else
							{
								Food.spawner = false;
								cellRunGame.heroStill(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();

								break;
							}
						case 6 :
							if(Monster.monsterPoisonTime%2 == 1)
							{
								Food.spawner = true;
								cellRunGame.heroStill(playArea);
								System.out.println("MONSTER IS POISONED, CAN NOT MOVE THIS TURN");
								cellRunGame.MonsterMove2(playArea);
								
								timeAdvance();
								runGame();

								break;
							}
							else
							{
								Food.spawner = true;
								cellRunGame.heroStill(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();

								break;
							}
						case 7 :
							loadGameMenu();
						default : break;
					}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			//==========================================//
			//VINH+JOSH: CASE 3 -- ONLY MONSTER 2 POISONED   --- Structure is same as Case 2, just only changed between M1 and M2//
			if((Hero.poisonTime == 0) && (Monster.monsterPoisonTime == 0) && (Monster.monsterPoisonTime2 > 0))	
			{
				
				
				
					switch(dirChoice) 
					{
						case 1:
							
							if(Monster.monsterPoisonTime2%2 == 1)
							{
								Food.spawner = false;
								cellRunGame.heroMoveUp(playArea);
								cellRunGame.MonsterMove(playArea);
								System.out.println("MONSTER2 IS POISONED, CAN NOT MOVE THIS TURN");
								timeAdvance();
								runGame();
								break;
							}
							else
							{
								Food.spawner = false;
								cellRunGame.heroMoveUp(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();
								break;
							}

						case 2:
							if(Monster.monsterPoisonTime2%2 == 1)
							{
								Food.spawner = false;
								cellRunGame.heroMoveLeft(playArea);
								cellRunGame.MonsterMove(playArea);
								System.out.println("MONSTER2 IS POISONED, CAN NOT MOVE THIS TURN");
								timeAdvance();
								runGame();
								break;
							}
							else
							{
								Food.spawner = false;
								cellRunGame.heroMoveLeft(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();
								break;
							}
						case 3:
							
							if(Monster.monsterPoisonTime2%2 == 1)
							{
								Food.spawner = false;
								cellRunGame.heroMoveRight(playArea);
								cellRunGame.MonsterMove(playArea);
								System.out.println("MONSTER2 IS POISONED, CAN NOT MOVE THIS TURN");
								timeAdvance();
								runGame();

								break;
							}
							else
							{
								Food.spawner = false;
								cellRunGame.heroMoveRight(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();

								break;
							}
						case 4:
							
							if(Monster.monsterPoisonTime2%2 == 1)
							{
								Food.spawner = false;
								cellRunGame.heroMoveDown(playArea);
								cellRunGame.MonsterMove(playArea);
								System.out.println("MONSTER2 IS POISONED, CAN NOT MOVE THIS TURN");
								timeAdvance();
								runGame();

								break;
							}
							else
							{
								Food.spawner = false;
								cellRunGame.heroMoveDown(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();

								break;
							}
						case 5 :
							
							if(Monster.monsterPoisonTime2%2 == 1)
							{
								Food.spawner = false;
								cellRunGame.heroStill(playArea);
								cellRunGame.MonsterMove(playArea);
								System.out.println("MONSTER2 IS POISONED, CAN NOT MOVE THIS TURN");
								timeAdvance();
								runGame();

								break;
							}
							else
							{
								Food.spawner = false;
								cellRunGame.heroStill(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();

								break;
							}
						case 6 :
							if(Monster.monsterPoisonTime2%2 == 1)
							{
								Food.spawner = true;
								cellRunGame.heroStill(playArea);
								cellRunGame.MonsterMove(playArea);
								System.out.println("MONSTER2 IS POISONED, CAN NOT MOVE THIS TURN");
								timeAdvance();
								runGame();

								break;
							}
							else
							{
								Food.spawner = true;
								cellRunGame.heroStill(playArea);
								cellRunGame.MonsterMove(playArea);
								cellRunGame.MonsterMove2(playArea);
								timeAdvance();
								runGame();

								break;
							}
						case 7 :
							loadGameMenu();
						default : break;
					}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			else                     //JOSH: No one step on Food
			{
				switch(dirChoice)
				{
					case 1:
						Food.spawner = false;
						cellRunGame.heroMoveUp(playArea);
						cellRunGame.MonsterMove(playArea);
						cellRunGame.MonsterMove2(playArea);
						timeAdvance();
						runGame();
						break;
					case 2:
						Food.spawner = false;
						cellRunGame.heroMoveLeft(playArea);
						cellRunGame.MonsterMove(playArea);
						cellRunGame.MonsterMove2(playArea);
						timeAdvance();
						runGame();
						break;
					case 3:
						Food.spawner = false;
						cellRunGame.heroMoveRight(playArea);
						cellRunGame.MonsterMove(playArea);
						cellRunGame.MonsterMove2(playArea);
						timeAdvance();
						runGame();
						break;
					case 4:
						Food.spawner = false;
						cellRunGame.heroMoveDown(playArea);
						cellRunGame.MonsterMove(playArea);
						cellRunGame.MonsterMove2(playArea);
						timeAdvance();
						runGame();
						break;
					case 5 :
						Food.spawner = false;
						cellRunGame.heroStill(playArea);
						cellRunGame.MonsterMove(playArea);
						cellRunGame.MonsterMove2(playArea);
						timeAdvance();
						runGame();
						break;
					case 6 :
						cellRunGame.heroStill(playArea);
						cellRunGame.MonsterMove(playArea);
						cellRunGame.MonsterMove2(playArea);
						Food.spawner = true;
						timeAdvance();
						runGame();
						break;
					case 7 : 
						loadGameMenu();
					default : break;
				}
			}
		
		}


	//Angus: This function increments 
	public static void timeAdvance()
	{
		//Angus: The time/turn counter goes up.
		timeCount++;
		
		//Josh: The time remaining for the food's appearance reduces.
		Food.timeFood--;

		//Turn count is displayed to the player.
		System.out.println("The turn number is:" + timeCount);

		//Angus: It is printed to the player with each turn.
		if(Food.timeFood > 0)
		System.out.println("The remaining food time is" + Food.timeFood);

		//Josh: if poison is active
		if(Hero.poisonTime > 0)
		{
			Hero.poisonTime--;	//count down poison
			System.out.println("Poison timer is: " + Hero.poisonTime);
		}
		
		
		
		if(Monster.monsterPoisonTime > 0)
		{
			Monster.monsterPoisonTime--;	//count down poison M1
			System.out.println("Monster1 Poison timer is: " + Monster.monsterPoisonTime);
		}
		
		if(Monster.monsterPoisonTime2 > 0)
		{
			Monster.monsterPoisonTime2--;	//count down poison M2
			System.out.println("Monster2 Poison timer is: " + Monster.monsterPoisonTime2);
		}
		
		
		
		//Angus: The player achieves victory when they survive for 100 turns.
		if (timeCount >= 100)
		{
			System.out.println("Winner!");
			loadGameMenu();
		}
		
	}
}
