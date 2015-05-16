/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.sanitytest;

public class SanityTestNonGUIRunner {
	
	  public SanityTestNonGUIRunner() {
	    try {
	      jbInit();
	    }
	    catch (Exception ex) {
	      ex.printStackTrace();
	    }
	  }

	  public static void main(String[] args) {
	    try {
	      TestContext context = TestContext.getTestContext();
	      context.saveConfiguration();
	      junit.textui.TestRunner runner = new junit.textui.TestRunner();
	      runner.start( new String[]{"-noloading", AllSoapTestsSuite.class.getName()} );
	    } catch(Exception e) {
	      e.printStackTrace();
	    }
	  }

	  private void jbInit() throws Exception {
	  }
}
