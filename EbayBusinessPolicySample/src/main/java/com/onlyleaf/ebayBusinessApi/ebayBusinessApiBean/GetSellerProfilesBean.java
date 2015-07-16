package com.onlyleaf.ebayBusinessApi.ebayBusinessApiBean;

import com.ebay.marketplace.selling.v1.services.GetSellerProfilesRequest;
import com.ebay.marketplace.selling.v1.services.GetSellerProfilesResponse;

public class GetSellerProfilesBean {
	private GetSellerProfilesRequest request;
	private GetSellerProfilesResponse response;

	public GetSellerProfilesRequest getRequest() {
		return request;
	}

	public void setRequest(GetSellerProfilesRequest request) {
		this.request = request;
	}

	public GetSellerProfilesResponse getResponse() {
		return response;
	}

	public void setResponse(GetSellerProfilesResponse response) {
		this.response = response;
	}
}
