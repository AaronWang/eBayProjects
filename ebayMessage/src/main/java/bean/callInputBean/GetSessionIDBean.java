package bean.callInputBean;

public class GetSessionIDBean extends AbstractInputBean {
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
