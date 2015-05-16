/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.sanitytest;

import javax.swing.UIManager;

import com.ebay.sdk.helper.ui.DialogAccount;
import com.ebay.sdk.helper.ui.GuiUtil;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class SanityTestGUIRunner {

  public SanityTestGUIRunner() {
    try {
      jbInit();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      TestContext context = TestContext.getTestContext();
      DialogAccount dlg = new DialogAccount(null, context.getApiContext(), "Config Test Context", true);
      GuiUtil.CenterComponent(dlg);
      dlg.setVisible(true);

      if(!dlg.isCancelled()) {
        context.saveConfiguration();
        junit.swingui.TestRunner runner = new junit.swingui.TestRunner();
        runner.start( new String[]{"-noloading", AllSoapTestsSuite.class.getName()} );
      } else
        System.exit(0);
    } catch(Exception e) {
      e.printStackTrace();
    }
   }

  private void jbInit() throws Exception {
  }
}
