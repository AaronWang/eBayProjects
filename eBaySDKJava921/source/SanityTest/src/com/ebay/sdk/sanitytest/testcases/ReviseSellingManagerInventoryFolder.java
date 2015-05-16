package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.ReviseSellingManagerInventoryFolderCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.SellingManagerFolderDetailsType;

public class ReviseSellingManagerInventoryFolder extends SDKTestCase{
	
	public void testReviseSellingManagerInventoryFolder()throws Exception{
		assertNotNull(TestData.folder_id2);
		ReviseSellingManagerInventoryFolderCall api = 
			new ReviseSellingManagerInventoryFolderCall(apiContext);
		SellingManagerFolderDetailsType folder = new SellingManagerFolderDetailsType();
		folder.setFolderID(TestData.folder_id2);
		folder.setFolderName("Revise folder by selling manager call");
		api.setFolder(folder);
		api.reviseSellingManagerInventoryFolder();
		assertNotNull(api.getReturnedFolder());
	}
}
