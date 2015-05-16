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

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetItemShippingCall;
import com.ebay.sdk.helper.ShippingServiceOptionTreeBuilder;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.CalculatedShippingRateType;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingRateTypeCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogGetItemShipping extends JDialog {
  private ApiContext apiContext = new ApiContext();

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JButton btnGetItemShipping = new JButton();

  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
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
  JTextField txtQuantitySold = new JTextField();
  JLabel jLabel8 = new JLabel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JComboBox cbxCountryCode = new JComboBox();
  JLabel jLabel9 = new JLabel();
  JTextField txtPostalCode = new JTextField();
  BorderLayout borderLayout6 = new BorderLayout();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JTextField txtShippingType = new JTextField();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JTextField txtCurrency = new JTextField();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel24 = new JLabel();
  JLabel jLabel25 = new JLabel();
  JTextField txtShipFromZipCode = new JTextField();
  JTextField txtPackageHandlingCost = new JTextField();
  JTextField txtShippingRateType = new JTextField();
  JTextField txtShippingPackage = new JTextField();
  JTextField txtInsuranceFee = new JTextField();
  JTextField txtShippingIrregular = new JTextField();
  JLabel jLabel28 = new JLabel();
  JLabel jLabel29 = new JLabel();
  JLabel jLabel30 = new JLabel();

  public DialogGetItemShipping(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetItemShipping() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setModal(true);
    this.setTitle("eBay SDK for Java - GetItemShipping");
    jPanel1.setLayout(borderLayout2);
    jPanel3.setLayout(borderLayout3);
    btnGetItemShipping.setText("GetItemShipping");
    btnGetItemShipping.addActionListener(new DialogGetItemShipping_btnGetItemShipping_actionAdapter(this));
    jPanel6.setLayout(borderLayout6);
    jPanel6.setBorder(BorderFactory.createEtchedBorder());
    jPanel5.setMinimumSize(new Dimension(10, 1));
    jPanel5.setPreferredSize(new Dimension(10, 1));
    jPanel2.setLayout(borderLayout4);
    jPanel7.setLayout(gridBagLayout1);
    jLabel1.setText("ItemID:");
    jLabel2.setText("        ");
    txtItemId.setPreferredSize(new Dimension(120, 21));
    jLabel3.setText("  ");
    jLabel4.setText("QuantitySold:");
    jLabel5.setText("  ");
    txtQuantitySold.setPreferredSize(new Dimension(120, 21));
    txtQuantitySold.setText("");
    jLabel8.setText("Destination PostalCode:");
    jPanel8.setLayout(gridBagLayout3);
    jLabel10.setText("  ");
    jLabel11.setText("    ");
    jLabel12.setText("Destination CountryCode:");
    jLabel9.setText("  ");
    jPanel4.setBorder(null);
    jPanel9.setLayout(gridBagLayout2);
    jPanel9.setBorder(BorderFactory.createEtchedBorder());
    jPanel9.setMaximumSize(new Dimension(32767, 32767));
    txtPostalCode.setPreferredSize(new Dimension(120, 21));
    jLabel6.setText(" ");
    jLabel7.setText(" ");
    jLabel13.setPreferredSize(new Dimension(10, 1));
    jLabel13.setText(" ");
    jLabel14.setPreferredSize(new Dimension(3, 1));
    jLabel14.setText(" ");
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setPreferredSize(new Dimension(1, 4));
    jLabel15.setText("ShippingType");
    jLabel16.setToolTipText("");
    jLabel16.setText("  ");
    txtShippingType.setBackground(Color.lightGray);
    txtShippingType.setPreferredSize(new Dimension(60, 21));
    txtShippingType.setText("");
    jLabel17.setText("        ");
    jLabel18.setText("Currency:");
    jLabel19.setText("    ");
    txtCurrency.setBackground(Color.lightGray);
    txtCurrency.setPreferredSize(new Dimension(60, 21));
    txtCurrency.setText("");
    jLabel20.setText("    ");
    jLabel21.setText("ShipFromZipCode:");
    jLabel22.setText("    ");
    jLabel23.setText("ShippingRateType:");
    jLabel24.setText("    ");
    jLabel25.setText("ShippingPackage:");
    txtShipFromZipCode.setBackground(Color.lightGray);
    txtShipFromZipCode.setPreferredSize(new Dimension(60, 21));
    txtShipFromZipCode.setText("");
    txtPackageHandlingCost.setBackground(Color.lightGray);
    txtPackageHandlingCost.setPreferredSize(new Dimension(60, 21));
    txtPackageHandlingCost.setText("");
    txtShippingRateType.setBackground(Color.lightGray);
    txtShippingRateType.setPreferredSize(new Dimension(60, 21));
    txtShippingRateType.setSelectedTextColor(Color.white);
    txtShippingRateType.setText("");
    txtShippingPackage.setBackground(Color.lightGray);
    txtShippingPackage.setMinimumSize(new Dimension(6, 21));
    txtShippingPackage.setPreferredSize(new Dimension(60, 21));
    txtShippingPackage.setText("");
    txtInsuranceFee.setBackground(Color.lightGray);
    txtInsuranceFee.setPreferredSize(new Dimension(60, 21));
    txtInsuranceFee.setText("");
    txtShippingIrregular.setBackground(Color.lightGray);
    txtShippingIrregular.setPreferredSize(new Dimension(60, 21));
    txtShippingIrregular.setText("");
    jLabel28.setText("PackageHandlingCost:");
    jLabel29.setText("InsuranceFee:");
    jLabel30.setText("ShippingIrregular:");
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jPanel4, BorderLayout.NORTH);
    jPanel3.add(jPanel5, BorderLayout.SOUTH);
    jPanel3.add(jPanel6, BorderLayout.CENTER);
    jPanel6.add(jLabel6, BorderLayout.WEST);
    jPanel6.add(jLabel7, BorderLayout.EAST);
    jPanel6.add(jLabel13, BorderLayout.NORTH);
    jPanel6.add(jLabel14, BorderLayout.SOUTH);
    jPanel6.add(jScrollPane1, BorderLayout.CENTER);
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel2.add(jPanel7, BorderLayout.NORTH);
    jPanel7.add(jLabel1,    new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel2,   new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(txtItemId,    new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel3,   new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel4,    new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel5,   new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(txtQuantitySold,    new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel8,    new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel11,   new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel12,    new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(cbxCountryCode,    new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel9,   new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jPanel9, BorderLayout.SOUTH);
    jPanel9.add(jLabel15,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel16, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(txtShippingType,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel17, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel19, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel20, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel22, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel23,  new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel24, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(txtPackageHandlingCost,  new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(txtShippingRateType,  new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(txtShippingIrregular,  new GridBagConstraints(6, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel28,  new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel30,  new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel25,  new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(txtShippingPackage, new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel29, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(txtInsuranceFee, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel18, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(txtCurrency, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel21, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(txtShipFromZipCode, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jPanel8, BorderLayout.CENTER);
    jPanel8.add(jLabel10,     new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(btnGetItemShipping,  new GridBagConstraints(1, 0, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel7.add(txtPostalCode,  new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    ComboBoxModel dataModel = new DefaultComboBoxModel(ControlEntryTypes.countryCodes);
    this.cbxCountryCode.setModel(dataModel);
    this.cbxCountryCode.setSelectedIndex(0);
    jPanel2.setPreferredSize(new Dimension(420, 350));
    jPanel3.setPreferredSize(new Dimension(420, 120));
    jPanel4.setPreferredSize(new Dimension(420, 1));
    jPanel6.setPreferredSize(new Dimension(420, 70));
    jPanel7.setPreferredSize(new Dimension(420, 155));
    jPanel8.setPreferredSize(new Dimension(420, 25));
    jPanel9.setPreferredSize(new Dimension(420, 155));
    this.setSize(new Dimension(420, 470));
    this.setResizable(false);
  }

  void btnGetItemShipping_actionPerformed(ActionEvent e)
  {
    try {
      String itemId = this.txtItemId.getText().trim();
      String quantitySold = this.txtQuantitySold.getText().trim();
      String postalCode = this.txtPostalCode.getText().trim();

      if (itemId.length() < 1 || quantitySold.length() < 1 || postalCode.length() < 1) {
          throw new Exception("ItemId, QuantirySold and PostalCode are required inputs.");
      }

      CountryCodeType cct = (CountryCodeType) ((ControlTagItem)this.cbxCountryCode.getSelectedItem()).Tag;

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      GetItemShippingCall api = new GetItemShippingCall(this.apiContext);
      api.setDetailLevel(detailLevels);
      api.setQuantitySold(new Integer(quantitySold));
      api.setItemID(itemId);
      api.setDestinationCountryCode(cct);
      api.setDestinationPostalCode(postalCode);
      ShippingDetailsType shippingDetails = api.getItemShipping();
      displayItemShipping(shippingDetails);
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void displayItemShipping(ShippingDetailsType shippingDetails)
  {
    CurrencyCodeType currencyId = null;

    ShippingTypeCodeType shippingType = shippingDetails.getShippingType();
    if (shippingType != null) {
      this.txtShippingType.setText(shippingType.value());
    }
    AmountType insuranceFee = shippingDetails.getInsuranceFee();
    if (insuranceFee != null) {
        currencyId = insuranceFee.getCurrencyID();
      this.txtInsuranceFee.setText(new Double(insuranceFee.getValue()).toString());
    }
    ShippingRateTypeCodeType shippingRateType = shippingDetails.getShippingRateType();
    if (shippingRateType != null) {
      this.txtShippingRateType.setText(shippingRateType.value());
    }
    if (shippingType == ShippingTypeCodeType.CALCULATED) {
      CalculatedShippingRateType csr = shippingDetails.getCalculatedShippingRate();
      this.txtShipFromZipCode.setText(csr.getOriginatingPostalCode());
      this.txtShippingIrregular.setText(csr.isShippingIrregular().toString());
      this.txtShippingPackage.setText(csr.getShippingPackage().value());
      AmountType costs = csr.getPackagingHandlingCosts();
      if (costs != null) {
        this.txtPackageHandlingCost.setText(new Double(costs.getValue()).toString());
        if (currencyId == null) {
          currencyId = costs.getCurrencyID();
        }
      }
    }
    if (currencyId != null) {
      this.txtCurrency.setText(currencyId.value());
    }
    DefaultMutableTreeNode root =  new DefaultMutableTreeNode("ShippingRate");
    ShippingServiceOptionTreeBuilder builder = ShippingServiceOptionTreeBuilder.getInstance();
    root.add(builder.buildShippingServiceOptionTree(shippingType, shippingDetails.getShippingServiceOptions()));
    root.add(builder.buildShippingServiceOptionTree(shippingType, shippingDetails.getInternationalShippingServiceOption()));

    JTree jTree1 = new JTree(root);
    jTree1.setEditable(false);
    jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    jTree1.setShowsRootHandles(true);
    jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
      public void valueChanged(TreeSelectionEvent e) {
      }
    });

    this.jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    this.jScrollPane1.setViewportBorder(BorderFactory.createEtchedBorder());
    this.jScrollPane1.getViewport().add(jTree1, null);
  }
}

class DialogGetItemShipping_btnGetItemShipping_actionAdapter implements java.awt.event.ActionListener {
  DialogGetItemShipping adaptee;

  DialogGetItemShipping_btnGetItemShipping_actionAdapter(DialogGetItemShipping adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetItemShipping_actionPerformed(e);
  }
}
