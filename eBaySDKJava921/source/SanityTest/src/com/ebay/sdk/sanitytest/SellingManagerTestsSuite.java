/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.sanitytest;

import com.ebay.sdk.sanitytest.testcases.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SellingManagerTestsSuite extends TestCase{
	public SellingManagerTestsSuite(String s) {
	    super(s);
	  }
	public static Test suite() {

		TestSuite suite = new TestSuite("Selling manager Tests");

		suite.addTestSuite(AddSellingManagerInventoryFolder.class);
		suite.addTestSuite(AddSellingManagerProduct.class);
		suite.addTestSuite(AddSellingManagerTemplate.class);
		suite.addTestSuite(AddItemFromSellingManagerTemplate.class);
		suite.addTestSuite(SetSellingManagerTemplateAutomationRule.class);
		suite.addTestSuite(SetSellingManagerItemAutomationRule.class);
		suite.addTestSuite(SetSellingManagerFeedbackOptions.class);
		suite.addTestSuite(GetSellingManagerAlerts.class);
		suite.addTestSuite(GetSellingManagerEmailLog.class);
		suite.addTestSuite(GetSellingManagerInventory.class);
		suite.addTestSuite(GetSellingManagerInventoryFolder.class);
		suite.addTestSuite(GetSellingManagerItemAutomationRule.class);
		suite.addTestSuite(GetSellingManagerSoldListings.class);
		suite.addTestSuite(GetSellingManagerSaleRecord.class);
		suite.addTestSuite(GetSellingManagerTemplateAutomationRule.class);
		suite.addTestSuite(GetSellingManagerTemplates.class);
		suite.addTestSuite(SaveItemToSellingManagerTemplate.class);
		suite.addTestSuite(ReviseSellingManagerTemplate.class);
		suite.addTestSuite(ReviseSellingManagerSaleRecord.class);
		suite.addTestSuite(ReviseSellingManagerProduct.class);
		suite.addTestSuite(ReviseSellingManagerInventoryFolder.class);
		suite.addTestSuite(MoveSellingManagerInventoryFolder.class);
		suite.addTestSuite(DeleteSellingManagerTemplateAutomationRule.class);
		suite.addTestSuite(DeleteSellingManagerItemAutomationRule.class);
		suite.addTestSuite(DeleteSellingManagerTemplate.class);
		suite.addTestSuite(DeleteSellingManagerProduct.class);
		suite.addTestSuite(DeleteSellingManagerInventoryFolder.class);
		
		return suite;
	  }
}
