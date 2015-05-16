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
import test.ebay.sdk.helper.GetCategoryFeaturesHelperTests;
import test.ebay.sdk.helper.eBayDetailsHelperTests;

public class HelperTestSuite extends TestCase {
	public HelperTestSuite(String s) {
		super(s);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Helper Tests");
		suite.addTestSuite(GetCategoryFeaturesHelperTests.class);
		suite.addTestSuite(eBayDetailsHelperTests.class);
		
		return suite;
	}
}
