package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.DeleteSellingManagerItemAutomationRuleCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;

public class DeleteSellingManagerItemAutomationRule extends SDKTestCase{

	public void testDeleteSellingManagerItemAutomationRule() throws Exception{
		assertNotNull(TestData.itemId);
		DeleteSellingManagerItemAutomationRuleCall api = 
			new DeleteSellingManagerItemAutomationRuleCall(apiContext);
		api.setItemID(TestData.itemId);
		api.setDeleteAutomatedRelistingRule(true);
		api.deleteSellingManagerItemAutomationRule();
		assertEquals(com.ebay.soap.eBLBaseComponents.AckCodeType.SUCCESS,
				api.getResponseObject().getAck());
	}
}
