package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.SetSellingManagerTemplateAutomationRuleCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistOptionCodeType;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistType;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistTypeCodeType;

public class SetSellingManagerTemplateAutomationRule extends SDKTestCase{

	public void testSetSellingManagerTemplateAutomationRule() throws Exception{
		assertNotNull(TestData.saleTemplateId);
		SetSellingManagerTemplateAutomationRuleCall api =
			new SetSellingManagerTemplateAutomationRuleCall(apiContext);
		SellingManagerAutoRelistType automatedRelistingRule = new SellingManagerAutoRelistType();
		automatedRelistingRule.setType(SellingManagerAutoRelistTypeCodeType.RELIST_ONCE_IF_NOT_SOLD);
		automatedRelistingRule.setRelistCondition(SellingManagerAutoRelistOptionCodeType.RELIST_IMMEDIATELY);
		api.setAutomatedRelistingRule(automatedRelistingRule);
		api.setSaleTemplateID(TestData.saleTemplateId);
		api.setSellingManagerTemplateAutomationRule();
		assertEquals(com.ebay.soap.eBLBaseComponents.AckCodeType.SUCCESS,
				api.getResponseObject().getAck());
	}
}