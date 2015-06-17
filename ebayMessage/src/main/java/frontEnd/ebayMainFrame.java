package frontEnd;

import ioSection.ReadWriteImplement;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import authentication.GetToken;
import ebayApiCall.EndingItems;
import ebayApiCall.GetOrders;

import javax.swing.JComboBox;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;

public class ebayMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 869, 498);

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
		contentPane.setLayout(null);

		JButton btnAuthentication = new JButton("Authentication");
		btnAuthentication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetToken gettoken = new GetToken();
				if (gettoken.getSessionID())
					gettoken.openBrowser();

				int reply = JOptionPane.showConfirmDialog(null,
						"authentication done ~", "Ebay Authentication",
						JOptionPane.YES_OPTION);
				if (reply == JOptionPane.YES_OPTION)
					gettoken.getToken();
				// JOptionPane.showMessageDialog(null, "sucess!");
			}
		});
		btnAuthentication.setBounds(497, 86, 117, 23);
		contentPane.add(btnAuthentication);

		JButton btnGetOrders = new JButton("Get Orders");
		btnGetOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// GetOrders go = new GetOrders();
				// go.getorders();
			}
		});
		btnGetOrders.setBounds(497, 195, 117, 23);
		contentPane.add(btnGetOrders);

		JButton btnNewButton = new JButton("End Items");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String contect = textField.getText();
				EndingItems enditems = new EndingItems();
				enditems.addItemID(contect);
				enditems.endingItem();

				ReadWriteImplement reader = new ReadWriteImplement();
				Workbook wb1 = reader.Read(textField_1.getText());

				Sheet sheet1 = wb1.getSheetAt(0);
				if (sheet1 == null)
					return;
				int rowNumber = 0;
				for (Row row1 : sheet1) {
					Cell cell1 = row1.getCell(0);
					if (cell1 == null)
						continue;
					String s = "";
					switch (cell1.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						s = cell1.getRichStringCellValue().getString();
						enditems.addItemID(s);
						System.out.println(s);
						if (enditems.size() >= 9) {
							enditems.endingItem();
							enditems.clear();
						}
						break;
					default:
						System.out.println();
					}
				}
			}
		});
		btnNewButton.setBounds(497, 304, 117, 23);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(154, 305, 225, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setBounds(65, 308, 82, 14);
		contentPane.add(lblItemId);

		JLabel lblNewLabel = new JLabel("xls file name");
		lblNewLabel.setBounds(65, 350, 82, 14);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(154, 347, 225, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(42, 87, 190, 20);

		contentPane.add(comboBox);

		JLabel lblExistAccounts = new JLabel("Exist Accounts");
		lblExistAccounts.setBounds(42, 62, 134, 14);
		contentPane.add(lblExistAccounts);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(42, 121, 89, 23);
		contentPane.add(btnLogin);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(142, 121, 89, 23);
		contentPane.add(btnRemove);
		
	}
}
