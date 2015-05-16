package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.ReviseSellingManagerTemplateCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.ItemType;

public class ReviseSellingManagerTemplate extends SDKTestCase{

	public void testReviseSellingManagerTemplate() throws Exception{
		assertNotNull(TestData.saleTemplateId);
		ReviseSellingManagerTemplateCall api = 
			new ReviseSellingManagerTemplateCall(apiContext);
		ItemType item = new ItemType();
		item.setItemID(TestData.itemId);
		item.setDescription("Modified by selling manager call.");
		api.setItem(item);
		api.setSaleTemplateID(TestData.saleTemplateId);
		//api.reviseSellingManagerTemplate();
	}
}
