package com.ebay.sample.itemSpecificsDemo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebay.sample.itemSpecificsDemo.Global;
import com.ebay.sample.itemSpecificsDemo.model.CategoryFacade;
import com.ebay.soap.eBLBaseComponents.NameRecommendationType;
import com.ebay.soap.eBLBaseComponents.NameValueListArrayType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;

/**
 * Servlet implementation class for Servlet: ItemSpecificsServlet
 *
 */
 public class ItemSpecificsServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ItemSpecificsServlet() {
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
			CategoryFacade cf = (CategoryFacade)session.getAttribute(Global.SK_CATEGORYFACADE);
			
			String submit = request.getParameter("btSubmit");
			
			if ("Continue".equals(submit)) {//Continue clicked
				
			      NameValueListArrayType  itemSpecifics = extractCustomItemSpecifics(request.getParameterMap());
			      session.setAttribute(Global.SK_CUSTOM_ITEM_SPECIFICS,itemSpecifics);
			      
			      response.sendRedirect(Global.ServletReturnPolicy);
				
			} else {//show item specifics input page
			
				NameRecommendationType[] nameRecommendationTypes = cf.getNameRecommendationTypes();
				request.setAttribute("Recommendations", nameRecommendationTypes);
				
				RequestDispatcher view = request.getRequestDispatcher(Global.PageItemSpecifics);
				view.forward(request, response);
				
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	private NameValueListArrayType  extractCustomItemSpecifics(Map map) {
		  int length = 0;
		  NameValueListArrayType nameValueArray = new NameValueListArrayType();
		  ArrayList<NameValueListType> list = new ArrayList<NameValueListType>();
		  Iterator iterator = map.keySet().iterator();
		  while(iterator.hasNext()){
			  String key = (String)iterator.next();
			  if(key.startsWith("itemSpecificName")){
				  String name = ((String[])map.get(key))[0];
				  NameValueListType nameValue = new NameValueListType();
				  int index = key.indexOf('_');
				  String label = key.substring(index+1);
				  String value = ((String[])map.get("itemSpecificValue_"+label))[0];
				  nameValue.setName(name);
				  nameValue.setValue(new String[]{value});
				  list.add(nameValue);
				  length++;
			  }
		  }
		  NameValueListType[] array = new NameValueListType[length];
		  nameValueArray.setNameValueList(list.toArray(array));
		  return nameValueArray;
   }
	
}