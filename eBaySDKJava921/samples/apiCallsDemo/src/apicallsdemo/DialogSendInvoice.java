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
import java.util.ArrayList;
import java.util.Hashtable;

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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.SendInvoiceCall;
import com.ebay.sdk.helper.InternationalShippingServiceSelector;
import com.ebay.sdk.helper.ServiceControlManager;
import com.ebay.sdk.helper.ShippingServiceHelper;
import com.ebay.sdk.helper.ShippingServiceSelector;
import com.ebay.sdk.helper.ui.ControlBuilder;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BuyerPaymentMethodCodeType;
import com.ebay.soap.eBLBaseComponents.InsuranceOptionCodeType;
import com.ebay.soap.eBLBaseComponents.InternationalShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.SalesTaxType;
import com.ebay.soap.eBLBaseComponents.SendInvoiceRequestType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

public class DialogSendInvoice extends JDialog {

  Frame parentFrame;
  SiteCodeType siteId = SiteCodeType.US;

  JCheckBox[] ckbPaymentServices;
  ControlTagItem[] ctrlPaymentServices = new ControlTagItem[] {};
  ArrayList shippingServiceOptions = new ArrayList();
  ArrayList intlShippingServiceOptions = new ArrayList();

  private ApiContext apiContext = new ApiContext();

  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanelBothSSO = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanelInvoice = new JPanel();
  JPanel jPanelSalesTax = new JPanel();
  JTextField txtItemID = new JTextField();
  JButton btnCallSendInvoice = new JButton();
  JPanel jPanelItemID = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanelInsuranceOption = new JPanel();
  JComboBox comboInsuranceOption = new JComboBox();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JPanel jPanelOrderID = new JPanel();
  JPanel jPanel1TransactionID = new JPanel();
  JPanel jPanelPaymentAndInstruction = new JPanel();
  JTextField txtTransactionID = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtOrderID = new JTextField();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JPanel jPanelPayPalEmail = new JPanel();
  JPanel jPanelMisc = new JPanel();
  JPanel jPanel1InsuranceFee = new JPanel();
  JTextField txtInsuranceFee = new JTextField();
  JLabel jLabel5 = new JLabel();
  JCheckBox cbxEmailToSeller = new JCheckBox();
  JTextField txtPayPalEmail = new JTextField();
  JLabel jLabel6 = new JLabel();
  GridLayout gridLayout2 = new GridLayout();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel11 = new JPanel();
  JTextField txtSalesTaxPercent = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField txtSalesTaxState = new JTextField();
  JLabel jLabel8 = new JLabel();
  JCheckBox cbxShipInTax = new JCheckBox();
  JTextField txtSalesTaxAmount = new JTextField();
  JLabel jLabel9 = new JLabel();
  TitledBorder titledBorder1;
  JPanel jPanelPaymentMethodsContainer = new JPanel();
  JPanel jPanelCheckoutInstructions = new JPanel();
  GridLayout gridLayout3 = new GridLayout();
  JPanel jPanelSSO = new JPanel();
  JPanel jPanelIntlSSO = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel15 = new JPanel();
  JPanel jPanel16 = new JPanel();
  JPanel jPanel17 = new JPanel();
  JPanel jPanel18 = new JPanel();
  JPanel jPanel19 = new JPanel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JScrollPane spShippingServiceOptions = new JScrollPane();
  JScrollPane spIntlShippingServiceOptions = new JScrollPane();
  JTable tblSSO = new JTable();
  JTable tblIntlSSO = new JTable();
  JButton btnSSORemove = new JButton();
  JButton btnSSOAdd = new JButton();
  JButton btnIntlSSORemove = new JButton();
  JButton btnIntlSSOAdd = new JButton();
  GridLayout gridLayout4 = new GridLayout();
  BorderLayout borderLayout4 = new BorderLayout();
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel12 = new JPanel();
  JPanel jPanelPaymentMethods = new JPanel();
  JPanel jPanel21 = new JPanel();
  JPanel jPanel22 = new JPanel();
  JPanel jPanel23 = new JPanel();
  JPanel jPanel24 = new JPanel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JScrollPane jScrollPane3 = new JScrollPane();
  JTextPane txtCheckoutInstructions = new JTextPane();
  BorderLayout borderLayout8 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel14 = new JLabel();

  void initPaymentServices(SiteCodeType siteId)
  {
    this.jPanelPaymentMethods.removeAll();
    ServiceControlManager manager = ServiceControlManager.getInstance();
    this.ctrlPaymentServices = manager.createPaymentServiceControl(siteId, false);
    ArrayList lstPayment = new ArrayList();
    for (int i = 0; i < this.ctrlPaymentServices.length; i++) {
      lstPayment.add(this.ctrlPaymentServices[i].Text);
    }
    ControlBuilder builder = ControlBuilder.getInstance();
    this.ckbPaymentServices = builder.buildCheckBoxControls(this.jPanelPaymentMethods,  lstPayment, 4);
    this.jPanelPaymentMethods.updateUI();
  }

  void initServiceControls(SiteCodeType siteId)
  {
    initPaymentServices(siteId);
    //initShipToLocations(siteId);
    updateShippingServiceSelections();
    updateIntlShippingServiceSelections();
  }

  void updateShippingServiceSelections()
  {
    ServiceControlManager.getInstance().updateShippingServiceSelections(
      this.shippingServiceOptions, this.spShippingServiceOptions,
      this.btnSSORemove, this.btnSSOAdd);
  }

  void updateIntlShippingServiceSelections()
  {
    ServiceControlManager.getInstance().updateIntlShippingServiceSelections(
      this.intlShippingServiceOptions, this.spIntlShippingServiceOptions,
      this.btnIntlSSORemove, this.btnIntlSSOAdd);
  }

  public DialogSendInvoice(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      //
      this.parentFrame = frame;
      this.apiContext = ((FrameDemo)this.parentFrame).getApiContext();

      // Initialize combo box.
      Object[] list = new Object[] {
          new ControlTagItem("NotOffered", InsuranceOptionCodeType.NOT_OFFERED),
          new ControlTagItem("NotOfferedOnSite", InsuranceOptionCodeType.NOT_OFFERED_ON_SITE),
          new ControlTagItem("IncludedInShippingHandling", InsuranceOptionCodeType.INCLUDED_IN_SHIPPING_HANDLING),
          new ControlTagItem("Optional", InsuranceOptionCodeType.OPTIONAL),
          new ControlTagItem("Required", InsuranceOptionCodeType.REQUIRED),
      };
      ComboBoxModel dataModel = new DefaultComboBoxModel(list);
      this.comboInsuranceOption.setModel(dataModel);
      this.comboInsuranceOption.setSelectedIndex(0);

      //
      initServiceControls(this.siteId);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogSendInvoice() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    txtItemID.setPreferredSize(new Dimension(120, 21));
    txtItemID.setText("");
    btnCallSendInvoice.setText("SendInvoice");
    btnCallSendInvoice.addActionListener(new DialogSendInvoice_btnCallSendInvoice_actionAdapter(this));
    jPanelInvoice.setLayout(gridLayout1);
    gridLayout1.setColumns(2);
    gridLayout1.setRows(4);
    comboInsuranceOption.setOpaque(true);
    comboInsuranceOption.setPreferredSize(new Dimension(120, 21));
    comboInsuranceOption.setToolTipText("");
    comboInsuranceOption.setPopupVisible(false);
    comboInsuranceOption.setSelectedIndex(-1);
    jPanelBothSSO.setLayout(borderLayout3);
    txtTransactionID.setPreferredSize(new Dimension(80, 21));
    txtTransactionID.setText("");
    jLabel3.setPreferredSize(new Dimension(100, 15));
    jLabel3.setText("Order ID:");
    jLabel1.setPreferredSize(new Dimension(100, 15));
    jLabel1.setText("Item ID:");
    txtOrderID.setPreferredSize(new Dimension(120, 21));
    txtOrderID.setText("");
    jLabel4.setPreferredSize(new Dimension(100, 15));
    jLabel4.setText("Transaction ID:");
    jLabel2.setPreferredSize(new Dimension(100, 15));
    jLabel2.setRequestFocusEnabled(true);
    jLabel2.setText("Insurance Option:");
    txtInsuranceFee.setPreferredSize(new Dimension(80, 21));
    txtInsuranceFee.setText("");
    jLabel5.setPreferredSize(new Dimension(100, 15));
    jLabel5.setRequestFocusEnabled(true);
    jLabel5.setText("Insurance fee:");
    cbxEmailToSeller.setText("Email copy to seller");
    txtPayPalEmail.setPreferredSize(new Dimension(120, 21));
    txtPayPalEmail.setText("");
    jLabel6.setPreferredSize(new Dimension(100, 15));
    jLabel6.setText("PayPal Email:");
    jPanelSalesTax.setLayout(gridLayout2);
    gridLayout2.setColumns(2);
    gridLayout2.setHgap(0);
    gridLayout2.setRows(2);
    txtSalesTaxPercent.setPreferredSize(new Dimension(60, 21));
    txtSalesTaxPercent.setText("");
    jLabel7.setText("Sales Tax Percent:");
    txtSalesTaxState.setPreferredSize(new Dimension(60, 21));
    txtSalesTaxState.setSelectionStart(0);
    txtSalesTaxState.setText("");
    jLabel8.setPreferredSize(new Dimension(100, 15));
    jLabel8.setText("Sales Tax State:");
    cbxShipInTax.setText("Shipping included in tax");
    txtSalesTaxAmount.setPreferredSize(new Dimension(60, 21));
    txtSalesTaxAmount.setSelectionStart(16);
    txtSalesTaxAmount.setText("");
    jLabel9.setPreferredSize(new Dimension(100, 15));
    jLabel9.setText("Sales Tax Amount:");
    jPanelSalesTax.setBorder(BorderFactory.createEtchedBorder());
    jPanelPaymentAndInstruction.setLayout(gridLayout4);
    jPanelPaymentMethodsContainer.setPreferredSize(new Dimension(10, 80));
    jPanelPaymentMethodsContainer.setLayout(borderLayout4);
    jPanel9.setLayout(gridLayout3);
    gridLayout3.setColumns(2);
    gridLayout3.setHgap(5);
    gridLayout3.setRows(1);
    jPanelSSO.setLayout(borderLayout5);
    jPanelIntlSSO.setLayout(borderLayout6);
    jLabel11.setText("Shipping Service Options");
    jLabel12.setText("International Shipping Service Options");
    spShippingServiceOptions.getViewport().setBackground(Color.white);
    spIntlShippingServiceOptions.getViewport().setBackground(Color.white);
    btnSSORemove.setText("Remove");
    btnSSORemove.addActionListener(new DialogSendInvoice_btnSSORemove_actionAdapter(this));
    btnSSOAdd.setText("Add");
    btnSSOAdd.addActionListener(new DialogSendInvoice_btnSSOAdd_actionAdapter(this));
    btnIntlSSORemove.setText("Remove");
    btnIntlSSORemove.addActionListener(new DialogSendInvoice_btnIntlSSORemove_actionAdapter(this));
    btnIntlSSOAdd.setText("Add");
    btnIntlSSOAdd.addActionListener(new DialogSendInvoice_btnIntlSSOAdd_actionAdapter(this));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    gridLayout4.setColumns(2);
    gridLayout4.setRows(1);
    jPanelCheckoutInstructions.setLayout(borderLayout7);
    jLabel10.setText("Payment Methods");
    jLabel13.setText("Checkout Instructions");
    jPanel23.setLayout(borderLayout8);
    txtCheckoutInstructions.setText("");
    jPanelPaymentMethods.setBorder(BorderFactory.createEtchedBorder());
    jPanel9.setPreferredSize(new Dimension(933, 300));
    jPanelPaymentAndInstruction.setBorder(null);
    jPanelPaymentAndInstruction.setPreferredSize(new Dimension(228, 200));
    jPanelCheckoutInstructions.setBorder(null);
    jLabel14.setText("(Enter either order ID or item ID plus transaction ID)");
    jPanelItemID.add(jLabel1, null);
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanelInvoice,  BorderLayout.NORTH);
    jPanelInvoice.add(jPanelItemID, null);
    jPanelInvoice.add(jPanel1TransactionID, null);
    jPanel1TransactionID.add(jLabel4, null);
    jPanel1TransactionID.add(txtTransactionID, null);
    jPanelInvoice.add(jPanelOrderID, null);
    jPanelOrderID.add(jLabel3, null);
    jPanelOrderID.add(txtOrderID, null);
    jPanelItemID.add(txtItemID, null);
    jPanel1InsuranceFee.add(jLabel5, null);
    jPanel1InsuranceFee.add(txtInsuranceFee, null);
    jPanelInvoice.add(jPanelMisc, null);
    jPanelMisc.add(jLabel14, null);
    jPanelPayPalEmail.add(jLabel6, null);
    jPanelPayPalEmail.add(txtPayPalEmail, null);
    jPanelInvoice.add(jPanelInsuranceOption, null);
    jPanelInvoice.add(jPanel1InsuranceFee, null);
    jPanelInvoice.add(jPanelPayPalEmail, null);
    jPanelInvoice.add(jPanel4, null);
    jPanel4.add(cbxEmailToSeller, null);
    jPanelInsuranceOption.add(jLabel2, null);
    jPanelInsuranceOption.add(comboInsuranceOption, null);
    jPanel1.add(jPanelSalesTax, BorderLayout.CENTER);
    jPanelSalesTax.add(jPanel5, null);
    jPanel5.add(jLabel7, null);
    jPanel5.add(txtSalesTaxPercent, null);
    jPanelSalesTax.add(jPanel11, null);
    jPanel11.add(jLabel8, null);
    jPanel11.add(txtSalesTaxState, null);
    jPanelSalesTax.add(jPanel7, null);
    jPanel7.add(cbxShipInTax, null);
    jPanelSalesTax.add(jPanel6, null);
    jPanel6.add(jLabel9, null);
    jPanel6.add(txtSalesTaxAmount, null);
    jPanel1.add(jPanelPaymentAndInstruction, BorderLayout.SOUTH);
    panel1.add(jPanelBothSSO,  BorderLayout.CENTER);
    jPanelBothSSO.add(jPanel8,  BorderLayout.NORTH);
    jPanelBothSSO.add(jPanel9,  BorderLayout.CENTER);
    jPanel9.add(jPanelSSO, null);
    jPanelSSO.add(jPanel2,  BorderLayout.NORTH);
    jPanelSSO.add(jPanel15,  BorderLayout.CENTER);
    jPanel15.add(spShippingServiceOptions, null);
    spShippingServiceOptions.getViewport().add(tblSSO, null);
    jPanelSSO.add(jPanel16, BorderLayout.SOUTH);
    jPanel16.add(btnSSOAdd, null);
    jPanel16.add(btnSSORemove, null);
    jPanel9.add(jPanelIntlSSO, null);
    jPanelIntlSSO.add(jPanel17,  BorderLayout.NORTH);
    jPanelIntlSSO.add(jPanel18,  BorderLayout.CENTER);
    jPanel18.add(spIntlShippingServiceOptions, null);
    spIntlShippingServiceOptions.getViewport().add(tblIntlSSO, null);
    jPanelIntlSSO.add(jPanel19, BorderLayout.SOUTH);
    jPanel19.add(btnIntlSSOAdd, null);
    jPanel19.add(btnIntlSSORemove, null);
    jPanelBothSSO.add(jPanel10, BorderLayout.SOUTH);
    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(btnCallSendInvoice, null);
    jPanelPaymentAndInstruction.add(jPanelPaymentMethodsContainer, null);
    jPanelPaymentMethodsContainer.add(jPanel12,  BorderLayout.NORTH);
    jPanel12.add(jLabel10, null);
    jPanelPaymentMethodsContainer.add(jPanelPaymentMethods,  BorderLayout.CENTER);
    jPanelPaymentMethodsContainer.add(jPanel21, BorderLayout.SOUTH);
    jPanelPaymentAndInstruction.add(jPanelCheckoutInstructions, null);
    jPanelCheckoutInstructions.add(jPanel22,  BorderLayout.NORTH);
    jPanel22.add(jLabel13, null);
    jPanelCheckoutInstructions.add(jPanel23,  BorderLayout.CENTER);
    jPanel23.add(jScrollPane3, BorderLayout.CENTER);
    jScrollPane3.getViewport().add(txtCheckoutInstructions, null);
    jPanelCheckoutInstructions.add(jPanel24, BorderLayout.SOUTH);
    jPanel2.add(jLabel11, null);
    jPanel17.add(jLabel12, null);
  }

  private SalesTaxType parseSalesTaxFromForm()
  {
    String s;

    SalesTaxType st = new SalesTaxType();

    s = this.txtSalesTaxPercent.getText();
    if( s.length() > 0 )
      st.setSalesTaxPercent(new Float(s));

    s = this.txtSalesTaxAmount.getText();
    if( s.length() > 0 ) {
    	AmountType at = new AmountType();
    	at.setValue(Double.parseDouble(s));
        st.setSalesTaxAmount(at);
    }

    s = this.txtSalesTaxState.getText();
    if( s.length() > 0 )
      st.setSalesTaxState(s);

    st.setShippingIncludedInTax(new Boolean(this.cbxShipInTax.isSelected()));

    return st;
  }

  void btnCallSendInvoice_actionPerformed(ActionEvent e) {

    String s;
    FrameDemo fd = (FrameDemo)this.getParent();

    try
    {
      SendInvoiceCall api = new SendInvoiceCall(this.apiContext);

      SendInvoiceRequestType req = new SendInvoiceRequestType();
      api.setSendInvoiceRequest(req);

      //
      String oid = this.txtOrderID.getText();
      String itm = this.txtItemID.getText();
      String tid = this.txtTransactionID.getText();

      if( oid.length() > 0 )
        req.setOrderID(oid);
      else if( itm.length() > 0 && tid.length() > 0 )
      {
        req.setItemID(itm);
        req.setTransactionID(tid);
      }
      else
      {
          fd.showInfoMessage("Please enter either order ID or item ID and transaction ID.");
          return;
      }

      s = this.txtCheckoutInstructions.getText();
      if( s.length() > 0 )
        req.setCheckoutInstructions(s);

      // Insurance
      ControlTagItem ct = (ControlTagItem)this.comboInsuranceOption.getSelectedItem();
      req.setInsuranceOption((InsuranceOptionCodeType)ct.Tag);

      s = this.txtInsuranceFee.getText();
      if( s.length() > 0 ) {
      	AmountType at = new AmountType();
    	at.setValue(Double.parseDouble(s));
        req.setInsuranceFee(at);
      }

      //
      s = this.txtPayPalEmail.getText();
      if( s.length() > 0 )
        req.setPayPalEmailAddress(s);

      req.setEmailCopyToSeller(new Boolean(this.cbxEmailToSeller.isSelected()));

      // Sales tax
      req.setSalesTax(this.parseSalesTaxFromForm());

      // Payment methods
      ServiceControlManager manager = ServiceControlManager.getInstance();

      BuyerPaymentMethodCodeType[] arrPaymentMethods =
          manager.processUserPaymentMethods(this.ckbPaymentServices, this.ctrlPaymentServices);
      if (arrPaymentMethods != null) {
        req.setPaymentMethods(arrPaymentMethods);
      }

      // Shipping service
      ShippingDetailsType shippingDetails =
          manager.processUserShippingDetails(this.shippingServiceOptions, this.intlShippingServiceOptions);
      if (shippingDetails != null)
      {
        ShippingServiceOptionsType[] so = shippingDetails.getShippingServiceOptions();
        if( so != null )
          req.setShippingServiceOptions(so);

        InternationalShippingServiceOptionsType[] iso = shippingDetails.getInternationalShippingServiceOption();
        if( iso != null )
          req.setInternationalShippingServiceOptions(iso);
      }

      api.sendInvoice();

      fd.showInfoMessage("The invoice has been sent successfully!");
    }
    catch(Exception ex)
    {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      ((FrameDemo)this.getParent()).showErrorMessage(msg);
    }
  }

  void btnSSOAdd_actionPerformed(ActionEvent e) {
    ServiceControlManager manager = ServiceControlManager.getInstance();
    ControlTagItem[] ctrlServices = manager.createShippingServiceControl(this.siteId, ShippingServiceHelper.FLAT_SHIPPING_METHODS, false);

    ShippingServiceSelector selector = new ShippingServiceSelector(ShippingTypeCodeType.FLAT, null, ctrlServices);
    DialogEditShippingService dialog =
        new DialogEditShippingService(this.parentFrame, "AddShippingService",
        selector, true);
    GuiUtil.CenterComponent(dialog);
    dialog.setVisible(true);

    ShippingServiceOptionsType sso = selector.getSelectedShippingServiceOption();
    if (sso != null) {
      this.shippingServiceOptions.add(selector);
      sso.setShippingServicePriority(new Integer(this.shippingServiceOptions.size()));
      updateShippingServiceSelections();
    }
  }

  void btnSSORemove_actionPerformed(ActionEvent e) {
    int size = this.shippingServiceOptions.size();
    if (size > 0) {
      this.shippingServiceOptions.remove(size - 1);
      updateShippingServiceSelections();
    }
  }

  void btnIntlSSOAdd_actionPerformed(ActionEvent e) {
    ServiceControlManager manager = ServiceControlManager.getInstance();

    ControlTagItem[] ctrlServices = manager.createShippingServiceControl(this.siteId, ShippingServiceHelper.INTL_FLATRATE_SHIPPING_SERVICES, false);

    ShippingServiceHelper helper = ShippingServiceHelper.getInstance();
    Hashtable shipToLocations = helper.getShipToLocationMap(this.siteId);

    InternationalShippingServiceSelector selector = new InternationalShippingServiceSelector(ShippingTypeCodeType.FLAT, null, shipToLocations, ctrlServices);
    DialogEditInternationalShippingService dialog =
        new DialogEditInternationalShippingService(this.parentFrame, "AddShippingService",
        selector, true);
    GuiUtil.CenterComponent(dialog);
    dialog.setVisible(true);

    InternationalShippingServiceOptionsType sso = selector.getSelectedShippingServiceOption();

    if (sso != null) {
      this.intlShippingServiceOptions.add(selector);
      sso.setShippingServicePriority(new Integer(this.intlShippingServiceOptions.size()));
      updateIntlShippingServiceSelections();
    }
  }

  void btnIntlSSORemove_actionPerformed(ActionEvent e) {
    int size = this.intlShippingServiceOptions.size();
    if (size > 0) {
      this.intlShippingServiceOptions.remove(size - 1);
      updateIntlShippingServiceSelections();
    }
  }
}

class DialogSendInvoice_btnCallSendInvoice_actionAdapter implements java.awt.event.ActionListener {
  DialogSendInvoice adaptee;

  DialogSendInvoice_btnCallSendInvoice_actionAdapter(DialogSendInvoice adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCallSendInvoice_actionPerformed(e);
  }
}

class DialogSendInvoice_btnSSOAdd_actionAdapter implements java.awt.event.ActionListener {
  DialogSendInvoice adaptee;

  DialogSendInvoice_btnSSOAdd_actionAdapter(DialogSendInvoice adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnSSOAdd_actionPerformed(e);
  }
}

class DialogSendInvoice_btnSSORemove_actionAdapter implements java.awt.event.ActionListener {
  DialogSendInvoice adaptee;

  DialogSendInvoice_btnSSORemove_actionAdapter(DialogSendInvoice adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnSSORemove_actionPerformed(e);
  }
}

class DialogSendInvoice_btnIntlSSOAdd_actionAdapter implements java.awt.event.ActionListener {
  DialogSendInvoice adaptee;

  DialogSendInvoice_btnIntlSSOAdd_actionAdapter(DialogSendInvoice adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnIntlSSOAdd_actionPerformed(e);
  }
}

class DialogSendInvoice_btnIntlSSORemove_actionAdapter implements java.awt.event.ActionListener {
  DialogSendInvoice adaptee;

  DialogSendInvoice_btnIntlSSORemove_actionAdapter(DialogSendInvoice adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnIntlSSORemove_actionPerformed(e);
  }
}
