package bean.callBean;

import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.NameValueListArrayType;
import com.ebay.soap.eBLBaseComponents.StoreType;

public class GetStoreBean extends EbayCallBean {
	// input
	boolean categoryStructureOnly = false;
	Long rootCategoryID = null;
	Integer levelLimit = null;
	String userID = null;

	// output
	StoreType returnedStoreType;

	public boolean isCategoryStructureOnly() {
		return categoryStructureOnly;
	}

	public void setCategoryStructureOnly(boolean categoryStructureOnly) {
		this.categoryStructureOnly = categoryStructureOnly;
	}

	public Long getRootCategoryID() {
		return rootCategoryID;
	}

	public void setRootCategoryID(Long rootCategoryID) {
		this.rootCategoryID = rootCategoryID;
	}

	public Integer getLevelLimit() {
		return levelLimit;
	}

	public void setLevelLimit(Integer levelLimit) {
		this.levelLimit = levelLimit;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public StoreType getReturnedStoreType() {
		return returnedStoreType;
	}

	public void setReturnedStoreType(StoreType returnedStoreType) {
		this.returnedStoreType = returnedStoreType;
	}
}
