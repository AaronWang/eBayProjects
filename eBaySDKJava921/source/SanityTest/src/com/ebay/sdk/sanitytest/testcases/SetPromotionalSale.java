package com.ebay.sdk.sanitytest.testcases;

import java.util.Calendar;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.SetPromotionalSaleCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.DiscountCodeType;
import com.ebay.soap.eBLBaseComponents.ModifyActionCodeType;
import com.ebay.soap.eBLBaseComponents.PromotionalSaleStatusCodeType;
import com.ebay.soap.eBLBaseComponents.PromotionalSaleType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

public class SetPromotionalSale extends SDKTestCase {
	 public void testSetPromotionalSale() throws Exception {
		 SetPromotionalSaleCall promotionalSale = new SetPromotionalSaleCall(apiContext);
		 promotionalSale.setAction(ModifyActionCodeType.ADD);
		 promotionalSale.setSite(SiteCodeType.US);
		 PromotionalSaleType promoSaleType = new PromotionalSaleType();
		 promoSaleType.setDiscountType(DiscountCodeType.PRICE);
		 promoSaleType.setDiscountValue(new Double(123.45));
		 Calendar startTime = Calendar.getInstance();
		 Calendar endTime = startTime;
		 endTime.add(Calendar.DAY_OF_YEAR, 7);
		 promoSaleType.setPromotionalSaleStartTime(startTime);
		 promoSaleType.setPromotionalSaleEndTime(endTime);
		 promoSaleType.setPromotionalSaleID(new Long(1234567890L));
		 promoSaleType.setPromotionalSaleName("Promo Sale");
		 promotionalSale.setPromotionalSaleDetails(promoSaleType);
		 try {
			 PromotionalSaleStatusCodeType resp = promotionalSale.setPromotionalSale();
		 } catch(ApiException apie) {
			 // got thru
		 } catch(SdkException sdke) {
			 fail(sdke.getMessage());
		 }
	 }
}
