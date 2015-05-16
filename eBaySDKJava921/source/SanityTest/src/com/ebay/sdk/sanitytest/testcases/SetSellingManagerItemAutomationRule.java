package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.SetSellingManagerItemAutomationRuleCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistOptionCodeType;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistType;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistTypeCodeType;

public class SetSellingManagerItemAutomationRule extends SDKTestCase{
	
	public void testSetSellingManagerItemAutomationRule() throws Exception{
		assertNotNull(TestData.itemId);
		SetSellingManagerItemAutomationRuleCall api =
			new SetSellingManagerItemAutomationRuleCall(apiContext);
		api.setItemID(TestData.itemId);
		SellingManagerAutoRelistType automatedRelistingRule = new SellingManagerAutoRelistType();
		automatedRelistingRule.setType(SellingManagerAutoRelistTypeCodeType.RELIST_ONCE_IF_NOT_SOLD);
		automatedRelistingRule.setRelistCondition(SellingManagerAutoRelistOptionCodeType.RELIST_IMMEDIATELY);
		api.setAutomatedRelistingRule(automatedRelistingRule);
		api.setSellingManagerItemAutomationRule();
		assertEquals(com.ebay.soap.eBLBaseComponents.AckCodeType.SUCCESS,
				api.getResponseObject().getAck());
	}
}
