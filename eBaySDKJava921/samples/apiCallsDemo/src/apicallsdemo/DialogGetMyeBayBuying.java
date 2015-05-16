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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetMyeBayBuyingCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BiddingDetailsType;
import com.ebay.soap.eBLBaseComponents.ItemListCustomizationType;
import com.ebay.soap.eBLBaseComponents.ItemSortTypeCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.OrderTransactionType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.SellingStatusType;
import com.ebay.soap.eBLBaseComponents.TransactionType;
import com.ebay.soap.eBLBaseComponents.UserType;

public class DialogGetMyeBayBuying extends JDialog {

  private ApiContext apiContext = new ApiContext();

  final static int totalColumns = 6;

  final String[] colNames = new String[] {
      "ItemID", "Title", "Price", "EndTime", "Seller", "MaxBid"
  };


  JPanel mainPanel = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();

  JPanel dataPanel = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();

  JPanel inputPanel = new JPanel();
  JPanel inputPanel2 = new JPanel();
  JPanel jPanel5 = new JPanel();

  JPanel jPanel6 = new JPanel();
  JPanel maxListPanel = new JPanel();
  JPanel itemSortPanel = new JPanel();


  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JComboBox cbxItemSort = new JComboBox();
  JLabel jLabel1 = new JLabel();
  JTextField txtMaxPerList = new JTextField();
  JLabel jLabel3 = new JLabel();
  JButton btnGetMyeBay = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JScrollPane jScrollPane2 = new JScrollPane();
  JScrollPane jScrollPane3 = new JScrollPane();
  JScrollPane jScrollPane4 = new JScrollPane();
  JTable tblBidList = new JTable();
  JTable tblWatchList = new JTable();
  JTable tblWonList = new JTable();
  JTable tblLostList = new JTable();

  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanelBidList = new JPanel();
  JPanel jPanelWatchList = new JPanel();
  JPanel jPanelWonList = new JPanel();
  JPanel jPanelLostList = new JPanel();

  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JLabel jLabel4 = new JLabel();
  JPanel jPanel21 = new JPanel();
  JPanel jPanel22 = new JPanel();

  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel14 = new JPanel();
  JLabel jLabel5 = new JLabel();
  JPanel jPanel23 = new JPanel();
  JPanel jPanel24 = new JPanel();


  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel15 = new JPanel();
  JPanel jPanel16 = new JPanel();
  JLabel jLabel8 = new JLabel();
  JPanel jPanel25 = new JPanel();
  JPanel jPanel26 = new JPanel();

  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel17 = new JPanel();
  JPanel jPanel18 = new JPanel();
  JLabel jLabel9 = new JLabel();
  JPanel jPanel27 = new JPanel();
  JPanel jPanel28 = new JPanel();


  static Object[] getTagItemArray()
  {
    Object[] list = new Object[] {
      new ControlTagItem("ItemID Ascending", ItemSortTypeCodeType.ITEM_ID),
      new ControlTagItem("ItemID Descending", ItemSortTypeCodeType.ITEM_ID_DESCENDING),
   };
   return list;
  }

  public DialogGetMyeBayBuying(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      //
      FrameDemo fd = (FrameDemo) frame;
      this.apiContext = fd.getApiContext();

      // Initialize combo box.
      ComboBoxModel dataModel = new DefaultComboBoxModel(getTagItemArray());
      this.cbxItemSort.setModel(dataModel);
      this.cbxItemSort.setSelectedIndex(1);

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetMyeBayBuying() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    mainPanel.setLayout(borderLayout1);

    jLabel1.setPreferredSize(new Dimension(99, 15));

    jLabel1.setText("Sort  items:");
    cbxItemSort.setMinimumSize(new Dimension(26, 21));
    cbxItemSort.setPreferredSize(new Dimension(150, 21));

    jLabel3.setText("Maximum number of items per list:");
    txtMaxPerList.setPreferredSize(new Dimension(80, 21));
    txtMaxPerList.setSelectionStart(5);

    jPanelBidList.setLayout(borderLayout4);
    jLabel4.setText("Bid Items:");

    jPanelWatchList.setLayout(borderLayout5);
    jLabel5.setText("Watch Items:");

    jPanelWonList.setLayout(borderLayout6);
    jLabel8.setText("Won Items:");

    jPanelLostList.setLayout(borderLayout7);
    jLabel9.setText("Lost Items:");

    inputPanel.setLayout(new GridLayout(2,1));
    inputPanel2.setLayout(new FlowLayout());

    inputPanel2.add(maxListPanel, null);
    inputPanel2.add(itemSortPanel,null);
    maxListPanel.add(jLabel3, null);
    maxListPanel.add(txtMaxPerList, null);

    itemSortPanel.add(jLabel1,null);
    itemSortPanel.add(cbxItemSort,null);

    inputPanel.add(inputPanel2);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(btnGetMyeBay, BorderLayout.CENTER);
    btnGetMyeBay.setText("GetMyeBayBuying");
    btnGetMyeBay.addActionListener(new DialogGetMyeBayBuying_btnGetMyeBayBuying_actionAdapter(this));
    inputPanel.add(buttonPanel);

    mainPanel.add(inputPanel,  BorderLayout.NORTH);
    mainPanel.add(dataPanel, BorderLayout.CENTER);

    jScrollPane2.getViewport().setBackground(Color.white);
//    jScrollPane2.setSize(250, 20);
    jScrollPane1.getViewport().setBackground(Color.white);
//    jScrollPane2.setSize(250, 20);
    jScrollPane3.getViewport().setBackground(Color.white);
//    jScrollPane2.setSize(250, 20);
    jScrollPane4.getViewport().setBackground(Color.white);
//    jScrollPane2.setSize(250, 20);

    getContentPane().add(mainPanel);


    dataPanel.setLayout(new GridLayout(2,2));
    dataPanel.setBorder(BorderFactory.createEtchedBorder());

   // dataPanel.setLayout(new FlowLayout());
    dataPanel.add(jPanelBidList);

      dataPanel.add(jPanelWatchList);

      dataPanel.add(jPanelWonList);

      dataPanel.add(jPanelLostList);



    jPanelBidList.add(jPanel11,  BorderLayout.NORTH);
    jPanel11.add(jLabel4, null);
    jPanelBidList.add(jScrollPane1,  BorderLayout.CENTER);
    jScrollPane1.getViewport().add(tblBidList, null);
    jScrollPane1.setPreferredSize(new Dimension(450,250));

    jPanelWatchList.add(jPanel13,  BorderLayout.NORTH);
    jPanel13.add(jLabel5, null);
    jPanelWatchList.add(jScrollPane2, BorderLayout.CENTER);
    jScrollPane2.getViewport().add(tblWatchList, null);
    jScrollPane2.setPreferredSize(new Dimension(450,250));


    jPanelWonList.add(jPanel15,  BorderLayout.NORTH);
    jPanel15.add(jLabel8, null);
    jPanelWonList.add(jScrollPane3, BorderLayout.CENTER);
    jScrollPane3.getViewport().add(tblWonList, null);
    jScrollPane3.setPreferredSize(new Dimension(450,250));


    jPanelLostList.add(jPanel17,  BorderLayout.NORTH);
    jPanel17.add(jLabel9, null);
    jPanelLostList.add(jScrollPane4, BorderLayout.CENTER);
    jScrollPane4.getViewport().add(tblLostList, null);
    jScrollPane4.setPreferredSize(new Dimension(450,250));


    this.setSize(new Dimension(600, 200));
  }

  static String[] itemToColumns(ItemType item)
  {
    String[] cols = new String[totalColumns];
    int i = 0;
    cols[i++] = item.getItemID() != null ? item.getItemID() : "";
    cols[i++] = item.getTitle() != null ? item.getTitle() : "";

    SellingStatusType sst = item.getSellingStatus();
    if (sst != null ) {
    	AmountType amt = sst.getCurrentPrice();
   	   cols[i++] = amt != null ? (new Double(amt.getValue()).toString()) : "";
    }

    java.util.Calendar endTime = item.getListingDetails() == null ? null : item.getListingDetails().getEndTime();
    cols[i++] = endTime != null ? eBayUtil.toAPITimeString(endTime.getTime()) : "";


    UserType seller = item.getSeller();
    cols[i++] = seller != null ? seller.getUserID() : "";

    BiddingDetailsType bidding = item.getBiddingDetails();

   if (bidding!=null) {
	   cols[i++] = bidding.getMaxBid()!=null ? new Double(bidding.getMaxBid().getValue()).toString():"";
   }

    return cols;
  }



  static String[] OrderToColumns(OrderTransactionType order)
  {
    String[] cols = new String[totalColumns];
    int i = 0;
    if (order.getTransaction() != null ) {
    	TransactionType transaction = order.getTransaction();
    	ItemType item = transaction.getItem();
    	if (item!= null) {
    		cols[i++] = item.getItemID();
    		cols[i++] = item.getTitle();
    		SellingStatusType sst = item.getSellingStatus();
    		if (sst!=null)
    			cols[i++] = new Double((sst.getCurrentPrice()).getValue()).toString();
    		cols[i++] = eBayUtil.toAPITimeString(item.getListingDetails().getEndTime().getTime());

    		UserType seller = item.getSeller();
    		cols[i++] = seller != null ? seller.getUserID() : "";
    		
    		BiddingDetailsType bidding = item.getBiddingDetails();
            if (bidding!=null) {
     		   cols[i++] = bidding.getMaxBid()!=null ? new Double(bidding.getMaxBid().getValue()).toString():"";
     	     }
    	}

    } else if (order.getOrder() != null )  {

    	if (order.getOrder().getTransactionArray()!= null){
    	    	TransactionType transaction = (order.getOrder().getTransactionArray()).getTransaction(0);
    	    	ItemType item = transaction.getItem();
    	    	if (item!= null) {
    	    		cols[i++] = item.getItemID();
    	    		cols[i++] = item.getTitle();
    	    		SellingStatusType sst = item.getSellingStatus();
    	    		if (sst!=null)
    	    			cols[i++] = new Double((sst.getCurrentPrice()).getValue()).toString();
    	    		cols[i++] = eBayUtil.toAPITimeString(item.getListingDetails().getEndTime().getTime());

    	    		UserType seller = item.getSeller();
    	    		cols[i++] = seller != null ? seller.getUserID() : "";
    	    		
    	    		BiddingDetailsType bidding = item.getBiddingDetails();
    	            if (bidding!=null) {
    	     		   cols[i++] = bidding.getMaxBid()!=null ? new Double(bidding.getMaxBid().getValue()).toString():"";
    	     	     }
    	    	}

    	    }
    }
    return cols;
  }

  void btnGetMyeBay_actionPerformed(ActionEvent e) {
    try
    {
      GetMyeBayBuyingCall api = new GetMyeBayBuyingCall(this.apiContext);

      ItemListCustomizationType itemListType =  new ItemListCustomizationType();
      ItemListCustomizationType wonListType =  new ItemListCustomizationType();

      itemListType.setInclude(Boolean.TRUE);
      itemListType.setSort((ItemSortTypeCodeType)((ControlTagItem) cbxItemSort.getSelectedItem()).Tag);
      String txt = this.txtMaxPerList.getText();
      if( txt.length() > 0 ) {
    	  try{
    		  PaginationType page = new PaginationType();
           	  page.setEntriesPerPage(Integer.valueOf(txt));
        	  itemListType.setPagination(page);
        	  wonListType.setPagination(page);

    	  } catch (Exception ex) {
    	    String msg = ex.getClass().getName() + " : " + ex.getMessage();
    	  	((FrameDemo)this.getParent()).showErrorMessage(msg);
      	  }
      }

  //    ControlTagItem ct;
  //   ct = (ControlTagItem)this.cbxActiveSort.getSelectedItem();
      api.setBidList(itemListType);
      api.setWatchList(itemListType);
      api.setWonList(wonListType);
      api.setLostList(itemListType);


      api.getMyeBayBuying();

      //
      ItemType[] tempBidItems = null;
      if (api.getReturnedBidList()!=null)
    	  tempBidItems = (api.getReturnedBidList().getItemArray()).getItem();
      final ItemType[] bidItems = tempBidItems;
      // Display BidItems items in table.
      TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return totalColumns; }
        public int getRowCount() { return bidItems == null ? 0 : bidItems.length;}
        public String getColumnName(int columnIndex){
          return colNames[columnIndex];
        }
        public Object getValueAt(int row, int col)
        {
          ItemType item = bidItems[row];
          return itemToColumns(item)[col];
        }
      };

      this.tblBidList.setModel(dataModel);

      //
      ItemType[] tempWatchItems = null;
      if (api.getReturnedWatchList()!=null)
    	  tempWatchItems= (api.getReturnedWatchList().getItemArray()).getItem();
      final ItemType[] watchItems = tempWatchItems;

      // Display Scheduled items in table.
      dataModel = new AbstractTableModel() {
        public int getColumnCount() { return totalColumns; }
        public int getRowCount() { return watchItems == null ? 0 : watchItems.length;}
        public String getColumnName(int columnIndex){
          return colNames[columnIndex];
        }
        public Object getValueAt(int row, int col)
        {
          ItemType item = watchItems[row];
          return itemToColumns(item)[col];
        }
      };

      this.tblWatchList.setModel(dataModel);

      //
      OrderTransactionType[] tempWonItems = null;
      if ((api.getReturnedWonList()!= null))
    	  tempWonItems= (api.getReturnedWonList().getOrderTransactionArray()).getOrderTransaction();
      final OrderTransactionType[] wonItems = tempWonItems;

      // Display Sold items in table.
      dataModel = new AbstractTableModel() {
        public int getColumnCount() { return totalColumns; }
        public int getRowCount() { return wonItems == null ? 0 : wonItems.length;}
        public String getColumnName(int columnIndex){
          return colNames[columnIndex];
        }
        public Object getValueAt(int row, int col)
        {
        	OrderTransactionType orderTrans = wonItems[row];
        	return OrderToColumns(orderTrans)[col];
        }
      };

      this.tblWonList.setModel(dataModel);

      //
      ItemType[] tempLostItems = null;
      if (api.getReturnedLostList()!=null)
    	  tempLostItems= (api.getReturnedLostList().getItemArray()).getItem();
      final ItemType[] lostItems = tempLostItems;

      // Display unsold items in table.
      dataModel = new AbstractTableModel() {
        public int getColumnCount() { return totalColumns; }
        public int getRowCount() { return lostItems == null ? 0 : lostItems.length;}
        public String getColumnName(int columnIndex){
          return colNames[columnIndex];
        }
        public Object getValueAt(int row, int col)
        {
          ItemType item = lostItems[row];
          return itemToColumns(item)[col];
        }
      };

      this.tblLostList.setModel(dataModel);
    }
    catch(Exception ex)
    {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      ((FrameDemo)this.getParent()).showErrorMessage(msg);
    }
  }
}

class DialogGetMyeBayBuying_btnGetMyeBayBuying_actionAdapter implements java.awt.event.ActionListener {
  DialogGetMyeBayBuying adaptee;

  DialogGetMyeBayBuying_btnGetMyeBayBuying_actionAdapter(DialogGetMyeBayBuying adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetMyeBay_actionPerformed(e);
  }
}
