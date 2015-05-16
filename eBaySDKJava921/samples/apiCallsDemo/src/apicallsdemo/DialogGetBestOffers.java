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
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetBestOffersCall;
import com.ebay.sdk.helper.Utils;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.BestOfferStatusCodeType;
import com.ebay.soap.eBLBaseComponents.BestOfferType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.UserType;

/**
 * Demonstrate API GetBestOffers.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogGetBestOffers extends JDialog {
  private ApiContext apiContext = new ApiContext();

  // Table related.
  final static String[] colNames = new String[] {
      "ID", "Expiration", "Price", "Status", "Quantity", "Message", "Buyer UserID", "Buyer Email"};

  final static int totalColumns = colNames.length;

  //
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();
  BorderLayout borderLayout3 = new BorderLayout();

  JPanel panel1 = new JPanel();

  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JButton btnExecuteAPI = new JButton();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable tblAlerts = new JTable();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel15 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel8 = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel14 = new JPanel();
  JLabel lblBestOffers = new JLabel();
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel18 = new JPanel();
  JTable tblBestOffers = new JTable();
  JPanel jPanel7 = new JPanel();
  JPanel jPanelItemInfo = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanelItemTitle = new JPanel();
  JPanel jPanel10 = new JPanel();
  JPanel jPanelReservePrice = new JPanel();
  JPanel jPanelStartPrice = new JPanel();
  JTextField txtItemTitle = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtStartPrice = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtReservePrice = new JTextField();
  JLabel jLabel4 = new JLabel();
  JPanel jPanel19 = new JPanel();
  JPanel jPanel20 = new JPanel();
  JComboBox comboBestOfferStatus = new JComboBox();
  JLabel jLabel3 = new JLabel();
  JTextField txtBestOfferID = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtItemID = new JTextField();
  JLabel jLabel6 = new JLabel();
  JPanel jPanelEndTime = new JPanel();
  JPanel jPanelStartTime = new JPanel();
  JTextField txtStartTime = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField txtEndTime = new JTextField();
  JLabel jLabel8 = new JLabel();
  JTextField txtBuyItNowPrice = new JTextField();
  JLabel jLabel9 = new JLabel();
  BorderLayout borderLayout8 = new BorderLayout();

  static void initStatusComboBox(JComboBox combo)
  {
    // Initialize combo box.
    Object[] list = new Object[] {
        new ControlTagItem("All", BestOfferStatusCodeType.ALL),
        new ControlTagItem("Active", BestOfferStatusCodeType.ACTIVE),
    };
    ComboBoxModel dataModel = new DefaultComboBoxModel(list);
    combo.setModel(dataModel);
    combo.setSelectedIndex(0);
  }

  public DialogGetBestOffers(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      this.initStatusComboBox(this.comboBestOfferStatus);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetBestOffers() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setMinimumSize(new Dimension(133, 25));
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(160, 25));
    btnExecuteAPI.setText("GetBestOffers");
    btnExecuteAPI.addActionListener(new DialogGetBestOffers_btnExecuteAPI_actionAdapter(this));
    jPanel5.setLayout(borderLayout5);
    jPanel6.setPreferredSize(new Dimension(143, 40));
    jPanel6.setLayout(borderLayout4);
    jPanel5.setOpaque(true);
    jPanel5.setPreferredSize(new Dimension(10, 50));
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setPreferredSize(new Dimension(600, 180));
    jPanel1.setRequestFocusEnabled(true);
    panel1.setPreferredSize(new Dimension(680, 558));
    panel1.setRequestFocusEnabled(true);
    jPanel11.setLayout(borderLayout6);
    lblBestOffers.setToolTipText("");
    lblBestOffers.setVerifyInputWhenFocusTarget(true);
    lblBestOffers.setText("Best Offers");
    jPanel12.setLayout(borderLayout7);
    jPanel11.setPreferredSize(new Dimension(464, 300));
    jPanel12.setPreferredSize(new Dimension(464, 100));
    jPanelItemInfo.setLayout(gridLayout1);
    gridLayout1.setColumns(2);
    gridLayout1.setRows(3);
    jLabel1.setText("Title:");
    txtItemTitle.setBackground(Color.white);
    txtItemTitle.setPreferredSize(new Dimension(200, 21));
    txtItemTitle.setEditable(false);
    txtItemTitle.setText("");
    jLabel2.setPreferredSize(new Dimension(100, 15));
    jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel2.setText("Start Price:");
    txtStartPrice.setBackground(Color.white);
    txtStartPrice.setMinimumSize(new Dimension(6, 21));
    txtStartPrice.setPreferredSize(new Dimension(100, 21));
    txtStartPrice.setToolTipText("");
    txtStartPrice.setEditable(false);
    txtStartPrice.setSelectionStart(3);
    txtStartPrice.setText("");
    jLabel4.setOpaque(false);
    jLabel4.setPreferredSize(new Dimension(100, 15));
    jLabel4.setRequestFocusEnabled(true);
    jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel4.setText("Reserve Price:");
    txtReservePrice.setBackground(Color.white);
    txtReservePrice.setPreferredSize(new Dimension(100, 21));
    txtReservePrice.setEditable(false);
    txtReservePrice.setText("");
    jLabel3.setText("BestOfferStatus:");
    txtBestOfferID.setMinimumSize(new Dimension(60, 21));
    txtBestOfferID.setPreferredSize(new Dimension(60, 21));
    txtBestOfferID.setSelectionStart(0);
    txtBestOfferID.setText("");
    jLabel5.setText("BestOfferID:");
    txtItemID.setPreferredSize(new Dimension(100, 21));
    txtItemID.setSelectionStart(0);
    txtItemID.setText("705005519");
    jLabel6.setText("Item ID:");
    comboBestOfferStatus.setMinimumSize(new Dimension(26, 21));
    comboBestOfferStatus.setPreferredSize(new Dimension(100, 21));
    txtStartTime.setBackground(Color.white);
    txtStartTime.setPreferredSize(new Dimension(100, 21));
    txtStartTime.setEditable(false);
    txtStartTime.setSelectionStart(0);
    txtStartTime.setText("");
    jLabel7.setPreferredSize(new Dimension(100, 15));
    jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel7.setHorizontalTextPosition(SwingConstants.LEADING);
    jLabel7.setText("Start Time:");
    txtEndTime.setBackground(Color.white);
    txtEndTime.setPreferredSize(new Dimension(100, 21));
    txtEndTime.setToolTipText("");
    txtEndTime.setEditable(false);
    txtEndTime.setText("");
    jLabel8.setPreferredSize(new Dimension(100, 15));
    jLabel8.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel8.setText("End Time:");
    txtBuyItNowPrice.setBackground(Color.white);
    txtBuyItNowPrice.setDoubleBuffered(false);
    txtBuyItNowPrice.setPreferredSize(new Dimension(100, 21));
    txtBuyItNowPrice.setEditable(false);
    txtBuyItNowPrice.setText("");
    jLabel9.setPreferredSize(new Dimension(100, 15));
    jLabel9.setText("Buy It Now Price:");
    jPanel14.setDebugGraphicsOptions(0);
    jPanel14.setLayout(borderLayout8);
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(btnExecuteAPI, null);
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(jPanel8,  BorderLayout.NORTH);
    jPanel8.add(jLabel6, null);
    jPanel8.add(txtItemID, null);
    jPanel8.add(jLabel5, null);
    jPanel8.add(txtBestOfferID, null);
    jPanel8.add(jLabel3, null);
    jPanel8.add(comboBestOfferStatus, null);
    jPanel5.add(jPanel19, BorderLayout.CENTER);
    jPanel5.add(jPanel20, BorderLayout.SOUTH);

    panel1.add(jPanel2, BorderLayout.CENTER);
    jPanel2.setLayout(borderLayout3);
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.add(jPanel11, BorderLayout.CENTER);
    jPanel11.add(jPanel13,  BorderLayout.NORTH);
    jPanel13.add(lblBestOffers, null);
    jPanel11.add(jPanel14, BorderLayout.CENTER);
    jPanel14.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(tblBestOffers, null);
    jPanel2.add(jPanel12,  BorderLayout.NORTH);
    jPanel12.add(jPanel7,  BorderLayout.NORTH);
    jPanel12.add(jPanelItemInfo, BorderLayout.CENTER);
    jPanelItemInfo.add(jPanelItemTitle, null);
    jPanelItemTitle.add(jLabel1, null);
    jPanelItemTitle.add(txtItemTitle, null);
    jPanelItemInfo.add(jPanelStartTime, null);
    jPanelItemInfo.add(jPanelEndTime, null);
    jPanelEndTime.add(jLabel8, null);
    jPanelEndTime.add(txtEndTime, null);
    jPanelItemInfo.add(jPanelStartPrice, null);
    jPanelStartPrice.add(jLabel2, null);
    jPanelStartPrice.add(txtStartPrice, null);
    jPanelItemInfo.add(jPanelReservePrice, null);
    jPanelReservePrice.add(jLabel4, null);
    jPanelReservePrice.add(txtReservePrice, null);
    jPanelItemInfo.add(jPanel10, null);
    jPanel10.add(jLabel9, null);
    jPanel10.add(txtBuyItNowPrice, null);
    jPanel2.add(jPanel18,  BorderLayout.SOUTH);

    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanelStartTime.add(jLabel7, null);
    jPanelStartTime.add(txtStartTime, null);

    jPanel1.setPreferredSize(new Dimension(800, 80));
    this.setSize(new Dimension(658, 415));
  }

  static String[] bestOfferTypeToColumns(BestOfferType bo)
  {
    //"ID", "Expiration", "Price", "Status", "Quantity", "Message", "Buyer UserID", "Buyer Email"

    String[] cols = new String[totalColumns];

    int i = 0;
    cols[i++] = bo.getBestOfferID() == null ? "" : bo.getBestOfferID();
    cols[i++] = eBayUtil.toAPITimeString(bo.getExpirationTime().getTime());
    cols[i++] = bo.getPrice() == null ? "" : new Double(bo.getPrice().getValue()).toString();
    cols[i++] = bo.getStatus().toString();
    cols[i++] = bo.getQuantity() == null ? "" : bo.getQuantity().toString();
    cols[i++] = Utils.getDispString(bo.getBuyerMessage());;

    UserType buyer = bo.getBuyer();
    cols[i++] = buyer.getUserID() == null ? "" : buyer.getUserID().toString();
    cols[i++] = Utils.getDispString(buyer.getEmail());

    return cols;
  }

  private void displayBestOffers(BestOfferType[] inOffers)
  {
    final BestOfferType[] offers = inOffers;

    TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalColumns;
      }

      public int getRowCount() {
        return offers != null ? offers.length : 0;
      }

      public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        BestOfferType o = offers[row];
        return bestOfferTypeToColumns(o)[col];
      }
    };

    this.tblBestOffers.setModel(dataModel);
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    String s;
    try
    {
      GetBestOffersCall api = new GetBestOffersCall(this.apiContext);

      s = this.txtItemID.getText();
      if( s.length() == 0 )
        throw new Exception("Please enter Item ID.");
      api.setItemID(s);

      s = this.txtBestOfferID.getText();
      if( s.length() > 0 )
        api.setBestOfferID(s);

      ControlTagItem ct = (ControlTagItem)this.comboBestOfferStatus.getSelectedItem();
      api.setBestOfferStatus((BestOfferStatusCodeType)ct.Tag);

      // Call API.
      api.getBestOffers();

      // Display best offers.
      this.displayBestOffers(api.getReturnedBestOffers());

      // Display item.
      ItemType item = api.getReturnedItem();

      this.txtItemTitle.setText(item.getTitle());
      java.util.Calendar c = item.getListingDetails().getStartTime();
      this.txtStartTime.setText(c == null ? "" : eBayUtil.toAPITimeString(c.getTime()));
      this.txtEndTime.setText(eBayUtil.toAPITimeString(item.getListingDetails().getEndTime().getTime()));
      this.txtStartPrice.setText(Utils.amountToString(item.getStartPrice()));
      this.txtReservePrice.setText(Utils.amountToString(item.getReservePrice()));
      this.txtBuyItNowPrice.setText(Utils.amountToString(item.getBuyItNowPrice()));
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGetBestOffers_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogGetBestOffers adaptee;

  DialogGetBestOffers_btnExecuteAPI_actionAdapter(DialogGetBestOffers adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}
