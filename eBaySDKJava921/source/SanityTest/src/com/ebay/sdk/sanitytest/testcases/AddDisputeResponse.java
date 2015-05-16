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
 * @author Weijun Li
 * @version 1.0
 */
public class AddDisputeResponse extends SDKTestCase {

  public void testAddDisputeResponse() throws Exception {

    AddDisputeResponseCall api = new AddDisputeResponseCall(this.apiContext);

    api.setDisputeActivity(DisputeActivityCodeType.SELLER_SHIPPED_ITEM);
    api.setShipmentTrackNumber("0000-1111");
    api.setShippingCarrierUsed("UPS");
    java.util.Calendar calTo = java.util.Calendar.getInstance();
    api.setShippingTime(calTo);

    String id = "Test";
    api.setDisputeID(id);
    api.setMessageText("SDK test dispute response");

    // Make API call.
    ApiException gotException = null;

    try
    {
      api.addDisputeResponse();
    }
    catch(ApiException ex)
    {
      gotException = ex;
    }

    this.assertNotNull(gotException);
  }
}
