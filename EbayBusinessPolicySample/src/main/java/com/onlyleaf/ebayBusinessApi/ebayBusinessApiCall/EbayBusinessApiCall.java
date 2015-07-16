/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlyleaf.ebayBusinessApi.ebayBusinessApiCall;

import com.ebay.marketplace.selling.v1.services.BaseRequest;
import com.ebay.marketplace.selling.v1.services.BaseResponse;
import com.ebay.marketplace.selling.v1.services.SellerProfilesManagementServicePort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author aaron
 */
public abstract class EbayBusinessApiCall {

	public static final String X_EBAY_SOA_CONTENT_TYPE = "X-EBAY-SOA-CONTENT-TYPE";
	public static final String X_EBAY_SOA_GLOBAL_ID = "X-EBAY-SOA-GLOBAL-ID";
	public static final String X_EBAY_SOA_MESSAGE_ENCODING = "X-EBAY-SOA-MESSAGE-ENCODING";
	public static final String X_EBAY_SOA_MESSAGE_PROTOCOL = "X-EBAY-SOA-MESSAGE-PROTOCOL";
	public static final String X_EBAY_SOA_SERVICE_NAME = "X-EBAY-SOA-SERVICE-NAME";
	public static final String X_EBAY_SOA_OPERATION_NAME = "X-EBAY-SOA-OPERATION-NAME";
	public static final String X_EBAY_SOA_REQUEST_DATA_FORMAT = "X-EBAY-SOA-REQUEST-DATA-FORMAT";
	public static final String X_EBAY_SOA_RESPONSE_DATA_FORMAT = "X-EBAY-SOA-RESPONSE-DATA-FORMAT";
	public static final String X_EBAY_SOA_SECURITY_TOKEN = "X-EBAY-SOA-SECURITY-TOKEN";
	public static final String X_EBAY_SOA_SERVICE_VERSION = "X-EBAY-SOA-SERVICE-VERSION";

	public static final String addSellerProfile = "addSellerProfile";
	public static final String consolidateShippingProfiles = "consolidateShippingProfiles";
	public static final String getConsolidationJobStatus = "getConsolidationJobStatus";
	public static final String getSellerProfiles = "getSellerProfiles";
	public static final String getVersion = "getVersion";
	public static final String removeOverrides = "removeOverrides";
	public static final String removeProfile = "removeProfile";
	public static final String removeSellerProfiles = "removeSellerProfiles";
	public static final String setSellerProfile = "setSellerProfile";

	private BusinessPolicyApiContext businessApiContext = null;
	Map<String, List<String>> requestHeaders = new HashMap<>();
	private BaseRequest request;
	private BaseResponse response;

	public BusinessPolicyApiContext getBusinessApiContext() {
		return businessApiContext;
	}

	public abstract void setBusinessApiContext(
			BusinessPolicyApiContext businessApiContext);

	protected SellerProfilesManagementServicePort preExcute() {
		com.ebay.marketplace.selling.v1.services.SellerProfilesManagementService service = new com.ebay.marketplace.selling.v1.services.SellerProfilesManagementService();
		com.ebay.marketplace.selling.v1.services.SellerProfilesManagementServicePort port = service
				.getSellerProfilesManagementServiceSOAPPort();

		// String token =
		// "AgAAAA**AQAAAA**aAAAAA**5S+JVQ**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6AHl4eoAJSApw+dj6x9nY+seQ**44YCAA**AAMAAA**bsbgf2dlnMfZsCeklbkTP9Krp7Jia56BUhpo3K40o1d2fa/drZdtRLVCyM97/R83xGPZwkhhLx4Y79whLPUuHZcYgv48+Nw6YOnrVvI86lqdspmQa+g3P7GNL+mc+tBkBl/UusR/OpQSOie9ANWocRZJmO0kKI6j9ZPiZuRw4oLjv/L6jY8WCdDMnqxPSjAYWjWR82qfEcOJF4Fh1YfJK+/Xsu3ZRVLzE3OZdbsN4Jj0oL8sezjRLUNlmgxtFkaD3JNHULQu/LuzrgnJAX7pl/CN3Pk7DOYy6n9nFtm9iWDZQ4o/3wK2lR8jUYbk4OBTcaRr8aCrwn0xGmqGOWASv1AH+J+td2PdA2Hobi+KdBnYHlZtFdWjg2WHx2wGmQ7ByHq3C8KeufCnHpn6YGaZjMJGh32jMeetxjsjMNYLQjCALFKwgzMNUVM4xT/nyvykyAmyf63DLOWxBj5Jdz3xiRAW4y62Xo6ZdpzunmCm4faFO2SvrA8pk2hL/NeFv6ZCv23BuG+IOU3Uk8JtRrsBYoaH3qN4Zux1m66YT8YViFYKuct6HZje645DD2iYV9ZT6bDNWmfkUFmVIJ/QgmKDflHEd31dTjwFyNPNPToBcULgocvMeX3uAs8f6Y2Y1HyM9jQk/WznvHcBqPxzxSmBt2OS4Fzoe2Nb8qQS+NgxwhpQensJt9j4BB7F49qnYDuVDQV4xurJI9kMNzlYQvK35KuFLd8NMompnRqUmVoZr8tSPJplUolPmeNgRKqDiG38";
		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS,
				requestHeaders);
		bp.getRequestContext()
				.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
						"https://svcs.ebay.com/services/selling/v1/SellerProfilesManagementService");

		return port;
	}

	void setContext() {
		requestHeaders.put(X_EBAY_SOA_CONTENT_TYPE,
				Arrays.asList(businessApiContext.getContent_type()));
		requestHeaders.put(X_EBAY_SOA_GLOBAL_ID,
				Arrays.asList(businessApiContext.getGlobal_id()));
		requestHeaders.put(X_EBAY_SOA_MESSAGE_ENCODING,
				Arrays.asList(businessApiContext.getMessage_encoding()));
		requestHeaders.put(X_EBAY_SOA_MESSAGE_PROTOCOL,
				Arrays.asList(businessApiContext.getMessage_protocol()));
		requestHeaders.put(X_EBAY_SOA_SERVICE_NAME,
				Arrays.asList(businessApiContext.getService_name()));
		requestHeaders.put(X_EBAY_SOA_CONTENT_TYPE,
				Arrays.asList(businessApiContext.getContent_type()));

		requestHeaders.put(X_EBAY_SOA_REQUEST_DATA_FORMAT,
				Arrays.asList(businessApiContext.getRequest_data_format()));
		requestHeaders.put(X_EBAY_SOA_RESPONSE_DATA_FORMAT,
				Arrays.asList(businessApiContext.getResponse_data_format()));
		requestHeaders.put(X_EBAY_SOA_SECURITY_TOKEN,
				Arrays.asList(businessApiContext.getSecurity_token()));

	}

	public BaseRequest getRequest() {
		return request;
	}

	public void setRequest(BaseRequest request) {
		this.request = request;
	}

	public BaseResponse getResponse() {
		return response;
	}

	public void setResponse(BaseResponse response) {
		this.response = response;
	}
}
