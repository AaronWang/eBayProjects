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
import com.ebay.sdk.call.GetNotificationPreferencesCall;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.soap.eBLBaseComponents.ApplicationDeliveryPreferencesType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.GetNotificationPreferencesResponseType;
import com.ebay.soap.eBLBaseComponents.NotificationEnableArrayType;
import com.ebay.soap.eBLBaseComponents.NotificationEnableType;
import com.ebay.soap.eBLBaseComponents.NotificationRoleCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogGetNotificationPreferences extends JDialog {
  private ApiContext apiContext = new ApiContext();

  BorderLayout borderLayout1 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;

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
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxNotificationRole = new JComboBox();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JButton btnGetNotificationPreferences = new JButton();
  BorderLayout borderLayout4 = new BorderLayout();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JPanel jPanel11 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField txtNumberOfPreferences = new JTextField();


  public DialogGetNotificationPreferences(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      customInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetNotificationPreferences() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    jPanel1.setLayout(borderLayout2);
    this.setModal(true);
    this.setTitle("eBay SDK for Java - GetNotificationPreferences");

    jPanel2.setBorder(null);
    this.jPanel2.setPreferredSize(new Dimension(320, 50));
    jPanel2.setLayout(gridBagLayout1);
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    this.jPanel3.setPreferredSize(new Dimension(420, 220));
    jPanel3.setLayout(borderLayout3);
    jPanel4.setBorder(null);
    this.jPanel4.setPreferredSize(new Dimension(420, 25));
    jPanel4.setLayout(gridBagLayout2);
    jPanel5.setBorder(null);
    this.jPanel5.setPreferredSize(new Dimension(420, 40));
    jPanel5.setLayout(borderLayout4);
    jPanel6.setBorder(BorderFactory.createEtchedBorder());
    this.jPanel6.setPreferredSize(new Dimension(420, 0));

    jPanel7.setLayout(borderLayout5);
    jLabel1.setText("NotificationRole:");
    jLabel2.setText("        ");
    btnGetNotificationPreferences.setText("GetNotificationPreferences");
    btnGetNotificationPreferences.addActionListener(new DialogGetNotificationPreferences_btnGetNotificationPreferences_actionAdapter(this));
    jLabel3.setBorder(null);
    jLabel3.setPreferredSize(new Dimension(34, 8));
    jLabel3.setText("  ");
    jLabel5.setText("    Number of preferences:  ");
    jPanel8.setPreferredSize(new Dimension(10, 1));
    jLabel6.setPreferredSize(new Dimension(200, 0));
    jLabel6.setText("");
    jLabel4.setPreferredSize(new Dimension(6, 8));
    jLabel4.setText("  ");
    txtNumberOfPreferences.setBackground(UIManager.getColor("Button.background"));
    txtNumberOfPreferences.setText("");
    jScrollPane1.getViewport().setBackground(Color.white);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel2.add(jLabel1,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(cbxNotificationRole,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jPanel5, BorderLayout.NORTH);
    jPanel5.add(jLabel3, BorderLayout.NORTH);
    jPanel5.add(jLabel4, BorderLayout.SOUTH);
    jPanel5.add(jLabel5, BorderLayout.WEST);
    jPanel5.add(jLabel6, BorderLayout.EAST);
    jPanel5.add(txtNumberOfPreferences, BorderLayout.CENTER);
    jPanel3.add(jPanel6, BorderLayout.SOUTH);
    jPanel3.add(jPanel7, BorderLayout.CENTER);
    jPanel7.add(jPanel8, BorderLayout.NORTH);
    jPanel7.add(jPanel9, BorderLayout.SOUTH);
    jPanel7.add(jPanel10, BorderLayout.WEST);
    jPanel7.add(jPanel11, BorderLayout.EAST);
    jPanel7.add(jScrollPane1, BorderLayout.CENTER);
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    jPanel4.add(btnGetNotificationPreferences, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    this.setSize(new Dimension(420, 350));
    this.setResizable(false);
  }

  void customInit()
  {
    ComboBoxModel dataModel = new DefaultComboBoxModel(ControlEntryTypes.notificationRoles);
    this.cbxNotificationRole.setModel(dataModel);
    this.cbxNotificationRole.setSelectedIndex(0);
  }

  void btnGetNotificationPreferences_actionPerformed(ActionEvent e) {
    int idx = this.cbxNotificationRole.getSelectedIndex();
    NotificationRoleCodeType role = (NotificationRoleCodeType)ControlEntryTypes.notificationRoles[idx].Tag;

    try {
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      GetNotificationPreferencesCall api = new GetNotificationPreferencesCall(this.apiContext);
      api.setPreferenceLevel(role);
      GetNotificationPreferencesResponseType resp = api.getNotificationPreferences();
      if (role == NotificationRoleCodeType.APPLICATION) {
        ApplicationDeliveryPreferencesType preference = resp.getApplicationDeliveryPreferences();
        displayApplicationPreferences(preference);
      }
      else {
        NotificationEnableArrayType nea = resp.getUserDeliveryPreferenceArray();
        NotificationEnableType[] arrPreferences = nea != null ? nea.getNotificationEnable() : null;
        displayUserPreferences(arrPreferences);
      }
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void displayApplicationPreferences(ApplicationDeliveryPreferencesType preference)
  {
    int size = 1;
    this.txtNumberOfPreferences.setText("  " + new Integer(size).toString());

    String[] columnNames = {"URL", "Status"};
    Object[] [] dataTable = new Object [size][2];

    dataTable[0][0] = preference.getApplicationURL();
    dataTable[0][1] = preference.getApplicationEnable().value();

    JTable jTable1 = new JTable(dataTable, columnNames);
    this.jScrollPane1.setPreferredSize(new Dimension(380, 150));
    this.jScrollPane1.getViewport().add(jTable1, null);
  }

  void displayUserPreferences(NotificationEnableType[] arrPreferences)
  {
    int size = arrPreferences != null ? arrPreferences.length : 0;
    this.txtNumberOfPreferences.setText("  " + new Integer(size).toString());

    String[] columnNames = {"Type", "Status"};
    Object[] [] dataTable = new Object [size][2];

    if (size > 0) {
      for (int i = 0; i < size; i++) {
        NotificationEnableType ne = arrPreferences[i];
        dataTable[i][0] = ne.getEventType().value();
        dataTable[i][1] = ne.getEventEnable().value();
      }
    }

    JTable jTable1 = new JTable(dataTable, columnNames);
    this.jScrollPane1.setPreferredSize(new Dimension(380, 150));
    this.jScrollPane1.getViewport().add(jTable1, null);
  }

}

class DialogGetNotificationPreferences_btnGetNotificationPreferences_actionAdapter implements java.awt.event.ActionListener {
  DialogGetNotificationPreferences adaptee;

  DialogGetNotificationPreferences_btnGetNotificationPreferences_actionAdapter(DialogGetNotificationPreferences adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetNotificationPreferences_actionPerformed(e);
  }
}
