package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class User
{
//	private static final int NUMBEROFUSERS = 50;
	
	
	String username;
	String password;
//	String storedUsernames[] = new String[NUMBEROFUSERS];
//	String storedPasswords[] = new String[NUMBEROFUSERS];
	
	static int n = 0;
	
	List<String> usernameList = new ArrayList<String>();
	List<String> passwordList = new ArrayList<String>();
	
	File file = new File();
	
	HashMap<String , String > users = file.load();
	
	void printUsers()
	{
		Iterator<String> accountIterator = users.keySet().iterator();
		while (accountIterator.hasNext())
		{
			String account = accountIterator.next();
			System.out.println(account + ": " +users.get(account));	
		}
	}
	
	void saveUsers(String username)
	{
		file.save(username);
	}
	
	
	
	boolean authenticateUser (String username)
	{
		
		// verify 
		if (users.containsKey(username))
		{
			System.out.println("The desired username is already in use");
			return false;
		}else
		{
		
			return true;
		}
	}	
	
	boolean accountLogin(String username , String password)
	{
		if(users.containsKey(username))
		{
			if(password.equals(users.get(username)))
			{
				System.out.println("login Successful");
				return true;
			}
			else
			{
				System.out.println("incorrect Password");
				return false;
			}
		}
		else
		{
			System.out.println("Invalid Username");
			return false;
		}	
	}
	
	boolean adminLogin (String username , String password)
	{
		String substring = username.substring(0, Math.min(username.length(), 3));
		String admin = "ADM";
		
		
		if (users.containsKey(username) && substring.equals(admin))
		{
			
			if(users.get(username).equals(password))
			{
				System.out.println("Admin login authorised");
				return true;
			}
			else
			{
				System.out.println("Incorrect Password");
				return false;
			}
		
		}
		else
		{
			System.out.println("invalid Admin username");
			return false;
		}
	}
	

}
