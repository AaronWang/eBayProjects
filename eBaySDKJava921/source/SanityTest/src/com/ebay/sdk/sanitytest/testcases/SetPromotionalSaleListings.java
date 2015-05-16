package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.SetPromotionalSaleListingsCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.soap.eBLBaseComponents.ModifyActionCodeType;

public class SetPromotionalSaleListings extends SDKTestCase {
	 public void testSetPromotionalSaleListings() throws Exception {
		 SetPromotionalSaleListingsCall promoSaleListings = new SetPromotionalSaleListingsCall(apiContext);
		 promoSaleListings.setAction(ModifyActionCodeType.ADD);
		 promoSaleListings.setAllFixedPriceItems(Boolean.TRUE);
		 promoSaleListings.setAllStoreInventoryItems(Boolean.TRUE);
		 promoSaleListings.setPromotionalSaleID(new Long(1234567890L));
		 try {
			 promoSaleListings.setPromotionalSaleListings();
		 } catch(ApiException apie) {
			 // got thru
		 } catch(SdkException sdke) {
			 fail(sdke.getMessage());
		 }
	 }
}
