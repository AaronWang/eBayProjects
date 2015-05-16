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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.TimeFilter;
import com.ebay.sdk.call.GetSellerTransactionsCall;
import com.ebay.sdk.helper.Utils;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.InternationalShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.PaginationResultType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.TransactionType;
import com.ebay.soap.eBLBaseComponents.UserType;

public class DialogGetSellerTransactions extends JDialog {
  private ApiContext apiContext = new ApiContext();

  final static String[] colNames = new String[] {
      "TransactionID", "ItemID", "Price", "AmountPaid", "QtyPurchased", "Buyer",
      "No. ShippingServices", "No. Intl ShippingServices", "InsuranceWanted", "BOE?", "IsMultiLegShipping"};
  final static int totalColumns = colNames.length;

  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanelModifiedTime = new JPanel();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  JTextField txtTransPerPage = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtPageNumber = new JTextField();
  JLabel jLabel2 = new JLabel();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JTextField txtModTimeFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtModTimeTo = new JTextField();
  JLabel jLabel4 = new JLabel();
  JButton btnCallGetSellerTransactions = new JButton();
  JPanel jPanel5 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JTextField txtTotalNumberOfPages = new JTextField();
  JLabel jLabel12 = new JLabel();
  JPanel jPanel22 = new JPanel();
  JLabel jLabel11 = new JLabel();
  JPanel jPanel19 = new JPanel();
  JLabel jLabel7 = new JLabel();
  JTextField txtCount = new JTextField();
  JPanel jPanel18 = new JPanel();
  JTextField txtReturnedItemCountActual = new JTextField();
  JTextField txtHasMoreItems = new JTextField();
  JPanel jPanel21 = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel14 = new JPanel();
  JPanel jPanel20 = new JPanel();
  JPanel jPanel11 = new JPanel();
  JLabel jLabel10 = new JLabel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel15 = new JPanel();
  JPanel jPanel16 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable tblTransactions = new JTable();

  public DialogGetSellerTransactions(Frame frame, String title, boolean modal) {
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

  public DialogGetSellerTransactions() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel3.setLayout(borderLayout2);
    jLabel1.setToolTipText("");
    jLabel1.setText("TransactionsPerPage:");
    jLabel2.setText("PageNumber:");
    txtTransPerPage.setPreferredSize(new Dimension(60, 21));
    txtTransPerPage.setText("");
    txtPageNumber.setPreferredSize(new Dimension(60, 21));
    txtPageNumber.setText("");
    txtModTimeFrom.setPreferredSize(new Dimension(120, 21));
    txtModTimeFrom.setText("");
    jLabel3.setText("ModifiedTimeFrom:");
    jLabel4.setText("ModifiedTimeTo:");
    txtModTimeTo.setPreferredSize(new Dimension(120, 21));
    txtModTimeTo.setText("");
    btnCallGetSellerTransactions.setText("GetSellerTransactions");
    btnCallGetSellerTransactions.addActionListener(new DialogGetSellerTransactions_btnCallGetSellerTransactions_actionAdapter(this));
    jPanel1.setLayout(borderLayout3);
    jPanel5.setLayout(borderLayout4);
    txtTotalNumberOfPages.setText("");
    txtTotalNumberOfPages.setEditable(false);
    txtTotalNumberOfPages.setPreferredSize(new Dimension(60, 21));
    jLabel12.setText("ReturnedItemCountActual: ");
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
    jPanel18.setLayout(gridBagLayout2);
    jPanel18.setBorder(BorderFactory.createEtchedBorder());
    jPanel18.setPreferredSize(new Dimension(940, 50));
    jLabel5.setText("    ");
    jLabel6.setText("        ");
    jLabel8.setText("    ");
    jLabel9.setText("        ");
    jLabel13.setText("    ");
    jLabel14.setText("        ");
    jLabel15.setText("    ");
    jPanel11.setPreferredSize(new Dimension(20, 2));
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setDebugGraphicsOptions(0);
    getContentPane().add(panel1, BorderLayout.CENTER);
    panel1.add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jPanel5, BorderLayout.CENTER);

    jPanel5.add(jPanel12, BorderLayout.NORTH);
    jPanel5.add(jPanel13, BorderLayout.EAST);
    jPanel5.add(jPanel15, BorderLayout.SOUTH);
    jPanel5.add(jPanel16, BorderLayout.WEST);
    jPanel5.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(tblTransactions, null);
    jPanel1.add(jPanel14, BorderLayout.NORTH);
    jPanel14.add(jPanel11, BorderLayout.CENTER);
    jPanel11.add(jPanel22, null);
    jPanel14.add(jPanel18, BorderLayout.NORTH);
    jPanel18.add(jLabel7, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel5, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(txtHasMoreItems, new GridBagConstraints(2, 0, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel6, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel11, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel8, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(txtCount, new GridBagConstraints(6, 0, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel9, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel10, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel13, new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(txtTotalNumberOfPages, new GridBagConstraints(10, 0, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel14, new GridBagConstraints(11, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel12,  new GridBagConstraints(12, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(jLabel15, new GridBagConstraints(13, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel18.add(txtReturnedItemCountActual,  new GridBagConstraints(14, 0, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panel1.add(jPanel2, BorderLayout.SOUTH);
    panel1.add(jPanel3, BorderLayout.NORTH);
    jPanel3.add(jPanel4,  BorderLayout.NORTH);
    jPanel4.add(jPanel8, null);
    jPanel8.add(jLabel1, null);
    jPanel8.add(txtTransPerPage, null);
    jPanel4.add(jPanel7, null);
    jPanel7.add(jLabel2, null);
    jPanel7.add(txtPageNumber, null);
    jPanel3.add(jPanelModifiedTime, BorderLayout.CENTER);
    jPanelModifiedTime.add(jPanel10, null);
    jPanel10.add(jLabel3, null);
    jPanel10.add(txtModTimeFrom, null);
    jPanelModifiedTime.add(jPanel9, null);
    jPanel9.add(jLabel4, null);
    jPanel9.add(txtModTimeTo, null);
    jPanel3.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(btnCallGetSellerTransactions, null);

    this.setSize(new Dimension(950, 500));
  }

  static String[] transactionToColumns(TransactionType trans)
  {
    String[] cols = new String[DialogGetSellerTransactions.totalColumns];
    int i = 0;
    cols[i++] = trans.getTransactionID();
    String itemID = trans.getItem().getItemID();
    cols[i++] = itemID == null ? "" : itemID;
    cols[i++] = "" + trans.getTransactionPrice().getValue();
    AmountType amt = trans.getAmountPaid();
    cols[i++] = amt == null ? "" : (new Double(amt.getValue())).toString();
    cols[i++] = trans.getQuantityPurchased().toString();
    UserType buyer = trans.getBuyer();
    cols[i++] = buyer == null ? "" : buyer.getUserID();
    ShippingDetailsType shippingDetails = trans.getShippingDetails();
    ShippingServiceOptionsType [] sso = shippingDetails.getShippingServiceOptions();
    int size = sso != null ? sso.length : 0;
    cols[i++] = new Integer(size).toString();
    InternationalShippingServiceOptionsType [] isso = shippingDetails.getInternationalShippingServiceOption();
    size = isso != null ? isso.length : 0;
    cols[i++] = new Integer(size).toString();
    Boolean insuranceWanted = shippingDetails.isInsuranceWanted();
    if (insuranceWanted != null) {
      cols[i] = insuranceWanted.toString();
    }

    cols[i++] = Utils.booleanToYesNo(trans.isBestOfferSale());
    
    //MultiLegShipping (Added for SDK 777 Release)
    cols[i++] = Utils.booleanToYesNo(trans.isIsMultiLegShipping());
    return cols;
  }

  void btnCallGetSellerTransactions_actionPerformed(ActionEvent e) {
    try
    {
      GetSellerTransactionsCall api = new GetSellerTransactionsCall(this.apiContext);
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
      final TransactionType[] transList = api.getSellerTransactions(tf);

      PaginationResultType pnresult = api.getPaginationResult();

      // Display results.
      this.txtCount.setText(pnresult.getTotalNumberOfEntries().toString());

      this.txtHasMoreItems.setText(api.getHasMoreTransactions() ? "yes" : "no");
      this.txtTotalNumberOfPages.setText(
        pnresult.getTotalNumberOfPages() == null ? "" : pnresult.getTotalNumberOfPages().toString());

      String actualCountTxt = new Integer(api.getReturnedTransactionCountActual()).toString();
      this.txtReturnedItemCountActual.setText(actualCountTxt);

      // Display items in table.
      TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return DialogGetSellerTransactions.totalColumns; }
        public int getRowCount() { return transList == null ? 0 : transList.length;}
        public String getColumnName(int columnIndex){
          return colNames[columnIndex];
        }
        public Object getValueAt(int row, int col)
        {
          TransactionType trans = transList[row];
          return DialogGetSellerTransactions.transactionToColumns(trans)[col];
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

class DialogGetSellerTransactions_btnCallGetSellerTransactions_actionAdapter implements java.awt.event.ActionListener {
  DialogGetSellerTransactions adaptee;

  DialogGetSellerTransactions_btnCallGetSellerTransactions_actionAdapter(DialogGetSellerTransactions adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCallGetSellerTransactions_actionPerformed(e);
  }
}
