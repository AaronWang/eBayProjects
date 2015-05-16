package com.ebay.sdk.sanitytest.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ebay.sdk.call.AddSellingManagerTemplateCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.ItemType;

public class AddSellingManagerTemplate extends SDKTestCase{
	
	public void testAddSellingManagerTemplate()throws Exception{
		assertNotNull(TestData.productId);
		AddSellingManagerTemplateCall api = new AddSellingManagerTemplateCall(apiContext);
		api.setProductID(TestData.productId);
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		String id_from_time = df.format(date);
		api.setSaleTemplateName("template group"+id_from_time);
		ItemType item = AddItem.buildItem();
		api.setItem(item);
		api.addSellingManagerTemplate();
		Long templateId = api.getReturnedSaleTemplateID();
		Long groupId = api.getReturnedSaleTemplateGroupID();
		Long productId = api.getReturnedSellingManagerProductDetails().getProductID();
		assertNotNull(templateId);
		assertNotNull(groupId);
		assertNotNull(productId);
		TestData.saleTemplateId = templateId;
	}
}
