package bean.callInputBean;

import com.ebay.soap.eBLBaseComponents.DisputeExplanationCodeType;
import com.ebay.soap.eBLBaseComponents.DisputeReasonCodeType;

public class AddDisputeBean extends AbstractInputBean {
	// input
	DisputeExplanationCodeType disputeExplanation;
	DisputeReasonCodeType disputeReason;
	String itemID;
	String transactionID;
	String orderLineItemID;// orderLineItemID == itemID + transactionID

	// output
	String ReturnedDisputeID;

	public DisputeExplanationCodeType getDisputeExplanation() {
		return disputeExplanation;
	}

	public void setDisputeExplanation(
			DisputeExplanationCodeType disputeExplanation) {
		this.disputeExplanation = disputeExplanation;
	}

	public DisputeReasonCodeType getDisputeReason() {
		return disputeReason;
	}

	public void setDisputeReason(DisputeReasonCodeType disputeReason) {
		this.disputeReason = disputeReason;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getOrderLineItemID() {
		return orderLineItemID;
	}

	public void setOrderLineItemID(String orderLineItemID) {
		this.orderLineItemID = orderLineItemID;
	}

	public String getReturnedDisputeID() {
		return ReturnedDisputeID;
	}

	public void setReturnedDisputeID(String returnedDisputeID) {
		ReturnedDisputeID = returnedDisputeID;
	}

}
