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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetAccountCall;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.AccountEntryType;
import com.ebay.soap.eBLBaseComponents.AccountHistorySelectionCodeType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;

public class DialogGetAccount extends JDialog {

  private ApiContext apiContext = new ApiContext();

  final static int totalColumns = 7;
  final String[] colNames = new String[] {
      "RefNumber", "Type", "ItemID", "Balance", "Date", "Credit", "Debit"
  };

  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();
  BorderLayout borderLayout3 = new BorderLayout();

  JPanel panel1 = new JPanel();

  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();

  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JButton btnCallGetAccount = new JButton();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel6 = new JPanel();
  JRadioButton rbtnLastInvoice = new JRadioButton();
  JPanel jPanel8 = new JPanel();
  JRadioButton rbtnSpecifiedInvoice = new JRadioButton();
  JTextField txtInvoiceDate = new JTextField();
  JPanel jPanel9 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable tblAccountEntries = new JTable();
  ButtonGroup buttonGroupHistoryType = new ButtonGroup();
  JPanel jPanel10 = new JPanel();
  JRadioButton rbtnBetweenSpecifiedDates = new JRadioButton();
  JTextField txtToDate = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JTextField txtFromDate = new JTextField();
  JLabel jLabel4 = new JLabel();

  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel14 = new JPanel();

  public DialogGetAccount(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      java.util.Calendar calNow = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("GMT"));
      this.txtInvoiceDate.setText(eBayUtil.toAPITimeString(calNow.getTime()));

      GuiUtil.setTimeFilterFields(5, this.txtFromDate, this.txtToDate);

      updateGUI();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetAccount() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnCallGetAccount.setText("GetAccount");
    btnCallGetAccount.addActionListener(new DialogGetAccount_btnCallGetAccount_actionAdapter(this));
    jPanel4.setLayout(gridLayout1);
    gridLayout1.setRows(5);
    rbtnLastInvoice.setPreferredSize(new Dimension(320, 23));
    rbtnLastInvoice.setVerifyInputWhenFocusTarget(true);
    rbtnLastInvoice.setSelected(true);
    rbtnLastInvoice.setText("Since Last Invoice");
    rbtnLastInvoice.addChangeListener(new DialogGetAccount_rbtnLastInvoice_changeAdapter(this));
    rbtnSpecifiedInvoice.setPreferredSize(new Dimension(140, 23));
    rbtnSpecifiedInvoice.setText("Specified Invoice Date:");
    rbtnSpecifiedInvoice.addChangeListener(new DialogGetAccount_rbtnSpecifiedInvoice_changeAdapter(this));
    txtInvoiceDate.setPreferredSize(new Dimension(85, 21));
    txtInvoiceDate.setToolTipText("");
    txtInvoiceDate.setSelectionStart(0);
    txtInvoiceDate.setText("");
    jLabel1.setText("Specify Account History to view");
    rbtnBetweenSpecifiedDates.setText("Between Dates:");
    rbtnBetweenSpecifiedDates.addChangeListener(new DialogGetAccount_rbtnBetweenSpecifiedDates_changeAdapter(this));
    jLabel2.setText("To");
    jLabel3.setVerifyInputWhenFocusTarget(true);
    jLabel3.setText("From");
    txtFromDate.setPreferredSize(new Dimension(80, 21));
    txtFromDate.setText("");
    txtToDate.setPreferredSize(new Dimension(80, 21));
    txtToDate.setSelectionStart(0);
    txtToDate.setText("");
    jLabel4.setText("(yyyy-mm-dd hh:mm:ss)");
    jPanel3.setPreferredSize(new Dimension(10, 1));
    jScrollPane1.getViewport().setBackground(Color.white);
    jPanel5.setPreferredSize(new Dimension(103, 40));
    jPanel8.add(rbtnSpecifiedInvoice, null);
    jPanel8.add(txtInvoiceDate, null);
    jPanel8.add(jLabel4, null);
    jPanel10.add(rbtnBetweenSpecifiedDates, null);
    jPanel10.add(jLabel3, null);
    jPanel10.add(txtFromDate, null);
    jPanel10.add(jLabel2, null);
    jPanel10.add(txtToDate, null);
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel4,  BorderLayout.NORTH);
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(btnCallGetAccount, null);
    panel1.add(jPanel2, BorderLayout.CENTER);

    jPanel2.setLayout(borderLayout3);
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.add(jPanel11, BorderLayout.NORTH);
    jPanel2.add(jPanel12, BorderLayout.SOUTH);
    jPanel2.add(jPanel13, BorderLayout.WEST);
    jPanel2.add(jPanel14, BorderLayout.EAST);
    jPanel2.add(jScrollPane1, BorderLayout.CENTER);

    jScrollPane1.getViewport().add(tblAccountEntries, null);
    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel4.add(jPanel9, null);
    jPanel9.add(jLabel1, null);
    jPanel4.add(jPanel6, null);
    jPanel6.add(rbtnLastInvoice, null);
    jPanel4.add(jPanel8, null);
    jPanel4.add(jPanel10, null);
    buttonGroupHistoryType.add(rbtnLastInvoice);
    buttonGroupHistoryType.add(rbtnSpecifiedInvoice);
    buttonGroupHistoryType.add(rbtnBetweenSpecifiedDates);

    this.setSize(new Dimension(700, 450));
  }

  static String[] accountEntryToColumns(AccountEntryType entry)
  {
    String[] cols = new String[totalColumns];
    int i = 0;
    cols[i++] = entry.getRefNumber() != null ? entry.getRefNumber() : "";
    cols[i++] = entry.getAccountDetailsEntryType() != null ? entry.getAccountDetailsEntryType().toString() : "";
    cols[i++] = entry.getItemID() != null ? entry.getItemID().toString() : "";
    cols[i++] = entry.getBalance() != null ? new Double(entry.getBalance().getValue()).toString() : "";
    cols[i++] = entry.getDate() != null ? eBayUtil.toAPITimeString(entry.getDate().getTime()) : "";

    return cols;
  }

  void updateGUI()
  {
    this.txtInvoiceDate.setEnabled(this.rbtnSpecifiedInvoice.isSelected());
    boolean period = this.rbtnBetweenSpecifiedDates.isSelected();
    this.txtFromDate.setEnabled(period);
    this.txtToDate.setEnabled(period);
  }

  void btnCallGetAccount_actionPerformed(ActionEvent e) {
    try
    {
      GetAccountCall api = new GetAccountCall(this.apiContext);
      api.setDetailLevel(new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL});

      AccountHistorySelectionCodeType ht = null;
      if( this.rbtnSpecifiedInvoice.isSelected() )
      {
        ht = AccountHistorySelectionCodeType.SPECIFIED_INVOICE;
        api.setInvoiceDate(GuiUtil.getCalendarFromField(this.txtInvoiceDate));
      }
      else if( this.rbtnBetweenSpecifiedDates.isSelected() )
      {
        ht = AccountHistorySelectionCodeType.BETWEEN_SPECIFIED_DATES;
        api.setViewPeriod(GuiUtil.getTimeFilterFromFields(this.txtFromDate, this.txtToDate));
      }
	  else {
		ht = AccountHistorySelectionCodeType.LAST_INVOICE;
	  }

      api.setViewType(ht);

      // Call eBay.
      final AccountEntryType[] entries = api.getAccount();

      // Display items in table.
      TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return totalColumns; }
        public int getRowCount() { return entries == null ? 0 : entries.length;}
        public String getColumnName(int columnIndex){
          return colNames[columnIndex];
        }
        public Object getValueAt(int row, int col)
        {
          AccountEntryType cat = entries[row];
          return accountEntryToColumns(cat)[col];
        }
      };

      this.tblAccountEntries.setModel(dataModel);
    }
    catch(Exception ex)
    {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      ((FrameDemo)this.getParent()).showErrorMessage(msg);
    }
  }

  void rbtnLastInvoice_stateChanged(ChangeEvent e) {
    this.updateGUI();
  }

  void rbtnSpecifiedInvoice_stateChanged(ChangeEvent e) {
    this.updateGUI();
  }

  void rbtnBetweenSpecifiedDates_stateChanged(ChangeEvent e) {
    this.updateGUI();
  }

  void rbtnAllHistory_stateChanged(ChangeEvent e) {
    this.updateGUI();
  }
}

class DialogGetAccount_btnCallGetAccount_actionAdapter implements java.awt.event.ActionListener {
  DialogGetAccount adaptee;

  DialogGetAccount_btnCallGetAccount_actionAdapter(DialogGetAccount adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCallGetAccount_actionPerformed(e);
  }
}

class DialogGetAccount_rbtnLastInvoice_changeAdapter implements javax.swing.event.ChangeListener {
  DialogGetAccount adaptee;

  DialogGetAccount_rbtnLastInvoice_changeAdapter(DialogGetAccount adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.rbtnLastInvoice_stateChanged(e);
  }
}

class DialogGetAccount_rbtnSpecifiedInvoice_changeAdapter implements javax.swing.event.ChangeListener {
  DialogGetAccount adaptee;

  DialogGetAccount_rbtnSpecifiedInvoice_changeAdapter(DialogGetAccount adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.rbtnSpecifiedInvoice_stateChanged(e);
  }
}

class DialogGetAccount_rbtnBetweenSpecifiedDates_changeAdapter implements javax.swing.event.ChangeListener {
  DialogGetAccount adaptee;

  DialogGetAccount_rbtnBetweenSpecifiedDates_changeAdapter(DialogGetAccount adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.rbtnBetweenSpecifiedDates_stateChanged(e);
  }
}
