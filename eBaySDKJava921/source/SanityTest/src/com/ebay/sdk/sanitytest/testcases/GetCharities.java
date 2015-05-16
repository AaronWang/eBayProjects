/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.*;
import com.ebay.sdk.sanitytest.*;
import com.ebay.soap.eBLBaseComponents.*;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class GetCharities extends SDKTestCase {

  public void testGetCharities() throws Exception {

    GetCharitiesCall api = new GetCharitiesCall(this.apiContext);

    GetCharitiesRequestType req = new GetCharitiesRequestType();
    req.setIncludeDescription(new Boolean(false));
    req.setCharityRegion(new Integer(7));
    req.setQuery("eBay");

    api.setOverrideRequest(req);

    // Make API call.
    api.getCharities();

    CharityInfoType[] charities = api.getReturnedCharities();
  }
}
