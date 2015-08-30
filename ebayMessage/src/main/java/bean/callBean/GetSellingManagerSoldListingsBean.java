package bean.callBean;

import com.ebay.soap.eBLBaseComponents.PaginationResultType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.SellingManagerSearchType;
import com.ebay.soap.eBLBaseComponents.SellingManagerSoldListingsPropertyTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SellingManagerSoldListingsSortTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SellingManagerSoldOrderType;
import com.ebay.soap.eBLBaseComponents.SortOrderCodeType;
import com.ebay.soap.eBLBaseComponents.TimeRangeType;

public class GetSellingManagerSoldListingsBean extends EbayCallBean {
	// input
	private SellingManagerSearchType search = null;
	private Long storeCategoryID = null;
	private SellingManagerSoldListingsPropertyTypeCodeType[] filter = null;
	private Boolean archived = null;
	private SellingManagerSoldListingsSortTypeCodeType sort = null;
	private SortOrderCodeType sortOrder = null;
	private PaginationType pagination = null;
	private TimeRangeType saleDateRange = null;
	// output
	private SellingManagerSoldOrderType[] returnedSaleRecord = null;
	private PaginationResultType returnedPaginationResult = null;

	public SellingManagerSearchType getSearch() {
		return search;
	}

	public void setSearch(SellingManagerSearchType search) {
		this.search = search;
	}

	public Long getStoreCategoryID() {
		return storeCategoryID;
	}

	public void setStoreCategoryID(Long storeCategoryID) {
		this.storeCategoryID = storeCategoryID;
	}

	public SellingManagerSoldListingsPropertyTypeCodeType[] getFilter() {
		return filter;
	}

	public void setFilter(SellingManagerSoldListingsPropertyTypeCodeType[] filter) {
		this.filter = filter;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	public SellingManagerSoldListingsSortTypeCodeType getSort() {
		return sort;
	}

	public void setSort(SellingManagerSoldListingsSortTypeCodeType sort) {
		this.sort = sort;
	}

	public SortOrderCodeType getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(SortOrderCodeType sortOrder) {
		this.sortOrder = sortOrder;
	}

	public PaginationType getPagination() {
		return pagination;
	}

	public void setPagination(PaginationType pagination) {
		this.pagination = pagination;
	}

	public TimeRangeType getSaleDateRange() {
		return saleDateRange;
	}

	public void setSaleDateRange(TimeRangeType saleDateRange) {
		this.saleDateRange = saleDateRange;
	}

	public SellingManagerSoldOrderType[] getReturnedSaleRecord() {
		return returnedSaleRecord;
	}

	public void setReturnedSaleRecord(SellingManagerSoldOrderType[] returnedSaleRecord) {
		this.returnedSaleRecord = returnedSaleRecord;
	}

	public PaginationResultType getReturnedPaginationResult() {
		return returnedPaginationResult;
	}

	public void setReturnedPaginationResult(PaginationResultType returnedPaginationResult) {
		this.returnedPaginationResult = returnedPaginationResult;
	}

}
