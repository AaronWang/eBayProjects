package bean.callBean;

import com.ebay.soap.eBLBaseComponents.ItemListCustomizationType;
import com.ebay.soap.eBLBaseComponents.MyeBaySellingSummaryType;
import com.ebay.soap.eBLBaseComponents.PaginatedItemArrayType;
import com.ebay.soap.eBLBaseComponents.PaginatedOrderTransactionArrayType;
import com.ebay.soap.eBLBaseComponents.SellingSummaryType;

public class GetMyeBaySellingBean extends EbayCallBean {
	// input
	ItemListCustomizationType scheduledList;
	ItemListCustomizationType activeList;
	ItemListCustomizationType soldList;
	ItemListCustomizationType unsoldList;
	ItemListCustomizationType bidList;
	ItemListCustomizationType deletedFromSoldList;
	ItemListCustomizationType deletedFromUnsoldList;
	ItemListCustomizationType sellingSummary;
	boolean hideVariations;
	// output
	SellingSummaryType returnedSellingSummary;
	PaginatedItemArrayType returnedScheduledList;
	PaginatedItemArrayType returnedActiveList;
	PaginatedOrderTransactionArrayType returnedSoldList;
	PaginatedItemArrayType returnedUnsoldList;
	MyeBaySellingSummaryType returnedSummary;
	PaginatedItemArrayType returnedBidList;
	PaginatedOrderTransactionArrayType returnedDeletedFromSoldList;
	PaginatedItemArrayType returnedDeletedFromUnsoldList;

	public ItemListCustomizationType getScheduledList() {
		return scheduledList;
	}

	public void setScheduledList(ItemListCustomizationType scheduledList) {
		this.scheduledList = scheduledList;
	}

	public ItemListCustomizationType getActiveList() {
		return activeList;
	}

	public void setActiveList(ItemListCustomizationType activeList) {
		this.activeList = activeList;
	}

	public ItemListCustomizationType getBidList() {
		return bidList;
	}

	public void setBidList(ItemListCustomizationType bidList) {
		this.bidList = bidList;
	}

	public ItemListCustomizationType getSoldList() {
		return soldList;
	}

	public void setSoldList(ItemListCustomizationType soldList) {
		this.soldList = soldList;
	}

	public ItemListCustomizationType getUnsoldList() {
		return unsoldList;
	}

	public void setUnsoldList(ItemListCustomizationType unsoldList) {
		this.unsoldList = unsoldList;
	}

	public ItemListCustomizationType getDeletedFromSoldList() {
		return deletedFromSoldList;
	}

	public void setDeletedFromSoldList(ItemListCustomizationType deletedFromSoldList) {
		this.deletedFromSoldList = deletedFromSoldList;
	}

	public ItemListCustomizationType getDeletedFromUnsoldList() {
		return deletedFromUnsoldList;
	}

	public void setDeletedFromUnsoldList(ItemListCustomizationType deletedFromUnsoldList) {
		this.deletedFromUnsoldList = deletedFromUnsoldList;
	}

	public ItemListCustomizationType getSellingSummary() {
		return sellingSummary;
	}

	public void setSellingSummary(ItemListCustomizationType sellingSummary) {
		this.sellingSummary = sellingSummary;
	}

	public boolean isHideVariations() {
		return hideVariations;
	}

	public void setHideVariations(boolean hideVariations) {
		this.hideVariations = hideVariations;
	}

	public SellingSummaryType getReturnedSellingSummary() {
		return returnedSellingSummary;
	}

	public void setReturnedSellingSummary(SellingSummaryType returnedSellingSummary) {
		this.returnedSellingSummary = returnedSellingSummary;
	}

	public PaginatedItemArrayType getReturnedScheduledList() {
		return returnedScheduledList;
	}

	public void setReturnedScheduledList(PaginatedItemArrayType returnedScheduledList) {
		this.returnedScheduledList = returnedScheduledList;
	}

	public PaginatedItemArrayType getReturnedActiveList() {
		return returnedActiveList;
	}

	public void setReturnedActiveList(PaginatedItemArrayType returnedActiveList) {
		this.returnedActiveList = returnedActiveList;
	}

	public PaginatedOrderTransactionArrayType getReturnedSoldList() {
		return returnedSoldList;
	}

	public void setReturnedSoldList(PaginatedOrderTransactionArrayType returnedSoldList) {
		this.returnedSoldList = returnedSoldList;
	}

	public PaginatedItemArrayType getReturnedUnsoldList() {
		return returnedUnsoldList;
	}

	public void setReturnedUnsoldList(PaginatedItemArrayType returnedUnsoldList) {
		this.returnedUnsoldList = returnedUnsoldList;
	}

	public MyeBaySellingSummaryType getReturnedSummary() {
		return returnedSummary;
	}

	public void setReturnedSummary(MyeBaySellingSummaryType returnedSummary) {
		this.returnedSummary = returnedSummary;
	}

	public PaginatedItemArrayType getReturnedBidList() {
		return returnedBidList;
	}

	public void setReturnedBidList(PaginatedItemArrayType returnedBidList) {
		this.returnedBidList = returnedBidList;
	}

	public PaginatedOrderTransactionArrayType getReturnedDeletedFromSoldList() {
		return returnedDeletedFromSoldList;
	}

	public void setReturnedDeletedFromSoldList(PaginatedOrderTransactionArrayType returnedDeletedFromSoldList) {
		this.returnedDeletedFromSoldList = returnedDeletedFromSoldList;
	}

	public PaginatedItemArrayType getReturnedDeletedFromUnsoldList() {
		return returnedDeletedFromUnsoldList;
	}

	public void setReturnedDeletedFromUnsoldList(PaginatedItemArrayType returnedDeletedFromUnsoldList) {
		this.returnedDeletedFromUnsoldList = returnedDeletedFromUnsoldList;
	}

}
