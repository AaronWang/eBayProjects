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
public class MessageTestsSuite extends TestCase {

  public MessageTestsSuite(String s) {
    super(s);
  }

  public static Test suite() {

    TestSuite suite = new TestSuite("Message Tests");
    
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetUser.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetMemberMessages.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetMyMessages.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.DeleteMyMessages.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.ReviseMyMessages.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.ReviseMyMessagesFolders.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.AddMemberMessagesAAQToBidder.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.AddMemberMessageAAQToPartner.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.AddMemberMessageRTQ.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.GetMessagePreferences.class);
    suite.addTestSuite(com.ebay.sdk.sanitytest.testcases.SetMessagePreferences.class);

    return suite;
  }
}
