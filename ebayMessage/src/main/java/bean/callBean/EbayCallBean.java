package bean.callBean;

import bean.Bean;

import com.ebay.sdk.ApiContext;

public class EbayCallBean extends Bean {
	String myUserID;
	ApiContext apiContext;

	public String getMyUserID() {
		return myUserID;
	}

	public void setMyUserID(String myUserID) {
		this.myUserID = myUserID;
	}

	public ApiContext getApiContext() {
		return apiContext;
	}

	public void setApiContext(ApiContext apiContext) {
		this.apiContext = apiContext;
	}

}
