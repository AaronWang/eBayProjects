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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetStoreOptionsCall;
import com.ebay.soap.eBLBaseComponents.StoreColorSchemeType;
import com.ebay.soap.eBLBaseComponents.StoreLogoType;
import com.ebay.soap.eBLBaseComponents.StoreSubscriptionType;
import com.ebay.soap.eBLBaseComponents.StoreThemeType;

/**
 * Demonstrate API GetStoreOptions.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogGetStoreOptions extends JDialog {
  private ApiContext apiContext = new ApiContext();

  // Theme table.
  final static String[] themeColNames = new String[] {
      "ID", "Name", "ColorSchemeID", "ColorScheme" };

  final static int totalThemeColumns = themeColNames.length;

  // Logo table.
  final static String[] logoColNames = new String[] {
      "ID", "Name", "URL" };

  final static int totalLogoColumns = logoColNames.length;

  // Subscription table.
  final static String[] subscriptionColNames = new String[] {
      "Level", "Fee" };

  final static int totalSubscriptionColumns = subscriptionColNames.length;

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
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel18 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JPanel jPanelStoreInfo = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JPanel jPanel16 = new JPanel();
  JPanel jPanel17 = new JPanel();
  BorderLayout borderLayout8 = new BorderLayout();
  JScrollPane jScrollPane2 = new JScrollPane();
  JLabel jLabel1 = new JLabel();
  JTable tblBasicTheme = new JTable();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable tblAdvTheme = new JTable();
  JLabel jLabel2 = new JLabel();
  BorderLayout borderLayout9 = new BorderLayout();
  BorderLayout borderLayout10 = new BorderLayout();
  JScrollPane jScrollPane3 = new JScrollPane();
  JTable tblLogo = new JTable();
  JLabel jLabel4 = new JLabel();
  JScrollPane jScrollPane4 = new JScrollPane();
  BorderLayout borderLayout11 = new BorderLayout();
  JTable tblSubscription = new JTable();
  JLabel jLabel5 = new JLabel();

  public DialogGetStoreOptions(Frame frame, String title, boolean modal) {
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

  public DialogGetStoreOptions() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setMinimumSize(new Dimension(133, 25));
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(160, 25));
    btnExecuteAPI.setText("GetStoreOptions");
    btnExecuteAPI.addActionListener(new DialogGetStoreOptions_btnExecuteAPI_actionAdapter(this));
    jPanel5.setLayout(borderLayout5);
    jPanel6.setPreferredSize(new Dimension(143, 40));
    jPanel6.setLayout(borderLayout4);
    jPanel5.setOpaque(true);
    jPanel5.setPreferredSize(new Dimension(10, 50));
    jLabel3.setText("Press the button below to retrieve store options.");
    jPanel1.setRequestFocusEnabled(true);
    panel1.setPreferredSize(new Dimension(680, 558));
    panel1.setRequestFocusEnabled(true);
    jPanel11.setLayout(borderLayout6);
    jPanel12.setLayout(borderLayout7);
    jPanel11.setPreferredSize(new Dimension(464, 10));
    jPanel12.setPreferredSize(new Dimension(464, 400));
    jPanelStoreInfo.setLayout(gridLayout1);
    gridLayout1.setColumns(2);
    gridLayout1.setHgap(10);
    gridLayout1.setRows(2);
    gridLayout1.setVgap(10);
    jPanel9.setLayout(borderLayout8);
    jLabel1.setText("Basic Theme");
    jScrollPane2.getViewport().setBackground(Color.white);
    jLabel2.setText("Advanced Theme");
    jPanel17.setLayout(borderLayout9);
    jScrollPane1.getViewport().setBackground(Color.white);
    jPanel16.setLayout(borderLayout10);
    jLabel4.setText("Logo");
    jScrollPane3.getViewport().setBackground(Color.white);
    jPanel10.setLayout(borderLayout11);
    jLabel5.setText("Subscription");
    jScrollPane4.getViewport().setBackground(Color.white);
    jPanel2.setPreferredSize(new Dimension(468, 500));
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
    jPanel11.add(jPanel14, BorderLayout.CENTER);
    jPanel2.add(jPanel12,  BorderLayout.NORTH);
    jPanel12.add(jPanel7,  BorderLayout.NORTH);
    jPanel12.add(jPanelStoreInfo, BorderLayout.CENTER);
    jPanelStoreInfo.add(jPanel9, null);
    jPanel9.add(jScrollPane2, BorderLayout.CENTER);
    jScrollPane2.getViewport().add(tblBasicTheme, null);
    jPanel9.add(jLabel1, BorderLayout.NORTH);
    jPanelStoreInfo.add(jPanel17, null);
    jPanel17.add(jLabel2, BorderLayout.NORTH);
    jPanel17.add(jScrollPane1,  BorderLayout.CENTER);
    jScrollPane1.getViewport().add(tblAdvTheme, null);
    jPanelStoreInfo.add(jPanel16, null);
    jPanel16.add(jScrollPane3, BorderLayout.CENTER);
    jPanel16.add(jLabel4, BorderLayout.NORTH);
    jScrollPane3.getViewport().add(tblLogo, null);
    jPanelStoreInfo.add(jPanel10, null);
    jPanel10.add(jScrollPane4, BorderLayout.CENTER);
    jPanel10.add(jLabel5, BorderLayout.NORTH);
    jScrollPane4.getViewport().add(tblSubscription, null);
    jPanel2.add(jPanel18,  BorderLayout.SOUTH);

    panel1.add(jPanel3, BorderLayout.SOUTH);

    jPanel1.setPreferredSize(new Dimension(800, 80));
    this.setSize(new Dimension(658, 525));
  }

  static String[] themeToColumns(StoreThemeType theme)
  {
    //"ID", "Name", "ColorScheme"

    String[] cols = new String[totalThemeColumns];

    int i = 0;
    cols[i++] = theme.getThemeID().toString();
    cols[i++] = theme.getName();

    StoreColorSchemeType cs = theme.getColorScheme();
    cols[i++] = (cs == null || cs.getColorSchemeID() == null)? "" : cs.getColorSchemeID().toString();
    cols[i++] = cs == null ? "" : cs.getName();

    return cols;
  }

  private void displayThemes(StoreThemeType[] inTheme, JTable tbl)
  {
    final StoreThemeType[] themes = inTheme;

    TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalThemeColumns;
      }

      public int getRowCount() {
        return themes != null ? themes.length : 0;
      }

      public String getColumnName(int columnIndex) {
        return themeColNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        StoreThemeType t = themes[row];
        return themeToColumns(t)[col];
      }
    };

    tbl.setModel(dataModel);
  }

  static String[] logoToColumns(StoreLogoType logo)
  {
    //"ID", "Name", "URL"

    String[] cols = new String[totalLogoColumns];

    int i = 0;
    cols[i++] = logo.getLogoID().toString();
    cols[i++] = logo.getName();

    String uri = logo.getURL();
    cols[i++] = uri == null ? "" : uri.toString();

    return cols;
  }

  private void displayLogs(StoreLogoType[] inLogos)
  {
    final StoreLogoType[] logos = inLogos;

    TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalLogoColumns;
      }

      public int getRowCount() {
        return logos != null ? logos.length : 0;
      }

      public String getColumnName(int columnIndex) {
        return logoColNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        StoreLogoType t = logos[row];
        return logoToColumns(t)[col];
      }
    };

    this.tblLogo.setModel(dataModel);
  }

  static String[] subscriptionToColumns(StoreSubscriptionType sub)
  {
    //"Level", "Fee"
    String[] cols = new String[totalSubscriptionColumns];

    int i = 0;
    cols[i++] = sub.getLevel().toString();
    cols[i++] = new Double(sub.getFee().getValue()).toString();

    return cols;
  }

  private void displaySubscription(StoreSubscriptionType[] inSubs)
  {
    final StoreSubscriptionType[] subs = inSubs;

    TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalSubscriptionColumns;
      }

      public int getRowCount() {
        return subs != null ? subs.length : 0;
      }

      public String getColumnName(int columnIndex) {
        return subscriptionColNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        StoreSubscriptionType t = subs[row];
        return subscriptionToColumns(t)[col];
      }
    };

    this.tblSubscription.setModel(dataModel);
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    try
    {
      GetStoreOptionsCall api = new GetStoreOptionsCall(this.apiContext);

      api.getStoreOptions();

      StoreThemeType basicThems[] = api.getReturnedBasicThemeArray().getTheme();
      StoreThemeType advThems[] = api.getReturnedAdvancedThemeArray().getTheme();
      StoreLogoType logos[] = api.getReturnedLogoArray().getLogo();
      StoreSubscriptionType subscription[] = api.getReturnedSubscriptionArray() == null ? null :
          api.getReturnedSubscriptionArray().getSubscription();

      this.displayThemes(basicThems, this.tblBasicTheme);
      this.displayThemes(advThems, this.tblAdvTheme);

      this.displayLogs(logos);
      this.displaySubscription(subscription);
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGetStoreOptions_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogGetStoreOptions adaptee;

  DialogGetStoreOptions_btnExecuteAPI_actionAdapter(DialogGetStoreOptions adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}
