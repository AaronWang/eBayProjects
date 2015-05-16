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

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.helper.ShippingServiceSelector;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogEditShippingService extends JDialog
{
  boolean resize;
  ShippingServiceSelector shippingServiceSelector;

  private ApiContext apiContext = new ApiContext();

  BorderLayout borderLayout1 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;

  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxShippingService = new JComboBox();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JButton btnAdd = new JButton();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JTextField txtShippingServiceCost = new JTextField();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField txtShippingServiceAdditionalCost = new JTextField();
  JButton btnCancel = new JButton();

  public DialogEditShippingService(Frame frame, String title, ShippingServiceSelector selector, boolean modal)
  {
    super(frame, title, modal);
    try {
      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
      this.shippingServiceSelector = selector;

      jbInit();
      pack();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private DialogEditShippingService() {
    //this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    jPanel1.setLayout(borderLayout2);
    this.setModal(true);
    this.setTitle("eBay SDK for Java - Edit Shipping Service");

    this.jPanel2.setPreferredSize(new Dimension(320, 200));
    jPanel2.setLayout(gridBagLayout2);
    this.jPanel3.setPreferredSize(new Dimension(420, 50));
    jPanel3.setLayout(gridBagLayout3);
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    jPanel4.setLayout(gridBagLayout1);

    jLabel1.setText("ShippingService:");
    jLabel2.setText("        ");
    btnAdd.setText("Add");
    btnAdd.addActionListener(new DialogEditShippingService_btnAdd_actionAdapter(this));
    jLabel3.setText("        ");
    jLabel4.setText("    ");
    jLabel5.setText("ShippingServiceCost:");
    txtShippingServiceCost.setPreferredSize(new Dimension(100, 21));
    jLabel6.setText("   ");
    jLabel7.setText("AdditionalShippingServiceCost:");
    txtShippingServiceAdditionalCost.setMinimumSize(new Dimension(6, 21));
    txtShippingServiceAdditionalCost.setPreferredSize(new Dimension(100, 21));
    txtShippingServiceAdditionalCost.setText("");
    btnCancel.setText("Cancel");
    btnCancel.addActionListener(new DialogEditShippingService_btnCancel_actionAdapter(this));
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(btnAdd, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jLabel3, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(btnCancel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel4, BorderLayout.CENTER);

    jPanel2.add(jLabel1,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel2,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(cbxShippingService,   new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel5,   new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtShippingServiceCost,   new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel6,  new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel7,   new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtShippingServiceAdditionalCost,   new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    this.setSize(new Dimension(420, 450));
    this.setResizable(false);


    ComboBoxModel dataModel = new DefaultComboBoxModel(this.shippingServiceSelector.getCtrlShippingServices());
    this.cbxShippingService.setModel(dataModel);
    this.cbxShippingService.setSelectedIndex(0);
    if (this.shippingServiceSelector.getShippingType() == ShippingTypeCodeType.CALCULATED) {
      this.txtShippingServiceCost.setEditable(false);
      this.txtShippingServiceAdditionalCost.setEditable(false);
    }
  }

  void btnCancel_actionPerformed(ActionEvent e)
  {
    this.dispose();
  }

  void btnAdd_actionPerformed(ActionEvent e) {
    ShippingServiceOptionsType sso = new ShippingServiceOptionsType();

    int idx = this.cbxShippingService.getSelectedIndex();
    sso.setShippingService(((ShippingServiceCodeType)
                            shippingServiceSelector.getCtrlShippingServices()[
                            idx].Tag).value());
    if (this.shippingServiceSelector.getShippingType() ==
        ShippingTypeCodeType.FLAT) {
      String cost = this.txtShippingServiceCost.getText();
      if (cost.length() > 0) {
    	  AmountType at = new AmountType();
    	  at.setValue(Double.parseDouble(cost));
          sso.setShippingServiceCost(at);
      }
      cost = this.txtShippingServiceAdditionalCost.getText();
      if (cost.length() > 0) {
    	  AmountType at = new AmountType();
    	  at.setValue(Double.parseDouble(cost));
          sso.setShippingServiceAdditionalCost(at);
      }
    }
    this.shippingServiceSelector.setSelectedShippingServiceOption(sso);

    this.dispose();
  }
}

class DialogEditShippingService_btnAdd_actionAdapter implements java.awt.event.ActionListener {
  DialogEditShippingService adaptee;

  DialogEditShippingService_btnAdd_actionAdapter(DialogEditShippingService adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnAdd_actionPerformed(e);
  }
}

class DialogEditShippingService_btnCancel_actionAdapter implements java.awt.event.ActionListener {
  DialogEditShippingService adaptee;

  DialogEditShippingService_btnCancel_actionAdapter(DialogEditShippingService adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCancel_actionPerformed(e);
  }
}
