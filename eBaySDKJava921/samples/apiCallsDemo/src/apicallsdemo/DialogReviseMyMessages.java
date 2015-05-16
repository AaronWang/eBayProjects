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
import javax.swing.SwingConstants;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.ReviseMyMessagesCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
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
public class DialogReviseMyMessages extends JDialog {
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
  JPanel jPanelFolderID = new JPanel();
  JPanel jPanelReadState = new JPanel();
  JPanel jPanelFlaggedState = new JPanel();
  JComboBox cbxReadState = new JComboBox();
  JLabel jLabel6 = new JLabel();
  JComboBox cbxFlagged = new JComboBox();
  JLabel jLabel7 = new JLabel();
  JTextField txtToFolderID = new JTextField();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();

  private void initReadControl()
  {
    // Initialize combo box.
    Object[] list = new Object[] {
        new ControlTagItem("No change", null),
        new ControlTagItem("Read", Boolean.TRUE),
        new ControlTagItem("Unread", Boolean.FALSE),
    };
    ComboBoxModel dataModel = new DefaultComboBoxModel(list);
    this.cbxReadState.setModel(dataModel);
    this.cbxReadState.setSelectedIndex(0);
  }

  private void initFlagControl()
  {
    // Initialize combo box.
    Object[] list = new Object[] {
        new ControlTagItem("No change", null),
        new ControlTagItem("Flagged", Boolean.TRUE),
        new ControlTagItem("Unflagged", Boolean.FALSE),
    };
    ComboBoxModel dataModel = new DefaultComboBoxModel(list);
    this.cbxFlagged.setModel(dataModel);
    this.cbxFlagged.setSelectedIndex(0);
  }

  public DialogReviseMyMessages(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      this.initReadControl();
      this.initFlagControl();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogReviseMyMessages() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setMaximumSize(new Dimension(129, 25));
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(148, 25));
    btnExecuteAPI.setText("ReviseMyMessages");
    btnExecuteAPI.addActionListener(new DialogReviseMyMessages_btnExecuteAPI_actionAdapter(this));
    jPanel5.setLayout(borderLayout5);
    jPanel6.setPreferredSize(new Dimension(143, 40));
    jPanel6.setLayout(borderLayout4);
    jPanel5.setOpaque(true);
    jPanel5.setPreferredSize(new Dimension(10, 160));
    jPanel7.setLayout(gridLayout1);
    gridLayout1.setColumns(1);
    gridLayout1.setHgap(5);
    gridLayout1.setRows(5);
    gridLayout1.setVgap(5);
    jPanel7.setPreferredSize(new Dimension(114, 80));
    jLabel3.setText("Please enter list of alert IDs and message IDs that you wish to revise.");
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
    btnGetMyMessages.addActionListener(new DialogReviseMyMessages_btnGetMyMessages_actionAdapter(this));
    jLabel6.setPreferredSize(new Dimension(90, 15));
    jLabel6.setText("Read State:");
    jLabel7.setMinimumSize(new Dimension(69, 15));
    jLabel7.setPreferredSize(new Dimension(90, 15));
    jLabel7.setText("Flagged State:");
    jLabel8.setMinimumSize(new Dimension(84, 15));
    jLabel8.setPreferredSize(new Dimension(90, 15));
    jLabel8.setText("Move to folder ID:");
    txtToFolderID.setPreferredSize(new Dimension(100, 21));
    txtToFolderID.setText("");
    cbxReadState.setPreferredSize(new Dimension(100, 21));
    cbxFlagged.setPreferredSize(new Dimension(100, 21));
    jLabel9.setText("(blank means no change)");
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
    jPanel7.add(jPanelFolderID, null);
    jPanelFolderID.add(jLabel8, null);
    jPanelFolderID.add(txtToFolderID, null);
    jPanelFolderID.add(jLabel9, null);
    jPanelMessageIDs.add(jLabel2, null);
    jPanelMessageIDs.add(txtMessageIDs, null);
    jPanelMessageIDs.add(jLabel5, null);
    jPanel5.add(jPanel8, BorderLayout.NORTH);
    jPanel8.add(jLabel3, null);
    jPanel8.add(btnGetMyMessages, null);


    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel7.add(jPanelReadState, null);
    jPanelReadState.add(jLabel6, null);
    jPanelReadState.add(cbxReadState, null);
    jPanel7.add(jPanelFlaggedState, null);
    jPanelFlaggedState.add(jLabel7, null);
    jPanelFlaggedState.add(cbxFlagged, null);

    jPanel1.setPreferredSize(new Dimension(800, 220));
    this.setSize(new Dimension(649, 271));
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    FrameDemo fd = (FrameDemo)this.getParent();

    try
    {
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_HEADERS,
          DetailLevelCodeType.RETURN_SUMMARY
      };

      ReviseMyMessagesCall api = new ReviseMyMessagesCall(this.apiContext);
      api.setDetailLevel(detailLevels);

      // Save alert ID list.
      String[] alertIDs = FrameDemo.getAllertIDFromTextBox(this.txtAlertIDs);
      if( alertIDs != null )
          api.setAlertIDs(alertIDs);

      // Save message ID list.
      String[] msgIDs = FrameDemo.getMessageIDFromTextBox(this.txtMessageIDs);
      if( msgIDs != null )
          api.setMessageIDs(msgIDs);

      // Folder ID
      String t = this.txtToFolderID.getText();
      if( t.length() > 0 )
        api.setFolderID(new Long(t));

      // Read state
      ControlTagItem ct = (ControlTagItem)this.cbxReadState.getSelectedItem();
      if( ct.Tag != null )
        api.setRead((Boolean)ct.Tag);

      // Flagged state
      ct = (ControlTagItem)this.cbxFlagged.getSelectedItem();
      if (ct.Tag != null)
        api.setFlagged((Boolean)ct.Tag);

      api.reviseMyMessages();

      fd.showInfoMessage("The specified alerts and messages have been revised successfully!");
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

class DialogReviseMyMessages_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogReviseMyMessages adaptee;

  DialogReviseMyMessages_btnExecuteAPI_actionAdapter(DialogReviseMyMessages adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}

class DialogReviseMyMessages_btnGetMyMessages_actionAdapter implements java.awt.event.ActionListener {
  DialogReviseMyMessages adaptee;

  DialogReviseMyMessages_btnGetMyMessages_actionAdapter(DialogReviseMyMessages adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetMyMessages_actionPerformed(e);
  }
}
