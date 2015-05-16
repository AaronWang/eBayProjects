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
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.TimeFilter;
import com.ebay.sdk.call.GetSellerEventsCall;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.ItemType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */

public class DialogGetSellerEvents extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanelOptions = new JPanel();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JTextField txtUserID = new JTextField();
  JLabel jLabel1 = new JLabel();
  JCheckBox cbxIncNewItem = new JCheckBox();
  JPanel jPanelCall = new JPanel();
  JButton btnGetSellerEvents = new JButton();
  JPanel jPanel5 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable tblEvents = new JTable();

  private ApiContext apiContext;

  final static int totalColumns = 7;
  final String[] colNames = new String[] {
    "ItemID", "Title", "Price", "QS", "BidCount", "Cy", "ST"};
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanelTimeFilters = new JPanel();
  JLabel jLabel8 = new JLabel();
  JTextField txtStartTimeTo = new JTextField();
  JPanel jPanel16 = new JPanel();
  JTextField txtEndTimeTo = new JTextField();
  JPanel jPanelEndTimeFilter = new JPanel();
  JLabel jLabel11 = new JLabel();
  JPanel jPanel19 = new JPanel();
  JTextField txtModTimeFrom = new JTextField();
  JTextField txtStartTimeFrom = new JTextField();
  JPanel jPanelModTimeFilter = new JPanel();
  JTextField txtEndTimeFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  JPanel jPanel17 = new JPanel();
  JPanel jPanel18 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JPanel jPanelStartTimeFilter = new JPanel();
  JPanel jPanel11 = new JPanel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JTextField txtModTimeTo = new JTextField();
  GridLayout gridLayout2 = new GridLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel7 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  BorderLayout borderLayout4 = new BorderLayout();
  ButtonGroup buttonGroupTimeFilter = new ButtonGroup();
  JRadioButton rbtnUseStartTime = new JRadioButton();
  JRadioButton rbtnUseModTime = new JRadioButton();
  JRadioButton rbtnUseEndTime = new JRadioButton();

  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel21 = new JPanel();
  JPanel jPanel22 = new JPanel();
  JPanel jPanel23 = new JPanel();
  JPanel jPanel24 = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel13 = new JPanel();
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel14 = new JPanel();
  JPanel jPanel15 = new JPanel();
  BorderLayout borderLayout8 = new BorderLayout();
  JLabel jLabel4 = new JLabel();
  JTextField txtNumberOfEvents = new JTextField();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel20 = new JPanel();
  JPanel jPanel25 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();

  public DialogGetSellerEvents(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      // Pre-set time fields first.
      GuiUtil.setTimeFilterFields(5, this.txtStartTimeFrom, this.txtStartTimeTo);
      GuiUtil.setTimeFilterFields(5, this.txtEndTimeFrom, this.txtEndTimeTo);
      GuiUtil.setTimeFilterFields(5, this.txtModTimeFrom, this.txtModTimeTo);
      //
      updateControlStatus();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetSellerEvents() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel3.setLayout(borderLayout3);
    txtUserID.setMinimumSize(new Dimension(6, 21));
    txtUserID.setOpaque(true);
    txtUserID.setPreferredSize(new Dimension(120, 21));
    txtUserID.setSelectedTextColor(Color.white);
    jLabel1.setText("UserID: ");
    cbxIncNewItem.setText("Include new item.");
    btnGetSellerEvents.setVerifyInputWhenFocusTarget(true);
    btnGetSellerEvents.setText("GetSellerEvents");
    btnGetSellerEvents.addActionListener(new DialogGetSellerEvents_btnGetSellerEvents_actionAdapter(this));
    jPanel1.setLayout(borderLayout2);
    tblEvents.setEnabled(true);
    tblEvents.setMaximumSize(new Dimension(0, 0));
    tblEvents.setMinimumSize(new Dimension(0, 0));
    jPanel5.setMaximumSize(new Dimension(32767, 32767));
    jPanel5.setPreferredSize(new Dimension(464, 310));
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setPreferredSize(new Dimension(454, 300));
    jLabel8.setText("EndTimeFrom: ");
    jLabel8.setPreferredSize(new Dimension(80, 15));
    jLabel8.setVerifyInputWhenFocusTarget(true);
    txtStartTimeTo.setPreferredSize(new Dimension(120, 21));
    txtStartTimeTo.setMargin(new Insets(1, 1, 1, 1));
    txtEndTimeTo.setText("");
    txtEndTimeTo.setMargin(new Insets(1, 1, 1, 1));
    txtEndTimeTo.setPreferredSize(new Dimension(120, 21));
    jLabel11.setPreferredSize(new Dimension(80, 15));
    jLabel11.setText("ModTimeTo: ");
    txtModTimeFrom.setPreferredSize(new Dimension(120, 21));
    txtModTimeFrom.setToolTipText("");
    txtModTimeFrom.setSelectedTextColor(Color.white);
    txtModTimeFrom.setText("");
    txtStartTimeFrom.setOpaque(true);
    txtStartTimeFrom.setPreferredSize(new Dimension(120, 21));
    txtStartTimeFrom.setToolTipText("");
    txtStartTimeFrom.setSelectedTextColor(Color.white);
    txtStartTimeFrom.setText("");
    txtEndTimeFrom.setText("");
    txtEndTimeFrom.setSelectedTextColor(Color.white);
    txtEndTimeFrom.setToolTipText("");
    txtEndTimeFrom.setOpaque(true);
    txtEndTimeFrom.setPreferredSize(new Dimension(120, 21));
    jLabel3.setPreferredSize(new Dimension(80, 15));
    jLabel3.setText("StartTimeTo: ");
    jLabel2.setPreferredSize(new Dimension(80, 15));
    jLabel2.setVerifyInputWhenFocusTarget(true);
    jLabel2.setText("StartTimeFrom: ");
    jLabel9.setPreferredSize(new Dimension(80, 15));
    jLabel9.setText("EndTimeTo: ");
    jLabel10.setPreferredSize(new Dimension(80, 15));
    jLabel10.setVerifyInputWhenFocusTarget(true);
    jLabel10.setText("ModTimeFrom: ");
    txtModTimeTo.setPreferredSize(new Dimension(120, 21));
    txtModTimeTo.setMargin(new Insets(1, 1, 1, 1));
    txtModTimeTo.setText("");
    jPanelTimeFilters.setLayout(gridLayout2);
    gridLayout2.setColumns(1);
    gridLayout2.setRows(3);
    jPanel7.setLayout(gridLayout1);
    gridLayout1.setColumns(1);
    gridLayout1.setRows(3);
    jPanel4.setLayout(borderLayout4);
    rbtnUseStartTime.setActionCommand("");
    rbtnUseStartTime.setText("");
    rbtnUseStartTime.addChangeListener(new DialogGetSellerEvents_rbtnUseStartTime_changeAdapter(this));
    rbtnUseModTime.setSelected(true);
    rbtnUseModTime.setText("");
    rbtnUseModTime.addChangeListener(new DialogGetSellerEvents_rbtnUseModTime_changeAdapter(this));
    rbtnUseEndTime.addChangeListener(new DialogGetSellerEvents_rbtnUseEndTime_changeAdapter(this));
    jPanel21.setPreferredSize(new Dimension(10, 40));
    jPanel21.setLayout(borderLayout6);
    jPanel13.setPreferredSize(new Dimension(10, 1));
    jPanel13.setLayout(borderLayout7);
    jPanel15.setLayout(borderLayout8);
    jLabel4.setText("    Number of events:    ");
    txtNumberOfEvents.setBackground(UIManager.getColor("Button.background"));
    txtNumberOfEvents.setPreferredSize(new Dimension(60, 21));
    txtNumberOfEvents.setText("");
    jPanelCall.setPreferredSize(new Dimension(121, 40));
    jPanel6.setPreferredSize(new Dimension(250, 21));
    jPanel6.setLayout(gridBagLayout1);
    jPanel12.setPreferredSize(new Dimension(10, 5));
    jPanel14.setPreferredSize(new Dimension(10, 5));
    jLabel5.setText(" ");
    jLabel6.setPreferredSize(new Dimension(50, 15));
    jLabel6.setText("");
    jPanel2.setPreferredSize(new Dimension(10, 1));
    getContentPane().add(panel1);
    panel1.add(jPanel1, BorderLayout.CENTER);

    jPanel1.add(jPanel5, BorderLayout.CENTER);

    jPanel5.setBorder(BorderFactory.createEtchedBorder());
    jPanel5.setLayout(borderLayout5);
    jPanel5.add(jPanel21, BorderLayout.NORTH);
    jPanel21.add(jPanel13, BorderLayout.CENTER);
    jPanel13.add(jPanel12, BorderLayout.NORTH);
    jPanel13.add(jPanel14, BorderLayout.SOUTH);
    jPanel13.add(jPanel15, BorderLayout.CENTER);
    jPanel15.add(jPanel6, BorderLayout.WEST);
    jPanel6.add(jLabel4,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(txtNumberOfEvents, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel5, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jLabel6, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel15.add(jPanel20, BorderLayout.EAST);
    jPanel15.add(jPanel25, BorderLayout.CENTER);
    jPanel5.add(jPanel22, BorderLayout.SOUTH);
    jPanel5.add(jPanel23, BorderLayout.WEST);
    jPanel5.add(jPanel24, BorderLayout.EAST);
    jPanel5.add(jScrollPane1, BorderLayout.CENTER);

    jScrollPane1.getViewport().add(tblEvents, null);

    panel1.add(jPanel2, BorderLayout.SOUTH);
    panel1.add(jPanel3, BorderLayout.NORTH);
    jPanel3.add(jPanelOptions,  BorderLayout.NORTH);
    jPanel9.add(jLabel1, null);
    jPanel9.add(txtUserID, null);
    jPanelOptions.add(jPanel9, null);
    jPanelOptions.add(jPanel8, null);
    jPanel8.add(cbxIncNewItem, null);
    jPanel3.add(jPanelCall,  BorderLayout.SOUTH);
    jPanelCall.add(btnGetSellerEvents, null);
    jPanel17.add(jLabel8, null);
    jPanel17.add(txtEndTimeFrom, null);
    jPanel3.add(jPanel4, BorderLayout.CENTER);
    jPanel4.add(jPanel7, BorderLayout.WEST);
    jPanel4.add(jPanelTimeFilters, BorderLayout.CENTER);
    jPanelEndTimeFilter.add(rbtnUseEndTime, null);
    jPanelEndTimeFilter.add(jPanel17, null);
    jPanelEndTimeFilter.add(jPanel16, null);
    jPanel16.add(jLabel9, null);
    jPanel16.add(txtEndTimeTo, null);
    jPanel19.add(jLabel10, null);
    jPanel19.add(txtModTimeFrom, null);
    jPanelModTimeFilter.add(rbtnUseModTime, null);
    jPanelModTimeFilter.add(jPanel19, null);
    jPanelModTimeFilter.add(jPanel18, null);
    jPanel18.add(jLabel11, null);
    jPanel18.add(txtModTimeTo, null);
    jPanelTimeFilters.add(jPanelModTimeFilter, null);
    jPanelTimeFilters.add(jPanelStartTimeFilter, null);
    jPanel11.add(jLabel2, null);
    jPanel11.add(txtStartTimeFrom, null);
    jPanelTimeFilters.add(jPanelEndTimeFilter, null);
    jPanelStartTimeFilter.add(rbtnUseStartTime, null);
    jPanelStartTimeFilter.add(jPanel11, null);
    jPanelStartTimeFilter.add(jPanel10, null);
    jPanel10.add(jLabel3, null);
    jPanel10.add(txtStartTimeTo, null);
    buttonGroupTimeFilter.add(rbtnUseModTime);
    buttonGroupTimeFilter.add(rbtnUseStartTime);
    buttonGroupTimeFilter.add(rbtnUseEndTime);

    this.setSize(new Dimension(750, 500));
  }

  static String[] itemToColumns(ItemType item)
  {
    String[] cols = new String[DialogGetSellerEvents.totalColumns];
    int i = 0;
    cols[i++] = item.getItemID().toString();
    cols[i++] = item.getTitle();
    AmountType currentPrice = item.getSellingStatus().getCurrentPrice();
    cols[i++] = (new Double(currentPrice.getValue())).toString();
    Integer qs = item.getSellingStatus().getQuantitySold();
    cols[i++] = (qs == null) ? "" : qs.toString();
    cols[i++] = item.getSellingStatus().getBidCount().toString();
    cols[i++] = currentPrice.getCurrencyID().value();
    Calendar cal = item.getListingDetails().getStartTime();
    if (cal != null) {
      cols[i++] = eBayUtil.toAPITimeString(cal.getTime());
    }

    return cols;
  }

  static void UpdateFilterPanel(JRadioButton rbtn, JTextField from, JTextField to)
  {
    boolean enable = rbtn.isSelected();
    from.setEnabled(enable);
    to.setEnabled(enable);

  }

  void updateControlStatus()
  {
    UpdateFilterPanel(this.rbtnUseModTime, this.txtModTimeFrom, this.txtModTimeTo);
    UpdateFilterPanel(this.rbtnUseStartTime, this.txtStartTimeFrom, this.txtStartTimeTo);
    UpdateFilterPanel(this.rbtnUseEndTime, this.txtEndTimeFrom, this.txtEndTimeTo);
  }

  void btnGetSellerEvents_actionPerformed(ActionEvent e) {

    TimeFilter tf;

    try
    {
      GetSellerEventsCall api = new GetSellerEventsCall(this.apiContext);

      if (this.txtUserID.getText().length() > 0)
        api.setUserID(this.txtUserID.getText());

      api.setIncludeNewItem(this.cbxIncNewItem.isSelected());

      if( this.rbtnUseModTime.isSelected() )
      {
        tf = GuiUtil.getTimeFilterFromFields(
            this.txtModTimeFrom, this.txtModTimeTo);
        if (tf != null)
          api.setModTimeFilter(tf);
      }
      else if( this.rbtnUseStartTime.isSelected() )
      {
        tf = GuiUtil.getTimeFilterFromFields(
            this.txtStartTimeFrom, this.txtStartTimeTo);
        if (tf != null)
          api.setStartTimeFilter(tf);
      }
      else if( this.rbtnUseEndTime.isSelected() )
      {
        tf = GuiUtil.getTimeFilterFromFields(
            this.txtEndTimeFrom, this.txtEndTimeTo);
        if (tf != null)
          api.setEndTimeFilter(tf);
      }

      // Call eBay.
      final ItemType[] items = api.getSellerEvents();

      this.txtNumberOfEvents.setText(new Integer(items.length).toString());

      // Display items in table.
      TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return DialogGetSellerEvents.totalColumns; }
        public int getRowCount() { return items.length;}
        public String getColumnName(int columnIndex){
          return colNames[columnIndex];
        }
        public Object getValueAt(int row, int col)
        {
          ItemType item = items[row];
          return DialogGetSellerEvents.itemToColumns(item)[col];
        }
      };

      tblEvents.setModel(dataModel);
    }
    catch(Exception ex)
    {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }

  }

  void rbtnUseModTime_stateChanged(ChangeEvent e) {
    updateControlStatus();
  }

  void rbtnUseStartTime_stateChanged(ChangeEvent e) {
    updateControlStatus();
  }

  void rbtnUseEndTime_stateChanged(ChangeEvent e) {
    updateControlStatus();
  }


}

class DialogGetSellerEvents_btnGetSellerEvents_actionAdapter implements java.awt.event.ActionListener {
  DialogGetSellerEvents adaptee;

  DialogGetSellerEvents_btnGetSellerEvents_actionAdapter(DialogGetSellerEvents adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetSellerEvents_actionPerformed(e);
  }
}

class DialogGetSellerEvents_rbtnUseModTime_changeAdapter implements javax.swing.event.ChangeListener {
  DialogGetSellerEvents adaptee;

  DialogGetSellerEvents_rbtnUseModTime_changeAdapter(DialogGetSellerEvents adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.rbtnUseModTime_stateChanged(e);
  }
}

class DialogGetSellerEvents_rbtnUseStartTime_changeAdapter implements javax.swing.event.ChangeListener {
  DialogGetSellerEvents adaptee;

  DialogGetSellerEvents_rbtnUseStartTime_changeAdapter(DialogGetSellerEvents adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.rbtnUseStartTime_stateChanged(e);
  }
}

class DialogGetSellerEvents_rbtnUseEndTime_changeAdapter implements javax.swing.event.ChangeListener {
  DialogGetSellerEvents adaptee;

  DialogGetSellerEvents_rbtnUseEndTime_changeAdapter(DialogGetSellerEvents adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.rbtnUseEndTime_stateChanged(e);
  }
}

