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
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.AddDisputeResponseCall;
import com.ebay.sdk.helper.ServiceControlManager;
import com.ebay.sdk.helper.ShippingServiceHelper;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.DisputeActivityCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogAddDisputeResponse extends JDialog {

  private ApiContext apiContext = new ApiContext();

  SiteCodeType siteID = SiteCodeType.US;

  ControlTagItem[] ctrlShippingServices = new ControlTagItem[] {};

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JPanel jPanel2 = new JPanel();
  JPanel jPanel4 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtDisputeId = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  BorderLayout borderLayout3 = new BorderLayout();
  JLabel jLabel9 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextPane txpMessage = new JTextPane();
  JComboBox cbxActivity = new JComboBox();

  static ControlTagItem[] activities = new ControlTagItem[] {
      new ControlTagItem(DisputeActivityCodeType.SELLER_ADD_INFORMATION.value(),
                         DisputeActivityCodeType.SELLER_ADD_INFORMATION),
      new ControlTagItem(DisputeActivityCodeType.SELLER_COMPLETED_TRANSACTION.value(),
                         DisputeActivityCodeType.SELLER_COMPLETED_TRANSACTION),
      new ControlTagItem(DisputeActivityCodeType.CAME_TO_AGREEMENT_NEED_FVF_CREDIT.value(),
                         DisputeActivityCodeType.CAME_TO_AGREEMENT_NEED_FVF_CREDIT),
      new ControlTagItem(DisputeActivityCodeType.SELLER_END_COMMUNICATION.value(),
                         DisputeActivityCodeType.SELLER_END_COMMUNICATION),

      new ControlTagItem(DisputeActivityCodeType.SELLER_OFFERS_REFUND.value(),
                         DisputeActivityCodeType.SELLER_OFFERS_REFUND),
      new ControlTagItem(DisputeActivityCodeType.SELLER_SHIPPED_ITEM.value(),
                         DisputeActivityCodeType.SELLER_SHIPPED_ITEM),
      new ControlTagItem(DisputeActivityCodeType.SELLER_COMMENT.value(),
                         DisputeActivityCodeType.SELLER_COMMENT),
      new ControlTagItem(DisputeActivityCodeType.SELLER_PAYMENT_NOT_RECEIVED.value(),
                         DisputeActivityCodeType.SELLER_PAYMENT_NOT_RECEIVED),

  };
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JButton btnAddDisputeResponse = new JButton();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JTextField txtCallStatus = new JTextField();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JTextField txteBayTime = new JTextField();
  JPanel jPanelMessage = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel9 = new JPanel();
  JLabel jLabel10 = new JLabel();
  JPanel jPanelSellerShipItem = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JPanel jPanel11 = new JPanel();
  JTextField txtShipmentTrackNumber = new JTextField();
  JLabel jLabel11 = new JLabel();
  JTextField txtShippingTime = new JTextField();
  JLabel jLabel12 = new JLabel();
  JComboBox comboShippingCarrier = new JComboBox();
  JLabel jLabel15 = new JLabel();

  void initShippingServices(SiteCodeType siteId)
  {
    ServiceControlManager manager = ServiceControlManager.getInstance();
    this.ctrlShippingServices = manager.createShippingServiceControl(
      siteId, ShippingServiceHelper.FLAT_SHIPPING_METHODS, this.comboShippingCarrier, true);
    //this.ctrlIntlShippingServices = manager.createShippingServiceControl(siteId, ShippingServiceHelper.INTL_FLATRATE_SHIPPING_SERVICES, this.cbxIntlShippingServiceSelected, true);
  }

  public DialogAddDisputeResponse(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      this.initShippingServices(this.siteID);
      this.comboShippingCarrier.setSelectedIndex(0);

      this.updateShippingService();

      //
      java.util.Calendar calNow = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("GMT"));
      String tmStr = eBayUtil.toAPITimeString(calNow.getTime());
      this.txtShippingTime.setText(tmStr);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogAddDisputeResponse() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setModal(true);
    this.setTitle("eBay SDK for Java - AddDisputeResponse");

    this.setSize(new Dimension(350, 420));

    jPanel1.setLayout(borderLayout2);
    jPanel3.setLayout(borderLayout5);

    jPanel2.setLayout(gridBagLayout1);
    jLabel1.setText("DisputeID:");
    jLabel2.setText("          ");
    txtDisputeId.setMinimumSize(new Dimension(100, 21));
    txtDisputeId.setPreferredSize(new Dimension(100, 21));
    jLabel4.setText("Activity:");
    jLabel5.setText("       ");
    jLabel3.setText("          ");
    jPanel4.setLayout(borderLayout3);
    jLabel9.setText("    MessageText:");
    txpMessage.setText("");
    jPanel5.setMinimumSize(new Dimension(1, 1));
    jPanel5.setPreferredSize(new Dimension(1, 1));
    jPanel7.setBorder(BorderFactory.createEtchedBorder());
    jPanel7.setLayout(gridBagLayout2);
    btnAddDisputeResponse.setText("AddDisputeResponse");
    btnAddDisputeResponse.addActionListener(new DialogAddDisputeResponse_btnAddDisputeResponse_actionAdapter(this));
    jLabel6.setText("CallStatus:");
    jLabel7.setText("    ");
    jLabel8.setToolTipText("");
    jLabel8.setText("    ");
    txtCallStatus.setBackground(UIManager.getColor("Button.background"));
    txtCallStatus.setPreferredSize(new Dimension(80, 21));
    txtCallStatus.setText("");
    jLabel13.setText("    ");
    jLabel14.setText("eBayTime:");
    txteBayTime.setBackground(UIManager.getColor("Button.light"));
    txteBayTime.setPreferredSize(new Dimension(120, 21));
    txteBayTime.setText("");
    jPanelMessage.setLayout(borderLayout4);
    jLabel10.setText("Message Text");
    jScrollPane1.setPreferredSize(new Dimension(11, 40));
    jPanelSellerShipItem.setLayout(gridLayout1);
    gridLayout1.setRows(3);
    gridLayout1.setVgap(3);
    txtShipmentTrackNumber.setPreferredSize(new Dimension(160, 21));
    txtShipmentTrackNumber.setText("");
    jLabel11.setPreferredSize(new Dimension(120, 15));
    jLabel11.setText("Shipment Track Number:");
    txtShippingTime.setPreferredSize(new Dimension(120, 21));
    txtShippingTime.setText("");
    jLabel12.setText("Shipping Time:");
    jLabel15.setPreferredSize(new Dimension(120, 15));
    jLabel15.setText("Shipping Carrier Used:");
    jPanelSellerShipItem.setBorder(BorderFactory.createEtchedBorder());
    comboShippingCarrier.setPreferredSize(new Dimension(160, 21));
    comboShippingCarrier.setPopupVisible(false);
    cbxActivity.addItemListener(new DialogAddDisputeResponse_cbxActivity_itemAdapter(this));
    cbxActivity.setMinimumSize(new Dimension(100, 21));
    cbxActivity.setPreferredSize(new Dimension(100, 21));
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jPanel6, BorderLayout.NORTH);
    jPanel6.add(btnAddDisputeResponse, null);
    jPanel3.add(jPanel5, BorderLayout.SOUTH);
    jPanel3.add(jPanel7, BorderLayout.CENTER);
    jPanel2.add(jLabel1,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtDisputeId,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel5, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(cbxActivity,        new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 4, 0));
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    jPanel4.add(jPanelMessage,  BorderLayout.NORTH);
    jPanelMessage.add(jScrollPane1, BorderLayout.CENTER);
    jPanelMessage.add(jPanel9, BorderLayout.NORTH);
    jPanel9.add(jLabel10, null);
    jPanel4.add(jPanelSellerShipItem, BorderLayout.CENTER);
    jPanelSellerShipItem.add(jPanel8, null);
    jPanel8.add(jLabel15, null);
    jPanel8.add(comboShippingCarrier, null);
    jPanelSellerShipItem.add(jPanel11, null);
    jPanel11.add(jLabel11, null);
    jPanel11.add(txtShipmentTrackNumber, null);
    jPanelSellerShipItem.add(jPanel10, null);
    jPanel10.add(jLabel12, null);
    jPanel10.add(txtShippingTime, null);
    jScrollPane1.getViewport().add(txpMessage, null);
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel7.add(jLabel6,   new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel7,    new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel8,    new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(txtCallStatus,     new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel13,   new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(jLabel14,   new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel7.add(txteBayTime,   new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    ComboBoxModel dataModel = new DefaultComboBoxModel(DialogAddDisputeResponse.activities);
    this.cbxActivity.setModel(dataModel);
    this.cbxActivity.setSelectedIndex(0);

    jPanel2.setPreferredSize(new Dimension(300, 80));
    jPanel3.setPreferredSize(new Dimension(300, 130));
    jPanel4.setPreferredSize(new Dimension(300, 130));
    jPanel6.setPreferredSize(new Dimension(300, 35));
    jPanel7.setPreferredSize(new Dimension(300, 95));
    jPanel1.setPreferredSize(new Dimension(320, 370));
    this.setSize(new Dimension(354, 424));
    this.setResizable(false);
  }

  void btnAddDisputeResponse_actionPerformed(ActionEvent e) {

    String s;

    try {
      String disputeId = this.txtDisputeId.getText().trim();
      if (disputeId.length() == 0) {
        throw new Exception("Please enter a DisputeId.");
      }

      int idx = this.cbxActivity.getSelectedIndex();
      ControlTagItem activity = DialogAddDisputeResponse.activities[idx];
      DisputeActivityCodeType dact = (DisputeActivityCodeType) activity.Tag;

      AddDisputeResponseCall api = new AddDisputeResponseCall(this.apiContext);
      api.setDisputeID(disputeId);
      api.setMessageText(this.txpMessage.getText());
      api.setDisputeActivity(dact);

      if( dact.equals(DisputeActivityCodeType.SELLER_SHIPPED_ITEM) )
      {
        s = this.txtShipmentTrackNumber.getText();
        if( s.length() > 0 )
          api.setShipmentTrackNumber(s);

        s = this.txtShippingTime.getText();
        if( s.length() > 0 )
        {
          java.util.Calendar shipTime = GuiUtil.getCalendarFromField(this.
              txtShippingTime);
          api.setShippingTime(shipTime);
        }

        ControlTagItem ct = (ControlTagItem)this.comboShippingCarrier.getSelectedItem();
        if( !ct.Text.equals("None") )
        {
          ShippingServiceCodeType ssc = (ShippingServiceCodeType) ct.Tag;
          api.setShippingCarrierUsed(ssc.toString());
        }
        //throw new Exception("Please select a shipping carrier.");
      }

      api.addDisputeResponse();

      ((FrameDemo)this.getParent()).showInfoMessage("The response has been added successfully.");
    }
    catch(Exception ex) {
      this.txteBayTime.setText(eBayUtil.toAPITimeString(new Date()));
      this.txtCallStatus.setText("Failure");
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void updateShippingService()
  {
    Object o = this.cbxActivity.getSelectedItem();
    if( o != null )
    {
      ControlTagItem ct = (ControlTagItem)o;
      DisputeActivityCodeType act = (DisputeActivityCodeType)ct.Tag;
      boolean enabled = act.equals(DisputeActivityCodeType.SELLER_SHIPPED_ITEM);

      //this.jPanelSellerShipItem.setEnabled(enabled);
      this.comboShippingCarrier.setEnabled(enabled);
      this.txtShipmentTrackNumber.setEnabled(enabled);
      this.txtShippingTime.setEnabled(enabled);
    }
  }

  void cbxActivity_itemStateChanged(ItemEvent e) {
    this.updateShippingService();
  }
}

class DialogAddDisputeResponse_btnAddDisputeResponse_actionAdapter implements java.awt.event.ActionListener {
  DialogAddDisputeResponse adaptee;

  DialogAddDisputeResponse_btnAddDisputeResponse_actionAdapter(DialogAddDisputeResponse adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnAddDisputeResponse_actionPerformed(e);
  }
}

class DialogAddDisputeResponse_cbxActivity_itemAdapter implements java.awt.event.ItemListener {
  DialogAddDisputeResponse adaptee;

  DialogAddDisputeResponse_cbxActivity_itemAdapter(DialogAddDisputeResponse adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.cbxActivity_itemStateChanged(e);
  }
}
