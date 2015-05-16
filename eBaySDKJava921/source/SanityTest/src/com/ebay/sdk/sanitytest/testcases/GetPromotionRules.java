/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.GetPromotionRulesCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.AckCodeType;
import com.ebay.soap.eBLBaseComponents.PromotionMethodCodeType;
import com.ebay.soap.eBLBaseComponents.PromotionRuleType;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class GetPromotionRules extends SDKTestCase {

  public void testGetPromotionRules() throws Exception {

    GetPromotionRulesCall api = new GetPromotionRulesCall(this.apiContext);

    api.setPromotionMethod(PromotionMethodCodeType.CROSS_SELL);

    PromotionRuleType[] rules = null;
    // Make API call.
    try {
    	api.getPromotionRules();
    } catch(Exception e) {
    	fail("Error executing GetPromotionRules");
    }

    rules = api.getReturnedPromotionRule();
    assertEquals(api.getResponseObject().getAck(),AckCodeType.SUCCESS);
    if(rules != null) {
    	TestData.ItemPromotionRule = rules[0];
    }

  }
}
