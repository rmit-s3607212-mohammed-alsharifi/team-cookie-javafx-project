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
            case 3:  System.out.println("End Game");
            		 break;
            default: break;
        }
	}

	public static void runGame()
	{
		//A reference to the cell class.
		Cell cellRunGame = new Cell();

		//Used for operating the menu.
		int dirChoice;


		Cell[][] playArea = cellRunGame.fillGrid(cellRunGame.initGrid());
		cellRunGame.printGrid(cellRunGame.fillGrid(cellRunGame.initGrid()));

		System.out.println("Press one 1 for up, 2 for left, 3 for right, 4 for down! 5 to stay stationary!, 6 to place food, 7 to exit!");

		//Temporary method of obtaining the direction choice.
		dirChoice = Integer.parseInt(reader.nextLine());



		while(dirChoice != 7){
			if(Hero.poisonTime > 0)
			{
				if(Hero.poisonTime%2 == 1)
				{
					Food.spawner = false;
					cellRunGame.heroStill(playArea);
					timeAdvance();
					runGame();
				}
		
				else
				{
					switch(dirChoice)
					{
						case 1:
							Food.spawner = false;

							//[Hero.getxPos()][cell.destY].id.equals("EMPTY"));

							//Runs the "heroMoveUp method within the cell class.
							cellRunGame.heroMoveUp(playArea);
							
							cellRunGame.MonsterMove(playArea);
							cellRunGame.MonsterMove2(playArea);
					

							//timeAdvance is a function that increments the time count by 1, and will later run other methods such as food degredation and monster movement.
							timeAdvance();

							//Runs the runGame function again (Which we are in at the moment)
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



						case 7 : break;
						default : break;
					}
				}
			}
			else if (Hero.poisonTime == 0)
			{
				switch(dirChoice)
				{
					case 1:
						Food.spawner = false;

						//[Hero.getxPos()][cell.destY].id.equals("EMPTY"));

						//Runs the "heroMoveUp method within the cell class.
						cellRunGame.heroMoveUp(playArea);
						
						cellRunGame.MonsterMove(playArea);
						cellRunGame.MonsterMove2(playArea);

						//timeAdvance is a function that increments the time count by 1, and will later run other methods such as food degredation and monster movement.
						timeAdvance();

						//Runs the runGame function again (Which we are in at the moment)
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



					case 7 : break;
					default : break;
				}
			}
		}
	}


	//This function can hold all of the functions that we need to run as time progreses.
	public static void timeAdvance()
	{
		//The time/turn counter goes up.
		timeCount++;
		Food.timeFood--;

		//Turn count for debugging purposes.
		System.out.println("The turn number is:" + timeCount);

		if(Food.timeFood > 0)
		System.out.println("The remaining food time is" + Food.timeFood);

		if(Hero.poisonTime > 0)
		{
			Hero.poisonTime--;
			System.out.println("Poison timer is: " + Hero.poisonTime);
		}
	}
}/////