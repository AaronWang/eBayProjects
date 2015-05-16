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

import com.ebay.sdk.sanitytest.testcases.HTTPSProtocolTester;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class OtherTestsSuite
    extends TestCase {

  public OtherTestsSuite(String s) {
    super(s);
  }

  public static Test suite() {

    TestSuite suite = new TestSuite("Other Tests");

    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.SiteHostedPicturesTest.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GeteBayOfficialTime.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetApiAccessRules.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetNotificationPreferences.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.SetNotificationPreferences.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetUser.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetUserPreferences.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.SetUserPreferences.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetTaxTable.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.SetTaxTable.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetDescriptionTemplates.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetAccount.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.FetchToken.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GeteBayDetails.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetCharities.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetNotificationsUsage.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetWantItNowPost.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetWantItNowSearchResults.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.RespondToWantItNowPost.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetUserContactDetails.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetContextualKeywords.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetChallengeToken.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.ValidateChallengeInput.class);
	suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.SOAPError.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetVeROReasonCodeDetails.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetVeROReportStatus.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.VeROReportItems.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetPromotionalSaleDetails.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.SetPromotionalSaleListings.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.SetShippingDiscountProfiles.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.SetPromotionalSale.class);
    suite.addTestSuite(HTTPSProtocolTester.class);
    
    return suite;
  }
}
