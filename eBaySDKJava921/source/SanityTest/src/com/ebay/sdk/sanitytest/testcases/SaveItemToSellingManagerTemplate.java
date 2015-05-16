package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.SaveItemToSellingManagerTemplateCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;

public class SaveItemToSellingManagerTemplate  extends SDKTestCase{
	
	public void testSaveItemToSellingManagerTemplate()throws Exception{
		assertNotNull(TestData.itemId);
		SaveItemToSellingManagerTemplateCall api = 
			new SaveItemToSellingManagerTemplateCall(apiContext);
		api.setItemID(TestData.itemId);
		api.setProductID(TestData.productId);
		api.saveItemToSellingManagerTemplate();
		assertNotNull(api.getReturnedTemplateID());
	}
}
