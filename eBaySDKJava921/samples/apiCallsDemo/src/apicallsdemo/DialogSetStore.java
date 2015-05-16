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

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.SetStoreCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.soap.eBLBaseComponents.StoreColorSchemeType;
import com.ebay.soap.eBLBaseComponents.StoreHeaderStyleCodeType;
import com.ebay.soap.eBLBaseComponents.StoreLogoType;
import com.ebay.soap.eBLBaseComponents.StoreSubscriptionLevelCodeType;
import com.ebay.soap.eBLBaseComponents.StoreThemeType;
import com.ebay.soap.eBLBaseComponents.StoreType;

/**
 * Demonstrate API SetStore.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogSetStore extends JDialog {
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
  JPanel jPanelName = new JPanel();
  JPanel jPanelThemeID = new JPanel();
  JTextField txtName = new JTextField();
  JTextField txtThemeID = new JTextField();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JPanel jPanelDescription = new JPanel();
  JTextField txtDescription = new JTextField();
  JLabel jLabel4 = new JLabel();
  JPanel jPanelSubscriptionLevel = new JPanel();
  JComboBox comboSubscriptionLevel = new JComboBox();
  JLabel jLabel5 = new JLabel();
  JPanel jPanelLogo = new JPanel();
  JTextField txtLogoID = new JTextField();
  JLabel jLabel6 = new JLabel();
  JPanel jPanelHeadStyle = new JPanel();
  JLabel jLabel7 = new JLabel();
  JComboBox comboHeaderStyle = new JComboBox();
  JPanel jPanelExportListing = new JPanel();
  JCheckBox cbxExportListing = new JCheckBox();
  JButton btnGetStoreOptions = new JButton();
  JTextField txtColorShemeID = new JTextField();
  JLabel jLabel8 = new JLabel();

  void initHeaderStyleCombo()
  {
    // Initialize combo box.
    Object[] list = new Object[] {
        new ControlTagItem("Full", StoreHeaderStyleCodeType.FULL),
        new ControlTagItem("Minimized", StoreHeaderStyleCodeType.MINIMIZED)
    };
    ComboBoxModel dataModel = new DefaultComboBoxModel(list);
    this.comboHeaderStyle.setModel(dataModel);
    this.comboHeaderStyle.setSelectedIndex(0);
  }

  void initSubscriptionLevelCombo()
  {
    // Initialize combo box.
    Object[] list = new Object[] {
        new ControlTagItem("Anchor", StoreSubscriptionLevelCodeType.ANCHOR),
        new ControlTagItem("Basic", StoreSubscriptionLevelCodeType.BASIC),
        new ControlTagItem("Close", StoreSubscriptionLevelCodeType.CLOSE),
        new ControlTagItem("Featured", StoreSubscriptionLevelCodeType.FEATURED)
    };
    ComboBoxModel dataModel = new DefaultComboBoxModel(list);
    this.comboSubscriptionLevel.setModel(dataModel);
    this.comboSubscriptionLevel.setSelectedIndex(0);
  }

  public DialogSetStore(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      this.initHeaderStyleCombo();

      this.initSubscriptionLevelCombo();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogSetStore() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setMaximumSize(new Dimension(129, 25));
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(128, 25));
    btnExecuteAPI.setText("SetStore");
    btnExecuteAPI.addActionListener(new DialogSetStore_btnExecuteAPI_actionAdapter(this));
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
    jLabel3.setText("Enter store information:");
    txtName.setPreferredSize(new Dimension(100, 21));
    txtName.setText("");
    txtThemeID.setMinimumSize(new Dimension(6, 21));
    txtThemeID.setPreferredSize(new Dimension(60, 21));
    txtThemeID.setToolTipText("");
    txtThemeID.setText("");
    jPanel1.setOpaque(true);
    jPanel1.setRequestFocusEnabled(true);
    panel1.setPreferredSize(new Dimension(680, 400));
    panel1.setRequestFocusEnabled(true);
    jLabel1.setText("Store name:");
    jLabel2.setText("Theme ID:");
    jLabel4.setText("Description:");
    txtDescription.setPreferredSize(new Dimension(200, 21));
    txtDescription.setText("");
    jLabel5.setText("Subscription level:");
    comboSubscriptionLevel.setPreferredSize(new Dimension(100, 21));
    jLabel6.setText("Logo ID:");
    txtLogoID.setPreferredSize(new Dimension(60, 21));
    txtLogoID.setText("");
    jLabel7.setText("Header Style:");
    comboHeaderStyle.setPreferredSize(new Dimension(100, 21));
    cbxExportListing.setText("Export the Store listings to comparison shopping websites");
    btnGetStoreOptions.setActionCommand("jButton1");
    btnGetStoreOptions.setText("GetStoreOptions");
    btnGetStoreOptions.addActionListener(new DialogSetStore_btnGetStoreOptions_actionAdapter(this));
    txtColorShemeID.setOpaque(true);
    txtColorShemeID.setPreferredSize(new Dimension(60, 21));
    txtColorShemeID.setSelectionStart(11);
    txtColorShemeID.setText("");
    jLabel8.setText("Color scheme ID:");
    jPanelHeadStyle.add(jLabel7, null);
    jPanelHeadStyle.add(comboHeaderStyle, null);
    jPanelThemeID.add(jLabel2, null);
    jPanelThemeID.add(txtThemeID, null);
    jPanelThemeID.add(jLabel8, null);
    jPanelThemeID.add(txtColorShemeID, null);
    jPanelName.add(jLabel1, null);
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(btnExecuteAPI, null);
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(jPanel7, BorderLayout.CENTER);
    jPanelName.add(txtName, null);
    jPanel7.add(jPanelName, null);
    jPanel7.add(jPanelDescription, null);
    jPanelDescription.add(jLabel4, null);
    jPanelDescription.add(txtDescription, null);
    jPanel7.add(jPanelLogo, null);
    jPanel7.add(jPanelExportListing, null);
    jPanelLogo.add(jLabel6, null);
    jPanelLogo.add(txtLogoID, null);
    jPanel7.add(jPanelThemeID, null);
    jPanel5.add(jPanel8,  BorderLayout.NORTH);
    jPanel8.add(jLabel3, null);
    jPanel8.add(btnGetStoreOptions, null);


    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel7.add(jPanelSubscriptionLevel, null);
    jPanelSubscriptionLevel.add(jLabel5, null);
    jPanelSubscriptionLevel.add(comboSubscriptionLevel, null);
    jPanel7.add(jPanelHeadStyle, null);
    jPanelExportListing.add(cbxExportListing, null);

    jPanel1.setPreferredSize(new Dimension(800, 190));
    this.setSize(new Dimension(649, 221));
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    FrameDemo fd = (FrameDemo)this.getParent();

    String s;

    try
    {
      SetStoreCall api = new SetStoreCall(this.apiContext);

      StoreType store = new StoreType();
      store.setName(this.txtName.getText());
      store.setDescription(this.txtDescription.getText());
      store.setExportListings(new Boolean(this.cbxExportListing.isSelected()));

      ControlTagItem ct = (ControlTagItem)this.comboHeaderStyle.getSelectedItem();
      store.setHeaderStyle((StoreHeaderStyleCodeType)ct.Tag);

      ct = (ControlTagItem)this.comboSubscriptionLevel.getSelectedItem();
      store.setSubscriptionLevel((StoreSubscriptionLevelCodeType)ct.Tag);

      s = this.txtLogoID.getText();
      if( s.length() > 0 )
      {
        StoreLogoType logo = new StoreLogoType();
        logo.setLogoID(new Integer(s));
        store.setLogo(logo);
      }

      s = this.txtThemeID.getText();
      if( s.length() > 0 )
      {
        StoreThemeType theme = new StoreThemeType();
        theme.setThemeID(new Integer(s));
        store.setTheme(theme);

        //
        StoreColorSchemeType scs = new StoreColorSchemeType();
        scs.setColorSchemeID(new Integer(this.txtColorShemeID.getText()));

        theme.setColorScheme(scs);
      }

      api.setStoreType(store);

      api.setStore();

      fd.showInfoMessage("The store has been set successfully!");
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

class DialogSetStore_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogSetStore adaptee;

  DialogSetStore_btnExecuteAPI_actionAdapter(DialogSetStore adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}

class DialogSetStore_btnGetStoreOptions_actionAdapter implements java.awt.event.ActionListener {
  DialogSetStore adaptee;

  DialogSetStore_btnGetStoreOptions_actionAdapter(DialogSetStore adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetStoreOptions_actionPerformed(e);
  }
}
