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
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.SetNotificationPreferencesCall;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.ApplicationDeliveryPreferencesType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.EnableCodeType;
import com.ebay.soap.eBLBaseComponents.NotificationEnableArrayType;
import com.ebay.soap.eBLBaseComponents.NotificationEnableType;
import com.ebay.soap.eBLBaseComponents.NotificationEventTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SetNotificationPreferencesResponseType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogSetNotificationPreferences extends JDialog
{
  private ApiContext apiContext = new ApiContext();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel23 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel4 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtDeliveryURL = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JButton btnSetNotificationPreferences = new JButton();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JComboBox cbxDeliveryURLStatus = new JComboBox();
  JComboBox cbxNotificationEventStatus = new JComboBox();
  JComboBox cbxNotificationEvent = new JComboBox();
  JTextField txtCallStatus = new JTextField();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField txteBayTime = new JTextField();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel14 = new JLabel();

  public DialogSetNotificationPreferences(Frame frame, String title, boolean modal) {
      super(frame, title, modal);
    try {
      jbInit();
      customInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogSetNotificationPreferences() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setModal(true);
    this.setTitle("eBay SDK for Java - SetNotificationPreferences");
    jPanel1.setLayout(borderLayout2);
    jPanel3.setLayout(gridBagLayout2);
    jLabel23.setText("CallStatus:");
    jPanel2.setLayout(gridBagLayout1);
    jLabel1.setText("DeliveryURL:");
    jLabel2.setText("    ");
    txtDeliveryURL.setMinimumSize(new Dimension(200, 21));
    txtDeliveryURL.setPreferredSize(new Dimension(200, 21));
    txtDeliveryURL.setRequestFocusEnabled(true);
    jLabel4.setText("NotificationEvent:");
    jLabel5.setText("       ");
    jLabel3.setText("          ");
    jPanel4.setLayout(gridBagLayout3);
    btnSetNotificationPreferences.setText("SetNotificationPreferences");
    btnSetNotificationPreferences.addActionListener(new DialogSetNotificationPreferences_btnSetNotificationPreferences_actionAdapter(this));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jLabel7.setText("        ");
    jLabel9.setText("Status:");
    jLabel10.setText("    ");
    jLabel11.setText("        ");
    txtCallStatus.setBackground(UIManager.getColor("Button.background"));
    txtCallStatus.setMinimumSize(new Dimension(80, 21));
    txtCallStatus.setPreferredSize(new Dimension(80, 21));
    txtCallStatus.setText("");
    txtCallStatus.setScrollOffset(0);
    jLabel12.setText("    ");
    jLabel13.setText("Status:");
    jLabel6.setText("        ");
    jLabel8.setText("    ");
    txteBayTime.setBackground(UIManager.getColor("Button.background"));
    txteBayTime.setMinimumSize(new Dimension(120, 21));
    txteBayTime.setPreferredSize(new Dimension(120, 21));
    txteBayTime.setDisabledTextColor(UIManager.getColor("Button.background"));
    txteBayTime.setText("");
    jLabel14.setText("eBayTime:");
    cbxDeliveryURLStatus.setMinimumSize(new Dimension(100, 21));
    cbxDeliveryURLStatus.setPreferredSize(new Dimension(100, 21));
    cbxNotificationEventStatus.setMinimumSize(new Dimension(100, 21));
    cbxNotificationEventStatus.setPreferredSize(new Dimension(100, 21));
    cbxNotificationEvent.setMinimumSize(new Dimension(160, 21));
    cbxNotificationEvent.setPreferredSize(new Dimension(160, 21));
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jLabel23,                  new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(txtCallStatus,        new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jLabel12,         new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jLabel6,    new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(txteBayTime,   new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jLabel8,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jLabel14,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel2.add(jLabel1,   new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtDeliveryURL,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel4,  new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel5, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel7, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel9,  new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel10, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel11, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(cbxDeliveryURLStatus,  new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(cbxNotificationEventStatus,  new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(cbxNotificationEvent,  new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel13,  new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel4.add(btnSetNotificationPreferences, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    jPanel2.setPreferredSize(new Dimension(500, 110));
    jPanel3.setPreferredSize(new Dimension(500, 50));
    jPanel4.setPreferredSize(new Dimension(500, 30));
    this.setSize(new Dimension(500, 220));
    this.setResizable(false);
  }

  void btnSetNotificationPreferences_actionPerformed(ActionEvent e)
  {
    try
    {
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      SetNotificationPreferencesCall api = new SetNotificationPreferencesCall(this.
          apiContext);
      api.setDetailLevel(detailLevels);

      ApplicationDeliveryPreferencesType appDeliveryPref = new
          ApplicationDeliveryPreferencesType();

      String sUrl = this.txtDeliveryURL.getText().trim();
      if (sUrl.length() > 0) {
        int idx = this.cbxDeliveryURLStatus.getSelectedIndex();
        EnableCodeType deliveryURLStatus = (EnableCodeType) ((ControlTagItem)this.cbxDeliveryURLStatus.getSelectedItem()).Tag;
        String uri;
        if (sUrl.indexOf("@") > 0) {
          if (sUrl.startsWith("mailto:")) {
        	  uri = sUrl;
          }
          else {
        	  uri = "mailto:" + sUrl;
          }
        }
        else {
          if (sUrl.startsWith("http:")) {
            uri = sUrl;
          }
          else {
            uri = "http://" + sUrl;
          }
        }
        appDeliveryPref.setApplicationURL(uri);
        appDeliveryPref.setApplicationEnable(deliveryURLStatus);
        api.setApplicationDeliveryPreferences(appDeliveryPref);
      }

      int idx = this.cbxNotificationEvent.getSelectedIndex();
      if (idx > 0) {
        NotificationEventTypeCodeType net = (NotificationEventTypeCodeType)
            ControlEntryTypes.notificationEvents[idx].Tag;
        idx = this.cbxNotificationEventStatus.getSelectedIndex();
        EnableCodeType eventStatus = (EnableCodeType)
            ControlEntryTypes.enabledStatus[idx].Tag;
        NotificationEnableType notification = new NotificationEnableType();
        notification.setEventType(net);
        notification.setEventEnable(eventStatus);
        NotificationEnableArrayType neat = new NotificationEnableArrayType();
        neat.setNotificationEnable(new NotificationEnableType[] {notification});
        api.setUserDeliveryPreferenceArray(neat);
      }

      SetNotificationPreferencesResponseType resp = api.setNotificationPreferences();
      Date dt = resp.getTimestamp().getTime();
      this.txteBayTime.setText(eBayUtil.toAPITimeString(dt));
      this.txtCallStatus.setText(resp.getAck().value());
    }
    catch(Exception ex)
    {
      this.txteBayTime.setText(eBayUtil.toAPITimeString(new Date()));
      this.txtCallStatus.setText("Failure");
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void customInit()
  {
    ComboBoxModel dataModel = new DefaultComboBoxModel(ControlEntryTypes.enabledStatus);
    this.cbxDeliveryURLStatus.setModel(dataModel);
    this.cbxDeliveryURLStatus.setSelectedIndex(0);

    dataModel = new DefaultComboBoxModel(ControlEntryTypes.enabledStatus);
    this.cbxNotificationEventStatus.setModel(dataModel);
    this.cbxNotificationEventStatus.setSelectedIndex(0);

    dataModel = new DefaultComboBoxModel(ControlEntryTypes.notificationEvents);
    this.cbxNotificationEvent.setModel(dataModel);
    this.cbxNotificationEvent.setSelectedIndex(0);
  }
}

class DialogSetNotificationPreferences_btnSetNotificationPreferences_actionAdapter implements java.awt.event.ActionListener {
  DialogSetNotificationPreferences adaptee;

  DialogSetNotificationPreferences_btnSetNotificationPreferences_actionAdapter(DialogSetNotificationPreferences adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnSetNotificationPreferences_actionPerformed(e);
  }
}
