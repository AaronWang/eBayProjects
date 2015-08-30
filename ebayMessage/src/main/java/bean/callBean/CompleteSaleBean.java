package bean.callBean;

import com.ebay.soap.eBLBaseComponents.FeedbackInfoType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.ShipmentType;

public class CompleteSaleBean extends EbayCallBean {
	// input
	String itemID ;
	String transactionID ;
	FeedbackInfoType feedbackInfo ;
	Boolean shipped ;
	Boolean paid ;
	ListingTypeCodeType listingType ;
	ShipmentType shipment ;
	String orderID ;
	String orderLineItemID ;

	// output
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

	public FeedbackInfoType getFeedbackInfo() {
		return feedbackInfo;
	}

	public void setFeedbackInfo(FeedbackInfoType feedbackInfo) {
		this.feedbackInfo = feedbackInfo;
	}

	public Boolean getShipped() {
		return shipped;
	}

	public void setShipped(Boolean shipped) {
		this.shipped = shipped;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public ListingTypeCodeType getListingType() {
		return listingType;
	}

	public void setListingType(ListingTypeCodeType listingType) {
		this.listingType = listingType;
	}

	public ShipmentType getShipment() {
		return shipment;
	}

	public void setShipment(ShipmentType shipment) {
		this.shipment = shipment;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOrderLineItemID() {
		return orderLineItemID;
	}

	public void setOrderLineItemID(String orderLineItemID) {
		this.orderLineItemID = orderLineItemID;
	}

}
