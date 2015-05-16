package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.GetSellingManagerItemAutomationRuleCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;

public class GetSellingManagerItemAutomationRule extends SDKTestCase{

	public void testGetSellingManagerItemAutomationRule() throws Exception{
		assertNotNull(TestData.itemId);
		GetSellingManagerItemAutomationRuleCall api = new GetSellingManagerItemAutomationRuleCall(apiContext);
		api.setItemID(TestData.itemId);
		api.getSellingManagerItemAutomationRule();
		assertEquals(com.ebay.soap.eBLBaseComponents.AckCodeType.SUCCESS,
				api.getResponseObject().getAck());
		assertNotNull(api.getReturnedAutomatedRelistingRule());
	}
}
