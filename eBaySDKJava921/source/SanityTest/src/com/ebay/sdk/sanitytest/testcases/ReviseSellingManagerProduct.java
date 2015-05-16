package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.ReviseSellingManagerProductCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.SellingManagerProductDetailsType;

public class ReviseSellingManagerProduct extends SDKTestCase{

	public void testReviseSellingManagerProduct() throws Exception{
		assertNotNull(TestData.productId);
		ReviseSellingManagerProductCall api = 
			new ReviseSellingManagerProductCall(apiContext);
		SellingManagerProductDetailsType sellingManagerProductDetails =
			new SellingManagerProductDetailsType();
		sellingManagerProductDetails.setProductID(TestData.productId);
		sellingManagerProductDetails.setProductName("Revise product by selling manager call");
		api.setSellingManagerProductDetails(sellingManagerProductDetails); 
		api.reviseSellingManagerProduct();
		assertNotNull(api.getReturnedSellingManagerProductDetails());
	}
}
