package authentication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class LoadAccount {
	ArrayList<String> accounts = new ArrayList<String>();

	public void loadAccounts() {
		Properties keys = new Properties();
		try {
			keys.load(new FileInputStream(".\\keys.properties"));
		} catch (IOException e) {
			System.out.println(e);
		}
		String account = keys.getProperty("accounts");
		accounts.addAll(Arrays.asList(account.split(",")));
	}

	public ArrayList<String> getAccounts() {
		return accounts;
	}

	public String getToken(String account) {
		Properties keys = new Properties();
		try {
			keys.load(new FileInputStream(".\\keys.properties"));
		} catch (IOException e) {
			System.out.println(e);
		}
		return keys.getProperty("account");
	}

	public void saveAccount(String userID, String token) {
		Properties keys = new Properties();
		try {
			keys.load(new FileInputStream(".\\keys.properties"));
		} catch (IOException e) {
			System.out.println(e);
		}

		keys.setProperty(userID, token);
		if (accounts.contains(userID) == false)
			keys.setProperty("accounts", keys.get("accounts") + "," + userID);
		try {
			keys.store(new FileOutputStream("keys.properties"), "");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
