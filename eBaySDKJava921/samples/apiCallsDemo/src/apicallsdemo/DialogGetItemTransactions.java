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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.TimeFilter;
import com.ebay.sdk.call.GetItemTransactionsCall;
import com.ebay.sdk.helper.Utils;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.InternationalShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.PaginationResultType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.TransactionType;
import com.ebay.soap.eBLBaseComponents.UserType;

public class DialogGetItemTransactions extends JDialog {

  //IsMultiLegShipping (Added for SDK 777 Release)
  final static String[] colNames = new String[] {
      "ID", "Price", "AmountPaid", "QtyPurchased", "Buyer", "No. ShippingServices",
      "No. Intl ShippingServices", "IsMultiLegShipping", "BOE?"};
  final static int totalColumns = colNames.length;

  private ApiContext apiContext = new ApiContext();

  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel jLabel4 = new JLabel();
  JButton btnCallGetItemTransactions = new JButton();
  JTextField txtModTimeTo = new JTextField();
  JPanel jPanel8 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtPageNumber = new JTextField();
  JTextField txtModTimeFrom = new JTextField();
  JPanel jPanelModifiedTime = new JPanel();
  JLabel jLabel3 = new JLabel();
  JTextField txtTransPerPage = new JTextField();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanelTimeFrom = new JPanel();
  JLabel jLabel2 = new JLabel();
  JPanel jPanel6 = new JPanel();
  JPanel jPanelTimeTo = new JPanel();
  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JTextField txtItemID = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtTotalNumberOfPages = new JTextField();
  JPanel jPanel22 = new JPanel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField txtCount = new JTextField();
  JPanel jPanel18 = new JPanel();
  JTextField txtReturnedItemCountActual = new JTextField();
  JTextField txtHasMoreItems = new JTextField();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel14 = new JPanel();
  JPanel jPanel11 = new JPanel();
  JLabel jLabel10 = new JLabel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel9 = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel10 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel15 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable tblTransactions = new JTable();
  JLabel jLabel8 = new JLabel();
  JTextField txtAutoPay = new JTextField();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JTextField txtStartPrice = new JTextField();
  JLabel jLabel21 = new JLabel();
  JTextField txtPrivateListing = new JTextField();
  JLabel jLabel22 = new JLabel();
  JTextField txtLotSize = new JTextField();
  JLabel jLabel23 = new JLabel();
//  JLabel jLabel24 = new JLabel();
//  JTextField txtAppShippingDiscount = new JTextField();

  public DialogGetItemTransactions(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      GuiUtil.setTimeFilterFields(5, this.txtModTimeFrom, this.txtModTimeTo);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetItemTransactions() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jLabel4.setText("ModifiedTimeTo:");
    btnCallGetItemTransactions.setText("GetItemTransactions");
    btnCallGetItemTransactions.addActionListener(new DialogGetItemTransactions_btnCallGetItemTransactions_actionAdapter(this));
    txtModTimeTo.setPreferredSize(new Dimension(120, 21));
    txtModTimeTo.setText("");
    jLabel1.setToolTipText("");
    jLabel1.setText("TransactionsPerPage:");
    txtPageNumber.setPreferredSize(new Dimension(60, 21));
    txtPageNumber.setText("");
    txtModTimeFrom.setPreferredSize(new Dimension(120, 21));
    txtModTimeFrom.setText("");
    jLabel3.setText("ModifiedTimeFrom:");
    txtTransPerPage.setPreferredSize(new Dimension(60, 21));
    txtTransPerPage.setText("");
    jPanel3.setLayout(borderLayout2);
    jLabel2.setText("PageNumber:");
    jPanel1.setLayout(borderLayout3);
    jPanel2.setLayout(borderLayout4);
    jLabel5.setText("ItemID:");
    txtItemID.setMinimumSize(new Dimension(6, 21));
    txtItemID.setPreferredSize(new Dimension(80, 21));
    txtItemID.setToolTipText("");
    txtItemID.setText("");
    txtTotalNumberOfPages.setText("");
    txtTotalNumberOfPages.setEditable(false);
    txtTotalNumberOfPages.setPreferredSize(new Dimension(60, 21));
    jLabel11.setText("Count: ");
    jLabel7.setText("HasMoreItems: ");
    txtCount.setPreferredSize(new Dimension(60, 21));
    txtCount.setEditable(false);
    txtCount.setText("");
    txtReturnedItemCountActual.setPreferredSize(new Dimension(60, 21));
    txtReturnedItemCountActual.setEditable(false);
    txtReturnedItemCountActual.setText("asdf");
    txtReturnedItemCountActual.setText("");
    txtHasMoreItems.setPreferredSize(new Dimension(60, 21));
    txtHasMoreItems.setEditable(false);
    txtHasMoreItems.setText("");
    jPanel14.setLayout(borderLayout5);
    jLabel10.setText("TotalNumberOfPages:");
    jPanel9.setLayout(borderLayout6);
    jScrollPane1.getViewport().setBackground(Color.white);
    jPanel11.setPreferredSize(new Dimension(20, 2));
    txtAutoPay.setBackground(UIManager.getColor("Button.background"));
    txtAutoPay.setMinimumSize(new Dimension(57, 21));
    txtAutoPay.setPreferredSize(new Dimension(60, 21));
    txtAutoPay.setText("");
    jPanel18.setLayout(gridBagLayout1);
    jPanel18.setBorder(BorderFactory.createEtchedBorder());
    jLabel6.setText("    ");
    jLabel14.setText("    ");
    jLabel15.setText("        ");
    jLabel16.setText("    ");
    jLabel17.setText("        ");
    jLabel18.setText("ReturnedItemCountActual:");
    jLabel19.setText("StartPrice:");
    jLabel9.setText("        ");
    jLabel12.setText("    ");
    jLabel20.setText("AutoPay:");
    txtStartPrice.setBackground(UIManager.getColor("Button.background"));
    txtStartPrice.setPreferredSize(new Dimension(60, 21));
    txtStartPrice.setRequestFocusEnabled(true);
    txtStartPrice.setText("");
    jLabel21.setText("Private Listing:");
    txtPrivateListing.setBackground(UIManager.getColor("Button.background"));
    txtPrivateListing.setPreferredSize(new Dimension(60, 21));
    txtPrivateListing.setText("");
    jLabel22.setText("    ");
    jLabel23.setText("LotSize:");
    txtLotSize.setBackground(UIManager.getColor("Button.background"));
    txtLotSize.setPreferredSize(new Dimension(60, 21));
    txtLotSize.setText("");
    jPanel6.setPreferredSize(new Dimension(143, 40));
//    jLabel24.setText("ApplyShippingDiscount:");
//    txtAppShippingDiscount.setBackground(UIManager.getColor("Button.background"));
//    txtAppShippingDiscount.setPreferredSize(new Dimension(60, 21));
//    txtAppShippingDiscount.setText("");
    getContentPane().add(panel1);
    panel1.add(jPanel3,  BorderLayout.NORTH);
    jPanel8.add(jLabel1, null);
    jPanel8.add(txtTransPerPage, null);
    jPanel4.add(jPanel5, null);
    jPanel5.add(jLabel5, null);
    jPanel5.add(txtItemID, null);
    jPanel4.add(jPanel7, null);
    jPanel4.add(jPanel8, null);
    jPanel7.add(jLabel2, null);
    jPanel7.add(txtPageNumber, null);
    jPanel3.add(jPanelModifiedTime, BorderLayout.CENTER);
    jPanel3.add(jPanel4, BorderLayout.NORTH);
    jPanelTimeFrom.add(jLabel3, null);
    jPanelTimeFrom.add(txtModTimeFrom, null);
    jPanelModifiedTime.add(jPanelTimeFrom, null);
    jPanelModifiedTime.add(jPanelTimeTo, null);
    jPanelTimeTo.add(jLabel4, null);
    jPanelTimeTo.add(txtModTimeTo, null);
    jPanel3.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(btnCallGetItemTransactions, null);
    panel1.add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jPanel2, BorderLayout.CENTER);
    jPanel2.add(jPanel9, BorderLayout.CENTER);
    jPanel9.add(jPanel10, BorderLayout.NORTH);
    jPanel9.add(jPanel12, BorderLayout.WEST);
    jPanel9.add(jPanel13, BorderLayout.EAST);
    jPanel9.add(jPanel15, BorderLayout.SOUTH);
    jPanel9.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(tblTransactions, null);
    jPanel1.add(jPanel14, BorderLayout.NORTH);
    jPanel14.add(jPanel18, BorderLayout.NORTH);
    jPanel14.add(jPanel11, BorderLayout.CENTER);
    jPanel11.add(jPanel22, null);
    jPanel18.add(jLabel8,           new GridBagConstraints(1, 1, GridBagConstraints.REMAINDER, GridBagConstraints.REMAINDER, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel11,       new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel6,     new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(txtCount,    new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel7,     new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel14,     new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(txtHasMoreItems,    new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel15,     new GridBagConstraints(8, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel10,    new GridBagConstraints(9, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel16,     new GridBagConstraints(10, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(txtTotalNumberOfPages,    new GridBagConstraints(11, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel17,     new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel19,   new GridBagConstraints(9, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel9,  new GridBagConstraints(12, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel18, new GridBagConstraints(13, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel12,  new GridBagConstraints(14, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(txtReturnedItemCountActual, new GridBagConstraints(15, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel20,   new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(txtAutoPay, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
     jPanel18.add(txtStartPrice,  new GridBagConstraints(11, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel21,  new GridBagConstraints(13, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(txtPrivateListing,  new GridBagConstraints(15, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel22,  new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(txtLotSize,   new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel23,   new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//    jPanel18.add(jLabel24,   new GridBagConstraints(5, 5, 1, 1, 0.0, 0.0
//            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//    jPanel18.add(txtAppShippingDiscount,   new GridBagConstraints(7, 5, 1, 1, 0.0, 0.0
//            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    jPanel18.setPreferredSize(new Dimension(950, 130));
    this.setSize(new Dimension(950, 500));
  }

  static String[] transactionToColumns(TransactionType trans)
  {
    String[] cols = new String[totalColumns];
    int i = 0;
    cols[i++] = trans.getTransactionID();
    cols[i++] = trans.getTransactionPrice().getValue() + "";
    AmountType amt = trans.getAmountPaid();
    cols[i++] = amt == null ? "" : (new Double(amt.getValue())).toString();
    cols[i++] = trans.getQuantityPurchased().toString();
    UserType buyer = trans.getBuyer();
    cols[i++] = buyer == null ? "" : buyer.getUserID().toString();
    ShippingDetailsType shippingDetails = trans.getShippingDetails();
    ShippingServiceOptionsType [] sso = shippingDetails.getShippingServiceOptions();
    int size = sso != null ? sso.length : 0;
    cols[i++] = new Integer(size).toString();
    InternationalShippingServiceOptionsType [] isso = shippingDetails.getInternationalShippingServiceOption();
    size = isso != null ? isso.length : 0;
    cols[i++] = new Integer(size).toString();
    
    //MultiLegShipping (Added for SDK 777 Release)
    cols[i++] = Utils.booleanToYesNo(trans.isIsMultiLegShipping());
    cols[i++] = Utils.booleanToYesNo(trans.isBestOfferSale());

    return cols;
  }

  void btnCallGetItemTransactions_actionPerformed(ActionEvent e) {
    try
    {
      GetItemTransactionsCall api = new GetItemTransactionsCall(this.apiContext);
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
      };
      api.setDetailLevel(detailLevels);

      TimeFilter tf = GuiUtil.getTimeFilterFromFields(
          this.txtModTimeFrom, this.txtModTimeTo);

      if( this.txtPageNumber.getText().length() > 0 &&
          this.txtTransPerPage.getText().length() > 0 )
      {
        PaginationType pgn = new PaginationType();
        pgn.setPageNumber(new Integer(this.txtPageNumber.getText()));
        pgn.setEntriesPerPage(new Integer(this.txtTransPerPage.getText()));

        api.setPagination(pgn);
      }

      // Call eBay.
      String itemID = this.txtItemID.getText();
      final TransactionType[] transList = api.getItemTransactions(itemID, tf);

      PaginationResultType pnresult = api.getPaginationResult();

      // Display results.
      this.txtCount.setText(pnresult.getTotalNumberOfEntries().toString());

      this.txtHasMoreItems.setText(api.getHasMoreTransactions() ? "yes" : "no");
      this.txtTotalNumberOfPages.setText(
        pnresult.getTotalNumberOfPages() == null ? "" : pnresult.getTotalNumberOfPages().toString());

      String actualCountTxt = new Integer(api.getReturnedTransactionCountActual()).toString();
      this.txtReturnedItemCountActual.setText(actualCountTxt);

      ItemType item = api.getItem();
      Boolean autoPay = item.isAutoPay();
      if (autoPay != null) {
        this.txtAutoPay.setText(autoPay.toString());
      }
      else {
        this.txtAutoPay.setText("false");
      }
      Boolean privateListing = item.isPrivateListing();
      if (privateListing != null) {
        this.txtPrivateListing.setText(privateListing.toString());
      }
      else {
        this.txtPrivateListing.setText("false");
      }
      AmountType startPrice = item.getStartPrice();
      if (startPrice != null) {
        this.txtStartPrice.setText(new Double(startPrice.getValue()).toString());
      }

      Integer lotSize = item.getLotSize();
      if (lotSize != null) {
        this.txtLotSize.setText(lotSize.toString());
      }
//      Boolean appShippingDiscount = item.isApplyShippingDiscount();
//      if (appShippingDiscount != null) {
//        this.txtAppShippingDiscount.setText(appShippingDiscount.toString());
//      }

      String token = item.getSeller().getEIASToken();

      // Display items in table.
      TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return totalColumns; }
        public int getRowCount() { return transList == null ? 0 : transList.length;}
        public String getColumnName(int columnIndex){
          return colNames[columnIndex];
        }
        public Object getValueAt(int row, int col)
        {
          TransactionType trans = transList[row];
          return transactionToColumns(trans)[col];
        }
      };

      this.tblTransactions.setModel(dataModel);
    }
    catch(Exception ex)
    {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGetItemTransactions_btnCallGetItemTransactions_actionAdapter implements java.awt.event.ActionListener {
  DialogGetItemTransactions adaptee;

  DialogGetItemTransactions_btnCallGetItemTransactions_actionAdapter(DialogGetItemTransactions adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCallGetItemTransactions_actionPerformed(e);
  }
}
