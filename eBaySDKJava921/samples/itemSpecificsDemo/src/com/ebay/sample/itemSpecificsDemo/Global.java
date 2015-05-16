/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sample.itemSpecificsDemo;

import java.util.ArrayList;

import com.ebay.sdk.ApiContext;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

/**
 * @author boyang
 *
 * Global constants and utilities
 * 
 */
public abstract class Global {
	  //Servlet and jsp pages
	  public static final String PageStart = "selectSite.jsp";
	  public static final String PageCategoryList = "categoryList.jsp";
	  public static final String ServletCategoryList = "CategoryListServlet";
	  public static final String PageItemSpecifics = "itemSpecifics.jsp";
	  public static final String ServletItemSpecifics = "ItemSpecificsServlet";
	  public static final String PageReturnPolicy = "returnPolicy.jsp";
	  public static final String ServletReturnPolicy = "ReturnPolicyServlet";
	  public static final String PageAddItem = "addItem.jsp";
	  public static final String ServletAddItem = "AddItemServlet";
	  public static final String ServletSite = "SiteServlet";
	  
	  //Session scope keys
	  public static final String SK_SITEFACADE = "SiteFacade";
	  public static final String SK_CATEGORYFACADE = "CategoryFacade";
	  public static final String SK_SORTEDLEAFCATEGORIES = "SortedLeafCategories";
	  public static final String SK_CUSTOM_ITEM_SPECIFICS = "categoryCustomItemSpecifics";
	  public static final String SELLER_RETURN_PROFILE = "sellerReturnProfile";
	  public static final String SK_CATEGORY_ID = "CatId";
	
	  //Init keys in web.xml
	  public static final String IK_DEVELOPER_ID = "DeveloperID";
	  public static final String IK_APITOKEN = "ApiToken";
	  public static final String IK_APISERVERURL = "ApiServerURL";
	  public static final String IK_EPSSERVERURL = "EpsServerURL";
	  public static final String IK_VIEWITEMURL = "ViewItemUrl";
	  public static final String IK_ENABLELOGGING = "EnableLogging";
	  
	  //ApiContent object as a global object
	  public static ApiContext apiContext = null;
	  
	  private static final int SHIPPING_SERVICE_ID_LIMIT = 50000;
	  
	  //site -> currency
	  public static CurrencyCodeType getCurrencyOfSite(SiteCodeType siteId) {
		    CurrencyCodeType curr = CurrencyCodeType.USD;

		    if( siteId.equals(SiteCodeType.US) || siteId.equals(SiteCodeType.E_BAY_MOTORS))
		      curr = CurrencyCodeType.USD;
		    else if( siteId.equals(SiteCodeType.UK) )
		      curr = CurrencyCodeType.GBP;
		    else if( siteId.equals(SiteCodeType.CANADA) )
		      curr = CurrencyCodeType.CAD;
		    else if( siteId.equals(SiteCodeType.AUSTRALIA) )
		      curr = CurrencyCodeType.AUD;
		    else if( siteId.equals(SiteCodeType.TAIWAN) )
		      curr = CurrencyCodeType.TWD;
		    else if( siteId.equals(SiteCodeType.SWITZERLAND) )
		      curr = CurrencyCodeType.CHF;
		    else if( siteId.equals(SiteCodeType.POLAND))
			      curr = CurrencyCodeType.PLN;
		    else if( siteId.equals(SiteCodeType.INDIA))
			      curr = CurrencyCodeType.INR;
		    else if( siteId.equals(SiteCodeType.FRANCE) || siteId.equals(SiteCodeType.GERMANY)
		             || siteId.equals(SiteCodeType.ITALY) || siteId.equals(SiteCodeType.NETHERLANDS)
		             || siteId.equals(SiteCodeType.BELGIUM_DUTCH) || siteId.equals(SiteCodeType.BELGIUM_FRENCH)
		             || siteId.equals(SiteCodeType.AUSTRIA)
		             )
		      curr = CurrencyCodeType.EUR;
		    else
		      curr = CurrencyCodeType.USD;

		    return curr;
	  }
	  
	  //site -> country
	  public static CountryCodeType getCountryCodeType(SiteCodeType siteId) {
		  CountryCodeType countryCodeType = CountryCodeType.US;

		  		if(siteId.equals(SiteCodeType.US) || siteId.equals(SiteCodeType.E_BAY_MOTORS)) {
		  			countryCodeType = CountryCodeType.US;
		  		}
		  		else if(siteId.equals(SiteCodeType.UK)) {
			    	countryCodeType = CountryCodeType.GB;
		  		}
		  		else if(siteId.equals(SiteCodeType.CANADA)) {
				    countryCodeType = CountryCodeType.CA;
		  		}
		  		else if(siteId.equals(SiteCodeType.AUSTRALIA)) {
				    countryCodeType = CountryCodeType.AU;
		  		}
		  		else if(siteId.equals(SiteCodeType.TAIWAN)) {
				    countryCodeType = CountryCodeType.TW;
		  		}
		  		else if(siteId.equals(SiteCodeType.SWITZERLAND)) {
				    countryCodeType = CountryCodeType.CH;
		  		}
		  		else if(siteId.equals(SiteCodeType.POLAND)) {
				    countryCodeType = CountryCodeType.PL;
		  		}
		  		else if(siteId.equals(SiteCodeType.INDIA)) {
				    countryCodeType = CountryCodeType.IN;
		  		}
		  		else if(siteId.equals(SiteCodeType.FRANCE)) {
				    countryCodeType = CountryCodeType.FR;
		  		}
		  		else if(siteId.equals(SiteCodeType.GERMANY)) {
				    countryCodeType = CountryCodeType.DE;
		  		}
		  		else if(siteId.equals(SiteCodeType.ITALY)) {
				    countryCodeType = CountryCodeType.IT;
		  		}
		  		else if(siteId.equals(SiteCodeType.AUSTRIA)) {
				    countryCodeType = CountryCodeType.AT;
		  		}
		  		else if(siteId.equals(SiteCodeType.NETHERLANDS)) {
				    countryCodeType = CountryCodeType.NL;
		  		}
		  		else if(siteId.equals(SiteCodeType.BELGIUM_FRENCH) || siteId.equals(SiteCodeType.BELGIUM_DUTCH)) {
				    countryCodeType = CountryCodeType.BE;
				}

		    return countryCodeType;
	  }
	  
	  
	  private static boolean isFlat(ShippingTypeCodeType[] st){
		  for(int i=0;i<st.length;i++){
			  if(st[i].compareTo(ShippingTypeCodeType.FLAT)==0){
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  
	  public static ShippingServiceDetailsType[] filterShippingService(ShippingServiceDetailsType[] array){
		  ArrayList<ShippingServiceDetailsType> list = new ArrayList<ShippingServiceDetailsType>();
		  for(int i=0;i<array.length;i++){
			  if(isFlat(array[i].getServiceType()) && array[i].getShippingServiceID() < SHIPPING_SERVICE_ID_LIMIT){
				  list.add(array[i]);
			  }
		  }
		  return list.toArray(new ShippingServiceDetailsType[0]);
	  }
}
