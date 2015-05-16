package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.call.GetSellingManagerAlertsCall;
import com.ebay.sdk.sanitytest.SDKTestCase;

public class GetSellingManagerAlerts extends SDKTestCase{
	public void testGetSellingManagerAlerts()throws Exception{
		GetSellingManagerAlertsCall api = new GetSellingManagerAlertsCall(apiContext);
		api.getSellingManagerAlerts();
		assertNotNull(api.getReturnedAlert());
	}
}
