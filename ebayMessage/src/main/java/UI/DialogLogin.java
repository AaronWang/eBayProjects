package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import bean.Account;
import modules.EbayContextModule;
import core.Module;
import ebayClient.EbayClient;

public class DialogLogin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JList<String> list;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			DialogLogin dialog = new DialogLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogLogin() {
		setResizable(false);
		setBounds(100, 100, 568, 505);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton btnNewAccount = new JButton("add account");
		btnNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EbayClient.getInstance().StartAuthentication();

				// System.out.println("Get session Call");

				int reply = JOptionPane.showConfirmDialog(null, "an Webpage will be opened soon,please press \"Yes\" button after authentication.", "Ebay Authentication",
						JOptionPane.YES_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					EbayClient.getInstance().FinishAuthentication();
					JOptionPane.showMessageDialog(null, "Authentication finished");
				} else {
					JOptionPane.showMessageDialog(null, "Authentication Failed");
				}
			}
		});
		btnNewAccount.setBounds(316, 142, 147, 23);
		contentPanel.add(btnNewAccount);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(list.getSelectedValue());
				EbayContextModule ebayContext = EbayClient.getInstance().getModule(Module.Type.EBAYCONTEXT);
				ebayContext.removeAccount(list.getSelectedValue());
				updateList();
			}
		});
		btnDelete.setBounds(316, 226, 147, 23);
		contentPanel.add(btnDelete);

		list = new JList<String>();
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(49, 104, 203, 265);
		// String[] listData = { "abcd", "aaa", "bbb" };
		// list.setListData(listData);
		updateList();

		contentPanel.add(list);
		JLabel lblAccounts = new JLabel("Accounts");
		lblAccounts.setBounds(51, 79, 97, 14);
		contentPanel.add(lblAccounts);
	}

	public void updateList() {
		EbayContextModule ebayContext = EbayClient.getInstance().getModule(Module.Type.EBAYCONTEXT);
		ArrayList<String> accountName = ebayContext.getAccountList();
		String[] listData = accountName.toArray(new String[accountName.size()]);
		list.setListData(listData);
	}
}
