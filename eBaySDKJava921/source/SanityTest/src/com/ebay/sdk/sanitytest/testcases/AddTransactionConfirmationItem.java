/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.call.AddTransactionConfirmationItemCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.SecondChanceOfferDurationCodeType;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class AddTransactionConfirmationItem extends SDKTestCase {
	//this call is used to create a TCR. 
	//An item is eligible to be used in a TCR if the item has been listed for at least 24 hours. 
  public void testAddTransactionConfirmationItem() throws Exception {

    AddTransactionConfirmationItemCall api = new AddTransactionConfirmationItemCall(this.apiContext);

    AmountType a = new AmountType();
    a.setValue(2.0);
    a.setCurrencyID(CurrencyCodeType.USD);

    api.setComments("Comment");
    String id = "1111111111";
    api.setItemID(id);
    api.setListingDuration(SecondChanceOfferDurationCodeType.DAYS_7);
    api.setNegotiatedPrice(a);
    api.setRecipientPostalCode("94566");
    api.setRecipientRelationType("1");
    api.setRecipientUserID("apitest20");
    api.setVerifyEligibilityOnly("true");
    // Negative test.
    ApiException gotException = null;
    try
    {
      api.addTransactionConfirmationItem();
    }
    catch(ApiException ex)
    {
      gotException = ex;
    }
    this.assertNotNull(gotException);
  }
}
