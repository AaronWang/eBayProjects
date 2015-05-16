/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package test.ebay.sdk.helper;

import java.util.Enumeration;
import java.util.Hashtable;

import com.ebay.sdk.SdkException;
import com.ebay.sdk.helper.eBayDetailsHelper;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

public class eBayDetailsHelperTests extends SDKTestCase {
	
	public void test_EBayDetailsHelper_PaymentOption() throws SdkException {
        System.out.println("******* eBayDetailsHelperTests: test_EBayDetailsHelper_PaymentOption() START *******");
		eBayDetailsHelper helper = eBayDetailsHelper.getInstance();
		Hashtable paymentOptions = helper.getDetailEntryMapWithStringValue(SiteCodeType.US, "PaymentOption");
		assertNotNull(paymentOptions);
		assertTrue(paymentOptions.size() > 0);
	    Enumeration keys = paymentOptions.keys();
	    while(keys.hasMoreElements()) {
	    	String key = (String)keys.nextElement();
	        String option = (String)paymentOptions.get(key);
	        System.out.println("Key: " + key + " Option: " + option);
	    }
        System.out.println("******* eBayDetailsHelperTests: test_EBayDetailsHelper_PaymentOption() END *******");
	}		
	
	public void test_EBayDetailsHelper_CountryDetails() throws SdkException {
        System.out.println("******* eBayDetailsHelperTests: test_EBayDetailsHelper_CountryDetails() START *******");
		eBayDetailsHelper helper = eBayDetailsHelper.getInstance();
		Hashtable countryDetails = helper.getDetailEntryMapWithStringValue(SiteCodeType.US, "Region");
//		Hashtable countryDetails = helper.getDetailEntryMapWithStringValue(SiteCodeType.US, "Site");
		assertNotNull(countryDetails);
		assertTrue(countryDetails.size() > 0);
	    Enumeration keys = countryDetails.keys();
	    while(keys.hasMoreElements()) {
	    	String key = (String)keys.nextElement();
	        String option = (String)countryDetails.get(key);
	        System.out.println("Key: " + key + " Option: " + option);
	    }
        System.out.println("******* eBayDetailsHelperTests: test_EBayDetailsHelper_CountryDetails() END *******");
	}		
	public void _test_EBayDetailsHelper_ShippingServiceDetails() throws SdkException {
        System.out.println("******* eBayDetailsHelperTests: test_EBayDetailsHelper_ShippingServiceDetails() START *******");
		eBayDetailsHelper helper = eBayDetailsHelper.getInstance();
		Hashtable shipDetails = helper.getDetailEntryMapWithStringValue(SiteCodeType.US, "ShippingServiceDetails");
		assertNotNull(shipDetails);
		assertTrue(shipDetails.size() > 0);
	    Enumeration keys = shipDetails.keys();
 	    while(keys.hasMoreElements()) {
	    	String key = (String)keys.nextElement();
	        String option = (String)shipDetails.get(key);
	        System.out.println("Key: " + key + " Option: " + option);
	    }
        System.out.println("******* eBayDetailsHelperTests: test_EBayDetailsHelper_ShippingServiceDetails() END *******");
	}		
}
