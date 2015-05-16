/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package apicallsdemo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.SetStorePreferencesCall;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.soap.eBLBaseComponents.StorePreferencesType;
import com.ebay.soap.eBLBaseComponents.StoreVacationPreferencesType;

/**
 * Demonstrate API SetStorePreferences.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogSetStorePreferences extends JDialog {
  private ApiContext apiContext = new ApiContext();

  //
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();

  JPanel panel1 = new JPanel();

  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JButton btnExecuteAPI = new JButton();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel15 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JLabel jLabel3 = new JLabel();
  JPanel jPanelDispCustMsg = new JPanel();
  JPanel jPanelMsgItem = new JPanel();
  JPanel jPanelCustMsg = new JPanel();
  JTextField txtCustomMsg = new JTextField();
  JLabel jLabel4 = new JLabel();
  JPanel jPanelMsgStore = new JPanel();
  JPanel jPanelVacation = new JPanel();
  JPanel jPanelReturnDate = new JPanel();
  JPanel jPanelHideItem = new JPanel();
  JCheckBox cbxHideItem = new JCheckBox();
  JCheckBox cbxDispCustomMsg = new JCheckBox();
  JCheckBox cbxOnVacation = new JCheckBox();
  JCheckBox cbxMsgItem = new JCheckBox();
  JCheckBox cbxMsgStore = new JCheckBox();
  JLabel jLabel1 = new JLabel();
  JTextField txtReturnDate = new JTextField();
  JLabel jLabel2 = new JLabel();

  public DialogSetStorePreferences(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogSetStorePreferences() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setMaximumSize(new Dimension(129, 25));
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(148, 25));
    btnExecuteAPI.setText("SetStorePreferences");
    btnExecuteAPI.addActionListener(new DialogSetStorePreferences_btnExecuteAPI_actionAdapter(this));
    jPanel5.setLayout(borderLayout5);
    jPanel6.setPreferredSize(new Dimension(143, 40));
    jPanel6.setLayout(borderLayout4);
    jPanel5.setOpaque(true);
    jPanel5.setPreferredSize(new Dimension(10, 160));
    jPanel7.setLayout(gridLayout1);
    gridLayout1.setColumns(2);
    gridLayout1.setHgap(5);
    gridLayout1.setRows(4);
    gridLayout1.setVgap(5);
    jPanel7.setPreferredSize(new Dimension(114, 100));
    jLabel3.setText("Enter store preferences");
    jPanel1.setOpaque(true);
    jPanel1.setRequestFocusEnabled(true);
    panel1.setPreferredSize(new Dimension(680, 400));
    panel1.setRequestFocusEnabled(true);
    jLabel4.setText("Custom message:");
    txtCustomMsg.setMinimumSize(new Dimension(160, 21));
    txtCustomMsg.setPreferredSize(new Dimension(160, 21));
    txtCustomMsg.setText("");
    cbxHideItem.setText(" Hide Store Inventory format items during vacation.");
    cbxDispCustomMsg.setText(" Display custom message on the Store pages");
    cbxOnVacation.setText("The store owner is on vacation");
    cbxMsgItem.setText("During vacation add a message to all their active items.");
    cbxMsgStore.setText("During vacation add a message to all the Store pages.");
    jLabel1.setText("(yyyy-mm-dd hh:mm:ss)");
    jLabel2.setText("Return date:");
    txtReturnDate.setMinimumSize(new Dimension(120, 21));
    txtReturnDate.setPreferredSize(new Dimension(120, 21));
    txtReturnDate.setSelectionStart(1);
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(btnExecuteAPI, null);
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(jPanel7, BorderLayout.CENTER);
    jPanelDispCustMsg.add(cbxDispCustomMsg, null);

    jPanelCustMsg.add(jLabel4, null);
    jPanelCustMsg.add(txtCustomMsg, null);
    jPanel7.add(jPanelVacation, null);
    jPanel7.add(jPanelReturnDate, null);
    jPanel7.add(jPanelDispCustMsg, null);
    jPanel7.add(jPanelCustMsg, null);
    jPanel7.add(jPanelHideItem, null);
    jPanel7.add(jPanelMsgItem, null);
    jPanel5.add(jPanel8,  BorderLayout.NORTH);
    jPanel8.add(jLabel3, null);


    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel7.add(jPanelMsgStore, null);
    jPanelMsgStore.add(cbxMsgStore, null);
    jPanelReturnDate.add(jLabel2, null);
    jPanelReturnDate.add(txtReturnDate, null);
    jPanelReturnDate.add(jLabel1, null);
    jPanelHideItem.add(cbxHideItem, null);
    jPanelVacation.add(cbxOnVacation, null);
    jPanelMsgItem.add(cbxMsgItem, null);

    jPanel1.setPreferredSize(new Dimension(800, 190));
    this.setSize(new Dimension(665, 221));
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    FrameDemo fd = (FrameDemo)this.getParent();

    String s;

    try
    {
      SetStorePreferencesCall api = new SetStorePreferencesCall(this.apiContext);

      StorePreferencesType pref = new StorePreferencesType();
      api.setStorePreferences(pref);

      StoreVacationPreferencesType spf = new StoreVacationPreferencesType();
      pref.setVacationPreferences(spf);

      spf.setOnVacation(new Boolean(this.cbxOnVacation.isSelected()));
      if (this.txtReturnDate.getText().trim().length() > 0) {
        java.util.Calendar date = GuiUtil.getCalendarFromField(this.txtReturnDate);
        spf.setReturnDate(date);
      }

      spf.setDisplayMessageStoreCustomText(new Boolean(this.cbxDispCustomMsg.isSelected()));
      spf.setMessageStoreCustomText(this.txtCustomMsg.getText());

      spf.setHideFixedPriceStoreItems(new Boolean(this.cbxHideItem.isSelected()));
      spf.setMessageItem(new Boolean(this.cbxMsgItem.isSelected()));
      spf.setMessageStore(new Boolean(this.cbxMsgStore.isSelected()));

      api.setStorePreferences(pref);
      api.setStorePreferences();

      fd.showInfoMessage("The store preferences has been successfully set!");
    }
    catch (Exception ex) {
      fd.showErrorMessage(ex.getMessage());
    }
  }

  void btnGetStoreOptions_actionPerformed(ActionEvent e) {
    FrameDemo fd = (FrameDemo)this.getParent();
    fd.getStoreOptions(fd);
  }
}

class DialogSetStorePreferences_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogSetStorePreferences adaptee;

  DialogSetStorePreferences_btnExecuteAPI_actionAdapter(DialogSetStorePreferences adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}
