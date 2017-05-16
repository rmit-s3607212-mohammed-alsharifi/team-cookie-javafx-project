package application;
	
import java.util.Scanner;


//import javafx.application.Application;
//import javafx.stage.Stage;

//import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;


//public class Main //extends Application 
//{
	
	// Graphical Interface
//	@Override
	//public void start(Stage primaryStage) {
	//	try {
	//		BorderPane root = new BorderPane();
	//		Scene scene = new Scene(root,400,400);
	//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	//		primaryStage.setScene(scene);
	//		primaryStage.show();
	//	} catch(Exception e) {
	//		e.printStackTrace();
	//	}
//	}
	
	public class Main
	{
		int crap;

		Cell cellref = new Cell();
		//Hero heroref = new Hero();
	
	//
	static User user = new User();
	static Scanner reader = new Scanner(System.in);
/*	public static void main(String[] args) {
		launch(args);
	}*/
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
		

		
		
		//reader.close();
		
		
		
		
		
		
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
		Cell cellRunGame = new Cell();
		cellRunGame.printGrid(cellRunGame.fillGrid(cellRunGame.initGrid()));
		
		int dirChoice;
		
		System.out.println("Press one 1 for up, 2 for left, 3 for right, 4 for down! 5 to exit game!");
		dirChoice = Integer.parseInt(reader.nextLine());
		
		//while(dirChoice != 5){
			switch(dirChoice)
			{
				case 1://[Hero.getxPos()][cell.destY].id.equals("EMPTY"));
					cellRunGame.heroMoveUp();
					cellRunGame.printGrid(cellRunGame.fillGrid(cellRunGame.initGrid()));
					runGame();
					break;
				case 2: cellRunGame.heroMoveLeft();
				cellRunGame.printGrid(cellRunGame.fillGrid(cellRunGame.initGrid()));
					runGame();
					break;
				case 3: cellRunGame.heroMoveRight();
				cellRunGame.printGrid(cellRunGame.fillGrid(cellRunGame.initGrid()));
					runGame();
					break;
				case 4: cellRunGame.heroMoveDown();
				cellRunGame.printGrid(cellRunGame.fillGrid(cellRunGame.initGrid()));
					runGame();
					break;
				default : break;
			}
		
	}
}
	//test