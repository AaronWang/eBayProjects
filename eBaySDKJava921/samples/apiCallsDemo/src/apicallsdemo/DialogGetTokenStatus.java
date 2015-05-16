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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.GetTokenStatusCall;
import com.ebay.sdk.call.RevokeTokenCall;
import com.ebay.soap.eBLBaseComponents.TokenStatusType;
import com.ebay.soap.eBLBaseComponents.TokenStatusCodeType;

public class DialogGetTokenStatus extends javax.swing.JDialog {
	private JPanel ctrlPanel;
	private JButton getTokenStatusButton;
	private JButton revokeTokenButton;
	private JPanel statusPanel;
	private JLabel jLabel1;
	private JPanel jPanel1;
	private JTextField jTextField1;
	private JLabel jLabel2;
	private JPanel jPanel2;
	private JTextField jTextField2;
	private JLabel jLabel3;
	private JPanel jPanel3;
	private JTextField jTextField3;
	private JLabel jLabel4;
	private JPanel jPanel4;
	private JTextField jTextField4;
	private ApiContext apiContext;

	public DialogGetTokenStatus(JFrame frame, String title, boolean modal) {
		super(frame, title, modal);
		
        FrameDemo fd = (FrameDemo)frame;
        this.apiContext = fd.getApiContext();	
		
        initGUI();
	}
	
	private void initGUI() {
		try {	
			ctrlPanel = new JPanel();
			FlowLayout ctrlPanelLayout = new FlowLayout();
			getContentPane().add(ctrlPanel, BorderLayout.NORTH);
			ctrlPanel.setLayout(ctrlPanelLayout);
			ctrlPanel.setPreferredSize(new java.awt.Dimension(392, 37));
			
			getTokenStatusButton = new JButton();
			ctrlPanel.add(getTokenStatusButton);
			getTokenStatusButton.setText("GetTokenStatus");
			getTokenStatusButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					getTokenStatusButtonActionPerformed(evt);
				}
			});
			
			revokeTokenButton = new JButton();
			ctrlPanel.add(revokeTokenButton);
			revokeTokenButton.setText("RevokeToken");
			revokeTokenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					revokeTokenButtonActionPerformed(evt);
				}
			});

			statusPanel = new JPanel();
			statusPanel.setBorder(BorderFactory.createEtchedBorder());
			getContentPane().add(statusPanel, BorderLayout.CENTER);
			GridLayout statusPanelLayout = new GridLayout();
			statusPanelLayout.setColumns(1);
			statusPanelLayout.setRows(4);
			statusPanel.setLayout(statusPanelLayout);
			
			//for Status
			jPanel1 = new JPanel();
			jLabel1 = new JLabel();
		    jLabel1.setPreferredSize(new Dimension(90, 15));
			jLabel1.setText("Status : ");
			jTextField1 = new JTextField();
			jTextField1.setPreferredSize(new Dimension(200, 21));
			jPanel1.add(jLabel1, null);
			jPanel1.add(jTextField1, null);
			statusPanel.add(jPanel1);
		
			//for EIASToken
			jPanel2 = new JPanel();
			jLabel2 = new JLabel();
		    jLabel2.setPreferredSize(new Dimension(90, 15));
			jLabel2.setText("EIASToken : ");
			jTextField2 = new JTextField();
			jTextField2.setPreferredSize(new Dimension(200, 21));
			jPanel2.add(jLabel2, null);
			jPanel2.add(jTextField2, null);
			statusPanel.add(jPanel2);
				
			//for ExpirationTime
			jPanel3 = new JPanel();
			jLabel3 = new JLabel();
		    jLabel3.setPreferredSize(new Dimension(90, 15));
			jLabel3.setText("ExpirationTime : ");
			jTextField3 = new JTextField();
			jTextField3.setPreferredSize(new Dimension(200, 21));
			jPanel3.add(jLabel3, null);
			jPanel3.add(jTextField3, null);
			statusPanel.add(jPanel3);
		
			//for RevocationTime
			jPanel4 = new JPanel();
			jLabel4 = new JLabel();
		    jLabel4.setPreferredSize(new Dimension(90, 15));
			jLabel4.setText("RevocationTime : ");
			jTextField4 = new JTextField();
			jTextField4.setPreferredSize(new Dimension(200, 21));
			jTextField4.setEnabled(false);
			jPanel4.add(jLabel4, null);
			jPanel4.add(jTextField4, null);
			statusPanel.add(jPanel4);
			
			setSize(400, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	  private boolean validateApiAccount() {
		  ApiAccount acc = this.apiContext.getApiCredential().getApiAccount();
		  if (acc == null) return false;
		  if (acc.getDeveloper().length() == 0) return false;
		  if (acc.getApplication().length() == 0) return false;
		  if (acc.getCertificate().length() == 0) return false;
		  return true;
	  }
	
	private void getTokenStatus() {
	    try
	    {
	  
	      	if (!validateApiAccount()) {
	      		((FrameDemo)this.getParent()).showErrorMessage("Please fill in Api Account first.");
	      		return;
	    	}
	      	
	      	
			GetTokenStatusCall gtsc = new GetTokenStatusCall(apiContext);
			TokenStatusType tst = gtsc.getTokenStatus();
			jTextField1.setText(tst.getStatus().toString());
			jTextField2.setText(tst.getEIASToken());
			jTextField3.setText(tst.getExpirationTime().getTime().toString());
			if( tst.getStatus() == TokenStatusCodeType.REVOKED_BY_APP ||
			    tst.getStatus() == TokenStatusCodeType.REVOKED_BYE_BAY ||
			    tst.getStatus() == TokenStatusCodeType.REVOKED_BY_USER ) {
				jTextField4.setText(tst.getRevocationTime().getTime().toString());
				jTextField4.setEditable(true);
			} else {
				jTextField4.setText("");
				jTextField4.setEditable(false);
			}
	    }
	    catch(Exception ex)
	    {
	      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
	    }		
	}
	
	private void getTokenStatusButtonActionPerformed(ActionEvent evt) {
	    this.getTokenStatus();
	}
	
	private void revokeTokenButtonActionPerformed(ActionEvent evt) {
	    try
	    {
	      	if (!validateApiAccount()) {
	      		((FrameDemo)this.getParent()).showErrorMessage("Please fill in Api Account first.");
	      		return;
	    	}
	    	
			RevokeTokenCall rtc = new RevokeTokenCall(apiContext);
			rtc.revokeToken();
			this.getTokenStatus();
	    }
	    catch(Exception ex)
	    {
	      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
	    }
	}

}
