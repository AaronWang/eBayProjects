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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetCategoriesCall;
import com.ebay.sdk.helper.Utils;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

public class DialogGetCategories extends JDialog {

  private ApiContext apiContext = new ApiContext();

  final static String[] colNames = new String[] {
      "ID", "Name", "ParentID", "Leaf", "Virtual", "Expired", "SellerGuaranteeEligible", "LotSizeEnabled", "ORPA", "BOE"};

  final static int totalColumns = colNames.length;

  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();
  BorderLayout borderLayout3 = new BorderLayout();
  BorderLayout borderLayout4 = new BorderLayout();
  BorderLayout borderLayout5 = new BorderLayout();
  BorderLayout borderLayout6 = new BorderLayout();

  JPanel panel1 = new JPanel();

  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();

  JPanel jPanel5 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel21 = new JPanel();
  JPanel jPanel22= new JPanel();
  JPanel jPanel23 = new JPanel();
  JPanel jPanel24 = new JPanel();

  JTextField txtCategoryParent = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtLevelLimit = new JTextField();
  JLabel jLabel2 = new JLabel();
  JCheckBox cbxViewAllNodes = new JCheckBox();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JLabel jLabel3 = new JLabel();
  JPanel jPanel11 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();

  JButton btnCallGetCategories = new JButton();
  JTable tblCategories = new JTable();

  JComboBox comboSiteID = new JComboBox();

  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  JButton btnGetAllCategories = new JButton();
  JLabel jLabel4 = new JLabel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel12 = new JLabel();
  GridBagLayout gridBagLayout4 = new GridBagLayout();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JTextField txtReservePriceInclusive = new JTextField();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JTextField txtMinimumReservePrice = new JTextField();
  JLabel jLabel18 = new JLabel();
  JTextField txtCategoryCount = new JTextField();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JCheckBox cbxEnableHttpCompression = new JCheckBox();

  public DialogGetCategories(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      //
      Object[] list = new Object[]
          {
          new ControlTagItem("US", SiteCodeType.US),
          new ControlTagItem("UK", SiteCodeType.UK),
          new ControlTagItem("Germany", SiteCodeType.GERMANY),
          new ControlTagItem("Canada", SiteCodeType.CANADA),
      };
      ComboBoxModel dataModel = new DefaultComboBoxModel(list);
      this.comboSiteID.setModel(dataModel);
      this.comboSiteID.setSelectedIndex(0);

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetCategories() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel3.setLayout(borderLayout2);
    jLabel1.setToolTipText("");
    jLabel1.setText("CategoryParent:");
    jLabel2.setText("LevelLimit:");
    txtCategoryParent.setMinimumSize(new Dimension(60, 21));
    txtCategoryParent.setPreferredSize(new Dimension(60, 21));
    txtCategoryParent.setRequestFocusEnabled(true);
    txtCategoryParent.setText("");
    txtLevelLimit.setMinimumSize(new Dimension(60, 21));
    txtLevelLimit.setPreferredSize(new Dimension(60, 21));
    txtLevelLimit.setSelectionStart(0);
    txtLevelLimit.setText("2");
    jLabel3.setText("SiteID (e.g. US, UK):");
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setPreferredSize(new Dimension(260, 132));
    jPanel1.setLayout(borderLayout4);
    btnCallGetCategories.setText("GetCategories");
    btnCallGetCategories.addActionListener(new DialogGetCategories_btnCallGetCategories_actionAdapter(this));
    jPanel11.setPreferredSize(new Dimension(260, 132));
    jPanel11.setRequestFocusEnabled(true);
    jPanel11.setLayout(borderLayout3);
    panel1.setPreferredSize(new Dimension(400, 261));
    comboSiteID.setMinimumSize(new Dimension(60, 21));
    comboSiteID.setPreferredSize(new Dimension(60, 21));
    comboSiteID.setToolTipText("");
    jPanel4.setLayout(borderLayout5);
    btnGetAllCategories.setText("Get Entire Categories");
    btnGetAllCategories.addActionListener(new DialogGetCategories_btnGetAllCategories_actionAdapter(this));
    jLabel4.setRequestFocusEnabled(true);
    jLabel4.setText("    (skip the above fields)");
    jPanel13.setBorder(BorderFactory.createEtchedBorder());
    jPanel13.setPreferredSize(new Dimension(259, 1));
    jPanel13.setLayout(gridBagLayout1);
    jPanel12.setBorder(null);
    jPanel12.setPreferredSize(new Dimension(10, 50));
    jPanel12.setLayout(gridBagLayout3);
    jPanel9.setPreferredSize(new Dimension(35, 50));
    jPanel9.setLayout(gridBagLayout2);
    jLabel5.setText("    ");
    jLabel6.setText("        ");
    jLabel7.setText("    ");
    jLabel9.setText("        ");
    jLabel10.setText("    ");
    jLabel11.setText("        ");
    cbxViewAllNodes.setText("ViewAllNodes");
    jLabel8.setPreferredSize(new Dimension(150, 10));
    jLabel8.setRequestFocusEnabled(true);
    jLabel8.setText("");
    jPanel5.setPreferredSize(new Dimension(35, 2));
    jLabel12.setPreferredSize(new Dimension(119, 15));
    jLabel12.setText("    ");
    jPanel21.setLayout(gridBagLayout4);
    jPanel21.setPreferredSize(new Dimension(400, 35));
    jLabel13.setText("ReservePriceInclusive:");
    jLabel14.setText("    ");
    jLabel15.setPreferredSize(new Dimension(60, 15));
    jLabel15.setText(" ");
    jLabel16.setText("MinimumReservePrice:");
    jLabel17.setText("    ");
    txtReservePriceInclusive.setBackground(UIManager.getColor("Button.background"));
    txtReservePriceInclusive.setPreferredSize(new Dimension(60, 21));
    txtReservePriceInclusive.setText("");
    txtMinimumReservePrice.setBackground(UIManager.getColor("Button.background"));
    txtMinimumReservePrice.setPreferredSize(new Dimension(60, 21));
    txtMinimumReservePrice.setText("");
    jLabel18.setText(" ");
    txtCategoryCount.setBackground(UIManager.getColor("Button.background"));
    txtCategoryCount.setPreferredSize(new Dimension(60, 21));
    txtCategoryCount.setText("");
    jLabel19.setText("    ");
    jLabel20.setText("Category count:");
    jLabel21.setPreferredSize(new Dimension(60, 15));
    jLabel21.setText(" ");
    cbxEnableHttpCompression.setToolTipText("");
    cbxEnableHttpCompression.setSelected(true);
    cbxEnableHttpCompression.setText("Enable HTTP Compression");
    jPanel5.add(jPanel10, null);
    jPanel5.add(jPanel7, null);
    jPanel3.add(jPanel9, BorderLayout.CENTER);
    jPanel9.add(comboSiteID,      new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel5,    new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel3,   new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel6,   new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel1,   new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel7,   new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(txtCategoryParent,   new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel9,   new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel2,   new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel10,   new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(txtLevelLimit,   new GridBagConstraints(10, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(jLabel11,   new GridBagConstraints(11, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(cbxViewAllNodes,   new GridBagConstraints(12, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel9.add(cbxEnableHttpCompression, new GridBagConstraints(13, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    getContentPane().add(panel1);
    panel1.add(jPanel1, BorderLayout.CENTER);
    panel1.add(jPanel2, BorderLayout.SOUTH);
    panel1.add(jPanel3, BorderLayout.NORTH);
    jPanel3.add(jPanel4,  BorderLayout.SOUTH);
    jPanel4.add(jPanel12,  BorderLayout.NORTH);
    jPanel12.add(btnCallGetCategories,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel12.add(jLabel8,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel12.add(btnGetAllCategories,  new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel12.add(jLabel4,  new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel12.add(jLabel12, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel4.add(jPanel13, BorderLayout.SOUTH);
    jPanel3.add(jPanel5, BorderLayout.NORTH);
    jPanel1.add(jPanel11, BorderLayout.CENTER);

    jPanel11.setBorder(BorderFactory.createEtchedBorder());
    jPanel11.setLayout(borderLayout6);
    jPanel11.add(jPanel21, BorderLayout.NORTH);
    jPanel21.add(jLabel13,       new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(jLabel14,      new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(txtReservePriceInclusive,      new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(jLabel15,      new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(jLabel16,       new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(jLabel17,      new GridBagConstraints(10, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(txtMinimumReservePrice,      new GridBagConstraints(11, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel11.add(jPanel22, BorderLayout.SOUTH);
    jPanel11.add(jPanel23, BorderLayout.WEST);
    jPanel11.add(jPanel24, BorderLayout.EAST);

    jPanel11.add(jScrollPane1, BorderLayout.CENTER);

    jScrollPane1.getViewport().add(tblCategories, null);
    jPanel21.add(jLabel18,     new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(txtCategoryCount,     new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(jLabel19,    new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(jLabel20,    new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel21.add(jLabel21,  new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    this.setSize(new Dimension(900, 400));
  }

  static String[] categoryToColumns(CategoryType cat)
  {
    String[] cols = new String[DialogGetCategories.totalColumns];
    int i = 0;
    cols[i++] = cat.getCategoryID();
    cols[i++] = cat.getCategoryName();
    String[] parentIDs = cat.getCategoryParentID();
    cols[i++] = parentIDs.length == 0 ? "" : parentIDs[0];
    Boolean leafCategory = cat.isLeafCategory();
    cols[i++] = (leafCategory == null)? "":leafCategory.toString();
    Boolean virtual = cat.isVirtual();
    cols[i++] = (virtual == null) ? "" : virtual.toString();
    Boolean expired = cat.isExpired();
    cols[i++] = (expired == null) ? "" : expired.toString();

    Boolean eligible = cat.isSellerGuaranteeEligible();
    cols[i++] = (eligible == null) ? "" : eligible.toString();

    Boolean lotSizeEnabled = cat.isLSD();
    cols[i++] = lotSizeEnabled == null ? "" : lotSizeEnabled.toString();

    Boolean ORPA = cat.isORPA();
    cols[i++] = ORPA == null ? "" : ORPA.toString();

    cols[i++] = cat.isBestOfferEnabled() == null ? "" : Utils.booleanToYesNo(cat.isBestOfferEnabled());

    return cols;
  }

  void btnCallGetCategories_actionPerformed(ActionEvent e) {
    try
    {
      GetCategoriesCall api = new GetCategoriesCall(this.apiContext);

      api.setEnableCompression(this.cbxEnableHttpCompression.isSelected());

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
      };
      api.setDetailLevel(detailLevels);

      SiteCodeType site = (SiteCodeType)((ControlTagItem)comboSiteID.getSelectedItem()).Tag;
      api.setCategorySiteID(site);

      if( txtCategoryParent.getText().length() > 0 )
        api.setParentCategory(new String[] {txtCategoryParent.getText()});

      if( txtLevelLimit.getText().length() > 0 )
        api.setLevelLimit(new Integer(txtLevelLimit.getText()).intValue());

      api.setViewAllNodes(cbxViewAllNodes.isSelected());

      // Call eBay.
      final CategoryType[] cats = api.getCategories();

      int cnt = cats != null ? cats.length : 0;
      this.txtCategoryCount.setText(new Integer(cnt).toString());

    /*  Boolean reservePriceInclusive = api.getReservePriceInclusive();
      if (reservePriceInclusive!=null)   this.txtReservePriceInclusive.setText(reservePriceInclusive.toString());
   */  
      this.txtMinimumReservePrice.setText(api.getMinimumReservePrice().toString());

      // Display items in table.
      TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return DialogGetCategories.totalColumns; }
        public int getRowCount() { return cats == null ? 0 : cats.length;}
        public String getColumnName(int columnIndex){
          return colNames[columnIndex];
        }
        public Object getValueAt(int row, int col)
        {
          CategoryType cat = cats[row];
          return DialogGetCategories.categoryToColumns(cat)[col];
        }
      };

      tblCategories.setModel(dataModel);
    }
    catch(Exception ex)
    {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      ((FrameDemo)this.getParent()).showErrorMessage(msg);
    }
  }

  void btnGetAllCategories_actionPerformed(ActionEvent e) {
    try
    {
      GetCategoriesCall api = new GetCategoriesCall(this.apiContext);
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
      };
      api.setDetailLevel(detailLevels);

      SiteCodeType site = (SiteCodeType)((ControlTagItem)comboSiteID.getSelectedItem()).Tag;
      api.setCategorySiteID(site);

      // Call eBay.
      final CategoryType[] cats = api.getCategories();

      int cnt = cats != null ? cats.length : 0;
      this.txtCategoryCount.setText(new Integer(cnt).toString());

 /*     Boolean reservePriceInclusive = api.getReservePriceInclusive();
      this.txtReservePriceInclusive.setText(reservePriceInclusive.toString());
 */
      this.txtMinimumReservePrice.setText(api.getMinimumReservePrice().toString());

      // Display items in table.
      TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return DialogGetCategories.totalColumns; }
        public int getRowCount() { return cats == null ? 0 : cats.length;}
        public String getColumnName(int columnIndex){
          return colNames[columnIndex];
        }
        public Object getValueAt(int row, int col)
        {
          CategoryType cat = cats[row];
          return DialogGetCategories.categoryToColumns(cat)[col];
        }
      };

      tblCategories.setModel(dataModel);
    }
    catch(Exception ex)
    {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      ((FrameDemo)this.getParent()).showErrorMessage(msg);
    }
  }
}

class DialogGetCategories_btnCallGetCategories_actionAdapter implements java.awt.event.ActionListener {
  DialogGetCategories adaptee;

  DialogGetCategories_btnCallGetCategories_actionAdapter(DialogGetCategories adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCallGetCategories_actionPerformed(e);
  }
}

class DialogGetCategories_btnGetAllCategories_actionAdapter implements java.awt.event.ActionListener {
  DialogGetCategories adaptee;

  DialogGetCategories_btnGetAllCategories_actionAdapter(DialogGetCategories adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetAllCategories_actionPerformed(e);
  }
}
