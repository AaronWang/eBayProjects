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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.ReviseCheckoutStatusCall;
import com.ebay.sdk.helper.ServiceControlManager;
import com.ebay.sdk.helper.ShippingServiceHelper;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BuyerPaymentMethodCodeType;
import com.ebay.soap.eBLBaseComponents.CompleteStatusCodeType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.ReviseCheckoutStatusResponseType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogReviseCheckoutStatus extends JDialog {
  Frame parent;
  SiteCodeType  siteId = SiteCodeType.US;
  ArrayList flatShippingServices;
  ArrayList intlFlatShippingServices;

  private ApiContext apiContext = new ApiContext();

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JButton btnReviseCheckoutStatus = new JButton();

  static ControlTagItem[] checkoutStatuses = new ControlTagItem[] {
      new ControlTagItem(CompleteStatusCodeType.INCOMPLETE.value(), CompleteStatusCodeType.INCOMPLETE),
      new ControlTagItem(CompleteStatusCodeType.COMPLETE.value(), CompleteStatusCodeType.COMPLETE)
  };

  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JTextField txtCallStatus = new JTextField();
  JPanel jPanel2 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtItemId = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JTextField txtTransactionId = new JTextField();
  JLabel jLabel6 = new JLabel();
  JTextField txtOrderId = new JTextField();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JTextField txtAmountPaid = new JTextField();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JComboBox cbxSite = new JComboBox();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JComboBox cbxCheckoutStatus = new JComboBox();
  JLabel jLabel13 = new JLabel();
  JLabel lbShippingService = new JLabel();
  JLabel jLabel15 = new JLabel();
  JComboBox cbxShippingService = new JComboBox();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JComboBox cbxIntlShippingService = new JComboBox();
  JComboBox cbxPaymentService = new JComboBox();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel22 = new JLabel();
  JTextField txteBayTime = new JTextField();
  JLabel jLabel23 = new JLabel();
  JLabel lbeBayTime = new JLabel();

  public DialogReviseCheckoutStatus(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
      this.parent = fd;
      this.initServices(this.siteId);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogReviseCheckoutStatus() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setModal(true);
    this.setTitle("eBay SDK for Java - ReviseCheckoutStatus");

    jPanel1.setLayout(borderLayout2);
    jPanel3.setLayout(borderLayout3);

    btnReviseCheckoutStatus.setText("ReviseCheckoutStatus");
    btnReviseCheckoutStatus.addActionListener(new DialogReviseCheckoutStatus_btnReviseCheckoutStatus_actionAdapter(this));
    jPanel6.setLayout(gridBagLayout2);
    jLabel20.setBorder(null);
    jLabel20.setText("CallStatus:");
    jLabel21.setText("      ");
    txtCallStatus.setBackground(UIManager.getColor("Button.background"));
    txtCallStatus.setMinimumSize(new Dimension(157, 21));
    txtCallStatus.setPreferredSize(new Dimension(70, 21));
    txtCallStatus.setRequestFocusEnabled(true);
    jPanel6.setBorder(BorderFactory.createEtchedBorder());
    jPanel5.setMinimumSize(new Dimension(10, 1));
    jPanel5.setPreferredSize(new Dimension(10, 1));
    jPanel2.setLayout(borderLayout4);
    jPanel7.setLayout(gridBagLayout1);
    jLabel1.setText("ItemID:");
    jLabel2.setText("        ");
    txtItemId.setPreferredSize(new Dimension(120, 21));
    jLabel3.setText("  ");
    jLabel4.setText("TransactionID:");
    jLabel5.setText("  ");
    txtTransactionId.setPreferredSize(new Dimension(120, 21));
    txtTransactionId.setText("");
    jLabel6.setText("OrderID:");
    txtOrderId.setPreferredSize(new Dimension(120, 21));
    txtOrderId.setText("");
    jLabel7.setText("  ");
    jLabel8.setText("AmountPaid:");
    txtAmountPaid.setPreferredSize(new Dimension(120, 21));
    txtAmountPaid.setText("");
    jPanel8.setLayout(gridBagLayout3);
    jLabel9.setToolTipText("");
    jLabel9.setText("Site:");
    jLabel10.setText("  ");
    jLabel11.setText("    ");
    jLabel12.setText("CheckoutStatus:");
    jLabel13.setText("          ");
    lbShippingService.setText("ShippingService:");
    jLabel15.setText("  ");
    jLabel14.setText("  ");
    jLabel16.setRequestFocusEnabled(true);
    jLabel16.setText("PaymentMethod:");
    jLabel17.setDebugGraphicsOptions(0);
    jLabel17.setText("Intl ShippingService:");
    jPanel7.setBorder(null);
    jPanel8.setBorder(null);
    cbxSite.addActionListener(new DialogReviseCheckoutStatus_cbxSite_actionAdapter(this));
    cbxShippingService.addActionListener(new DialogReviseCheckoutStatus_cbxShippingService_actionAdapter(this));
    cbxIntlShippingService.addActionListener(new DialogReviseCheckoutStatus_cbxIntlShippingService_actionAdapter(this));
    jLabel18.setText("        ");
    jLabel19.setText("        ");
    jLabel22.setText("        ");
    jLabel23.setText("    ");
    lbeBayTime.setText("eBayTime:");
    txteBayTime.setBackground(UIManager.getColor("Button.light"));
    txteBayTime.setPreferredSize(new Dimension(120, 21));
    txteBayTime.setText("");
    jPanel1.add(jPanel3, BorderLayout.SOUTH);

    jPanel3.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(btnReviseCheckoutStatus, null);
    jPanel3.add(jPanel5, BorderLayout.SOUTH);
    jPanel3.add(jPanel6, BorderLayout.CENTER);
    jPanel6.add(jLabel20,      new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel21,     new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtCallStatus,     new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel22,    new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txteBayTime,    new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel23,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(lbeBayTime, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel2.add(jPanel7, BorderLayout.NORTH);
    jPanel7.add(jLabel1,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(txtItemId,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel4,  new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(txtTransactionId,  new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel6,  new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(txtOrderId,  new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel7, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel8,  new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(txtAmountPaid,  new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel11, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel12,  new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(cbxCheckoutStatus,  new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jPanel9, BorderLayout.SOUTH);
    jPanel2.add(jPanel8, BorderLayout.CENTER);
    jPanel8.add(jLabel9,          new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel10,         new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(cbxSite,          new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel13,         new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(lbShippingService,          new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel15,         new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(cbxShippingService,          new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel14,         new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel16,         new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel17,          new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(cbxIntlShippingService,         new GridBagConstraints(7, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(cbxPaymentService,    new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel18,  new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel19, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);

    ComboBoxModel dataModel = new DefaultComboBoxModel(DialogReviseCheckoutStatus.checkoutStatuses);
    this.cbxCheckoutStatus.setModel(dataModel);
    this.cbxCheckoutStatus.setSelectedIndex(0);

    dataModel = new DefaultComboBoxModel(ControlEntryTypes.sites);
    this.cbxSite.setModel(dataModel);
    this.cbxSite.setSelectedIndex(0);

    jPanel2.setPreferredSize(new Dimension(650, 291));
    jPanel3.setPreferredSize(new Dimension(650, 130));
    jPanel4.setPreferredSize(new Dimension(650, 50));
    jPanel6.setPreferredSize(new Dimension(650, 40));

    jPanel7.setPreferredSize(new Dimension(650, 200));
    jPanel8.setPreferredSize(new Dimension(650, 120));
    jPanel9.setPreferredSize(new Dimension(650, 1));

    this.setSize(new Dimension(650, 421));
    this.setResizable(false);
  }

  void btnReviseCheckoutStatus_actionPerformed(ActionEvent e)
  {
    try {
      String itemId = this.txtItemId.getText().trim();
      String transactionId = this.txtTransactionId.getText().trim();
      String orderId = this.txtOrderId.getText().trim();
      String amountPaid = this.txtAmountPaid.getText().trim();

      if ( itemId.length() == 0 && orderId.length() == 0) {
        throw new Exception("Please enter either a valid ItemId.");
      }

      this.apiContext.setSite(this.siteId);

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      CompleteStatusCodeType checkoutStatus = (CompleteStatusCodeType) ((ControlTagItem)this.cbxCheckoutStatus.getSelectedItem()).Tag;

      ShippingServiceCodeType shippingService = null;
      int idx = this.cbxShippingService.getSelectedIndex();
      if (idx > 0) {
        shippingService = (ShippingServiceCodeType)((ControlTagItem)this.cbxShippingService.getSelectedItem()).Tag;
      }
      else {
        idx = this.cbxIntlShippingService.getSelectedIndex();
        if (idx > 0) {
          shippingService = (ShippingServiceCodeType)((ControlTagItem)this.cbxIntlShippingService.getSelectedItem()).Tag;
        }
      }

      BuyerPaymentMethodCodeType paymentMethod = null;
      idx = this.cbxPaymentService.getSelectedIndex();
      if (idx > 0) {
        paymentMethod = (BuyerPaymentMethodCodeType)((ControlTagItem)this.cbxPaymentService.getSelectedItem()).Tag;
      }

      ReviseCheckoutStatusCall api = new ReviseCheckoutStatusCall(this.apiContext);
      api.setDetailLevel(detailLevels);

      api.setItemID(itemId);
      if (transactionId.length() > 0) {
        api.setTransactionID(transactionId);
      }
      if (orderId.length() > 0) {
        api.setOrderId(orderId);
      }
      api.setCheckoutStatus(checkoutStatus);
      AmountType at = new AmountType();
      at.setValue(Double.parseDouble(amountPaid));
      api.setAmountPaid(at);
      if (shippingService != null) {
        api.setShippingService(shippingService);
      }

      if (paymentMethod != null) {
        api.setPaymentMethodUsed(paymentMethod);
      }

      ReviseCheckoutStatusResponseType resp = api.reviseCheckoutStatus();


      Date dt = resp.getTimestamp().getTime();
      this.txteBayTime.setText(eBayUtil.toAPITimeString(dt));
      this.txtCallStatus.setText(resp.getAck().value());
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void initServices(SiteCodeType site)
  {
    initShippingServices(site);
    initPaymentServices(site);
  }

  void initPaymentServices(SiteCodeType siteId)
  {
    ServiceControlManager.getInstance().createPaymentServiceControl(siteId, this.cbxPaymentService, true);
  }

  void initShippingServices(SiteCodeType site)
  {
    ServiceControlManager manager = ServiceControlManager.getInstance();
    manager.createShippingServiceControl(site, ShippingServiceHelper.FLAT_SHIPPING_METHODS, this.cbxShippingService, true);
    manager.createShippingServiceControl(site, ShippingServiceHelper.INTL_FLATRATE_SHIPPING_SERVICES, this.cbxIntlShippingService, true);
  }

  void cbxSite_actionPerformed(ActionEvent e) {

    int idx = this.cbxSite.getSelectedIndex();
    SiteCodeType siteId = (SiteCodeType)ControlEntryTypes.sites[idx].Tag;
    if (!this.siteId.equals(siteId)) {
      this.siteId = siteId;
      this.initServices(siteId);
    }
  }

  void cbxShippingService_actionPerformed(ActionEvent e) {
    int idx = this.cbxShippingService.getSelectedIndex();
    if (idx > 0) {
      this.cbxIntlShippingService.setSelectedIndex(0);
    }
  }

  void cbxIntlShippingService_actionPerformed(ActionEvent e) {
    int idx = this.cbxIntlShippingService.getSelectedIndex();
    if (idx > 0) {
      this.cbxShippingService.setSelectedIndex(0);
    }
  }
}

class DialogReviseCheckoutStatus_btnReviseCheckoutStatus_actionAdapter implements java.awt.event.ActionListener {
  DialogReviseCheckoutStatus adaptee;

  DialogReviseCheckoutStatus_btnReviseCheckoutStatus_actionAdapter(DialogReviseCheckoutStatus adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnReviseCheckoutStatus_actionPerformed(e);
  }
}

class DialogReviseCheckoutStatus_cbxSite_actionAdapter implements java.awt.event.ActionListener {
  DialogReviseCheckoutStatus adaptee;

  DialogReviseCheckoutStatus_cbxSite_actionAdapter(DialogReviseCheckoutStatus adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbxSite_actionPerformed(e);
  }
}

class DialogReviseCheckoutStatus_cbxShippingService_actionAdapter implements java.awt.event.ActionListener {
  DialogReviseCheckoutStatus adaptee;

  DialogReviseCheckoutStatus_cbxShippingService_actionAdapter(DialogReviseCheckoutStatus adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbxShippingService_actionPerformed(e);
  }
}

class DialogReviseCheckoutStatus_cbxIntlShippingService_actionAdapter implements java.awt.event.ActionListener {
  DialogReviseCheckoutStatus adaptee;

  DialogReviseCheckoutStatus_cbxIntlShippingService_actionAdapter(DialogReviseCheckoutStatus adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbxIntlShippingService_actionPerformed(e);
  }
}
