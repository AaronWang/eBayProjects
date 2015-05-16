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
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetDisputeCall;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.DisputeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogGetDispute extends JDialog {
  private ApiContext apiContext = new ApiContext();

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
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
  JButton btnGetDispute = new JButton();
  JLabel jLabel17 = new JLabel();
  JTextField txtDisputeId = new JTextField();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel5 = new JLabel();
  BorderLayout borderLayout3 = new BorderLayout();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel24 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();

  public DialogGetDispute(Frame frame, String title, boolean modal) {
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

  public DialogGetDispute() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setModal(true);
    this.setTitle("eBay SDK for Java - GetDispute");

    this.setSize(new Dimension(350, 420));
    jPanel1.setLayout(borderLayout2);
    jPanel2.setLayout(gridBagLayout1);
    jLabel6.setRequestFocusEnabled(true);
    jLabel6.setText("          ");
    jLabel7.setText("");
    jLabel2.setText("");
    jLabel4.setText("");
    jPanel3.setLayout(borderLayout3);

    jLabel11.setText("  ");
    jLabel12.setText("  ");
    jLabel14.setText("");
    jLabel13.setText("  ");
    btnGetDispute.setText("GetDispute");
    btnGetDispute.addActionListener(new DialogGetDispute_btnGetDispute_actionAdapter(this));

    jLabel17.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel17.setText("DisputeID:        ");
    txtDisputeId.setPreferredSize(new Dimension(60, 21));
    jLabel20.setRequestFocusEnabled(true);
    jLabel20.setText("          ");
    jLabel21.setText("   ");
    jLabel1.setText("      ");
    jLabel3.setText("       ");
    jLabel5.setText("           ");
    jLabel19.setText("  ");
    jLabel22.setToolTipText("");
    jLabel22.setText("  ");
    jLabel23.setMaximumSize(new Dimension(12, 2));
    jLabel23.setMinimumSize(new Dimension(12, 2));
    jLabel23.setOpaque(false);
    jLabel23.setPreferredSize(new Dimension(12, 2));
    jLabel23.setIconTextGap(4);
    jLabel23.setText("    ");
    jLabel24.setMaximumSize(new Dimension(12, 2));
    jLabel24.setMinimumSize(new Dimension(12, 2));
    jLabel24.setPreferredSize(new Dimension(12, 2));
    jLabel24.setText("    ");
    jScrollPane1.getViewport().setBackground(Color.white);
    jPanel2.add(jLabel2,              new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel4,              new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel6,              new GridBagConstraints(1, 3, 1, 3, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel7,              new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel11,              new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel12,              new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel13,              new GridBagConstraints(0, 3, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel14,              new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(btnGetDispute,                    new GridBagConstraints(1, 5, 3, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 21, 0, 0), 70, 0));
    jPanel2.add(jLabel17,                     new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 30), 27, 0));
    jPanel2.add(txtDisputeId,                    new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 84, 0));
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jLabel19, BorderLayout.WEST);
    jPanel3.add(jLabel22, BorderLayout.EAST);
    jPanel3.add(jLabel23, BorderLayout.NORTH);
    jPanel3.add(jLabel24, BorderLayout.SOUTH);
    jPanel3.add(jScrollPane1, BorderLayout.CENTER);
    jPanel3.setBorder(BorderFactory.createEtchedBorder());

    jPanel1.add(jPanel2, BorderLayout.CENTER);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel2.add(jLabel1,          new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel3,         new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel5,        new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    jPanel2.setPreferredSize(new Dimension(320, 100));
    jPanel3.setPreferredSize(new Dimension(320, 220));
    jPanel1.setPreferredSize(new Dimension(320, 320));
    this.setSize(new Dimension(320, 320));
    this.setResizable(false);
  }

  void displayDispute(DisputeType dispute)
  {
    String[] columnNames = {
        "Name", "Value"};


    Object[] [] dataTable = {
        {"BuyerUserId", dispute.getBuyerUserID()},
        {"SellerUserId", dispute.getSellerUserID()},
        {"ItemId", dispute.getItem().getItemID()},
        {"TransactionId", dispute.getTransactionID()},
        {"Reason", dispute.getDisputeReason().value()},
        {"Explanation", dispute.getDisputeExplanation().value()},
        {"State", dispute.getDisputeState().value()},
        {"Status", dispute.getDisputeStatus().value()},
        {"CreditEligibility", dispute.getDisputeCreditEligibility().value()},
        {"CreatedTime", eBayUtil.toAPITimeString(dispute.getDisputeCreatedTime().getTime())},
        {"ModifiedTime", eBayUtil.toAPITimeString(dispute.getDisputeModifiedTime().getTime())}
    };

    JTable jTable1 = new JTable(dataTable, columnNames);
    this.jScrollPane1.getViewport().add(jTable1, null);
  }

  void btnGetDispute_actionPerformed(ActionEvent e) {
    try {
      String disputeId = this.txtDisputeId.getText().trim();
      if (disputeId.length() == 0) {
        throw new Exception("Please enter a valid DisputeID.");
      }

      GetDisputeCall api = new GetDisputeCall(this.apiContext);
      api.setDisputeID(disputeId);
      DisputeType dispute = api.getDispute();
      displayDispute(dispute);
    }
    catch(Exception ex)
    {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGetDispute_btnGetDispute_actionAdapter implements java.awt.event.ActionListener {
  DialogGetDispute adaptee;

  DialogGetDispute_btnGetDispute_actionAdapter(DialogGetDispute adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetDispute_actionPerformed(e);
  }
}
