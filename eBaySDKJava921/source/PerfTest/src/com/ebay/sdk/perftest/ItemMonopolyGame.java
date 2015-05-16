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

public class ItemMonopolyGame {

	// this method creates the item definition for a cd
	// for demonstration purposes only
	// your application might get this info from a database
	// or other data source
	public ItemType buildItem() {
		
		ItemType myItem = new ItemType();
		
		// define some needed values
		CategoryType cat = new CategoryType();
		cat.setCategoryID("14111");
		
		ShippingDetailsType shipDetails = new ShippingDetailsType();
		shipDetails.setChangePaymentInstructions(new Boolean(true));
		
		BuyerPaymentMethodCodeType[] payments = new BuyerPaymentMethodCodeType[1];
		payments[0] = BuyerPaymentMethodCodeType.PAY_PAL;
		
		// set these and other values in the item
		// myItem.setSite(SiteCodeType.US);
		myItem.setPrimaryCategory( cat );
		myItem.setShippingDetails(shipDetails);
		myItem.setCountry(CountryCodeType.US);
		myItem.setCurrency(CurrencyCodeType.USD);
		myItem.setDescription("Test listing - do not bid");
		myItem.setListingDuration(ListingDurationCodeType.DAYS_1.value());
		myItem.setLocation("New York, NY");
		myItem.setLotSize( new Integer(5));
		AmountType at = new AmountType();
		at.setValue(new Double("15").doubleValue());
		myItem.setStartPrice(at);
		myItem.setPaymentMethods(payments);
		myItem.setQuantity( new Integer(1));
		myItem.setRegionID("34");
		myItem.setTitle("Test Listing");
		myItem.setPayPalEmailAddress("me@ebay.com");
		
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

