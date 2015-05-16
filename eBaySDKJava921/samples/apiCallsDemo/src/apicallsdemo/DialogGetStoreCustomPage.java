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
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetStoreCustomPageCall;
import com.ebay.sdk.helper.Utils;
import com.ebay.soap.eBLBaseComponents.MyMessagesFolderType;
import com.ebay.soap.eBLBaseComponents.StoreCustomPageType;

/**
 * Demonstrate API GetStoreCustomPage.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogGetStoreCustomPage extends JDialog {
  private ApiContext apiContext = new ApiContext();

  // Table related.
  final static String[] colNames = new String[] {
      "ID", "Name", "Order", "LeftNav" };

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
  JLabel lblStoreCustomPages = new JLabel();
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel18 = new JPanel();
  JTable tblAccessRules = new JTable();
  JTextField txtPageID = new JTextField();

  public DialogGetStoreCustomPage(Frame frame, String title, boolean modal) {
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

  public DialogGetStoreCustomPage() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setMinimumSize(new Dimension(133, 25));
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(160, 25));
    btnExecuteAPI.setText("GetStoreCustomPage");
    btnExecuteAPI.addActionListener(new DialogGetStoreCustomPage_btnExecuteAPI_actionAdapter(this));
    jPanel5.setLayout(borderLayout5);
    jPanel6.setPreferredSize(new Dimension(143, 40));
    jPanel6.setLayout(borderLayout4);
    jPanel5.setOpaque(true);
    jPanel5.setPreferredSize(new Dimension(10, 50));
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setPreferredSize(new Dimension(600, 260));
    jLabel3.setToolTipText("");
    jLabel3.setText("ID of the custom page (leave blank to return all):");
    jPanel1.setRequestFocusEnabled(true);
    panel1.setPreferredSize(new Dimension(680, 558));
    panel1.setRequestFocusEnabled(true);
    jPanel11.setLayout(borderLayout6);
    lblStoreCustomPages.setToolTipText("");
    lblStoreCustomPages.setVerifyInputWhenFocusTarget(true);
    lblStoreCustomPages.setText("Store Custom Pages");
    jPanel12.setLayout(borderLayout7);
    jPanel11.setPreferredSize(new Dimension(464, 300));
    jPanel12.setPreferredSize(new Dimension(464, 250));
    txtPageID.setPreferredSize(new Dimension(60, 21));
    txtPageID.setText("");
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(btnExecuteAPI, null);
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(jPanel8, BorderLayout.NORTH);
    jPanel8.add(jLabel3, null);
    jPanel8.add(txtPageID, null);

    panel1.add(jPanel2, BorderLayout.CENTER);
    jPanel2.setLayout(borderLayout3);
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.add(jPanel11, BorderLayout.NORTH);
    jPanel11.add(jPanel13,  BorderLayout.NORTH);
    jPanel13.add(lblStoreCustomPages, null);
    jPanel11.add(jPanel14, BorderLayout.CENTER);
    jPanel14.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(tblAccessRules, null);
    jPanel2.add(jPanel12,  BorderLayout.CENTER);
    jPanel2.add(jPanel18,  BorderLayout.SOUTH);

    panel1.add(jPanel3, BorderLayout.SOUTH);

    jPanel1.setPreferredSize(new Dimension(800, 80));
    this.setSize(new Dimension(658, 415));
  }

  static String getFolderDispName(MyMessagesFolderType folder)
  {
    if( folder == null )
      return "";

    if( folder.getFolderName() != null && folder.getFolderName().length() > 0 )
      return folder.getFolderName();
    return folder.getFolderID().toString();
  }

  static String[] customPageToColumns(StoreCustomPageType page)
  {
    //"ID", "Name", "Order", "LeftNav"
    String[] cols = new String[totalColumns];

    int i = 0;
    cols[i++] = page.getPageID().toString();
    cols[i++] = page.getName();
    cols[i++] = page.getOrder().toString();
    cols[i++] = Utils.booleanToYesNo(page.isLeftNav());

    return cols;
  }

  private void displayCustomPages(StoreCustomPageType[] inPages)
  {
    final StoreCustomPageType[] pages = inPages;

    TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalColumns;
      }

      public int getRowCount() {
        return pages != null ? pages.length : 0;
      }

      public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        StoreCustomPageType page = pages[row];
        return customPageToColumns(page)[col];
      }
    };

    this.tblAccessRules.setModel(dataModel);
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    String s;

    try
    {
      GetStoreCustomPageCall api = new GetStoreCustomPageCall(this.apiContext);

      s = this.txtPageID.getText();
      if( s.length() > 0 )
        api.setPageID(new Long(s));

      api.getStoreCustomPage();

      StoreCustomPageType pages[] = api.getReturnedStoreCustomPageArrayType().getCustomPage();

      // Display alerts.
      this.displayCustomPages(pages);
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGetStoreCustomPage_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogGetStoreCustomPage adaptee;

  DialogGetStoreCustomPage_btnExecuteAPI_actionAdapter(DialogGetStoreCustomPage adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}
