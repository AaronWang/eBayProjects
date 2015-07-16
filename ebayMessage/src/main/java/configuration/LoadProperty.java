package configuration;

import java.util.ArrayList;

import bean.Account;

public interface LoadProperty {
	ArrayList<Account> accounts = new ArrayList<Account>();

	public static final String propertiFile = "../../keys.properties";
	public static final String propertiXmlFile = "../../Config.xml";

	public void loadAccounts();

	public ArrayList<Account> getAccounts();

	public String getToken(String userID);

	public boolean isExsit(String userID);

	public void removeAccount(String userID);

	public void saveAccount(String userID, String token);

	public void saveFile();
}
