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
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.sdk.helper.ShippingServiceOptionTreeBuilder;
import com.ebay.sdk.helper.Utils;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BestOfferDetailsType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingEnhancementsCodeType;
import com.ebay.soap.eBLBaseComponents.ProductListingDetailsType;
import com.ebay.soap.eBLBaseComponents.ReviseStatusType;
import com.ebay.soap.eBLBaseComponents.SellerGuaranteeLevelCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */

public class DialogGetItem extends JDialog {
  private ApiContext apiContext = new ApiContext();

  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanelResult = new JPanel();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtItemId = new JTextField();
  BorderLayout borderLayout2 = new BorderLayout();
  FlowLayout flowLayout1 = new FlowLayout();
  JLabel jLabel3 = new JLabel();
  JPanel jPanelTitle = new JPanel();
  JTextField txtTitle = new JTextField();
  JPanel jPanelDescription = new JPanel();
  JLabel jLabel10 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel4 = new JLabel();
  JTextField txtReservePrice = new JTextField();
  JPanel jPanel16 = new JPanel();
  JPanel jPanel8 = new JPanel();
  JTextField txtCategory = new JTextField();
  JLabel jLabel7 = new JLabel();
  JPanel jPanelPrice = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel10 = new JPanel();
  JTextField txtBINPrice = new JTextField();
  JTextField txtCurrentPrice = new JTextField();
  JPanel jPanel14 = new JPanel();
  JPanel jPanel15 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JTextField txtQuantity = new JTextField();
  JLabel jLabel5 = new JLabel();
  JButton btnGetItem = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextPane txtaDescription = new JTextPane();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JScrollPane spShippingServices = new JScrollPane();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JTextField txtShippingType = new JTextField();
  BorderLayout borderLayout4 = new BorderLayout();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JTextField txtSellerGuarantee = new JTextField();
  JLabel jLabel21 = new JLabel();
  JTextField txtLotSize = new JTextField();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel25 = new JLabel();
  JTextField txtBorder = new JTextField();
  JLabel jLabel26 = new JLabel();
//  JTextField txtSPOT = new JTextField();
//  JLabel jLabel27 = new JLabel();
  JLabel jLabel28 = new JLabel();
  JTextField txtZip = new JTextField();
  JLabel jLabel29 = new JLabel();
  JLabel jLabel30 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel31 = new JLabel();
  JTextField txtBINPriceLowered = new JTextField();
  JTextField txtReservePriceLowered = new JTextField();
  JLabel jLabel32 = new JLabel();
//  JTextField txtApplyShippingDiscount = new JTextField();
  JLabel jLabel33 = new JLabel();
//  JLabel jLabel34 = new JLabel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel12 = new JPanel();
  JLabel jLabel35 = new JLabel();
  JTextField txtProductID = new JTextField();
  JLabel jLabel36 = new JLabel();
  JLabel jLabel37 = new JLabel();
  JTextField txtUsePreFillItemInfo = new JTextField();
  JLabel jLabel38 = new JLabel();
  JLabel jLabel39 = new JLabel();
  JTextField txtBestOfferEnabled = new JTextField();
  JLabel jLabel40 = new JLabel();
  JTextField txtBestOfferCount = new JTextField();
  ItemType item;
  
  public DialogGetItem(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
//      pack();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetItem() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jLabel1.setRequestFocusEnabled(true);
    jLabel1.setText("ItemID:");
    txtItemId.setMinimumSize(new Dimension(200, 21));
    txtItemId.setPreferredSize(new Dimension(200, 21));
    jPanelResult.setLayout(borderLayout2);
    jPanelResult.setBorder(BorderFactory.createEtchedBorder());
    flowLayout1.setHgap(5);
    jLabel3.setText("Title:       ");
    jLabel3.setRequestFocusEnabled(true);
    jLabel3.setToolTipText("");
    jLabel3.setHorizontalAlignment(SwingConstants.LEADING);
    jLabel3.setPreferredSize(new Dimension(80, 15));
    jLabel3.setMinimumSize(new Dimension(55, 15));
    jLabel3.setMaximumSize(new Dimension(55, 15));
    jPanelTitle.setLayout(flowLayout1);
    txtTitle.setMaximumSize(new Dimension(2147483647, 2147483647));
    txtTitle.setMinimumSize(new Dimension(360, 21));
    txtTitle.setOpaque(true);
    txtTitle.setPreferredSize(new Dimension(365, 21));
    txtTitle.setEditable(false);
    txtTitle.setHorizontalAlignment(SwingConstants.LEADING);
    txtTitle.setScrollOffset(0);
    jLabel10.setMaximumSize(new Dimension(55, 15));
    jLabel10.setMinimumSize(new Dimension(55, 15));
    jLabel10.setPreferredSize(new Dimension(85, 15));
    jLabel10.setText("Description:");
    jPanel2.setBorder(null);
    jPanel2.setMinimumSize(new Dimension(459, 80));

    jPanelResult.setPreferredSize(new Dimension(459, 410));
    jPanel2.setPreferredSize(new Dimension(459, 190));
    jPanel2.setLayout(gridBagLayout1);
    this.setTitle("eBay SDK for Java - GetItem");
    jLabel4.setMaximumSize(new Dimension(68, 15));
    jLabel4.setMinimumSize(new Dimension(68, 15));
    jLabel4.setPreferredSize(new Dimension(68, 15));
    jLabel4.setText("Category:");
    txtReservePrice.setMinimumSize(new Dimension(70, 21));
    txtReservePrice.setPreferredSize(new Dimension(70, 21));
    txtReservePrice.setEditable(false);
    txtReservePrice.setText("");
    txtCategory.setMinimumSize(new Dimension(70, 21));
    txtCategory.setPreferredSize(new Dimension(70, 21));
    txtCategory.setRequestFocusEnabled(true);
    txtCategory.setEditable(false);
    txtCategory.setText("");
    jLabel7.setMaximumSize(new Dimension(68, 15));
    jLabel7.setMinimumSize(new Dimension(68, 15));
    jLabel7.setPreferredSize(new Dimension(68, 15));
    jLabel7.setText("CurrentPrice:");
    jPanelPrice.setLayout(gridLayout1);
    gridLayout1.setColumns(3);
    gridLayout1.setHgap(0);
    gridLayout1.setRows(2);
    gridLayout1.setVgap(0);
    txtBINPrice.setMinimumSize(new Dimension(70, 21));
    txtBINPrice.setPreferredSize(new Dimension(70, 21));
    txtBINPrice.setEditable(false);
    txtBINPrice.setText("");
    txtCurrentPrice.setMinimumSize(new Dimension(70, 21));
    txtCurrentPrice.setPreferredSize(new Dimension(70, 21));
    txtCurrentPrice.setEditable(false);
    txtCurrentPrice.setText("");
    txtQuantity.setMinimumSize(new Dimension(70, 21));
    txtQuantity.setPreferredSize(new Dimension(70, 21));
    txtQuantity.setEditable(false);
    txtQuantity.setText("");
    jLabel5.setMaximumSize(new Dimension(68, 15));
    jLabel5.setMinimumSize(new Dimension(68, 15));
    jLabel5.setPreferredSize(new Dimension(68, 15));
    jLabel5.setText("Quantity:");
    btnGetItem.setText("GetItem");
    btnGetItem.addActionListener(new DialogGetItem_btnGetItem_actionAdapter(this));
    txtaDescription.setBorder(null);
    txtaDescription.setOpaque(true);
    txtaDescription.setPreferredSize(new Dimension(185, 21));
    txtaDescription.setEditable(false);
    jScrollPane1.setMinimumSize(new Dimension(24, 24));
    jScrollPane1.setPreferredSize(new Dimension(360, 50));
    jPanel3.setPreferredSize(new Dimension(459, 150));
    jPanel3.setLayout(borderLayout3);
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel5.setPreferredSize(new Dimension(459, 10));
    jPanel4.setPreferredSize(new Dimension(459, 25));
    jPanel4.setLayout(borderLayout4);
    jLabel2.setText("    ");
    jLabel6.setText("                ");
    jLabel11.setText("    ");
    jLabel12.setText("    ");
    jLabel13.setText("    ");
    jLabel15.setText("ReservePrice:");
    jLabel16.setText("    ");
    jLabel17.setText("    ");
    jLabel18.setText("BIN Price:");
    jLabel8.setText("ShippingType:");
    txtShippingType.setBackground(SystemColor.activeCaptionBorder);
    txtShippingType.setMinimumSize(new Dimension(70, 21));
    txtShippingType.setPreferredSize(new Dimension(70, 21));
    txtShippingType.setText("");
    spShippingServices.getViewport().setBackground(Color.white);
    jLabel9.setText("   Checkout:");
    jLabel19.setText("ShippingType:");
    jLabel20.setText("    ");
    txtSellerGuarantee.setBackground(UIManager.getColor("Button.background"));
    txtSellerGuarantee.setMinimumSize(new Dimension(70, 21));
    txtSellerGuarantee.setPreferredSize(new Dimension(70, 21));
    txtSellerGuarantee.setText("");
    jLabel21.setText("SellerGuarantee:");
    txtLotSize.setBackground(UIManager.getColor("Button.background"));
    txtLotSize.setMinimumSize(new Dimension(70, 21));
    txtLotSize.setPreferredSize(new Dimension(70, 21));
    txtLotSize.setText("");
    jLabel22.setText("LotSize:");
    jLabel23.setText("    ");
    jLabel25.setText("Border:");
    txtBorder.setBackground(UIManager.getColor("Button.background"));
    txtBorder.setMinimumSize(new Dimension(70, 21));
    txtBorder.setPreferredSize(new Dimension(70, 21));
    txtBorder.setText("");
    jLabel26.setText("    ");
/*
 *
    txtSPOT.setBackground(UIManager.getColor("Button.background"));
    txtSPOT.setMinimumSize(new Dimension(70, 21));
    txtSPOT.setPreferredSize(new Dimension(70, 21));
    txtSPOT.setRequestFocusEnabled(true);
    txtSPOT.setSelectedTextColor(Color.white);
    txtSPOT.setText("");
    jLabel27.setText("IncludeInProximitySearch:");
*/
    jLabel28.setText("PostalCode:");
    txtZip.setBackground(UIManager.getColor("Button.background"));
    txtZip.setMinimumSize(new Dimension(70, 21));
    txtZip.setPreferredSize(new Dimension(70, 21));
    txtZip.setText("");
    jLabel29.setRequestFocusEnabled(true);
    jLabel29.setText("        ");
    jLabel30.setText("    ");
    jLabel14.setText("BINPriceLowered:");
    jLabel31.setText("ReservePriceLowered:");
    txtBINPriceLowered.setBackground(UIManager.getColor("Button.background"));
    txtBINPriceLowered.setMinimumSize(new Dimension(70, 21));
    txtBINPriceLowered.setPreferredSize(new Dimension(70, 21));
    txtBINPriceLowered.setText("");
    txtReservePriceLowered.setBackground(UIManager.getColor("Button.background"));
    txtReservePriceLowered.setMinimumSize(new Dimension(70, 21));
    txtReservePriceLowered.setPreferredSize(new Dimension(70, 21));
    txtReservePriceLowered.setText("");
    jLabel32.setText("  ");
//    txtApplyShippingDiscount.setBackground(UIManager.getColor("Button.background"));
//    txtApplyShippingDiscount.setMinimumSize(new Dimension(70, 21));
//    txtApplyShippingDiscount.setPreferredSize(new Dimension(70, 21));
//    txtApplyShippingDiscount.setText("");
    jLabel33.setPreferredSize(new Dimension(69, 15));
    jLabel33.setText("NowAndNew:");
//    jLabel34.setText("ApplyShippingDiscount:");
    jPanelDescription.setLayout(borderLayout5);
    jLabel35.setRequestFocusEnabled(true);
    jLabel35.setText(" ");
    txtProductID.setMinimumSize(new Dimension(70, 21));
    txtProductID.setPreferredSize(new Dimension(70, 21));
    txtProductID.setEditable(false);
    txtProductID.setSelectionStart(0);
    txtProductID.setText("");
    panel1.setPreferredSize(new Dimension(459, 608));
    jLabel36.setMinimumSize(new Dimension(69, 15));
    jLabel36.setPreferredSize(new Dimension(69, 15));
    jLabel36.setHorizontalAlignment(SwingConstants.LEADING);
    jLabel36.setHorizontalTextPosition(SwingConstants.LEFT);
    jLabel36.setText("Catalog product ID:");
    jLabel37.setText("Inc pre-filled item info:");
    txtUsePreFillItemInfo.setMinimumSize(new Dimension(70, 21));
    txtUsePreFillItemInfo.setPreferredSize(new Dimension(70, 21));
    txtUsePreFillItemInfo.setEditable(false);
    txtUsePreFillItemInfo.setText("");
    jLabel38.setText(" ");
    jLabel39.setText("Best Offer Enabled:");
    txtBestOfferEnabled.setMinimumSize(new Dimension(70, 21));
    txtBestOfferEnabled.setPreferredSize(new Dimension(70, 21));
    txtBestOfferEnabled.setEditable(false);
    txtBestOfferEnabled.setText("");
    jLabel40.setText("Best Offer Count:");
    txtBestOfferCount.setMinimumSize(new Dimension(70, 21));
    txtBestOfferCount.setPreferredSize(new Dimension(70, 21));
    txtBestOfferCount.setEditable(false);
    txtBestOfferCount.setText("");
    jPanelDescription.add(jPanel12, BorderLayout.CENTER);
    jPanel12.add(jLabel10, null);
    jPanel12.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtaDescription, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(txtItemId, null);
    jPanel1.add(jLabel29, null);
    jPanel1.add(btnGetItem, null);
    getContentPane().add(panel1);
    panel1.add(jPanel1, BorderLayout.NORTH);
    panel1.add(jPanelResult, BorderLayout.CENTER);
    panel1.add(jPanel3,  BorderLayout.SOUTH);
    jPanel3.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(jLabel9, BorderLayout.WEST);
    jPanel3.add(jPanel5, BorderLayout.SOUTH);
    jPanel3.add(jPanel6, BorderLayout.WEST);
    jPanel3.add(jPanel7, BorderLayout.EAST);
    jPanel3.add(spShippingServices, BorderLayout.CENTER);
    jPanelResult.add(jPanelTitle,  BorderLayout.NORTH);
    jPanelTitle.add(jLabel3, null);
    jPanelTitle.add(txtTitle, null);
    jPanelResult.add(jPanelDescription,  BorderLayout.SOUTH);
    jPanelResult.add(jPanel2, BorderLayout.CENTER);

    jPanel2.add(jLabel5,             new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel2,             new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtQuantity,            new GridBagConstraints(2, 0, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel6,             new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel4,             new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel11,            new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtCategory,           new GridBagConstraints(6, 0, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel12,            new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel13,            new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtCurrentPrice,           new GridBagConstraints(2, 3, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel7,            new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel16,            new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel17,            new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel18,             new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtBINPrice,           new GridBagConstraints(2, 6, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel20,            new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel23,           new GridBagConstraints(2, 12, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel25,            new GridBagConstraints(4, 13, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtBorder,             new GridBagConstraints(6, 13, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//    jPanel2.add(txtSPOT,             new GridBagConstraints(2, 15, 1, 1, 0.0, 0.0
//            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//    jPanel2.add(jLabel27,             new GridBagConstraints(0, 15, 1, 1, 0.0, 0.0
//            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel28,             new GridBagConstraints(4, 15, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtZip,             new GridBagConstraints(6, 15, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel30,           new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel21,         new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtSellerGuarantee,         new GridBagConstraints(2, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel22,         new GridBagConstraints(4, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtLotSize,         new GridBagConstraints(6, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel15,         new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtReservePrice,         new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel19,         new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtShippingType,         new GridBagConstraints(6, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel14,           new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel31,           new GridBagConstraints(4, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtBINPriceLowered,           new GridBagConstraints(6, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtReservePriceLowered,           new GridBagConstraints(6, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel32,          new GridBagConstraints(0, 14, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//    jPanel2.add(txtApplyShippingDiscount,           new GridBagConstraints(6, 17, 1, 1, 0.0, 0.0
//            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//    jPanel2.add(jLabel34,           new GridBagConstraints(4, 17, 1, 1, 0.0, 0.0
//            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel35,       new GridBagConstraints(2, 16, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel36,       new GridBagConstraints(0, 17, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 43, 0));
    jPanel2.add(jLabel33,      new GridBagConstraints(0, 15, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -1, 0, 1), 7, 0));
    jPanel2.add(txtUsePreFillItemInfo,      new GridBagConstraints(6, 19, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel38,      new GridBagConstraints(0, 18, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtProductID,    new GridBagConstraints(2, 17, 1, 3, 0.0, 0.0
            ,GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel39,    new GridBagConstraints(0, 19, 1, 2, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtBestOfferEnabled,    new GridBagConstraints(2, 19, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel40, new GridBagConstraints(4, 22, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel37, new GridBagConstraints(4, 19, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 4), 0, 0));
	jPanel2.add(jLabel26,            new GridBagConstraints(0, 21, 1, 1, 0.0, 0.0
			,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtBestOfferCount, new GridBagConstraints(6, 22, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    this.setModal(true);
    this.setResizable(false);
    this.setSize(new Dimension(520, 670));
  }

  void btnGetItem_actionPerformed(ActionEvent e) {

    try
    {
      if( this.txtItemId.getText().length() == 0 )
        throw new Exception("Please enter Item ID first.");

      GetItemCall api = new GetItemCall(apiContext);

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };
      api.setDetailLevel(detailLevels);

      String itemID = this.txtItemId.getText();
      itemID = itemID.trim();
      item = api.getItem(itemID);

      // Display data in GUI.
      txtTitle.setText(item.getTitle());
      txtQuantity.setText(item.getQuantity().toString());
      txtCategory.setText(item.getPrimaryCategory().getCategoryID());
      txtCurrentPrice.setText(
        (new Double(item.getSellingStatus().getCurrentPrice().getValue()).toString()));

      AmountType amt = item.getReservePrice();
      this.txtReservePrice.setText(
        amt == null ? "" : (new Double(amt.getValue()).toString()));

      amt = item.getBuyItNowPrice();
      txtBINPrice.setText(
        amt == null ? "" : (new Double(amt.getValue()).toString()));

      ReviseStatusType reviseStatus = item.getReviseStatus();
      Boolean binPriceLowered = reviseStatus.isBuyItNowLowered();
      if (binPriceLowered != null) {
        this.txtBINPriceLowered.setText(binPriceLowered.toString());
      }
      Boolean reservePriceLowered = reviseStatus.isReserveLowered();
      if (reservePriceLowered != null) {
        this.txtReservePriceLowered.setText(reservePriceLowered.toString());
      }
      this.txtaDescription.setText(item.getDescription());

      SellerGuaranteeLevelCodeType level = item.getSeller().getSellerInfo().getSellerGuaranteeLevel();
      if (level != null) {
        this.txtSellerGuarantee.setText(level.value());
      }
      Integer lotSize = item.getLotSize();
      if (lotSize != null) {
        this.txtLotSize.setText(lotSize.toString());
      }

      ListingEnhancementsCodeType[] enhancements = item.getListingEnhancement();
      int len = enhancements != null ? enhancements.length : 0;
      if (len > 0) {
        for (int i = 0; i < len; i++) {
          if (enhancements[i] == ListingEnhancementsCodeType.BORDER) {
            this.txtBorder.setText("true");
          }
        }
      }

      ProductListingDetailsType pld = item.getProductListingDetails();
      if( pld != null )
      {
        this.txtProductID.setText(Utils.getDispString(pld.getProductID()));

        this.txtUsePreFillItemInfo.setText(Utils.booleanToYesNo(pld.isIncludePrefilledItemInformation()));
      }

      this.txtBestOfferEnabled.setText("");
      this.txtBestOfferCount.setText("");
      BestOfferDetailsType bod = item.getBestOfferDetails();
      if( bod != null )
      {
        this.txtBestOfferEnabled.setText(Utils.booleanToYesNo(bod.isBestOfferEnabled()));

        String cnt = bod.getBestOfferCount() == null ? "" : bod.getBestOfferCount().toString();
        this.txtBestOfferCount.setText(cnt);
      }

  /*    ProximitySearchDetailsType spot = item.getProximitySearchDetails();
      if (spot != null) {

        this.txtZip.setText(spot.getPostalCode().toString());
      }
      */


//      Boolean applyShippingDiscount = item.isApplyShippingDiscount();
//      if (applyShippingDiscount != null) {
//        this.txtApplyShippingDiscount.setText(applyShippingDiscount.toString());
//      }

      displayShippingServices(item.getShippingDetails());
    }
    catch(Exception ex)
    {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void displayShippingServices(ShippingDetailsType shippingDetails)
  {
    ShippingTypeCodeType shippingType = shippingDetails.getShippingType();

    if (shippingType != null) {
      this.txtShippingType.setText(shippingType.value());
    }

    DefaultMutableTreeNode root =  new DefaultMutableTreeNode("Checkout Details");
    ShippingServiceOptionTreeBuilder builder = ShippingServiceOptionTreeBuilder.getInstance();
    root.add(builder.buildShippingServiceOptionTree(shippingType, shippingDetails.getShippingServiceOptions()));
    root.add(builder.buildShippingServiceOptionTree(shippingType, shippingDetails.getInternationalShippingServiceOption()));

    JTree jTree1 = new JTree(root);
    jTree1.setEditable(false);
    jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    jTree1.setShowsRootHandles(true);

    this.spShippingServices.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    this.spShippingServices.setViewportBorder(BorderFactory.createEtchedBorder());
    this.spShippingServices.getViewport().add(jTree1, null);
  }
  
  public ItemType getItem() {
	  return item;
  }
}

class DialogGetItem_btnGetItem_actionAdapter implements java.awt.event.ActionListener {
  DialogGetItem adaptee;

  DialogGetItem_btnGetItem_actionAdapter(DialogGetItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetItem_actionPerformed(e);
  }
}
