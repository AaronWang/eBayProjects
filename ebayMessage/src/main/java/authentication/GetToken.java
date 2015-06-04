package authentication;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.ebay.sdk.call.FetchTokenCall;
import com.ebay.sdk.call.GetSessionIDCall;

import ebayContext.EbayContext;

public class GetToken {
	static String sessionID;
	static String runame = "Xin_Wang-XinWang0c-6a0c--wyipcandl";
	static String token;
	static boolean tokenSeccess = false;

	public GetToken() {
	}

	public boolean getSessionID() {
		GetSessionIDCall sessionCall = new GetSessionIDCall(new 
				EbayContext().apiContext);
		sessionCall.setRuName("Xin_Wang-XinWang0c-6a0c--wyipcandl");
		JOptionPane.showMessageDialog(null,sessionCall.getRuName());
		
		try {
			sessionID = sessionCall.getSessionID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"get session id failed");
			return false;
		}
		if (sessionID != null)
			System.out.println("Got session ID :" + sessionID);
		return true;
	}

	public void openBrowser() {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop()
				: null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(new URI(
						"https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&RUName=Xin_Wang-XinWang0c-6a0c--wyipcandl&SessID="
								+ sessionID));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean getToken() {
		FetchTokenCall getToken = new FetchTokenCall(EbayContext.apiContext);
		getToken.setSessionID(sessionID);
		try {
			token = getToken.fetchToken();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tokenSeccess = false;
			JOptionPane.showMessageDialog(null,"failed");
			return false;
		}
		System.out.println(token);
		tokenSeccess = true;
		EbayContext.apiContext.getApiCredential().seteBayToken(token);
		Properties keys = new Properties();
		try {
			keys.load(new FileInputStream("keys.properties"));
		} catch (IOException e) {
			System.out.println(e);
		}
		keys.setProperty(sessionID, token);
		try {
			keys.store(new FileOutputStream("keys.properties"), "");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
