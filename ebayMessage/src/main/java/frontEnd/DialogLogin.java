package frontEnd;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

import authentication.GetToken;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		setBounds(100, 100, 568, 505);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(64, 307, 170, 20);
		contentPanel.add(comboBox);

		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnLogin.setBounds(316, 306, 147, 23);
		contentPanel.add(btnLogin);

		JButton btnNewAccount = new JButton("new account");
		btnNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetToken gettoken = new GetToken();
				if (gettoken.getSessionID())
					gettoken.openBrowser();
			}
		});
		btnNewAccount.setBounds(64, 106, 170, 23);
		contentPanel.add(btnNewAccount);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(316, 360, 147, 23);
		contentPanel.add(btnDelete);
	}
}
