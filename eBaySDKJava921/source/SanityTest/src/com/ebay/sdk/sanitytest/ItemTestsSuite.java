/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk.sanitytest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class ItemTestsSuite extends TestCase {

  public ItemTestsSuite(String s) {
    super(s);
  } 

  public static Test suite() {

	TestSuite suite = new TestSuite("Item Tests");

	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.AddItem.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.AddItems.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.AddFixedPriceItem.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetItem.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetItemRecommendations.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.AddToItemDescription.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.SetUserNotes.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.ReviseItem.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.PlaceOffer.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetCrossPromotions.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetPromotionRules.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetItemShipping.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.AddToWatchList.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.RemoveFromWatchList.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.EndItem.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.EndItems.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.RelistItem.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetSellerList.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetAdFormatLeads.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.AddSecondChanceItem.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetSellerEvents.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.AddTransactionConfirmationItem.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetShippingDiscountProfiles.class);
	
	return suite;
  }
}
