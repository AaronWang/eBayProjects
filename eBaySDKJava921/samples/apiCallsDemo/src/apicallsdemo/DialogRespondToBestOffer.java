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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.RespondToBestOfferCall;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BestOfferActionCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;

/**
 * Demonstrate API RespondToBestOffer.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class DialogRespondToBestOffer extends JDialog {
  private ApiContext apiContext = new ApiContext();

  //
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();

  JPanel panel1 = new JPanel();

  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JButton btnExecuteAPI = new JButton();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel15 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JLabel jLabel3 = new JLabel();
  JPanel jPanelItemID = new JPanel();
  JTextField txtItemID = new JTextField();
  JLabel cpLabel = new JLabel();
  JPanel cpPanel = new JPanel();
  JTextField cpTxtField = new JTextField();
  JLabel cqLabel = new JLabel();
  JPanel cqPanel = new JPanel();
  JTextField cqTxtField = new JTextField();
  JLabel jLabel1 = new JLabel();
  JPanel jPanelBestOfferID = new JPanel();
  JTextField txtBestOfferID = new JTextField();
  JLabel jLabel4 = new JLabel();
  JPanel jPanelAction = new JPanel();
  JLabel jLabel6 = new JLabel();
  JPanel jPanelMisc = new JPanel();
  JButton btnGetBestOffers = new JButton();
  JComboBox comboAction = new JComboBox();
  JPanel jPanel2 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  BorderLayout borderLayout6 = new BorderLayout();
  JTextPane txtSellerResponse = new JTextPane();
  JLabel jLabel5 = new JLabel();

  private void initActionComboBox(JComboBox combo)
  {
    // Initialize combo box.
    Object[] list = new Object[] {
        new ControlTagItem("Accept", BestOfferActionCodeType.ACCEPT),
        new ControlTagItem("Decline", BestOfferActionCodeType.DECLINE),
        new ControlTagItem("Counter", BestOfferActionCodeType.COUNTER)
    };
    ComboBoxModel dataModel = new DefaultComboBoxModel(list);
    combo.setModel(dataModel);
    combo.setSelectedIndex(0);
	  
    combo.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			JComboBox combo = (JComboBox)e.getSource();
			ControlTagItem cti = (ControlTagItem)combo.getSelectedItem();
			if("Counter".equals(cti.Text)) {
				cpTxtField.setEnabled(true);
				cqTxtField.setEnabled(true);
			} else {
				cpTxtField.setText("");
				cqTxtField.setText("");
				cpTxtField.setEnabled(false);
				cqTxtField.setEnabled(false);
			}
		}
    });
  }
  
  public DialogRespondToBestOffer(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();

      initActionComboBox(this.comboAction);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogRespondToBestOffer() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
	  
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    btnExecuteAPI.setMaximumSize(new Dimension(129, 25));
    btnExecuteAPI.setOpaque(true);
    btnExecuteAPI.setPreferredSize(new Dimension(148, 25));
    btnExecuteAPI.setText("RespondToBestOffer");
    btnExecuteAPI.addActionListener(new DialogRespondToBestOffer_btnExecuteAPI_actionAdapter(this));
    jPanel5.setLayout(borderLayout5);
    jPanel6.setPreferredSize(new Dimension(143, 40));
    jPanel6.setLayout(borderLayout4);
    jPanel5.setOpaque(true);
    jPanel5.setPreferredSize(new Dimension(114, 200));
    jPanel7.setLayout(gridLayout1);
    gridLayout1.setColumns(2);
    gridLayout1.setHgap(5);
    gridLayout1.setRows(3);
    gridLayout1.setVgap(5);
    jPanel7.setPreferredSize(new Dimension(114, 45));
    jLabel3.setText("Enter your response below:");
    txtItemID.setPreferredSize(new Dimension(100, 21));
    txtItemID.setText("");
    jPanel1.setOpaque(true);
    jPanel1.setRequestFocusEnabled(true);
    panel1.setPreferredSize(new Dimension(680, 400));
    panel1.setRequestFocusEnabled(true);
    jLabel1.setText("Item ID:");
    jLabel4.setText("BestOffer ID:");
    txtBestOfferID.setPreferredSize(new Dimension(200, 21));
    txtBestOfferID.setText("");
    jLabel6.setText("Action:");
    btnGetBestOffers.setActionCommand("jButton1");
    btnGetBestOffers.setText("GetBestOffers");
    btnGetBestOffers.addActionListener(new DialogRespondToBestOffer_btnGetBestOffers_actionAdapter(this));
    jPanel2.setLayout(borderLayout3);
    jLabel2.setText("Seller Response");
    jPanel10.setLayout(borderLayout6);
    txtSellerResponse.setText("");
    jPanel2.setPreferredSize(new Dimension(89, 70));
    jLabel5.setText("(Comma delimited, e.g., \"6245, 8292\")");
    jPanelAction.add(jLabel6, null);
    jPanelAction.add(comboAction, null);
    jPanelItemID.add(jLabel1, null);
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanel6, BorderLayout.CENTER);
    jPanel6.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(btnExecuteAPI, null);
    jPanel1.add(jPanel5,  BorderLayout.NORTH);
    jPanel5.add(jPanel7, BorderLayout.CENTER);
    jPanelItemID.add(txtItemID, null);

    jPanel7.add(jPanelItemID, null);
    jPanel7.add(jPanelBestOfferID, null);
    jPanelBestOfferID.add(jLabel4, null);
    jPanelBestOfferID.add(txtBestOfferID, null);
    jPanel7.add(jPanelAction, null);
    jPanel7.add(jPanelMisc, null);
    cpLabel.setText("Counter Offer Price(USD):");
    cpTxtField.setPreferredSize(new Dimension(100, 21));
    cpTxtField.setEnabled(false);
    cpPanel.add(cpLabel, null);
    cpPanel.add(cpTxtField, null);
    jPanel7.add(cpPanel, null);
    cqLabel.setText("Counter Offer Quantity:");
    cqTxtField.setPreferredSize(new Dimension(100, 21));
    cqTxtField.setEnabled(false);
    cqPanel.add(cqLabel, null);
    cqPanel.add(cqTxtField, null);
    jPanel7.add(cqPanel, null);
    jPanelMisc.add(jLabel5, null);
    jPanel5.add(jPanel8, BorderLayout.NORTH);
    jPanel8.add(jLabel3, null);
    jPanel8.add(btnGetBestOffers, null);
    jPanel5.add(jPanel2,  BorderLayout.SOUTH);
    jPanel2.add(jPanel9,  BorderLayout.NORTH);
    jPanel9.add(jLabel2, null);
    jPanel2.add(jPanel10, BorderLayout.CENTER);
    jPanel10.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(txtSellerResponse, null);


    panel1.add(jPanel3, BorderLayout.SOUTH);

    jPanel1.setPreferredSize(new Dimension(800, 250));
    this.setSize(new Dimension(649, 300));
  }

  void btnExecuteAPI_actionPerformed(ActionEvent e) {

    FrameDemo fd = (FrameDemo)this.getParent();

    String s;

    try
    {
      RespondToBestOfferCall api = new RespondToBestOfferCall(this.apiContext);

      s = this.txtItemID.getText();
      if( s.length() == 0 )
        throw new Exception("Please enter Item ID.");
      api.setItemID(s);

      s = this.txtBestOfferID.getText();
      if( s.length() == 0 )
        throw new Exception("Please enter BestOffer ID.");

      String ids[] = s.split(",");
      api.setBestOfferIDs(ids);

      ControlTagItem ct = (ControlTagItem)this.comboAction.getSelectedItem();
      BestOfferActionCodeType act = (BestOfferActionCodeType)ct.Tag;
      
      api.setBestOfferAction(act);
      
      if(act == BestOfferActionCodeType.COUNTER) {
    	  AmountType at = new AmountType();
    	  s = cpTxtField.getText();
    	  if( s.length() == 0 ) {
    		  throw new Exception("Please enter Counter Offer Price.");
    	  }
    	  double value = Double.parseDouble(s);
    	  at.setValue(value);
    	  at.setCurrencyID(CurrencyCodeType.USD);
    	  api.setCounterOfferPrice(at);
    	  
    	  s = cqTxtField.getText();
    	  if( s.length() == 0 ) {
    		  throw new Exception("Please enter Counter Offer Quantity.");
    	  }
    	  Integer quantity = Integer.valueOf(s);
    	  api.setCounterOfferQuantity(quantity);
      }

      api.respondToBestOffer();

      fd.showInfoMessage("The response has been sent successfully!");
    }
    catch (Exception ex) {
      fd.showErrorMessage(ex.getMessage());
    }
  }

  void btnGetBestOffers_actionPerformed(ActionEvent e) {
    FrameDemo fd = (FrameDemo)this.getParent();
    fd.getBestOffers(fd);
  }
}

class DialogRespondToBestOffer_btnExecuteAPI_actionAdapter implements java.awt.event.ActionListener {
  DialogRespondToBestOffer adaptee;

  DialogRespondToBestOffer_btnExecuteAPI_actionAdapter(DialogRespondToBestOffer adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnExecuteAPI_actionPerformed(e);
  }
}

class DialogRespondToBestOffer_btnGetBestOffers_actionAdapter implements java.awt.event.ActionListener {
  DialogRespondToBestOffer adaptee;

  DialogRespondToBestOffer_btnGetBestOffers_actionAdapter(DialogRespondToBestOffer adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetBestOffers_actionPerformed(e);
  }
}
