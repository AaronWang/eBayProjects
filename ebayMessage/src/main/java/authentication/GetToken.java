package authentication;

import java.awt.Desktop;
import java.net.URI;

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
		GetSessionIDCall sessionCall = new GetSessionIDCall(
				EbayContext.apiContext);
		sessionCall.setRuName("Xin_Wang-XinWang0c-6a0c--wyipcandl");

		try {
			sessionID = sessionCall.getSessionID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public boolean getToken(){
		FetchTokenCall getToken = new FetchTokenCall(EbayContext.apiContext);
		getToken.setSessionID(sessionID);
		try {
			token = getToken.fetchToken();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tokenSeccess = false;
			return false;
		}
		System.out.println(token);
		tokenSeccess = true;
		EbayContext.apiContext.getApiCredential().seteBayToken(token);
		return true;
	}
}
