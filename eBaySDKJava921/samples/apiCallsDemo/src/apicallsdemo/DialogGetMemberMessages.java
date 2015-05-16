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
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import com.ebay.sdk.call.GetMemberMessagesCall;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDetailsType;
import com.ebay.soap.eBLBaseComponents.MemberMessageExchangeType;
import com.ebay.soap.eBLBaseComponents.MemberMessageType;
import com.ebay.soap.eBLBaseComponents.MessageStatusTypeCodeType;
import com.ebay.soap.eBLBaseComponents.MessageTypeCodeType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.SellingStatusType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class DialogGetMemberMessages extends JDialog {
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
  BorderLayout borderLayout4 = new BorderLayout();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JButton btnGetMemberMessage = new JButton();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtItemId = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JComboBox cbxMessageType = new JComboBox();
  JComboBox cbxMessageStatus = new JComboBox();
  JTextField txtEntriesPerPage = new JTextField();
  JTextField txtPageNumber = new JTextField();
  JTextField txtStartCreationDate = new JTextField();
  JTextField txtEndCreationDate = new JTextField();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel4 = new JLabel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  BorderLayout borderLayout6 = new BorderLayout();
  JLabel jLabel25 = new JLabel();
  JLabel jLabel26 = new JLabel();
  JTextField txtItemTitle = new JTextField();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JTextField txtItemCurrentPrice = new JTextField();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JTextField txtItemStartTime = new JTextField();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel24 = new JLabel();
  JTextField txtItemEndTime = new JTextField();
  BorderLayout borderLayout7 = new BorderLayout();
  JLabel jLabel27 = new JLabel();
  JLabel jLabel28 = new JLabel();
  JTextField txtNumberOfMessages = new JTextField();
  BorderLayout borderLayout8 = new BorderLayout();
  JPanel jPanel11 = new JPanel();
  JPanel jPanel12 = new JPanel();
  JLabel jLabel29 = new JLabel();
  JLabel jLabel30 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JCheckBox ckbDisplayToPublic = new JCheckBox();
  JLabel jLabel31 = new JLabel();
  JLabel jLabel32 = new JLabel();
  JLabel jLabel33 = new JLabel();


  public DialogGetMemberMessages(Frame frame, String title, boolean modal) {
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

  public DialogGetMemberMessages() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    jPanel1.setLayout(borderLayout2);
    this.setModal(true);
    this.setTitle("eBay SDK for Java - GetMemberMessages");
    this.getContentPane().setLayout(borderLayout4);

    this.jPanel7.setPreferredSize(new Dimension(550, 21));
    jPanel8.setPreferredSize(new Dimension(620, 70));
    this.jPanel10.setPreferredSize(new Dimension(550, 21));
    this.jPanel2.setPreferredSize(new Dimension(550, 180));
    jPanel2.setLayout(gridBagLayout2);
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    this.jPanel3.setPreferredSize(new Dimension(550, 355));
    jPanel3.setLayout(borderLayout3);
    this.jPanel4.setPreferredSize(new Dimension(550, 30));
    jPanel4.setLayout(gridBagLayout1);
    this.jPanel5.setPreferredSize(new Dimension(550, 105));
    jPanel5.setLayout(borderLayout5);
    this.jPanel6.setPreferredSize(new Dimension(550, 220));
    jPanel6.setLayout(borderLayout8);

    jPanel7.setLayout(borderLayout7);
    btnGetMemberMessage.setText("GetMemberMessages");
    btnGetMemberMessage.addActionListener(new DialogGetMemberMessages_btnGetMemberMessage_actionAdapter(this));
    jLabel1.setText("ItemID:");
    jLabel2.setText("    ");
    jLabel3.setText("        ");
    jLabel5.setText("  ");
    jLabel6.setText("    ");
    jLabel7.setText("DisplayToPublic:");
    jLabel9.setText("    ");
    jLabel10.setText("MessageType:");
    jLabel11.setText("    ");
    jLabel12.setText("    ");
    jLabel8.setText("MessageStatus:");
    jLabel14.setText("EndCreationDate:");
    jLabel15.setText("EntriesPerPage:");
    jLabel16.setText("PageNumber:");
    txtItemId.setMinimumSize(new Dimension(85, 21));
    txtItemId.setPreferredSize(new Dimension(85, 21));
    txtItemId.setText("");
    txtEntriesPerPage.setMinimumSize(new Dimension(80, 21));
    txtEntriesPerPage.setOpaque(true);
    txtEntriesPerPage.setPreferredSize(new Dimension(80, 21));
    txtEntriesPerPage.setText("");
    txtPageNumber.setMinimumSize(new Dimension(80, 21));
    txtPageNumber.setPreferredSize(new Dimension(80, 21));
    txtPageNumber.setText("");
    txtStartCreationDate.setMinimumSize(new Dimension(120, 21));
    txtStartCreationDate.setPreferredSize(new Dimension(120, 21));
    txtStartCreationDate.setText("");
    txtEndCreationDate.setMinimumSize(new Dimension(120, 21));
    txtEndCreationDate.setPreferredSize(new Dimension(120, 21));
    txtEndCreationDate.setText("");
    jLabel13.setText("    ");
    jLabel4.setText("StartCreationDate:");
    jPanel8.setBorder(null);
    jPanel8.setLayout(gridBagLayout3);
    jPanel10.setBorder(null);
    jPanel10.setLayout(borderLayout6);
    jLabel25.setText("    ItemTitle:    ");
    jLabel26.setText("    ");
    txtItemTitle.setText("");
    jLabel17.setText("ItemCurrentPrice:");
    jLabel18.setText("   ");
    txtItemCurrentPrice.setMinimumSize(new Dimension(80, 21));
    txtItemCurrentPrice.setPreferredSize(new Dimension(80, 21));
    txtItemCurrentPrice.setText("");
    jLabel19.setText("        ");
    jLabel20.setText("ItemStartTime:");
    jLabel21.setText("   ");
    txtItemStartTime.setMinimumSize(new Dimension(110, 21));
    txtItemStartTime.setPreferredSize(new Dimension(110, 21));
    txtItemStartTime.setText("");
    jLabel22.setText("        ");
    jLabel23.setText("ItemEndTime:");
    jLabel24.setText("   ");
    txtItemEndTime.setMinimumSize(new Dimension(110, 21));
    txtItemEndTime.setPreferredSize(new Dimension(110, 21));
    txtItemEndTime.setText("");
    jLabel27.setText("    Number of messages:   ");
    jLabel28.setPreferredSize(new Dimension(400, 15));
    jLabel28.setText("");
    txtNumberOfMessages.setBackground(UIManager.getColor("Button.background"));
    txtNumberOfMessages.setPreferredSize(new Dimension(60, 21));
    txtNumberOfMessages.setSelectedTextColor(Color.white);
    txtNumberOfMessages.setText("");
    txtNumberOfMessages.setScrollOffset(0);
    jLabel29.setText("  ");
    jLabel30.setText("  ");
    jScrollPane1.getViewport().setBackground(Color.white);
    jLabel31.setText("  ");
    jLabel32.setText("(yyyy-mm-dd hh:mm:ss)");
    jLabel33.setText("(yyyy-mm-dd hh:mm:ss)");
    cbxMessageType.setMinimumSize(new Dimension(85, 21));
    cbxMessageType.setPreferredSize(new Dimension(85, 21));
    cbxMessageStatus.setMinimumSize(new Dimension(85, 21));
    cbxMessageStatus.setPreferredSize(new Dimension(85, 21));
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jPanel5, BorderLayout.NORTH);
    jPanel5.add(jPanel8, BorderLayout.NORTH);
    jPanel5.add(jPanel9, BorderLayout.SOUTH);
    jPanel5.add(jPanel10, BorderLayout.CENTER);
    jPanel10.add(jLabel25, BorderLayout.WEST);
    jPanel10.add(jLabel26, BorderLayout.EAST);
    jPanel10.add(txtItemTitle, BorderLayout.CENTER);
    jPanel3.add(jPanel6, BorderLayout.SOUTH);
    jPanel3.add(jPanel7, BorderLayout.CENTER);
    jPanel7.add(jLabel27, BorderLayout.WEST);
    jPanel7.add(jLabel28, BorderLayout.EAST);
    jPanel7.add(txtNumberOfMessages, BorderLayout.CENTER);
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    jPanel4.add(btnGetMemberMessage, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel2.add(jLabel1,     new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel2,     new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtItemId,      new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel3,     new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel5,     new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel6,     new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel9,     new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel7,    new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel11,    new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel10,    new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel12,   new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel8,    new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel14,    new GridBagConstraints(4, 2, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel15,     new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel16,    new GridBagConstraints(4, 6, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(cbxMessageType,    new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(cbxMessageStatus,    new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtEntriesPerPage,    new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtPageNumber,    new GridBagConstraints(6, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtStartCreationDate,    new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtEndCreationDate,    new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel13,  new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel4,   new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(ckbDisplayToPublic,  new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, -4, 0, 0), 0, 0));
    jPanel2.add(jLabel31, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel32, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel33, new GridBagConstraints(8, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel17, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel18, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(txtItemCurrentPrice,  new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel19,  new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel20,  new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel21,  new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(txtItemStartTime,  new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel22,  new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel23,  new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(jLabel24,  new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel8.add(txtItemEndTime,  new GridBagConstraints(10, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel6.add(jPanel11, BorderLayout.NORTH);
    jPanel6.add(jPanel12, BorderLayout.SOUTH);
    jPanel6.add(jLabel29, BorderLayout.WEST);
    jPanel6.add(jLabel30, BorderLayout.EAST);
    jPanel6.add(jScrollPane1, BorderLayout.CENTER);

    this.setSize(new Dimension(620, 600));
    this.setResizable(false);
  }

  void customInit()
  {
    initStaticControls();
  }

  void initStaticControls()
  {
    DefaultComboBoxModel dataModel = new DefaultComboBoxModel(ControlEntryTypes.messageTypes);
    this.cbxMessageType.setModel(dataModel);
    dataModel = new DefaultComboBoxModel(ControlEntryTypes.messageStatuses);
    this.cbxMessageStatus.setModel(dataModel);
  }

  void btnGetMemberMessage_actionPerformed(ActionEvent e) {
    try {
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      GetMemberMessagesCall api = new GetMemberMessagesCall(this.apiContext);

      api.setDisplayToPublic(new Boolean(this.ckbDisplayToPublic.isSelected()));

      Calendar cd = GuiUtil.getCalendarFromField(this.txtEndCreationDate);
      if (cd != null) {
        api.setEndCreationTime(cd);
      }

      cd = GuiUtil.getCalendarFromField(this.txtStartCreationDate);
      if (cd != null) {
        api.setStartCreationTime(cd);
      }

      String itemId = this.txtItemId.getText().trim();
      if (itemId.length() > 0) {
        api.setItemID(itemId);
      }

      api.setMailMessageType((MessageTypeCodeType)((ControlTagItem)this.cbxMessageType.getSelectedItem()).Tag);
      api.setMessageStatus((MessageStatusTypeCodeType)((ControlTagItem)this.cbxMessageStatus.getSelectedItem()).Tag);
      PaginationType pt = new PaginationType();
      String entriesPerPage = this.txtEntriesPerPage.getText().trim();
      if (entriesPerPage.length() > 0) {
        pt.setEntriesPerPage(new Integer(entriesPerPage));
      }
      String pageNumber = this.txtPageNumber.getText().trim();
      if (pageNumber.length() > 0) {
        pt.setPageNumber(new Integer(pageNumber));
      }
      api.setPagination(pt);
      DetailLevelCodeType[] detailLevel = {DetailLevelCodeType.RETURN_ALL};
      api.setDetailLevel(detailLevel);
      MemberMessageExchangeType[] arrMessages = api.getMemberMessages();
      displayMemberMessages(arrMessages);
    }
    catch (Exception ex) {
      ( (FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }

  void displayMemberMessages(MemberMessageExchangeType[] arrMessages)
  {
    int size = arrMessages != null ? arrMessages.length : 0;
    this.txtNumberOfMessages.setText("  " + new Integer(size).toString());

    String[] columnNames = {"ID", "Type", "Status", "CreationDate", "LastModifiedDate", "Response"};
    Object[] [] dataTable = new Object [size][6];

    if (size > 0) {
      ItemType item = arrMessages[0].getItem();
      SellingStatusType sellingStatus = item.getSellingStatus();
      AmountType currentPrice = sellingStatus.getCurrentPrice();
      if (currentPrice != null) {
        this.txtItemCurrentPrice.setText(new Double(currentPrice.getValue()).toString());
      }
      ListingDetailsType lstDetails = item.getListingDetails();
      this.txtItemStartTime.setText(eBayUtil.toAPITimeString(lstDetails.getStartTime().getTime()));
      this.txtItemEndTime.setText(eBayUtil.toAPITimeString(lstDetails.getEndTime().getTime()));
      this.txtItemTitle.setText(item.getTitle());
      for (int i = 0; i < size; i++) {
        MemberMessageExchangeType mme = arrMessages[i];
        MemberMessageType mmt = mme.getQuestion();
        dataTable[i][0] = mmt.getMessageID();
        dataTable[i][1] = mmt.getMessageType().value();
        dataTable[i][2] = mme.getMessageStatus().value();
        dataTable[i][3] = eBayUtil.toAPITimeString(mme.getCreationDate().
            getTime());
        dataTable[i][4] = eBayUtil.toAPITimeString(mme.getLastModifiedDate().
            getTime());
        String [] responses = mme.getResponse();
        if (responses != null && responses.length > 0) {
          dataTable[i][5] = responses[0];
        }
      }
    }

    JTable jTable1 = new JTable(dataTable, columnNames);
    this.jScrollPane1.setPreferredSize(new Dimension(380, 150));
    this.jScrollPane1.getViewport().add(jTable1, null);
  }
}

class DialogGetMemberMessages_btnGetMemberMessage_actionAdapter implements java.awt.event.ActionListener {
  DialogGetMemberMessages adaptee;

  DialogGetMemberMessages_btnGetMemberMessage_actionAdapter(DialogGetMemberMessages adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetMemberMessage_actionPerformed(e);
  }
}
