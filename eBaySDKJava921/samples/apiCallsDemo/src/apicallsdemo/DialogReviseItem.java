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

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.BuyerPaymentMethodCodeType;
import com.ebay.soap.eBLBaseComponents.FeeType;
import com.ebay.soap.eBLBaseComponents.FeesType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDurationCodeType;
import com.ebay.soap.eBLBaseComponents.ListingEnhancementsCodeType;
import com.ebay.soap.eBLBaseComponents.ReviseStatusType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */

public class DialogReviseItem extends JDialog {
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
  JTextField txtReviseItemID = new JTextField();
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
  JButton btnCallReviseItem = new JButton();
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
  JLabel jLabel20 = new JLabel();
  JCheckBox chkBINAdded = new JCheckBox();
  JLabel jLabel22 = new JLabel();
  JCheckBox chkBINLowered = new JCheckBox();
  JCheckBox chkReservePriceLowered = new JCheckBox();
  JCheckBox chkReservePriceRemoved = new JCheckBox();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JTextField txtQuantity = new JTextField();
  JComboBox cbxDuration = new JComboBox();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel24 = new JLabel();
  JTextField txtLotSize = new JTextField();
  JLabel jLabel26 = new JLabel();
  JComboBox cbxBorder = new JComboBox();
  JComboBox cbxBoldTitle = new JComboBox();
  JTextField txtPayPalEmail = new JTextField();
  JLabel jLabel27 = new JLabel();
  JLabel jLabel28 = new JLabel();
  JLabel jLabel29 = new JLabel();
  JCheckBox ckbPayPal = new JCheckBox();
  JCheckBox chkRemovePayPalEmail = new JCheckBox();
  JCheckBox chkRemoveAppData = new JCheckBox();
  JLabel jLabel30 = new JLabel();
  JLabel jLabel31 = new JLabel();
  JLabel jLabel32 = new JLabel();
  JComboBox cbxBestOffer = new JComboBox();


  public DialogReviseItem(Frame frame, String title, boolean modal) {
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

  public DialogReviseItem() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {

    jPanel0.setLayout(borderLayout0);
    spParent.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    spParent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

    jPanel6.setBorder(BorderFactory.createEtchedBorder());
    jPanel6.setPreferredSize(new Dimension(414, 280));
    jPanel6.setLayout(gridBagLayout1);
    jPanel16.setPreferredSize(new Dimension(273, 30));
    jLabel12.setText("        ");
    jLabel13.setText("Duration:");
    jLabel14.setText("    ");
    txtReservePrice.setMinimumSize(new Dimension(70, 21));
    txtReservePrice.setPreferredSize(new Dimension(70, 20));
    txtReservePrice.setText("");
    txtBINPrice.setMinimumSize(new Dimension(70, 21));
    txtBINPrice.setRequestFocusEnabled(true);
    jLabel4.setText("        ");
    jLabel3.setText("    ");
    jLabel10.setText("BuyItNowPrice:");
    jLabel15.setText("    ");
    jLabel17.setText("        ");
    jLabel18.setText("ReservePrice:");
    jLabel20.setText("    ");
    chkBINAdded.setActionCommand("jCheckBox1");
    chkBINAdded.setText("AddBuyItNowPrice");
    chkBINAdded.addActionListener(new DialogReviseItem_chkBINAdded_actionAdapter(this));
    jLabel22.setText("  ");
    chkBINLowered.setText("LowerBuyItNowPrice");
    chkBINLowered.addActionListener(new DialogReviseItem_chkBINLowered_actionAdapter(this));
    chkReservePriceLowered.setText("LowerReservePrice");
    chkReservePriceLowered.addActionListener(new DialogReviseItem_chkReservePriceLowered_actionAdapter(this));
    chkReservePriceRemoved.setText("RemoveReservePrice");
    chkReservePriceRemoved.addActionListener(new DialogReviseItem_chkReservePriceRemoved_actionAdapter(this));
    jLabel11.setText("    ");
    jLabel16.setText("        ");
    jLabel19.setText("BoldTitle:  ");
    jLabel21.setText("Border:");
    txtQuantity.setMinimumSize(new Dimension(70, 21));
    txtQuantity.setPreferredSize(new Dimension(70, 21));
    txtQuantity.setText("");
    txtQuantity.setScrollOffset(0);
    jLabel23.setText("    ");
    jLabel24.setText("        ");
    txtLotSize.setMinimumSize(new Dimension(70, 21));
    txtLotSize.setPreferredSize(new Dimension(70, 21));
    txtLotSize.setRequestFocusEnabled(true);
    txtLotSize.setText("");
    jLabel26.setText("LotSize:");
    jPanel12.setBorder(BorderFactory.createEtchedBorder());
    jLabel27.setText("PayPalAccepted:");
    jLabel28.setText("PayPalEmail:");
    txtPayPalEmail.setMinimumSize(new Dimension(140, 21));
    txtPayPalEmail.setPreferredSize(new Dimension(140, 21));
    txtPayPalEmail.setText("");
    jLabel29.setText("    ");
    ckbPayPal.setText("");
    jPanel10.setPreferredSize(new Dimension(375, 70));
    jPanel13.setPreferredSize(new Dimension(97, 40));
    chkRemovePayPalEmail.setText("Drop PayPal email");
    chkRemoveAppData.setText("Drop App. Data");
    jLabel30.setRequestFocusEnabled(true);
    jLabel30.setText(" ");
    jLabel31.setText("Best Offer:");
    jLabel32.setText(" ");
    this.getContentPane().add(spParent, BorderLayout.CENTER);
    spParent.getViewport().add(jPanel0, null);

    this.setModal(true);
    this.setTitle("eBay SDK for Java - ReviseItem");
    txtReviseItemID.setEnabled(true);
    txtReviseItemID.setPreferredSize(new Dimension(100, 21));
    txtReviseItemID.setText("");
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
    jPanel11.setPreferredSize(new Dimension(249, 31));
    jPanel11.setRequestFocusEnabled(true);
    txtItemID.setPreferredSize(new Dimension(100, 21));
    txtItemID.setEditable(false);
    txtItemID.setText("");
    txtListingFee.setPreferredSize(new Dimension(40, 21));
    txtListingFee.setEditable(false);
    txtListingFee.setText("");
    jPanel3.setLayout(borderLayout4);
    jLabel9.setText("Fill all fields that you want to change for this item: ");
    btnCallReviseItem.setText("ReviseItem");
    btnCallReviseItem.addActionListener(new DialogReviseItem_btnCallReviseItem_actionAdapter(this));
    jPanel0.add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    jPanel4.add(jPanel11, BorderLayout.NORTH);
    jPanel11.add(jLabel5, null);
    jPanel11.add(txtTitle, null);
    jPanel4.add(jPanel10, BorderLayout.CENTER);
    jPanel10.add(jLabel6, null);
    jPanel10.add(txtaDescription, null);
    jPanel1.add(jPanel6, BorderLayout.NORTH);
    jPanel6.add(jLabel4,               new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel3,               new GridBagConstraints(0, 7, 3, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel10,                new GridBagConstraints(0, 8, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel15,               new GridBagConstraints(1, 9, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtBINPrice,                new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel17,              new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel18,               new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtReservePrice,               new GridBagConstraints(6, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel20,              new GridBagConstraints(4, 12, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(chkBINAdded,                 new GridBagConstraints(0, 12, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -5, 0, 0), 0, 0));
    jPanel6.add(jLabel22,              new GridBagConstraints(4, 13, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(chkBINLowered,                 new GridBagConstraints(0, 13, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -5, 0, 0), 0, 0));
    jPanel6.add(chkReservePriceLowered,                new GridBagConstraints(5, 12, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -5, 0, 0), 0, 0));
    jPanel6.add(chkReservePriceRemoved,                new GridBagConstraints(5, 13, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -5, 0, 0), 0, 0));
    jPanel6.add(jLabel11,             new GridBagConstraints(4, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel16,            new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel0.add(jPanel2, BorderLayout.SOUTH);
    jPanel2.add(jPanel13,  BorderLayout.NORTH);
    jPanel13.add(btnCallReviseItem, null);
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
    jPanel5.add(txtReviseItemID, null);
    jPanel3.add(jPanel16,  BorderLayout.SOUTH);
    jPanel16.add(jLabel9, null);
    jPanel6.add(jLabel19,             new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel21,              new GridBagConstraints(0, 6, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel23,          new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel24,          new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel26,          new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(cbxBorder,           new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(cbxBoldTitle,          new GridBagConstraints(6, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtQuantity,       new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(cbxDuration,       new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel13,       new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtPayPalEmail,         new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel2,       new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel27,        new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel28,         new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtLotSize,       new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel29,        new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(ckbPayPal,         new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -4, 0, 0), 0, 0));
    jPanel6.add(chkRemoveAppData,         new GridBagConstraints(5, 14, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -4, 0, 4), 0, 0));
    jPanel6.add(chkRemovePayPalEmail,     new GridBagConstraints(0, 14, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -6, 0, 6), 0, 0));
    jPanel6.add(jLabel30,    new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel31,   new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel32,  new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(cbxBestOffer,    new GridBagConstraints(3, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    jPanel3.setSize(new Dimension(450, 150));
    this.setSize(new Dimension(550, 540));
    this.setResizable(true);
  }

  void btnCallReviseItem_actionPerformed(ActionEvent e) {
    try
    {
      String sItemId = this.txtReviseItemID.getText().trim();
      if( sItemId.length() == 0 )
        throw new Exception("Please enter Item ID first.");

      this.txtListingFee.setText("");
      this.txtItemID.setText("");

      com.ebay.sdk.call.ReviseItemCall api = new com.ebay.sdk.call.ReviseItemCall(this.apiContext);

      ItemType item = new ItemType();
      String itemId = sItemId;

      item.setItemID(itemId);

      ArrayList modList = new ArrayList();
      ArrayList remList = new ArrayList();

      if( this.txtQuantity.getText().length() > 0 )
      {
        item.setQuantity(new Integer(this.txtQuantity.getText()));
        modList.add("item.quantity");
      }

      ReviseStatusType reviseStatus = new ReviseStatusType();
      if( this.txtBINPrice.getText().length() > 0 )
      {
        item.setBuyItNowPrice(GuiUtil.getMoneyField(this.txtBINPrice));
        modList.add("item.buyItNowPrice");
        if (this.chkBINAdded.isSelected()) {
          reviseStatus.setBuyItNowAdded(Boolean.TRUE);
        }
        else if (this.chkBINLowered.isSelected()) {
          reviseStatus.setBuyItNowLowered(Boolean.TRUE);
        }
      }

      if (this.txtReservePrice.getText().trim().length() > 0) {
        item.setReservePrice(GuiUtil.getMoneyField(this.txtReservePrice));
        if (this.chkReservePriceLowered.isSelected()) {
          reviseStatus.setReserveLowered(Boolean.TRUE);
        }
        modList.add("item.ReservePrice");
      }
      else {
        if (this.chkReservePriceRemoved.isSelected()) {
          reviseStatus.setReserveRemoved(Boolean.TRUE);
          remList.add("item.ReservePrice");
        }
      }
      item.setReviseStatus(reviseStatus);

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

      if( this.txtaDescription.getText().length() > 0 )
      {
        item.setDescription(this.txtaDescription.getText());
        modList.add("item.description");
      }

      if (setListingEnhancements(item)) {
        modList.add("item.listingEnhancement");
      }

/*
      int idx = this.cbxBoldTitle.getSelectedIndex();
      if (idx > 0) {
        ProximitySearchDetailsType psd = new ProximitySearchDetailsType();
        psd.setIncludeInProximitySearch((Boolean)((ControlTagItem)ControlEntryTypes.booleanFlagsRev[idx]).Tag);
        item.setProximitySearchDetails(psd);
        modList.add("item.proximitySearchDetails");
      }
*/

      if( this.chkRemovePayPalEmail.isSelected() )
      {
        DialogRelistItem.removePaypalPaymentMethod(this.apiContext, item, modList);
        remList.add("item.PayPalEmailAddress");
      }
      else
      {
        if (this.ckbPayPal.isSelected()) {
          item.setPaymentMethods(new BuyerPaymentMethodCodeType[] {BuyerPaymentMethodCodeType.PAY_PAL});
          modList.add("item.paymentMethods");
        }

        String payPalEmail = this.txtPayPalEmail.getText().trim();
        if (payPalEmail.length() > 0) {
          item.setPayPalEmailAddress(payPalEmail);
          modList.add("item.payPalEmailAddress");
        }
      }

      if( this.chkRemoveAppData.isSelected() )
        remList.add("item.ApplicationData");

      String lotSize = this.txtLotSize.getText().trim();
      if (lotSize.length() > 0) {
        item.setLotSize(new Integer(lotSize));
        modList.add("item.lotSize");
      }

      DialogRelistItem.setBestOfferInItem(this.cbxBestOffer, item, modList);

      
      api.setItemToBeRevised(item);

      FeesType fees = api.reviseItem();

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
    DialogRelistItem.initBestOfferCombo(this.cbxBestOffer);
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
    this.cbxBoldTitle.setModel(dataModel);

    dataModel = new DefaultComboBoxModel(ControlEntryTypes.booleanFlagsRev);
    this.cbxBorder.setModel(dataModel);
  }

  boolean setListingEnhancements(ItemType item)
  {
    boolean set = false;

    int idxBorder = this.cbxBorder.getSelectedIndex();
    int idxBoldTitle = this.cbxBoldTitle.getSelectedIndex();

    if (idxBorder == 0 && idxBoldTitle == 0) {
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

    if (idxBorder > 0) {
      Boolean border = (Boolean) ( (ControlTagItem) ControlEntryTypes.
                                  booleanFlagsRev[idxBorder]).Tag;
      if (border == Boolean.TRUE) {
        if (!list.contains(ListingEnhancementsCodeType.BORDER)) {
          list.add(ListingEnhancementsCodeType.BORDER);
        }
      }
      else {
        list.remove(ListingEnhancementsCodeType.BORDER);
      }
    }
    if (idxBoldTitle > 0) {
      Boolean boldTitle = (Boolean) ( (ControlTagItem) ControlEntryTypes.
                                  booleanFlagsRev[idxBoldTitle]).Tag;
      if (boldTitle == Boolean.TRUE) {
        if (!list.contains(ListingEnhancementsCodeType.BOLD_TITLE)) {
          list.add(ListingEnhancementsCodeType.BOLD_TITLE);
        }
      }
      else {
        list.remove(ListingEnhancementsCodeType.BOLD_TITLE);
      }
    }
    size = list.size();
    enhancements = new ListingEnhancementsCodeType[size];
    for (int i = 0; i < size; i++) {
      enhancements[i] = (ListingEnhancementsCodeType) list.get(i);
    }
    item.setListingEnhancement(enhancements);

    return set;
  }

  void chkBINAdded_actionPerformed(ActionEvent e) {
    if (this.chkBINAdded.isSelected()) {
      this.chkBINLowered.setSelected(false);
    }
  }

  void chkBINLowered_actionPerformed(ActionEvent e) {
    if (this.chkBINLowered.isSelected()) {
      this.chkBINAdded.setSelected(false);
    }
  }

  void chkReservePriceLowered_actionPerformed(ActionEvent e) {
    if (this.chkReservePriceLowered.isSelected()) {
      this.chkReservePriceRemoved.setSelected(false);
    }
  }

  void chkReservePriceRemoved_actionPerformed(ActionEvent e) {
    if (this.chkReservePriceRemoved.isSelected()) {
      this.chkReservePriceLowered.setSelected(false);
    }
  }
}

class DialogReviseItem_btnCallReviseItem_actionAdapter implements java.awt.event.ActionListener {
  DialogReviseItem adaptee;

  DialogReviseItem_btnCallReviseItem_actionAdapter(DialogReviseItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCallReviseItem_actionPerformed(e);
  }
}

class DialogReviseItem_chkBINAdded_actionAdapter implements java.awt.event.ActionListener {
  DialogReviseItem adaptee;

  DialogReviseItem_chkBINAdded_actionAdapter(DialogReviseItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.chkBINAdded_actionPerformed(e);
  }
}

class DialogReviseItem_chkBINLowered_actionAdapter implements java.awt.event.ActionListener {
  DialogReviseItem adaptee;

  DialogReviseItem_chkBINLowered_actionAdapter(DialogReviseItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.chkBINLowered_actionPerformed(e);
  }
}

class DialogReviseItem_chkReservePriceLowered_actionAdapter implements java.awt.event.ActionListener {
  DialogReviseItem adaptee;

  DialogReviseItem_chkReservePriceLowered_actionAdapter(DialogReviseItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.chkReservePriceLowered_actionPerformed(e);
  }
}

class DialogReviseItem_chkReservePriceRemoved_actionAdapter implements java.awt.event.ActionListener {
  DialogReviseItem adaptee;

  DialogReviseItem_chkReservePriceRemoved_actionAdapter(DialogReviseItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.chkReservePriceRemoved_actionPerformed(e);
  }
}
