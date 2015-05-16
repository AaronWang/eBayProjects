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
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.SellerReverseDisputeCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.DisputeResolutionReasonCodeType;
import com.ebay.soap.eBLBaseComponents.SellerReverseDisputeResponseType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogSellerReverseDispute extends JDialog
{
  private ApiContext apiContext;

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel23 = new JLabel();
  JTextField txtCallStatus = new JTextField();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel4 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtDisputeId = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JButton btnSellerReverseDispute = new JButton();
  JLabel jLabel6 = new JLabel();
  JComboBox cbxDisputeResolutionReason = new JComboBox();

  static ControlTagItem[] reasons = new ControlTagItem[] {
      new ControlTagItem(DisputeResolutionReasonCodeType.PROOF_OF_PAYMENT.value(), DisputeResolutionReasonCodeType.PROOF_OF_PAYMENT),
      new ControlTagItem(DisputeResolutionReasonCodeType.COMPUTER_TECHNICAL_PROBLEM.value(), DisputeResolutionReasonCodeType.COMPUTER_TECHNICAL_PROBLEM),
      new ControlTagItem(DisputeResolutionReasonCodeType.NO_CONTACT.value(), DisputeResolutionReasonCodeType.NO_CONTACT),
      new ControlTagItem(DisputeResolutionReasonCodeType.FAMILY_EMERGENCY.value(), DisputeResolutionReasonCodeType.FAMILY_EMERGENCY),
      new ControlTagItem(DisputeResolutionReasonCodeType.PROOF_GIVEN_IN_FEEDBACK.value(), DisputeResolutionReasonCodeType.PROOF_GIVEN_IN_FEEDBACK),
      new ControlTagItem(DisputeResolutionReasonCodeType.FIRST_INFRACTION.value(), DisputeResolutionReasonCodeType.FIRST_INFRACTION),
      new ControlTagItem(DisputeResolutionReasonCodeType.CAME_TO_AGREEMENT.value(), DisputeResolutionReasonCodeType.CAME_TO_AGREEMENT),
      new ControlTagItem(DisputeResolutionReasonCodeType.ITEM_RETURNED.value(), DisputeResolutionReasonCodeType.ITEM_RETURNED),
      new ControlTagItem(DisputeResolutionReasonCodeType.BUYER_PAID_AUCTION_FEES.value(), DisputeResolutionReasonCodeType.BUYER_PAID_AUCTION_FEES),
      new ControlTagItem(DisputeResolutionReasonCodeType.SELLER_RECEIVED_PAYMENT.value(), DisputeResolutionReasonCodeType.SELLER_RECEIVED_PAYMENT),
      new ControlTagItem(DisputeResolutionReasonCodeType.OTHER_RESOLUTION.value(), DisputeResolutionReasonCodeType.OTHER_RESOLUTION)
  };
  JLabel jLabel7 = new JLabel();
  Border border1;
  Border border2;
  JLabel jLabel10 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JTextField txteBayTime = new JTextField();

  public DialogSellerReverseDispute(Frame frame, String title, boolean modal) {
      super(frame, title, modal);
    try {
      jbInit();
      pack();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogSellerReverseDispute() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    border1 = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),BorderFactory.createEmptyBorder(0,5,0,0));
    border2 = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),BorderFactory.createEmptyBorder(0,5,0,0));
    this.setModal(true);
    this.setTitle("eBay SDK for Java - SellerReverseDispute");
    jPanel1.setLayout(borderLayout2);
    jPanel3.setLayout(gridBagLayout2);

    jLabel23.setText("CallStatus:");
    txtCallStatus.setBackground(UIManager.getColor("Button.background"));
    txtCallStatus.setText("                           ");
    jPanel2.setLayout(gridBagLayout1);
    jLabel1.setText("DisputeID:");
    jLabel2.setText("    ");
    txtDisputeId.setMinimumSize(new Dimension(100, 21));
    txtDisputeId.setPreferredSize(new Dimension(100, 21));
    jLabel4.setText("DisputeResolutionReason:");
    jLabel5.setText("       ");
    jLabel3.setText("          ");
    jPanel4.setLayout(gridBagLayout3);
    btnSellerReverseDispute.setText("SellerReverseDispute");
    btnSellerReverseDispute.addActionListener(new DialogSellerReverseDispute_btnSellerReverseDispute_actionAdapter(this));
    jLabel6.setText("    ");
    jLabel7.setToolTipText("");
    jLabel7.setText("    ");
    jPanel3.setBorder(border2);
    jLabel10.setText("        ");
    jLabel9.setText("eBayTime:");
    jLabel11.setText("");
    txteBayTime.setBackground(UIManager.getColor("Button.background"));
    txteBayTime.setPreferredSize(new Dimension(120, 21));
    txteBayTime.setText("");
    cbxDisputeResolutionReason.setMaximumSize(new Dimension(32767, 32767));
    cbxDisputeResolutionReason.setMinimumSize(new Dimension(100, 21));
    cbxDisputeResolutionReason.setPreferredSize(new Dimension(100, 21));
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jLabel23,              new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jLabel6,       new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(txtCallStatus,    new GridBagConstraints(2, 2, 1, 2, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 26, 0));
    jPanel3.add(jLabel10,   new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jLabel9,   new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(txteBayTime,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel2.add(jLabel1,    new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel2,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtDisputeId,   new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel3,  new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel4,   new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel5,  new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(cbxDisputeResolutionReason,   new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel7, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel4.add(btnSellerReverseDispute, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.getContentPane().add(jLabel11, BorderLayout.EAST);

    ComboBoxModel dataModel = new DefaultComboBoxModel(DialogSellerReverseDispute.reasons);
    this.cbxDisputeResolutionReason.setModel(dataModel);
    this.cbxDisputeResolutionReason.setSelectedIndex(0);

    jPanel2.setPreferredSize(new Dimension(360, 110));
    jPanel3.setPreferredSize(new Dimension(360, 90));
    jPanel4.setPreferredSize(new Dimension(360, 60));
    this.setSize(new Dimension(360, 260));
    this.setResizable(false);
  }

  void btnSellerReverseDispute_actionPerformed(ActionEvent e)
  {
    try
    {
      String disputeId = this.txtDisputeId.getText().trim();
      if(disputeId.length() == 0 ) {
        throw new Exception("Please enter Dispute ID first.");
      }

      int idx = this.cbxDisputeResolutionReason.getSelectedIndex();
      ControlTagItem reason = DialogSellerReverseDispute.reasons[idx];
      DisputeResolutionReasonCodeType drrct = (DisputeResolutionReasonCodeType) reason.Tag;

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      SellerReverseDisputeCall api = new SellerReverseDisputeCall(this.apiContext);
      api.setDetailLevel(detailLevels);
      api.setDisputeID(disputeId);
      api.setDisputeResolutionReason(drrct);
      SellerReverseDisputeResponseType resp = api.sellerReverseDispute();
      Date dt = resp.getTimestamp().getTime();
      this.txteBayTime.setText(eBayUtil.toAPITimeString(dt));
      this.txtCallStatus.setText(resp.getAck().value());
    }
    catch(Exception ex)
    {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogSellerReverseDispute_btnSellerReverseDispute_actionAdapter implements java.awt.event.ActionListener {
  DialogSellerReverseDispute adaptee;

  DialogSellerReverseDispute_btnSellerReverseDispute_actionAdapter(DialogSellerReverseDispute adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnSellerReverseDispute_actionPerformed(e);
  }
}
