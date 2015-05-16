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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetFeedbackCall;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.FeedbackDetailType;
import com.ebay.soap.eBLBaseComponents.PaginationType;

public class DialogGetFeedback extends JDialog {
  private ApiContext apiContext = new ApiContext();

  final static int totalColumns = 6;
  final String[] colNames = new String[] {
      "UserID", "UserScore", "ItemID", "Type", "Comment", "CommentTime"};

  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();
  BorderLayout borderLayout3 = new BorderLayout();

  JPanel panel1 = new JPanel();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();

  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JTextField txtUserID = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtStartingPage = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtItemsPerPage = new JTextField();
  JLabel jLabel3 = new JLabel();
  JPanel jPanel8 = new JPanel();
  JButton btnGetFeedback = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable tblFeedbacks = new JTable();

  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel14 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel7 = new JLabel();

  public DialogGetFeedback(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      //
      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetFeedback() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    jLabel1.setPreferredSize(new Dimension(50, 15));
    jLabel1.setVerifyInputWhenFocusTarget(true);
    jLabel1.setText("UserID:");
    txtUserID.setPreferredSize(new Dimension(80, 21));
    txtUserID.setText("");
    jPanel5.setLayout(gridBagLayout1);
    txtStartingPage.setMinimumSize(new Dimension(60, 21));
    txtStartingPage.setPreferredSize(new Dimension(60, 21));
    txtStartingPage.setText("1");
    jLabel2.setText("Starting page:");
    txtItemsPerPage.setOpaque(true);
    txtItemsPerPage.setPreferredSize(new Dimension(60, 21));
    txtItemsPerPage.setText("100");
    jLabel3.setText("Items Per page:");
    btnGetFeedback.setText("GetFeedback");
    btnGetFeedback.addActionListener(new DialogGetFeedback_btnGetFeedback_actionAdapter(this));
    jPanel3.setPreferredSize(new Dimension(10, 1));
    jPanel4.setPreferredSize(new Dimension(130, 40));
    jPanel4.setLayout(gridBagLayout2);
    jLabel4.setText("    ");
    jLabel6.setText("    ");
    jLabel5.setPreferredSize(new Dimension(45, 21));
    jLabel5.setText("");
    jScrollPane1.getViewport().setBackground(Color.white);
    jLabel7.setText("    ");
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(txtUserID,   new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel4.add(jLabel7,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel4.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(jLabel2,    new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(jLabel4,    new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(txtStartingPage,    new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(jLabel5,    new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(jLabel3,    new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(jLabel6,    new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel5.add(txtItemsPerPage,    new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panel1.add(jPanel2,  BorderLayout.CENTER);

    jPanel2.setLayout(borderLayout3);
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.add(jPanel11, BorderLayout.NORTH);
    jPanel2.add(jPanel12, BorderLayout.SOUTH);
    jPanel2.add(jPanel13, BorderLayout.WEST);
    jPanel2.add(jPanel14, BorderLayout.EAST);
    jPanel2.add(jScrollPane1, BorderLayout.CENTER);

    jScrollPane1.getViewport().add(tblFeedbacks, null);
    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel1.add(jPanel8,  BorderLayout.SOUTH);
    jPanel8.add(btnGetFeedback, null);

    jPanel5.setPreferredSize(new Dimension(400, 40));
    this.setSize(new Dimension(700, 400));
  }

  static String[] feedbackToColumns(FeedbackDetailType fd)
  {
    String[] cols = new String[totalColumns];
    int i = 0;
    cols[i++] = fd.getCommentingUser() == null ? "" : fd.getCommentingUser();
    cols[i++] = fd.getCommentingUserScore() == null ? "" : fd.getCommentingUserScore().toString();
    cols[i++] = fd.getItemID() == null ? "" : fd.getItemID();
    cols[i++] = fd.getCommentType() == null ? "" : fd.getCommentType().toString();
    cols[i++] = fd.getCommentText() == null ? "" : fd.getCommentText();
    cols[i++] = fd.getCommentTime() == null ? "" : eBayUtil.toAPITimeString(fd.getCommentTime().getTime());

    return cols;
  }

  void btnGetFeedback_actionPerformed(ActionEvent e) {
    try
    {
      GuiUtil.isTextControlFilled(this.txtUserID, "Please enter user ID.");

      GetFeedbackCall api = new GetFeedbackCall(this.apiContext);

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {DetailLevelCodeType.RETURN_ALL};
      api.setDetailLevel(detailLevels);

      api.setUserID(this.txtUserID.getText());

      if( this.txtItemsPerPage.getText().length() > 0 &&
          this.txtStartingPage.getText().length() > 0 )
      {
        PaginationType pt = new PaginationType();
        pt.setPageNumber(new Integer(this.txtStartingPage.getText()));
        pt.setEntriesPerPage(new Integer(this.txtItemsPerPage.getText()));
        api.setPagination(pt);
      }

      // Executes the API.
      final FeedbackDetailType[] feedbacks = api.getFeedback();

      // Display items in table.
      TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return DialogGetFeedback.totalColumns; }
        public int getRowCount() { return feedbacks == null ? 0 : feedbacks.length;}
        public String getColumnName(int columnIndex){
          return colNames[columnIndex];
        }
        public Object getValueAt(int row, int col)
        {
          FeedbackDetailType fd = feedbacks[row];
          return feedbackToColumns(fd)[col];
        }
      };

      this.tblFeedbacks.setModel(dataModel);
    }
    catch(Exception ex)
    {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      ((FrameDemo)this.getParent()).showErrorMessage(msg);
    }
  }
}

class DialogGetFeedback_btnGetFeedback_actionAdapter implements java.awt.event.ActionListener {
  DialogGetFeedback adaptee;

  DialogGetFeedback_btnGetFeedback_actionAdapter(DialogGetFeedback adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetFeedback_actionPerformed(e);
  }
}
