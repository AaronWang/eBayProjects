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
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetStorePreferencesCall;
import com.ebay.sdk.helper.Utils;
import com.ebay.soap.eBLBaseComponents.StorePreferencesType;
import com.ebay.soap.eBLBaseComponents.StoreVacationPreferencesType;

/**
 * Demonstrate API GetStorePreferences.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogGetStorePreferences extends JDialog {
  private ApiContext apiContext = new ApiContext();

  // Table related.
  final static String[] colNames = new String[] {
      "Preference", "Status" };

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
  JPanel jPanel18 = new JPanel();
  JTable tblPreferences = new JTable();

  public DialogGetStorePreferences(Frame frame, String title, boolean modal) {
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

  public DialogGetStorePreferences() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setMinimumSize(new Dimension(133, 25));
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(160, 25));
    btnExecuteAPI.setText("GetStorePreferences");
    btnExecuteAPI.addActionListener(new DialogGetStorePreferences_btnExecuteAPI_actionAdapter(this));
    jPanel5.setLayout(borderLayout5);
    jPanel6.setPreferredSize(new Dimension(143, 40));
    jPanel6.setLayout(borderLayout4);
    jPanel5.setOpaque(true);
    jPanel5.setPreferredSize(new Dimension(10, 50));
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setBorder(BorderFactory.createLoweredBevelBorder());
    jScrollPane1.setPreferredSize(new Dimension(600, 180));
    jLabel3.setText("Press the button below to retrieve store preferences.");
    jPanel1.setRequestFocusEnabled(true);
    panel1.setPreferredSize(new Dimension(680, 558));
    panel1.setRequestFocusEnabled(true);
    jPanel11.setLayout(borderLayout6);
    lblReturnedApiRules.setToolTipText("");
    lblReturnedApiRules.setVerifyInputWhenFocusTarget(true);
    lblReturnedApiRules.setText("Store Preferences");
    jPanel11.setPreferredSize(new Dimension(464, 300));
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
    jScrollPane1.getViewport().add(tblPreferences, null);
    jPanel2.add(jPanel18,  BorderLayout.SOUTH);

    panel1.add(jPanel3, BorderLayout.SOUTH);

    jPanel1.setPreferredSize(new Dimension(800, 80));
    this.setSize(new Dimension(658, 325));
  }

  static String[] mapItemToColumns(Object name, Object value)
  {
    //"Preference", "Status"

    String[] cols = new String[totalColumns];

    int i = 0;
    cols[i++] = name.toString();
    cols[i++] = value.toString();

    return cols;
  }

  private void displayStorePreferences(StorePreferencesType pref)
  {
    String s;
    StoreVacationPreferencesType sv = pref.getVacationPreferences();

    final java.util.Hashtable nvs = new java.util.Hashtable();

    nvs.put("Owner is on vacation", Utils.booleanToYesNo(sv.isOnVacation()));
    nvs.put("Hide store inventory items", Utils.booleanToYesNo(sv.isHideFixedPriceStoreItems()));
    nvs.put("Add message to active items", Utils.booleanToYesNo(sv.isMessageItem()));
    nvs.put("Add message to store pages", Utils.booleanToYesNo(sv.isMessageStore()));
    nvs.put("Display custom message", Utils.booleanToYesNo(sv.isDisplayMessageStoreCustomText()));

    s = sv.getMessageStoreCustomText();
    nvs.put("Custom message text", s == null ? "" : s);

    final Object[] keys = nvs.keySet().toArray();

    //
    TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalColumns;
      }

      public int getRowCount() {
        return nvs != null ? nvs.size() : 0;
      }

      public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        Object key = keys[row];
        return mapItemToColumns(key, nvs.get(key))[col];
      }
    };

    this.tblPreferences.setModel(dataModel);
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    try
    {
      GetStorePreferencesCall api = new GetStorePreferencesCall(this.apiContext);

      api.getStorePreferences();

      StorePreferencesType pref = api.getReturnedStorePreferencesType();

      //
      this.displayStorePreferences(pref);
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGetStorePreferences_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogGetStorePreferences adaptee;

  DialogGetStorePreferences_btnExecuteAPI_actionAdapter(DialogGetStorePreferences adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}
