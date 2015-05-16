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
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.AddDisputeCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.DisputeExplanationCodeType;
import com.ebay.soap.eBLBaseComponents.DisputeReasonCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogAddDispute extends JDialog {
  private ApiContext apiContext = new ApiContext();

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtItemId = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField txtTransactionId = new JTextField();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JButton btnAddDispute = new JButton();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JComboBox cbxReason = new JComboBox();
  JComboBox cbxExplaination = new JComboBox();

  static ControlTagItem[] reasons = new ControlTagItem[] {
      new ControlTagItem(DisputeReasonCodeType.BUYER_HAS_NOT_PAID.value(), DisputeReasonCodeType.BUYER_HAS_NOT_PAID),
      new ControlTagItem(DisputeReasonCodeType.TRANSACTION_MUTUALLY_CANCELED.value(), DisputeReasonCodeType.TRANSACTION_MUTUALLY_CANCELED)
  };

  static ControlTagItem[] explanations = new ControlTagItem[] {
      new ControlTagItem(DisputeExplanationCodeType.BUYER_HAS_NOT_RESPONDED.value(), DisputeExplanationCodeType.BUYER_HAS_NOT_RESPONDED),
      new ControlTagItem(DisputeExplanationCodeType.BUYER_REFUSED_TO_PAY.value(), DisputeExplanationCodeType.BUYER_REFUSED_TO_PAY),
      new ControlTagItem(DisputeExplanationCodeType.BUYER_RETURNED_ITEM_FOR_REFUND.value(), DisputeExplanationCodeType.BUYER_RETURNED_ITEM_FOR_REFUND),
      new ControlTagItem(DisputeExplanationCodeType.UNABLE_TO_RESOLVE_TERMS.value(), DisputeExplanationCodeType.UNABLE_TO_RESOLVE_TERMS),
      new ControlTagItem(DisputeExplanationCodeType.BUYER_PURCHASING_MISTAKE.value(), DisputeExplanationCodeType.BUYER_PURCHASING_MISTAKE),
      new ControlTagItem(DisputeExplanationCodeType.SHIP_COUNTRY_NOT_SUPPORTED.value(), DisputeExplanationCodeType.SHIP_COUNTRY_NOT_SUPPORTED),
      new ControlTagItem(DisputeExplanationCodeType.SHIPPING_ADDRESS_NOT_CONFIRMED.value(), DisputeExplanationCodeType.SHIPPING_ADDRESS_NOT_CONFIRMED),
      new ControlTagItem(DisputeExplanationCodeType.PAYMENT_METHOD_NOT_SUPPORTED.value(), DisputeExplanationCodeType.PAYMENT_METHOD_NOT_SUPPORTED),
      new ControlTagItem(DisputeExplanationCodeType.BUYER_NO_LONGER_REGISTERED.value(), DisputeExplanationCodeType.BUYER_NO_LONGER_REGISTERED),
      new ControlTagItem(DisputeExplanationCodeType.OTHER_EXPLANATION.value(),DisputeExplanationCodeType.OTHER_EXPLANATION)
  };
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  JLabel jLabel19 = new JLabel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JTextField txtDisputeId = new JTextField();

  public DialogAddDispute(Frame frame, String title, boolean modal) {
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

  public DialogAddDispute() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setModal(true);
    this.setTitle("eBay SDK for Java - AddDispute");

    this.setSize(new Dimension(350, 420));

    jPanel1.setLayout(borderLayout2);
    jPanel2.setLayout(gridBagLayout1);
    jLabel1.setRequestFocusEnabled(true);
    jLabel1.setHorizontalAlignment(SwingConstants.LEADING);
    jLabel1.setHorizontalTextPosition(SwingConstants.RIGHT);
    jLabel1.setText("ItemID:");
    jLabel3.setHorizontalTextPosition(SwingConstants.RIGHT);
    jLabel3.setText("TransactionID:");
    jLabel5.setFont(new java.awt.Font("MS Sans Serif", 0, 11));
    jLabel5.setHorizontalAlignment(SwingConstants.LEADING);
    jLabel5.setHorizontalTextPosition(SwingConstants.RIGHT);
    jLabel5.setText("Reason:");
    jLabel6.setRequestFocusEnabled(true);
    jLabel6.setText("          ");
    jLabel7.setText("");
    jLabel2.setText("");
    jLabel4.setText("");
    jLabel8.setText("   ");
    jLabel9.setText("   ");
    jLabel10.setText("   ");
    jPanel3.setLayout(borderLayout3);

    jLabel11.setText("  ");
    jLabel12.setText("  ");
    jLabel14.setText("");
    jLabel13.setText("  ");
    jLabel15.setText("     ");
    btnAddDispute.setText("AddDispute");
    btnAddDispute.addActionListener(new DialogAddDispute_btnAddDispute_actionAdapter(this));
    jLabel16.setText("      ");
    jLabel17.setHorizontalTextPosition(SwingConstants.RIGHT);
    jLabel17.setText(" Explanation:");
    jLabel18.setText("    ");
    jLabel19.setText("    ");
    jPanel6.setLayout(gridBagLayout2);
    jLabel20.setBorder(null);
    jLabel20.setText("DisputeID:");
    jLabel21.setText("          ");
    txtDisputeId.setBackground(Color.lightGray);
    txtDisputeId.setMinimumSize(new Dimension(157, 21));
    txtDisputeId.setPreferredSize(new Dimension(157, 21));
    txtDisputeId.setRequestFocusEnabled(true);
    jPanel4.setBorder(null);
    jPanel6.setBorder(BorderFactory.createEtchedBorder());
    jPanel5.setMinimumSize(new Dimension(10, 1));
    jPanel5.setPreferredSize(new Dimension(10, 1));
    txtItemId.setPreferredSize(new Dimension(80, 21));
    txtTransactionId.setPreferredSize(new Dimension(80, 21));
    jPanel2.add(jLabel2,     new GridBagConstraints(2, 1, 3, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel4,     new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel6,     new GridBagConstraints(4, 5, 1, 3, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel7,     new GridBagConstraints(0, 8, 5, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel8,     new GridBagConstraints(0, 9, 3, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel9,     new GridBagConstraints(4, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel10,     new GridBagConstraints(5, 9, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel11,     new GridBagConstraints(0, 2, 2, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel12,     new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel13,     new GridBagConstraints(0, 5, 2, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel14,     new GridBagConstraints(5, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel15,     new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel1,      new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtItemId,      new GridBagConstraints(5, 1, 2, 2, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 51, 0));
    jPanel2.add(txtTransactionId,      new GridBagConstraints(5, 4, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(-5, 0, 5, 0), 51, 0));
    jPanel2.add(jLabel3,          new GridBagConstraints(1, 4, 3, 1, 0.0, 0.0
            ,GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(-5, -6, 5, 0), 0, 0));
    jPanel2.add(jLabel5,        new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 7, 0, 0), 0, 0));
    jPanel2.add(jLabel17,        new GridBagConstraints(1, 11, 3, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 20, 0));
    jPanel2.add(jLabel18,    new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(cbxReason,    new GridBagConstraints(5, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(cbxExplaination,   new GridBagConstraints(5, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel16,  new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel19, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel3, BorderLayout.SOUTH);

    jPanel3.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(btnAddDispute, null);
    jPanel3.add(jPanel5, BorderLayout.SOUTH);
    jPanel3.add(jPanel6, BorderLayout.CENTER);
    jPanel6.add(jLabel20,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel21, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtDisputeId, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    jPanel1.add(jPanel2, BorderLayout.NORTH);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);

    ComboBoxModel dataModel = new DefaultComboBoxModel(DialogAddDispute.reasons);
    this.cbxReason.setModel(dataModel);
    this.cbxReason.setSelectedIndex(0);

    dataModel = new DefaultComboBoxModel(DialogAddDispute.explanations);
    this.cbxExplaination.setModel(dataModel);
    this.cbxExplaination.setSelectedIndex(0);

    jPanel2.setPreferredSize(new Dimension(320, 160));
    jPanel3.setPreferredSize(new Dimension(320, 85));
    jPanel4.setPreferredSize(new Dimension(320, 35));
    jPanel6.setPreferredSize(new Dimension(320, 50));
    this.setSize(new Dimension(320, 245));
    this.setResizable(false);
  }

  void btnAddDispute_actionPerformed(ActionEvent e)
  {
    try {
      this.txtDisputeId.setText(" ");

      String itemId = this.txtItemId.getText().trim();
      String transactionId = this.txtTransactionId.getText().trim();

      if ( itemId.length() == 0 && transactionId.length() == 0) {
        throw new Exception("Please enter either an ItemId or TransactionId.");
      }

      int idx = this.cbxReason.getSelectedIndex();
      ControlTagItem reason = DialogAddDispute.reasons[idx];
      DisputeReasonCodeType drct = (DisputeReasonCodeType) reason.Tag;
      idx = this.cbxExplaination.getSelectedIndex();
      ControlTagItem explanation = DialogAddDispute.explanations[idx];
      DisputeExplanationCodeType dect = (DisputeExplanationCodeType) explanation.Tag;

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      AddDisputeCall api = new AddDisputeCall(this.apiContext);
      api.setDetailLevel(detailLevels);
      api.setItemID(itemId);
      api.setTransactionID(transactionId);
      api.setDisputeExplanation(dect);
      api.setDisputeReason(drct);

      String id = api.addDispute();

      this.txtDisputeId.setText(id);
    }
    catch (Exception ex) {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogAddDispute_btnAddDispute_actionAdapter implements java.awt.event.ActionListener {
  DialogAddDispute adaptee;

  DialogAddDispute_btnAddDispute_actionAdapter(DialogAddDispute adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnAddDispute_actionPerformed(e);
  }
}
