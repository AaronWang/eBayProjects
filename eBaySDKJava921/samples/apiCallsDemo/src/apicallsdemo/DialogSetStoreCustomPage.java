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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.SetStoreCustomPageCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.soap.eBLBaseComponents.StoreCustomPageStatusCodeType;
import com.ebay.soap.eBLBaseComponents.StoreCustomPageType;

/**
 * Demonstrate API SetStoreCustomPage.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogSetStoreCustomPage extends JDialog {

  private ApiContext apiContext = new ApiContext();

  //
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();
  BorderLayout borderLayout3 = new BorderLayout();

  JPanel panel1 = new JPanel();

  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JButton btnExecuteAPI = new JButton();
  JPanel jPanel6 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable tblAlerts = new JTable();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel15 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel14 = new JPanel();
  JLabel lblHtmlContent = new JLabel();
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel18 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JPanel jPanelStoreInfo = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanelStoreName = new JPanel();
  JPanel jPanelPreviewEnabled = new JPanel();
  JPanel jPanelPageOrder = new JPanel();
  JPanel jPanelPageID = new JPanel();
  JTextField txtStoreName = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtPageID = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtPageOrder = new JTextField();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JTextArea txtPageContent = new JTextArea();
  JCheckBox cbxPreviewEnabled = new JCheckBox();
  JPanel jPanelLeftNav = new JPanel();
  JCheckBox cbxLeftNavBar = new JCheckBox();
  JPanel jPanelPageStatus = new JPanel();
  JComboBox comboPageStatus = new JComboBox();
  JLabel jLabel5 = new JLabel();

  public DialogSetStoreCustomPage(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      // Initialize combo box.
      Object[] list = new Object[] {
          new ControlTagItem("Active", StoreCustomPageStatusCodeType.ACTIVE),
          new ControlTagItem("Inactive", StoreCustomPageStatusCodeType.INACTIVE),
          new ControlTagItem("Delete", StoreCustomPageStatusCodeType.DELETE)
      };
      ComboBoxModel dataModel = new DefaultComboBoxModel(list);
      this.comboPageStatus.setModel(dataModel);
      this.comboPageStatus.setSelectedIndex(0);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogSetStoreCustomPage() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setMinimumSize(new Dimension(133, 25));
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(160, 25));
    btnExecuteAPI.setText("SetStoreCustomPage");
    btnExecuteAPI.addActionListener(new DialogSetStoreCustomPage_btnExecuteAPI_actionAdapter(this));
    jPanel6.setPreferredSize(new Dimension(143, 40));
    jPanel6.setLayout(borderLayout4);
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setPreferredSize(new Dimension(600, 180));
    jPanel1.setRequestFocusEnabled(true);
    panel1.setPreferredSize(new Dimension(680, 558));
    panel1.setRequestFocusEnabled(true);
    jPanel11.setLayout(borderLayout6);
    lblHtmlContent.setToolTipText("");
    lblHtmlContent.setVerifyInputWhenFocusTarget(true);
    lblHtmlContent.setText("HTML Content of the Page");
    jPanel12.setLayout(borderLayout7);
    jPanel11.setPreferredSize(new Dimension(464, 300));
    jPanel12.setPreferredSize(new Dimension(464, 100));
    jPanelStoreInfo.setLayout(gridLayout1);
    gridLayout1.setColumns(2);
    gridLayout1.setRows(3);
    jLabel1.setText("Page name:");
    txtStoreName.setBackground(Color.white);
    txtStoreName.setPreferredSize(new Dimension(120, 21));
    txtStoreName.setEditable(true);
    txtStoreName.setText("");
    jLabel2.setPreferredSize(new Dimension(80, 15));
    jLabel2.setText("Page ID:");
    txtPageID.setBackground(Color.white);
    txtPageID.setMinimumSize(new Dimension(6, 21));
    txtPageID.setPreferredSize(new Dimension(60, 21));
    txtPageID.setToolTipText("");
    txtPageID.setEditable(true);
    txtPageID.setSelectionStart(3);
    txtPageID.setText("");
    jLabel4.setMinimumSize(new Dimension(56, 15));
    jLabel4.setPreferredSize(new Dimension(80, 15));
    jLabel4.setRequestFocusEnabled(true);
    jLabel4.setText("Page order:");
    txtPageOrder.setBackground(Color.white);
    txtPageOrder.setPreferredSize(new Dimension(60, 21));
    txtPageOrder.setText("");
    jLabel3.setText("Enter your store custom page.");
    cbxPreviewEnabled.setText("Preview enabled");
    cbxLeftNavBar.setText("Show left nagivation bar.");
    comboPageStatus.setPreferredSize(new Dimension(100, 21));
    jLabel5.setText("Status:");
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.SOUTH);
    jPanel1.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(btnExecuteAPI, null);

    panel1.add(jPanel2, BorderLayout.CENTER);
    jPanel2.setLayout(borderLayout3);
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.add(jPanel11, BorderLayout.CENTER);
    jPanel11.add(jPanel13,  BorderLayout.NORTH);
    jPanel13.add(lblHtmlContent, null);
    jPanel11.add(jPanel14, BorderLayout.CENTER);
    jPanel14.add(jScrollPane1, null);
    jPanel2.add(jPanel12,  BorderLayout.NORTH);
    jPanel12.add(jPanel7,  BorderLayout.NORTH);
    jPanel12.add(jPanelStoreInfo, BorderLayout.CENTER);
    jPanelStoreInfo.add(jPanelStoreName, null);
    jPanelStoreName.add(jLabel1, null);
    jPanelStoreName.add(txtStoreName, null);
    jPanelStoreInfo.add(jPanelPageID, null);
    jPanelStoreInfo.add(jPanelPageStatus, null);
    jPanelPageID.add(jLabel2, null);
    jPanelPageID.add(txtPageID, null);
    jPanelStoreInfo.add(jPanelPageOrder, null);
    jPanelStoreInfo.add(jPanelLeftNav, null);
    jPanelPageOrder.add(jLabel4, null);
    jPanelPageOrder.add(txtPageOrder, null);
    jPanelStoreInfo.add(jPanelPreviewEnabled, null);
    jPanelPreviewEnabled.add(cbxPreviewEnabled, null);
    jPanel2.add(jPanel18,  BorderLayout.SOUTH);

    panel1.add(jPanel3, BorderLayout.NORTH);
    jPanel3.add(jLabel3, null);
    jScrollPane1.getViewport().add(txtPageContent, null);
    jPanelLeftNav.add(cbxLeftNavBar, null);
    jPanelPageStatus.add(jLabel5, null);
    jPanelPageStatus.add(comboPageStatus, null);

    jPanel1.setPreferredSize(new Dimension(800, 50));
    this.setSize(new Dimension(658, 415));
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    String s;

    FrameDemo fd = (FrameDemo)this.getParent();

    try
    {
      SetStoreCustomPageCall api = new SetStoreCustomPageCall(this.apiContext);

      StoreCustomPageType custPage = new StoreCustomPageType();
      api.setStoreCustomPage(custPage);

      custPage.setName(this.txtStoreName.getText());

      s = this.txtPageID.getText();
      if( s.length() > 0 )
        custPage.setPageID(new Long(s));

      s = this.txtPageOrder.getText();
      if( s.length() > 0 )
        custPage.setOrder(new Integer(s));

      custPage.setLeftNav(new Boolean(this.cbxLeftNavBar.isSelected()));

      custPage.setPreviewEnabled(new Boolean(this.cbxPreviewEnabled.isSelected()));

      ControlTagItem ct = (ControlTagItem)this.comboPageStatus.getSelectedItem();
      custPage.setStatus((StoreCustomPageStatusCodeType)ct.Tag);

      custPage.setContent(this.txtPageContent.getText());

      // Execute the API.
      api.setStoreCustomPage();

      //
      fd.showInfoMessage("The store custom page have been set successfully!");
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogSetStoreCustomPage_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogSetStoreCustomPage adaptee;

  DialogSetStoreCustomPage_btnExecuteAPI_actionAdapter(DialogSetStoreCustomPage adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}
