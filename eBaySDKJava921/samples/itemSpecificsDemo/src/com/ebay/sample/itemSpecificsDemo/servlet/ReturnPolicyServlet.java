package com.ebay.sample.itemSpecificsDemo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebay.sample.itemSpecificsDemo.Global;
import com.ebay.sample.itemSpecificsDemo.model.CategoryFacade;
import com.ebay.sample.itemSpecificsDemo.model.SiteFacade;
import com.ebay.soap.eBLBaseComponents.GeteBayDetailsResponseType;
import com.ebay.soap.eBLBaseComponents.SellerReturnProfileType;

/**
 * Servlet implementation class for Servlet: ReturnPolicyServlet
 *
 */
 public class ReturnPolicyServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ReturnPolicyServlet() {
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
			
			String submit = request.getParameter("btSubmit");
			
			if ("Continue".equals(submit)) {//Continue clicked
				
				/*
				 * The Business Policies API and related Trading API fields are
				 * available in sandbox. It will be available in production for a
				 * limited number of sellers with Version 775. 100 percent of sellers
				 * will be ramped up to use Business Polcies in July 2012
				 */
				
				SellerReturnProfileType sellerReturnProfile=new SellerReturnProfileType();
				if(request.getParameter("ReturnProfileId") !=null && request.getParameter("ReturnProfileId")!=""){
					sellerReturnProfile.setReturnProfileID(Long.valueOf(request.getParameter("ReturnProfileId")));
				}
				if(request.getParameter("ReturnProfileName")!= null && request.getParameter("ReturnProfileName")!=""){
					sellerReturnProfile.setReturnProfileName(request.getParameter("ReturnProfileName"));
				}
				
				session.setAttribute(Global.SELLER_RETURN_PROFILE, sellerReturnProfile);  
		    	
				response.sendRedirect(Global.PageAddItem);

			} else {//show return policy input page
			
				CategoryFacade cf = (CategoryFacade)session.getAttribute(Global.SK_CATEGORYFACADE);
				
				Boolean returnPolicyEnabled = cf.getRetPolicyEnabled();
				
				request.setAttribute("ReturnPolicyEnabled", returnPolicyEnabled);
				
				RequestDispatcher view = request.getRequestDispatcher(Global.PageReturnPolicy);
				view.forward(request, response);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}   	  	    
}