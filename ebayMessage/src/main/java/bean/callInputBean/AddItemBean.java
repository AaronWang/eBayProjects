package bean.callInputBean;

import java.util.Calendar;

import com.ebay.soap.eBLBaseComponents.DiscountReasonCodeType;
import com.ebay.soap.eBLBaseComponents.FeesType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingRecommendationsType;
import com.ebay.soap.eBLBaseComponents.ProductSuggestionsType;

public class AddItemBean extends AbstractInputBean {
	
	// input, required
	ItemType item;
	
	// output
	String returnedItemID;
	String returnedSKU;// custom label
	Calendar returnedStartTime;
	Calendar returnedEndTime;
	FeesType returnedFees;
	String returnedCategoryID;
	String returnedCategory2ID;// if the second category in list
	DiscountReasonCodeType[] returnedDiscountReason;
	ProductSuggestionsType returnedProductSuggestions;
	ListingRecommendationsType returnedListingRecommendations;
	
}
