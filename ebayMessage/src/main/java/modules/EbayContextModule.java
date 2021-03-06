package modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.Account;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;

import configuration.LoadTextProperties;
import configuration.LoadXmlProperties;
import core.SystemContext;

public class EbayContextModule extends AbstractModule {

	public LoadTextProperties keys;
	private LoadXmlProperties accountList;
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

		updateAccountInfo();
	}

	public void updateAccountInfo() {
		apiContextMap.clear();
		for (Account tmp : accountList.getAccounts()) {
			getApiContext();
			originalApiContext.getApiCredential().seteBayToken(tmp.getToken());
			// System.out.println("name  : " + tmp.getName());
			// System.out.println("token : " + tmp.getToken());
			apiContextMap.put(tmp.getName(), originalApiContext);
		}
	}

	@Override
	public void init(SystemContext systemContext) {
		super.init(systemContext);
		try {

			// initSDK(getApiContext());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void initSDK(ApiContext apiContext) {
		GeteBayOfficialTimeCall t = new GeteBayOfficialTimeCall(apiContext);
		try {
			t.geteBayOfficialTime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveApiContext(String userID, ApiContext apicontext) {
		apiContextMap.put(userID, apicontext);
		accountList.saveAccount(userID, apicontext.getApiCredential()
				.geteBayToken());
	}

	public void saveAccount(String userID, String ebayToken) {
		getApiContext();
		originalApiContext.getApiCredential().seteBayToken(ebayToken);
		// System.out.println("name  : " + tmp.getName());
		// System.out.println("token : " + tmp.getToken());
		apiContextMap.put(userID, originalApiContext);
		accountList.saveAccount(userID, ebayToken);
	}

	public ArrayList<String> getAccountList() {
		ArrayList<String> list = new ArrayList<String>();
		for (String name : apiContextMap.keySet()) {
			list.add(name);
		}
		return list;
	}

	public void removeAccount(String userID) {
		apiContextMap.remove(userID);
		accountList.removeAccount(userID);
	}

	public ApiContext getApiContext(String accountID) {
		if (accountID == "" || accountID == null)
			return getApiContext();
		else
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
		originalApiContext.setRuName(keys.getProperty("RuName"));
		return originalApiContext;
	}

}