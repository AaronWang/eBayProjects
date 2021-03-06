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
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.AddToItemDescriptionCall;

public class DialogAddToItemDescription extends JDialog {
  private ApiContext apiContext = new ApiContext();

  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JButton btnCallAddToItemDescription = new JButton();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JTextField txtItemID = new JTextField();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextPane txtDescriptionToAppend = new JTextPane();
  BorderLayout borderLayout3 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();

  public DialogAddToItemDescription(Frame frame, String title, boolean modal) {
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

  public DialogAddToItemDescription() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnCallAddToItemDescription.setText("AddToItemDescription");
    btnCallAddToItemDescription.addActionListener(new DialogAddToItemDescription_btnCallAddToItemDescription_actionAdapter(this));
    jLabel1.setPreferredSize(new Dimension(60, 15));
    jLabel1.setText("Item ID");
    jLabel2.setPreferredSize(new Dimension(60, 15));
    jLabel2.setText("Description");
    txtDescriptionToAppend.setPreferredSize(new Dimension(200, 100));
    jPanel4.setLayout(borderLayout3);
    txtItemID.setMinimumSize(new Dimension(6, 21));
    txtItemID.setPreferredSize(new Dimension(205, 21));
    txtItemID.setText("");
    jPanel5.setPreferredSize(new Dimension(149, 40));
    jPanel6.setMinimumSize(new Dimension(52, 31));
    jPanel6.setPreferredSize(new Dimension(280, 35));
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    panel1.add(jPanel2,  BorderLayout.CENTER);
    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel1.add(jPanel4,  BorderLayout.NORTH);
    jPanel4.add(jPanel6,  BorderLayout.NORTH);
    jPanel6.add(jLabel1, null);
    jPanel6.add(txtItemID, null);
    jPanel4.add(jPanel7, BorderLayout.CENTER);
    jPanel7.add(jLabel2, null);
    jPanel7.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtDescriptionToAppend, null);
    jPanel1.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(btnCallAddToItemDescription, null);
    this.setSize(new Dimension(300, 210));
    this.setResizable(false);
  }

  void btnCallAddToItemDescription_actionPerformed(ActionEvent e) {
    try
    {
      AddToItemDescriptionCall api = new AddToItemDescriptionCall(this.apiContext);

      String itemID = this.txtItemID.getText();
      if( itemID.length() == 0 )
        throw new SdkException("Please enter item ID.");
      api.setItemID(itemID);

      String desc = this.txtDescriptionToAppend.getText();
      if( desc.length() == 0 )
        throw new SdkException("Please enter description to be appended.");
      api.setDescription(desc);

      api.addToItemDescription();

      ((FrameDemo)this.getParent()).showInfoMessage("The description has been appended successfully.");
    }
    catch(Exception ex)
    {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      ((FrameDemo)this.getParent()).showErrorMessage(msg);
    }
  }
}

class DialogAddToItemDescription_btnCallAddToItemDescription_actionAdapter implements java.awt.event.ActionListener {
  DialogAddToItemDescription adaptee;

  DialogAddToItemDescription_btnCallAddToItemDescription_actionAdapter(DialogAddToItemDescription adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCallAddToItemDescription_actionPerformed(e);
  }
}
