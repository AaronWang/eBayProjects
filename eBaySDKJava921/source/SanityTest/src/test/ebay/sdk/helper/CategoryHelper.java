/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package test.ebay.sdk.helper;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.*;
import com.ebay.soap.eBLBaseComponents.CategoryFeatureType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.FeatureIDCodeType;
import com.ebay.soap.eBLBaseComponents.GetCategoryFeaturesResponseType;
import com.ebay.soap.eBLBaseComponents.ItemSpecificsEnabledCodeType;
import com.ebay.soap.eBLBaseComponents.SiteDefaultsType;

public class CategoryHelper {
	
	//call GetCategoryFeatures to check whether the category supports custom item specifics
	public static boolean getCategoryFeature(int categoryId,ApiContext apiContext,FeatureIDCodeType featureID)throws Exception{
		 DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
			        DetailLevelCodeType.RETURN_ALL
			    };
		
		 GetCategoryFeaturesCall getCategoryFeatures=new GetCategoryFeaturesCall(apiContext);
		 getCategoryFeatures.setCategoryID(Integer.toString(categoryId));
		 //getCategoryFeatures.setFeatureIDs(new FeatureIDCodeType[]{featureID});
		 getCategoryFeatures.setDetailLevel(detailLevels);
		 getCategoryFeatures.getCategoryFeatures();
		 GetCategoryFeaturesResponseType response=(GetCategoryFeaturesResponseType)getCategoryFeatures.getResponseObject();
		 SiteDefaultsType sitedefault=response.getSiteDefaults();
		 CategoryFeatureType[] categoryFeatures=getCategoryFeatures.getReturnedCategory();
		 if(categoryFeatures==null||categoryFeatures.length==0)
		 {	 
			 return false;
		 } 
		 if (categoryFeatures[0] !=null && categoryFeatures[0].getItemSpecificsEnabled() != null && categoryFeatures[0].getItemSpecificsEnabled() == ItemSpecificsEnabledCodeType.DISABLED) {
			 return false;
		 } else {
			 return ( 
					 (categoryFeatures[0] !=null && categoryFeatures[0].getItemSpecificsEnabled() != null && categoryFeatures[0].getItemSpecificsEnabled() == ItemSpecificsEnabledCodeType.ENABLED) 
					 || (sitedefault != null && sitedefault.getItemSpecificsEnabled() == ItemSpecificsEnabledCodeType.ENABLED) 
					) ;
		 }
				 
	}

}
