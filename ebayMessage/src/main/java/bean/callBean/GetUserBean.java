package bean.callBean;

import com.ebay.soap.eBLBaseComponents.UserType;

public class GetUserBean extends EbayCallBean {
	// input
	String itemID;
	String userID;
	// output
	UserType returnedUser;

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public UserType getReturnedUser() {
		return returnedUser;
	}

	public void setReturnedUser(UserType returnedUser) {
		this.returnedUser = returnedUser;
	}

}
