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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.DeleteMyMessagesCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;

/**
 * Demonstrate API DeleteMyMessages.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogDeleteMyMessages extends JDialog {
  private ApiContext apiContext = new ApiContext();

  //
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();

  JPanel panel1 = new JPanel();

  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JButton btnExecuteAPI = new JButton();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel15 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JLabel jLabel3 = new JLabel();
  JPanel jPanelAlertIDs = new JPanel();
  JPanel jPanelMessageIDs = new JPanel();
  JTextField txtAlertIDs = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtMessageIDs = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JButton btnGetMyMessages = new JButton();

  public DialogDeleteMyMessages(Frame frame, String title, boolean modal) {
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

  public DialogDeleteMyMessages() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setMaximumSize(new Dimension(129, 25));
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(128, 25));
    btnExecuteAPI.setText("DeleteMyMessages");
    btnExecuteAPI.addActionListener(new DialogDeleteMyMessages_btnExecuteAPI_actionAdapter(this));
    jPanel5.setLayout(borderLayout5);
    jPanel6.setPreferredSize(new Dimension(143, 40));
    jPanel6.setLayout(borderLayout4);
    jPanel5.setOpaque(true);
    jPanel5.setPreferredSize(new Dimension(10, 160));
    jPanel7.setLayout(gridLayout1);
    gridLayout1.setColumns(1);
    gridLayout1.setHgap(5);
    gridLayout1.setRows(2);
    gridLayout1.setVgap(5);
    jPanel7.setPreferredSize(new Dimension(114, 80));
    jLabel3.setText("Please enter list of alert IDs and message IDs that you wish to delete.");
    txtAlertIDs.setPreferredSize(new Dimension(250, 21));
    txtAlertIDs.setText("");
    jLabel1.setPreferredSize(new Dimension(180, 15));
    jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel1.setText("Allert ID list (comma delimited):");
    txtMessageIDs.setMinimumSize(new Dimension(6, 21));
    txtMessageIDs.setPreferredSize(new Dimension(250, 21));
    txtMessageIDs.setToolTipText("");
    txtMessageIDs.setText("");
    jLabel2.setPreferredSize(new Dimension(180, 15));
    jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel2.setText("Message ID list (comma delimited):");
    jPanel1.setOpaque(true);
    jPanel1.setRequestFocusEnabled(true);
    jLabel4.setOpaque(false);
    jLabel4.setPreferredSize(new Dimension(143, 15));
    jLabel4.setRequestFocusEnabled(true);
    jLabel4.setText("(e.g., 1923858,1996435)");
    jLabel5.setRequestFocusEnabled(true);
    jLabel5.setText("(e.g., 101606583,101606523)");
    panel1.setPreferredSize(new Dimension(680, 400));
    panel1.setRequestFocusEnabled(true);
    btnGetMyMessages.setText("View Messages...");
    btnGetMyMessages.addActionListener(new DialogDeleteMyMessages_btnGetMyMessages_actionAdapter(this));
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(btnExecuteAPI, null);
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(jPanel7, BorderLayout.CENTER);
    jPanelAlertIDs.add(jLabel1, null);
    jPanelAlertIDs.add(txtAlertIDs, null);
    jPanelAlertIDs.add(jLabel4, null);
    jPanel7.add(jPanelAlertIDs, null);
    jPanel7.add(jPanelMessageIDs, null);
    jPanelMessageIDs.add(jLabel2, null);
    jPanelMessageIDs.add(txtMessageIDs, null);
    jPanelMessageIDs.add(jLabel5, null);
    jPanel5.add(jPanel8, BorderLayout.NORTH);
    jPanel8.add(jLabel3, null);
    jPanel8.add(btnGetMyMessages, null);


    panel1.add(jPanel3, BorderLayout.SOUTH);

    jPanel1.setPreferredSize(new Dimension(800, 140));
    this.setSize(new Dimension(649, 179));
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    FrameDemo fd = (FrameDemo)this.getParent();

    try
    {
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_HEADERS,
          DetailLevelCodeType.RETURN_SUMMARY
      };

      DeleteMyMessagesCall api = new DeleteMyMessagesCall(this.apiContext);
      api.setDetailLevel(detailLevels);

      // Save alert ID list.
      String[] alertIDs = FrameDemo.getAllertIDFromTextBox(this.txtAlertIDs);
      if( alertIDs != null )
          api.setAlertIDs(alertIDs);

      // Save message ID list.
      String[] msgIDs = FrameDemo.getMessageIDFromTextBox(this.txtMessageIDs);
      if( msgIDs != null )
          api.setMessageIDs(msgIDs);

      api.deleteMyMessages();

      fd.showInfoMessage("The specified alerts and messages have been deleted successfully!");
    }
    catch (Exception ex) {
      fd.showErrorMessage(ex.getMessage());
    }
  }

  void btnGetMyMessages_actionPerformed(ActionEvent e) {
    FrameDemo fd = (FrameDemo)this.getParent();
    fd.getMyMessages(fd);
  }
}

class DialogDeleteMyMessages_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogDeleteMyMessages adaptee;

  DialogDeleteMyMessages_btnExecuteAPI_actionAdapter(DialogDeleteMyMessages adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}

class DialogDeleteMyMessages_btnGetMyMessages_actionAdapter implements java.awt.event.ActionListener {
  DialogDeleteMyMessages adaptee;

  DialogDeleteMyMessages_btnGetMyMessages_actionAdapter(DialogDeleteMyMessages adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetMyMessages_actionPerformed(e);
  }
}
