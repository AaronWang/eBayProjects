package bean.callBean;

import bean.Bean;

import com.ebay.sdk.ApiContext;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;

public class EbayCallBean extends Bean {
	String myUserID;
	ApiContext apiContext;

	DetailLevelCodeType[] detailLevel;

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

	public DetailLevelCodeType[] getDetailLevel() {
		return detailLevel;
	}

	public void setDetailLevel(DetailLevelCodeType[] detailLevel) {
		this.detailLevel = detailLevel;
	}

}
