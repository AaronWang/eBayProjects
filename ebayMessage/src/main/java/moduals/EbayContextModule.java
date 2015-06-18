package moduals;

import java.util.HashMap;
import java.util.Map;

import bean.Account;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;

import configuration.LoadTextProperties;
import configuration.LoadXmlProperties;

public class EbayContextModule extends AbstractModule {

	public LoadTextProperties keys;
	public LoadXmlProperties accountList;
	// private ArrayList<ApiContext> apiContext;

	private Map<String, ApiContext> apiContextMap;
	private ApiContext originalApiContext;
	private ApiAccount account;

	public EbayContextModule() {
		keys = new LoadTextProperties();
		accountList = new LoadXmlProperties();

		apiContextMap = new HashMap<String, ApiContext>();
		account = new ApiAccount();
		account.setDeveloper(keys.getProperty("devId"));
		account.setApplication(keys.getProperty("appId"));
		account.setCertificate(keys.getProperty("certId"));
		// account.setDeveloper("7dbf468d-db19-4dbc-8e5e-8630a4543b61");
		// account.setApplication("XinWang0c-6a0c-4ea0-8def-d094f42a343");
		// account.setCertificate("98b00dc7-8d0b-48ea-bca6-a4b461b0c69a");

		// System.out.println(account.getDeveloper());
		// System.out.println(account.getApplication());
		// System.out.println(account.getCertificate());

		for (Account tmp : accountList.getAccounts()) {
			getApiContext();
			originalApiContext.getApiCredential().seteBayToken(tmp.getToken());
//			System.out.println("name  : " + tmp.getName());
//			System.out.println("token : " + tmp.getToken());
			apiContextMap.put(tmp.getName(), originalApiContext);
		}
	}

	void initSDK(ApiContext apiContext) throws Exception {
		GeteBayOfficialTimeCall t = new GeteBayOfficialTimeCall(apiContext);
		t.geteBayOfficialTime();
	}

	public void saveApiContext(String accountID, ApiContext apicontext) {
		apiContextMap.put(accountID, apicontext);
	}

	public ApiContext getApiContext(String accountID) {
		return apiContextMap.get(accountID);
	}

	public ApiContext getApiContext() {
		originalApiContext = new ApiContext();
		ApiCredential cred = originalApiContext.getApiCredential();

		// ApiLogging apiLogging = new ApiLogging();
		// apiLogging.setLogSOAPMessages(false);
		// apiLogging.setLogHTTPHeaders(true);
		// originalApiContext.setApiLogging(apiLogging);

		cred.setApiAccount(account);
		// cred.seteBayToken("set ebay token");

		// Make one call because Axis takes long time for the first execution.
		originalApiContext.setApiServerUrl(keys.getProperty("apiServer"));
		return originalApiContext;
	}
}