package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class File {

	String csvFile = "C:/Users/Mohammed/Desktop/strategicMonsterGame/src/application/storedAccounts.csv";
	BufferedReader buffer = null;
	String line = "";
	String cvsDilem = ",";
	String newLine ="\n";

	HashMap<String, String> users = new HashMap<String, String>();

	public HashMap<String, String> load() {

		// HashMap<String , String > users = new HashMap<String , String>();

		try {

			buffer = new BufferedReader(new FileReader(csvFile));

			while ((line = buffer.readLine()) != null) {
				String[] accounts = line.split(cvsDilem);

				users.put(accounts[0], accounts[1]);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return users;

	}

	public void save(String username) {
	

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
			//

			StringBuilder sb = new StringBuilder();

					sb.append(username);
					sb.append(cvsDilem);
					sb.append(users.get(username));
					sb.append(newLine);
					writer.write(sb.toString());

				

			//}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
//test