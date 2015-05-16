/*
 Copyright (c) 2007 eBay, Inc.

 This program is licensed under the terms of the eBay Common Development and
 Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
 version thereof released by eBay.  The then-current version of the License
 can be found at https://www.codebase.ebay.com/Licenses.html and in the
 eBaySDKLicense file that is under the eBay SDK install directory.
 */

package com.ebay.sdk.sanitytest.testcases;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.call.GetContextualKeywordsCall;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.soap.eBLBaseComponents.ContextSearchAssetType;

/**
 *
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: eBay Inc.
 * </p>
 *
 * @author Weian Deng
 * @version 1.0
 */
public class GetContextualKeywords extends SDKTestCase {

	public void testGetContextualKeywords() throws Exception {

		GetContextualKeywordsCall api = new GetContextualKeywordsCall(
				this.apiContext);

		api.setURL("http://www.ebay.com");
		api.setEncoding("ISO-8859-1");
		String[] strings = {"124", "568"};
		api.setCategoryID(strings);

		// Make API call.
		ApiException gotException = null;

		// Negative test.
		try {
			ContextSearchAssetType[] assets = api.getContextualKeywords();
		} catch (ApiException ex) {
			gotException = ex;
		}
		assertTrue(gotException == null || gotException.containsErrorCode("17475"));

	}
}
