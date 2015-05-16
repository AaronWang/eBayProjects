/*
Copyright (c) 2006 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and 
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent 
version thereof released by eBay.  The then-current version of the License 
can be found at https://www.codebase.ebay.com/Licenses.html and in the 
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.ebay.sdk.perftest;
import com.ebay.soap.eBLBaseComponents.*;


/**
 * 
 * @author Suzanne Ahmed   suzanne.ahmed@ebay.com
 * 
 */

public class ItemNecklace {

	// this method creates the item definition for a cd
	// for demonstration purposes only
	// your application might get this info from a database
	// or other data source
	public ItemType buildItem() {
		
		ItemType myItem = new ItemType();
		
		// Category
		CategoryType cat = new CategoryType();
		cat.setCategoryID("92827");      // call GetCategories
		myItem.setPrimaryCategory(cat);
	
		// CheckoutDetailsSpecified = 0
		ShippingDetailsType shipDetails = new ShippingDetailsType();
		shipDetails.setChangePaymentInstructions(new Boolean(false));
		myItem.setShippingDetails(shipDetails);
		
		myItem.setCountry(CountryCodeType.US);
		myItem.setCurrency(CurrencyCodeType.USD);
		
		myItem.setDescription("Two strands of sparkling pink tourmaline and rose quartz on 18K gold");
		myItem.setListingDuration(ListingDurationCodeType.DAYS_7.value());
		myItem.setLocation("New York, NY");
		AmountType at = new AmountType();
		at.setValue(new Double("100").doubleValue());
		myItem.setStartPrice(at);
		
		BuyerPaymentMethodCodeType[] payments = new BuyerPaymentMethodCodeType[2];
		payments[0] = BuyerPaymentMethodCodeType.PAY_PAL;
		payments[1] = BuyerPaymentMethodCodeType.VISA_MC;
		myItem.setPaymentMethods(payments);
		myItem.setPayPalEmailAddress("tiffany@tiffany.com");
		
		myItem.setQuantity( new Integer(1));
		myItem.setRegionID("60");
		myItem.setTitle("Pink tourmaline on 18k gold necklace");
		
		//domestic shipping service must be specified
		myItem.setShippingDetails(PerformanceTest.getShippingDetails());
		
		myItem.setConditionID(1000);
		
	    //fill in mandatory fields
	    //handling time
	    myItem.setDispatchTimeMax(Integer.valueOf(1));
	    //return policy
	    ReturnPolicyType returnPolicy = new ReturnPolicyType();
	    returnPolicy.setReturnsAcceptedOption("ReturnsAccepted");
	    myItem.setReturnPolicy(returnPolicy);
		
		return myItem;
		
	}
 }

