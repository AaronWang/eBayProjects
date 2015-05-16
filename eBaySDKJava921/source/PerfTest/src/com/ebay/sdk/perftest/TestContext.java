/*
Copyright (c) 2006 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.ebay.sdk.perftest;

import org.w3c.dom.*;
import com.ebay.sdk.*;
import com.ebay.sdk.util.*;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class TestContext {

  static TestContext globalContext = null;

  private ApiContext apiContext = null;

  static final String CONFIG_XML_NAME = "PerfTestConfig.xml";

  public static TestContext getTestContext() throws Exception {
    if( globalContext == null )
    {
      globalContext = new TestContext();
      globalContext.loadConfiguration();
    }
    return globalContext;
  }
  
  public ApiContext getApiContext()
  {
    return this.apiContext;
  }

  public void loadConfiguration() throws Exception
  {
    String xmlPath = this.getConfigXmlPath();
    Document doc = XmlUtil.createDomByPathname(xmlPath);//getConfigXmlText()

    Node testConfig = XmlUtil.getChildByName(doc, "TestConfiguration");
    if( testConfig == null )
      throw new Exception("<TestConfiguration> was not found.");

    String s;

    this.apiContext = new ApiContext();

    s = XmlUtil.getChildString(testConfig, "ServerUrl").trim();
    this.apiContext.setApiServerUrl(s);

    s = XmlUtil.getChildString(testConfig, "EpsServerUrl").trim();
    this.apiContext.setEpsServerUrl(s);

    //
    ApiCredential apiCred = new ApiCredential();
    this.apiContext.setApiCredential(apiCred);

    ApiAccount ac = new ApiAccount();
    apiCred.setApiAccount(ac);

    Node eBayCredential = XmlUtil.getChildByName(testConfig, "eBayCredential");
    s = XmlUtil.getChildString(eBayCredential, "Token");
    apiCred.seteBayToken(s);
    
    s = XmlUtil.getChildString(testConfig, "Timeout");
    if (s.length() > 0)
    {
      int timeout = Integer.parseInt(s);
      this.apiContext.setTimeout(timeout);
    }
  }

   private String getConfigXmlPath()
  {
    return CONFIG_XML_NAME;
  }
}
