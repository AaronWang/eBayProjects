/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
 */

package apicallsdemo;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.CallRetry;
import com.ebay.sdk.helper.ui.DialogAccount;
import com.ebay.sdk.helper.ui.DialogFetchToken;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.ebay.sdk.util.SdkProxySelector;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import com.ebay.sdk.util.XmlUtil;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */

public class FrameDemo extends JFrame implements KeyListener,
		ListSelectionListener, MouseListener {
	// private String signInUrl =
	// "http://my.sandbox.ebay.com/ws/eBayISAPI.dll?SignIn";
	private ApiContext apiContext = new ApiContext();
	public static final String TITLE = "eBay SDK for Java - ApiCallsDemo";
	static final String CONFIG_XML_NAME = "Config.xml";

	long lastMouseClickedTime;

	static ArrayList lstCalls = new ArrayList();

	static {
		lstCalls.add("AddDispute");
		lstCalls.add("AddDisputeResponse");
		lstCalls.add("AddItem");
		lstCalls.add("AddOrder");
		lstCalls.add("AddSecondChanceItem");
		lstCalls.add("AddToItemDescription");
		lstCalls.add("EndItem");
		lstCalls.add("GetAccount");
		lstCalls.add("GetAllBidders");
		lstCalls.add("GetCategories");
		lstCalls.add("GetDispute");
		lstCalls.add("GeteBayOfficialTime");
		lstCalls.add("GetFeedback");
		lstCalls.add("GetItem");
		lstCalls.add("GetItemShipping");
		lstCalls.add("GetItemTransactions");
		lstCalls.add("GetMemberMessages");
		lstCalls.add("GetMyeBayBuying");
		lstCalls.add("GetMyeBaySelling");
		lstCalls.add("GetNotificationPreferences");
		lstCalls.add("GetOrders");
		lstCalls.add("GetSellerEvents");
		lstCalls.add("GetSellerList");
		lstCalls.add("GetSellerTransactions");
		lstCalls.add("GetSuggestedCategories");
		lstCalls.add("GetTokenStatus");
		lstCalls.add("GetUser");
		lstCalls.add("GetUserDisputes");
		lstCalls.add("LeaveFeedback");
		lstCalls.add("RelistItem");
		lstCalls.add("ReviseCheckoutStatus");
		lstCalls.add("ReviseItem");
		lstCalls.add("SellerReverseDispute");
		lstCalls.add("SetNotificationPreferences");
		lstCalls.add("GetMyMessages");
		lstCalls.add("DeleteMyMessages");
		lstCalls.add("ReviseMyMessages");
		lstCalls.add("GetApiAccessRules");
		lstCalls.add("GetStore");
		lstCalls.add("SetStoreCustomPage");
		lstCalls.add("GetStoreCustomPage");
		lstCalls.add("GetStoreOptions");
		lstCalls.add("SetStore");
		lstCalls.add("GetStorePreferences");
		lstCalls.add("SetStorePreferences");
		lstCalls.add("GetItemRecommendations");
		lstCalls.add("SendInvoice");
		lstCalls.add("GetBestOffers");
		lstCalls.add("RespondToBestOffer");
		lstCalls.add("FetchToken");
		lstCalls.add("UploadPictures");

		// Sort the list.
		Object[] ary = lstCalls.toArray();
		Arrays.sort(ary);

		lstCalls.clear();
		for (int i = 0; i < ary.length; i++)
			lstCalls.add(ary[i]);
	}

	JPanel contentPane;
	JMenuBar jMenuBar1 = new JMenuBar();
	JMenu jMenuFile = new JMenu();
	JMenuItem jMenuFileExit = new JMenuItem();
	JMenu jMenuHelp = new JMenu();
	JMenuItem jMenuHelpAbout = new JMenuItem();
	JLabel jLabel1 = new JLabel();
	JMenuItem jMenuItemAccount = new JMenuItem();
	JButton btnAccount = new JButton();
	JPanel jPanel1 = new JPanel();
	JPanel jPanel2 = new JPanel();
	JPanel jPanel3 = new JPanel();
	GridLayout gridLayout1 = new GridLayout();
	BorderLayout borderLayout1 = new BorderLayout();
	JPanel jPanel10 = new JPanel();
	JPanel jPanelGetItemTransaction = new JPanel();
	JButton btnGetItemTransaction = new JButton();
	BorderLayout borderLayout2 = new BorderLayout();
	JPanel jPanel4 = new JPanel();
	JPanel jPanel5 = new JPanel();
	JPanel jPanel6 = new JPanel();
	JPanel jPanel7 = new JPanel();
	JScrollPane jScrollPane1 = new JScrollPane();

	DefaultListModel lstModel = new DefaultListModel();
	JList lstCommands = new JList(lstModel);

	TitledBorder titledBorder1;
	TitledBorder titledBorder2;
	TitledBorder titledBorder3;

	GridBagLayout gridBagLayout2 = new GridBagLayout();
	JButton btnRun = new JButton();

	// Construct the frame
	public FrameDemo() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();

			// Enable Call-Retry.
			CallRetry cr = new CallRetry();
			cr.setMaximumRetries(3);
			cr.setDelayTime(1000); // Wait for one second between each
									// retry-call.
			String[] apiErrorCodes = new String[] { "10007", // "Internal error to the application."
					"931", // "Validation of the authentication token in API request failed."
					"521", // Test of Call-Retry:
							// "The specified time window is invalid."
					"124" // Test of Call-Retry: "Developer name invalid."
			};
			cr.setTriggerApiErrorCodes(apiErrorCodes);

			// Set trigger exceptions for CallRetry.
			// Build a dummy SdkSoapException so that we can get its Class.
			java.lang.Class[] tcs = new java.lang.Class[] { com.ebay.sdk.SdkSoapException.class };
			cr.setTriggerExceptions(tcs);

			apiContext.setCallRetry(cr);

			apiContext.setTimeout(180000);

			this.loadConfiguration();

			// Add listener for token renewal event.
			apiContext.getApiCredential().addTokenEventListener(
					new DemoTokenEventListener(this));
			customInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadConfiguration() throws Exception {
		String xmlPath = CONFIG_XML_NAME;
		Document doc = XmlUtil.createDomByPathname(xmlPath);// getConfigXmlText()

		Node config = XmlUtil.getChildByName(doc, "Configuration");
		if (config == null)
			throw new Exception("<Configuration> was not found.");

		String s;

		// this.apiContext = new ApiContext();

		s = XmlUtil.getChildString(config, "ServerUrl").trim();
		this.apiContext.setApiServerUrl(s);

		s = XmlUtil.getChildString(config, "EpsServerUrl").trim();
		this.apiContext.setEpsServerUrl(s);

		s = XmlUtil.getChildString(config, "SignInUrl").trim();
		this.apiContext.setSignInUrl(s);

		ApiCredential apiCred = new ApiCredential();
		this.apiContext.setApiCredential(apiCred);

		ApiAccount ac = new ApiAccount();
		apiCred.setApiAccount(ac);

		//
		Node apiCredential = XmlUtil.getChildByName(config, "ApiCredential");
		s = XmlUtil.getChildString(apiCredential, "Developer");
		ac.setDeveloper(s);
		s = XmlUtil.getChildString(apiCredential, "Application");
		ac.setApplication(s);
		s = XmlUtil.getChildString(apiCredential, "Certificate");
		ac.setCertificate(s);

		Node eBayCredential = XmlUtil.getChildByName(config, "eBayCredential");

		s = XmlUtil.getChildString(eBayCredential, "Token");
		apiCred.seteBayToken(s.trim());

		s = XmlUtil.getChildString(config, "RuName");
		if (s.length() > 0) {
			this.apiContext.setRuName(s);
		}

		s = XmlUtil.getChildString(config, "Timeout");
		if (s.length() > 0) {
			int timeout = Integer.parseInt(s);
			this.apiContext.setTimeout(timeout);
		}
		// proxy setting
		Node proxy = XmlUtil.getChildByName(config, "Proxy");

		if (proxy != null) {
			String host = XmlUtil.getChildString(proxy, "Host");
			String port = XmlUtil.getChildString(proxy, "Port");
			if (host.length() > 0 && port.length() > 0) {
				SdkProxySelector ps = null;
				String username = XmlUtil.getChildString(proxy, "Username");
				String password = XmlUtil.getChildString(proxy, "Password");
				if (username.length() > 0 && password.length() > 0) {
					ps = new SdkProxySelector(host, Integer.parseInt(port),
							username, password);
				} else {
					ps = new SdkProxySelector(host, Integer.parseInt(port));
				}
				ps.register();
			}
		}
	}

	// Component initialization
	private void jbInit() throws Exception {
		contentPane = (JPanel) getContentPane();

		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");
		titledBorder3 = new TitledBorder("");

		contentPane.setLayout(borderLayout1);
		setSize(new Dimension(449, 413));
		setTitle("eBay SDK for Java - ApiCallsDemo");
		jMenuFile.setText("File");
		jMenuFileExit.setText("Exit");
		jMenuFileExit
				.addActionListener(new FrameDemo_jMenuFileExit_ActionAdapter(
						this));
		jMenuHelp.setText("Help");
		jMenuHelpAbout.setText("About");
		jMenuHelpAbout
				.addActionListener(new FrameDemo_jMenuHelpAbout_ActionAdapter(
						this));
		jLabel1.setMaximumSize(new Dimension(330, 15));
		jLabel1.setOpaque(false);
		jLabel1.setRequestFocusEnabled(true);
		jLabel1.setToolTipText("");
		jLabel1.setVerifyInputWhenFocusTarget(true);
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Select an API from the list and press button Run to launch the demo.");
		jMenuItemAccount.setRolloverEnabled(false);
		jMenuItemAccount.setText("Account");
		jMenuItemAccount
				.addActionListener(new FrameDemo_jMenuItemAccount_actionAdapter(
						this));
		btnAccount.setMaximumSize(new Dimension(119, 21));
		btnAccount.setMinimumSize(new Dimension(119, 21));
		btnAccount.setPreferredSize(new Dimension(130, 21));
		btnAccount.setText("Config API Account");
		btnAccount.addActionListener(new FrameDemo_btnAccount_actionAdapter(
				this));
		jPanel1.setLayout(gridLayout1);
		gridLayout1.setColumns(1);
		gridLayout1.setRows(2);
		gridLayout1.setVgap(0);
		jPanel3.setLayout(borderLayout2);
		btnGetItemTransaction.setPreferredSize(new Dimension(148, 25));
		btnGetItemTransaction.setText("GetItemTransaction");

		jPanel6.setPreferredSize(new Dimension(50, 10));
		jPanel6.setLayout(gridBagLayout2);
		jPanel5.setPreferredSize(new Dimension(50, 10));
		jPanel2.setBorder(BorderFactory.createEtchedBorder());
		jPanel2.setPreferredSize(new Dimension(50, 50));
		jPanel4.setPreferredSize(new Dimension(10, 15));
		jPanel10.setPreferredSize(new Dimension(140, 31));
		btnRun.setPreferredSize(new Dimension(180, 25));
		btnRun.setText("Run");
		btnRun.addActionListener(new FrameDemo_btnRun_actionAdapter(this));
		jMenuFile.add(jMenuItemAccount);
		jMenuFile.add(jMenuFileExit);
		jMenuHelp.add(jMenuHelpAbout);
		jMenuBar1.add(jMenuFile);
		jMenuBar1.add(jMenuHelp);
		contentPane.add(jPanel1, BorderLayout.NORTH);
		jPanel1.add(jPanel10, null);
		jPanel10.add(btnAccount, null);
		jPanel1.add(jLabel1, null);
		contentPane.add(jPanel3, BorderLayout.CENTER);
		jPanel3.add(jPanel4, BorderLayout.NORTH);
		jPanel3.add(jPanel5, BorderLayout.WEST);
		jPanel3.add(jPanel6, BorderLayout.EAST);
		jPanel3.add(jPanel7, BorderLayout.SOUTH);
		jPanel3.add(jScrollPane1, BorderLayout.CENTER);
		jScrollPane1.setViewportView(lstCommands);
		contentPane.add(jPanel2, BorderLayout.SOUTH);
		jPanel2.add(btnRun, null);
		jPanelGetItemTransaction.add(btnGetItemTransaction, null);

		setJMenuBar(jMenuBar1);
	}

	void customInit() {
		lstCommands.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		int size = lstCalls.size();
		for (int i = 0; i < size; i++) {
			lstModel.addElement(lstCalls.get(i));
		}

		lstCommands.addKeyListener(this);
		lstCommands.addListSelectionListener(this);
		lstCommands.addMouseListener(this);
	}

	public void select() {
		lstCommands.setSelectedIndex(0);
		lstCommands.grabFocus();
	}

	private boolean readyToMakeApiCall() {
		if (!GuiUtil.isApiContextFilled(apiContext, true)) {
			showInfoMessage("Please complete account information first.");
			return false;
		}
		return true;
	}

	// File | Exit action performed
	public void jMenuFileExit_actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	// Help | About action performed
	public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
		FrameDemo_AboutBox dlg = new FrameDemo_AboutBox(this);
		Dimension dlgSize = dlg.getPreferredSize();
		Dimension frmSize = getSize();
		Point loc = getLocation();
		dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
				(frmSize.height - dlgSize.height) / 2 + loc.y);
		dlg.setModal(true);
		dlg.pack();
		dlg.setVisible(true);
	}

	// Overridden so we can exit when window is closed
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			jMenuFileExit_actionPerformed(null);
		}
	}

	private void showAccountDialog() {
		DialogAccount dlg = new DialogAccount(this, apiContext,
				"Config Account", true);
		// dlg.setSignInUrl(signInUrl);

		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);

		// if( !dlg.isCancelled() )
		// signInUrl = dlg.getSignInUrl();
	}

	void jMenuItemAccount_actionPerformed(ActionEvent e) {
		showAccountDialog();
	}

	void btnAccount_actionPerformed(ActionEvent e) {
		showAccountDialog();
	}

	public ApiContext getApiContext() {
		return apiContext;
	}

	public void setApiContext(ApiContext apiContext) {
		this.apiContext = apiContext;
	}

	public void showErrorMessage(String error) {
		JOptionPane.showMessageDialog(this, error, TITLE,
				JOptionPane.ERROR_MESSAGE);
	}

	public void showInfoMessage(String error) {
		JOptionPane.showMessageDialog(this, error, TITLE,
				JOptionPane.INFORMATION_MESSAGE);
	}

	// KeyListner interfaces
	public void keyTyped(KeyEvent evt) {
	}

	public void keyPressed(KeyEvent evt) {
		if (lstCommands.hasFocus()) {
			char c = Character.toLowerCase(evt.getKeyChar());
			if (c == '\n') {
				btnRun_actionPerformed(null);
			} else {
				int cnt = 0;
				boolean hasSelection = false;
				while (!hasSelection && cnt < lstCalls.size()) {
					String call = (String) lstCalls.get(cnt);
					if (c == Character.toLowerCase(call.charAt(0))) {
						hasSelection = true;
						lstCommands.setSelectedIndex(cnt - 1);
						Rectangle rect = lstCommands.getCellBounds(cnt, cnt);
						jScrollPane1.getVerticalScrollBar().setValue(rect.y);
					}
					cnt++;
				}
			}
		}
	}

	public void keyReleased(KeyEvent evt) {
	}

	// ListSelectionListner interfaces
	public void valueChanged(ListSelectionEvent e) {
		String api = lstCommands.getSelectedValue().toString();
		btnRun.setText(api);
	}

	// MouseListener interfaces
	/**
	 * Invoked when the mouse button has been clicked (pressed and released) on
	 * a component.
	 */
	public void mouseClicked(MouseEvent e) {
		long eventTime = e.getWhen();
		long timeDiff = eventTime - lastMouseClickedTime;
		if (timeDiff < 300L) {
			btnRun_actionPerformed(null);
		}
		lastMouseClickedTime = eventTime;
	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * Invoked when a mouse button has been released on a component.
	 */
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * Invoked when the mouse enters a component.
	 */
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Invoked when the mouse exits a component.
	 */
	public void mouseExited(MouseEvent e) {
	}

	// Execute the selected API
	void btnRun_actionPerformed(ActionEvent e) {
		if (!readyToMakeApiCall()) {
			return;
		}

		if (lstCommands.getSelectedIndex() > -1) {
			String api = lstCommands.getSelectedValue().toString();
			int len = api.length();
			char[] arrChar = api.toCharArray();

			StringBuffer buf = new StringBuffer();
			buf.append(Character.toLowerCase(arrChar[0]));
			for (int i = 1; i < len; i++) {
				buf.append(arrChar[i]);
			}

			String cmd = buf.toString();

			java.lang.reflect.Method m = null;
			try {
				Class c = this.getClass();
				m = this.getClass().getMethod(cmd, new Class[] { c });
				if (m != null) {
					m.invoke(this, new Object[] { this });
				}
			} catch (Exception ex) {

			}
		}
	}

	// Methods to display the input dialog for a selected API
	public void addDispute(FrameDemo parentFrame) {
		DialogAddDispute dlg = new DialogAddDispute(this,
				"eBay SDK for Java - AddDispute", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void addDisputeResponse(FrameDemo parentFrame) {
		DialogAddDisputeResponse dlg = new DialogAddDisputeResponse(this,
				"eBay SDK for Java - AddDisputeResponse", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void addItem(FrameDemo parentFrame) {
		DialogAddItem dlg = new DialogAddItem(this,
				"eBay SDK for Java - AddItem", SiteCodeType.US, true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void addOrder(FrameDemo parentFrame) {
		DialogAddOrder dlg = new DialogAddOrder(this,
				"eBay SDK for Java - AddOrder", SiteCodeType.US, true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void addSecondChanceItem(FrameDemo parentFrame) {
		DialogAddSecondChanceItem dlg = new DialogAddSecondChanceItem(this,
				"eBay SDK for Java - AddSecondChanceItem", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void addToItemDescription(FrameDemo parentFrame) {
		DialogAddToItemDescription dlg = new DialogAddToItemDescription(this,
				"eBay SDK for Java - AddToItemDescription", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void endItem(FrameDemo parentFrame) {
		DialogEndItem dlg = new DialogEndItem(this,
				"eBay SDK for Java - EndItem", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getAccount(FrameDemo parentFrame) {
		DialogGetAccount dlg = new DialogGetAccount(this,
				"eBay SDK for Java - GetAccount", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getAllBidders(FrameDemo parentFrame) {
		DialogGetAllBidders dlg = new DialogGetAllBidders(this,
				"eBay SDK for Java - GetAllBidders", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getCategories(FrameDemo parentFrame) {
		DialogGetCategories dlg = new DialogGetCategories(this,
				"eBay SDK for Java - GetCategories", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getDispute(FrameDemo parentFrame) {
		DialogGetDispute dlg = new DialogGetDispute(this,
				"eBay SDK for Java - GetDispute", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void geteBayOfficialTime(FrameDemo parentFrame) {
		DialogGeteBayOfficialTime dlg = new DialogGeteBayOfficialTime(this,
				"eBay SDK for Java - GeteBayOfficialTime", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getFeedback(FrameDemo parentFrame) {
		DialogGetFeedback dlg = new DialogGetFeedback(this,
				"eBay SDK for Java - GetFeedback", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public ItemType getItem(FrameDemo parentFrame) {
		DialogGetItem dlg = new DialogGetItem(this,
				"eBay SDK for Java - GetItem", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
		return dlg.getItem();
	}

	public void getItemShipping(FrameDemo parentFrame) {
		DialogGetItemShipping dlg = new DialogGetItemShipping(this,
				"eBay SDK for Java - GetItemShipping", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getItemTransactions(FrameDemo parentFrame) {
		DialogGetItemTransactions dlg = new DialogGetItemTransactions(this,
				"eBay SDK for Java - GetItemTransactions", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getMemberMessages(FrameDemo parentFrame) {
		DialogGetMemberMessages dlg = new DialogGetMemberMessages(this,
				"eBay SDK for Java - GetMemberMessages", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getMyeBaySelling(FrameDemo parentFrame) {
		DialogGetMyeBaySelling dlg = new DialogGetMyeBaySelling(this,
				"eBay SDK for Java - GetMyeBaySelling", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getMyeBayBuying(FrameDemo parentFrame) {
		DialogGetMyeBayBuying dlg = new DialogGetMyeBayBuying(this,
				"eBay SDK for Java - GetMyeBayBuying", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getNotificationPreferences(FrameDemo parentFrame) {
		DialogGetNotificationPreferences dlg = new DialogGetNotificationPreferences(
				this, "eBay SDK for Java - GetNotificationPreferencs", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getOrders(FrameDemo parentFrame) {
		DialogGetOrders dlg = new DialogGetOrders(this,
				"eBay SDK for Java - GetOrders", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getSellerEvents(FrameDemo parentFrame) {
		DialogGetSellerEvents dlg = new DialogGetSellerEvents(this,
				"eBay SDK for Java - GetSellerEvents", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getSellerList(FrameDemo parentFrame) {
		DialogGetSellerList dlg = new DialogGetSellerList(this,
				"eBay SDK for Java - GetSellerList", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getSellerTransactions(FrameDemo parentFrame) {
		DialogGetSellerTransactions dlg = new DialogGetSellerTransactions(this,
				"eBay SDK for Java - GetSellerTransactions", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getSuggestedCategories(FrameDemo parentFrame) {
		DialogGetSuggestedCategories dlg = new DialogGetSuggestedCategories(
				this, "eBay SDK for Java - GetSuggestedCategories", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getTokenStatus(FrameDemo parentFrame) {
		DialogGetTokenStatus dlg = new DialogGetTokenStatus(this,
				"eBay SDK for Java - GetTokenStatus", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getUser(FrameDemo parentFrame) {
		DialogGetUser dlg = new DialogGetUser(this,
				"eBay SDK for Java - GetUser", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getUserDisputes(FrameDemo parentFrame) {
		DialogGetUserDisputes dlg = new DialogGetUserDisputes(this,
				"eBay SDK for Java - GetUserDisputes", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void leaveFeedback(FrameDemo parentFrame) {
		DialogLeaveFeedback dlg = new DialogLeaveFeedback(this,
				"eBay SDK for Java - LeaveFeedback", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void relistItem(FrameDemo parentFrame) {
		DialogRelistItem dlg = new DialogRelistItem(this,
				"eBay SDK for Java - RelistItem", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void reviseCheckoutStatus(FrameDemo parentFrame) {
		DialogReviseCheckoutStatus dlg = new DialogReviseCheckoutStatus(this,
				"eBay SDK for Java - ReviseCheckoutStatus", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void reviseItem(FrameDemo parentFrame) {
		DialogReviseItem dlg = new DialogReviseItem(this,
				"eBay SDK for Java - ReviseItem", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void sellerReverseDispute(FrameDemo parentFrame) {
		DialogSellerReverseDispute dlg = new DialogSellerReverseDispute(this,
				"eBay SDK for Java - SellerReverseDispute", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void setNotificationPreferences(FrameDemo parentFrame) {
		DialogSetNotificationPreferences dlg = new DialogSetNotificationPreferences(
				this, "eBay SDK for Java - SetNotificationPreferencs", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getMyMessages(FrameDemo parentFrame) {
		DialogGetMyMessages dlg = new DialogGetMyMessages(this,
				"eBay SDK for Java - GetMyMessages", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void deleteMyMessages(FrameDemo parentFrame) {
		DialogDeleteMyMessages dlg = new DialogDeleteMyMessages(this,
				"eBay SDK for Java - DeleteMyMessages", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void reviseMyMessages(FrameDemo parentFrame) {
		DialogReviseMyMessages dlg = new DialogReviseMyMessages(this,
				"eBay SDK for Java - ReviseMyMessages", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getApiAccessRules(FrameDemo parentFrame) {
		DialogGetApiAccessRules dlg = new DialogGetApiAccessRules(this,
				"eBay SDK for Java - GetApiAccessRules", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getStore(FrameDemo parentFrame) {
		DialogGetStore dlg = new DialogGetStore(this,
				"eBay SDK for Java - GetStore", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void setStoreCustomPage(FrameDemo parentFrame) {
		DialogSetStoreCustomPage dlg = new DialogSetStoreCustomPage(this,
				"eBay SDK for Java - SetStoreCustomPage", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getStoreCustomPage(FrameDemo parentFrame) {
		DialogGetStoreCustomPage dlg = new DialogGetStoreCustomPage(this,
				"eBay SDK for Java - GetStoreCustomPage", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getStoreOptions(FrameDemo parentFrame) {
		DialogGetStoreOptions dlg = new DialogGetStoreOptions(this,
				"eBay SDK for Java - GetStoreOptions", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void setStore(FrameDemo parentFrame) {
		DialogSetStore dlg = new DialogSetStore(this,
				"eBay SDK for Java - SetStore", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getStorePreferences(FrameDemo parentFrame) {
		DialogGetStorePreferences dlg = new DialogGetStorePreferences(this,
				"eBay SDK for Java - GetStorePreferences", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void setStorePreferences(FrameDemo parentFrame) {
		DialogSetStorePreferences dlg = new DialogSetStorePreferences(this,
				"eBay SDK for Java - SetStorePreferences", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getItemRecommendations(FrameDemo parentFrame) {
		DialogGetItemRecommendations dlg = new DialogGetItemRecommendations(
				this, "eBay SDK for Java - GetItemRecommendations", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void sendInvoice(FrameDemo parentFrame) {
		DialogSendInvoice dlg = new DialogSendInvoice(this,
				"eBay SDK for Java - SendInvoice", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void getBestOffers(FrameDemo parentFrame) {
		DialogGetBestOffers dlg = new DialogGetBestOffers(this,
				"eBay SDK for Java - GetBestOffers", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void respondToBestOffer(FrameDemo parentFrame) {
		DialogRespondToBestOffer dlg = new DialogRespondToBestOffer(this,
				"eBay SDK for Java - RespondToBestOffer", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void fetchToken(FrameDemo parentFrame) {
		DialogFetchToken dlg = new DialogFetchToken(this, apiContext,
				"eBay SDK for Java - FetchToken", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public void uploadPictures(FrameDemo parentFrame) {
		DialogUploadPictures dlg = new DialogUploadPictures(this,
				"eBay SDK for Java - UploadPictures", true);
		GuiUtil.CenterComponent(dlg);
		dlg.setVisible(true);
	}

	public static String[] getAllertIDFromTextBox(JTextField txtFld) {
		// Save alert ID list.
		String ids = txtFld.getText().trim();
		if (ids.length() > 0) {
			String[] idsList = ids.split(",");
			if (idsList.length > 0) {
				String[] alertIDs = new String[idsList.length];
				for (int i = 0; i < idsList.length; i++) {
					alertIDs[i] = idsList[i].trim();
				}

				return alertIDs;
			}
		}
		return null;
	}

	public static String[] getMessageIDFromTextBox(JTextField txtFld) {
		String ids = txtFld.getText().trim();
		if (ids.length() > 0) {
			String[] idsList = ids.split(",");
			if (idsList.length > 0) {
				String[] msgIDs = new String[idsList.length];

				for (int i = 0; i < idsList.length; i++) {
					msgIDs[i] = idsList[i].trim();
				}

				return msgIDs;
			}
		}
		return null;
	}
}

// Classes to handle the menu selection/button press events.
class FrameDemo_jMenuFileExit_ActionAdapter implements ActionListener {
	FrameDemo adaptee;

	FrameDemo_jMenuFileExit_ActionAdapter(FrameDemo adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuFileExit_actionPerformed(e);
	}
}

class FrameDemo_jMenuHelpAbout_ActionAdapter implements ActionListener {
	FrameDemo adaptee;

	FrameDemo_jMenuHelpAbout_ActionAdapter(FrameDemo adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuHelpAbout_actionPerformed(e);
	}
}

class FrameDemo_jMenuItemAccount_actionAdapter implements
		java.awt.event.ActionListener {
	FrameDemo adaptee;

	FrameDemo_jMenuItemAccount_actionAdapter(FrameDemo adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItemAccount_actionPerformed(e);
	}
}

class FrameDemo_btnAccount_actionAdapter implements
		java.awt.event.ActionListener {
	FrameDemo adaptee;

	FrameDemo_btnAccount_actionAdapter(FrameDemo adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.btnAccount_actionPerformed(e);
	}
}

class FrameDemo_btnRun_actionAdapter implements java.awt.event.ActionListener {
	FrameDemo adaptee;

	FrameDemo_btnRun_actionAdapter(FrameDemo adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.btnRun_actionPerformed(e);
	}
}
