package configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import bean.Account;

public class LoadXmlProperties implements LoadProperty {

	Document doc;
	String xmlPath;

	public LoadXmlProperties() {
		xmlPath = LoadProperty.propertiXmlFile;
		loadAccounts();
	}

	@Override
	public void loadAccounts() {
		// TODO Auto-generated method stub
		try {
			File inputFile = new File(xmlPath);
			SAXReader reader = new SAXReader();
			doc = reader.read(inputFile);

			// System.out.println("Root element :"
			// + doc.getRootElement().getName());

			// Element classElement = doc.getRootElement();

			List<Node> nodes = doc
					.selectNodes("/Configuration/eBayCredential/Account");

			accounts.clear();
			for (Node node : nodes) {
				// System.out.println("\nCurrent Element :" + node.getName());
				Account tmp = new Account();
				tmp.setName(node.selectSingleNode("name").getText());
				tmp.setToken(node.selectSingleNode("token").getText());
				accounts.add(tmp);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Account> getAccounts() {
		// TODO Auto-generated method stub
		return accounts;
	}

	@Override
	public String getToken(String userID) {
		// TODO Auto-generated method stub
		for (Account s : accounts) {
			if (s.getName().equals(userID))
				return s.getToken();
		}
		return null;
	}

	@Override
	public boolean isExsit(String userID) {
		// TODO Auto-generated method stub
		for (Account s : accounts) {
			if (s.getName().equals(userID))
				return true;
		}
		return false;
	}

	@Override
	public void saveAccount(String userID, String token) {
		// TODO Auto-generated method stub
		if (isExsit(userID)) {
			for (Account tmp : accounts)
				if (tmp.getName().equals(userID)) {
					tmp.setToken(token);
					doc.selectSingleNode(
							"/Configuration/eBayCredential/Account[name='"
									+ userID + "']/token").setText(token);
					saveFile();
					return;
				}
			return;
		}
		Account tmp = new Account();
		tmp.setName(userID);
		tmp.setToken(token);
		accounts.add(tmp);

		Element rootElement = (Element) (doc
				.selectSingleNode("/Configuration/eBayCredential"));

		Element newAccount = rootElement.addElement("Account");
		newAccount.addElement("name").setText(userID);
		newAccount.addElement("token").setText(token);
		saveFile();
	}

	@Override
	public void saveFile() {
		// TODO Auto-generated method stub
		// lets write to a file
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileWriter(xmlPath));
			writer.write(doc);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeAccount(String userID) {
		// TODO Auto-generated method stub
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getName().equals(userID)) {
				accounts.remove(i);
				doc.selectSingleNode(
						"/Configuration/eBayCredential/Account[name='" + userID
								+ "']").detach();
				saveFile();
				return;
			}
		}
	}
}
