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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.sdk.helper.Utils;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.OrderIDArrayType;
import com.ebay.soap.eBLBaseComponents.OrderStatusCodeType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.TradingRoleCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogGetOrders extends JDialog {
  private ApiContext apiContext = new ApiContext();

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel0 = new JPanel();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JButton btnGetOrders = new JButton();

  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel2 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtOrderId = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JTextField txtStartDate = new JTextField();
  JLabel jLabel6 = new JLabel();
  JTextField txtEndDate = new JTextField();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JComboBox cbxOrderStatus = new JComboBox();
  JComboBox cbxOrderRole = new JComboBox();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  BorderLayout borderLayout5 = new BorderLayout();
  BorderLayout borderLayout6 = new BorderLayout();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JTextField txtNumberOfOrders = new JTextField();
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanel10 = new JPanel();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  BorderLayout borderLayout8 = new BorderLayout();
  JPanel jPanel14 = new JPanel();
  JPanel jPanel15 = new JPanel();
  JPanel jPanel16 = new JPanel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel24 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel22 = new JLabel();

  public DialogGetOrders(Frame frame, String title, boolean modal) {
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

  public DialogGetOrders() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setModal(true);
    this.setTitle("eBay SDK for Java - GetOrders");

    jPanel1.setLayout(borderLayout2);
    jPanel3.setLayout(borderLayout3);

    btnGetOrders.setText("GetOrders");
    btnGetOrders.addActionListener(new DialogGetOrders_btnGetOrders_actionAdapter(this));
    jPanel6.setLayout(borderLayout6);
    jPanel5.setMinimumSize(new Dimension(10, 1));
    jPanel5.setPreferredSize(new Dimension(10, 1));
    jPanel2.setLayout(borderLayout4);
    jPanel7.setLayout(gridBagLayout1);
    jLabel1.setText("OrderID(s):");
    jLabel2.setText("        ");
    txtOrderId.setMinimumSize(new Dimension(200, 21));
    txtOrderId.setPreferredSize(new Dimension(200, 21));
    jLabel3.setText("  ");
    jLabel4.setText("StartDate:");
    jLabel5.setText("  ");
    txtStartDate.setMinimumSize(new Dimension(160, 21));
    txtStartDate.setPreferredSize(new Dimension(160, 21));
    txtStartDate.setText("");
    jLabel6.setText("EndDate:");
    txtEndDate.setMinimumSize(new Dimension(160, 21));
    txtEndDate.setPreferredSize(new Dimension(160, 21));
    txtEndDate.setText("");
    jLabel7.setText("  ");
    jLabel8.setText("OrderRole:");
    jPanel8.setLayout(gridBagLayout3);
    jLabel10.setText("  ");
    jLabel11.setText("    ");
    jLabel12.setText("OrderStatus:");
    jLabel9.setPreferredSize(new Dimension(80, 15));
    jLabel9.setText("  ");
    jLabel13.setText("(yyyy-mm-dd hh:mm:ss)");
    jLabel14.setText("(yyyy-mm-dd hh:mm:ss)");
    jPanel4.setBorder(null);
    jPanel9.setLayout(borderLayout5);
    jPanel9.setBorder(null);
    jPanel9.setMaximumSize(new Dimension(32767, 32767));
    jLabel15.setPreferredSize(new Dimension(2, 15));
    jLabel15.setText("  ");
    jLabel16.setPreferredSize(new Dimension(2, 15));
    jLabel16.setText("  ");
    jLabel17.setPreferredSize(new Dimension(3, 2));
    jLabel17.setText(" ");
    jLabel18.setPreferredSize(new Dimension(3, 2));
    jLabel18.setText(" ");
    jLabel19.setText("(separated by a comma)");
    jScrollPane1.getViewport().setBackground(Color.white);
    jLabel20.setText("  Number of orders:  ");
    txtNumberOfOrders.setBackground(UIManager.getColor("activeCaptionBorder"));
    txtNumberOfOrders.setMinimumSize(new Dimension(60, 21));
    txtNumberOfOrders.setPreferredSize(new Dimension(60, 21));

    jPanel0.setLayout(borderLayout7);
    jPanel0.setBorder(BorderFactory.createEtchedBorder());

    jPanel10.setDebugGraphicsOptions(0);
    jPanel10.setPreferredSize(new Dimension(10, 45));
    jPanel10.setRequestFocusEnabled(true);
    jPanel10.setLayout(borderLayout8);
    jPanel14.setBorder(null);
    jPanel14.setPreferredSize(new Dimension(300, 10));
    jPanel14.setLayout(gridBagLayout2);
    jLabel24.setText("    ");
    jPanel8.setBorder(null);
    jPanel7.setMinimumSize(new Dimension(262, 150));
    jLabel21.setPreferredSize(new Dimension(100, 21));
    jLabel21.setText("");
    jLabel22.setText("  ");
    cbxOrderRole.setMinimumSize(new Dimension(160, 21));
    cbxOrderRole.setPreferredSize(new Dimension(160, 21));
    cbxOrderStatus.setMinimumSize(new Dimension(100, 21));
    cbxOrderStatus.setPreferredSize(new Dimension(100, 21));
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel1.add(jPanel0, BorderLayout.CENTER);
    jPanel0.add(jPanel10, BorderLayout.NORTH);
    jPanel10.add(jPanel14, BorderLayout.WEST);
    jPanel14.add(jLabel20, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel14.add(jLabel24, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel14.add(txtNumberOfOrders, new GridBagConstraints(3, 0, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel14.add(jLabel21, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel10.add(jPanel15, BorderLayout.EAST);
    jPanel10.add(jPanel16, BorderLayout.CENTER);
    jPanel0.add(jPanel11, BorderLayout.WEST);
    jPanel0.add(jPanel12, BorderLayout.EAST);
    jPanel0.add(jPanel13, BorderLayout.SOUTH);
    jPanel0.add(jScrollPane1, BorderLayout.CENTER);

    jPanel3.add(jPanel4, BorderLayout.NORTH);
    jPanel3.add(jPanel6, BorderLayout.SOUTH);

    jPanel2.add(jPanel7, BorderLayout.NORTH);
    jPanel7.add(jLabel1,   new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel2,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(txtOrderId,   new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel3,  new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel4,   new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel5,  new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(txtStartDate,   new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel6,   new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(txtEndDate,   new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel7,  new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel8,   new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel11,  new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(cbxOrderRole,   new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel9,   new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel13,  new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel14,  new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel19,   new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel22, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel12, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(cbxOrderStatus, new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jPanel9, BorderLayout.SOUTH);
    jPanel2.add(jPanel8, BorderLayout.CENTER);
    jPanel8.add(jLabel10,     new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(btnGetOrders,  new GridBagConstraints(1, 0, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);

    ComboBoxModel dataModel = new DefaultComboBoxModel(ControlEntryTypes.orderStatuses);
    this.cbxOrderStatus.setModel(dataModel);
    this.cbxOrderStatus.setSelectedIndex(0);

    dataModel = new DefaultComboBoxModel(ControlEntryTypes.orderRoles);
    this.cbxOrderRole.setModel(dataModel);
    this.cbxOrderRole.setSelectedIndex(0);

    jPanel2.setPreferredSize(new Dimension(900, 220));
    jPanel3.setPreferredSize(new Dimension(900, 1));
    jPanel4.setPreferredSize(new Dimension(900, 1));
    jPanel6.setPreferredSize(new Dimension(900, 1));
    jPanel7.setPreferredSize(new Dimension(900, 170));
    jPanel8.setPreferredSize(new Dimension(900, 45));
    jPanel9.setPreferredSize(new Dimension(900, 1));

    this.setSize(new Dimension(900, 500));
  }

  void btnGetOrders_actionPerformed(ActionEvent e)
  {
    try {
      String ids = this.txtOrderId.getText().trim();
      if (ids.length() == 0) {
        throw new Exception("Please enter valid OrderIds.");
      }

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      GetOrdersCall api = new GetOrdersCall(this.apiContext);
      api.setDetailLevel(detailLevels);

      StringTokenizer st = new StringTokenizer(ids, ",");
      ArrayList lstOrders = new ArrayList();
      while (st.hasMoreTokens()) {
        lstOrders.add(st.nextToken());
      }

      int size = lstOrders.size();
      String[] orderIds = new String[size];
      for (int i = 0; i < size; i++) {
        orderIds[i] = lstOrders.get(i).toString().trim();
      }

      OrderIDArrayType oiat = new OrderIDArrayType();
      oiat.setOrderID(orderIds);
      api.setOrderIDArray(oiat);

      int idx = this.cbxOrderStatus.getSelectedIndex();
      OrderStatusCodeType status = (OrderStatusCodeType) ControlEntryTypes.orderStatuses[idx].Tag;
      api.setOrderStatus(status);

      idx = this.cbxOrderRole.getSelectedIndex();
      TradingRoleCodeType role = (TradingRoleCodeType) ControlEntryTypes.orderRoles[idx].Tag;
      api.setOrderRole(role);

      if (this.txtStartDate.getText().trim().length() > 0) {
        Calendar date = GuiUtil.getCalendarFromField(this.txtStartDate);
        api.setCreateTimeFrom(date);
      }

      if (this.txtEndDate.getText().trim().length() > 0) {
        Calendar date = GuiUtil.getCalendarFromField(this.txtEndDate);
        api.setCreateTimeTo(date);
      }

      OrderType[] orders = api.getOrders();
      displayOrders(orders);
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void displayOrders(OrderType[] orders)
  {
    int size = orders != null ? orders.length : 0;
    this.txtNumberOfOrders.setText(new Integer(size).toString());

    String[] columnNames = {"OrderId", "NumberOfTrans", "TransPrice", "CreatedDate", "ShippingServiceSelected", "InsuranceWanted", "IsMultiLegShipping"};
    Object[] [] dataTable = new Object [size][columnNames.length];
    for (int i = 0; i < size; i++) {
      OrderType order = orders[i];
      dataTable[i][0] = order.getOrderID();
      dataTable[i][1] = new Integer(order.getTransactionArray().getTransaction().length).toString();
      dataTable[i][2] = new Double(order.getTotal().getValue()).toString();
      dataTable[i][3] = eBayUtil.toAPITimeString(order.getCreatedTime().getTime());
      ShippingServiceOptionsType sso = order.getShippingServiceSelected();
      if (sso != null) {
        dataTable[i][4] = sso.getShippingService().toString();
      }
      ShippingDetailsType shippingDetails = order.getShippingDetails();
      Boolean insuranceWanted = shippingDetails.isInsuranceWanted();
      if (insuranceWanted != null) {
        dataTable[i][5] = insuranceWanted.toString();
      }
      
      //MultiLegShipping (Added for SDK 777 Release)
      dataTable[i][6] = Utils.booleanToYesNo(order.isIsMultiLegShipping());
    }

    JTable jTable1 = new JTable(dataTable, columnNames);
    jTable1.setEnabled(false);
    this.jScrollPane1.getViewport().add(jTable1, null);
  }

}

class DialogGetOrders_btnGetOrders_actionAdapter implements java.awt.event.ActionListener {
  DialogGetOrders adaptee;

  DialogGetOrders_btnGetOrders_actionAdapter(DialogGetOrders adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetOrders_actionPerformed(e);
  }
}
