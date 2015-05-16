/*
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

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetItemRecommendationsCall;
import com.ebay.sdk.helper.Utils;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.AttributeRecommendationsType;
import com.ebay.soap.eBLBaseComponents.AttributeSetArrayType;
import com.ebay.soap.eBLBaseComponents.AttributeSetType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.GetRecommendationsRequestContainerType;
import com.ebay.soap.eBLBaseComponents.GetRecommendationsResponseContainerType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingAnalyzerRecommendationsType;
import com.ebay.soap.eBLBaseComponents.ListingFlowCodeType;
import com.ebay.soap.eBLBaseComponents.ListingTipArrayType;
import com.ebay.soap.eBLBaseComponents.ListingTipFieldType;
import com.ebay.soap.eBLBaseComponents.ListingTipMessageType;
import com.ebay.soap.eBLBaseComponents.ListingTipType;
import com.ebay.soap.eBLBaseComponents.PricingRecommendationsType;
import com.ebay.soap.eBLBaseComponents.ProductInfoType;
import com.ebay.soap.eBLBaseComponents.ProductListingDetailsType;
import com.ebay.soap.eBLBaseComponents.ProductRecommendationsType;
import com.ebay.soap.eBLBaseComponents.RecommendationEngineCodeType;

/**
 * Demonstrate API GetMyMessages.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogGetItemRecommendations extends JDialog {
  private ApiContext apiContext = new ApiContext();

  // Tips related
  final static String[] tipColNames = new String[] {
    "ID", "FieldID", "Priority", "Message",  "FieldTip", "FieldText", "HelpURL" };

  final static int totalTipColumns = tipColNames.length;

  // AttributeSet related
  final static String[] astColNames = new String[] {
    "CSID", "Version", "# of Attributes" };

  final static int totalAstColumns = astColNames.length;

  // Product related
  final static String[] prodColNames = new String[] {
    "Title", "InfoID", "Avg Start Price", "Avg Sold Price" };

  final static int totalProdColumns = prodColNames.length;

  //
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();

  JPanel panel1 = new JPanel();

  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanelItem = new JPanel();
  JPanel jPanelCommand = new JPanel();
  JPanel jPanel6 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel10 = new JPanel();
  JPanel jPanelItemDataBody = new JPanel();
  JPanel jPanel12 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JButton btnGetItem = new JButton();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel13 = new JPanel();
  JPanel jPanel14 = new JPanel();
  JPanel jPanel15 = new JPanel();
  JPanel jPanel16 = new JPanel();
  JPanel jPanel17 = new JPanel();
  JPanel jPanel18 = new JPanel();
  JPanel jPanel19 = new JPanel();
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanelListingAnalyzerEngine = new JPanel();
  JPanel jPaneProductPricingEngine = new JPanel();
  JPanel jPanelSuggestedAttributesEngine = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  BorderLayout borderLayout7 = new BorderLayout();
  BorderLayout borderLayout8 = new BorderLayout();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel20 = new JPanel();
  JButton btnListingAnalyzer = new JButton();
  JTextField txtTitle = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtStartPrice = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtReservePrice = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField txtBuyItNowPrice = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtPrimaryCategory = new JTextField();
  JLabel jLabel6 = new JLabel();
  JTextField txtSecondaryCategory = new JTextField();
  JLabel jLabel7 = new JLabel();
  BorderLayout borderLayout9 = new BorderLayout();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable tblTips = new JTable();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel21 = new JPanel();
  JLabel jLabel10 = new JLabel();
  JPanel jPanel22 = new JPanel();
  JPanel jPanel23 = new JPanel();
  JPanel jPanel24 = new JPanel();
  JTextField txtProductID = new JTextField();
  JLabel jLabel14 = new JLabel();
  BorderLayout borderLayout10 = new BorderLayout();
  JPanel jPanel25 = new JPanel();
  JPanel jPanel26 = new JPanel();
  JButton btnProductPricingEngine = new JButton();
  JPanel jPanel27 = new JPanel();
  JTextField txtAvgSoldPrice = new JTextField();
  JLabel jLabel9 = new JLabel();
  JTextField txtAvgStartPrice = new JTextField();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JTextField txtCatalogTitle = new JTextField();
  JLabel jLabel17 = new JLabel();
  JPanel jPanel28 = new JPanel();
  JPanel jPanel29 = new JPanel();
  JPanel jPanel30 = new JPanel();
  JTextField txtQuery = new JTextField();
  JLabel jLabel18 = new JLabel();
  BorderLayout borderLayout11 = new BorderLayout();
  JPanel jPanel31 = new JPanel();
  JPanel jPanel32 = new JPanel();
  JButton btnRunSuggestedAttrEngine = new JButton();
  JPanel jPanel33 = new JPanel();
  JPanel jPanel34 = new JPanel();
  GridLayout gridLayout2 = new GridLayout();
  BorderLayout borderLayout12 = new BorderLayout();
  JPanel jPanel35 = new JPanel();
  JPanel jPanel36 = new JPanel();
  BorderLayout borderLayout13 = new BorderLayout();
  JPanel jPanel37 = new JPanel();
  JPanel jPanel38 = new JPanel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel11 = new JLabel();
  BorderLayout borderLayout14 = new BorderLayout();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTable tblAttributeSets = new JTable();
  BorderLayout borderLayout15 = new BorderLayout();
  JScrollPane jScrollPane3 = new JScrollPane();
  JTable tblSuggestedProducts = new JTable();
  JComboBox comboListingFlow = new JComboBox();
  JLabel jLabel12 = new JLabel();
  ItemType fetchedItem;
  
  private void initListingFlowComboBox()
  {
    // Initialize combo box.
    Object[] list = new Object[] {
        new ControlTagItem("AddItem", ListingFlowCodeType.ADD_ITEM),
        new ControlTagItem("RelistItem", ListingFlowCodeType.RELIST_ITEM),
        new ControlTagItem("ReviseItem", ListingFlowCodeType.REVISE_ITEM),
    };
    ComboBoxModel dataModel = new DefaultComboBoxModel(list);
    this.comboListingFlow.setModel(dataModel);
    this.comboListingFlow.setSelectedIndex(0);
  }

  public DialogGetItemRecommendations(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      this.initListingFlowComboBox();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetItemRecommendations() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    jPanel1.setRequestFocusEnabled(true);
    panel1.setPreferredSize(new Dimension(680, 558));
    panel1.setRequestFocusEnabled(true);
    jPanelItem.setLayout(borderLayout4);
    jLabel1.setText("Define the Item. You can use GetItem to get some item data:");
    btnGetItem.setText("GetItem");
    btnGetItem.addActionListener(new DialogGetItemRecommendations_btnGetItem_actionAdapter(this));
    jPanelItemDataBody.setLayout(gridLayout1);
    jPanelItemDataBody.setOpaque(true);
    gridLayout1.setColumns(2);
    gridLayout1.setRows(4);
    jPanelCommand.setLayout(borderLayout5);
    jPanelListingAnalyzerEngine.setDebugGraphicsOptions(0);
    jPanelListingAnalyzerEngine.setLayout(borderLayout6);
    jPaneProductPricingEngine.setLayout(borderLayout7);
    jPanelSuggestedAttributesEngine.setLayout(borderLayout8);
    btnListingAnalyzer.setText("Run Listing Analyzer Engine");
    btnListingAnalyzer.addActionListener(new DialogGetItemRecommendations_btnListingAnalyzer_actionAdapter(this));
    jPanelItem.setPreferredSize(new Dimension(372, 160));
    txtTitle.setPreferredSize(new Dimension(200, 21));
    txtTitle.setToolTipText("");
    txtTitle.setSelectionStart(0);
    txtTitle.setText("DELL new");
    jLabel2.setText("Title:");
    jLabel3.setPreferredSize(new Dimension(120, 15));
    jLabel3.setText("Start Price:");
    txtStartPrice.setPreferredSize(new Dimension(60, 21));
    txtStartPrice.setToolTipText("");
    txtStartPrice.setSelectionStart(1);
    txtStartPrice.setText("1");
    jLabel4.setPreferredSize(new Dimension(120, 15));
    jLabel4.setText("Reserve Price:");
    txtReservePrice.setMinimumSize(new Dimension(6, 21));
    txtReservePrice.setPreferredSize(new Dimension(60, 21));
    txtReservePrice.setSelectionStart(0);
    txtReservePrice.setText("1000");
    txtBuyItNowPrice.setPreferredSize(new Dimension(60, 21));
    txtBuyItNowPrice.setSelectionStart(0);
    txtBuyItNowPrice.setText("3000");
    jLabel5.setPreferredSize(new Dimension(120, 15));
    jLabel5.setText("Buy It Now Price:");
    txtPrimaryCategory.setPreferredSize(new Dimension(60, 21));
    txtPrimaryCategory.setText("80208");
    jLabel6.setPreferredSize(new Dimension(120, 15));
    jLabel6.setText("Primary Category:");
    txtSecondaryCategory.setPreferredSize(new Dimension(60, 21));
    txtSecondaryCategory.setText("");
    jLabel7.setPreferredSize(new Dimension(120, 15));
    jLabel7.setToolTipText("");
    jLabel7.setText("Secondary Category:");
    jTabbedPane1.setPreferredSize(new Dimension(184, 400));
    jPanelCommand.setPreferredSize(new Dimension(184, 500));
    jPanel5.setLayout(borderLayout9);
    jPanel11.setLayout(borderLayout3);
    jScrollPane1.getViewport().setBackground(Color.white);
    jLabel10.setText("Listing Tips");
    jPanel4.setRequestFocusEnabled(true);
    txtProductID.setPreferredSize(new Dimension(200, 21));
    // 83013:2:1134:1344939897:58367207:a3304c042fdc2e3dbc758e43fdd2df24:1:1:1:1195919124
    // 64497:2:1134:1561934745:49362435:019d2bdb5d3e842f32d10acca180906d:1:1:1:9930809901
    txtProductID.setText("79328:2:1431:561576419:57669919:391bc1eb4871c4a4e930a52fca6eccfd:1:1:1:1348602270");
    jLabel14.setText("Catalog product ID:");
    jPanel22.setLayout(borderLayout10);
    btnProductPricingEngine.setText("Run Product Pricing Engine");
    btnProductPricingEngine.addActionListener(new DialogGetItemRecommendations_btnProductPricingEngine_actionAdapter(this));
    txtAvgSoldPrice.setBackground(Color.white);
    txtAvgSoldPrice.setPreferredSize(new Dimension(60, 21));
    txtAvgSoldPrice.setEditable(false);
    txtAvgSoldPrice.setText("");
    jLabel9.setText("Average sold price:");
    txtAvgStartPrice.setBackground(Color.white);
    txtAvgStartPrice.setPreferredSize(new Dimension(60, 21));
    txtAvgStartPrice.setEditable(false);
    txtAvgStartPrice.setText("");
    jLabel15.setText("Average Start Price:");
    jLabel16.setText("(refer to API document about how to get product ID)");
    txtCatalogTitle.setBackground(Color.white);
    txtCatalogTitle.setPreferredSize(new Dimension(160, 21));
    txtCatalogTitle.setEditable(false);
    txtCatalogTitle.setText("");
    jLabel17.setText("Catalog title:");
    txtQuery.setPreferredSize(new Dimension(200, 21));
    txtQuery.setText("DELL Inspiron");
    jLabel18.setText("Query:");
    jPanel28.setLayout(borderLayout11);
    btnRunSuggestedAttrEngine.setText("Run Suggested Attributes Engine");
    btnRunSuggestedAttrEngine.addActionListener(new DialogGetItemRecommendations_btnRunSuggestedAttrEngine_actionAdapter(this));
    jPanel29.setLayout(gridLayout2);
    gridLayout2.setColumns(2);
    gridLayout2.setHgap(5);
    gridLayout2.setRows(1);
    jPanel33.setLayout(borderLayout12);
    jPanel34.setLayout(borderLayout13);
    jLabel8.setText("Suggested Attributes");
    jLabel11.setText("Suggested Products");
    jPanel36.setLayout(borderLayout14);
    jScrollPane2.getViewport().setBackground(Color.white);
    jPanel38.setLayout(borderLayout15);
    jScrollPane3.getViewport().setBackground(Color.white);
    jLabel12.setText("Listing flow:");
    comboListingFlow.setMinimumSize(new Dimension(26, 21));
    comboListingFlow.setPreferredSize(new Dimension(100, 21));
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);


    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel1.add(jPanelItem,  BorderLayout.NORTH);
    jPanelItem.add(jPanel10,  BorderLayout.NORTH);
    jPanel10.add(jLabel1, null);
    jPanel10.add(btnGetItem, null);
    jPanelItem.add(jPanelItemDataBody, BorderLayout.CENTER);
    jPanelItemDataBody.add(jPanel4, null);
    jPanel4.add(jLabel2, null);
    jPanel4.add(txtTitle, null);
    jPanelItemDataBody.add(jPanel19, null);
    jPanelItemDataBody.add(jPanel18, null);
    jPanel18.add(jLabel4, null);
    jPanel18.add(txtReservePrice, null);
    jPanelItemDataBody.add(jPanel17, null);
    jPanel17.add(jLabel5, null);
    jPanel17.add(txtBuyItNowPrice, null);
    jPanelItemDataBody.add(jPanel16, null);
    jPanel16.add(jLabel6, null);
    jPanel16.add(txtPrimaryCategory, null);
    jPanelItemDataBody.add(jPanel15, null);
    jPanel15.add(jLabel7, null);
    jPanel15.add(txtSecondaryCategory, null);
    jPanelItemDataBody.add(jPanel14, null);
    jPanelItemDataBody.add(jPanel13, null);
    jPanelItem.add(jPanel12, BorderLayout.SOUTH);
    jPanel1.add(jPanelCommand,  BorderLayout.CENTER);
    jPanel1.add(jPanel6, BorderLayout.SOUTH);
    jPanelCommand.add(jTabbedPane1, BorderLayout.NORTH);
    jTabbedPane1.add(jPanelListingAnalyzerEngine,   "Listing Analyzer Engine");
    jPanelListingAnalyzerEngine.add(jPanel5,  BorderLayout.NORTH);
    jPanel5.add(jPanel7,  BorderLayout.NORTH);
    jPanel7.add(jLabel12, null);
    jPanel7.add(comboListingFlow, null);
    jPanel5.add(jPanel8, BorderLayout.CENTER);
    jPanel8.add(btnListingAnalyzer, null);
    jPanel5.add(jPanel9, BorderLayout.SOUTH);
    jPanelListingAnalyzerEngine.add(jPanel11,  BorderLayout.CENTER);
    jPanel11.add(jScrollPane1, BorderLayout.CENTER);
    jPanel11.add(jPanel2,  BorderLayout.NORTH);
    jPanel2.add(jLabel10, null);
    jPanel11.add(jPanel21, BorderLayout.SOUTH);
    jScrollPane1.getViewport().add(tblTips, null);
    jPanelListingAnalyzerEngine.add(jPanel20, BorderLayout.SOUTH);
    jTabbedPane1.add(jPaneProductPricingEngine,    "Product Pricing Engine");
    jPaneProductPricingEngine.add(jPanel22,  BorderLayout.NORTH);
    jPaneProductPricingEngine.add(jPanel23,  BorderLayout.CENTER);
    jPaneProductPricingEngine.add(jPanel24, BorderLayout.SOUTH);
    jTabbedPane1.add(jPanelSuggestedAttributesEngine,   "Suggested Attributes Engine");
    jPanelSuggestedAttributesEngine.add(jPanel28,  BorderLayout.NORTH);
    jPanelSuggestedAttributesEngine.add(jPanel29,  BorderLayout.CENTER);
    jPanel29.add(jPanel33, null);
    jPanel33.add(jPanel35,  BorderLayout.NORTH);
    jPanel35.add(jLabel8, null);
    jPanel33.add(jPanel36, BorderLayout.CENTER);
    jPanel36.add(jScrollPane2,  BorderLayout.CENTER);
    jScrollPane2.getViewport().add(tblAttributeSets, null);
    jPanel29.add(jPanel34, null);
    jPanel34.add(jPanel37,  BorderLayout.NORTH);
    jPanel37.add(jLabel11, null);
    jPanel34.add(jPanel38, BorderLayout.CENTER);
    jPanel38.add(jScrollPane3,  BorderLayout.CENTER);
    jScrollPane3.getViewport().add(tblSuggestedProducts, null);
    jPanelSuggestedAttributesEngine.add(jPanel30, BorderLayout.SOUTH);
    jPanel19.add(jLabel3, null);
    jPanel19.add(txtStartPrice, null);
    jPanel22.add(jPanel25,  BorderLayout.NORTH);
    jPanel25.add(jLabel14, null);
    jPanel25.add(txtProductID, null);
    jPanel25.add(jLabel16, null);
    jPanel22.add(jPanel26, BorderLayout.CENTER);
    jPanel26.add(btnProductPricingEngine, null);
    jPanel22.add(jPanel27,  BorderLayout.SOUTH);
    jPanel27.add(jLabel17, null);
    jPanel27.add(txtCatalogTitle, null);
    jPanel27.add(jLabel15, null);
    jPanel27.add(txtAvgStartPrice, null);
    jPanel27.add(jLabel9, null);
    jPanel27.add(txtAvgSoldPrice, null);
    jPanel28.add(jPanel31,  BorderLayout.NORTH);
    jPanel31.add(jLabel18, null);
    jPanel31.add(txtQuery, null);
    jPanel28.add(jPanel32, BorderLayout.SOUTH);
    jPanel32.add(btnRunSuggestedAttrEngine, null);

    jPanel1.setPreferredSize(new Dimension(800, 550));
    this.setSize(new Dimension(658, 567));
  }

  static String getDispTipMessage(ListingTipMessageType msg)
  {
    if( msg == null )
      return "";

    if( msg.getLongMessage() != null )
      return msg.getLongMessage();

    if( msg.getShortMessage() != null )
      return msg.getShortMessage();

    if( msg.getListingTipMessageID() != null )
      return msg.getListingTipMessageID();

    return "";
  }

  static String[] tipToColumns(ListingTipType tip)
  {
    //    "ID", "FieldID", "Priority", "Message",  "FieldTip", "FieldText", "HelpURL" };

    ListingTipFieldType fld = tip.getField();

    String[] cols = new String[totalTipColumns];

    int i = 0;
    cols[i++] = tip.getListingTipID();
    cols[i++] = Utils.getDispString(fld.getListingTipFieldID());
    cols[i++] = tip.getPriority() == null ? "" : tip.getPriority().toString();
    cols[i++] = getDispTipMessage(tip.getMessage());
    cols[i++] = Utils.stripCDATA(fld.getFieldTip());
    cols[i++] = Utils.stripCDATA(fld.getCurrentFieldText());
    cols[i++] = Utils.getDispString(tip.getMessage().getHelpURLPath());

    return cols;
  }

  private void displayTips(ListingTipType[] inTips)
  {
    final ListingTipType[] tips = inTips;

    TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalTipColumns;
      }

      public int getRowCount() {
        return tips != null ? tips.length : 0;
      }

      public String getColumnName(int columnIndex) {
        return tipColNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        ListingTipType t = tips[row];
        return tipToColumns(t)[col];
      }
    };

    this.tblTips.setModel(dataModel);
  }

  static String[] astToColumns(AttributeSetType ast)
  {
    //"CSID", "Version", "# of Attributes"
    String[] cols = new String[totalAstColumns];

    int i = 0;
    cols[i++] = new Integer(ast.getAttributeSetID()).toString();
    cols[i++] = Utils.getDispString(ast.getAttributeSetVersion());

    int child = ast.getAttribute() != null ? ast.getAttribute().length : 0;
    cols[i] = new Integer(child).toString();

    return cols;
  }

  private void displayAttributeSet(AttributeSetType[] inAst) {
	  final AttributeSetType[] asts = inAst;

    TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalAstColumns;
      }

      public int getRowCount() {
        return asts != null ? asts.length : 0;
      }

      public String getColumnName(int columnIndex) {
        return astColNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        AttributeSetType t = asts[row];
        return astToColumns(t)[col];
      }
    };

    this.tblAttributeSets.setModel(dataModel);
  }

  static String[] prodToColumns(ProductInfoType prod) {
    //"Title", "InfoID", "Avg Start Price", "Avg Sold Price"
    String[] cols = new String[totalProdColumns];

    int i = 0;
    cols[i++] = Utils.getDispString(prod.getTitle());
    cols[i++] = Utils.getDispString(prod.getProductInfoID());
    cols[i++] = Utils.amountToString(prod.getAverageStartPrice());
    cols[i] = Utils.amountToString(prod.getAverageSoldPrice());

    return cols;
  }

  private void displayProducts(ProductInfoType[] inProds) {
	  final ProductInfoType[] prods = inProds;

	  TableModel dataModel = new AbstractTableModel() {
      public int getColumnCount() {
        return totalProdColumns;
      }

      public int getRowCount() {
        return prods != null ? prods.length : 0;
      }

      public String getColumnName(int columnIndex) {
        return prodColNames[columnIndex];
      }

      public Object getValueAt(int row, int col) {
        ProductInfoType t = prods[row];
        return prodToColumns(t)[col];
      }
    };

    this.tblSuggestedProducts.setModel(dataModel);
  }

  private ItemType getItemFromGUI(RecommendationEngineCodeType engine)
  {
    String s;

    ItemType item = new ItemType();

    s = this.txtTitle.getText();
    if( s.length() > 0 )
      item.setTitle(s);

    s = this.txtStartPrice.getText();
    if( s.length() > 0 ) {
    	AmountType at = new AmountType();
    	at.setValue(Double.parseDouble(s));
        item.setStartPrice(at);
    }

    s = this.txtReservePrice.getText();
    if( s.length() > 0 ) {
    	AmountType at = new AmountType();
    	at.setValue(Double.parseDouble(s));
    	item.setReservePrice(at);
    }
      
    s = this.txtBuyItNowPrice.getText();
    if( s.length() > 0 ) {
    	AmountType at = new AmountType();
    	at.setValue(Double.parseDouble(s));
        item.setBuyItNowPrice(at);  	
    }


    s = this.txtPrimaryCategory.getText();
    if( s.length() > 0 )
    {
      CategoryType cat = new CategoryType();
      cat.setCategoryID(s);
      item.setPrimaryCategory(cat);
    }

    s = this.txtSecondaryCategory.getText();
    if( s.length() > 0 )
    {
      CategoryType cat = new CategoryType();
      cat.setCategoryID(s);
      item.setSecondaryCategory(cat);
    }

    if( engine == RecommendationEngineCodeType.PRODUCT_PRICING )
    {
      s = this.txtProductID.getText();
      if (s.length() > 0) {
        ProductListingDetailsType pld = new ProductListingDetailsType();
        pld.setProductID(s);
        item.setProductListingDetails(pld);
      }
    }

    return item;
  }

  void btnListingAnalyzer_actionPerformed(ActionEvent e) {
    try {
      GetItemRecommendationsCall api = new GetItemRecommendationsCall(this.apiContext);

      GetRecommendationsRequestContainerType reqContainer = new GetRecommendationsRequestContainerType();

      ControlTagItem ct = (ControlTagItem)this.comboListingFlow.getSelectedItem();
      ListingFlowCodeType flowCodeType = (ListingFlowCodeType)ct.Tag;
      reqContainer.setListingFlow(flowCodeType);
      reqContainer.setRecommendationEngine(new RecommendationEngineCodeType[] {RecommendationEngineCodeType.LISTING_ANALYZER});
      ItemType item = getItemFromGUI(RecommendationEngineCodeType.LISTING_ANALYZER);
      if(flowCodeType == ListingFlowCodeType.ADD_ITEM) {
          item.setItemID(null);
      } else if(fetchedItem != null) {
    	  item.setItemID(fetchedItem.getItemID());
      }
      reqContainer.setItem(item);
      api.setRecommendationsRequests(new GetRecommendationsRequestContainerType[]{reqContainer});

      // Make API call.
      api.getItemRecommendations();

      GetRecommendationsResponseContainerType[] resps = api.getReturnedRecommendations();

      // Display alerts.
      ListingAnalyzerRecommendationsType listingAnalyzerRecommendations = resps[0].getListingAnalyzerRecommendations();
      if(listingAnalyzerRecommendations != null) {
    	  ListingTipArrayType listingTipArrayType = listingAnalyzerRecommendations.getListingTipArray();
    	  if(listingTipArrayType != null) {
    		  ListingTipType[] listingTipType = listingTipArrayType.getListingTip();
    		  displayTips(listingTipType);
    	  }
      } else {
    	  displayTips(null);
      }
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void btnProductPricingEngine_actionPerformed(ActionEvent e) {
    try
    {
      if( this.txtProductID.getText().length() == 0 ) {
        throw new Exception("Please specify the catalog product ID.");
      }

      GetItemRecommendationsCall api = new GetItemRecommendationsCall(this.apiContext);
      GetRecommendationsRequestContainerType reqContainer = new GetRecommendationsRequestContainerType();
      reqContainer.setItem(getItemFromGUI(RecommendationEngineCodeType.PRODUCT_PRICING));
      reqContainer.setListingFlow(ListingFlowCodeType.ADD_ITEM);
      reqContainer.setRecommendationEngine(new RecommendationEngineCodeType[] {RecommendationEngineCodeType.PRODUCT_PRICING});
      api.setRecommendationsRequests(new GetRecommendationsRequestContainerType[]{reqContainer});

      // Make API call.
      api.getItemRecommendations();

      GetRecommendationsResponseContainerType[] resps = api.getReturnedRecommendations();
      PricingRecommendationsType productRecoms = resps[0].getPricingRecommendations();
      if(productRecoms != null) {
    	  ProductInfoType productInfo = productRecoms.getProductInfo();
    	  // Display results.
    	  if( productInfo != null ) {
    		  txtCatalogTitle.setText(Utils.getDispString(productInfo.getTitle()));
    		  txtAvgStartPrice.setText(Utils.amountToString(productInfo.getAverageStartPrice()));
    		  txtAvgSoldPrice.setText(Utils.amountToString(productInfo.getAverageSoldPrice()));
    	  }
      }
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void btnRunSuggestedAttrEngine_actionPerformed(ActionEvent e) {
    String query;

    try {
        GetItemRecommendationsCall api = new GetItemRecommendationsCall(this.apiContext);
        GetRecommendationsRequestContainerType reqContainer = new GetRecommendationsRequestContainerType();
        reqContainer.setRecommendationEngine(new RecommendationEngineCodeType[] {RecommendationEngineCodeType.SUGGESTED_ATTRIBUTES});
        reqContainer.setListingFlow(ListingFlowCodeType.ADD_ITEM);
        reqContainer.setItem(getItemFromGUI(RecommendationEngineCodeType.SUGGESTED_ATTRIBUTES));
        query = txtQuery.getText();
        if(query.length() > 0 ) {
        	reqContainer.setQuery(query);
    	}
        api.setRecommendationsRequests(new GetRecommendationsRequestContainerType[]{reqContainer});

        // Make API call.
        api.getItemRecommendations();

        GetRecommendationsResponseContainerType[] resps = api.getReturnedRecommendations();

        AttributeRecommendationsType attrs = resps[0].getAttributeRecommendations();
        if(attrs != null) {
    	  AttributeSetArrayType attrSetArray = attrs.getAttributeSetArray();
    	  if(attrSetArray != null) {
    		  AttributeSetType[] attrSet = attrSetArray.getAttributeSet();
    	      if(attrSet != null) {
    	    	  displayAttributeSet(attrSet);
    	      }
    	  }
        }
        // Display results.
        ProductRecommendationsType prods = resps[0].getProductRecommendations();
        if(prods != null) {
        	ProductInfoType[] prodInfos = prods.getProduct();
        	if(prodInfos != null) {
        		displayProducts(prodInfos);
        	}
        }
    } catch (Exception ex) {
    	((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void btnGetItem_actionPerformed(ActionEvent e) {
    FrameDemo fd = (FrameDemo)this.getParent();
    fetchedItem = fd.getItem(fd);
    //
    if(fetchedItem != null) {
    	txtTitle.setText(fetchedItem.getTitle());
    	txtPrimaryCategory.setText(fetchedItem.getPrimaryCategory().getCategoryID());
    	CategoryType secondaryCategory = fetchedItem.getSecondaryCategory(); 
    	txtSecondaryCategory.setText((secondaryCategory != null)?secondaryCategory.getCategoryID():"");
    	txtStartPrice.setText((new Double(fetchedItem.getSellingStatus().getCurrentPrice().getValue()).toString()));
    	AmountType amt = fetchedItem.getReservePrice();
    	this.txtReservePrice.setText((amt == null)?"":(new Double(amt.getValue()).toString()));
    	amt = fetchedItem.getBuyItNowPrice();
    	txtBuyItNowPrice.setText((amt == null)?"":(new Double(amt.getValue()).toString()));
    }
    //
  }
}

class DialogGetItemRecommendations_btnListingAnalyzer_actionAdapter implements java.awt.event.ActionListener {
  DialogGetItemRecommendations adaptee;

  DialogGetItemRecommendations_btnListingAnalyzer_actionAdapter(DialogGetItemRecommendations adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnListingAnalyzer_actionPerformed(e);
  }
}

class DialogGetItemRecommendations_btnProductPricingEngine_actionAdapter implements java.awt.event.ActionListener {
  DialogGetItemRecommendations adaptee;

  DialogGetItemRecommendations_btnProductPricingEngine_actionAdapter(DialogGetItemRecommendations adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnProductPricingEngine_actionPerformed(e);
  }
}

class DialogGetItemRecommendations_btnRunSuggestedAttrEngine_actionAdapter implements java.awt.event.ActionListener {
  DialogGetItemRecommendations adaptee;

  DialogGetItemRecommendations_btnRunSuggestedAttrEngine_actionAdapter(DialogGetItemRecommendations adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnRunSuggestedAttrEngine_actionPerformed(e);
  }
}

class DialogGetItemRecommendations_btnGetItem_actionAdapter implements java.awt.event.ActionListener {
  DialogGetItemRecommendations adaptee;

  DialogGetItemRecommendations_btnGetItem_actionAdapter(DialogGetItemRecommendations adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetItem_actionPerformed(e);
  }
}
