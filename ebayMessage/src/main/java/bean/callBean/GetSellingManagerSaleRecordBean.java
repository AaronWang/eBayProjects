package bean.callBean;

import com.ebay.soap.eBLBaseComponents.SellingManagerSoldOrderType;

public class GetSellingManagerSaleRecordBean extends EbayCallBean {
	// input
	private String itemID = null;
	private String transactionID = null;
	private String orderID = null;
	private String orderLineItemID = null;
	// output
	private SellingManagerSoldOrderType returnedSellingManagerSoldOrder = null;

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

	public SellingManagerSoldOrderType getReturnedSellingManagerSoldOrder() {
		return returnedSellingManagerSoldOrder;
	}

	public void setReturnedSellingManagerSoldOrder(SellingManagerSoldOrderType returnedSellingManagerSoldOrder) {
		this.returnedSellingManagerSoldOrder = returnedSellingManagerSoldOrder;
	}

}
