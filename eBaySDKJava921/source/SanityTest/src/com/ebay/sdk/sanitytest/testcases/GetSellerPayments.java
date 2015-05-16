/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.ebay.sdk.sanitytest.testcases;

import java.util.Calendar;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.call.GetSellerPaymentsCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.soap.eBLBaseComponents.AckCodeType;
import com.ebay.soap.eBLBaseComponents.GetSellerPaymentsResponseType;
import com.ebay.soap.eBLBaseComponents.RCSPaymentStatusCodeType;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weian Deng
 * @version 1.0
 */
public class GetSellerPayments extends SDKTestCase {

  public void testGetSellerPayments() throws Exception {

    // Make API call.
    ApiException gotException = null;

    try
    {
		GetSellerPaymentsCall api = new GetSellerPaymentsCall(this.apiContext);

		Calendar endDay = Calendar.getInstance();
		Calendar startDay = Calendar.getInstance();

		endDay.clear();
		endDay.set(2005,12,1,12,12);

		startDay.clear();
		startDay.set(2005,11,15,0,0);


		api.setPaymentTimeFrom(startDay);
		api.setPaymentTimeTo(endDay);
		api.setPaymentStatus(RCSPaymentStatusCodeType.PENDING);

		api.getSellerPayments();
		GetSellerPaymentsResponseType responseType = (GetSellerPaymentsResponseType) api.getResponseObject();
		this.assertEquals(AckCodeType.SUCCESS, responseType.getAck());
    }
    catch(ApiException ex)
    {
      gotException = ex;
    }

    this.assertNull(gotException);
  }
}
