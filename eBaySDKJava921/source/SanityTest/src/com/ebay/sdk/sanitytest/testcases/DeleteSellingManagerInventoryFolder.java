package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.DeleteSellingManagerInventoryFolderCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;

public class DeleteSellingManagerInventoryFolder extends SDKTestCase{

	public void testDeleteSellingManagerInventoryFolder() throws Exception{
		assertNotNull(TestData.folder_id1);
		DeleteSellingManagerInventoryFolderCall api =
			new DeleteSellingManagerInventoryFolderCall(apiContext);
		api.setFolderID(TestData.folder_id1);
		api.deleteSellingManagerInventoryFolder();
		assertEquals(com.ebay.soap.eBLBaseComponents.AckCodeType.SUCCESS,
				api.getResponseObject().getAck());
	}
}
