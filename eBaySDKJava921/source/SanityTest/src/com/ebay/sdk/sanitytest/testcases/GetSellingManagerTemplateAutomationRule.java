package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.GetSellingManagerTemplateAutomationRuleCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;

public class GetSellingManagerTemplateAutomationRule extends SDKTestCase{
	
	public void testGetSellingManagerTemplateAutomationRule()throws Exception{
		assertNotNull(TestData.saleTemplateId);
		GetSellingManagerTemplateAutomationRuleCall api = 
			new GetSellingManagerTemplateAutomationRuleCall(apiContext);
		api.setSaleTemplateID(TestData.saleTemplateId);
		api.getSellingManagerTemplateAutomationRule();
		assertEquals(com.ebay.soap.eBLBaseComponents.AckCodeType.SUCCESS,
				api.getResponseObject().getAck());
		assertNotNull(api.getReturnedAutomatedRelistingRule());
	}
}
