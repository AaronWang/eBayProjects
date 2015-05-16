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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetUserCall;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.SellerGuaranteeLevelCodeType;
import com.ebay.soap.eBLBaseComponents.UserType;
import com.ebay.soap.eBLBaseComponents.VATStatusCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */

public class DialogGetUser extends JDialog {
  private ApiContext apiContext;

  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();

  JPanel panel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JTextField txtUserID = new JTextField();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();

  JPanel jPanel10 = new JPanel();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel14 = new JPanel();

  JTextField txtItemID = new JTextField();
  JLabel jLabel2 = new JLabel();
  JPanel jPanel5 = new JPanel();
  JButton btnGetUser = new JButton();
  JPanel jPanel1 = new JPanel();
  JTextField txtEmail = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtRegDate = new JTextField();
  JTextField txtFeedbackPrivate = new JTextField();
  JTextField txtFeedbackStore = new JTextField();
  JTextField txtNewUser = new JTextField();
  JTextField txtIDVerified = new JTextField();
  JTextField txtUserIDChanged = new JTextField();
  JLabel jLabel9 = new JLabel();
  JTextField txtUserIDLastChanged = new JTextField();
  JTextField txtFeedbackScore = new JTextField();
  JTextField txtSellerGuaranteeLevel = new JTextField();
  JTextField txtVATStatus = new JTextField();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel24 = new JLabel();
  JLabel jLabel25 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel15 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JTextField txtEIAS = new JTextField();

  public DialogGetUser(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetUser() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jLabel1.setText("UserID:");
    txtItemID.setPreferredSize(new Dimension(120, 21));
    txtItemID.setText("");
    jLabel2.setText("ItemID:");
    btnGetUser.setText("GetUser");
    btnGetUser.addActionListener(new DialogGetUser_btnGetUser_actionAdapter(this));
    txtUserID.setPreferredSize(new Dimension(120, 21));
    txtUserID.setText("");

//    jPanel1.setLayout(gridBagLayout1);
    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    jPanel1.setLayout(borderLayout2);
    jPanel12.setPreferredSize(new Dimension(10, 50));
    jPanel12.setLayout(borderLayout3);
    jPanel15.setPreferredSize(new Dimension(10, 10));
    jPanel15.setLayout(borderLayout4);
    jPanel8.setPreferredSize(new Dimension(10, 15));
    jLabel7.setText("      EIAS:  ");
    jLabel8.setText("       ");
    txtEIAS.setBackground(UIManager.getColor("Button.background"));
    txtEIAS.setText("");
    jPanel11.setPreferredSize(new Dimension(10, 1));
    txtEmail.setMinimumSize(new Dimension(120, 21));
    txtUserIDChanged.setMinimumSize(new Dimension(120, 21));
    txtUserIDLastChanged.setMinimumSize(new Dimension(120, 21));
    txtRegDate.setMinimumSize(new Dimension(120, 21));
    txtFeedbackPrivate.setMinimumSize(new Dimension(120, 21));
    txtFeedbackScore.setMinimumSize(new Dimension(120, 21));
    txtNewUser.setMinimumSize(new Dimension(120, 21));
    txtIDVerified.setMinimumSize(new Dimension(120, 21));
    txtSellerGuaranteeLevel.setMinimumSize(new Dimension(120, 21));
    txtVATStatus.setMinimumSize(new Dimension(120, 21));
    jPanel1.add(jPanel11, BorderLayout.NORTH);
    jPanel1.add(jPanel12, BorderLayout.SOUTH);
    jPanel12.add(jPanel6, BorderLayout.WEST);
    jPanel12.add(jPanel7, BorderLayout.EAST);
    jPanel12.add(jPanel8, BorderLayout.SOUTH);
    jPanel12.add(jPanel9, BorderLayout.NORTH);
    jPanel12.add(jPanel15, BorderLayout.CENTER);
    jPanel15.add(jLabel7, BorderLayout.WEST);
    jPanel15.add(jLabel8, BorderLayout.EAST);
    jPanel15.add(txtEIAS, BorderLayout.CENTER);
    jPanel1.add(jPanel13, BorderLayout.WEST);
    jPanel1.add(jPanel14, BorderLayout.EAST);
    jPanel1.add(jPanel10, BorderLayout.CENTER);
    jPanel10.setLayout(gridBagLayout1);

    txtEmail.setPreferredSize(new Dimension(120, 21));
    txtEmail.setToolTipText("");
    txtEmail.setEditable(false);
    txtEmail.setText("");
    txtEmail.setHorizontalAlignment(SwingConstants.LEADING);
    jLabel3.setOpaque(false);
    jLabel3.setPreferredSize(new Dimension(60, 15));
    jLabel3.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel3.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel3.setText("Email:");
    txtRegDate.setPreferredSize(new Dimension(120, 21));
    txtRegDate.setEditable(false);
    txtRegDate.setText("");
    txtFeedbackPrivate.setPreferredSize(new Dimension(120, 21));
    txtFeedbackPrivate.setToolTipText("");
    txtFeedbackPrivate.setEditable(false);
    txtFeedbackPrivate.setMargin(new Insets(1, 1, 1, 1));
    txtFeedbackPrivate.setSelectedTextColor(Color.white);
    txtFeedbackPrivate.setText("");
    txtFeedbackScore.setEnabled(true);
    txtFeedbackScore.setPreferredSize(new Dimension(80, 21));
    txtFeedbackScore.setEditable(false);
    txtFeedbackScore.setText("");
    txtNewUser.setPreferredSize(new Dimension(120, 21));
    txtNewUser.setEditable(false);
    txtNewUser.setText("");
    txtIDVerified.setPreferredSize(new Dimension(120, 21));
    txtIDVerified.setEditable(false);
    txtIDVerified.setText("");
    jLabel9.setMinimumSize(new Dimension(81, 15));
    jLabel9.setPreferredSize(new Dimension(89, 15));
    jLabel9.setVerifyInputWhenFocusTarget(true);
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText("UserIDChanged ?");
    txtUserIDChanged.setEnabled(true);
    txtUserIDChanged.setPreferredSize(new Dimension(120, 21));
    txtUserIDChanged.setEditable(false);
    txtUserIDChanged.setText("");
    txtUserIDLastChanged.setOpaque(true);
    txtUserIDLastChanged.setPreferredSize(new Dimension(120, 21));
    txtUserIDLastChanged.setEditable(false);
    txtUserIDLastChanged.setText("");
    txtFeedbackScore.setText("");
    txtFeedbackScore.setSelectedTextColor(Color.white);
    txtFeedbackScore.setMargin(new Insets(1, 1, 1, 1));
    txtFeedbackScore.setEditable(false);
    txtFeedbackScore.setToolTipText("");
    txtFeedbackScore.setPreferredSize(new Dimension(120, 21));
    this.setTitle("eBay SDK for Java - GetUser");
    txtSellerGuaranteeLevel.setBackground(UIManager.getColor("Button.background"));
    txtSellerGuaranteeLevel.setDebugGraphicsOptions(0);
    txtSellerGuaranteeLevel.setPreferredSize(new Dimension(120, 21));
    txtSellerGuaranteeLevel.setText("");
    txtVATStatus.setBackground(UIManager.getColor("Button.background"));
    txtVATStatus.setPreferredSize(new Dimension(120, 21));
    txtVATStatus.setText("");
    jLabel13.setText("    ");
    jLabel14.setText("    ");
    jLabel15.setText("        ");
    jLabel16.setText("    ");
    jLabel17.setText("    ");
    jLabel18.setText("IDLastChanged:");
    jLabel19.setText("RegistrationDate:");
    jLabel20.setText("    ");
    jLabel21.setText("FeedBackPrivate ?");
    jLabel22.setText("Feedback Score:");
    jLabel23.setText("    ");
    jLabel24.setText("New User ?");
    jLabel25.setText("IDVerified ?");
    jLabel4.setText("    ");
    jLabel5.setText("SellerGuaranteeLevel:");
    jLabel6.setText("VATStatus:");

    getContentPane().add(panel1);
    panel1.add(jPanel2, BorderLayout.NORTH);

    jPanel5.add(btnGetUser, null);
    panel1.add(jPanel1,  BorderLayout.CENTER);
    jPanel10.add(jLabel3,     new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel13,    new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(txtEmail,   new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel9,    new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel14,  new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(txtUserIDChanged,  new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel15, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel16, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel17,  new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel18,  new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(txtUserIDLastChanged, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel19,  new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(txtRegDate, new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel20, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel21,  new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(txtFeedbackPrivate, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel22,  new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(txtFeedbackScore, new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel23, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel24,  new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(txtNewUser, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel25,  new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(txtIDVerified, new GridBagConstraints(6, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel4, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel5,  new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(txtSellerGuaranteeLevel, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(txtVATStatus,  new GridBagConstraints(6, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jLabel6, new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jPanel4, null);
    jPanel4.add(jLabel1, null);
    jPanel4.add(txtUserID, null);
    jPanel2.add(jPanel3, null);
    jPanel3.add(jLabel2, null);
    jPanel3.add(txtItemID, null);
    jPanel2.add(jPanel5, null);
    jPanel1.setPreferredSize(new Dimension(500, 280));
    jPanel2.setPreferredSize(new Dimension(500, 50));
    this.setSize(new Dimension(550, 310));
  }

  void btnGetUser_actionPerformed(ActionEvent e)
  {
    try
    {
      GetUserCall api = new GetUserCall(this.apiContext);

      // Set detail level.
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL
      };
      api.setDetailLevel(detailLevels);

      if (this.txtUserID.getText().length() > 0)
        api.setUserID(this.txtUserID.getText());

      if (this.txtItemID.getText().length() > 0)
      {
        String itemId = this.txtItemID.getText();
        api.setItemID(itemId);
      }

      // Call eBay.
      UserType user = api.getUser();

      // Display result.
      this.txtEmail.setText(user.getEmail());
      this.txtUserIDChanged.setText(user.isUserIDChanged().toString());
      this.txtUserIDLastChanged.setText( eBayUtil.toAPITimeString(user.getUserIDLastChanged().getTime()));
      this.txtRegDate.setText(eBayUtil.toAPITimeString(user.getRegistrationDate().getTime()));
      Boolean feedBackPrivate = user.isFeedbackPrivate();
      this.txtFeedbackPrivate.setText(feedBackPrivate != null ? feedBackPrivate.toString() : "false");
      this.txtFeedbackScore.setText(user.getFeedbackScore().toString());
      this.txtNewUser.setText(user.isNewUser().toString());
      this.txtIDVerified.setText(user.isIDVerified().toString());
      SellerGuaranteeLevelCodeType level = user.getSellerInfo().getSellerGuaranteeLevel();
      this.txtSellerGuaranteeLevel.setText(level.value());
      VATStatusCodeType vat = user.getVATStatus();
      if (vat != null) {
        this.txtVATStatus.setText(vat.value());
      }
      this.txtEIAS.setText(user.getEIASToken());
    }
    catch(Exception ex)
    {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGetUser_btnGetUser_actionAdapter implements java.awt.event.ActionListener {
  DialogGetUser adaptee;

  DialogGetUser_btnGetUser_actionAdapter(DialogGetUser adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetUser_actionPerformed(e);
  }
}
