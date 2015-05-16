/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sample.itemSpecificsDemo.model;

import java.util.HashMap;
import java.util.Map;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.helper.cache.CategoriesDownloader;
import com.ebay.sdk.helper.cache.DetailsDownloader;
import com.ebay.sdk.helper.cache.FeaturesDownloader;
import com.ebay.soap.eBLBaseComponents.CategoryFeatureType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.FeatureDefinitionsType;
import com.ebay.soap.eBLBaseComponents.GetCategoryFeaturesResponseType;
import com.ebay.soap.eBLBaseComponents.GeteBayDetailsResponseType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.ebay.soap.eBLBaseComponents.SiteDefaultsType;

/**
 * @author boyang
 * 
 * facade for site level API, cache site level meta-data
 *
 */
public class SiteFacade {
	
	private ApiContext apiContext = null;
	
	private static final int MAP_SIZE = 30000;
	
	private Map<SiteCodeType, Map<String, CategoryType>> siteCategoriesMap = 
		  new HashMap<SiteCodeType, Map<String, CategoryType>>();
	private Map<SiteCodeType, Map<String, CategoryFeatureType>> siteCategoriesFeaturesMap =
		  new HashMap<SiteCodeType, Map<String, CategoryFeatureType>>();
	private Map<SiteCodeType, SiteDefaultsType> siteFeatureDefaultMap = 
		  new HashMap<SiteCodeType, SiteDefaultsType>();
	private  Map<SiteCodeType, FeatureDefinitionsType> siteFeatureDefinitionsMap =
		  new HashMap<SiteCodeType, FeatureDefinitionsType>();
	private Map<SiteCodeType, GeteBayDetailsResponseType> eBayDetailsMap =
		  new HashMap<SiteCodeType, GeteBayDetailsResponseType>();

	public SiteFacade(ApiContext ctx) throws ApiException, SdkException, Exception {
		this.apiContext = ctx;
		syncAllCategoriesFeatures();
		syncEBayDetails();
	}
	
	
	private void syncEBayDetails() throws Exception {
		if (!eBayDetailsMap.containsKey(this.apiContext.getSite())) {
		    DetailsDownloader downloader = new DetailsDownloader(this.apiContext);
		    GeteBayDetailsResponseType resp =  downloader.geteBayDetails();
		    eBayDetailsMap.put(this.apiContext.getSite(), resp);
		}
	}
	
	//sync and cache all categories features in memory
	private void syncAllCategoriesFeatures() throws Exception  {
		  
		if (!siteCategoriesFeaturesMap.containsKey(this.apiContext.getSite())) { 
			  FeaturesDownloader fd = new FeaturesDownloader(this.apiContext);
			  GetCategoryFeaturesResponseType cfrt = fd.getAllCategoryFeatures();
			  CategoryFeatureType[] categoryFeatures = cfrt.getCategory();
			  Map<String, CategoryFeatureType> cfsMap = new HashMap<String, CategoryFeatureType>(MAP_SIZE);
			  for(CategoryFeatureType cf: categoryFeatures) {
	    		cfsMap.put(cf.getCategoryID(), cf);
			  }
			  siteCategoriesFeaturesMap.put(this.apiContext.getSite(), cfsMap);
			  siteFeatureDefaultMap.put(this.apiContext.getSite(), cfrt.getSiteDefaults());
			  siteFeatureDefinitionsMap.put(this.apiContext.getSite(), cfrt.getFeatureDefinitions());
		}
	}
	
	
	  //get all categories map
	  public Map<String, CategoryType> getAllCategories() throws Exception {
		  
			if (!siteCategoriesMap.containsKey(this.apiContext.getSite())) { 
				
				  Map<String, CategoryType> catsMap = new HashMap<String, CategoryType>(30000);
				  CategoriesDownloader cd = new CategoriesDownloader(this.apiContext);
				  CategoryType[] cats = cd.getAllCategories();
				  
				  for (CategoryType cat : cats) {
					  catsMap.put(cat.getCategoryID(), cat);
				  }
				  siteCategoriesMap.put(this.apiContext.getSite(), catsMap);
				  return catsMap;
			} else {
				return siteCategoriesMap.get(this.apiContext.getSite());
			}
	  }

	
	public Map<SiteCodeType, Map<String, CategoryFeatureType>> getSiteCategoriesFeaturesMap() {
		return siteCategoriesFeaturesMap;
	}

	public Map<SiteCodeType, SiteDefaultsType> getSiteFeatureDefaultMap() {
		return siteFeatureDefaultMap;
	}

	public Map<SiteCodeType, FeatureDefinitionsType> getSiteFeatureDefinitionsMap() {
		return siteFeatureDefinitionsMap;
	}

	public Map<SiteCodeType, Map<String, CategoryType>> getSiteCategoriesMap() {
		return siteCategoriesMap;
	}

	public Map<SiteCodeType, GeteBayDetailsResponseType> getEBayDetailsMap() {
		return eBayDetailsMap;
	}

}
