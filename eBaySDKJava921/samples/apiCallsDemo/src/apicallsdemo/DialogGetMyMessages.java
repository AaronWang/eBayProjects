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
import java.awt.GridLayout;
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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetMyMessagesCall;
import com.ebay.sdk.helper.Utils;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.MyMessagesAlertType;
import com.ebay.soap.eBLBaseComponents.MyMessagesFolderType;
import com.ebay.soap.eBLBaseComponents.MyMessagesMessageType;

/**
 * Demonstrate API GetMyMessages.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogGetMyMessages extends JDialog {
  private ApiContext apiContext = new ApiContext();

  // Alerts related
  final static String[] alertColNames = new String[] {
    "ID", "Read", "Folder", "Sender", "Subject", "Recipient", "Created", "Priority", "ItemID", "Resolved" };

  final static int totalAlertColumns = alertColNames.length;

  // Alerts related
  final static String[] messageColNames = new String[] {
    "ID", "Read", "Flagged", "Folder", "Sender", "Subject", "Recipient", "Created", "ItemID" };

  final static int totalMessageColumns = messageColNames.length;

  //
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();
  BorderLayout borderLayout3 = new BorderLayout();

  JPanel panel1 = new JPanel();

  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JButton btnExecuteAPI = new JButton();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable tblAlerts = new JTable();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
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
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel14 = new JPanel();
  JLabel lblReturnedAlerts = new JLabel();
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel16 = new JPanel();
  JPanel jPanel17 = new JPanel();
  JLabel lblReturnedMessages = new JLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTable tblMyMessages = new JTable();
  JPanel jPanel18 = new JPanel();
  JPanel jPanelFolderID = new JPanel();
  JTextField txtFolderID = new JTextField();
  JLabel jLabel6 = new JLabel();

  public DialogGetMyMessages(Frame frame, String title, boolean modal) {
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

  public DialogGetMyMessages() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(115, 25));
    btnExecuteAPI.setText("GetMyMessages");
    btnExecuteAPI.addActionListener(new DialogGetMyMessages_btnExecuteAPI_actionAdapter(this));
    jPanel5.setLayout(borderLayout5);
    jPanel6.setPreferredSize(new Dimension(143, 40));
    jPanel6.setLayout(borderLayout4);
    jPanel5.setOpaque(true);
    jPanel5.setPreferredSize(new Dimension(10, 200));
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setPreferredSize(new Dimension(600, 150));
    jPanel7.setLayout(gridLayout1);
    gridLayout1.setColumns(1);
    gridLayout1.setHgap(5);
    gridLayout1.setRows(3);
    gridLayout1.setVgap(5);
    jPanel7.setPreferredSize(new Dimension(114, 80));
    jLabel3.setText("Enter list of alert IDs and message IDs that you want to retrieve. " +
    "Leave blank if you want to get all alterts and messages.");
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
    jPanel1.setRequestFocusEnabled(true);
    jLabel4.setOpaque(false);
    jLabel4.setPreferredSize(new Dimension(143, 15));
    jLabel4.setRequestFocusEnabled(true);
    jLabel4.setText("(e.g., 1923858,1996435)");
    jLabel5.setRequestFocusEnabled(true);
    jLabel5.setText("(e.g., 101606583,101606523)");
    panel1.setPreferredSize(new Dimension(680, 558));
    panel1.setRequestFocusEnabled(true);
    jPanel11.setLayout(borderLayout6);
    lblReturnedAlerts.setText("Alerts:");
    jPanel12.setLayout(borderLayout7);
    lblReturnedMessages.setText("MyMessages:");
    jScrollPane2.getViewport().setBackground(Color.white);
    jScrollPane2.setPreferredSize(new Dimension(600, 150));
    jPanel11.setPreferredSize(new Dimension(464, 190));
    jPanel12.setPreferredSize(new Dimension(464, 250));
    txtFolderID.setPreferredSize(new Dimension(80, 21));
    txtFolderID.setText("");
    jLabel6.setMinimumSize(new Dimension(45, 15));
    jLabel6.setPreferredSize(new Dimension(60, 15));
    jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel6.setText("Folder ID:");
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
    jPanel7.add(jPanelFolderID, null);
    jPanel7.add(jPanelAlertIDs, null);
    jPanel7.add(jPanelMessageIDs, null);
    jPanelFolderID.add(jLabel6, null);
    jPanelFolderID.add(txtFolderID, null);
    jPanelMessageIDs.add(jLabel2, null);
    jPanelMessageIDs.add(txtMessageIDs, null);
    jPanelMessageIDs.add(jLabel5, null);
    jPanel5.add(jPanel8, BorderLayout.NORTH);
    jPanel8.add(jLabel3, null);

    panel1.add(jPanel2, BorderLayout.CENTER);
    jPanel2.setLayout(borderLayout3);
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.add(jPanel11, BorderLayout.NORTH);
    jPanel11.add(jPanel13,  BorderLayout.NORTH);
    jPanel13.add(lblReturnedAlerts, null);
    jPanel11.add(jPanel14, BorderLayout.CENTER);
    jPanel14.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(tblAlerts, null);
    jPanel2.add(jPanel12,  BorderLayout.CENTER);
    jPanel12.add(jPanel16,  BorderLayout.NORTH);
    jPanel16.add(lblReturnedMessages, null);
    jPanel12.add(jPanel17, BorderLayout.CENTER);
    jPanel17.add(jScrollPane2, null);
    jPanel2.add(jPanel18,  BorderLayout.SOUTH);
    jScrollPane2.getViewport().add(tblMyMessages, null);

    panel1.add(jPanel3, BorderLayout.SOUTH);

    jPanel1.setPreferredSize(new Dimension(800, 150));
    this.setSize(new Dimension(658, 567));
  }

  static String getFolderDispName(MyMessagesFolderType folder)
  {
    if( folder == null )
      return "";

    if( folder.getFolderName() != null && folder.getFolderName().length() > 0 )
      return folder.getFolderName();
    return folder.getFolderID().toString();
  }

  static String[] alertToColumns(MyMessagesAlertType alert)
  {
    //"ID", "Read", "Folder", "Sender", "Subject", "Recipient", "Created", "Priority", "ItemID", "Resolved"

    String[] cols = new String[totalAlertColumns];

    int i = 0;
    cols[i++] = alert.getAlertID();
    cols[i++] = Utils.booleanToYesNo(alert.isRead());
    cols[i++] = getFolderDispName(alert.getFolder());
    cols[i++] = alert.getSender();
    cols[i++] = alert.getSubject();
    cols[i++] = alert.getRecipientUserID();
    cols[i++] = alert.getCreationDate() == null ? "" : eBayUtil.toAPITimeString(
      alert.getCreationDate().getTime());
    cols[i++] = alert.getPriority();
    cols[i++] = alert.getItemID() == null ? "" : alert.getItemID();
    cols[i++] = alert.getResolutionDate() == null ? "" : eBayUtil.toAPITimeString(
      alert.getResolutionDate().getTime());

    return cols;
  }

  static String[] messageToColumns(MyMessagesMessageType message)
  {
    //"ID", "Read", "Flagged", "Folder", "Sender", "Subject", "Recipient", "Created", "ItemID"

    String[] cols = new String[totalMessageColumns];

    int i = 0;
    cols[i++] = message.getMessageID();
    cols[i++] = Utils.booleanToYesNo(message.isRead());
    cols[i++] = Utils.booleanToYesNo(message.isFlagged());
    cols[i++] = getFolderDispName(message.getFolder());
    cols[i++] = message.getSender();
    cols[i++] = message.getSubject();
    cols[i++] = message.getRecipientUserID();
    cols[i++] = message.getCreationDate() == null ? "" : eBayUtil.toAPITimeString(
      message.getCreationDate().getTime());
    cols[i++] = message.getItemID() == null ? "" : message.getItemID();

    return cols;
  }

  private void displayAlerts(MyMessagesAlertType[] inAlerts)
  {
    final MyMessagesAlertType[] alerts = inAlerts;

    TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalAlertColumns;
      }

      public int getRowCount() {
        return alerts != null ? alerts.length : 0;
      }

      public String getColumnName(int columnIndex) {
        return alertColNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        MyMessagesAlertType alert = alerts[row];
        return alertToColumns(alert)[col];
      }
    };

    this.tblAlerts.setModel(dataModel);
  }

  private void displayMessages(MyMessagesMessageType[] inMessages)
  {
    final MyMessagesMessageType[] messages = inMessages;

    TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalMessageColumns;
      }

      public int getRowCount() {
        return messages != null ? messages.length : 0;
      }

      public String getColumnName(int columnIndex) {
        return messageColNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        MyMessagesMessageType msg = messages[row];
        return messageToColumns(msg)[col];
      }
    };

    this.tblMyMessages.setModel(dataModel);
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    try
    {
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_HEADERS,
          DetailLevelCodeType.RETURN_SUMMARY
      };

      GetMyMessagesCall api = new GetMyMessagesCall(this.apiContext);
      api.setDetailLevel(detailLevels);

      if( this.txtFolderID.getText().length() > 0 )
        api.setFolderID(Long.parseLong(this.txtFolderID.getText()));

      // Save alert ID list.
      String[] alertIDs = FrameDemo.getAllertIDFromTextBox(this.txtAlertIDs);
      if( alertIDs != null )
          api.setAlertIDs(alertIDs);

      // Save ,essage ID list.
      String[] msgIDs = FrameDemo.getMessageIDFromTextBox(this.txtMessageIDs);
      if( msgIDs != null )
          api.setMessageIDs(msgIDs);

      api.getMyMessages();

      // Display alerts.
      this.displayAlerts(api.getReturnedAlerts());

      // Display MyMessages
      this.displayMessages(api.getReturnedMyMessages());
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGetMyMessages_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogGetMyMessages adaptee;

  DialogGetMyMessages_btnExecuteAPI_actionAdapter(DialogGetMyMessages adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}
