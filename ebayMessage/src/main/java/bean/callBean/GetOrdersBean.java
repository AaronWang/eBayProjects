package bean.callBean;

import java.util.Calendar;

import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.OrderIDArrayType;
import com.ebay.soap.eBLBaseComponents.OrderStatusCodeType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PaginationResultType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.SortOrderCodeType;
import com.ebay.soap.eBLBaseComponents.TradingRoleCodeType;

public class GetOrdersBean extends EbayCallBean {
	// input

	OrderIDArrayType orderIDArray;
	Calendar createTimeFrom;
	Calendar createTimeTo;
	TradingRoleCodeType orderRole;
	OrderStatusCodeType orderStatus;
	ListingTypeCodeType listingType;
	PaginationType pagination;
	Calendar modTimeFrom;
	Calendar modTimeTo;
	int numberOfDays;
	boolean includeFinalValueFee;
	SortOrderCodeType sortingOrder;

	// output
	PaginationResultType returnedPaginationResult;
	boolean returnedHasMoreOrders;
	OrderType[] returnedOrderArray;
	int returnedOrdersPerPage;
	int returnedPageNumber;
	int returnedReturnedOrderCountActual;

	public OrderIDArrayType getOrderIDArray() {
		return orderIDArray;
	}

	public void setOrderIDArray(OrderIDArrayType orderIDArray) {
		this.orderIDArray = orderIDArray;
	}

	public Calendar getCreateTimeFrom() {
		return createTimeFrom;
	}

	public void setCreateTimeFrom(Calendar createTimeFrom) {
		this.createTimeFrom = createTimeFrom;
	}

	public Calendar getCreateTimeTo() {
		return createTimeTo;
	}

	public void setCreateTimeTo(Calendar createTimeTo) {
		this.createTimeTo = createTimeTo;
	}

	public TradingRoleCodeType getOrderRole() {
		return orderRole;
	}

	public void setOrderRole(TradingRoleCodeType orderRole) {
		this.orderRole = orderRole;
	}

	public OrderStatusCodeType getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusCodeType orderStatus) {
		this.orderStatus = orderStatus;
	}

	public ListingTypeCodeType getListingType() {
		return listingType;
	}

	public void setListingType(ListingTypeCodeType listingType) {
		this.listingType = listingType;
	}

	public PaginationType getPagination() {
		return pagination;
	}

	public void setPagination(PaginationType pagination) {
		this.pagination = pagination;
	}

	public Calendar getModTimeFrom() {
		return modTimeFrom;
	}

	public void setModTimeFrom(Calendar modTimeFrom) {
		this.modTimeFrom = modTimeFrom;
	}

	public Calendar getModTimeTo() {
		return modTimeTo;
	}

	public void setModTimeTo(Calendar modTimeTo) {
		this.modTimeTo = modTimeTo;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public boolean isIncludeFinalValueFee() {
		return includeFinalValueFee;
	}

	public void setIncludeFinalValueFee(boolean includeFinalValueFee) {
		this.includeFinalValueFee = includeFinalValueFee;
	}

	public SortOrderCodeType getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(SortOrderCodeType sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	public PaginationResultType getReturnedPaginationResult() {
		return returnedPaginationResult;
	}

	public void setReturnedPaginationResult(PaginationResultType returnedPaginationResult) {
		this.returnedPaginationResult = returnedPaginationResult;
	}

	public boolean isReturnedHasMoreOrders() {
		return returnedHasMoreOrders;
	}

	public void setReturnedHasMoreOrders(boolean returnedHasMoreOrders) {
		this.returnedHasMoreOrders = returnedHasMoreOrders;
	}

	public OrderType[] getReturnedOrderArray() {
		return returnedOrderArray;
	}

	public void setReturnedOrderArray(OrderType[] returnedOrderArray) {
		this.returnedOrderArray = returnedOrderArray;
	}

	public int getReturnedOrdersPerPage() {
		return returnedOrdersPerPage;
	}

	public void setReturnedOrdersPerPage(int returnedOrdersPerPage) {
		this.returnedOrdersPerPage = returnedOrdersPerPage;
	}

	public int getReturnedPageNumber() {
		return returnedPageNumber;
	}

	public void setReturnedPageNumber(int returnedPageNumber) {
		this.returnedPageNumber = returnedPageNumber;
	}

	public int getReturnedReturnedOrderCountActual() {
		return returnedReturnedOrderCountActual;
	}

	public void setReturnedReturnedOrderCountActual(int returnedReturnedOrderCountActual) {
		this.returnedReturnedOrderCountActual = returnedReturnedOrderCountActual;
	}

}
