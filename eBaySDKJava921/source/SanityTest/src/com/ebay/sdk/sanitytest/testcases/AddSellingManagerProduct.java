package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.AddSellingManagerProductCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.SellingManagerProductDetailsType;

public class AddSellingManagerProduct extends SDKTestCase{
	
	public void testAddSellingManagerProduct()throws Exception{
		assertNotNull(TestData.folder_id1);
		AddSellingManagerProductCall api = new AddSellingManagerProductCall(apiContext);
		SellingManagerProductDetailsType details = new SellingManagerProductDetailsType();
		details.setProductName("Product for test");
		details.setQuantityAvailable(10);
		api.setSellingManagerProductDetails(details);
		api.setFolderID(TestData.folder_id1);
		api.addSellingManagerProduct();
		long productId = api.getReturnedSellingManagerProductDetails().getProductID();
		assertTrue(10==api.getReturnedSellingManagerProductDetails().getQuantityAvailable());
		assertTrue("Product for test".equals(
				api.getReturnedSellingManagerProductDetails().getProductName()));
		assertNotNull(productId);
		TestData.productId = productId;
	}
}
