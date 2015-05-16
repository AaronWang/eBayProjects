package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.MoveSellingManagerInventoryFolderCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;

public class MoveSellingManagerInventoryFolder extends SDKTestCase{

	public void testMoveSellingManagerInventoryFolder()throws Exception{
		assertNotNull(TestData.folder_id1);
		assertNotNull(TestData.folder_id2);
		MoveSellingManagerInventoryFolderCall api = 
			new MoveSellingManagerInventoryFolderCall(apiContext);
		api.setFolderID(TestData.folder_id2);
		api.setNewParentFolderID(TestData.folder_id1);
		api.moveSellingManagerInventoryFolder();
	}
}
