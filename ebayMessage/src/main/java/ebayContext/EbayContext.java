package ebayContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;

public class EbayContext {
	public static ApiContext apiContext = getApiContext();
	public EbayContext(){
		getApiContext();
	}
	public static ApiContext getApiContext() {
		if (apiContext != null)
			return apiContext;
		apiContext = new ApiContext();
		ApiCredential cred = apiContext.getApiCredential();
		Properties keys = new Properties();
		try {
			keys.load(new FileInputStream("keys.properties"));
		} catch (IOException e) {
			System.out.println(e);
		}
		// set devId, appId, certId in ApiAccount
		ApiAccount account = new ApiAccount();
		account.setDeveloper(keys.getProperty("devId"));
		account.setApplication(keys.getProperty("appId"));
		account.setCertificate(keys.getProperty("certId"));
		cred.setApiAccount(account);
		apiContext.setApiServerUrl("https://api.ebay.com/wsapi");
		System.out.println("initialize Api Context");
		//wangyingxin
		cred.seteBayToken("AgAAAA**AQAAAA**aAAAAA**OxAuVQ**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6AFkICnAJSDow2dj6x9nY+seQ**44YCAA**AAMAAA**0NfRWAB4Irh20lr45k4IRve/uU1VMMLGtW1Zk1Ab23M6aoYbxG9ARbI4R6+1kqkCi8MwKjIM2KZySQGvHgVXUGdS4V6+Xn5wfJjCoCJCp4JXD2Z2oQJ3FoeZoiocy2r/rSYeRP92pvM7b4OhQYSX0FVnl9AQz2XegRkPn2FfYsqVpdGm9Bh408DRD+VedMbClX3DZ6llepCXpVqrPXOOHAuulye55muXKFG8OuA03a1Izzxrbmm841ZGWFecNoWURjBBGNmnZllMXq8oodES7nk9b1GWLbUCETrvTok3aHl45q65lfU/n87zl0nDFBcHywHnNup2H4MPeXhXmeV65gMq/oxV74FN6dTkmcduVVQ6VQpiiowt2WHBXPmU03XHh71t/GpGPyB/VMwdTwPSBtx0VA71ITDRiReBObwHCVV76de8oMsyVSzOKI+yBkfo6zokOLLg/6aEPVHJGAWZISg774cQkXG78uRtjwTEAiU0sghDEkJQHa7oGc5nNVP2KG3mlDe+qSU14QyueSP8sa3UQZyXOQNhqcnkqOctIoYwzfVoWE/Z/jjHohd5TFZ7iTcbMACqXkeEA5jD01olY16l+LcCpJm/XvI/ZQHmj4iJMOLbEwUIAR9VpQz4o6Q3uHexatTMtUlEDIkvvEBrbwaMl4PCdOxS34JJ6l/e1UUnb2s1Nr702MkUQoAGvOi9eZ8Uy3gunKbVOtNsYJ4reK4AG2vaDfbfdgaypZVtPW84tyMLIl1Fy2ubvCrql4KG");
		return apiContext;
	}


}