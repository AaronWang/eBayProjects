package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.DeleteSellingManagerTemplateAutomationRuleCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.sdk.sanitytest.TestData;

public class DeleteSellingManagerTemplateAutomationRule extends SDKTestCase{

	public void testDeleteSellingManagerTemplateAutomationRule() throws Exception{
		assertNotNull(TestData.saleTemplateId);
		DeleteSellingManagerTemplateAutomationRuleCall api =
			new DeleteSellingManagerTemplateAutomationRuleCall(apiContext);
		api.setSaleTemplateID(TestData.saleTemplateId);
		api.setDeleteAutomatedRelistingRule(true);
		api.deleteSellingManagerTemplateAutomationRule();
		assertEquals(com.ebay.soap.eBLBaseComponents.AckCodeType.SUCCESS,
				api.getResponseObject().getAck());
	}
}
