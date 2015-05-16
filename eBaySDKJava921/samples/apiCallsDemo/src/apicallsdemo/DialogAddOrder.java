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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.AddOrderCall;
import com.ebay.sdk.helper.InternationalShippingServiceSelector;
import com.ebay.sdk.helper.ServiceControlManager;
import com.ebay.sdk.helper.ShippingServiceHelper;
import com.ebay.sdk.helper.ShippingServiceSelector;
import com.ebay.sdk.helper.ui.ControlBuilder;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.soap.eBLBaseComponents.AddOrderResponseType;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BuyerPaymentMethodCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.InternationalShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.ebay.soap.eBLBaseComponents.TradingRoleCodeType;
import com.ebay.soap.eBLBaseComponents.TransactionArrayType;
import com.ebay.soap.eBLBaseComponents.TransactionType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Changyi
 * @version 1.0
 */
public class DialogAddOrder extends JDialog
{
  private ApiContext apiContext = new ApiContext();

  Frame parentFrame;
  SiteCodeType siteId;

  ControlTagItem[] ctrlShippingServices = new ControlTagItem[] {};
  ControlTagItem[] ctrlIntlShippingServices = new ControlTagItem[] {};
  ControlTagItem[] ctrlPaymentServices = new ControlTagItem[] {};

  JCheckBox[] ckbPaymentServices;
  ArrayList shippingServiceOptions = new ArrayList();
  ArrayList intlShippingServiceOptions = new ArrayList();

  static ControlTagItem[] tradingRole = new ControlTagItem[] {
      new ControlTagItem(TradingRoleCodeType.BUYER.value(), TradingRoleCodeType.BUYER),
      new ControlTagItem(TradingRoleCodeType.SELLER.value(), TradingRoleCodeType.SELLER)
  };

  BorderLayout borderLayout1 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;

  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JButton btnAddOrder = new JButton();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtOrderId = new JTextField();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel14 = new JPanel();
  JPanel jPanel15 = new JPanel();
  JPanel jPanel16 = new JPanel();
  JButton btnAddShippingService = new JButton();
  JButton btnRemoveShippingService = new JButton();
  JButton btnAddIntlShippingService = new JButton();
  JButton btnRemoveIntlShippingService = new JButton();
  BorderLayout borderLayout7 = new BorderLayout();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JScrollPane spShippingServiceOptions = new JScrollPane();
  BorderLayout borderLayout8 = new BorderLayout();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JScrollPane spIntlShippingServiceOptions = new JScrollPane();
  BorderLayout borderLayout9 = new BorderLayout();
  JPanel jPanel17 = new JPanel();
  JPanel jPanel18 = new JPanel();
  JPanel jPanel19 = new JPanel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  GridBagLayout gridBagLayout6 = new GridBagLayout();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JComboBox cbxSite = new JComboBox();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JTextField txtItemId1 = new JTextField();
  JTextField txtTransactionId1 = new JTextField();
  JLabel jLabel22 = new JLabel();
  JComboBox cbxTradingRole = new JComboBox();
  JLabel jLabel23 = new JLabel();
  JLabel lbItemId2 = new JLabel();
  JLabel lbTransactionId2 = new JLabel();
  JTextField txtTransactionId2 = new JTextField();
  JTextField txtItemId2 = new JTextField();
  JLabel jLabel26 = new JLabel();
  JLabel jLabel27 = new JLabel();
  JTextField txtTotal = new JTextField();
  JLabel jLabel28 = new JLabel();
  JLabel jLabel29 = new JLabel();
  JLabel jLabel30 = new JLabel();
  JLabel jLabel31 = new JLabel();
  JComboBox cbxIntlShippingServiceSelected = new JComboBox();
  JTextField txtShippingServiceSelectedCost = new JTextField();
  JComboBox cbxShippingServiceSelected = new JComboBox();
  JLabel jLabel24 = new JLabel();
  JLabel jLabel32 = new JLabel();
  JComboBox cbxCurrency = new JComboBox();
  BorderLayout borderLayout10 = new BorderLayout();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JPanel jPanel20 = new JPanel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel33 = new JLabel();
  BorderLayout borderLayout11 = new BorderLayout();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JPanel jPanel21 = new JPanel();
  GridBagLayout gridBagLayout5 = new GridBagLayout();
  JLabel jLabel34 = new JLabel();
  BorderLayout borderLayout12 = new BorderLayout();
  JPanel jPanel22 = new JPanel();
  JPanel jPanel23 = new JPanel();
  JPanel jPanel24 = new JPanel();
  BorderLayout borderLayout13 = new BorderLayout();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel35 = new JLabel();
  GridBagLayout gridBagLayout4 = new GridBagLayout();
  JLabel jLabel36 = new JLabel();
  JLabel jLabel37 = new JLabel();
  JLabel jLabel38 = new JLabel();


  public DialogAddOrder(Frame frame, String title, SiteCodeType siteId, boolean modal) {
    super(frame, title, modal);
    this.siteId = siteId;
    this.parentFrame = frame;
    try {
      jbInit();
      customInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private DialogAddOrder() {
    this(null, "", SiteCodeType.US, false);
  }

  private void jbInit() throws Exception {

    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    jPanel1.setLayout(borderLayout2);
    this.setModal(true);
    this.setTitle("eBay SDK for Java - AddOrder");

    jPanel2.setLayout(borderLayout9);
    jPanel3.setLayout(borderLayout3);
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    jPanel4.setLayout(borderLayout12);
    jPanel5.setBorder(null);
    jPanel5.setLayout(borderLayout4);
    jPanel6.setBorder(BorderFactory.createEtchedBorder());
    jPanel6.setLayout(gridBagLayout1);

    this.jPanel2.setPreferredSize(new Dimension(600, 240));
    this.jPanel3.setPreferredSize(new Dimension(600, 350));
    this.jPanel4.setPreferredSize(new Dimension(600, 80));
    this.jPanel5.setPreferredSize(new Dimension(600, 250));
    this.jPanel6.setPreferredSize(new Dimension(600, 60));
    this.jPanel7.setPreferredSize(new Dimension(600, 50));

    btnAddOrder.setText("AddOrder");
    btnAddOrder.addActionListener(new DialogAddOrder_btnAddOrder_actionAdapter(this));
    jLabel1.setPreferredSize(new Dimension(80, 15));
    jLabel1.setText("OrderID:");
    jLabel2.setText("        ");
    txtOrderId.setBackground(Color.lightGray);
    txtOrderId.setPreferredSize(new Dimension(100, 21));
    txtOrderId.setText("");
    jPanel7.setBorder(BorderFactory.createEtchedBorder());

    jPanel8.setLayout(borderLayout5);
    jPanel8.setBorder(BorderFactory.createEtchedBorder());
    jPanel9.setLayout(borderLayout6);
    jPanel11.setLayout(borderLayout10);
    jPanel14.setLayout(borderLayout11);
    btnAddShippingService.setBorder(BorderFactory.createEtchedBorder());
    btnAddShippingService.setPreferredSize(new Dimension(49, 20));
    btnAddShippingService.setRequestFocusEnabled(true);
    btnAddShippingService.setContentAreaFilled(true);
    btnAddShippingService.setText("    Add    ");
    btnAddShippingService.addActionListener(new DialogAddOrder_btnAddShippingService_actionAdapter(this));
    btnRemoveShippingService.setBorder(BorderFactory.createEtchedBorder());
    btnRemoveShippingService.setMaximumSize(new Dimension(55, 20));
    btnRemoveShippingService.setPreferredSize(new Dimension(55, 20));
    btnRemoveShippingService.setText("  Remove  ");
    btnRemoveShippingService.addActionListener(new DialogAddOrder_btnRemoveShippingService_actionAdapter(this));
    btnAddIntlShippingService.setBorder(BorderFactory.createEtchedBorder());
    btnAddIntlShippingService.setPreferredSize(new Dimension(49, 20));
    btnAddIntlShippingService.setRequestFocusEnabled(true);
    btnAddIntlShippingService.setRolloverEnabled(false);
    btnAddIntlShippingService.setText("  Add  ");
    btnAddIntlShippingService.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    btnAddIntlShippingService.addActionListener(new DialogAddOrder_btnAddIntlShippingService_actionAdapter(this));
    btnRemoveIntlShippingService.setBorder(BorderFactory.createEtchedBorder());
    btnRemoveIntlShippingService.setPreferredSize(new Dimension(55, 20));
    btnRemoveIntlShippingService.setRequestFocusEnabled(true);
    btnRemoveIntlShippingService.setText("Remove");
    btnRemoveIntlShippingService.addActionListener(new DialogAddOrder_btnRemoveIntlShippingService_actionAdapter(this));
    jPanel13.setLayout(borderLayout7);
    jLabel10.setText(" ");
    jLabel11.setText(" ");
    jPanel16.setLayout(borderLayout8);
    jLabel12.setText(" ");
    jLabel13.setText(" ");
    spShippingServiceOptions.getViewport().setBackground(Color.white);
    spIntlShippingServiceOptions.getViewport().setBackground(Color.white);
    jPanel19.setLayout(gridBagLayout3);
    jPanel17.setLayout(gridBagLayout6);
    jLabel5.setText("Site:");
    jLabel14.setText("              ");
    cbxSite.addActionListener(new DialogAddOrder_cbxSite_actionAdapter(this));
    jLabel15.setText("OrderCurrency:");
    jLabel16.setText("    ");
    jLabel17.setText("        ");
    jLabel18.setText("TradingRole:");
    jLabel19.setText("  ");
    jLabel20.setText("    ");
    jLabel21.setText("ItemID (1):");
    txtItemId1.setMinimumSize(new Dimension(100, 21));
    txtItemId1.setPreferredSize(new Dimension(100, 21));
    txtItemId1.setText("");
    txtTransactionId1.setMinimumSize(new Dimension(100, 21));
    txtTransactionId1.setPreferredSize(new Dimension(100, 21));
    txtTransactionId1.setText("");
    jLabel22.setText("TransactionID (1):");
    jLabel23.setText("    ");
    lbItemId2.setText("ItemID (2):");
    lbTransactionId2.setText("TransactionID (2):");
    txtTransactionId2.setMinimumSize(new Dimension(100, 21));
    txtTransactionId2.setPreferredSize(new Dimension(100, 21));
    txtTransactionId2.setText("");
    txtItemId2.setMaximumSize(new Dimension(2147483647, 2147483647));
    txtItemId2.setMinimumSize(new Dimension(100, 21));
    txtItemId2.setPreferredSize(new Dimension(100, 21));
    txtItemId2.setText("");
    jLabel26.setText("    ");
    jLabel27.setText("Total (cost):");
    txtTotal.setMinimumSize(new Dimension(100, 21));
    txtTotal.setPreferredSize(new Dimension(100, 21));
    txtTotal.setText("");
    jLabel28.setText("    ");
    jLabel29.setText("ShippingServiceSelectedCost:");
    jLabel30.setText("ShippingServiceSelected:");
    jLabel31.setText("IntlShippingServiceSelected:");
    txtShippingServiceSelectedCost.setMinimumSize(new Dimension(100, 21));
    txtShippingServiceSelectedCost.setPreferredSize(new Dimension(100, 21));
    txtShippingServiceSelectedCost.setText("");
    jLabel24.setText("    ");
    jLabel32.setText("");
    cbxShippingServiceSelected.addActionListener(new DialogAddOrder_cbxShippingServiceSelected_actionAdapter(this));
    cbxIntlShippingServiceSelected.addActionListener(new DialogAddOrder_cbxIntlShippingServiceSelected_actionAdapter(this));
    jLabel6.setText("  ShippingServiceOptions:                    ");
    jLabel7.setText("    ");
    jPanel20.setLayout(gridBagLayout2);
    jLabel33.setText("        ");
    jLabel8.setText("  InternationalShippingServiceOptions:");
    jLabel9.setText("    ");
    jPanel21.setLayout(gridBagLayout5);
    jLabel34.setText("        ");
    jPanel22.setBorder(null);
    jPanel22.setPreferredSize(new Dimension(10, 25));
    jPanel22.setLayout(borderLayout13);
    jPanel23.setPreferredSize(new Dimension(10, 1));
    jPanel23.setRequestFocusEnabled(true);
    jLabel3.setText("  PaymentMethods:");
    jPanel24.setLayout(gridBagLayout4);
    jLabel4.setText("      ");
    jLabel35.setText("    ");
    jLabel36.setText(" ");
    jLabel37.setText(" ");
    jLabel38.setPreferredSize(new Dimension(12, 15));
    jLabel38.setRequestFocusEnabled(true);
    jLabel38.setText(" ");
    cbxShippingServiceSelected.setMinimumSize(new Dimension(100, 21));
    cbxShippingServiceSelected.setPreferredSize(new Dimension(100, 21));
    cbxIntlShippingServiceSelected.setMinimumSize(new Dimension(100, 21));
    cbxIntlShippingServiceSelected.setPreferredSize(new Dimension(100, 21));
    cbxTradingRole.setMinimumSize(new Dimension(100, 21));
    cbxTradingRole.setPreferredSize(new Dimension(100, 21));
    cbxCurrency.setMinimumSize(new Dimension(100, 21));
    cbxCurrency.setPreferredSize(new Dimension(100, 21));
    cbxSite.setMinimumSize(new Dimension(100, 21));
    cbxSite.setPreferredSize(new Dimension(100, 21));
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jPanel5, BorderLayout.NORTH);
    jPanel5.add(jPanel8, BorderLayout.NORTH);
    jPanel8.add(jPanel11, BorderLayout.NORTH);
    jPanel11.add(jLabel6, BorderLayout.WEST);
    jPanel11.add(jLabel7, BorderLayout.EAST);
    jPanel11.add(jPanel20, BorderLayout.CENTER);
    jPanel20.add(btnAddShippingService, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel20.add(jLabel33, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel20.add(btnRemoveShippingService, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jPanel12, BorderLayout.SOUTH);
    jPanel8.add(jPanel13, BorderLayout.CENTER);
    jPanel13.add(jLabel10, BorderLayout.WEST);
    jPanel13.add(jLabel11, BorderLayout.EAST);
    jPanel13.add(spShippingServiceOptions, BorderLayout.CENTER);
    jPanel5.add(jPanel9, BorderLayout.SOUTH);
    jPanel9.add(jPanel14, BorderLayout.NORTH);
    jPanel14.add(jLabel8, BorderLayout.WEST);
    jPanel14.add(jLabel9, BorderLayout.EAST);
    jPanel14.add(jPanel21, BorderLayout.CENTER);
    jPanel21.add(btnAddIntlShippingService, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(jLabel34, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(btnRemoveIntlShippingService, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jPanel15, BorderLayout.SOUTH);
    jPanel9.add(jPanel16, BorderLayout.CENTER);
    jPanel16.add(jLabel12, BorderLayout.WEST);
    jPanel16.add(jLabel13, BorderLayout.EAST);
    jPanel16.add(spIntlShippingServiceOptions, BorderLayout.CENTER);
    jPanel5.add(jPanel10, BorderLayout.CENTER);
    jPanel3.add(jPanel6, BorderLayout.SOUTH);
    jPanel3.add(jPanel7, BorderLayout.CENTER);
    jPanel7.add(btnAddOrder, null);
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    jPanel4.add(jPanel22, BorderLayout.NORTH);
    jPanel22.add(jLabel3, BorderLayout.WEST);
    jPanel4.add(jPanel23, BorderLayout.SOUTH);
    jPanel4.add(jPanel24, BorderLayout.CENTER);
    jPanel24.add(jLabel36,  new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel37,  new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel38, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel2,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtOrderId,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jPanel17, BorderLayout.NORTH);
    jPanel17.add(jLabel14,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jPanel18, BorderLayout.SOUTH);
    jPanel2.add(jPanel19, BorderLayout.CENTER);
    jPanel19.add(jLabel16,    new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel17,   new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel18,     new GridBagConstraints(4, 0, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel19,    new GridBagConstraints(6, 0, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel20,   new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel21,     new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(txtItemId1,     new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(txtTransactionId1,     new GridBagConstraints(8, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel22,     new GridBagConstraints(4, 2, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(cbxTradingRole,    new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel23,   new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(lbItemId2,     new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(lbTransactionId2,     new GridBagConstraints(4, 4, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(txtTransactionId2,       new GridBagConstraints(8, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(txtItemId2,     new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel26,    new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel27,     new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(txtTotal,     new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel28,    new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel24,    new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel32,     new GridBagConstraints(4, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel31,  new GridBagConstraints(5, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(cbxIntlShippingServiceSelected,  new GridBagConstraints(8, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(cbxShippingServiceSelected,  new GridBagConstraints(8, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel30,  new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(txtShippingServiceSelectedCost,  new GridBagConstraints(8, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel29,  new GridBagConstraints(5, 6, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel15,  new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(cbxCurrency,  new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel5,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(cbxSite,   new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel4,   new GridBagConstraints(6, 4, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel19.add(jLabel35,  new GridBagConstraints(7, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    this.jPanel11.setPreferredSize(new Dimension(650, 30));
    this.jPanel14.setPreferredSize(new Dimension(650, 30));
    this.jPanel17.setPreferredSize(new Dimension(650, 1));

    this.jPanel8.setPreferredSize(new Dimension(650, 120));
    this.jPanel9.setPreferredSize(new Dimension(650, 120));

    this.setSize(new Dimension(650, 710));
    this.setResizable(false);
  }

  void btnAddShippingService_actionPerformed(ActionEvent e) {
    ServiceControlManager manager = ServiceControlManager.getInstance();
    ControlTagItem[] ctrlServices = manager.createShippingServiceControl(this.siteId, ShippingServiceHelper.FLAT_SHIPPING_METHODS, false);

    ShippingServiceSelector selector = new ShippingServiceSelector(ShippingTypeCodeType.FLAT, null, ctrlServices);
    DialogEditShippingService dialog =
        new DialogEditShippingService(this.parentFrame, "AddShippingService",
        selector, true);
    dialog.setVisible(true);

    ShippingServiceOptionsType sso = selector.getSelectedShippingServiceOption();
    if (sso != null) {
      this.shippingServiceOptions.add(selector);
      sso.setShippingServicePriority(new Integer(this.shippingServiceOptions.size()));
      updateShippingServiceSelections();
    }
  }

  void btnAddIntlShippingService_actionPerformed(ActionEvent e) {
    ServiceControlManager manager = ServiceControlManager.getInstance();
    ControlTagItem[] ctrlServices = manager.createShippingServiceControl(this.siteId, ShippingServiceHelper.INTL_FLATRATE_SHIPPING_SERVICES, false);

    ShippingServiceHelper helper = ShippingServiceHelper.getInstance();
     Hashtable shipToLocations = helper.getShipToLocationMap(this.siteId);

    InternationalShippingServiceSelector selector = new InternationalShippingServiceSelector(ShippingTypeCodeType.FLAT, null, shipToLocations, ctrlServices);
    DialogEditInternationalShippingService dialog =
        new DialogEditInternationalShippingService(this.parentFrame, "AddShippingService",
        selector, true);
    dialog.setVisible(true);

    InternationalShippingServiceOptionsType sso = selector.getSelectedShippingServiceOption();

    if (sso != null) {
      this.intlShippingServiceOptions.add(selector);
      sso.setShippingServicePriority(new Integer(this.intlShippingServiceOptions.size()));
      updateIntlShippingServiceSelections();
    }
  }

  void btnRemoveShippingService_actionPerformed(ActionEvent e)
  {
    int size = this.shippingServiceOptions.size();
    if (size > 0) {
      this.shippingServiceOptions.remove(size - 1);
      updateShippingServiceSelections();
    }
  }

  void btnRemoveIntlShippingService_actionPerformed(ActionEvent e) {
    int size = this.intlShippingServiceOptions.size();
    if (size > 0) {
      this.intlShippingServiceOptions.remove(size - 1);
      updateIntlShippingServiceSelections();
    }
  }

  void cbxSite_actionPerformed(ActionEvent e) {
    int idx = this.cbxSite.getSelectedIndex();
    SiteCodeType siteId = (SiteCodeType)ControlEntryTypes.sites[idx].Tag;
    if (!this.siteId.equals(siteId)) {
      this.siteId = siteId;
      initPaymentServices(this.siteId);
      initShippingServices(this.siteId);
      this.clearShippingServiceSelections();
    }
  }

  void cbxShippingServiceSelected_actionPerformed(ActionEvent e) {
    int idx = this.cbxShippingServiceSelected.getSelectedIndex();
    if (idx > 0) {
      this.cbxIntlShippingServiceSelected.setSelectedIndex(0);
    }
  }

  void cbxIntlShippingServiceSelected_actionPerformed(ActionEvent e) {
    int idx = this.cbxIntlShippingServiceSelected.getSelectedIndex();
    if (idx > 0) {
      this.cbxShippingServiceSelected.setSelectedIndex(0);
    }
  }

  void clearShippingServiceSelections()
  {
    this.shippingServiceOptions = new ArrayList();
    this.intlShippingServiceOptions = new ArrayList();
    updateShippingServiceSelections();
    updateIntlShippingServiceSelections();
  }

  void customInit()
  {
    initStaticControls();
    initServiceControls(this.siteId);
  }

  void initPaymentServices(SiteCodeType site)
  {
    this.jPanel24.removeAll();

    ServiceControlManager manager = ServiceControlManager.getInstance();
    this.ctrlPaymentServices = manager.createPaymentServiceControl(site, false);
    ArrayList lstPayment = new ArrayList();
    for (int i = 0; i < this.ctrlPaymentServices.length; i++) {
      lstPayment.add(this.ctrlPaymentServices[i].Tag.toString());
    }
    ControlBuilder builder = ControlBuilder.getInstance();
    this.ckbPaymentServices = builder.buildCheckBoxControls(this.jPanel24,  lstPayment, 3);
    this.jPanel24.updateUI();
  }

  void initServiceControls(SiteCodeType siteId)
  {
    initPaymentServices(siteId);
    initShippingServices(siteId);
    updateShippingServiceSelections();
    updateIntlShippingServiceSelections();
  }

  void initShippingServices(SiteCodeType siteId)
  {
    ServiceControlManager manager = ServiceControlManager.getInstance();
    this.ctrlShippingServices = manager.createShippingServiceControl(siteId, ShippingServiceHelper.FLAT_SHIPPING_METHODS, this.cbxShippingServiceSelected, true);
    this.ctrlIntlShippingServices = manager.createShippingServiceControl(siteId, ShippingServiceHelper.INTL_FLATRATE_SHIPPING_SERVICES, this.cbxIntlShippingServiceSelected, true);
  }

  void initStaticControls()
  {
    DefaultComboBoxModel dataModel = new DefaultComboBoxModel(ControlEntryTypes.sites);
    this.cbxSite.setModel(dataModel);
    this.cbxSite.setSelectedIndex(0);

    dataModel = new DefaultComboBoxModel(DialogAddOrder.tradingRole);
    this.cbxTradingRole.setModel(dataModel);
    this.cbxTradingRole.setSelectedIndex(0);

    dataModel = new DefaultComboBoxModel(ControlEntryTypes.currencyIDs);
    this.cbxCurrency.setModel(dataModel);
    this.cbxCurrency.setSelectedIndex(0);
  }

  ShippingServiceOptionsType processUserSelectedShippingService(CurrencyCodeType currencyId)
  {
    return ServiceControlManager.getInstance().processUserSelectedShippingService(
      currencyId,
      this.cbxShippingServiceSelected,
      this.ctrlShippingServices,
      this.cbxIntlShippingServiceSelected,
      this.ctrlIntlShippingServices,
      this.txtShippingServiceSelectedCost);
  }

  void updateIntlShippingServiceSelections()
  {
    ServiceControlManager.getInstance().updateIntlShippingServiceSelections(
      this.intlShippingServiceOptions, this.spIntlShippingServiceOptions,
      this.btnRemoveIntlShippingService, this.btnAddIntlShippingService);
  }

  void updateShippingServiceSelections()
  {
    ServiceControlManager.getInstance().updateShippingServiceSelections(
      this.shippingServiceOptions, this.spShippingServiceOptions,
      this.btnRemoveShippingService, this.btnAddShippingService);
  }

  // -------------------------------------------------------------------------

  void btnAddOrder_actionPerformed(ActionEvent e) {

    ServiceControlManager manager = ServiceControlManager.getInstance();
    try {
      String itemId1 = this.txtItemId1.getText().trim();
      String transactionId1 = this.txtTransactionId1.getText().trim();
      String itemId2 = this.txtItemId2.getText().trim();
      String transactionId2 = this.txtTransactionId2.getText().trim();

      if (itemId1.length() == 0 || itemId2.length() == 0) {
        throw new Exception("Please enter either valid ItemIds.");
      }

      this.apiContext.setSite(this.siteId);

      OrderType order = new OrderType();

      int idx = this.cbxCurrency.getSelectedIndex();
      CurrencyCodeType currencyId = (CurrencyCodeType)ControlEntryTypes.currencyIDs[idx].Tag;

      ShippingServiceOptionsType shippingServiceOptionsType = processUserSelectedShippingService(currencyId);
      order.setShippingServiceSelected(shippingServiceOptionsType);

      idx = this.cbxTradingRole.getSelectedIndex();
      TradingRoleCodeType tr = (TradingRoleCodeType)this.tradingRole[idx].Tag;
      order.setCreatingUserRole(tr);

      TransactionType transactionType1 = new TransactionType();
      ItemType itemType1 = new ItemType();
      itemType1.setItemID(itemId1);
      transactionType1.setItem(itemType1);
      if (transactionId1.length() > 0) {
        transactionType1.setTransactionID(transactionId1);
      }

      TransactionType transactionType2 = new TransactionType();
      ItemType itemType2 = new ItemType();
      itemType2.setItemID(itemId2);
      transactionType2.setItem(itemType2);
      if (transactionId2.length() > 0) {
        transactionType2.setTransactionID(transactionId2);
      }

      TransactionArrayType transArray = new TransactionArrayType();
      transArray.setTransaction(new TransactionType[] {transactionType1, transactionType2});
      order.setTransactionArray(transArray);

      String cost = this.txtTotal.getText().trim();
      AmountType at = new AmountType();
      at.setValue(Double.parseDouble(cost));
      AmountType totalAmount = at;
      totalAmount.setCurrencyID(currencyId);
      order.setTotal(totalAmount);

      BuyerPaymentMethodCodeType[] arrPaymentMethods =
          manager.processUserPaymentMethods(this.ckbPaymentServices, this.ctrlPaymentServices);
      if (arrPaymentMethods != null) {
        order.setPaymentMethods(arrPaymentMethods);
      }

      ShippingDetailsType shippingDetails =
          manager.processUserShippingDetails(this.shippingServiceOptions, this.intlShippingServiceOptions);
      if (shippingDetails != null) {
        order.setShippingDetails(shippingDetails);
      }

      AddOrderCall api = new AddOrderCall(this.apiContext);
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      api.setDetailLevel(detailLevels);
      api.setOrder(order);
      AddOrderResponseType resp = api.addOrder();
      String orderId = resp.getOrderID();
      this.txtOrderId.setText(orderId);
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogAddOrder_btnAddOrder_actionAdapter implements java.awt.event.ActionListener {
  DialogAddOrder adaptee;

  DialogAddOrder_btnAddOrder_actionAdapter(DialogAddOrder adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnAddOrder_actionPerformed(e);
  }
}

class DialogAddOrder_btnRemoveShippingService_actionAdapter implements java.awt.event.ActionListener {
  DialogAddOrder adaptee;

  DialogAddOrder_btnRemoveShippingService_actionAdapter(DialogAddOrder adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnRemoveShippingService_actionPerformed(e);
  }
}

class DialogAddOrder_btnRemoveIntlShippingService_actionAdapter implements java.awt.event.ActionListener {
  DialogAddOrder adaptee;

  DialogAddOrder_btnRemoveIntlShippingService_actionAdapter(DialogAddOrder adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnRemoveIntlShippingService_actionPerformed(e);
  }
}

class DialogAddOrder_btnAddShippingService_actionAdapter implements java.awt.event.ActionListener {
  DialogAddOrder adaptee;

  DialogAddOrder_btnAddShippingService_actionAdapter(DialogAddOrder adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnAddShippingService_actionPerformed(e);
  }
}

class DialogAddOrder_btnAddIntlShippingService_actionAdapter implements java.awt.event.ActionListener {
  DialogAddOrder adaptee;

  DialogAddOrder_btnAddIntlShippingService_actionAdapter(DialogAddOrder adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnAddIntlShippingService_actionPerformed(e);
  }
}

class DialogAddOrder_cbxSite_actionAdapter implements java.awt.event.ActionListener {
  DialogAddOrder adaptee;

  DialogAddOrder_cbxSite_actionAdapter(DialogAddOrder adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbxSite_actionPerformed(e);
  }
}

class DialogAddOrder_cbxShippingServiceSelected_actionAdapter implements java.awt.event.ActionListener {
  DialogAddOrder adaptee;

  DialogAddOrder_cbxShippingServiceSelected_actionAdapter(DialogAddOrder adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbxShippingServiceSelected_actionPerformed(e);
  }
}

class DialogAddOrder_cbxIntlShippingServiceSelected_actionAdapter implements java.awt.event.ActionListener {
  DialogAddOrder adaptee;

  DialogAddOrder_cbxIntlShippingServiceSelected_actionAdapter(DialogAddOrder adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbxIntlShippingServiceSelected_actionPerformed(e);
  }
}
