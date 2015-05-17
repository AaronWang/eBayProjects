package helloworld;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;

public class EbayContext {
	public static ApiContext apiContext = getApiContext();

	public EbayContext() {
		// getApiContext();
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
		return apiContext;
	}
}