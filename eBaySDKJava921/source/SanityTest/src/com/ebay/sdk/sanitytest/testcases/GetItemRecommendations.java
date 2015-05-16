/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.GetItemCall;
import com.ebay.sdk.call.GetItemRecommendationsCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.AckCodeType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.GetRecommendationsRequestContainerType;
import com.ebay.soap.eBLBaseComponents.GetRecommendationsResponseContainerType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingFlowCodeType;
import com.ebay.soap.eBLBaseComponents.ProductFamilyType;
import com.ebay.soap.eBLBaseComponents.ProductListingDetailsType;
import com.ebay.soap.eBLBaseComponents.ProductType;
import com.ebay.soap.eBLBaseComponents.RecommendationEngineCodeType;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class GetItemRecommendations extends SDKTestCase {

	public void testGetItemRecommendations()throws Exception{
		  GetItemRecommendationsCall api = new GetItemRecommendationsCall(apiContext);
		  
		  //test for suggested attributes Engine
		  ItemType item_sae = new ItemType();
		  CategoryType category_sae = new CategoryType();
		  category_sae.setCategoryID("279");
		  item_sae.setPrimaryCategory(category_sae);
		  GetRecommendationsRequestContainerType reqContainer_sae = new GetRecommendationsRequestContainerType();
		  reqContainer_sae.setItem(item_sae);
		  reqContainer_sae.setQuery("Harry Potter");
		  reqContainer_sae.setRecommendationEngine(new RecommendationEngineCodeType[]{RecommendationEngineCodeType.SUGGESTED_ATTRIBUTES});
		  api.setRecommendationsRequests(new GetRecommendationsRequestContainerType[]{reqContainer_sae});
		  api.getItemRecommendations();
		  GetRecommendationsResponseContainerType[] resps_sae = api.getReturnedRecommendations();
		  assertTrue(api.getResponseObject().getAck()==AckCodeType.SUCCESS||api.getResponseObject().getAck()==AckCodeType.WARNING);
		  assertTrue(resps_sae.length>0);
		  assertNotNull(resps_sae[0].getAttributeRecommendations());
		  
		  //test for listing analyzer Engine
		  ItemType item_lae = new ItemType();
		  CategoryType category_lae = new CategoryType();
		  category_lae.setCategoryID("279");
		  item_lae.setPrimaryCategory(category_lae);
		  GetRecommendationsRequestContainerType reqContainer_lae = new GetRecommendationsRequestContainerType();
		  reqContainer_lae.setItem(item_lae);
		  reqContainer_lae.setListingFlow(ListingFlowCodeType.ADD_ITEM);
		  reqContainer_lae.setRecommendationEngine(new RecommendationEngineCodeType[]{RecommendationEngineCodeType.LISTING_ANALYZER});
		  api.setRecommendationsRequests(new GetRecommendationsRequestContainerType[]{reqContainer_lae});
		  api.getItemRecommendations();
		  GetRecommendationsResponseContainerType[] resps_lae = api.getReturnedRecommendations();
		  assertTrue(api.getResponseObject().getAck()==AckCodeType.SUCCESS || api.getResponseObject().getAck()==AckCodeType.WARNING);
		  assertTrue(resps_lae.length>0);
		  assertNotNull(resps_lae[0].getListingAnalyzerRecommendations());
	  }
}
