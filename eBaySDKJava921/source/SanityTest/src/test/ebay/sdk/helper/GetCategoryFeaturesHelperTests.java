/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package test.ebay.sdk.helper;

import com.ebay.sdk.SdkException;
import com.ebay.sdk.helper.GetCategoryFeaturesHelper;
import com.ebay.sdk.sanitytest.SDKTestCase;
import com.ebay.soap.eBLBaseComponents.FeatureDefinitionsType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

public class GetCategoryFeaturesHelperTests extends SDKTestCase {
	public void testGetCategoryFeatures() throws SdkException, Exception {
		apiContext.setSite(SiteCodeType.AUSTRIA);
		GetCategoryFeaturesHelper helper1 = new GetCategoryFeaturesHelper(apiContext);
		assertTrue(helper1.hasCategoryFeatures(SiteCodeType.AUSTRIA));
		apiContext.setSite(SiteCodeType.CHINA);
		helper1.loadCategoryFeatures(apiContext);
		assertTrue(helper1.hasCategoryFeatures(SiteCodeType.AUSTRIA));
		assertTrue(helper1.hasCategoryFeatures(SiteCodeType.CHINA));
		helper1.loadCategoryFeatures(SiteCodeType.US);
		assertTrue(helper1.hasCategoryFeatures(SiteCodeType.AUSTRIA));
		assertTrue(helper1.hasCategoryFeatures(SiteCodeType.CHINA));
		assertTrue(helper1.hasCategoryFeatures(SiteCodeType.US));
		assertFalse(helper1.hasCategoryFeatures(SiteCodeType.CANADA));
		//
		FeatureDefinitionsType us_features = helper1.getSiteFeatures(SiteCodeType.US);
		assertNotNull(us_features);
		FeatureDefinitionsType cn_features = helper1.getSiteFeatures(SiteCodeType.CHINA);
		assertNotNull(cn_features);
		//reset the site
		apiContext.setSite(SiteCodeType.US);
	}

}
