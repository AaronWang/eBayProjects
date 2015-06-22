package UI;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;

public class cardlayoutTest extends JPanel {

	/**
	 * Create the panel.
	 */
	public cardlayoutTest() {
		setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, "name_553129062195324");
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(51, 88, 46, 14);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(141, 117, 28, 20);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(318, 158, 97, 23);
		panel_2.add(chckbxNewCheckBox);

	}
}
