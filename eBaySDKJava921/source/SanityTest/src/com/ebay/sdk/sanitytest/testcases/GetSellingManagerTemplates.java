package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.GetSellingManagerTemplatesCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;

public class GetSellingManagerTemplates extends SDKTestCase{
	
	public void testGetSellingManagerTemplates()throws Exception{
		assertNotNull(TestData.saleTemplateId);
		GetSellingManagerTemplatesCall api = new GetSellingManagerTemplatesCall(apiContext);
		api.setSaleTemplateID(new long[]{TestData.saleTemplateId});
		api.getSellingManagerTemplates();
		assertNotNull(api.getReturnedSellingManagerTemplateDetailsArray());
		assertNotNull(api.getReturnedSellingManagerTemplateDetailsArray().
				getSellingManagerTemplateDetails());
		assertTrue(api.getReturnedSellingManagerTemplateDetailsArray().
				getSellingManagerTemplateDetailsLength() > 0);
	}
}
