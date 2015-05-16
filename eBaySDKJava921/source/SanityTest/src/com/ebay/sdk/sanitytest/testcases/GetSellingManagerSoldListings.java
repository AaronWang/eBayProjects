package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.GetSellingManagerSoldListingsCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.PaginationType;

public class GetSellingManagerSoldListings extends SDKTestCase{
	
	public void testGetSellingManagerSoldListings()throws Exception{
		GetSellingManagerSoldListingsCall api = new GetSellingManagerSoldListingsCall(apiContext);
		PaginationType pagination = new PaginationType();
		pagination.setEntriesPerPage(5);
		pagination.setPageNumber(0);
		api.setPagination(pagination);
		api.getSellingManagerSoldListings();
		assertNotNull(api.getReturnedSaleRecord());
		assertTrue(api.getReturnedSaleRecord()[0].getSellingManagerSoldTransaction().length > 0);
		TestData.soldItemId = api.getReturnedSaleRecord()[0].
			getSellingManagerSoldTransaction()[0].getItemID();
	}
}
