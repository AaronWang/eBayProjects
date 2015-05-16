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
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetAllBiddersCall;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.GetAllBiddersModeCodeType;
import com.ebay.soap.eBLBaseComponents.OfferType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogGetAllBidders extends JDialog {
  private ApiContext apiContext = new ApiContext();

  BorderLayout borderLayout1 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;

  static String[] columnNames = {"ConvertedPrice", "MaxBid", "BidTime", "Quantity", "Bidder"};

  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel6 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtItemId = new JTextField();
  JCheckBox chkSecondChanceEnabledOnly = new JCheckBox();
  JCheckBox chkViewAllBidders = new JCheckBox();
  JButton btnGetAllBidders = new JButton();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel jLabel16 = new JLabel();
  JTextField txtCount = new JTextField();
  JTextField txtHighBidderUserId = new JTextField();
  JTextField txtHighestBid = new JTextField();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel14 = new JPanel();
  GridBagLayout gridBagLayout4 = new GridBagLayout();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel17 = new JLabel();

  public DialogGetAllBidders(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetAllBidders() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    jPanel1.setLayout(borderLayout2);
    this.setModal(true);
    this.setTitle("eBay SDK for Java - GetAllBidders");

    txtItemId.setPreferredSize(new Dimension(100, 21));
    txtItemId.setText("");
    chkSecondChanceEnabledOnly.setText("SecondChanceEnabledOnly");
    chkViewAllBidders.setText("ViewAllBidders");
    btnGetAllBidders.setText("GetAllBidders");
    btnGetAllBidders.addActionListener(new DialogGetAllBidders_btnGetAllBidders_actionAdapter(this));
    jLabel4.setText("Count:");
    jLabel10.setText("HighestBid:");
    jLabel16.setText("ItemID:");

    jPanel2.setLayout(borderLayout5);
    jPanel3.setLayout(borderLayout3);

    txtCount.setBackground(Color.lightGray);
    txtCount.setPreferredSize(new Dimension(100, 21));
    txtCount.setText("");
    txtHighBidderUserId.setBackground(Color.lightGray);
    txtHighBidderUserId.setPreferredSize(new Dimension(100, 21));
    txtHighestBid.setBackground(Color.lightGray);
    txtHighestBid.setPreferredSize(new Dimension(100, 21));
    txtHighestBid.setText("");
    jScrollPane1.getViewport().setBackground(Color.white);

    jPanel8.setPreferredSize(new Dimension(10, 100));
    jPanel8.setLayout(gridBagLayout1);
    jLabel2.setPreferredSize(new Dimension(40, 15));
    jLabel2.setText("  ");
    jLabel3.setText("    ");
    jPanel10.setLayout(gridBagLayout3);
    jPanel4.setLayout(borderLayout6);
    jPanel11.setPreferredSize(new Dimension(100, 130));
    jPanel11.setLayout(gridBagLayout4);
    jLabel12.setText(" ");
    jLabel13.setText("HIghBidderUserID:");
    jLabel17.setText(" ");
    jLabel11.setPreferredSize(new Dimension(60, 21));
    jLabel11.setText("");
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel2.add(jPanel8, BorderLayout.NORTH);
    jPanel8.add(chkSecondChanceEnabledOnly,    new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, -4, 0, 0), 0, 0));
    jPanel8.add(jLabel2,   new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(chkViewAllBidders,    new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, -4, 0, 0), 0, 0));
    jPanel8.add(txtItemId,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel16,   new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jPanel9, BorderLayout.SOUTH);
    jPanel2.add(jPanel10, BorderLayout.CENTER);
    jPanel10.add(btnGetAllBidders, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jPanel6, BorderLayout.SOUTH);
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    jPanel4.add(jPanel11, BorderLayout.NORTH);
    jPanel11.add(txtCount,   new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel11.add(jLabel11,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel11.add(jLabel4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel11.add(jLabel12, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel11.add(txtHighBidderUserId, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel11.add(jLabel13,  new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel11.add(jLabel17, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel11.add(txtHighestBid, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel11.add(jLabel10, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    jPanel4.add(jPanel12, BorderLayout.SOUTH);
    jPanel4.add(jPanel13, BorderLayout.WEST);
    jPanel4.add(jPanel14, BorderLayout.EAST);
    jPanel4.add(jScrollPane1, BorderLayout.CENTER);

    this.jPanel2.setPreferredSize(new Dimension(320, 140));
    this.jPanel3.setPreferredSize(new Dimension(420, 1));
    this.jPanel4.setPreferredSize(new Dimension(420, 30));
    this.jPanel6.setPreferredSize(new Dimension(420, 1));

    this.setSize(new Dimension(620, 500));
  }

  void displayAllBidders(OfferType[] offers)
  {
    Object[] [] dataTable = null;
    int size = offers != null ? offers.length : 0;

    this.txtCount.setText(new Integer(size).toString());
    if (size > 0) {
      double highestBid = 0;
      String highBidder = "";
      double bid = 0;
      dataTable = new Object[size][5];
      for (int i = 0; i < size; i++) {
        OfferType offer = offers[i];
        dataTable[i][0] = offer.getConvertedPrice().getValue();
        dataTable[i][1] = offer.getMaxBid().getValue();
        dataTable[i][2] = eBayUtil.toAPITimeString(offer.getTimeBid().getTime());
        dataTable[i][3] = offer.getQuantity().toString();
        dataTable[i][4] = offer.getUser().getUserID();
        bid = offer.getMaxBid().getValue();
        if (highestBid < bid) {
          highestBid = bid;
          highBidder = dataTable[i][4].toString();
        }

        this.txtHighestBid.setText(new Double(highestBid).toString());
        this.txtHighBidderUserId.setText(highBidder);
      }

      JTable jTable1 = new JTable(dataTable, columnNames);
      this.jScrollPane1.getViewport().add(jTable1, null);
    }
  }

  void btnGetAllBidders_actionPerformed(ActionEvent e)
  {
    try {
      String itemId = this.txtItemId.getText().trim();
      if ( itemId.length() == 0) {
        throw new Exception("Please enter an ItemID.");
      }

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      GetAllBiddersCall api = new GetAllBiddersCall(this.apiContext);
      api.setDetailLevel(detailLevels);
      api.setItemID(itemId);

      boolean b = this.chkSecondChanceEnabledOnly.isSelected();
      b = this.chkViewAllBidders.isSelected();

      api.setCallMode(GetAllBiddersModeCodeType.VIEW_ALL);
      OfferType[] bidders = api.getAllBidders();

      displayAllBidders(bidders);
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGetAllBidders_btnGetAllBidders_actionAdapter implements java.awt.event.ActionListener {
  DialogGetAllBidders adaptee;

  DialogGetAllBidders_btnGetAllBidders_actionAdapter(DialogGetAllBidders adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetAllBidders_actionPerformed(e);
  }
}
