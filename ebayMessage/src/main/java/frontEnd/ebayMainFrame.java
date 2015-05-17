package frontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import com.ebay.sdk.call.GeteBayOfficialTimeCall;
import com.ebay.sdk.helper.ui.DialogFetchToken;

import ebayApiCall.GetOrders;
import ebayContext.EbayContext;
import authentication.GetToken;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;

public class ebayMainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAuthentication = new JButton("Authentication");
		btnAuthentication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetToken gettoken = new GetToken();
				gettoken.getSessionID();
				gettoken.openBrowser();

				int reply = JOptionPane.showConfirmDialog(null,
						"authentication done ~", "Ebay Authentication",
						JOptionPane.YES_OPTION);
				if (reply == JOptionPane.YES_OPTION)
					gettoken.getToken();
				// JOptionPane.showMessageDialog(null, "sucess!");
			}
		});
		btnAuthentication.setBounds(10, 228, 117, 23);
		contentPane.add(btnAuthentication);
		
		JButton btnGetOrders = new JButton("Get Orders");
		btnGetOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GetOrders go= new GetOrders();
				go.getorders();
				
			}
		});
		btnGetOrders.setBounds(255, 228, 117, 23);
		contentPane.add(btnGetOrders);
	}
}
