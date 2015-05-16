package com.ebay.sample.itemSpecificsDemo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiLogging;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

import com.ebay.sample.itemSpecificsDemo.Global;
import com.ebay.sample.itemSpecificsDemo.model.SiteFacade;

/**
 * Servlet implementation class for Servlet: SiteServlet
 *
 */
 public class SiteServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public SiteServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//clear previous session
		HttpSession session = request.getSession(false);
		if (session != null) session.invalidate();
		
		
		//forward to the selectSite page first
		RequestDispatcher view = request.getRequestDispatcher(Global.PageStart);
		view.forward(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submit = request.getParameter("Continue");
		if( submit != null ) {  
		  try {
			
			  SiteCodeType site = SiteCodeType.fromValue(request.getParameter("eBaySite"));
	      
			  Global.apiContext.setSite(site);
			  
			  SiteFacade sf = new SiteFacade(Global.apiContext);
			  
			  //cache session facade in the session scope
			  HttpSession session = request.getSession();
			  session.setAttribute(Global.SK_SITEFACADE, sf);
			  
			  //user input category id
			  String catId = request.getParameter("catId");
			  if (catId != null && catId.length() > 0) {
				  session.setAttribute(Global.SK_CATEGORY_ID, catId);
			  } else {
				  session.removeAttribute(Global.SK_CATEGORY_ID);
			  }
			  
			  response.sendRedirect(Global.ServletCategoryList);
			  
		  } catch(Exception e) {
			  throw new ServletException(e);
		  }
		}
	}   	  	  
	
	/* 
	 * first time initialization
	 */
	public void init() throws ServletException {
		super.init();
		
		initApiContext();
		
	    //init logger, to suppress debug level log of Tomcat
	    //Logger logger = Logger.getLogger("org.apache");
	    //logger.setLevel(Level.INFO);
	}
	
	private void initApiContext()
	{
		ServletContext application = this.getServletContext();
		
		if (Global.apiContext != null) {
			return;
		}
		
	    // Construct ApiContext.
	    ApiContext ctx = new ApiContext();

	    // Enabling logging ?
	    String str = (String)application.getInitParameter(Global.IK_ENABLELOGGING);
	    if( str.trim().equals("true") )
	    {
	      ApiLogging log = ctx.getApiLogging();
	      log.setLogSOAPMessages(true);
	      log.setLogExceptions(true);
	    }

	    ctx.setTimeout(480000);

	    String token = application.getInitParameter(Global.IK_APITOKEN);
	    if( token != null && token.length() > 10 ) {
	      ctx.getApiCredential().seteBayToken(token);
	    }

	    ctx.setApiServerUrl(application.getInitParameter(Global.IK_APISERVERURL));
	    ctx.setEpsServerUrl(application.getInitParameter(Global.IK_EPSSERVERURL));

	    //Cache the global ApiContext object
	    Global.apiContext = ctx;
	    
	}
}