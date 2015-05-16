package com.ebay.sample.itemSpecificsDemo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebay.sample.itemSpecificsDemo.Global;
import com.ebay.sample.itemSpecificsDemo.model.CategoryFacade;
import com.ebay.sample.itemSpecificsDemo.model.SiteFacade;
import com.ebay.sdk.call.AddItemCall;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BuyerPaymentMethodCodeType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.ConditionEnabledCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.GeteBayDetailsResponseType;
import com.ebay.soap.eBLBaseComponents.InsuranceOptionCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDurationCodeType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.NameValueListArrayType;
import com.ebay.soap.eBLBaseComponents.SalesTaxType;
import com.ebay.soap.eBLBaseComponents.SellerPaymentProfileType;
import com.ebay.soap.eBLBaseComponents.SellerProfilesType;
import com.ebay.soap.eBLBaseComponents.SellerReturnProfileType;
import com.ebay.soap.eBLBaseComponents.SellerShippingProfileType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingLocationDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

/**
 * Servlet implementation class for Servlet: AddItemServlet
 *
 */
 public class AddItemServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AddItemServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
				String submit = request.getParameter("BtnAddItem");
				
				if ("List Item to eBay".equals(submit)) {//list item to eBay
				
				      AddItemCall aic = new AddItemCall(Global.apiContext);

				      aic.setSite(Global.apiContext.getSite());
				 
				      ItemType item = this.populateItem(request);      

				      aic.setItem(item);
				      aic.addItem();

				      // Go to view item page.
				      ServletContext application = this.getServletContext();
				      String fmt = application.getInitParameter(Global.IK_VIEWITEMURL);
				      String url = java.text.MessageFormat.format(fmt, new Object[] {item.getItemID()} );
				      response.sendRedirect(url);
					
				} else {
					
					RequestDispatcher view = request.getRequestDispatcher(Global.PageAddItem);
					view.forward(request, response);
					
				}
				
			} catch (Exception e) {
				request.setAttribute("PageError", e.getMessage());
				RequestDispatcher view = request.getRequestDispatcher(Global.PageAddItem);
				view.forward(request, response);
				//throw new ServletException(e);
			}
	}

	private ItemType populateItem(HttpServletRequest request) {
		ItemType item = new ItemType();
		
		//common Item request fields
		setCommonFields(item, request);
		
		//add item specifics
		setItemSpecifics(item, request);
		
		/*
		 * The Business Policies API and related Trading API fields are
		 * available in sandbox. It will be available in production for a
		 * limited number of sellers with Version 775. 100 percent of sellers
		 * will be ramped up to use Business Polcies in July 2012
		 */
		
	    SellerProfilesType sellerProfile=new SellerProfilesType();
	    
	    //Add Seller PaymentProfile
	    SellerPaymentProfileType sellerPaymentProfile=new SellerPaymentProfileType();
	    if(request.getParameter("PaymentProfileId") != null && request.getParameter("PaymentProfileId")!=""){
	    	sellerPaymentProfile.setPaymentProfileID(Long.valueOf(request.getParameter("PaymentProfileId")));
	    }
	    if(request.getParameter("PaymentProfileName") != null && request.getParameter("PaymentProfileName")!=""){
	    	sellerPaymentProfile.setPaymentProfileName(request.getParameter("PaymentProfileName"));
	    }
	    sellerProfile.setSellerPaymentProfile(sellerPaymentProfile);
	    	
	    //Add Seller ReturnProfile
	    HttpSession session = request.getSession();
		CategoryFacade cf = (CategoryFacade)session.getAttribute(Global.SK_CATEGORYFACADE);
		Boolean returnPolicyEnabled = cf.getRetPolicyEnabled();
		if(returnPolicyEnabled.booleanValue()){
			SellerReturnProfileType sellerReturnProfile=(SellerReturnProfileType)session.getAttribute(Global.SELLER_RETURN_PROFILE);	
		    sellerProfile.setSellerReturnProfile(sellerReturnProfile);
		}
	    
	    
	    //Add Seller ShippingProfile
	    SellerShippingProfileType sellerShippingProfile=new SellerShippingProfileType();
	    if(request.getParameter("ShippingProfileId") != null && request.getParameter("ShippingProfileId") != ""){
	    	sellerShippingProfile.setShippingProfileID(Long.valueOf(request.getParameter("ShippingProfileId")));
	    }
	    if(request.getParameter("ShippingProfileName") != null && request.getParameter("ShippingProfileName") != ""){
	    	sellerShippingProfile.setShippingProfileName(request.getParameter("ShippingProfileName"));
	    }
	    
	    sellerProfile.setSellerShippingProfile(sellerShippingProfile);
	    
	    //set SelllerProfile to Item
	    item.setSellerProfiles(sellerProfile);
		return item;
	}
	
	private void setCommonFields(ItemType item, HttpServletRequest request) {
		  item.setSite(Global.apiContext.getSite());
		  
		  String itemTitle = request.getParameter("ItemTitle");
	      item.setTitle(itemTitle);
	      
	      String subTitle = request.getParameter("SubTitle");
	      if( subTitle != null && subTitle.length()>0){
	    	  item.setSubTitle(subTitle);
	      }
	      
	      String description = request.getParameter("Description");
	      item.setDescription(description);
	      
		  String startPrice = request.getParameter("StartPrice");
	      if(startPrice != null && startPrice.length() > 0){
	    	  AmountType at = new AmountType();
	    	  at.setValue(Double.valueOf(startPrice));
	          item.setStartPrice(at);
	      }
	      
	      String buyItNowPrice = request.getParameter("BuyItNowPrice");
	      if( buyItNowPrice != null && buyItNowPrice.length() > 0) {
	    	  AmountType at = new AmountType();
	    	  at.setValue(Double.valueOf(buyItNowPrice));
	    	  item.setBuyItNowPrice(at);
	      }

	      //get item listing type
	      String listingType = request.getParameter("ListingType");
	      item.setListingType(ListingTypeCodeType.fromValue(listingType));
	      
		  String itemDuration = request.getParameter("ItemDuration");
	      ListingDurationCodeType duration = ListingDurationCodeType.fromValue(itemDuration);
		  if (duration != null)
	      	item.setListingDuration(duration.value());

		  String quantity = request.getParameter("Quantity");
	      item.setQuantity(new Integer(quantity));
	      
		  String itemlocation = request.getParameter("ItemLocation");
	      item.setLocation(itemlocation);

	      item.setRegionID("0");
	      
	      item.setCountry(Global.getCountryCodeType(Global.apiContext.getSite()));;
	      
	      CurrencyCodeType currencyType = Global.getCurrencyOfSite(Global.apiContext.getSite());
	      item.setCurrency(currencyType);

		  HttpSession session = request.getSession();
		  CategoryFacade cf = (CategoryFacade)session.getAttribute(Global.SK_CATEGORYFACADE);
	      CategoryType cat = new CategoryType();
	      cat.setCategoryID(cf.getCatId());
		  item.setPrimaryCategory(cat);
		  
		  //set item condition
	      if (cf.getConditionEnabled() == ConditionEnabledCodeType.ENABLED || 
	       		cf.getConditionEnabled() == ConditionEnabledCodeType.REQUIRED) {
	    	  String condIdString = request.getParameter("ItemCondition");
	    	  Integer condId = Integer.parseInt(condIdString);
	    	  item.setConditionID(condId);
	      }
	}
	
	
	private void setItemSpecifics(ItemType item, HttpServletRequest request) {
		  HttpSession session = request.getSession();
		  
	      //add custom item specific
		  NameValueListArrayType  itemSpecifics = (NameValueListArrayType)session.getAttribute(Global.SK_CUSTOM_ITEM_SPECIFICS);
	      if(itemSpecifics != null){
	    	  item.setItemSpecifics(itemSpecifics);
	      }	
	}
	
}