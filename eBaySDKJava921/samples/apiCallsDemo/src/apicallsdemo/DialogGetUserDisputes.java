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

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetUserDisputesCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.DisputeFilterTypeCodeType;
import com.ebay.soap.eBLBaseComponents.DisputeResolutionType;
import com.ebay.soap.eBLBaseComponents.DisputeSortTypeCodeType;
import com.ebay.soap.eBLBaseComponents.DisputeType;
import com.ebay.soap.eBLBaseComponents.GetUserDisputesResponseType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.SortOrderCodeType;
import com.ebay.soap.eBLBaseComponents.TradingRoleCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Changyi
 * @version 1.0
 */
public class DialogGetUserDisputes extends JDialog {
  private ApiContext apiContext = new ApiContext();

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel8 = new JLabel();

  static ControlTagItem[] filters = new ControlTagItem[] {
      new ControlTagItem(DisputeFilterTypeCodeType.ALL_INVOLVED_DISPUTES.value(), DisputeFilterTypeCodeType.ALL_INVOLVED_DISPUTES),
      new ControlTagItem(DisputeFilterTypeCodeType.DISPUTES_AWAITING_MY_RESPONSE.value(), DisputeFilterTypeCodeType.DISPUTES_AWAITING_MY_RESPONSE),
      new ControlTagItem(DisputeFilterTypeCodeType.DISPUTES_AWAITING_OTHER_PARTY_RESPONSE.value(), DisputeFilterTypeCodeType.DISPUTES_AWAITING_OTHER_PARTY_RESPONSE),
      new ControlTagItem(DisputeFilterTypeCodeType.ALL_INVOLVED_CLOSED_DISPUTES.value(), DisputeFilterTypeCodeType.ALL_INVOLVED_CLOSED_DISPUTES)
  };

  static ControlTagItem[] sortTypes = new ControlTagItem[] {
      new ControlTagItem(DisputeSortTypeCodeType.NONE.value(), DisputeSortTypeCodeType.NONE),
      new ControlTagItem(DisputeSortTypeCodeType.DISPUTE_CREATED_TIME_ASCENDING.value(), DisputeSortTypeCodeType.DISPUTE_CREATED_TIME_ASCENDING),
      new ControlTagItem(DisputeSortTypeCodeType.DISPUTE_CREATED_TIME_DESCENDING.value(), DisputeSortTypeCodeType.DISPUTE_CREATED_TIME_DESCENDING),
      new ControlTagItem(DisputeSortTypeCodeType.DISPUTE_STATUS_ASCENDING.value(), DisputeSortTypeCodeType.DISPUTE_STATUS_ASCENDING),
      new ControlTagItem(DisputeSortTypeCodeType.DISPUTE_STATUS_DESCENDING.value(), DisputeSortTypeCodeType.DISPUTE_STATUS_DESCENDING),
      new ControlTagItem(DisputeSortTypeCodeType.DISPUTE_CREDIT_ELIGIBILITY_ASCENDING.value(), DisputeSortTypeCodeType.DISPUTE_CREDIT_ELIGIBILITY_ASCENDING),
      new ControlTagItem(DisputeSortTypeCodeType.DISPUTE_CREDIT_ELIGIBILITY_DESCENDING.value(), DisputeSortTypeCodeType.DISPUTE_STATUS_DESCENDING)
  };

  static ControlTagItem[] sortOrder = new ControlTagItem[] {
      new ControlTagItem(SortOrderCodeType.ASCENDING.value(), SortOrderCodeType.ASCENDING),
      new ControlTagItem(SortOrderCodeType.DESCENDING.value(), SortOrderCodeType.DESCENDING)
  };

  JLabel jLabel16 = new JLabel();
  BorderLayout borderLayout3 = new BorderLayout();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel24 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel jLabel26 = new JLabel();
  BorderLayout borderLayout4 = new BorderLayout();
  JLabel jLabel27 = new JLabel();
  JLabel jLabel28 = new JLabel();
  JLabel jLabel29 = new JLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JButton btnGetUserDisputes = new JButton();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel30 = new JLabel();
  JLabel jLabel31 = new JLabel();
  JComboBox cbxFilter = new JComboBox();
  JLabel jLabel32 = new JLabel();
  JLabel jLabel33 = new JLabel();
  JLabel jLabel34 = new JLabel();
  JTextField txtPageNumber = new JTextField();
  JLabel jLabel35 = new JLabel();
  JLabel jLabel36 = new JLabel();
  JComboBox cbxSortType = new JComboBox();
  JLabel jLabel37 = new JLabel();
  JComboBox cbxSortOrder = new JComboBox();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JTextField txtStartDisputeNumber = new JTextField();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JTextField txtEndDisputeNumber = new JTextField();
  JLabel jLabel25 = new JLabel();
  JLabel jLabel38 = new JLabel();
  JLabel jLabel39 = new JLabel();
  JTextField txtTotalPage = new JTextField();

  public DialogGetUserDisputes(Frame frame, String title, boolean modal) {
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

  public DialogGetUserDisputes() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setModal(true);
    this.setTitle("eBay SDK for Java - GetUserDisputes");

    jPanel1.setLayout(borderLayout2);
    jPanel2.setLayout(borderLayout5);
    jLabel6.setRequestFocusEnabled(true);
    jLabel6.setText("          ");
    jLabel7.setText("");
    jLabel2.setText("");
    jLabel4.setText("");

    jLabel11.setText("  ");
    jLabel12.setText("  ");
    jLabel14.setText("");
    jLabel13.setText("  ");

    jLabel20.setRequestFocusEnabled(true);
    jLabel20.setText("          ");
    jLabel21.setText("   ");
    jLabel1.setText("      ");
    jLabel3.setText("       ");
    jLabel5.setText("           ");
    jLabel23.setText("    ");
    jLabel8.setRequestFocusEnabled(true);
    jLabel8.setText("  ");
    jPanel3.setMinimumSize(new Dimension(600, 250));
    jPanel3.setLayout(borderLayout3);
    jLabel16.setMaximumSize(new Dimension(113, 25));
    jLabel16.setMinimumSize(new Dimension(113, 25));
    jLabel16.setPreferredSize(new Dimension(113, 25));
    jLabel16.setText("    Dispute from buyers:");
    jLabel19.setText("  ");
    jLabel22.setText("  ");
    jLabel24.setText("    ");
    jLabel26.setMaximumSize(new Dimension(105, 25));
    jLabel26.setMinimumSize(new Dimension(105, 25));
    jLabel26.setPreferredSize(new Dimension(105, 25));
    jLabel26.setText("  Dispute from sellers:");
    jPanel4.setLayout(borderLayout4);
    jLabel27.setText("  ");
    jLabel28.setText("    ");
    jLabel29.setText("  ");
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane2.getViewport().setBackground(Color.white);
    btnGetUserDisputes.setText("GetUserDisputes");
    btnGetUserDisputes.addActionListener(new DialogGetUserDisputes_btnGetUserDisputes_actionAdapter(this));
    jPanel5.setLayout(gridBagLayout1);
    jLabel30.setText("Filter:");
    jLabel31.setText("        ");
    jLabel32.setText("        ");
    jLabel33.setText("PageNumber:");
    jLabel34.setText("        ");
    txtPageNumber.setMinimumSize(new Dimension(100, 21));
    txtPageNumber.setPreferredSize(new Dimension(100, 21));
    jLabel35.setText("        ");
    jLabel36.setText("SortType:");
    jLabel37.setText("SortOrder:");
    cbxSortType.setMinimumSize(new Dimension(100, 21));
    cbxSortType.setPreferredSize(new Dimension(100, 21));
    cbxSortType.setActionCommand("comboBoxChanged");
    jPanel6.setBorder(BorderFactory.createEtchedBorder());
    jPanel6.setLayout(gridBagLayout2);
    jLabel9.setText("StartDisputeNumber:");
    jLabel10.setText("  ");
    jLabel15.setText("        ");
    jLabel17.setText("EndDisputeNumber:");
    jLabel18.setText("  ");
    jLabel25.setText("        ");
    jLabel38.setText("TotalPage:");
    jLabel39.setText("  ");
    txtEndDisputeNumber.setBackground(UIManager.getColor("Button.background"));
    txtEndDisputeNumber.setMinimumSize(new Dimension(100, 21));
    txtEndDisputeNumber.setPreferredSize(new Dimension(100, 21));
    txtEndDisputeNumber.setText("");
    txtStartDisputeNumber.setBackground(UIManager.getColor("Button.background"));
    txtStartDisputeNumber.setMaximumSize(new Dimension(2147483647, 2147483647));
    txtStartDisputeNumber.setMinimumSize(new Dimension(100, 21));
    txtStartDisputeNumber.setPreferredSize(new Dimension(100, 21));
    txtStartDisputeNumber.setText("");
    txtTotalPage.setBackground(UIManager.getColor("Button.background"));
    txtTotalPage.setMinimumSize(new Dimension(60, 21));
    txtTotalPage.setPreferredSize(new Dimension(60, 21));
    txtTotalPage.setText("");
    txtTotalPage.setColumns(0);
    cbxSortOrder.setMinimumSize(new Dimension(100, 21));
    cbxSortOrder.setPreferredSize(new Dimension(100, 21));
    cbxFilter.setMinimumSize(new Dimension(100, 21));
    cbxFilter.setPreferredSize(new Dimension(100, 21));
    jPanel2.add(jLabel6, BorderLayout.EAST);
    jPanel2.add(jLabel11, BorderLayout.EAST);
    jPanel2.add(jLabel12, BorderLayout.EAST);
    jPanel2.add(jLabel13, BorderLayout.EAST);
    jPanel2.add(jLabel14, BorderLayout.WEST);

    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel1.add(jPanel4, BorderLayout.SOUTH);
    jPanel4.add(jLabel26, BorderLayout.NORTH);
    jPanel4.add(jLabel27, BorderLayout.WEST);
    jPanel4.add(jLabel28, BorderLayout.SOUTH);
    jPanel4.add(jLabel29, BorderLayout.EAST);
    jPanel4.add(jScrollPane2, BorderLayout.CENTER);
    jPanel4.setBorder(BorderFactory.createEtchedBorder());

    jPanel1.add(jPanel3, BorderLayout.CENTER);
    jPanel3.add(jLabel19, BorderLayout.WEST);
    jPanel3.add(jLabel22, BorderLayout.EAST);
    jPanel3.add(jLabel24, BorderLayout.SOUTH);
    jPanel3.add(jScrollPane1, BorderLayout.CENTER);
    jPanel3.add(jLabel16, BorderLayout.NORTH);
    jPanel3.setBorder(BorderFactory.createEtchedBorder());

    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel2.add(jLabel1, BorderLayout.EAST);
    jPanel2.add(jLabel3, BorderLayout.EAST);
    jPanel2.add(jLabel5, BorderLayout.EAST);
    jPanel2.add(jLabel8, BorderLayout.EAST);
    jPanel2.add(jPanel5, BorderLayout.NORTH);
    jPanel5.add(jLabel30,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(jLabel31, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(cbxFilter,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(jLabel32, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(jLabel33,  new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(jLabel34, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(txtPageNumber,  new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(jLabel35, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(jLabel36,  new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(cbxSortType,  new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(jLabel37,  new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(cbxSortOrder,  new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jPanel7, BorderLayout.CENTER);
    jPanel7.add(btnGetUserDisputes, null);
    jPanel2.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(jLabel9,  new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel10,  new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtStartDisputeNumber,  new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel15,  new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel17,  new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel18,  new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtEndDisputeNumber,  new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel25,  new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel38,  new GridBagConstraints(8, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel39,  new GridBagConstraints(9, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtTotalPage,  new GridBagConstraints(10, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    ComboBoxModel dataModel = new DefaultComboBoxModel(DialogGetUserDisputes.filters);
    this.cbxFilter.setModel(dataModel);
    this.cbxFilter.setSelectedIndex(0);

    dataModel = new DefaultComboBoxModel(DialogGetUserDisputes.sortTypes);
    this.cbxSortType.setModel(dataModel);
    this.cbxSortType.setSelectedIndex(0);

    dataModel = new DefaultComboBoxModel(DialogGetUserDisputes.sortOrder);
    this.cbxSortOrder.setModel(dataModel);
    this.cbxSortOrder.setSelectedIndex(0);

    jPanel2.setPreferredSize(new Dimension(600, 200));
    jPanel3.setPreferredSize(new Dimension(600, 200));
    jPanel4.setPreferredSize(new Dimension(600, 200));
    jPanel1.setPreferredSize(new Dimension(600, 600));
    jPanel5.setPreferredSize(new Dimension(600, 100));
    jPanel6.setPreferredSize(new Dimension(600, 50));
    jPanel7.setPreferredSize(new Dimension(600, 50));

    this.setSize(new Dimension(600, 600));
  }

  static int getSizeByRow(DisputeType[] disputes, TradingRoleCodeType role)
  {
    int count = 0;
    if( disputes != null )
    {
      for (int i = 0; i < disputes.length; i++) {
        DisputeType dispute = disputes[i];

        if (dispute.getOtherPartyRole().equals(role))
          count++;
      }
    }

    return count;
  }

  static Object[][] FillDisputeTable(ArrayList disputes, TradingRoleCodeType role, int numOfColumns)
  {
    int size = disputes == null ? 0 : disputes.size(); //getSizeByRow(disputes, role);

    Object[][] dataTable = new Object[size][numOfColumns];
    for (int i = 0; i < size; i++)
    {
      DisputeType dispute = (DisputeType)disputes.get(i);

      if( !dispute.getOtherPartyRole().equals(role) )
        continue;

      int k = 0;
      dataTable[i][k++] = dispute.getDisputeID();
      dataTable[i][k++] = (dispute.getItem() == null || dispute.getItem().getItemID() == null) ? "" :
          dispute.getItem().getItemID();
      dataTable[i][k++] = dispute.getTransactionID() == null ? "" : dispute.getTransactionID();
      dataTable[i][k++] = eBayUtil.toAPITimeString(dispute.
          getDisputeCreatedTime().getTime());
      dataTable[i][k++] = dispute.getDisputeCreditEligibility() == null ? "" :
          dispute.getDisputeCreditEligibility().value();

      /*
      String user = "";
      if( buyerOnly )
      {
        UserIDType userId = dispute.getBuyerUserID();
        if (userId != null) {
          user = userId.getValue();
        }
      }
      else
        user = dispute.getOtherPartyName();
      dataTable[i][k++] = user;
     */
      dataTable[i][k++] = dispute.getOtherPartyName() == null ? "" : dispute.getOtherPartyName();

      dataTable[i][k++] = dispute.getDisputeReason() == null ? "" : dispute.getDisputeReason().toString();
      //
      java.util.Calendar c = dispute.getDisputeModifiedTime();
      dataTable[i][k++] = ( c ==  null ) ? "" : eBayUtil.toAPITimeString(c.getTime());

      // Display the first resolutions.
      DisputeResolutionType res = null;
      DisputeResolutionType[] resolutions = dispute.getDisputeResolution();
      if( resolutions != null && resolutions.length > 0 )
        res = resolutions[0];

      dataTable[i][k++] = (res == null || res.getDisputeResolutionReason() == null) ? "" :
          res.getDisputeResolutionReason().toString();
      dataTable[i][k++] = (res == null || res.getDisputeResolutionRecordType() == null) ? "" :
          res.getDisputeResolutionRecordType().toString();
      dataTable[i][k++] = (res == null || res.getResolutionTime() == null) ? "" :
          eBayUtil.toAPITimeString(res.getResolutionTime().getTime());
    }

    return dataTable;
  }

  void displayDisputes(DisputeType[] disputes)
  {
    int size = disputes != null ? disputes.length : 0;

      String[] colDisputeFromSellers = {
          "DisputeId", "ItemId", "TransactionId", "CreateTime", "CreditEligibility", "Seller",
          "Reason", "LastModified", "ResReason", "ResRecord", "ResTime"
      };

      String[] colDisputeFromBuyers = {
          "DisputeId", "ItemId", "TransactionId", "CreateTime", "CreditEligibility", "Buyer",
          "Reason", "LastModified", "ResReason", "ResRecord", "ResTime"
      };

      ArrayList buyerList = new ArrayList();
      ArrayList sellerList = new ArrayList();
      for (int i = 0; i < size; i++) {
        DisputeType dispute = disputes[i];
        String role = dispute.getOtherPartyRole().value();
        if (BUYER.equals(role)) {
          buyerList.add(dispute);
        }
        else if (SELLER.equals(role)) {
          sellerList.add(dispute);
        }
      }

      // Buyers
      size = buyerList.size();
      if (size > 0) {
        Object[][] dataTable = FillDisputeTable(buyerList, TradingRoleCodeType.BUYER, colDisputeFromBuyers.length);

        JTable jTable1 = new JTable(dataTable, colDisputeFromBuyers);
        this.jScrollPane1.getViewport().add(jTable1, null);
      }
      else {
        Object[][] dataTable = new Object[1][colDisputeFromBuyers.length];
        JTable jTable1 = new JTable(dataTable, colDisputeFromBuyers);
        this.jScrollPane1.getViewport().add(jTable1, null);
      }

      // Sellers
      size = sellerList.size();
      if (size > 0) {
        Object[][] dataTable = FillDisputeTable(sellerList, TradingRoleCodeType.SELLER, colDisputeFromSellers.length);
        JTable jTable2 = new JTable(dataTable, colDisputeFromSellers);
        this.jScrollPane2.getViewport().add(jTable2, null);
      }
      else {
        Object[][] dataTable = new Object[1][colDisputeFromSellers.length];
        JTable jTable2 = new JTable(dataTable, colDisputeFromSellers);
        this.jScrollPane2.getViewport().add(jTable2, null);
      }

  }

  void btnGetUserDisputes_actionPerformed(ActionEvent e) {
    try {
      int idx = this.cbxFilter.getSelectedIndex();
      DisputeFilterTypeCodeType filterType = (DisputeFilterTypeCodeType)
          DialogGetUserDisputes.filters[idx].Tag;

      idx = this.cbxSortOrder.getSelectedIndex();
      SortOrderCodeType sortOrder = (SortOrderCodeType) DialogGetUserDisputes.
          sortOrder[idx].Tag;

      idx = this.cbxSortType.getSelectedIndex();
      DisputeSortTypeCodeType sortType = (DisputeSortTypeCodeType)
          DialogGetUserDisputes.sortTypes[idx].Tag;

      String pageNumber = this.txtPageNumber.getText().trim();
      if (pageNumber == null || pageNumber.length() == 0) {
        pageNumber = "0";
      }
      GetUserDisputesCall api = new GetUserDisputesCall(this.apiContext);
      api.setDisputeFilterType(filterType);
      api.setDisputeSortType(sortType);
      PaginationType pt = new PaginationType();
      pt.setPageNumber(new Integer(pageNumber));
      pt.setEntriesPerPage(new Integer(100));
      api.setPagination(pt);

      GetUserDisputesResponseType resp = api.getUserDisputes();
      this.txtEndDisputeNumber.setText(resp.getEndingDisputeID());
      this.txtStartDisputeNumber.setText(resp.getStartingDisputeID());
      DisputeType[] disputes = resp.getDisputeArray().getDispute();
      displayDisputes(disputes);
    }
    catch(Exception ex) {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  String BUYER = "Buyer";
  String SELLER = "Seller";
}

class DialogGetUserDisputes_btnGetUserDisputes_actionAdapter implements java.awt.event.ActionListener {
  DialogGetUserDisputes adaptee;

  DialogGetUserDisputes_btnGetUserDisputes_actionAdapter(DialogGetUserDisputes adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetUserDisputes_actionPerformed(e);
  }
}
