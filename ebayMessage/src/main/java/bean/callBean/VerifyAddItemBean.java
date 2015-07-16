package bean.callBean;

import com.ebay.soap.eBLBaseComponents.DiscountReasonCodeType;
import com.ebay.soap.eBLBaseComponents.ExpressItemRequirementsType;
import com.ebay.soap.eBLBaseComponents.FeesType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingRecommendationsType;
import com.ebay.soap.eBLBaseComponents.ProductSuggestionsType;

public class VerifyAddItemBean extends EbayCallBean {
	// input
	ItemType item;
	boolean includeExpressRequirements;

	// output
	String returnedItemID;
	FeesType returnedFees;
	boolean returnedExpressListing;
	ExpressItemRequirementsType returnedExpressItemRequirements;
	String returnedCategoryID;
	String returnedCategory2ID;
	DiscountReasonCodeType[] returnedDiscountReason;
	ProductSuggestionsType returnedProductSuggestions;
	ListingRecommendationsType returnedListingRecommendations;

}
