package bean.callBean;

import java.util.Calendar;

import com.ebay.soap.eBLBaseComponents.EndItemRequestContainerType;
import com.ebay.soap.eBLBaseComponents.EndItemResponseContainerType;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;

public class EndItemBean extends EbayCallBean {
	// input
	String itemID;
	EndReasonCodeType endingReason;
	String sellerInventoryID;
	// output
	Calendar ReturnedEndTime;

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public EndReasonCodeType getEndingReason() {
		return endingReason;
	}

	public void setEndingReason(EndReasonCodeType endingReason) {
		this.endingReason = endingReason;
	}

	public String getSellerInventoryID() {
		return sellerInventoryID;
	}

	public void setSellerInventoryID(String sellerInventoryID) {
		this.sellerInventoryID = sellerInventoryID;
	}

	public Calendar getReturnedEndTime() {
		return ReturnedEndTime;
	}

	public void setReturnedEndTime(Calendar returnedEndTime) {
		ReturnedEndTime = returnedEndTime;
	}

}
