package bean.callBean;

import java.util.Calendar;

import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.GetCategoriesResponseType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

public class GetCategoriesBean extends EbayCallBean {
	private SiteCodeType categorySiteID = null;
	private String[] parentCategories = null;
	private int levelLimit = 0;
	private Boolean viewAllNodes = null;

	private CategoryType[] returnedCategoryArray = null;
	private Integer returnedCategoryCount = null;
	private Calendar returnedCategoryUpdateTime = null;
	private String returnedCategoryVersion = null;
	private Boolean returnedReservePriceAllowed = null;
	private Double minimumReservePrice = null;
	private Boolean returnedReduceReserveAllowed = null;

	private GetCategoriesResponseType response;

	public SiteCodeType getCategorySiteID() {
		return categorySiteID;
	}

	public void setCategorySiteID(SiteCodeType categorySiteID) {
		this.categorySiteID = categorySiteID;
	}

	public String[] getParentCategories() {
		return parentCategories;
	}

	public void setParentCategories(String[] parentCategories) {
		this.parentCategories = parentCategories;
	}

	public int getLevelLimit() {
		return levelLimit;
	}

	public void setLevelLimit(int levelLimit) {
		this.levelLimit = levelLimit;
	}

	public Boolean getViewAllNodes() {
		return viewAllNodes;
	}

	public void setViewAllNodes(Boolean viewAllNodes) {
		this.viewAllNodes = viewAllNodes;
	}

	public CategoryType[] getReturnedCategoryArray() {
		return returnedCategoryArray;
	}

	public void setReturnedCategoryArray(CategoryType[] returnedCategoryArray) {
		this.returnedCategoryArray = returnedCategoryArray;
	}

	public Integer getReturnedCategoryCount() {
		return returnedCategoryCount;
	}

	public void setReturnedCategoryCount(Integer returnedCategoryCount) {
		this.returnedCategoryCount = returnedCategoryCount;
	}

	public Calendar getReturnedCategoryUpdateTime() {
		return returnedCategoryUpdateTime;
	}

	public void setReturnedCategoryUpdateTime(Calendar returnedCategoryUpdateTime) {
		this.returnedCategoryUpdateTime = returnedCategoryUpdateTime;
	}

	public String getReturnedCategoryVersion() {
		return returnedCategoryVersion;
	}

	public void setReturnedCategoryVersion(String returnedCategoryVersion) {
		this.returnedCategoryVersion = returnedCategoryVersion;
	}

	public Boolean getReturnedReservePriceAllowed() {
		return returnedReservePriceAllowed;
	}

	public void setReturnedReservePriceAllowed(Boolean returnedReservePriceAllowed) {
		this.returnedReservePriceAllowed = returnedReservePriceAllowed;
	}

	public Double getMinimumReservePrice() {
		return minimumReservePrice;
	}

	public void setMinimumReservePrice(Double minimumReservePrice) {
		this.minimumReservePrice = minimumReservePrice;
	}

	public Boolean getReturnedReduceReserveAllowed() {
		return returnedReduceReserveAllowed;
	}

	public void setReturnedReduceReserveAllowed(Boolean returnedReduceReserveAllowed) {
		this.returnedReduceReserveAllowed = returnedReduceReserveAllowed;
	}

	public GetCategoriesResponseType getResponse() {
		return response;
	}

	public void setResponse(GetCategoriesResponseType response) {
		this.response = response;
	}

}
