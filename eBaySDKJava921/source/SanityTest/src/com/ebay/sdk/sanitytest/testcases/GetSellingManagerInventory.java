package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.GetSellingManagerInventoryCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;

public class GetSellingManagerInventory extends SDKTestCase{
	
	public void testGetSellingManagerInventory() throws Exception{
		assertNotNull(TestData.folder_id1);
		GetSellingManagerInventoryCall api = new GetSellingManagerInventoryCall(apiContext);
		api.setFolderID(TestData.folder_id1);
		api.getSellingManagerInventory();
		assertNotNull(api.getReturnedSellingManagerProduct());
		assertNotNull(api.getReturnedPaginationResult());
	}
}
