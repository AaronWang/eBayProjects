package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.AddItemFromSellingManagerTemplateCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.ItemType;

public class AddItemFromSellingManagerTemplate extends SDKTestCase{
	
	public void testAddItemFromSellingManagerTemplate()throws Exception{
		assertNotNull(TestData.saleTemplateId);
		Long templateId = TestData.saleTemplateId;
		ItemType item = new ItemType();
		AddItemFromSellingManagerTemplateCall api = new AddItemFromSellingManagerTemplateCall(apiContext);
		item.setTitle("Selling Manager Item");
		api.setItem(item);
		api.setSaleTemplateID(templateId);
		api.addItemFromSellingManagerTemplate();
		assertNotNull(api.getReturnedItemID());
		assertNotNull(api.getReturnedFees());
		TestData.itemId = api.getReturnedItemID();
	}
}
