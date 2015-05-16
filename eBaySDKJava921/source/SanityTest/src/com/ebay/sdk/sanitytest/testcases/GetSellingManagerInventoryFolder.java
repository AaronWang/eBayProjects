package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.GetSellingManagerInventoryFolderCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.SellingManagerFolderDetailsType;

public class GetSellingManagerInventoryFolder extends SDKTestCase{
	
	public void testGetSellingManagerInventoryFolder()throws Exception{
		assertNotNull(TestData.folder_id1);
		GetSellingManagerInventoryFolderCall api = new GetSellingManagerInventoryFolderCall(apiContext);
		api.getSellingManagerInventoryFolder();
		assertTrue(contains(TestData.folder_id1,api.getReturnedFolder()));
	}

	private boolean contains(Long folder_id1,
			SellingManagerFolderDetailsType returnedFolder) {
		SellingManagerFolderDetailsType[] folders = returnedFolder.getChildFolder();
		for(int i = 0 ; i<folders.length; i++){
			if(folders[i].getFolderID().compareTo(folder_id1) == 0){
				return true;
			}
		}
		return false;
	}
}
