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
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.VerifyAddSecondChanceItemCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogVerifyAddSecondChanceItem extends JDialog
{
  private ApiContext apiContext;

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JTextField jTextField4 = new JTextField();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel23 = new JLabel();
  JTextField jTextField5 = new JTextField();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel4 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtDisputeId = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JTextField txtDisputeResolutionReason = new JTextField();
  JLabel jLabel8 = new JLabel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JButton jButton2 = new JButton();
  JLabel jLabel6 = new JLabel();

  public DialogVerifyAddSecondChanceItem(Frame frame, String title, boolean modal) {
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

  public DialogVerifyAddSecondChanceItem() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setModal(true);
    this.setTitle("eBay SOAP SDK - VerifyAddSecondChanceItem");

    this.setSize(new Dimension(350, 420));
//    this.getContentPane().setLayout(borderLayout1);
    //  this.setResizable(false);

    jPanel1.setLayout(borderLayout2);
    jPanel3.setLayout(gridBagLayout2);


    jLabel19.setText("eBayTime:");
    jLabel20.setRequestFocusEnabled(true);
    jLabel20.setText("          ");
    jTextField4.setText("                           ");
    jLabel21.setText("   ");
    jLabel22.setText("      ");
    jLabel23.setText("CallStatus:");
    jTextField5.setText("                           ");
    jPanel2.setLayout(gridBagLayout1);
    jLabel1.setText("DisputeId:");
    jLabel2.setText("          ");
    txtDisputeId.setText("                                   ");
    jLabel4.setText("DisputeResolutionReason:");
    jLabel5.setText("       ");
    txtDisputeResolutionReason.setText("                                   ");
    jLabel3.setText("          ");
    jPanel4.setLayout(gridBagLayout3);
    jLabel8.setRequestFocusEnabled(true);
    jLabel8.setText("    ");
    jButton2.setText("VerifyAddSecondChanceItem");
    jButton2.addActionListener(new DialogVerifyAddSecondChanceItem_jButton2_actionAdapter(this));
    jLabel6.setText("    ");
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jLabel19,             new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 25, 0, 0), 28, 0));
    jPanel3.add(jLabel20,        new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jTextField4,         new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 26, 0));
    jPanel3.add(jLabel21,        new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jLabel22,        new GridBagConstraints(2, 3, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jLabel23,        new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jTextField5,             new GridBagConstraints(2, 5, 1, 2, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 26, 0));
    jPanel3.add(jLabel8,    new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jLabel6, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel2.add(jLabel1,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtDisputeId, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel5, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtDisputeResolutionReason, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel4.add(jButton2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    jPanel2.setPreferredSize(new Dimension(300, 110));
    jPanel3.setPreferredSize(new Dimension(300, 130));
    jPanel4.setPreferredSize(new Dimension(300, 25));
    jPanel1.setPreferredSize(new Dimension(320, 265));
    this.setSize(new Dimension(320, 265));
    this.setResizable(false);
  }

  void jButton2_actionPerformed(ActionEvent e)
  {
    try
    {
      String disputeId = this.txtDisputeId.getText();
      if(disputeId.length() == 0 )
        throw new Exception("Please enter Dispute ID first.");

      String disputeResolutionReason = this.txtDisputeResolutionReason.getText();

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      VerifyAddSecondChanceItemCall api = new VerifyAddSecondChanceItemCall(this.apiContext);
//      api.setDisputeID(this.txtDisputeId.getText());
//      api.setDisputeResolutionReason(this.txtDisputeResolutionReason.getText());
      api.setDetailLevel(detailLevels);
      api.verifyAddSecondChanceItem();

      /*
      // Display data in GUI.
      */
      }
    catch(Exception ex)
    {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogVerifyAddSecondChanceItem_jButton2_actionAdapter implements java.awt.event.ActionListener {
  DialogVerifyAddSecondChanceItem adaptee;

  DialogVerifyAddSecondChanceItem_jButton2_actionAdapter(DialogVerifyAddSecondChanceItem adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}
