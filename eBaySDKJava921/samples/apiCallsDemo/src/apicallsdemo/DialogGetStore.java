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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetStoreCall;
import com.ebay.soap.eBLBaseComponents.StoreCustomCategoryType;
import com.ebay.soap.eBLBaseComponents.StoreType;

/**
 * Demonstrate API GetStore.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogGetStore extends JDialog {
  private ApiContext apiContext = new ApiContext();

  // Table related.
  final static String[] colNames = new String[] {
      "ID", "Name", "Order" };

  final static int totalColumns = colNames.length;

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
  JPanel jPanel8 = new JPanel();
  JLabel jLabel3 = new JLabel();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel14 = new JPanel();
  JLabel lblReturnedApiRules = new JLabel();
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel18 = new JPanel();
  JTable tblStoreCategories = new JTable();
  JPanel jPanel7 = new JPanel();
  JPanel jPanelStoreInfo = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JPanel jPanel16 = new JPanel();
  JPanel jPanel17 = new JPanel();
  JTextField txtStoreName = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtDescription = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtSubscriptionType = new JTextField();
  JLabel jLabel4 = new JLabel();

  public DialogGetStore(Frame frame, String title, boolean modal) {
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

  public DialogGetStore() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setMinimumSize(new Dimension(133, 25));
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(160, 25));
    btnExecuteAPI.setText("GetStore");
    btnExecuteAPI.addActionListener(new DialogGetStore_btnExecuteAPI_actionAdapter(this));
    jPanel5.setLayout(borderLayout5);
    jPanel6.setPreferredSize(new Dimension(143, 40));
    jPanel6.setLayout(borderLayout4);
    jPanel5.setOpaque(true);
    jPanel5.setPreferredSize(new Dimension(10, 50));
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setPreferredSize(new Dimension(600, 180));
    jLabel3.setText("Press the button below to retrieve store information.");
    jPanel1.setRequestFocusEnabled(true);
    panel1.setPreferredSize(new Dimension(680, 558));
    panel1.setRequestFocusEnabled(true);
    jPanel11.setLayout(borderLayout6);
    lblReturnedApiRules.setToolTipText("");
    lblReturnedApiRules.setVerifyInputWhenFocusTarget(true);
    lblReturnedApiRules.setText("Store Custom Categories");
    jPanel12.setLayout(borderLayout7);
    jPanel11.setPreferredSize(new Dimension(464, 300));
    jPanel12.setPreferredSize(new Dimension(464, 100));
    jPanelStoreInfo.setLayout(gridLayout1);
    gridLayout1.setColumns(2);
    gridLayout1.setRows(2);
    jLabel1.setText("Name:");
    txtStoreName.setBackground(Color.white);
    txtStoreName.setPreferredSize(new Dimension(100, 21));
    txtStoreName.setEditable(false);
    txtStoreName.setText("");
    jLabel2.setText("Description:");
    txtDescription.setBackground(Color.white);
    txtDescription.setMinimumSize(new Dimension(6, 21));
    txtDescription.setPreferredSize(new Dimension(200, 21));
    txtDescription.setToolTipText("");
    txtDescription.setEditable(false);
    txtDescription.setSelectionStart(3);
    txtDescription.setText("");
    jLabel4.setRequestFocusEnabled(true);
    jLabel4.setText("Subscription Level:");
    txtSubscriptionType.setBackground(Color.white);
    txtSubscriptionType.setPreferredSize(new Dimension(100, 21));
    txtSubscriptionType.setEditable(false);
    txtSubscriptionType.setText("");
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(btnExecuteAPI, null);
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(jPanel8, BorderLayout.NORTH);
    jPanel8.add(jLabel3, null);

    panel1.add(jPanel2, BorderLayout.CENTER);
    jPanel2.setLayout(borderLayout3);
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.add(jPanel11, BorderLayout.CENTER);
    jPanel11.add(jPanel13,  BorderLayout.NORTH);
    jPanel13.add(lblReturnedApiRules, null);
    jPanel11.add(jPanel14, BorderLayout.CENTER);
    jPanel14.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(tblStoreCategories, null);
    jPanel2.add(jPanel12,  BorderLayout.NORTH);
    jPanel12.add(jPanel7,  BorderLayout.NORTH);
    jPanel12.add(jPanelStoreInfo, BorderLayout.CENTER);
    jPanelStoreInfo.add(jPanel9, null);
    jPanel9.add(jLabel1, null);
    jPanel9.add(txtStoreName, null);
    jPanelStoreInfo.add(jPanel17, null);
    jPanel17.add(jLabel2, null);
    jPanel17.add(txtDescription, null);
    jPanelStoreInfo.add(jPanel16, null);
    jPanel16.add(jLabel4, null);
    jPanel16.add(txtSubscriptionType, null);
    jPanelStoreInfo.add(jPanel10, null);
    jPanel2.add(jPanel18,  BorderLayout.SOUTH);

    panel1.add(jPanel3, BorderLayout.SOUTH);

    jPanel1.setPreferredSize(new Dimension(800, 80));
    this.setSize(new Dimension(658, 415));
  }

  static String[] storeTypeToColumns(StoreCustomCategoryType cat)
  {
    //"ID", "Name", "Order"

    String[] cols = new String[totalColumns];

    int i = 0;
    cols[i++] = new Long(cat.getCategoryID()).toString();
    cols[i++] = cat.getName();
    cols[i++] = new Integer(cat.getOrder()).toString();

    return cols;
  }

  private void displayStoreCustomCategories(StoreType store)
  {
    final StoreCustomCategoryType[] cats = store.getCustomCategories().getCustomCategory();

    TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalColumns;
      }

      public int getRowCount() {
        return cats != null ? cats.length : 0;
      }

      public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        StoreCustomCategoryType rule = cats[row];
        return storeTypeToColumns(rule)[col];
      }
    };

    this.tblStoreCategories.setModel(dataModel);
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    try
    {
      GetStoreCall api = new GetStoreCall(this.apiContext);

      api.getStore();

      StoreType store = api.getReturnedStoreType();

      // Display store information.
      this.txtStoreName.setText(store.getName());
      this.txtDescription.setText(store.getDescription());
      this.txtSubscriptionType.setText(store.getSubscriptionLevel().toString());

      this.displayStoreCustomCategories(store);
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGetStore_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogGetStore adaptee;

  DialogGetStore_btnExecuteAPI_actionAdapter(DialogGetStore adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}
