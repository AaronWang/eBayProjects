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
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.LeaveFeedbackCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.AbstractResponseType;
import com.ebay.soap.eBLBaseComponents.CommentTypeCodeType;
import com.ebay.soap.eBLBaseComponents.FeedbackDetailType;

public class DialogLeaveFeedback extends JDialog {
  private ApiContext apiContext = new ApiContext();

  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JTextField txtItemID = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtTransactionID = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtTargetUser = new JTextField();
  JLabel jLabel3 = new JLabel();
  JComboBox comboFeedbackType = new JComboBox();
  JTextField txtComments = new JTextField();
  JLabel jLabel4 = new JLabel();
  JButton btnLeaveFeedback = new JButton();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField txteBayTime = new JTextField();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JTextField txtCallStatus = new JTextField();

  public DialogLeaveFeedback(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      // Initialize combo box.
      Object[] list = new Object[] {
          new ControlTagItem("Positive", CommentTypeCodeType.POSITIVE),
          new ControlTagItem("Neutral", CommentTypeCodeType.NEUTRAL),
          new ControlTagItem("Negative", CommentTypeCodeType.NEGATIVE),
      };
      ComboBoxModel dataModel = new DefaultComboBoxModel(list);
      this.comboFeedbackType.setModel(dataModel);
      this.comboFeedbackType.setSelectedIndex(0);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogLeaveFeedback() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    jPanel4.setLayout(gridLayout1);
    gridLayout1.setColumns(2);
    gridLayout1.setRows(2);
    jLabel1.setPreferredSize(new Dimension(70, 15));
    jLabel1.setText("ItemID:");
    txtItemID.setPreferredSize(new Dimension(60, 21));
    txtItemID.setText("");
    jLabel2.setPreferredSize(new Dimension(70, 15));
    jLabel2.setText("TransactionID:");
    txtTransactionID.setPreferredSize(new Dimension(60, 21));
    txtTransactionID.setText("");
    jLabel3.setPreferredSize(new Dimension(70, 15));
    jLabel3.setText("TargetUser:");
    txtTargetUser.setPreferredSize(new Dimension(60, 21));
    txtTargetUser.setText("");
    jLabel4.setText("Comments:");
    txtComments.setPreferredSize(new Dimension(200, 21));
    txtComments.setText("");
    btnLeaveFeedback.setText("LeaveFeedback");
    btnLeaveFeedback.addActionListener(new DialogLeaveFeedback_btnLeaveFeedback_actionAdapter(this));
    jPanel2.setLayout(gridBagLayout1);
    jLabel5.setText("eBayTime:");
    jLabel6.setText("    ");
    jLabel7.setText("    ");
    jLabel8.setText("CallStatus:");
    jLabel9.setText("    ");
    txteBayTime.setBackground(UIManager.getColor("Button.background"));
    txteBayTime.setPreferredSize(new Dimension(120, 21));
    txteBayTime.setText("");
    txtCallStatus.setBackground(UIManager.getColor("Button.background"));
    txtCallStatus.setPreferredSize(new Dimension(60, 21));
    txtCallStatus.setText("");
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel4,  BorderLayout.NORTH);
    jPanel4.add(jPanel7, null);
    jPanel7.add(jLabel1, null);
    jPanel7.add(txtItemID, null);
    jPanel4.add(jPanel10, null);
    jPanel4.add(jPanel9, null);
    jPanel4.add(jPanel8, null);
    jPanel8.add(comboFeedbackType, null);
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(jLabel4, null);
    jPanel5.add(txtComments, null);
    jPanel1.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(btnLeaveFeedback, null);
    panel1.add(jPanel2,  BorderLayout.CENTER);
    jPanel2.add(jLabel5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel6, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txteBayTime, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel7, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel8, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel9, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtCallStatus, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel10.add(jLabel2, null);
    jPanel10.add(txtTransactionID, null);
    jPanel9.add(jLabel3, null);
    jPanel9.add(txtTargetUser, null);
    this.setSize(new Dimension(400, 200));
    this.setResizable(false);
  }

  void btnLeaveFeedback_actionPerformed(ActionEvent e) {
    try
    {
      GuiUtil.isTextControlFilled(this.txtItemID, "Please enter item ID.");
      GuiUtil.isTextControlFilled(this.txtComments, "Please enter comments.");
      GuiUtil.isTextControlFilled(this.txtTargetUser, "Please enter target user ID.");

      ControlTagItem ct = (ControlTagItem)this.comboFeedbackType.getSelectedItem();

      LeaveFeedbackCall api = new LeaveFeedbackCall(this.apiContext);

      FeedbackDetailType fd = new FeedbackDetailType();
      fd.setItemID(this.txtItemID.getText());
      fd.setCommentText(this.txtComments.getText());
      fd.setCommentType((CommentTypeCodeType)ct.Tag);

      String txt = this.txtTransactionID.getText();
      if( txt.length() > 0 )
        api.setTransactionID(txt);

      api.setTargetUser(this.txtTargetUser.getText());
      api.setFeedbackDetail(fd);

      api.leaveFeedback();

      AbstractResponseType resp = api.getResponseObject();
      Date dt = resp.getTimestamp().getTime();
      this.txteBayTime.setText(eBayUtil.toAPITimeString(dt));
      this.txtCallStatus.setText(resp.getAck().value());
    }
    catch(Exception ex)
    {
      this.txteBayTime.setText(eBayUtil.toAPITimeString(new Date()));
      this.txtCallStatus.setText("Failure");
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogLeaveFeedback_btnLeaveFeedback_actionAdapter implements java.awt.event.ActionListener {
  DialogLeaveFeedback adaptee;

  DialogLeaveFeedback_btnLeaveFeedback_actionAdapter(DialogLeaveFeedback adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnLeaveFeedback_actionPerformed(e);
  }
}
