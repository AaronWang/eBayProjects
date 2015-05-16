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
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogGeteBayOfficialTime extends JDialog
{
  private ApiContext apiContext;

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JPanel jPanel2 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel lbeBayOfficialTime = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txteBayOfficialTime = new JTextField();
  JButton btnGeteBayOfficialTime = new JButton();

  public DialogGeteBayOfficialTime(Frame frame, String title, boolean modal) {
      super(frame, title, modal);
    try {
      jbInit();
      pack();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGeteBayOfficialTime() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setModal(true);
    this.setTitle("eBay SDK for Java - GeteBayOfficialTime");

    jPanel1.setLayout(borderLayout2);
    jPanel3.setLayout(gridBagLayout2);
    jPanel2.setLayout(gridBagLayout1);
    lbeBayOfficialTime.setBorder(null);
    lbeBayOfficialTime.setText("eBay Official Time:");
    jLabel2.setText("          ");
    txteBayOfficialTime.setBackground(UIManager.getColor("Button.background"));
    txteBayOfficialTime.setAlignmentY((float) 0.5);
    txteBayOfficialTime.setPreferredSize(new Dimension(110, 21));
    txteBayOfficialTime.setText("");
    txteBayOfficialTime.setHorizontalAlignment(SwingConstants.LEFT);
    btnGeteBayOfficialTime.setText("GeteBayOfficialTime");
    btnGeteBayOfficialTime.addActionListener(new DialogGeteBayOfficialTime_btnGeteBayOfficialTime_actionAdapter(this));
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setMinimumSize(new Dimension(133, 25));
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(btnGeteBayOfficialTime, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel2.add(lbeBayOfficialTime,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txteBayOfficialTime, new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 3), 16, 0));
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);

    jPanel2.setPreferredSize(new Dimension(300, 80));
    jPanel3.setPreferredSize(new Dimension(300, 60));
    this.setSize(new Dimension(320, 140));
    this.setResizable(false);
  }

  void btnGeteBayOfficialTime_actionPerformed(ActionEvent e)
  {
    try
    {
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      GeteBayOfficialTimeCall api = new GeteBayOfficialTimeCall(this.apiContext);
      api.setDetailLevel(detailLevels);
      Date dt = api.geteBayOfficialTime().getTime();
      this.txteBayOfficialTime.setText(eBayUtil.toAPITimeString(dt));
    }
    catch(Exception ex)
    {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGeteBayOfficialTime_btnGeteBayOfficialTime_actionAdapter implements java.awt.event.ActionListener {
  DialogGeteBayOfficialTime adaptee;

  DialogGeteBayOfficialTime_btnGeteBayOfficialTime_actionAdapter(DialogGeteBayOfficialTime adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGeteBayOfficialTime_actionPerformed(e);
  }
}
