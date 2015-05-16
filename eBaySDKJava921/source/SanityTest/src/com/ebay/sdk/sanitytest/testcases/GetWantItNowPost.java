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
import com.ebay.sdk.call.*;
import com.ebay.sdk.sanitytest.*;
import com.ebay.soap.eBLBaseComponents.*;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weian Deng
 * @version 1.0
 */
public class GetWantItNowPost extends SDKTestCase {

  public void testGetWantItNowPost() throws Exception {

    // Make API call.
    ApiException gotException = null;

    try
    {
		GetWantItNowPostCall api = new GetWantItNowPostCall(this.apiContext);

		String postItem = "00000000000";
		//TODO:  should create WantItNowPost item on the fly. Currently because there is no way
		// to use API to create a WantItNowPost item, this is a negative test
		api.setPostID(postItem);

		api.getWantItNowPost();

		GetWantItNowPostResponseType responseType = (GetWantItNowPostResponseType) api.getResponseObject();
	  this.assertEquals(AckCodeType.FAILURE, responseType.getAck());
    }
    catch(ApiException ex)
    {
      gotException = ex;
    }

    this.assertNotNull(gotException);
  }
}
