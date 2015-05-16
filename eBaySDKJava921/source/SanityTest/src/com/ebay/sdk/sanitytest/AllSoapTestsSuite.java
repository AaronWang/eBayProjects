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
public class AllSoapTestsSuite extends TestCase {

  public AllSoapTestsSuite(String s) {
    super(s);
  }

  public static Test suite() {
    TestSuite suite = new TestSuite("All SDK Tests");
    
    suite.addTest(MessageTestsSuite.suite());
    suite.addTest(OtherTestsSuite.suite());
    suite.addTest(CategoryTestsSuite.suite());
    suite.addTest(ItemTestsSuite.suite());
    suite.addTest(MyeBayTestsSuite.suite());
    suite.addTest(FeedbackTestsSuite.suite());
    suite.addTest(TransactionTestsSuite.suite()); 
    suite.addTest(DisputeTestsSuite.suite());
    suite.addTest(StoreTestsSuite.suite());
    suite.addTest(HelperTestSuite.suite());
    suite.addTest(SellingManagerTestsSuite.suite());
    return suite;
  }
}
