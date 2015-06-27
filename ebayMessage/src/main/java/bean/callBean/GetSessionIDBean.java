package bean.callBean;

import bean.Bean;

public class GetSessionIDBean extends EbayCallBean {
	// input
	String RuName;
	// output
	String returnedSessionID;

	public String getRuName() {
		return RuName;
	}

	public void setRuName(String ruName) {
		RuName = ruName;
	}

	public String getReturnedSessionID() {
		return returnedSessionID;
	}

	public void setReturnedSessionID(String returnedSessionID) {
		this.returnedSessionID = returnedSessionID;
	}

}
