package FrontEnd;

import java.awt.Color;
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
import javax.swing.border.LineBorder;

import ControlerLayer.AddInventory;
import ControlerLayer.DeleteDuplicate;
import ControlerLayer.SoldItem;
import javax.swing.JCheckBox;

public class TestJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProductListxls;
	private JTextField txtBookxls;
	private JTextField txtBookxls_1;
	private JCheckBox chckbxNewCheckBox;
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestJFrame frame = new TestJFrame();
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
	public TestJFrame() {
		setTitle("tools for ebay");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(24, 22, 248, 175);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("minus");
		btnNewButton.setBounds(48, 128, 69, 23);
		panel.add(btnNewButton);

		txtProductListxls = new JTextField();
		txtProductListxls.setBounds(94, 40, 120, 20);
		panel.add(txtProductListxls);
		txtProductListxls.setText("product list.xls");
		txtProductListxls.setColumns(10);

		JLabel lblNewLabel = new JLabel("inventory");
		lblNewLabel.setBounds(19, 43, 75, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("item list");
		lblNewLabel_1.setBounds(19, 81, 75, 14);
		panel.add(lblNewLabel_1);

		txtBookxls = new JTextField();
		txtBookxls.setBounds(94, 78, 120, 20);
		panel.add(txtBookxls);
		txtBookxls.setText("book2.xls");
		txtBookxls.setColumns(10);

		JButton btnNewButton_2 = new JButton("add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddInventory add = new AddInventory();
				if (add.add(txtProductListxls.getText(), txtBookxls.getText())) {
					JOptionPane.showMessageDialog(null, "sucess!");
				} else {
					JOptionPane.showMessageDialog(null,
							"file operation failed!");
				}
			}
		});
		btnNewButton_2.setBounds(141, 128, 73, 23);
		panel.add(btnNewButton_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// soldItem test = new soldItem();
				// test.soldFunction(txtProductListxls.getText(),
				// txtBookxls.getText());

				SoldItem sold = new SoldItem();
				if (sold.minusItem(txtProductListxls.getText(),
						txtBookxls.getText())) {
					JOptionPane.showMessageDialog(null, "sucessed!");
				} else {
					JOptionPane.showMessageDialog(null,
							"file operation failed!");
				}
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(321, 22, 268, 175);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		chckbxNewCheckBox = new JCheckBox("Ignore High/Low case");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(35, 80, 166, 23);
		panel_1.add(chckbxNewCheckBox);

		txtBookxls_1 = new JTextField();
		txtBookxls_1.setText("2-3\u53F7.xls");
		txtBookxls_1.setBounds(35, 53, 109, 20);
		panel_1.add(txtBookxls_1);
		txtBookxls_1.setColumns(10);

		JButton btnNewButton_1 = new JButton("combine the same products");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// soldItem test = new soldItem();
				// test.deleteSameFunction(txtBookxls_1.getText());
				DeleteDuplicate dd = new DeleteDuplicate();
				;
				if (dd.delete(txtBookxls_1.getText(),chckbxNewCheckBox.isSelected())) {
					JOptionPane.showMessageDialog(null, "sucessed!");
				} else {
					JOptionPane.showMessageDialog(null,
							"file operation failed!");
				}
			}
		});
		btnNewButton_1.setBounds(25, 130, 210, 23);
		panel_1.add(btnNewButton_1);

	}
}
