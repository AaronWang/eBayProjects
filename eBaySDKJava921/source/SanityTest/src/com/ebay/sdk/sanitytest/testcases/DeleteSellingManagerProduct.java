package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.DeleteSellingManagerProductCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;

public class DeleteSellingManagerProduct extends SDKTestCase{

	public void testDeleteSellingManagerProduct() throws Exception{
		assertNotNull(TestData.productId);
		DeleteSellingManagerProductCall api = 
			new DeleteSellingManagerProductCall(apiContext);
		api.setProductID(TestData.productId);
		api.deleteSellingManagerProduct();
		assertEquals(com.ebay.soap.eBLBaseComponents.AckCodeType.SUCCESS,
				api.getResponseObject().getAck());
	}
}
