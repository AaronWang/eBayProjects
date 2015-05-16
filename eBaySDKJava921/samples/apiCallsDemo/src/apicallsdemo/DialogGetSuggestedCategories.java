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
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetSuggestedCategoriesCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.DisputeActivityCodeType;
import com.ebay.soap.eBLBaseComponents.SuggestedCategoryType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogGetSuggestedCategories extends JDialog {
  private ApiContext apiContext = new ApiContext();

  BorderLayout borderLayout1 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;

  static ControlTagItem[] activities = new ControlTagItem[] {
      new ControlTagItem(DisputeActivityCodeType.SELLER_ADD_INFORMATION.value(), DisputeActivityCodeType.SELLER_ADD_INFORMATION),
      new ControlTagItem(DisputeActivityCodeType.SELLER_COMPLETED_TRANSACTION.value(), DisputeActivityCodeType.SELLER_COMPLETED_TRANSACTION),
      new ControlTagItem(DisputeActivityCodeType.CAME_TO_AGREEMENT_NEED_FVF_CREDIT.value(), DisputeActivityCodeType.CAME_TO_AGREEMENT_NEED_FVF_CREDIT),
      new ControlTagItem(DisputeActivityCodeType.SELLER_END_COMMUNICATION.value(), DisputeActivityCodeType.SELLER_END_COMMUNICATION),
      new ControlTagItem(DisputeActivityCodeType.CUSTOM_CODE.value(), DisputeActivityCodeType.CUSTOM_CODE)
  };

  public DialogGetSuggestedCategories(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetSuggestedCategories() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    jPanel1.setLayout(borderLayout2);
    this.setModal(true);
    this.setTitle("eBay SDK for Java - GetSuggestedCategories");
    ComboBoxModel dataModel = new DefaultComboBoxModel(DialogGetSuggestedCategories.activities);

    this.setSize(new Dimension(700, 400));

    jPanel2.setBorder(null);
    jPanel2.setPreferredSize(new Dimension(10, 150));
    jPanel2.setLayout(borderLayout3);
    jPanel5.setBorder(null);
    jPanel5.setPreferredSize(new Dimension(10, 40));
    jPanel5.setLayout(borderLayout4);
    jPanel6.setBorder(null);
    jPanel6.setPreferredSize(new Dimension(10, 45));
    jPanel6.setLayout(gridBagLayout1);
    btnGetSuggestedCategories.setText("GetSuggestedCategories");
    btnGetSuggestedCategories.addActionListener(new DialogGetSuggestedCategories_btnGetSuggestedCategories_actionAdapter(this));
    jLabel1.setText("    Query (<=350 characters):");
    jPanel7.setLayout(borderLayout5);
    jPanel4.setLayout(borderLayout6);
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    jPanel10.setBorder(null);
    jPanel10.setPreferredSize(new Dimension(10, 45));
    jPanel10.setLayout(borderLayout7);
    jPanel14.setBorder(null);
    jPanel14.setPreferredSize(new Dimension(250, 10));
    jPanel14.setLayout(gridBagLayout2);
    jLabel2.setText("Number of categories:    ");
    jLabel3.setPreferredSize(new Dimension(25, 15));
    jLabel3.setText(" ");
    jPanel3.setPreferredSize(new Dimension(10, 1));
    txtCount.setBackground(UIManager.getColor("Button.background"));
    txtCount.setMinimumSize(new Dimension(80, 21));
    txtCount.setPreferredSize(new Dimension(80, 21));
    txtCount.setText("");
    txpQuery.setText("");
    jScrollPane2.getViewport().setBackground(Color.white);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel2.add(jPanel5, BorderLayout.NORTH);
    jPanel5.add(jLabel1, BorderLayout.WEST);
    jPanel2.add(jPanel6, BorderLayout.SOUTH);
    jPanel6.add(btnGetSuggestedCategories, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jPanel7, BorderLayout.CENTER);
    jPanel7.add(jPanel8, BorderLayout.WEST);
    jPanel7.add(jPanel9, BorderLayout.EAST);
    jPanel7.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(txpQuery, null);
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    jPanel4.add(jPanel10, BorderLayout.NORTH);
    jPanel10.add(jPanel14, BorderLayout.WEST);
    jPanel14.add(jLabel2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel14.add(txtCount, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel14.add(jLabel3, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jPanel15, BorderLayout.EAST);
    jPanel10.add(jPanel16, BorderLayout.CENTER);
    jPanel4.add(jPanel11, BorderLayout.WEST);
    jPanel4.add(jPanel12, BorderLayout.EAST);
    jPanel4.add(jPanel13, BorderLayout.SOUTH);
    jPanel4.add(jScrollPane2, BorderLayout.CENTER);
  }

  void btnGetSuggestedCategories_actionPerformed(ActionEvent e) {
    try {
      String query = this.txpQuery.getText();
      int len = query.length();
      if(len == 0 || len > 350) {
        throw new Exception("Please enter a search query (< 350 characters).");
      }
      GetSuggestedCategoriesCall api = new GetSuggestedCategoriesCall(this.apiContext);
      api.setQuery(query);
      SuggestedCategoryType[] categories = api.getSuggestedCategories();
      displayCategories(categories);
    }
    catch(Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void displayCategories(SuggestedCategoryType[] categories)
  {
    String[] columnNames =
        {"CategoryId", "CategoryFullId", "CategoryFullName", "PercentItemFound"};

    int size = categories != null ? categories.length : 0;
    this.txtCount.setText(new Integer(size).toString());

    Object[] [] dataTable = new Object[size][4];

    for (int i = 0; i < size; i++) {
      SuggestedCategoryType sct = categories[i];
      CategoryType cat = sct.getCategory();
      dataTable[i][0] = cat.getCategoryID();
      dataTable[i][1] = stringArrayToString(cat.getCategoryParentID(), SEPARATOR);
      dataTable[i][2] = stringArrayToString(cat.getCategoryParentName(), SEPARATOR);
      dataTable[i][3] = new Integer(sct.getPercentItemFound()).toString();
    }

    JTable jTable1 = new JTable(dataTable, columnNames);
    this.jScrollPane2.getViewport().add(jTable1, null);
  }

  public static String stringArrayToString(String[] sa, String separator)
  {
    StringBuffer sb = new StringBuffer();
    if (sa != null) {
      int len = sa.length;
      sb.append(sa[0]);
      if (len > 1) {
        for (int i = 1; i < len; i++) {
          sb.append(separator + sa[i]);
        }
      }
    }

    return sb.toString();
  }

  public static String SEPARATOR = ":";
  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JButton btnGetSuggestedCategories = new JButton();
  BorderLayout borderLayout4 = new BorderLayout();
  JLabel jLabel1 = new JLabel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextPane txpQuery = new JTextPane();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel10 = new JPanel();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  JScrollPane jScrollPane2 = new JScrollPane();
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel14 = new JPanel();
  JPanel jPanel15 = new JPanel();
  JPanel jPanel16 = new JPanel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel2 = new JLabel();
  JTextField txtCount = new JTextField();
  JLabel jLabel3 = new JLabel();
}

class DialogGetSuggestedCategories_btnGetSuggestedCategories_actionAdapter implements java.awt.event.ActionListener {
  DialogGetSuggestedCategories adaptee;

  DialogGetSuggestedCategories_btnGetSuggestedCategories_actionAdapter(DialogGetSuggestedCategories adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetSuggestedCategories_actionPerformed(e);
  }
}
