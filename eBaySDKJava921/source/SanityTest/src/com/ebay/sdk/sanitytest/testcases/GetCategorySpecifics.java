/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.GetCategorySpecificsCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.soap.eBLBaseComponents.AckCodeType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.RecommendationsType;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class GetCategorySpecifics  extends SDKTestCase {

  public void testGetCategorySpecifics () throws Exception {

    GetCategorySpecificsCall api = new GetCategorySpecificsCall(this.apiContext);
    DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
            DetailLevelCodeType.RETURN_ALL
    };
    api.setDetailLevel(detailLevels);
    String[] catIds = new String[1];
    catIds[0] = "20714";
    api.setCategoryID(catIds);

    // Make API call.
    RecommendationsType[] recommendations = api.getCategorySpecifics();
    
    assertEquals(api.getResponseObject().getAck(),AckCodeType.SUCCESS);
    assertNotNull(recommendations);
    assertTrue(recommendations.length > 0);
  }
}
