package bean.callBean;

import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.NameValueListArrayType;

public class GetItemBean extends EbayCallBean {
	// input
	String itemID;
	boolean includeWatchCount;
	boolean includeCrossPromotion;
	boolean includeItemSpecifics;
	boolean includeTaxTable;
	String sku;
	String variationSKU;
	NameValueListArrayType variationSpecifics;
	String transactionID;
	boolean includeItemCompatibilityList;

	// output
	ItemType returnedItem;

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public boolean isIncludeWatchCount() {
		return includeWatchCount;
	}

	public void setIncludeWatchCount(boolean includeWatchCount) {
		this.includeWatchCount = includeWatchCount;
	}

	public boolean isIncludeCrossPromotion() {
		return includeCrossPromotion;
	}

	public void setIncludeCrossPromotion(boolean includeCrossPromotion) {
		this.includeCrossPromotion = includeCrossPromotion;
	}

	public boolean isIncludeItemSpecifics() {
		return includeItemSpecifics;
	}

	public void setIncludeItemSpecifics(boolean includeItemSpecifics) {
		this.includeItemSpecifics = includeItemSpecifics;
	}

	public boolean isIncludeTaxTable() {
		return includeTaxTable;
	}

	public void setIncludeTaxTable(boolean includeTaxTable) {
		this.includeTaxTable = includeTaxTable;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getVariationSKU() {
		return variationSKU;
	}

	public void setVariationSKU(String variationSKU) {
		this.variationSKU = variationSKU;
	}

	public NameValueListArrayType getVariationSpecifics() {
		return variationSpecifics;
	}

	public void setVariationSpecifics(NameValueListArrayType variationSpecifics) {
		this.variationSpecifics = variationSpecifics;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public boolean isIncludeItemCompatibilityList() {
		return includeItemCompatibilityList;
	}

	public void setIncludeItemCompatibilityList(boolean includeItemCompatibilityList) {
		this.includeItemCompatibilityList = includeItemCompatibilityList;
	}

	public ItemType getReturnedItem() {
		return returnedItem;
	}

	public void setReturnedItem(ItemType returnedItem) {
		this.returnedItem = returnedItem;
	}
}
