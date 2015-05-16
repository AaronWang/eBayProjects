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
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import apicallsdemo.DialogEditInternationalShippingService;
import apicallsdemo.DialogEditShippingService;
import apicallsdemo.FrameDemo;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.helper.InternationalShippingServiceSelector;
import com.ebay.sdk.helper.ServiceControlManager;
import com.ebay.sdk.helper.ShippingServiceHelper;
import com.ebay.sdk.helper.ShippingServiceSelector;
import com.ebay.sdk.helper.ui.ControlBuilder;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BestOfferDetailsType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.FeeType;
import com.ebay.soap.eBLBaseComponents.FeesType;
import com.ebay.soap.eBLBaseComponents.InternationalShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDurationCodeType;
import com.ebay.soap.eBLBaseComponents.ListingEnhancementsCodeType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SellerPaymentProfileType;
import com.ebay.soap.eBLBaseComponents.SellerProfilesType;
import com.ebay.soap.eBLBaseComponents.SellerReturnProfileType;
import com.ebay.soap.eBLBaseComponents.SellerShippingProfileType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.ebay.soap.eBLBaseComponents.VATDetailsType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */

public class DialogAddItem extends JDialog implements MouseListener
{
  private ApiContext apiContext = new ApiContext();

  Frame parentFrame;
  SiteCodeType siteId;

  ControlTagItem[] ctrlPaymentServices = new ControlTagItem[] {};
  JCheckBox[] ckbPaymentServices;
  ArrayList shippingServiceOptions = new ArrayList();
  ArrayList intlShippingServiceOptions = new ArrayList();
  JCheckBox[] ckbShipToLocations;
 
  GridBagLayout paymentGridLayout = new GridBagLayout();
  
  JLabel paymentIDLabel = new JLabel();
  JLabel paymentNameLabel = new JLabel();
  JLabel returnIDLabel = new JLabel();
  JLabel returnNameLabel = new JLabel();
  JLabel shippingIDLabel = new JLabel();
  JLabel shippingNameLabel = new JLabel();
  
  
  JTextField paymentIDTextField = new JTextField();
  JTextField paymentNameTextField = new JTextField();
  JTextField returnIDTextField = new JTextField();
  JTextField returnNameTextField = new JTextField();
  JTextField shippingIDTextField = new JTextField();
  JTextField shippingNameTextField = new JTextField();
  
  BorderLayout borderLayout0 = new BorderLayout();
  JScrollPane spParent = new JScrollPane();
  JPanel jPanel0 = new JPanel();

  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtItemId = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtListingFee = new JTextField();
  JPanel jPanelPrice = new JPanel();
  JPanel jPanel7 = new JPanel();
  JLabel jLabel3 = new JLabel();
  JTextField txtTitle = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField txtCategory = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtQuantity = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField txtStartPrice = new JTextField();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel conditionLabel = new JLabel();
  JTextField txtReservePrice = new JTextField();
  JTextField txtBINPrice = new JTextField();
  JPanel jPanel17 = new JPanel();
  JPanel jPanel18 = new JPanel();
  JButton btnListToEBay = new JButton();
  JPanel jPanelPicFiles = new JPanel();
  JPanel jPanel20 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  BorderLayout borderLayout4 = new BorderLayout();
  JTextField txtItemLocation = new JTextField();
  JPanel jPanel23 = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  BorderLayout borderLayout6 = new BorderLayout();
  JList jListPictureFiles = new JList();
  FlowLayout flowLayout1 = new FlowLayout();
  JLabel jLabel14 = new JLabel();
  JButton btnRemoveImage = new JButton();
  JButton btnAddImage = new JButton();
  JPanel jPanel6 = new JPanel();
  JLabel jLabel20 = new JLabel();
  JButton btnVerifyAddItem = new JButton();
  JComboBox cbxDuration = new JComboBox();
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  BorderLayout borderLayout8 = new BorderLayout();
  JPanel jPanel22 = new JPanel();
  JPanel jPanel25 = new JPanel();
  JPanel jPanel26 = new JPanel();
  BorderLayout borderLayout9 = new BorderLayout();
  BorderLayout borderLayout10 = new BorderLayout();
  JPanel jPanel27 = new JPanel();
  JPanel jPanel28 = new JPanel();
  JPanel jPanel29 = new JPanel();
  JPanel jPanel30 = new JPanel();
  JPanel jPanel31 = new JPanel();
  JPanel jPanel32 = new JPanel();
  JButton btnAddIntlShippingService = new JButton();
  JButton btnRemoveIntlShippingService = new JButton();
  BorderLayout borderLayout11 = new BorderLayout();
  JLabel jLabel24 = new JLabel();
  JLabel jLabel25 = new JLabel();
  JScrollPane spIntlShippingServiceOptions = new JScrollPane();
  JButton btnAddShippingService = new JButton();
  JButton btnRemoveShippingService = new JButton();
  BorderLayout borderLayout12 = new BorderLayout();
  JLabel jLabel29 = new JLabel();
  JLabel jLabel30 = new JLabel();
  JScrollPane spShippingServiceOptions = new JScrollPane();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JLabel jLabel31 = new JLabel();
  JLabel jLabel32 = new JLabel();
  JLabel jLabel33 = new JLabel();
  JLabel jLabel34 = new JLabel();
  JLabel jLabel35 = new JLabel();
  JLabel jLabel36 = new JLabel();
  JLabel jLabel37 = new JLabel();
  JLabel jLabel38 = new JLabel();
  JLabel jLabel39 = new JLabel();
  BorderLayout borderLayout13 = new BorderLayout();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel50 = new JPanel();

  BorderLayout borderLayout14 = new BorderLayout();
  JLabel jLabel41 = new JLabel();
  JLabel jLabel42 = new JLabel();
  JComboBox cbxSite = new JComboBox();
  BorderLayout borderLayout15 = new BorderLayout();
  JLabel jLabel27 = new JLabel();
  JLabel jLabel28 = new JLabel();
  JPanel jPanel10 = new JPanel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel43 = new JLabel();
  BorderLayout borderLayout16 = new BorderLayout();
  JPanel jPanel14 = new JPanel();
  GridBagLayout gridBagLayout4 = new GridBagLayout();
  JLabel jLabel45 = new JLabel();
  BorderLayout borderLayout17 = new BorderLayout();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel23 = new JLabel();
  BorderLayout borderLayout18 = new BorderLayout();
  JComboBox cbxShippingType = new JComboBox();
  JPanel jPanel15 = new JPanel();
  JPanel jPanel16 = new JPanel();
  JPanel jPanel33 = new JPanel();
  BorderLayout borderLayout19 = new BorderLayout();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JPanel jPanel34 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel21 = new JLabel();
  GridBagLayout gridBagLayout6 = new GridBagLayout();
  JLabel jLabel26 = new JLabel();
  JLabel jLabel46 = new JLabel();
  JLabel jLabel47 = new JLabel();
  JLabel jLabel48 = new JLabel();
  JLabel jLabel49 = new JLabel();
  JLabel jLabel50 = new JLabel();
  JComboBox cbxListingType = new JComboBox();
  JComboBox cbxCondition = new JComboBox();
  JLabel jLabel51 = new JLabel();
  JLabel jLabel52 = new JLabel();
  JTextField txtLotSize = new JTextField();
  JPanel jPanel19 = new JPanel();
  JPanel jPanel21 = new JPanel();
  JPanel jPanel24 = new JPanel();
  JPanel jPanel35 = new JPanel();
  BorderLayout borderLayout20 = new BorderLayout();
  JPanel jPanel36 = new JPanel();
  JPanel jPanel37 = new JPanel();
  JPanel jPanel38 = new JPanel();
  BorderLayout borderLayout21 = new BorderLayout();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  BorderLayout borderLayout22 = new BorderLayout();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel15 = new JLabel();
  BorderLayout borderLayout23 = new BorderLayout();
  JPanel jPanel39 = new JPanel();
  JPanel jPanel40 = new JPanel();
  JPanel jPanel41 = new JPanel();
  JPanel jPanel42 = new JPanel();
  GridBagLayout gridBagLayout5 = new GridBagLayout();
  JLabel jLabel16 = new JLabel();
  GridBagLayout gridBagLayout7 = new GridBagLayout();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel54 = new JLabel();
  JLabel jLabel55 = new JLabel();
  JLabel jLabel56 = new JLabel();
  JLabel jLabel57 = new JLabel();
  JLabel jLabel58 = new JLabel();
  JLabel jLabel59 = new JLabel();
  JLabel jLabel60 = new JLabel();
  JLabel jLabel61 = new JLabel();
  JLabel jLabel62 = new JLabel();
  JLabel jLabel63 = new JLabel();
  JLabel jLabel64 = new JLabel();
  JLabel jLabel65 = new JLabel();
  JLabel jLabel66 = new JLabel();
  JLabel jLabel67 = new JLabel();
  JLabel jLabel69 = new JLabel();
  JLabel jLabel70 = new JLabel();
  JLabel jLabel71 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextPane txtaDescription = new JTextPane();
  JScrollPane jScrollPane2 = new JScrollPane();
  JLabel jLabel72 = new JLabel();
  JLabel jLabel73 = new JLabel();
  JLabel jLabel77 = new JLabel();
  JLabel jLabel78 = new JLabel();
  JTextField txtVATPercent = new JTextField();
  JTextField txtZip = new JTextField();
  JLabel jLabel68 = new JLabel();
  JTextField txtPayPalEmail = new JTextField();
  JCheckBox ckbAutoPay = new JCheckBox();
  JCheckBox ckbBorder = new JCheckBox();
  JLabel jLabel44 = new JLabel();
  JButton btnImage = new JButton();
  Border border1;
  JPanel jPanel43 = new JPanel();
  JPanel jPanel44 = new JPanel();
  JPanel jPanelPaymentMethods = new JPanel();
  JPanel paymentprofile = new JPanel();  
  
  BorderLayout borderLayout24 = new BorderLayout();
  JLabel jLabel40 = new JLabel();
  BorderLayout borderLayout25 = new BorderLayout();
  JPanel jPanel45 = new JPanel();
  JPanel jPanel46 = new JPanel();
  JPanel jPanelShipToLocations = new JPanel();
  BorderLayout borderLayout26 = new BorderLayout();
  JLabel jLabel76 = new JLabel();
  GridBagLayout gridBagLayout8 = new GridBagLayout();
  JLabel jLabel74 = new JLabel();
  JCheckBox ckbBoldTitle = new JCheckBox();
  JLabel jLabel79 = new JLabel();
  JLabel jLabel80 = new JLabel();
  JCheckBox cbxBestOffer = new JCheckBox();

  public DialogAddItem(Frame frame, String title, SiteCodeType siteId, boolean modal) {
    super(frame, title, modal);
    this.siteId = siteId;
    this.parentFrame = frame;
    try {
      jbInit();
      customInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      // Initialize combo box.
      Object[] list = new Object[] {
          new ControlTagItem("3 days", ListingDurationCodeType.DAYS_3),
          new ControlTagItem("5 days", ListingDurationCodeType.DAYS_5),
          new ControlTagItem("7 days", ListingDurationCodeType.DAYS_7),
          new ControlTagItem("10 days", ListingDurationCodeType.DAYS_10),
          new ControlTagItem("30 days", ListingDurationCodeType.DAYS_30),
          new ControlTagItem("GTC", ListingDurationCodeType.GTC),
      };
      ComboBoxModel dataModel = new DefaultComboBoxModel(list);
      this.cbxDuration.setModel(dataModel);
      this.cbxDuration.setSelectedIndex(0);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  private DialogAddItem() {
    this(null, "", SiteCodeType.US, false);
  }

  private void jbInit() throws Exception {
	  
    border1 = new MatteBorder(null);
    jPanel0.setLayout(borderLayout0);
    spParent.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    ckbAutoPay.setText("");
    ckbBorder.setText("");
    jLabel44.setMaximumSize(new Dimension(8, 5));
    jLabel44.setMinimumSize(new Dimension(8, 5));
    jLabel44.setPreferredSize(new Dimension(8, 5));
    jLabel44.setText("");
    jLabel16.setMaximumSize(new Dimension(12, 5));
    jLabel16.setMinimumSize(new Dimension(12, 5));
    jLabel16.setPreferredSize(new Dimension(12, 5));
    jLabel16.setText("");
    btnImage.setBackground(Color.white);
    btnImage.setBorder(BorderFactory.createLineBorder(Color.black));
    btnImage.setMaximumSize(new Dimension(35, 35));
    btnImage.setMinimumSize(new Dimension(35, 35));
    btnImage.setPreferredSize(new Dimension(35, 35));
    btnImage.setText("");
    jPanel43.setPreferredSize(new Dimension(10, 30));
    jPanel43.setLayout(borderLayout24);
    //jLabel40.setText("    PaymentMethods:");
    jLabel40.setText("    PaymentProfile:");
    jPanel50.setLayout(borderLayout25);
    jPanel45.setBorder(null);
    jPanel45.setPreferredSize(new Dimension(10, 30));
    jPanel45.setLayout(borderLayout26);
    jLabel76.setText("    ShipToLocations:");
    jPanelShipToLocations.setLayout(gridBagLayout8);
    jLabel74.setText("BoldTitle:");
    ckbBoldTitle.setText("");
    jLabel79.setText(" ");
    jLabel80.setText("Best Offer:");
    cbxBestOffer.setText("Enable Best Offer");
    txtZip.setMinimumSize(new Dimension(70, 21));
    txtPayPalEmail.setMinimumSize(new Dimension(120, 21));
    txtVATPercent.setMinimumSize(new Dimension(70, 21));
    txtLotSize.setMinimumSize(new Dimension(50, 21));
    cbxDuration.setMinimumSize(new Dimension(60, 21));
    txtReservePrice.setText("");
    cbxListingType.addItemListener(new DialogAddItem_cbxListingType_itemAdapter(this));
    cbxListingType.setMinimumSize(new Dimension(120, 21));
    cbxListingType.setPreferredSize(new Dimension(120, 21));
    cbxCondition.setMinimumSize(new Dimension(60, 21));
    cbxCondition.setPreferredSize(new Dimension(60, 21));
    this.getContentPane().add(spParent, BorderLayout.CENTER);
    spParent.getViewport().add(jPanel0, null);

    jPanel11.setLayout(borderLayout13);
    jPanelPrice.setBorder(BorderFactory.createEtchedBorder());
    jPanelPrice.setPreferredSize(new Dimension(600, 180));
    jLabel31.setText("    ");
    jLabel32.setText("                ");
    jLabel33.setText("         ");
    jLabel34.setText("    ");
    jLabel35.setText("    ");
    jLabel36.setText("        ");
    jLabel37.setText("    ");
    jLabel38.setText("    ");
    jLabel39.setText("    ");
    jPanel8.setBorder(BorderFactory.createEtchedBorder());
    jPanel8.setPreferredSize(new Dimension(10, 120));
    jPanel8.setRequestFocusEnabled(true);
    //jPanel8.setLayout(borderLayout14);
    jPanel8.setLayout(paymentGridLayout);
    
    jLabel41.setText("    ");
    jLabel42.setText("    SiteID:");
    jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
    jPanel1.setMinimumSize(new Dimension(553, 31));
    jPanel1.setPreferredSize(new Dimension(553, 40));
    txtTitle.setFont(new java.awt.Font("MS Sans Serif", 0, 11));
    jLabel27.setText("    ShippingServiceOptions:                   ");
    jLabel28.setText("    ");
    jPanel10.setLayout(gridBagLayout2);
    jLabel43.setText("        ");
    jPanel26.setLayout(borderLayout16);
    jPanel14.setLayout(gridBagLayout4);
    jLabel45.setText("        ");
    jLabel22.setText("    InternationalShippingServiceOptions:");   
    jLabel23.setText("    ");
    jPanel26.setPreferredSize(new Dimension(12, 2));
    jPanel26.setRequestFocusEnabled(true);
    jPanel26.setToolTipText("");
    jPanel14.setPreferredSize(new Dimension(144, 20));
    //jPanelPaymentMethods.setLayout(gridBagLayout6);
    paymentprofile.setLayout(gridBagLayout6);
    
    btnAddIntlShippingService.addActionListener(new DialogAddItem_btnAddIntlShippingService_actionAdapter(this));
    btnAddShippingService.addActionListener(new DialogAddItem_btnAddShippingService_actionAdapter(this));
    btnRemoveShippingService.addActionListener(new DialogAddItem_btnRemoveShippingService_actionAdapter(this));
    btnRemoveIntlShippingService.addActionListener(new DialogAddItem_btnRemoveIntlShippingService_actionAdapter(this));
    //cbxSite.addActionListener(new DialogAddItem_cbxSite_actionAdapter(this));
    jPanel9.setPreferredSize(new Dimension(10, 2));
    jPanel13.setLayout(borderLayout18);
    jPanel13.setMinimumSize(new Dimension(553, 31));
    jPanel13.setPreferredSize(new Dimension(80, 60));
    jPanel13.setToolTipText("");
    spShippingServiceOptions.getViewport().setBackground(Color.white);
    spIntlShippingServiceOptions.getViewport().setBackground(Color.white);
    cbxDuration.setPreferredSize(new Dimension(60, 21));
    cbxDuration.setSelectedIndex(-1);
    cbxSite.setPreferredSize(new Dimension(70, 21));
    jPanel15.setPreferredSize(new Dimension(10, 30));
    jPanel15.setLayout(borderLayout19);
    jLabel17.setText("    ShippingType:");
    jLabel18.setText("    ");
    jPanel34.setLayout(gridBagLayout1);
    jLabel21.setPreferredSize(new Dimension(350, 15));
    jLabel26.setToolTipText("");
    jLabel26.setText(" ");
    jLabel46.setText(" ");
    jLabel47.setText("        ");
    jLabel48.setText("LotSize:");
    jLabel49.setText("        ");
    jLabel50.setText("        ");
    jLabel51.setText("BIN Price:");
    jLabel52.setText("        ");
    jLabel7.setToolTipText("");
    jPanel23.setPreferredSize(new Dimension(600, 235));
    jPanel24.setOpaque(true);
    jPanel24.setPreferredSize(new Dimension(100, 10));
    jPanel24.setLayout(gridBagLayout7);
    jPanel35.setLayout(borderLayout20);
    jPanel37.setPreferredSize(new Dimension(10, 120));
    jPanel37.setLayout(borderLayout23);
    jPanel36.setBorder(null);
    jPanel36.setMinimumSize(new Dimension(10, 100));
    jPanel36.setPreferredSize(new Dimension(14, 80));
    jPanel36.setLayout(borderLayout21);
    jLabel12.setText("    ");
    jPanel38.setLayout(borderLayout22);
    jPanel41.setPreferredSize(new Dimension(80, 10));
    jPanel41.setLayout(gridBagLayout5);
    jLabel10.setText("");
    jLabel11.setText("");
    jLabel6.setText("");
    jLabel15.setText("");
    jLabel13.setText("");
    jPanel21.setPreferredSize(new Dimension(10, 2));
    jPanel40.setPreferredSize(new Dimension(0, 10));
    jLabel19.setText("  ");
    jLabel54.setText("  ");
    jLabel55.setText("  ");
    jLabel56.setText("  ");
    jLabel57.setText("for the item:");
    jLabel58.setText("Picture files");
    jLabel59.setText("  ");
    jLabel60.setText("  ");
    jLabel61.setText("Location:");
    jLabel62.setText("  ");
    jLabel63.setText("  ");
    jLabel64.setText("  ");
    jLabel65.setText("  ");
    jLabel66.setText("Description:");
    jLabel67.setText("    ");
    txtLotSize.setPreferredSize(new Dimension(50, 21));
    txtLotSize.setText("");
    jLabel69.setText("AutoPay:");
    jLabel70.setText("VATPercent:");
    conditionLabel.setMaximumSize(new Dimension(68, 15));
    conditionLabel.setMinimumSize(new Dimension(68, 15));
    conditionLabel.setPreferredSize(new Dimension(68, 15));
    conditionLabel.setText("Condition : ");
    jLabel71.setRequestFocusEnabled(true);
    jLabel71.setText("Border:");
    txtaDescription.setVerifyInputWhenFocusTarget(true);
    txtaDescription.setText("SDK item description");
    jLabel72.setText("    ");
    jLabel73.setText("PostalCode:");
    jLabel77.setText("    ");
    jLabel78.setText("    ");
    txtVATPercent.setPreferredSize(new Dimension(70, 21));
    txtVATPercent.setText("");
    txtZip.setPreferredSize(new Dimension(70, 21));
    txtZip.setText("");
    txtZip.addActionListener(new DialogAddItem_txtZip_actionAdapter(this));
    jLabel68.setText("");
    jLabel68.setText("PayPalEmail:");
    txtPayPalEmail.setPreferredSize(new Dimension(120, 21));
    txtPayPalEmail.setRequestFocusEnabled(true);
    txtPayPalEmail.setSelectedTextColor(Color.white);
    txtPayPalEmail.setText("");

    panel1.setLayout(borderLayout1);
    jPanel3.setLayout(borderLayout2);
    jLabel1.setPreferredSize(new Dimension(46, 15));
    jLabel1.setRequestFocusEnabled(true);
    jLabel1.setToolTipText("");
    jLabel1.setText("ItemID:");
    txtItemId.setMinimumSize(new Dimension(160, 21));
    txtItemId.setOpaque(true);
    txtItemId.setPreferredSize(new Dimension(160, 21));
    txtItemId.setRequestFocusEnabled(true);
    txtItemId.setEditable(false);
    jLabel2.setText("ListingFee:");
    txtListingFee.setPreferredSize(new Dimension(57, 21));
    txtListingFee.setEditable(false);
    txtListingFee.setText("");
    jPanel4.setMaximumSize(new Dimension(200, 32767));
    jPanel4.setMinimumSize(new Dimension(300, 31));
    jPanel4.setOpaque(true);
    jPanel4.setPreferredSize(new Dimension(300, 31));
    jLabel3.setMaximumSize(new Dimension(70, 15));
    jLabel3.setMinimumSize(new Dimension(70, 15));
    jLabel3.setPreferredSize(new Dimension(70, 15));
    jLabel3.setRequestFocusEnabled(true);
    jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel3.setText("Title:    ");
    txtTitle.setMaximumSize(new Dimension(2147483647, 2147483647));
    txtTitle.setMinimumSize(new Dimension(360, 21));
    txtTitle.setOpaque(true);
    txtTitle.setPreferredSize(new Dimension(360, 21));
    txtTitle.setText("SDK item title");
    txtTitle.setHorizontalAlignment(SwingConstants.LEFT);
    jPanelPrice.setLayout(gridBagLayout3);
    jLabel4.setText("Category:");
    jLabel5.setMaximumSize(new Dimension(68, 15));
    jLabel5.setMinimumSize(new Dimension(68, 15));
    jLabel5.setPreferredSize(new Dimension(68, 15));
    jLabel5.setText("ListingType:");
    txtQuantity.setMinimumSize(new Dimension(70, 21));
    txtQuantity.setPreferredSize(new Dimension(70, 21));
    txtQuantity.setText("1");
    jLabel7.setText("Duration:");
    txtStartPrice.setMinimumSize(new Dimension(70, 21));
    txtStartPrice.setPreferredSize(new Dimension(70, 21));
    txtStartPrice.setText("1.0");
    jLabel8.setPreferredSize(new Dimension(68, 15));
    jLabel8.setText("StartPrice:");
    jLabel9.setMaximumSize(new Dimension(50, 15));
    jLabel9.setMinimumSize(new Dimension(50, 15));
    jLabel9.setPreferredSize(new Dimension(75, 15));
    jLabel9.setText("ReservePrice:");
    txtReservePrice.setMinimumSize(new Dimension(70, 21));
    txtReservePrice.setPreferredSize(new Dimension(70, 21));
    btnListToEBay.setText("AddItem");
    btnListToEBay.addActionListener(new DialogAddItem_btnListToEBay_actionAdapter(this));
    jPanel7.setLayout(borderLayout3);
    jPanel20.setLayout(borderLayout4);
    txtItemLocation.setMinimumSize(new Dimension(360, 21));
    txtItemLocation.setOpaque(true);
    txtItemLocation.setPreferredSize(new Dimension(487, 21));
    txtItemLocation.setRequestFocusEnabled(true);
    txtItemLocation.setText("San Jose, CA");
    jPanelPicFiles.setLayout(borderLayout5);
    jPanel23.setLayout(borderLayout6);
    jListPictureFiles.setBorder(BorderFactory.createLoweredBevelBorder());
    jListPictureFiles.setMaximumSize(new Dimension(10000, 10000));
    jListPictureFiles.setMinimumSize(new Dimension(300, 120));
    jListPictureFiles.setPreferredSize(new Dimension(450, 120));
    jPanel1.setLayout(flowLayout1);
    flowLayout1.setAlignment(FlowLayout.LEFT);
    flowLayout1.setHgap(5);
    jLabel14.setPreferredSize(new Dimension(9, 15));
    jLabel14.setRequestFocusEnabled(true);
    jLabel14.setText("   ");
    btnRemoveImage.setBorder(BorderFactory.createEtchedBorder());
    btnRemoveImage.setMaximumSize(new Dimension(50, 25));
    btnRemoveImage.setMinimumSize(new Dimension(50, 25));
    btnRemoveImage.setPreferredSize(new Dimension(50, 20));
    btnRemoveImage.setMnemonic('0');
    btnRemoveImage.setSelected(false);
    btnRemoveImage.setText("Remove");
    btnRemoveImage.addActionListener(new DialogAddItem_btnRemoveImage_actionAdapter(this));
    btnAddImage.setBorder(BorderFactory.createEtchedBorder());
    btnAddImage.setMaximumSize(new Dimension(50, 25));
    btnAddImage.setMinimumSize(new Dimension(50, 25));
    btnAddImage.setPreferredSize(new Dimension(50, 20));
    btnAddImage.setMnemonic('0');
    btnAddImage.setText("Add");
    btnAddImage.addActionListener(new DialogAddItem_btnAddImage_actionAdapter(this));
    jPanel6.setMinimumSize(new Dimension(30, 10));
    jPanel6.setOpaque(true);
    jPanel6.setPreferredSize(new Dimension(5, 10));
    jPanel6.setRequestFocusEnabled(true);
    txtCategory.setMinimumSize(new Dimension(70, 21));
    txtCategory.setPreferredSize(new Dimension(70, 21));
    txtCategory.setRequestFocusEnabled(true);
    txtCategory.setText("139971");
    txtBINPrice.setMinimumSize(new Dimension(50, 21));
    txtBINPrice.setPreferredSize(new Dimension(50, 21));
    this.setTitle("eBay SDK for Java - AddItem/VerifyAddItem");
    jLabel20.setMaximumSize(new Dimension(50, 15));
    jLabel20.setMinimumSize(new Dimension(50, 15));
    jLabel20.setPreferredSize(new Dimension(50, 15));
    jLabel20.setText("Quantity:");
    btnVerifyAddItem.setText("VerifyAddItem");
    btnVerifyAddItem.addActionListener(new DialogAddItem_btnVerifyAddItem_actionAdapter(this));
    jPanel18.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setLayout(borderLayout7);
    jPanel12.setBorder(null);
    jPanel12.setPreferredSize(new Dimension(10, 260));
    jPanel12.setRequestFocusEnabled(true);
    jPanel12.setToolTipText("");
    jPanel12.setLayout(borderLayout8);
    jPanel11.setBorder(BorderFactory.createEtchedBorder());
    //jPanel11.setPreferredSize(new Dimension(10, 240));
    jPanel22.setBorder(BorderFactory.createEtchedBorder());
    jPanel22.setPreferredSize(new Dimension(14, 120));
    jPanel22.setLayout(borderLayout9);
    jPanel25.setBorder(BorderFactory.createEtchedBorder());
    jPanel25.setPreferredSize(new Dimension(14, 120));
    jPanel25.setLayout(borderLayout10);
    jPanel27.setBorder(null);
    jPanel27.setMinimumSize(new Dimension(10, 35));
    jPanel27.setOpaque(true);
    jPanel27.setPreferredSize(new Dimension(10, 35));
    jPanel27.setRequestFocusEnabled(true);
    jPanel27.setLayout(borderLayout15);
    jPanel30.setBorder(null);
    jPanel30.setDebugGraphicsOptions(0);
    jPanel30.setMinimumSize(new Dimension(10, 10));
    jPanel30.setPreferredSize(new Dimension(10, 30));
    jPanel30.setRequestFocusEnabled(true);
    jPanel30.setToolTipText("");
    jPanel30.setLayout(borderLayout17);
    btnAddIntlShippingService.setBorder(BorderFactory.createEtchedBorder());
    btnAddIntlShippingService.setPreferredSize(new Dimension(60, 20));
    btnAddIntlShippingService.setText("  Add  ");
    btnRemoveIntlShippingService.setBorder(BorderFactory.createEtchedBorder());
    btnRemoveIntlShippingService.setPreferredSize(new Dimension(60, 20));
    btnRemoveIntlShippingService.setText("  Remove  ");
    jPanel32.setLayout(borderLayout11);
    jLabel24.setToolTipText("");
    jLabel24.setText("    ");
    jLabel25.setText("    ");
    btnAddShippingService.setBorder(BorderFactory.createEtchedBorder());
    btnAddShippingService.setPreferredSize(new Dimension(60, 20));
    btnAddShippingService.setRequestFocusEnabled(true);
    btnAddShippingService.setText("  Add  ");
    btnRemoveShippingService.setBorder(BorderFactory.createEtchedBorder());
    btnRemoveShippingService.setPreferredSize(new Dimension(60, 20));
    btnRemoveShippingService.setRequestFocusEnabled(true);
    btnRemoveShippingService.setText("  Remove  ");
    jPanel29.setLayout(borderLayout12);
    jLabel29.setText("    ");
    jLabel30.setText("    ");
    jPanel28.setPreferredSize(new Dimension(10, 2));
    jPanel31.setPreferredSize(new Dimension(10, 2));
    jPanel1.add(jLabel42, null);
    jPanel1.add(jLabel41, null);
    jPanel1.add(cbxSite, null);
    jPanel1.add(jLabel14, null);
    jPanel0.add(panel1,  BorderLayout.NORTH);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jLabel3, null);
    jPanel1.add(txtTitle, null);
    panel1.add(jPanelPrice,  BorderLayout.CENTER);
    jPanelPrice.add(jLabel4,        new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel31,       new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel32,        new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel5,        new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel33,       new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel20,        new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel35,        new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel34,       new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel36,       new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel38,      new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel37,      new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel8,       new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel39,     new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel9,      new GridBagConstraints(8, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(txtCategory,     new GridBagConstraints(2, 0, 1, 3, 0.0, 0.0
            ,GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, -3, 0, 3), 0, 0));
    jPanelPrice.add(jLabel47,    new GridBagConstraints(11, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel49,    new GridBagConstraints(13, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel50,    new GridBagConstraints(14, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(txtQuantity,    new GridBagConstraints(10, 0, 1, 2, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(cbxListingType,    new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panel1.add(jPanel7, BorderLayout.SOUTH);
    jPanel7.add(jPanel20,  BorderLayout.CENTER);
    jPanel7.add(jPanelPicFiles,  BorderLayout.SOUTH);
    jPanelPicFiles.add(jPanel23, BorderLayout.CENTER);
    jPanel23.add(jPanel6,  BorderLayout.EAST);
    jPanel23.add(jPanel19, BorderLayout.NORTH);
    jPanel23.add(jPanel21, BorderLayout.SOUTH);
    jPanel23.add(jPanel24, BorderLayout.WEST);
    jPanel24.add(jLabel19,              new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel54,             new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel55,            new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel56,           new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel57,           new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel58,          new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel59,        new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel60,       new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel61,      new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel62,     new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel63,    new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel64,   new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel65,  new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel24.add(jLabel66,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel23.add(jPanel35, BorderLayout.CENTER);
    jPanel35.add(jPanel36, BorderLayout.NORTH);
    jPanel36.add(jLabel6, BorderLayout.NORTH);
    jPanel36.add(jLabel10, BorderLayout.WEST);
    jPanel36.add(jLabel11, BorderLayout.EAST);
    jPanel36.add(jLabel12, BorderLayout.SOUTH);
    jPanel36.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(txtaDescription, null);
    jPanel35.add(jPanel37, BorderLayout.SOUTH);
    jPanel37.add(jPanel39, BorderLayout.NORTH);
    jPanel37.add(jPanel40, BorderLayout.WEST);
    jPanel37.add(jPanel41, BorderLayout.EAST);
    jPanel41.add(btnAddImage,    new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel41.add(jLabel16,    new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel41.add(btnRemoveImage,    new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel41.add(jLabel44,   new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel41.add(btnImage, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel37.add(jPanel42, BorderLayout.SOUTH);
    jPanel35.add(jPanel38, BorderLayout.CENTER);
    jPanel38.add(jLabel13, BorderLayout.WEST);
    jPanel38.add(jLabel15, BorderLayout.EAST);
    jPanel38.add(txtItemLocation, BorderLayout.CENTER);
    jPanel0.add(jPanel2, BorderLayout.CENTER);
    jPanel2.add(jPanel11, BorderLayout.NORTH);
    jPanel11.add(jPanel8, BorderLayout.CENTER);
   
    //seller Profile Pane   
    JPanel paymentProfilePanel = new JPanel();
    JPanel returnProfilePanel = new JPanel();
    JPanel shippingProfilePanel = new JPanel();
    
    GridBagLayout mGLayout = new GridBagLayout();
    
    paymentProfilePanel.setLayout(mGLayout);
    returnProfilePanel.setLayout(mGLayout);
    shippingProfilePanel.setLayout(mGLayout);
    
    
    paymentNameLabel.setText("Payment Profile Name:");
    paymentIDLabel.setText("Payment Profile ID:");
    paymentIDTextField.setMinimumSize(new Dimension(130, 21));
    paymentIDTextField.setPreferredSize(new Dimension(130, 21));
    paymentIDTextField.setText("");
    paymentNameTextField.setMinimumSize(new Dimension(130, 21));
    paymentNameTextField.setPreferredSize(new Dimension(130, 21));
    paymentNameTextField.setText("");
    
    
    returnIDLabel.setText("Return Profile ID:");
    returnNameLabel.setText("Return Profile Name:");
    returnIDTextField.setMinimumSize(new Dimension(130, 21));
    returnIDTextField.setPreferredSize(new Dimension(130, 21));
    returnIDTextField.setText("");
    returnNameTextField.setMinimumSize(new Dimension(130, 21));
    returnNameTextField.setPreferredSize(new Dimension(130, 21));
    returnNameTextField.setText("");
    
    
    shippingIDLabel.setText("Shipping Profile ID:");
    shippingNameLabel.setText("Shipping Profile Name:");
    shippingIDTextField.setMinimumSize(new Dimension(130, 21));
    shippingIDTextField.setPreferredSize(new Dimension(130, 21));
    shippingNameTextField.setMinimumSize(new Dimension(130, 21));
    shippingNameTextField.setPreferredSize(new Dimension(130, 21));
    shippingIDTextField.setText("");
    shippingNameTextField.setText("");
    
    
    paymentProfilePanel.add(paymentIDLabel, new GridBagConstraints(0, 0, 1, 1, 2.0, 2.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 8, 0, 0), 0, 0));
    paymentProfilePanel.add(paymentIDTextField, new GridBagConstraints(1, 0, 1, 1, 2.0, 2.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 8), 0, 0));
    paymentProfilePanel.add(paymentNameLabel, new GridBagConstraints(0, 1, 1, 1, 2.0, 2.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 8, 0, 0), 0, 0));
    paymentProfilePanel.add(paymentNameTextField, new GridBagConstraints(1, 1, 1, 1, 2.0, 2.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 8), 0, 0));
    
    returnProfilePanel.add(returnIDLabel, new GridBagConstraints(0, 0, 1, 1, 2.0, 2.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 8, 0, 0), 0, 0));
    returnProfilePanel.add(returnIDTextField, new GridBagConstraints(1, 0, 1, 1, 2.0, 2.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 8), 0, 0));
    returnProfilePanel.add(returnNameLabel, new GridBagConstraints(0, 1, 1, 1, 2.0, 2.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 8, 0, 0), 0, 0));
    returnProfilePanel.add(returnNameTextField, new GridBagConstraints(1, 1, 1, 1, 2.0, 2.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 8), 0, 0));
    
    shippingProfilePanel.add(shippingIDLabel, new GridBagConstraints(0, 0, 1, 1, 2.0, 2.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 8, 0, 0), 0, 0));
    shippingProfilePanel.add(shippingIDTextField, new GridBagConstraints(1, 0, 1, 1, 2.0, 2.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 8), 0, 0));
    shippingProfilePanel.add(shippingNameLabel, new GridBagConstraints(0, 1, 1, 1, 2.0, 2.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 8, 0, 0), 0, 0));
    shippingProfilePanel.add(shippingNameTextField, new GridBagConstraints(1, 1, 1, 1, 2.0, 2.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 8), 0, 0));
    
    jPanel8.add(paymentProfilePanel, new GridBagConstraints(0, 0, 1, 1, 3.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(returnProfilePanel, new GridBagConstraints(1, 0, 1, 1, 3.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(shippingProfilePanel, new GridBagConstraints(2, 0, 1, 1, 3.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    jPanel0.add(jPanel3, BorderLayout.SOUTH);
    jPanel4.add(jLabel1, null);
    jPanel4.add(txtItemId, null);
    jPanel18.add(jPanel4, null);
    jPanel18.add(jPanel5, null);
    jPanel5.add(jLabel2, null);
    jPanel5.add(txtListingFee, null);
    jPanel3.add(jPanel17,  BorderLayout.NORTH);
    jPanel17.add(btnListToEBay, null);
    jPanel17.add(btnVerifyAddItem, null);
    jPanel3.add(jPanel18, BorderLayout.CENTER);
    jPanelPrice.add(jLabel51,    new GridBagConstraints(12, 3, 1, 1, 0.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(txtBINPrice,   new GridBagConstraints(14, 3, 2, 2, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel52,    new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(txtReservePrice,   new GridBagConstraints(10, 3, 1, 2, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(txtStartPrice,   new GridBagConstraints(6, 3, 1, 2, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel67,    new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel71,     new GridBagConstraints(12, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel72,   new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel73,    new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel77,   new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel78,   new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel48,   new GridBagConstraints(12, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(txtLotSize,   new GridBagConstraints(14, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(txtZip,   new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(cbxDuration,   new GridBagConstraints(2, 3, 1, 2, 0.0, 0.0
            ,GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(-1, -1, 1, 1), 0, 0));
    jPanelPrice.add(jLabel7,   new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(conditionLabel,  new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(cbxCondition,  new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel68,    new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(txtPayPalEmail,     new GridBagConstraints(6, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel69,  new GridBagConstraints(8, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(ckbAutoPay,    new GridBagConstraints(10, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -4, 0, 0), 0, 0));
    jPanel37.add(jScrollPane2, BorderLayout.CENTER);
    jScrollPane2.getViewport().add(jListPictureFiles, null);
    jPanelPrice.add(ckbBorder,    new GridBagConstraints(14, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -4, 0, 0), 0, 0));
    jPanelPrice.add(jLabel70,  new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(txtVATPercent,  new GridBagConstraints(6, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel74,    new GridBagConstraints(12, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(ckbBoldTitle,    new GridBagConstraints(14, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -4, 0, 0), 0, 0));
    jPanelPrice.add(jLabel79,   new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(jLabel80,    new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelPrice.add(cbxBestOffer,         new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -3, 0, 9), 0, 0));

    this.setSize(new Dimension(850, 640));
    this.setModal(true);
    this.setResizable(false);
  }

  void btnAddImage_actionPerformed(ActionEvent e) {
    FileDialog dlg = new FileDialog((Frame)this.getOwner(), "Choose Picture File", FileDialog.LOAD);
    dlg.setVisible(true);

    String file = dlg.getFile();
    if( file != null )
    {
      String dirPath = dlg.getDirectory();
      String filePath = dirPath.substring(0, dirPath.length()-1) + "//" + file;
      GuiUtil.JListAddObject(jListPictureFiles, filePath);
      this.jListPictureFiles.setSelectedIndex(this.jListPictureFiles.getModel().getSize() - 1);
    }

    updateImageButtons();
    updateImageDisplay();
  }

  void btnRemoveImage_actionPerformed(ActionEvent e) {
    GuiUtil.JListRemoveSelectedObject(jListPictureFiles);
    this.jListPictureFiles.setSelectedIndex(this.jListPictureFiles.getModel().getSize() - 1);
    updateImageButtons();
    updateImageDisplay();
  }

  void updateImageButtons()
  {
    int size = this.jListPictureFiles.getModel().getSize();
    if (size > 0) {
      this.btnRemoveImage.setEnabled(true);
    }
    else {
      this.btnRemoveImage.setEnabled(false);
    }

    if (size <= 12) {
      this.btnAddImage.setEnabled(true);
    }
    else {
      this.btnAddImage.setEnabled(false);
    }
  }

  void updateImageDisplay()
  {
    Object selected = this.jListPictureFiles.getSelectedValue();
    if (selected != null) {
      String file = selected.toString();
      Image image = Toolkit.getDefaultToolkit().getImage(file);
      Dimension dim = this.btnImage.getPreferredSize();
      int h = (int) dim.getHeight();
      int w = (int) dim.getWidth();

      ImageIcon icon = new ImageIcon(image);

      int h1 = icon.getIconHeight();
      int w1 = icon.getIconWidth();

      float x = (float) h/h1;
      float y = (float) w/w1;
      float r = x < y ? x : y;

      h = (int) (h1 * r);
      w = (int) (w1 * r);

      this.btnImage.setIcon(new ImageIcon(image.getScaledInstance(w, h, Image.SCALE_SMOOTH)));

    }
    else {
      this.btnImage.setIcon(null);
    }
  }

  private ItemType getItemFromForm() throws Exception
  {
    String s;

    ItemType item = new ItemType();

    item.setTitle(this.txtTitle.getText());

    String subTitle = "sub title";
    if (subTitle.length() > 0) {
      item.setSubTitle(subTitle);
    }

    item.setDescription(this.txtaDescription.getText());

    ControlTagItem ct = (ControlTagItem)this.cbxDuration.getSelectedItem();
    if (null != ct.Tag)
    	item.setListingDuration(((ListingDurationCodeType)ct.Tag).value());

    item.setRegionID("0");
    item.setLocation("San Jose, CA");
    item.setCurrency(CurrencyCodeType.USD);
    item.setQuantity(new Integer(txtQuantity.getText()));
    item.setCountry(CountryCodeType.US);

    CategoryType cat = new CategoryType();
    cat.setCategoryID(this.txtCategory.getText());
    item.setPrimaryCategory(cat);

    s = this.txtStartPrice.getText();
    if( s.length() == 0 )
      throw new Exception("Please enter start price.");
    AmountType at = new AmountType();
    at.setValue(Double.parseDouble(s));
    item.setStartPrice(at);

    if( this.txtReservePrice.getText().length() > 0 )
    {
    	at = new AmountType();
    	at.setValue(Double.parseDouble(this.txtReservePrice.getText()));
        item.setReservePrice(at);
    }

    if( this.txtBINPrice.getText().length() > 0 ) {
    	at = new AmountType();
    	at.setValue(Double.parseDouble(this.txtBINPrice.getText()));
        item.setBuyItNowPrice(at);
    }
    
     //Create Seller Profile container
     SellerProfilesType sellerProfile=new SellerProfilesType();
     
     //Set payment ProfileId
     SellerPaymentProfileType sellerPaymentProfile=new SellerPaymentProfileType();
     sellerPaymentProfile.setPaymentProfileID(Long.valueOf(this.paymentIDTextField.getText()));
     sellerPaymentProfile.setPaymentProfileName(this.paymentNameTextField.getText());
     sellerProfile.setSellerPaymentProfile(sellerPaymentProfile);  
     
     //Set Shipping ProfileId
	  SellerShippingProfileType sellerShippingProfile=new SellerShippingProfileType();
     sellerShippingProfile.setShippingProfileID(Long.valueOf(this.shippingIDTextField.getText()));
     sellerShippingProfile.setShippingProfileName(this.shippingNameTextField.getText());
     sellerProfile.setSellerShippingProfile(sellerShippingProfile);
     
     //Set Return Policy ProfileId
	  SellerReturnProfileType sellerReturnProfile=new SellerReturnProfileType();
	  sellerReturnProfile.setReturnProfileID(Long.valueOf(this.returnIDTextField.getText()));
	  sellerReturnProfile.setReturnProfileName(this.returnNameTextField.getText());
	  sellerProfile.setSellerReturnProfile(sellerReturnProfile);
	  
	//Add Seller Profile to Item
     item.setSellerProfiles(sellerProfile);
     
    String payPalEmail = this.txtPayPalEmail.getText().trim();
    if (payPalEmail.length() > 0) {
      item.setPayPalEmailAddress(payPalEmail);
    }

    String vatPercent = this.txtVATPercent.getText().trim();
    if (vatPercent.length() > 0) {
      VATDetailsType vatDetails = new VATDetailsType();
      vatDetails.setVATPercent(new Float(vatPercent));
      item.setVATDetails(vatDetails);
    }

    item.setAutoPay(new Boolean(this.ckbAutoPay.isSelected()));
    boolean borderChecked = this.ckbBorder.isSelected();
    boolean boldTitleChecked = this.ckbBoldTitle.isSelected();
    int cnt = 0;
    if (borderChecked) {
      cnt++;
    }
    if (boldTitleChecked) {
      cnt++;
    }

    if (cnt > 0) {
      ListingEnhancementsCodeType enhancements[] = new ListingEnhancementsCodeType [cnt];
      cnt = 0;
      if (borderChecked) {
        enhancements[cnt++] = ListingEnhancementsCodeType.BORDER;
      }
      if (boldTitleChecked) {
        enhancements[cnt] = ListingEnhancementsCodeType.BOLD_TITLE;
      }
      item.setListingEnhancement(enhancements);
    }

    String lotSize = this.txtLotSize.getText().trim();
    if (lotSize.length() > 0) {
      item.setLotSize(new Integer(lotSize));
    }

    if( this.cbxBestOffer.isSelected() )
    {
      BestOfferDetailsType bo = new BestOfferDetailsType();
      bo.setBestOfferEnabled(new Boolean(true));
      item.setBestOfferDetails(bo);
    }

    return item;
  }

  private String[] getPicturePathList() {
    // Get picture files list.
    String[] pathList = null;

    javax.swing.ListModel lm = this.jListPictureFiles.getModel();
    if (lm.getSize() > 0) {
      pathList = new String[lm.getSize()];
      for (int i = 0; i < lm.getSize(); i++) {
        pathList[i] = (String) lm.getElementAt(i);
      }
    }

    return pathList;
  }

  void btnListToEBay_actionPerformed(ActionEvent e) {
    try
    {
      this.txtItemId.setText("");
      this.txtListingFee.setText("");

      this.apiContext.setSite(this.siteId);
      CurrencyCodeType currency = CurrencyCodeType.USD;
      if (this.siteId == SiteCodeType.UK) {
        currency = CurrencyCodeType.GBP;
      }
      else if (this.siteId == SiteCodeType.GERMANY){
        currency = CurrencyCodeType.EUR;
      }
      else if (this.siteId == SiteCodeType.CANADA) {
        currency = CurrencyCodeType.CAD;
      }

      com.ebay.sdk.call.AddItemCall api = new com.ebay.sdk.call.AddItemCall(this.apiContext);
      // Let the call object to automatically generate UUID for my item.
      api.setAutoSetItemUUID(false);

      // Set detail level to retrieve item description.
      api.addDetailLevel(DetailLevelCodeType.ITEM_RETURN_DESCRIPTION);

      ItemType item = getItemFromForm();
      item.setSite(this.siteId);
      item.setCurrency(currency);

      api.setPictureFiles(this.getPicturePathList());

      item.setListingType((ListingTypeCodeType)((ControlTagItem)this.cbxListingType.getSelectedItem()).Tag);
      
      item.setConditionID((Integer)((ControlTagItem)this.cbxCondition.getSelectedItem()).Tag);

      api.setItem(item);
      FeesType fees = api.addItem();

      // Display results.
      this.txtItemId.setText(item.getItemID());
      FeeType ft = eBayUtil.findFeeByName(fees.getFee(), "ListingFee");
      this.txtListingFee.setText(new Double(ft.getFee().getValue()).toString());
    }
    catch(Exception ex)
    {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void btnVerifyAddItem_actionPerformed(ActionEvent e) {
    try
    {
      this.txtListingFee.setText("");

      this.apiContext.setSite(this.siteId);
      CurrencyCodeType currency = CurrencyCodeType.USD;
      if (this.siteId == SiteCodeType.UK) {
        currency = CurrencyCodeType.GBP;
      }
      else if (this.siteId == SiteCodeType.GERMANY){
        currency = CurrencyCodeType.EUR;
      }
      else if (this.siteId == SiteCodeType.CANADA) {
        currency = CurrencyCodeType.CAD;
      }

      com.ebay.sdk.call.VerifyAddItemCall api = new com.ebay.sdk.call.VerifyAddItemCall(this.apiContext);
      
      ItemType item = this.getItemFromForm();
      item.setSite(this.siteId);
      
      item.setConditionID((Integer)((ControlTagItem)this.cbxCondition.getSelectedItem()).Tag);

      api.setPictureFiles(this.getPicturePathList());
      
      api.setItem(item);
      FeesType fees = api.verifyAddItem();

      // Display results.
      FeeType ft = eBayUtil.findFeeByName(fees.getFee(), "ListingFee");
      this.txtListingFee.setText(new Double(ft.getFee().getValue()).toString());
    }
    catch(Exception ex)
    {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
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
      intlShippingServiceOptions.add(selector);
      sso.setShippingServicePriority(new Integer(this.intlShippingServiceOptions.size()));
      updateIntlShippingServiceSelections();
    }
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

  void btnRemoveIntlShippingService_actionPerformed(ActionEvent e) {
    int size = this.intlShippingServiceOptions.size();
    if (size > 0) {
      this.intlShippingServiceOptions.remove(size - 1);
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

  void cbxSite_actionPerformed(ActionEvent e) {
    int idx = this.cbxSite.getSelectedIndex();
    SiteCodeType siteId = (SiteCodeType)ControlEntryTypes.sites[idx].Tag;
    if (!this.siteId.equals(siteId)) {
      initPaymentServices(siteId);
      initShipToLocations(siteId);
      clearShippingServiceSelections();
      this.siteId = siteId;
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
    //initServiceControls(this.siteId);

    this.jListPictureFiles.addMouseListener(this);

    this.updateFormControls();
  }

  void initStaticControls()
  {
    DefaultComboBoxModel dataModel = new DefaultComboBoxModel(ControlEntryTypes.sites);
    this.cbxSite.setModel(dataModel);
    this.cbxSite.setSelectedIndex(0);

    dataModel = new DefaultComboBoxModel(ControlEntryTypes.shippingTypes);
    this.cbxShippingType.setModel(dataModel);

    dataModel = new DefaultComboBoxModel(ControlEntryTypes.listingTypes);
    this.cbxListingType.setModel(dataModel);
    this.cbxListingType.setSelectedIndex(0);
    
    dataModel = new DefaultComboBoxModel(conditions);
    this.cbxCondition.setModel(dataModel);
    this.cbxCondition.setSelectedIndex(0);

    updateImageButtons();
  }
  
  static ControlTagItem[] conditions = new ControlTagItem[] {
      new ControlTagItem("New", new Integer(1000)),
      new ControlTagItem("Used", new Integer(3000)),
      //new ControlTagItem("Good", new Integer(5000)),
  };

  
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
  
  
  
  void initShipToLocations(SiteCodeType sideId)
  {
    this.jPanelShipToLocations.removeAll();
    ShippingServiceHelper helper = ShippingServiceHelper.getInstance();
    Hashtable map = helper.getShipToLocationMap(this.siteId);
    ControlBuilder builder = ControlBuilder.getInstance();
    this.ckbShipToLocations = builder.buildIDCheckBoxControls(this.jPanelShipToLocations, map, 4);
  }

  void initServiceControls(SiteCodeType siteId)
  {
    initPaymentServices(siteId);
    initShipToLocations(siteId);
    updateShippingServiceSelections();
    updateIntlShippingServiceSelections();
  }

  void updateShippingServiceSelections()
  {
    ServiceControlManager.getInstance().updateShippingServiceSelections(
      this.shippingServiceOptions, this.spShippingServiceOptions,
      this.btnRemoveShippingService, this.btnAddShippingService);
  }

  void updateIntlShippingServiceSelections()
  {
    ServiceControlManager.getInstance().updateIntlShippingServiceSelections(
      this.intlShippingServiceOptions, this.spIntlShippingServiceOptions,
      this.btnRemoveIntlShippingService, this.btnAddIntlShippingService);
  }

  void txtZip_actionPerformed(ActionEvent e) {

  }

  public void mouseClicked(MouseEvent e)
  {
    updateImageDisplay();
  }

  public void mousePressed(MouseEvent e)
  {
  }

  public void mouseReleased(MouseEvent e)
  {
  }

  public void mouseEntered(MouseEvent e)
  {
  }

  public void mouseExited(MouseEvent e)
  {
  }

  void updateFormControls()
  {
    ListingTypeCodeType type = (ListingTypeCodeType)((ControlTagItem)this.cbxListingType.getSelectedItem()).Tag;
    this.cbxBestOffer.setVisible(type.equals(ListingTypeCodeType.STORES_FIXED_PRICE)
                                 || type.equals(ListingTypeCodeType.FIXED_PRICE_ITEM));
    boolean fixed = type.equals(ListingTypeCodeType.STORES_FIXED_PRICE) ||
        type.equals(ListingTypeCodeType.FIXED_PRICE_ITEM);
    this.txtReservePrice.setEnabled(!fixed);
    this.txtBINPrice.setEnabled(!fixed);

    if( fixed )
    {
      this.txtReservePrice.setText("");
      this.txtBINPrice.setText("");
    }
  }

  void cbxListingType_itemStateChanged(ItemEvent e) {
    updateFormControls();
  }
}

class DialogAddItem_btnAddImage_actionAdapter implements java.awt.event.ActionListener {
  DialogAddItem adaptee;

  DialogAddItem_btnAddImage_actionAdapter(DialogAddItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnAddImage_actionPerformed(e);
  }
}

class DialogAddItem_btnRemoveImage_actionAdapter implements java.awt.event.ActionListener {
  DialogAddItem adaptee;

  DialogAddItem_btnRemoveImage_actionAdapter(DialogAddItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnRemoveImage_actionPerformed(e);
  }
}

class DialogAddItem_btnListToEBay_actionAdapter implements java.awt.event.ActionListener {
  DialogAddItem adaptee;

  DialogAddItem_btnListToEBay_actionAdapter(DialogAddItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnListToEBay_actionPerformed(e);
  }
}

class DialogAddItem_btnVerifyAddItem_actionAdapter implements java.awt.event.ActionListener {
  DialogAddItem adaptee;

  DialogAddItem_btnVerifyAddItem_actionAdapter(DialogAddItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnVerifyAddItem_actionPerformed(e);
  }
}

class DialogAddItem_btnAddIntlShippingService_actionAdapter implements java.awt.event.ActionListener {
  DialogAddItem adaptee;

  DialogAddItem_btnAddIntlShippingService_actionAdapter(DialogAddItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnAddIntlShippingService_actionPerformed(e);
  }
}

class DialogAddItem_btnAddShippingService_actionAdapter implements java.awt.event.ActionListener {
  DialogAddItem adaptee;

  DialogAddItem_btnAddShippingService_actionAdapter(DialogAddItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnAddShippingService_actionPerformed(e);
  }
}

class DialogAddItem_btnRemoveShippingService_actionAdapter implements java.awt.event.ActionListener {
  DialogAddItem adaptee;

  DialogAddItem_btnRemoveShippingService_actionAdapter(DialogAddItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnRemoveShippingService_actionPerformed(e);
  }
}

class DialogAddItem_btnRemoveIntlShippingService_actionAdapter implements java.awt.event.ActionListener {
  DialogAddItem adaptee;

  DialogAddItem_btnRemoveIntlShippingService_actionAdapter(DialogAddItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnRemoveIntlShippingService_actionPerformed(e);
  }
}

class DialogAddItem_cbxSite_actionAdapter implements java.awt.event.ActionListener {
  DialogAddItem adaptee;

  DialogAddItem_cbxSite_actionAdapter(DialogAddItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbxSite_actionPerformed(e);
  }
}

class DialogAddItem_txtZip_actionAdapter implements java.awt.event.ActionListener {
  DialogAddItem adaptee;

  DialogAddItem_txtZip_actionAdapter(DialogAddItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.txtZip_actionPerformed(e);
  }
}

class DialogAddItem_cbxListingType_itemAdapter implements java.awt.event.ItemListener {
  DialogAddItem adaptee;

  DialogAddItem_cbxListingType_itemAdapter(DialogAddItem adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.cbxListingType_itemStateChanged(e);
  }
}
