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
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.BestOfferDetailsType;
import com.ebay.soap.eBLBaseComponents.BuyerPaymentMethodCodeType;
import com.ebay.soap.eBLBaseComponents.FeeType;
import com.ebay.soap.eBLBaseComponents.FeesType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDurationCodeType;
import com.ebay.soap.eBLBaseComponents.ListingEnhancementsCodeType;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */

public class DialogRelistItem extends JDialog {
  private ApiContext apiContext = new ApiContext();

  static ControlTagItem[] reviseStatuses = new ControlTagItem[] {
      new ControlTagItem("None", "None"),
      new ControlTagItem("BuyItNowAdded", "BuyItNowAdded"),
      new ControlTagItem("BuyItNowLowered", "BuyItNowLowered"),
      new ControlTagItem("ReserveLowered", "ReserveLowered"),
      new ControlTagItem("ReserveRemoved", "ReserveRemoved")
  };

  BorderLayout borderLayout0 = new BorderLayout();
  JScrollPane spParent = new JScrollPane();
  JPanel jPanel0 = new JPanel();

  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JTextField txtRelistItemID = new JTextField();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel6 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField txtBINPrice = new JTextField();
  JPanel jPanel10 = new JPanel();
  JPanel jPanel11 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JTextField txtTitle = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextArea txtaDescription = new JTextArea();
  JLabel jLabel6 = new JLabel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel14 = new JPanel();
  JPanel jPanel15 = new JPanel();
  JTextField txtItemID = new JTextField();
  JTextField txtListingFee = new JTextField();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel16 = new JPanel();
  JLabel jLabel9 = new JLabel();
  JButton btnCallRelistItem = new JButton();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JTextField txtReservePrice = new JTextField();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JTextField txtQuantity = new JTextField();
  JComboBox cbxDuration = new JComboBox();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel24 = new JLabel();
  JTextField txtLotSize = new JTextField();
  JLabel jLabel26 = new JLabel();
  JComboBox cbxBorder = new JComboBox();
  JTextField txtPayPalEmail = new JTextField();
  JLabel jLabel27 = new JLabel();
  JLabel jLabel28 = new JLabel();
  JLabel jLabel29 = new JLabel();
  JCheckBox ckbPayPal = new JCheckBox();
  JLabel jLabel20 = new JLabel();
  JTextField txtStartprice = new JTextField();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JLabel jLabel22 = new JLabel();
  JTextField txtSubTitle = new JTextField();
  JCheckBox chkRemoveSubTitle = new JCheckBox();
  JCheckBox chkRemove2ndCategory = new JCheckBox();
  JCheckBox chkRemoveAppData = new JCheckBox();
  JPanel jPanel17 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JCheckBox chkRemovePayPalEmail = new JCheckBox();
  JPanel jPanel18 = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel30 = new JLabel();
  JComboBox cbxBestOffer = new JComboBox();


  public DialogRelistItem(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      customInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      Object[] list = new Object[] {
          new ControlTagItem("NoChange", ListingDurationCodeType.CUSTOM_CODE),
          new ControlTagItem("1 Day", ListingDurationCodeType.DAYS_1),
          new ControlTagItem("3 Days", ListingDurationCodeType.DAYS_3),
          new ControlTagItem("5 Days", ListingDurationCodeType.DAYS_5),
          new ControlTagItem("7 Days", ListingDurationCodeType.DAYS_7),
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

  public DialogRelistItem() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {

    jPanel0.setLayout(borderLayout0);
    spParent.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    spParent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

    jPanel6.setBorder(BorderFactory.createEtchedBorder());
    jPanel6.setPreferredSize(new Dimension(414, 250));
    jPanel6.setLayout(gridBagLayout1);
    jPanel16.setPreferredSize(new Dimension(273, 30));
    jLabel12.setText("        ");
    jLabel13.setText("Duration:");
    jLabel14.setText("    ");
    txtReservePrice.setPreferredSize(new Dimension(70, 20));
    txtReservePrice.setText("");
    txtBINPrice.setMinimumSize(new Dimension(6, 21));
    txtBINPrice.setRequestFocusEnabled(true);
    jLabel4.setText("        ");
    jLabel3.setText("    ");
    jLabel10.setText("BuyItNowPrice:");
    jLabel15.setText("    ");
    jLabel17.setText("        ");
    jLabel18.setText("ReservePrice:");
    jLabel11.setText("    ");
    jLabel16.setText("        ");
    jLabel21.setText("Border:");
    txtQuantity.setPreferredSize(new Dimension(70, 21));
    txtQuantity.setText("");
    txtQuantity.setScrollOffset(0);
    jLabel23.setText("    ");
    jLabel24.setText("        ");
    txtLotSize.setPreferredSize(new Dimension(70, 21));
    txtLotSize.setRequestFocusEnabled(true);
    txtLotSize.setText("");
    jLabel26.setText("LotSize:");
    jPanel12.setBorder(BorderFactory.createEtchedBorder());
    jLabel27.setText("PayPalAccepted:  ");
    jLabel28.setText("PayPalEmail:");
    txtPayPalEmail.setPreferredSize(new Dimension(140, 21));
    txtPayPalEmail.setText("");
    jLabel29.setText("    ");
    ckbPayPal.setText("");
    jLabel20.setText("StartPrice");
    txtStartprice.setPreferredSize(new Dimension(70, 21));
    txtStartprice.setText("");
    jPanel11.setLayout(borderLayout5);
    jPanel7.setBorder(null);
    jPanel7.setPreferredSize(new Dimension(10, 35));
    jLabel22.setPreferredSize(new Dimension(60, 15));
    jLabel22.setText("SubTitle:");
    txtSubTitle.setPreferredSize(new Dimension(300, 21));
    jPanel8.setBorder(BorderFactory.createEtchedBorder());
    jPanel8.setPreferredSize(new Dimension(10, 30));
    jPanel8.setLayout(gridLayout1);
    jPanel11.setBorder(null);
    chkRemoveSubTitle.setAlignmentX((float) 0.0);
    chkRemoveSubTitle.setHorizontalAlignment(SwingConstants.LEADING);
    chkRemoveSubTitle.setMargin(new Insets(2, 60, 2, 2));
    chkRemoveSubTitle.setText("Remove sub title");
    chkRemove2ndCategory.setHorizontalAlignment(SwingConstants.LEADING);
    chkRemove2ndCategory.setText("Remove secondary category");
    chkRemoveAppData.setHorizontalAlignment(SwingConstants.LEADING);
    chkRemoveAppData.setMargin(new Insets(2, 60, 2, 2));
    chkRemoveAppData.setText("Remove application data");
    gridLayout1.setColumns(2);
    gridLayout1.setHgap(10);
    gridLayout1.setRows(2);
    gridLayout1.setVgap(5);
    chkRemovePayPalEmail.setHorizontalAlignment(SwingConstants.LEADING);
    chkRemovePayPalEmail.setMargin(new Insets(2, 2, 2, 2));
    chkRemovePayPalEmail.setText("Remove PayPal email address");
    jPanel10.setLayout(borderLayout6);
    jLabel19.setText(" ");
    jLabel30.setText("Best Offer:");
    jPanel8.add(chkRemoveSubTitle, null);
    jPanel8.add(chkRemovePayPalEmail, null);
    jPanel8.add(chkRemoveAppData, null);
    jPanel8.add(chkRemove2ndCategory, null);
    this.getContentPane().add(spParent, BorderLayout.CENTER);
    spParent.getViewport().add(jPanel0, null);

    this.setModal(true);
    this.setTitle("eBay SDK for Java - RelistItem");
    txtRelistItemID.setEnabled(true);
    txtRelistItemID.setPreferredSize(new Dimension(100, 21));
    txtRelistItemID.setText("");
    jLabel1.setText("ItemID: ");
    jPanel1.setLayout(borderLayout1);
    jLabel2.setText("Quantity:");
    jPanel4.setLayout(borderLayout2);
    txtTitle.setMinimumSize(new Dimension(6, 21));
    txtTitle.setOpaque(true);
    txtTitle.setPreferredSize(new Dimension(300, 21));
    txtTitle.setToolTipText("");
    txtTitle.setText("");
    jLabel5.setMinimumSize(new Dimension(25, 15));
    jLabel5.setOpaque(false);
    jLabel5.setPreferredSize(new Dimension(60, 15));
    jLabel5.setToolTipText("");
    jLabel5.setText("Title:");
    txtaDescription.setBorder(BorderFactory.createLoweredBevelBorder());
    txtaDescription.setPreferredSize(new Dimension(300, 60));
    txtaDescription.setToolTipText("");
    txtaDescription.setText("");
    txtaDescription.setTabSize(8);
    jLabel6.setText("Description: ");
    jPanel2.setLayout(borderLayout3);
    jLabel7.setText("ItemID: ");
    jLabel8.setText("ListingFee: ");
    txtBINPrice.setPreferredSize(new Dimension(70, 20));
    txtBINPrice.setText("");
    jPanel11.setPreferredSize(new Dimension(249, 70));
    jPanel11.setRequestFocusEnabled(true);
    txtItemID.setPreferredSize(new Dimension(100, 21));
    txtItemID.setEditable(false);
    txtItemID.setText("");
    txtListingFee.setPreferredSize(new Dimension(40, 21));
    txtListingFee.setEditable(false);
    txtListingFee.setText("");
    jPanel3.setLayout(borderLayout4);
    jLabel9.setText("Fill all fields that you want to change for the new item: ");
    btnCallRelistItem.setText("RelistItem");
    btnCallRelistItem.addActionListener(new DialogRelistItem_btnCallRelistItem_actionAdapter(this));
    jPanel0.add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    jPanel4.add(jPanel11, BorderLayout.NORTH);
    jPanel11.add(jPanel7, BorderLayout.NORTH);
    jPanel7.add(jLabel5, null);
    jPanel7.add(txtTitle, null);
    jPanel11.add(jPanel9, BorderLayout.CENTER);
    jPanel9.add(jLabel22, null);
    jPanel9.add(txtSubTitle, null);
    jPanel4.add(jPanel10, BorderLayout.CENTER);
    jPanel10.add(jPanel18,  BorderLayout.NORTH);
    jPanel18.add(jLabel6, null);
    jPanel18.add(txtaDescription, null);
    jPanel10.add(jPanel8, BorderLayout.CENTER);
    jPanel1.add(jPanel6, BorderLayout.NORTH);
    jPanel6.add(jLabel4,          new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel3,          new GridBagConstraints(0, 7, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel15,          new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel17,         new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel11,        new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel16,       new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel0.add(jPanel2, BorderLayout.SOUTH);
    jPanel2.add(jPanel13,  BorderLayout.NORTH);
    jPanel13.add(btnCallRelistItem, null);
    jPanel2.add(jPanel12, BorderLayout.CENTER);
    jPanel12.add(jPanel15, null);
    jPanel15.add(jLabel7, null);
    jPanel15.add(txtItemID, null);
    jPanel12.add(jPanel14, null);
    jPanel14.add(jLabel8, null);
    jPanel14.add(txtListingFee, null);
    jPanel0.add(jPanel3, BorderLayout.NORTH);
    jPanel3.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(jLabel1, null);
    jPanel5.add(txtRelistItemID, null);
    jPanel3.add(jPanel16,  BorderLayout.SOUTH);
    jPanel16.add(jLabel9, null);
    jPanel6.add(jLabel23,     new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel24,     new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel26,     new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtQuantity,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(cbxDuration,  new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel13,  new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtPayPalEmail,    new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel2,  new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel27,   new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel28,    new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtLotSize,  new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel29,   new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(ckbPayPal,    new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -4, 0, 0), 0, 0));
    jPanel6.add(txtBINPrice,  new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel10,  new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(cbxBorder,  new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel21,  new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtStartprice,  new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel20,  new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel18,  new GridBagConstraints(0, 8, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtReservePrice,  new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel19,  new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel30,  new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(cbxBestOffer,    new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -2, 0, 2), 0, 0));

    jPanel3.setSize(new Dimension(450, 150));
    this.setSize(new Dimension(550, 605));
    this.setResizable(false);
  }

  static boolean hasPayment(BuyerPaymentMethodCodeType[] list, BuyerPaymentMethodCodeType pmt)
  {
    for(int i = 0; i < list.length; i++ )
    {
      if (list[i].equals(pmt) )
          return true;
    }
    return false;
  }

  public static void removePaypalPaymentMethod(ApiContext apiContext, ItemType item, ArrayList modList) throws Exception
  {
    // We need to remove the PayPal payment method
    com.ebay.sdk.call.GetItemCall gtm = new com.ebay.sdk.call.GetItemCall(apiContext);
    ItemType oldItem = gtm.getItem(item.getItemID());

    BuyerPaymentMethodCodeType[] payments = oldItem.getPaymentMethods();
    if( !hasPayment(payments, BuyerPaymentMethodCodeType.PAY_PAL) )
      throw new Exception("The item does not have PayPal as one of its payment method.");
    if( payments.length == 1 )
      throw new Exception("You can not remove PayPal email address because PayPal is the only paymeht method of your item.");

    BuyerPaymentMethodCodeType[] newLists = new BuyerPaymentMethodCodeType[payments.length - 1];
    int n = 0;
    for(int i = 0; i < payments.length; i++ )
    {
      if( !payments[i].equals(BuyerPaymentMethodCodeType.PAY_PAL) )
        newLists[n++] = payments[i];
    }

    item.setPaymentMethods(newLists);

    modList.add("item.PaymentMethods");
  }

  void btnCallRelistItem_actionPerformed(ActionEvent e) {
    try
    {
      this.txtListingFee.setText("");
      this.txtItemID.setText("");

      com.ebay.sdk.call.RelistItemCall api = new com.ebay.sdk.call.RelistItemCall(this.apiContext);
      ItemType item = new ItemType();
      item.setItemID(this.txtRelistItemID.getText());

      ArrayList modList = new ArrayList();
      ArrayList remList = new ArrayList();

      if( this.txtStartprice.getText().length() > 0 )
      {
        item.setStartPrice(GuiUtil.getMoneyField(this.txtStartprice));
        modList.add("item.startPrice");
      }

      if( this.txtQuantity.getText().length() > 0 )
      {
        item.setQuantity(new Integer(this.txtQuantity.getText()));
        modList.add("item.quantity");
      }

      if( this.txtBINPrice.getText().length() > 0 )
      {
        item.setBuyItNowPrice(GuiUtil.getMoneyField(this.txtBINPrice));
        modList.add("item.buyItNowPrice");
      }

      if (this.txtReservePrice.getText().trim().length() > 0) {
        item.setReservePrice(GuiUtil.getMoneyField(this.txtReservePrice));
        modList.add("item.reservePrice");
      }

      ListingDurationCodeType duration = (ListingDurationCodeType)(((ControlTagItem)this.cbxDuration.getSelectedItem()).Tag);
      if( !duration.equals(ListingDurationCodeType.CUSTOM_CODE) )
      {
        item.setListingDuration(duration.value());
        modList.add("item.listingDuration");
      }

      if( this.txtTitle.getText().length() > 0 )
      {
        item.setTitle(this.txtTitle.getText());
        modList.add("item.title");
      }

      if (this.chkRemoveSubTitle.isSelected()) {
        remList.add("item.subTitle");
      }
      else if (this.txtSubTitle.getText().length() > 0) {
        item.setSubTitle(this.txtSubTitle.getText());
        modList.add("item.subTitle");
      }

      if (this.chkRemovePayPalEmail.isSelected()) {
        // We need to remove the PayPal payment method
        removePaypalPaymentMethod(this.apiContext, item, modList);

        remList.add("item.PayPalEmailAddress");
      }
      else if (this.txtPayPalEmail.getText().length() > 0) {
        item.setPayPalEmailAddress(this.txtPayPalEmail.getText());
        modList.add("item.PayPalEmailAddress");
      }

      if( this.chkRemove2ndCategory.isSelected() )
        remList.add("item.SecondaryCategory");

      if( this.chkRemoveAppData.isSelected() )
        remList.add("item.ApplicationData");

      if( this.txtaDescription.getText().length() > 0 )
      {
        item.setDescription(this.txtaDescription.getText());
        modList.add("item.description");
      }

      if (setListingEnhancements(item)) {
        modList.add("item.listingEnhancement");
      }

      if (this.ckbPayPal.isSelected()) {
        item.setPaymentMethods(new BuyerPaymentMethodCodeType[] {BuyerPaymentMethodCodeType.PAY_PAL});
        modList.add("item.paymentMethods");
      }

      String payPalEmail = this.txtPayPalEmail.getText().trim();
      if (payPalEmail.length() > 0) {
        item.setPayPalEmailAddress(payPalEmail);
        modList.add("item.payPalEmailAddress");
      }

      String lotSize = this.txtLotSize.getText().trim();
      if (lotSize.length() > 0) {
        item.setLotSize(new Integer(lotSize));
        modList.add("item.lotSize");
      }

      DialogRelistItem.setBestOfferInItem(this.cbxBestOffer, item, modList);
      api.setItemToBeRelisted(item);
      
      FeesType fees = api.relistItem();

      // Display results.
      this.txtItemID.setText(item.getItemID().toString());
      FeeType ft = eBayUtil.findFeeByName(fees.getFee(), "ListingFee");
      this.txtListingFee.setText(new Double(ft.getFee().getValue()).toString());
    }
    catch(Exception ex)
    {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      ((FrameDemo)this.getParent()).showErrorMessage(msg);
    }
  }

  void customInit()
  {
    initStaticControls();
    initBestOfferCombo(this.cbxBestOffer);
  }

  ItemType getItem(String itemId) {
    ItemType item = null;
    try {
      com.ebay.sdk.call.GetItemCall api = new com.ebay.sdk.call.GetItemCall(apiContext);
      item = api.getItem(itemId);
    }
    catch(Exception ex) {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      ((FrameDemo)this.getParent()).showErrorMessage(msg);
    }

    return item;
  }

  void initStaticControls()
  {
    DefaultComboBoxModel dataModel = new DefaultComboBoxModel(ControlEntryTypes.booleanFlagsRev);
    this.cbxBorder.setModel(dataModel);
  }

  public static void initBestOfferCombo(JComboBox combo)
  {
    // Initialize combo box.
    Object[] list = new Object[] {
        new ControlTagItem("No Change", "-1"),
        new ControlTagItem("Disable", "0"),
        new ControlTagItem("Enable", "1"),
    };
    ComboBoxModel dataModel = new DefaultComboBoxModel(list);
    combo.setModel(dataModel);
    combo.setSelectedIndex(0);
  }

  public static void setBestOfferInItem(JComboBox combo, ItemType item, ArrayList modList)
  {
    ControlTagItem ct = (ControlTagItem)combo.getSelectedItem();
    String boSel = (String)ct.Tag;
    if( !boSel.equals("-1") )
    {
      BestOfferDetailsType bo = new BestOfferDetailsType();
      Boolean enable = new Boolean(boSel.equals("0") ? false : true);
      bo.setBestOfferEnabled(enable);
      item.setBestOfferDetails(bo);

      modList.add("item.bestOfferDetails");
    }
  }

  boolean setListingEnhancements(ItemType item)
  {
    boolean set = false;

    int idx = this.cbxBorder.getSelectedIndex();
    if (idx == 0) {
      return set;
    }
    else {
      set = true;
    }

    ItemType originalItem = getItem(item.getItemID());
    ArrayList list = new ArrayList();
    ListingEnhancementsCodeType [] enhancements = originalItem.getListingEnhancement();
    int size = enhancements != null ? enhancements.length : 0;
    for (int i = 0; i < size; i++) {
      list.add(enhancements[i]);
    }

    Boolean border = (Boolean)((ControlTagItem)ControlEntryTypes.booleanFlagsRev[idx]).Tag;
    if (border == Boolean.TRUE) {
      list.add(ListingEnhancementsCodeType.BORDER);
    }
    else {
      list.remove(ListingEnhancementsCodeType.BORDER);
    }
    size = list.size();
    enhancements = new ListingEnhancementsCodeType[size];
    for (int i = 0; i < size; i++) {
      enhancements[i] = (ListingEnhancementsCodeType) list.get(i);
    }
    item.setListingEnhancement(enhancements);

    return set;
  }
}

class DialogRelistItem_btnCallRelistItem_actionAdapter implements java.awt.event.ActionListener {
  DialogRelistItem adaptee;

  DialogRelistItem_btnCallRelistItem_actionAdapter(DialogRelistItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCallRelistItem_actionPerformed(e);
  }
}

