/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.sanitytest;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.ApiLogging;
import com.ebay.sdk.util.XmlUtil;
import com.ebay.sdk.util.eBayUtil;

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

  static final String CONFIG_XML_NAME = "SanityTestConfig.xml";

  public static TestContext getTestContext() throws Exception {
    if( globalContext == null )
    {
      globalContext = new TestContext();
      globalContext.loadConfiguration();
    }
    return globalContext;
  }

  private boolean initializeLogger() throws Exception
  {
    // set logging in jsdk
    ApiLogging logging = this.apiContext.getApiLogging();
    logging.setLogSOAPMessages(true);
    logging.setLogExceptions(true);

    return false;
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

    this.initializeLogger();

    //
    ApiCredential apiCred = new ApiCredential();
    this.apiContext.setApiCredential(apiCred);

    ApiAccount ac = new ApiAccount();
    apiCred.setApiAccount(ac);

    //
    Node apiCredential = XmlUtil.getChildByName(testConfig, "ApiCredential");
    s = XmlUtil.getChildString(apiCredential, "Developer");
    ac.setDeveloper(s);
    s = XmlUtil.getChildString(apiCredential, "Application");
    ac.setApplication(s);
    s = XmlUtil.getChildString(apiCredential, "Certificate");
    ac.setCertificate(s);

    Node eBayCredential = XmlUtil.getChildByName(testConfig, "eBayCredential");
   

    s = XmlUtil.getChildString(eBayCredential, "Token");
    apiCred.seteBayToken(s);
    
    
    s=XmlUtil.getChildString(testConfig,"RuName");
    if(s.length() > 0){
    	this.apiContext.setRuName(s);
    }
    
    s = XmlUtil.getChildString(testConfig, "Timeout");
    if (s.length() > 0)
    {
      int timeout = Integer.parseInt(s);
      this.apiContext.setTimeout(timeout);
    }
  }

  static String getConfigXmlText() throws java.io.IOException
  {
    java.io.InputStream strm = SanityTestGUIRunner.class.getResourceAsStream(
        CONFIG_XML_NAME);
    return eBayUtil.convertInputStreamToString(strm);
  }

  private String getConfigXmlPath()
  {
    return CONFIG_XML_NAME;
  }

  public void saveConfiguration() throws Exception
  {
	  if (true)
	  {
		  return;
	  }
    //String dir = eBayUtil.getFullPathOfClass(TestContext.class);
    //String xmlPath = dir + CONFIG_XML_NAME;
    String xmlPath = this.getConfigXmlPath();

    Document doc = XmlUtil.createDomByPathname(xmlPath);

    Node testConfig = XmlUtil.getChildByName(doc, "TestConfiguration");

    XmlUtil.setChildValue(doc, testConfig, "ServerUrl", this.apiContext.getApiServerUrl());
    XmlUtil.setChildValue(doc, testConfig, "EpsServerUrl", this.apiContext.getEpsServerUrl());

    //XmlUtil.setChildValue(doc, testConfig, "LogFilePath", ?);

    //
    ApiCredential apiCred = this.apiContext.getApiCredential();

    ApiAccount ac = apiCred.getApiAccount();

    //
    Node apiCredential = XmlUtil.getChildByName(testConfig, "ApiCredential");

    XmlUtil.setChildValue(doc, apiCredential, "Developer", ac.getDeveloper());
    XmlUtil.setChildValue(doc, apiCredential, "Application", ac.getApplication());
    XmlUtil.setChildValue(doc, apiCredential, "Certificate", ac.getCertificate());

    Node eBayCredential = XmlUtil.getChildByName(testConfig, "eBayCredential");
    XmlUtil.setChildValue(doc, eBayCredential, "Token", apiCred.geteBayToken());

    // Write the DOM to file.
    XmlUtil.saveDomToFile(doc, xmlPath);
  }
}
