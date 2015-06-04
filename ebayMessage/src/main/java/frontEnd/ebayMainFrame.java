package frontEnd;

import ioSection.ReadWriteImplement;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		setBounds(100, 100, 708, 451);
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
				GetOrders go = new GetOrders();
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
						// System.out.println(s);
						if (enditems.size() >= 9) {
							// enditems.endingItem();
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
		lblItemId.setBounds(88, 308, 59, 14);
		contentPane.add(lblItemId);

		JLabel lblNewLabel = new JLabel("xls file name");
		lblNewLabel.setBounds(88, 350, 59, 14);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(154, 347, 225, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
