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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.EndItemCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;

public class DialogEndItem extends JDialog {
  private ApiContext apiContext = new ApiContext();

  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JTextField txtItemID = new JTextField();
  JLabel jLabel1 = new JLabel();
  JButton btnCallEndItem = new JButton();
  JPanel jPanel6 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel7 = new JPanel();
  JComboBox cbxReasonCode = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JTextField txtEndTime = new JTextField();

  public DialogEndItem(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      //
      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      // Initialize combo box.
      Object[] list = new Object[] {
          new ControlTagItem("Incorrect", EndReasonCodeType.INCORRECT),
          new ControlTagItem("LostOrBroken", EndReasonCodeType.LOST_OR_BROKEN),
          new ControlTagItem("NotAvailable", EndReasonCodeType.NOT_AVAILABLE),
          new ControlTagItem("OtherListingError", EndReasonCodeType.OTHER_LISTING_ERROR),
      };
      ComboBoxModel dataModel = new DefaultComboBoxModel(list);
      this.cbxReasonCode.setModel(dataModel);
      this.cbxReasonCode.setSelectedIndex(0);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogEndItem() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    jLabel1.setPreferredSize(new Dimension(80, 15));
    jLabel1.setText("Item ID:");
    txtItemID.setPreferredSize(new Dimension(120, 21));
    txtItemID.setText("");
    btnCallEndItem.setText("EndItem");
    btnCallEndItem.addActionListener(new DialogEndItem_btnCallEndItem_actionAdapter(this));
    jPanel4.setLayout(gridLayout1);
    gridLayout1.setRows(2);
    cbxReasonCode.setOpaque(true);
    cbxReasonCode.setPreferredSize(new Dimension(120, 21));
    cbxReasonCode.setToolTipText("");
    cbxReasonCode.setPopupVisible(false);
    cbxReasonCode.setSelectedIndex(-1);
    jLabel2.setPreferredSize(new Dimension(80, 15));
    jLabel2.setText("Ending Reason:");
    jLabel3.setText("End Time:");
    txtEndTime.setPreferredSize(new Dimension(150, 21));
    txtEndTime.setEditable(false);
    txtEndTime.setSelectionEnd(4);
    txtEndTime.setSelectionStart(0);
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel4,  BorderLayout.NORTH);
    jPanel4.add(jPanel6, null);
    jPanel6.add(jLabel1, null);
    jPanel6.add(txtItemID, null);
    jPanel4.add(jPanel7, null);
    jPanel7.add(jLabel2, null);
    jPanel7.add(cbxReasonCode, null);
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(btnCallEndItem, null);
    panel1.add(jPanel2,  BorderLayout.CENTER);
    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jLabel3, null);
    jPanel3.add(txtEndTime, null);
  }

  void btnCallEndItem_actionPerformed(ActionEvent e) {
    try
    {
      EndItemCall api = new EndItemCall(this.apiContext);

      if( this.txtItemID.getText().length() == 0 )
        throw new SdkException("Please enter item ID.");
      api.setItemID(this.txtItemID.getText());

      ControlTagItem ct = (ControlTagItem)this.cbxReasonCode.getSelectedItem();
      api.setEndingReason((EndReasonCodeType)ct.Tag);

      java.util.Calendar endTime = api.endItem();

      this.txtEndTime.setText(eBayUtil.toAPITimeString(endTime.getTime()));
    }
    catch(Exception ex)
    {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      ((FrameDemo)this.getParent()).showErrorMessage(msg);
    }
  }
}

class DialogEndItem_btnCallEndItem_actionAdapter implements java.awt.event.ActionListener {
  DialogEndItem adaptee;

  DialogEndItem_btnCallEndItem_actionAdapter(DialogEndItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCallEndItem_actionPerformed(e);
  }
}
