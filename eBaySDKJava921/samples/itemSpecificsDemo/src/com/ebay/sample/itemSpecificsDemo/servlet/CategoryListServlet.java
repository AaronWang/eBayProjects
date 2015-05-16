package com.ebay.sample.itemSpecificsDemo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebay.sample.itemSpecificsDemo.Global;
import com.ebay.sample.itemSpecificsDemo.bean.ListItem;
import com.ebay.sample.itemSpecificsDemo.model.CategoryFacade;
import com.ebay.sample.itemSpecificsDemo.model.SiteFacade;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.soap.eBLBaseComponents.CategoryFeatureType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.ItemSpecificsEnabledCodeType;
import com.ebay.soap.eBLBaseComponents.SiteDefaultsType;

/**
 * Servlet implementation class for Servlet: AttributesListServlet
 *
 */
 public class CategoryListServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CategoryListServlet() {
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
			HttpSession session = request.getSession();
			SiteFacade sf = (SiteFacade)session.getAttribute(Global.SK_SITEFACADE);
			
			String submit = request.getParameter("ListInCat");

			if ("Continue".equals(submit)) {//Continue clicked
				String catId = request.getParameter("catId");
				
				CategoryFacade cf = new CategoryFacade(catId, Global.apiContext,sf);
				session.setAttribute(Global.SK_CATEGORYFACADE, cf);
				
				//clear previous item specifics in session
				session.removeAttribute(Global.SK_CUSTOM_ITEM_SPECIFICS);
				
				response.sendRedirect(Global.ServletItemSpecifics);
				
				
			} else {
				
				ArrayList<CategoryType> sortedLeafCategories = this.getSortedLeafCategories(sf);
			    session.setAttribute(Global.SK_SORTEDLEAFCATEGORIES, sortedLeafCategories);
				
				
				//user input category id
				String catId = (String)session.getAttribute(Global.SK_CATEGORY_ID);
				
				ArrayList<ListItem> items = this.createCategoryList(sf, sortedLeafCategories,catId);
				
				request.setAttribute("ItemList", items);
				
				//no category found
				if(items.size() == 0) {
					request.setAttribute("NoCat", "NoCat");
				}
				
				RequestDispatcher view = request.getRequestDispatcher(Global.PageCategoryList);
				view.forward(request, response);
			}
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	private ArrayList<ListItem> createCategoryList(SiteFacade sf, ArrayList<CategoryType> sortedLeafCategories,String catId){
		Map<String, CategoryFeatureType> cfsMap = sf.getSiteCategoriesFeaturesMap().get(Global.apiContext.getSite());
		SiteDefaultsType siteDefaults = sf.getSiteFeatureDefaultMap().get(Global.apiContext.getSite());
		
		ArrayList<ListItem> items = new ArrayList<ListItem>();
		for(CategoryType cat : sortedLeafCategories) {
			String catName = cat.getCategoryName();
			
			//has user input category id?
			if (catId != null && catId.length() > 0) { 
				if (!catId.equals(cat.getCategoryID())) {
					continue;
				}
			}
			
			CategoryFeatureType cft = cfsMap.get(cat.getCategoryID());
			
			if(cft==null)
			{
				continue;
			}
			
			if(cft != null && cft.getItemSpecificsEnabled()!=null && ItemSpecificsEnabledCodeType.DISABLED == cft.getItemSpecificsEnabled()){
				continue;
			}
			
			
			if ((cft != null && cft.getItemSpecificsEnabled()!=null && ItemSpecificsEnabledCodeType.ENABLED == cft.getItemSpecificsEnabled()) 
					|| (siteDefaults != null && siteDefaults.getItemSpecificsEnabled()!=null && siteDefaults.getItemSpecificsEnabled() == ItemSpecificsEnabledCodeType.ENABLED))
			{
				String name;
			    String value;
			    if (catName != null && catName.length() > 1) {
			    	name = cat.getCategoryName() + "("+"CatId-" + cat.getCategoryID() +")";
				   	value = cat.getCategoryID();
			    }else{
			    	name = "("+"CatId-" + cat.getCategoryID() +")";
				   	value = cat.getCategoryID();
			    }
			   	
			    items.add(new ListItem(name, value));
			}
			
		}
		return items;
	}
 
	private ArrayList<CategoryType> getSortedLeafCategories(SiteFacade sf) throws ApiException, SdkException, Exception
	{

		ArrayList<CategoryType> catsList = new ArrayList(sf.getAllCategories().values());
		
		//sort the cats list
		Collections.sort(catsList, new Comparator() {
			public int compare(Object a, Object b) {
				CategoryType cat1 = (CategoryType)a;
				CategoryType cat2 = (CategoryType)b;
				int catId1 = Integer.parseInt(cat1.getCategoryID());
				int catId2 = Integer.parseInt(cat2.getCategoryID());
				return catId1 - catId2;
			}
		});
		
		//ignore non-leaf cats
		ArrayList<CategoryType> leafCats = new ArrayList<CategoryType>();
		for(CategoryType cat : catsList) {
			if(cat.isLeafCategory() != null && cat.isLeafCategory().booleanValue()) {
				leafCats.add(cat);
			}
		}
		
		return leafCats;
	}
}