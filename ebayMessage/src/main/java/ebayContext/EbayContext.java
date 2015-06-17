package ebayContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.ApiLogging;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;

import configuration.LoadTextProperties;

public class EbayContext {

	public LoadTextProperties keys = new LoadTextProperties();
	// private ArrayList<ApiContext> apiContext;

	private Map<String, ApiContext> apiContextMap;
	private ApiContext originalApiContext;

	public EbayContext() {
		apiContextMap = new HashMap<String, ApiContext>();
		originalApiContext = new ApiContext();

		ApiCredential cred = originalApiContext.getApiCredential();
		ApiAccount account = new ApiAccount();
		ApiLogging apiLogging = new ApiLogging();

		apiLogging.setLogSOAPMessages(false);
		apiLogging.setLogHTTPHeaders(true);
		originalApiContext.setApiLogging(apiLogging);

		account.setDeveloper(keys.getProperty("devId"));
		account.setApplication(keys.getProperty("appId"));
		account.setCertificate(keys.getProperty("certId"));
		// account.setDeveloper("7dbf468d-db19-4dbc-8e5e-8630a4543b61");
		// account.setApplication("XinWang0c-6a0c-4ea0-8def-d094f42a343");
		// account.setCertificate("98b00dc7-8d0b-48ea-bca6-a4b461b0c69a");
		System.out.println(account.getDeveloper());
		System.out.println(account.getApplication());
		System.out.println(account.getCertificate());
		cred.setApiAccount(account);
		// Make one call because Axis takes long time for the first execution.
		originalApiContext.setApiServerUrl(keys.getProperty("apiServer"));

	}

	void initSDK(ApiContext ctx) throws Exception {
		GeteBayOfficialTimeCall t = new GeteBayOfficialTimeCall(ctx);
		t.geteBayOfficialTime();
	}

	public void initializeApiContext(String accountID, String token) {
		
		if (apiContextMap.size() != 0) {
			apiContextMap.
		} else {
			ApiContext newApiConotext = new ApiContext();
		}
	}

	public ApiContext getApiContext(String accountID) {
		return apiContextMap.get(accountID);
	}

	public ApiContext getApiContext() {
		return originalApiContext.clone();
	}
}