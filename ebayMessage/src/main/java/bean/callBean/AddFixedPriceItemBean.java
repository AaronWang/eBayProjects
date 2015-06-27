package bean.callBean;

import java.util.Calendar;

import com.ebay.soap.eBLBaseComponents.DiscountReasonCodeType;
import com.ebay.soap.eBLBaseComponents.FeesType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingRecommendationsType;
import com.ebay.soap.eBLBaseComponents.ProductSuggestionsType;

public class AddFixedPriceItemBean extends EbayCallBean {

	// input, required
	ItemType item;

	// output
	String returnedItemID;
	String returnedSKU;
	Calendar returnedStartTime;
	Calendar returnedEndTime;
	FeesType returnedFees;
	String returnedCategoryID;
	String returnedCategory2ID;// if the second category in list
	DiscountReasonCodeType[] returnedDiscountReason;
	ProductSuggestionsType returnedProductSuggestions;
	ListingRecommendationsType returnedListingRecommendations;

	public ItemType getItem() {
		return item;
	}

	public void setItem(ItemType item) {
		this.item = item;
	}

	public String getReturnedItemID() {
		return returnedItemID;
	}

	public void setReturnedItemID(String returnedItemID) {
		this.returnedItemID = returnedItemID;
	}

	public Calendar getReturnedStartTime() {
		return returnedStartTime;
	}

	public void setReturnedStartTime(Calendar returnedStartTime) {
		this.returnedStartTime = returnedStartTime;
	}

	public Calendar getReturnedEndTime() {
		return returnedEndTime;
	}

	public void setReturnedEndTime(Calendar returnedEndTime) {
		this.returnedEndTime = returnedEndTime;
	}

	public FeesType getReturnedFees() {
		return returnedFees;
	}

	public void setReturnedFees(FeesType returnedFees) {
		this.returnedFees = returnedFees;
	}

	public String getReturnedCategoryID() {
		return returnedCategoryID;
	}

	public void setReturnedCategoryID(String returnedCategoryID) {
		this.returnedCategoryID = returnedCategoryID;
	}

	public String getReturnedCategory2ID() {
		return returnedCategory2ID;
	}

	public void setReturnedCategory2ID(String returnedCategory2ID) {
		this.returnedCategory2ID = returnedCategory2ID;
	}

	public DiscountReasonCodeType[] getReturnedDiscountReason() {
		return returnedDiscountReason;
	}

	public void setReturnedDiscountReason(DiscountReasonCodeType[] returnedDiscountReason) {
		this.returnedDiscountReason = returnedDiscountReason;
	}

	public ProductSuggestionsType getReturnedProductSuggestions() {
		return returnedProductSuggestions;
	}

	public void setReturnedProductSuggestions(ProductSuggestionsType returnedProductSuggestions) {
		this.returnedProductSuggestions = returnedProductSuggestions;
	}

	public ListingRecommendationsType getReturnedListingRecommendations() {
		return returnedListingRecommendations;
	}

	public void setReturnedListingRecommendations(ListingRecommendationsType returnedListingRecommendations) {
		this.returnedListingRecommendations = returnedListingRecommendations;
	}

	public String getReturnedSKU() {
		return returnedSKU;
	}

	public void setReturnedSKU(String returnedSKU) {
		this.returnedSKU = returnedSKU;
	}

}
