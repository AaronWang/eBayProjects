package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.DeleteSellingManagerTemplateCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;

public class DeleteSellingManagerTemplate extends SDKTestCase{

	public void testDeleteSellingManagerTemplate() throws Exception{
		assertNotNull(TestData.saleTemplateId);
		DeleteSellingManagerTemplateCall api = 
			new DeleteSellingManagerTemplateCall(apiContext);
		api.setSaleTemplateID(TestData.saleTemplateId);
		api.deleteSellingManagerTemplate();
		assertEquals(com.ebay.soap.eBLBaseComponents.AckCodeType.SUCCESS,
				api.getResponseObject().getAck());
	}
}
