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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.AddSecondChanceItemCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.SecondChanceOfferDurationCodeType;

public class DialogAddSecondChanceItem extends JDialog {
  private ApiContext apiContext = new ApiContext();

  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanelOriginalItemID = new JPanel();
  JPanel jPanelBINPrice = new JPanel();
  JPanel jPanelCopyEmailToSeller = new JPanel();
  JPanel jPanelDuration = new JPanel();
  JPanel jPanelRecipientBidderUserID = new JPanel();
  JTextField txtOriginalItemId = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtRecipientBidderUserId = new JTextField();
  JLabel jLabel2 = new JLabel();
  JComboBox comboDuration = new JComboBox();
  JLabel jLabel4 = new JLabel();
  JCheckBox cbxCopyEmailToSeller = new JCheckBox();
  JTextField txtBINPrice = new JTextField();
  JLabel jLabel5 = new JLabel();
  JButton btnAddSecondChangeIcen = new JButton();
  GridLayout gridLayout2 = new GridLayout();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JTextField txtItemID = new JTextField();
  JLabel jLabel6 = new JLabel();
  JTextField txtListingFee = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField txtStartTime = new JTextField();
  JLabel jLabel8 = new JLabel();
  JTextField txtEndTime = new JTextField();
  JLabel jLabel9 = new JLabel();
 
  public DialogAddSecondChanceItem(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      //
      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      // Initialize combo box.
      Object[] list = new Object[] {
          new ControlTagItem("1 Day", SecondChanceOfferDurationCodeType.DAYS_1),
          new ControlTagItem("3 Days", SecondChanceOfferDurationCodeType.DAYS_3),
          new ControlTagItem("5 Days", SecondChanceOfferDurationCodeType.DAYS_5),
          new ControlTagItem("7 Days", SecondChanceOfferDurationCodeType.DAYS_7),
      };
      ComboBoxModel dataModel = new DefaultComboBoxModel(list);
      this.comboDuration.setModel(dataModel);
      this.comboDuration.setSelectedIndex(2);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogAddSecondChanceItem() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    jPanel4.setLayout(gridLayout1);
    gridLayout1.setColumns(2);
    gridLayout1.setRows(3);
    jLabel1.setText("OriginalItemID:");
    txtOriginalItemId.setPreferredSize(new Dimension(80, 21));
    txtOriginalItemId.setText("");
    jLabel2.setToolTipText("");
    jLabel2.setText("RecipientBidderUserID:");
    txtRecipientBidderUserId.setPreferredSize(new Dimension(80, 21));
    txtRecipientBidderUserId.setText("");
    jLabel4.setText("Duration:");
    cbxCopyEmailToSeller.setText("Copy email to seller");
    jLabel5.setText("BuyItNow price:");
    txtBINPrice.setPreferredSize(new Dimension(60, 21));
    txtBINPrice.setText("");
    btnAddSecondChangeIcen.setText("AddSecondChanceItem");
    btnAddSecondChangeIcen.addActionListener(new DialogAddSecondChanceItem_btnAddSecondChangeIcen_actionAdapter(this));
    jPanel2.setLayout(gridLayout2);
    gridLayout2.setColumns(2);
    gridLayout2.setRows(2);
    jLabel6.setPreferredSize(new Dimension(60, 15));
    jLabel6.setText("ItemID:");
    txtItemID.setPreferredSize(new Dimension(60, 21));
    txtItemID.setEditable(false);
    txtItemID.setText("");
    jLabel7.setMinimumSize(new Dimension(55, 15));
    jLabel7.setPreferredSize(new Dimension(60, 15));
    jLabel7.setText("Listing Fee:");
    txtListingFee.setMaximumSize(new Dimension(2147483647, 2147483647));
    txtListingFee.setMinimumSize(new Dimension(6, 21));
    txtListingFee.setPreferredSize(new Dimension(60, 21));
    txtListingFee.setEditable(false);
    txtListingFee.setSelectionStart(4);
    jLabel8.setPreferredSize(new Dimension(60, 15));
    jLabel8.setText("StartTime:");
    txtStartTime.setPreferredSize(new Dimension(60, 21));
    txtStartTime.setEditable(false);
    txtStartTime.setText("");
    jLabel9.setPreferredSize(new Dimension(60, 15));
    jLabel9.setText("EndTime:");
    txtEndTime.setPreferredSize(new Dimension(60, 21));
    txtEndTime.setEditable(false);
    txtEndTime.setText("");
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel4,  BorderLayout.NORTH);
    jPanel4.add(jPanelOriginalItemID, null);
    jPanelOriginalItemID.add(jLabel1, null);
    jPanelOriginalItemID.add(txtOriginalItemId, null);
    jPanel4.add(jPanelRecipientBidderUserID, null);
    jPanelRecipientBidderUserID.add(jLabel2, null);
    jPanelRecipientBidderUserID.add(txtRecipientBidderUserId, null);
    jPanel4.add(jPanelDuration, null);
    jPanelDuration.add(jLabel4, null);
    jPanelDuration.add(comboDuration, null);
    jPanel4.add(jPanelCopyEmailToSeller, null);
    jPanelCopyEmailToSeller.add(cbxCopyEmailToSeller, null);
    jPanel4.add(jPanelBINPrice, null);
    jPanelBINPrice.add(jLabel5, null);
    jPanelBINPrice.add(txtBINPrice, null);
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(btnAddSecondChangeIcen, null);
    panel1.add(jPanel2,  BorderLayout.CENTER);
    jPanel2.add(jPanel6, null);
    jPanel6.add(jLabel6, null);
    jPanel6.add(txtItemID, null);
    jPanel2.add(jPanel9, null);
    jPanel9.add(jLabel7, null);
    jPanel9.add(txtListingFee, null);
    jPanel2.add(jPanel8, null);
    jPanel8.add(jLabel8, null);
    jPanel8.add(txtStartTime, null);
    jPanel2.add(jPanel7, null);
    jPanel7.add(jLabel9, null);
    jPanel7.add(txtEndTime, null);
    panel1.add(jPanel3, BorderLayout.SOUTH);
  }

  void internalAddSecondChanceItem(boolean isVerify)
  {
    try
    {
      GuiUtil.isTextControlFilled(this.txtOriginalItemId, "Please enter OriginalItemId");
      GuiUtil.isTextControlFilled(this.txtRecipientBidderUserId, "Please enter RecipientBidderUserId");

      AddSecondChanceItemCall api = new AddSecondChanceItemCall(this.apiContext);

      ControlTagItem ct = (ControlTagItem)this.comboDuration.getSelectedItem();

      api.setRecipientBidderUserID(this.txtRecipientBidderUserId.getText());

      if (null != ct.Tag) {
      	api.setDuration((SecondChanceOfferDurationCodeType)ct.Tag);
      }
      
      api.setItemID(this.txtOriginalItemId.getText());

      if( txtBINPrice.getText().length() != 0 )
      {
        double bp = Double.parseDouble(this.txtBINPrice.getText());
        AmountType at = new AmountType();
        at.setValue(bp);
        api.setBuyItNowPrice(at);
      }

      // Executes the API.
       if (isVerify )
    	    api.verifyAddSecondChanceItem();
       else
    	   api.addSecondChanceItem();

      // Display results.
      this.txtItemID.setText(isVerify ? "" : api.getItemID().toString());

  
      this.txtStartTime.setText(eBayUtil.toAPITimeString(api.getReturnedStartTime().getTime()));
      this.txtEndTime.setText(eBayUtil.toAPITimeString(api.getReturnedEndTime().getTime()));
    }
    catch(Exception ex)
    {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      ((FrameDemo)this.getParent()).showErrorMessage(msg);
    }
  }

  void btnAddSecondChangeItem_actionPerformed(ActionEvent e) {
    internalAddSecondChanceItem(false);
  }
}

class DialogAddSecondChanceItem_btnAddSecondChangeIcen_actionAdapter implements java.awt.event.ActionListener {
  DialogAddSecondChanceItem adaptee;

  DialogAddSecondChanceItem_btnAddSecondChangeIcen_actionAdapter(DialogAddSecondChanceItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnAddSecondChangeItem_actionPerformed(e);
  }
}


