package UI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import UI.Listing.SingleListing;
import UI.Listing.SingleListingVariation;

public class ebayMainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel		contentPane;
	private JPanel		rightPanel;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						// System.out.println(info.getName());
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}

					ebayMainFrame frame = new ebayMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ebayMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 900);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTestMenu = new JMenu("Account");
		menuBar.add(mnTestMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Login");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogLogin login = new DialogLogin();
				login.setVisible(true);
			}
		});
		mnTestMenu.add(mntmNewMenuItem);

		JMenuItem mntmTestMenuItem_1 = new JMenuItem("Remove");
		mnTestMenu.add(mntmTestMenuItem_1);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnTestMenu.add(mntmExit);

		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_1 = new JMenu("Tools");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmListing = new JMenuItem("listing");
		mnNewMenu_1.add(mntmListing);

		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmAbout = new JMenuItem("About");
		mnNewMenu_2.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JButton btnListingButton = new JButton("Listing");
		btnListingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) rightPanel.getLayout()).show(rightPanel, "listing");

			}
		});

		JButton btnMessageButton = new JButton("Message");
		btnMessageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) rightPanel.getLayout()).show(rightPanel, "message");
			}
		});

		JButton btnFeedbackButton = new JButton("Feedback");
		btnFeedbackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) rightPanel.getLayout()).show(rightPanel, "feedback");
			}
		});

		rightPanel = new JPanel();
		rightPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addComponent(leftPanel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE).addPreferredGap(
						ComponentPlacement.UNRELATED).addComponent(rightPanel, GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane.createSequentialGroup().addGroup(
						gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(rightPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
								.addComponent(leftPanel, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)).addGap(0)));
		rightPanel.setLayout(new CardLayout(0, 0));

		JTabbedPane tabbedPaneListing = new JTabbedPane(JTabbedPane.TOP);
		rightPanel.add(tabbedPaneListing, "listing");

		SingleListing jPanelSingleListing = new SingleListing();
		tabbedPaneListing.addTab("Single Listing", null, jPanelSingleListing, null);

		SingleListingVariation jPanelSingleListingVariation = new SingleListingVariation();
		tabbedPaneListing.addTab("Single Listing With Variation", null, jPanelSingleListingVariation, null);

		JPanel panel_3 = new JPanel();
		tabbedPaneListing.addTab("Bulk Listing", null, panel_3, null);

		JPanel panel = new JPanel();
		tabbedPaneListing.addTab("All Listings", null, panel, null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 894, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 622, Short.MAX_VALUE));
		panel.setLayout(gl_panel);

		JTabbedPane tabbedPaneMessage = new JTabbedPane(JTabbedPane.TOP);
		rightPanel.add(tabbedPaneMessage, "message");

		JPanel panel_4 = new JPanel();
		tabbedPaneMessage.addTab("333", null, panel_4, null);

		JPanel panel_5 = new JPanel();
		tabbedPaneMessage.addTab("444", null, panel_5, null);

		JTabbedPane tabbedPaneFeedback = new JTabbedPane(JTabbedPane.TOP);
		rightPanel.add(tabbedPaneFeedback, "feedback");

		JPanel panel_6 = new JPanel();
		tabbedPaneFeedback.addTab("555", null, panel_6, null);

		JTabbedPane tabbedPaneResolution = new JTabbedPane(JTabbedPane.TOP);
		rightPanel.add(tabbedPaneResolution, "resolution");

		JPanel panel_7 = new JPanel();
		tabbedPaneResolution.addTab("666", null, panel_7, null);
		
		JTabbedPane tabbedPaneAccount = new JTabbedPane(JTabbedPane.TOP);
		rightPanel.add(tabbedPaneAccount, "name_123492670757745");
		
		JPanel panel_1 = new JPanel();
		tabbedPaneAccount.addTab("Site Preference", null, panel_1, null);

		JButton btnResolutionButton = new JButton("Resolution");
		btnResolutionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) rightPanel.getLayout()).show(rightPanel, "resolution");
			}
		});

		JButton btnNewButton_4 = new JButton("Account");
		GroupLayout gl_leftPanel = new GroupLayout(leftPanel);
		gl_leftPanel.setHorizontalGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_leftPanel.createSequentialGroup().addGap(1).addGroup(
						gl_leftPanel.createParallelGroup(Alignment.LEADING).addComponent(btnFeedbackButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnResolutionButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnNewButton_4,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(
										gl_leftPanel.createParallelGroup(Alignment.TRAILING).addComponent(btnListingButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnMessageButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addGap(5)));
		gl_leftPanel.setVerticalGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_leftPanel.createSequentialGroup().addGap(5).addComponent(btnListingButton).addGap(5).addComponent(btnMessageButton).addGap(5).addComponent(btnFeedbackButton)
						.addGap(5).addComponent(btnResolutionButton).addGap(5).addComponent(btnNewButton_4)));
		leftPanel.setLayout(gl_leftPanel);
		contentPane.setLayout(gl_contentPane);

	}
}
