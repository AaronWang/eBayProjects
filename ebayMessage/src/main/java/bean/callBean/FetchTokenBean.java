package bean.callBean;

import java.util.Calendar;

import bean.Bean;

public class FetchTokenBean extends EbayCallBean {
	// input
	String secretID;
	String sessionID;

	// output
	String returnedToken;
	Calendar hardExpirationTime;
	String returnedRESTToken;

	public String getSecretID() {
		return secretID;
	}

	public void setSecretID(String secretID) {
		this.secretID = secretID;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getReturnedToken() {
		return returnedToken;
	}

	public void setReturnedToken(String returnedToken) {
		this.returnedToken = returnedToken;
	}

	public Calendar getHardExpirationTime() {
		return hardExpirationTime;
	}

	public void setHardExpirationTime(Calendar hardExpirationTime) {
		this.hardExpirationTime = hardExpirationTime;
	}

	public String getReturnedRESTToken() {
		return returnedRESTToken;
	}

	public void setReturnedRESTToken(String returnedRESTToken) {
		this.returnedRESTToken = returnedRESTToken;
	}

}
