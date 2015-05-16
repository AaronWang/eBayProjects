/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sample.itemSpecificsDemo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ebay.sample.itemSpecificsDemo.model.SiteFacade;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.GetCategorySpecificsCall;
import com.ebay.soap.eBLBaseComponents.BuyerPaymentMethodCodeType;
import com.ebay.soap.eBLBaseComponents.CategoryFeatureType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.ConditionEnabledCodeType;
import com.ebay.soap.eBLBaseComponents.ConditionValuesType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.FeatureDefinitionsType;
import com.ebay.soap.eBLBaseComponents.ItemSpecificsEnabledCodeType;
import com.ebay.soap.eBLBaseComponents.ListingDurationDefinitionType;
import com.ebay.soap.eBLBaseComponents.ListingDurationDefinitionsType;
import com.ebay.soap.eBLBaseComponents.ListingDurationReferenceType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.NameRecommendationType;
import com.ebay.soap.eBLBaseComponents.RecommendationsType;
import com.ebay.soap.eBLBaseComponents.SiteDefaultsType;

/**
 * @author boyang
 * 
 * facade for category level API, cache category level meta-data
 * 
 */
public class CategoryFacade {
	
	private ApiContext apiContext = null;
	private String catId = null;
	private SiteFacade siteFacade = null;
	
	private ItemSpecificsEnabledCodeType itemSpecificEnabled = null;
	private Boolean retPolicyEnabled = null;
	private Map<Integer,String[]> listingDurationMap = null;
	private Map<ListingTypeCodeType,Integer> listingDurationReferenceMap = null;
	private BuyerPaymentMethodCodeType[] paymentMethods = null;
	private NameRecommendationType[] nameRecommendationTypes = null;
	private ConditionEnabledCodeType conditionEnabled = null;
	private ConditionValuesType conditionValues = null;

	
	public CategoryFacade(String catId, ApiContext apiContext,SiteFacade siteFacade) 
            throws SdkException, Exception {
	this.catId = catId;
	this.apiContext = apiContext;
	this.siteFacade = siteFacade;
	
	this.syncCategoryMetaData();
	
    }
    private void syncCategoryMetaData() throws SdkException, Exception
    {
        syncCategoryFeatures();
        syncNameRecommendationTypes();
    }
	
	private void syncNameRecommendationTypes() throws ApiException, SdkException, Exception
	{
		GetCategorySpecificsCall getCatSpe = new GetCategorySpecificsCall(apiContext);
		getCatSpe.setCategoryID(new String[]{this.catId});
		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {DetailLevelCodeType.RETURN_ALL};
		getCatSpe.setDetailLevel(detailLevels);
		RecommendationsType[] recommendationsArray = getCatSpe.getCategorySpecifics();
		if(recommendationsArray==null||recommendationsArray.length==0)
			return;
		RecommendationsType recommendations = recommendationsArray[0];
		this.nameRecommendationTypes = recommendations.getNameRecommendation();
	}
	
	
	public void syncCategoryFeatures() throws Exception {
		Map<String, CategoryType> categoriesCacheMap = this.siteFacade.getSiteCategoriesMap().get(apiContext.getSite());
		    
  		Map<String, CategoryFeatureType> cfsMap = this.siteFacade.getSiteCategoriesFeaturesMap().get(apiContext.getSite());
  		SiteDefaultsType siteDefaults = this.siteFacade.getSiteFeatureDefaultMap().get(apiContext.getSite());
  		FeatureDefinitionsType featureDefinition = this.siteFacade.getSiteFeatureDefinitionsMap().get(apiContext.getSite());
  				
  		//get itemSpecificsEnabled feature
  		itemSpecificEnabled = (ItemSpecificsEnabledCodeType)getInheritProperty(catId, "getItemSpecificsEnabled", categoriesCacheMap,cfsMap);
  		if (itemSpecificEnabled == null) {
  			itemSpecificEnabled = siteDefaults.getItemSpecificsEnabled();
  		}
  		//get returnPolicyEnabled feature
  		retPolicyEnabled = (Boolean)getInheritProperty(catId, "isReturnPolicyEnabled", categoriesCacheMap,cfsMap);
  		if (retPolicyEnabled == null) {
  			retPolicyEnabled = siteDefaults.isReturnPolicyEnabled();
  		}
  		
  		//get listing durations
  		ListingDurationDefinitionsType listDuration = featureDefinition.getListingDurations();
  		ListingDurationDefinitionType[] durationArray = listDuration.getListingDuration();
  		listingDurationMap = new HashMap<Integer,String[]>();
  		for(int i=0;i<durationArray.length;i++){
  			listingDurationMap.put(durationArray[i].getDurationSetID(), durationArray[i].getDuration());
  		}
  		
  		//get listing types
  		ListingDurationReferenceType[] listingDuration = (ListingDurationReferenceType[])getInheritProperty(catId, "getListingDuration", categoriesCacheMap,cfsMap);
  		if (listingDuration == null || listingDuration.length == 0) {
  			listingDuration = siteDefaults.getListingDuration();
  		}
  		listingDurationReferenceMap = new HashMap<ListingTypeCodeType,Integer>();
  		for(int i=0;i<listingDuration.length;i++){
  			listingDurationReferenceMap.put(listingDuration[i].getType(),listingDuration[i].getValue());
  		}

  		//get payment methods
  		paymentMethods = (BuyerPaymentMethodCodeType[])getInheritProperty(catId, "getPaymentMethod", categoriesCacheMap,cfsMap);
  		if (paymentMethods ==  null || paymentMethods.length == 0) {
  			paymentMethods = siteDefaults.getPaymentMethod();
  		}
  		
  		//get conditionEnabled feature
  		this.conditionEnabled = (ConditionEnabledCodeType)getInheritProperty(catId, "getConditionEnabled", categoriesCacheMap, cfsMap);
  		if (this.conditionEnabled == null) {
  			this.conditionEnabled = siteDefaults.getConditionEnabled();
  			if (this.conditionEnabled == ConditionEnabledCodeType.ENABLED || this.conditionEnabled == ConditionEnabledCodeType.REQUIRED) {
  				this.conditionValues = siteDefaults.getConditionValues();
  			}
  		} else if (this.conditionEnabled == ConditionEnabledCodeType.ENABLED || this.conditionEnabled == ConditionEnabledCodeType.REQUIRED) {
  			this.conditionValues = (ConditionValuesType)getInheritProperty(catId, "getConditionValues", categoriesCacheMap, cfsMap);
  			if (this.conditionValues == null) {
  				this.conditionValues = siteDefaults.getConditionValues();
  			}
  		}

  	    //fix 'invalid enum' issue
  		paymentMethods = fiterPaymentMethod(paymentMethods);	
	  }
	
	  //remove all 'null' code type
	  private static BuyerPaymentMethodCodeType[] fiterPaymentMethod(BuyerPaymentMethodCodeType[] paymentMethods) {
		  ArrayList<BuyerPaymentMethodCodeType> al = new ArrayList<BuyerPaymentMethodCodeType>();
		  for (BuyerPaymentMethodCodeType pm : paymentMethods) {
			  if (pm != null) {
				  al.add(pm);
			  }
		  }
		  return (BuyerPaymentMethodCodeType[])al.toArray(new BuyerPaymentMethodCodeType[0]);
	  }
	
	  /**
	   * recursively check the parent category to find out category feature 
	   * @param catId categoryID to be retrieved
	   * @param methodName method name to be invoked
	   * @param categoriesCacheMap cache of all the categories
	   * @param cfsMap category features map
	   * @return generic Object
	   * @throws Exception
	   */
	  private Object getInheritProperty(String catId,String methodName,
			  Map<String, CategoryType> categoriesCacheMap,  Map<String, CategoryFeatureType> cfsMap) throws Exception{
		  if (cfsMap.containsKey(catId)) {
			  CategoryFeatureType cf = cfsMap.get(catId);
			  // invoke the method indicated by methodName
			  Object returnValue = invokeMethodByName(cf, methodName);
			  if (returnValue != null) {
				  return returnValue;
			  }
		 }
		  
		  CategoryType cat = categoriesCacheMap.get(catId);
		  //if we reach top level, return null
		  if (cat.getCategoryLevel() == 1) {
			  return null;
		  }
		  
		  //check parent category
		  return getInheritProperty(cat.getCategoryParentID(0), methodName, categoriesCacheMap, cfsMap);
	  }
	  
	  /**
	   * invoke the method specified by methodName and return the corresponding return value
	   * @param cf CategoryFeatureType
	   * @param methodName String
	   * @return generic object
	   */
	  private Object invokeMethodByName(CategoryFeatureType cf, String methodName){
		  java.lang.reflect.Method m = null;
		  try{
			  m = cf.getClass().getMethod(methodName);
		      if (m != null) {
		        return m.invoke(cf);
		      } 
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	      return null;
	  }

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}


	public ItemSpecificsEnabledCodeType getItemSpecificEnabled() {
		return itemSpecificEnabled;
	}

	public Boolean getRetPolicyEnabled() {
		return retPolicyEnabled;
	}

	public Map<Integer, String[]> getListingDurationMap() {
		return listingDurationMap;
	}

	public Map<ListingTypeCodeType, Integer> getListingDurationReferenceMap() {
		return listingDurationReferenceMap;
	}

	public BuyerPaymentMethodCodeType[] getPaymentMethods() {
		return paymentMethods;
	}

	public NameRecommendationType[] getNameRecommendationTypes() {
		return nameRecommendationTypes;
	}
	
	public ConditionEnabledCodeType getConditionEnabled() {
		return conditionEnabled;
	}

	public void setConditionEnabled(ConditionEnabledCodeType conditionEnabled) {
		this.conditionEnabled = conditionEnabled;
	}

	public ConditionValuesType getConditionValues() {
		return conditionValues;
	}

	public void setConditionValues(ConditionValuesType conditionValues) {
		this.conditionValues = conditionValues;
	}
}
