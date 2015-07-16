package com.onlyleaf.ebayBusinessApi.ebayBusinessApiCall;

import java.util.Arrays;

import com.ebay.marketplace.selling.v1.services.GetSellerProfilesRequest;
import com.ebay.marketplace.selling.v1.services.SellerProfilesManagementServicePort;

public class GetSellerProfilesCall extends EbayBusinessApiCall {

	public GetSellerProfilesCall() {

	}

	public GetSellerProfilesCall(BusinessPolicyApiContext ctx) {
		ctx.setOperation_name(getSellerProfiles);
		this.setBusinessApiContext(ctx);
	}

	@Override
	public void setBusinessApiContext(BusinessPolicyApiContext ctx) {
		ctx.setOperation_name(getSellerProfiles);
		this.setBusinessApiContext(ctx);
	}

	public boolean getSellerProfiles() {
		setContext();

		try { // Call Web Service Operation
			SellerProfilesManagementServicePort port = preExcute();

			super.setResponse(port
					.getSellerProfiles((GetSellerProfilesRequest) super
							.getRequest()));

			// System.out.println("Result = " + result);
		} catch (Exception ex) {
			// TODO handle custom exceptions here
			System.out.println(ex.toString());
			return false;
		}
		return true;
	}

	@Override
	void setContext() {
		super.setContext();
		requestHeaders
				.put("X-EBAY-SOA-OPERATION-NAME", Arrays.asList(this
						.getBusinessApiContext().getOperation_name()));
	}
}
