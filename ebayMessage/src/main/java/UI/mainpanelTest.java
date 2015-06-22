package UI;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.CardLayout;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class mainpanelTest extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public mainpanelTest() {

		JPanel panel = new JPanel();
		panel.setSize(new Dimension(50, 500));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);

		JButton btnNewButton_4 = new JButton("New button");
		panel.add(btnNewButton_4);

		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(71, 262, 89, 23);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(71, 135, 89, 23);
		
		textField = new JTextField();
		textField.setBounds(174, 407, 86, 20);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(340, 174, 239, 194);
		panel_1.setLayout(null);
		panel_1.add(btnNewButton_7);
		panel_1.add(btnNewButton_6);
		panel_1.add(textField);
		panel_1.add(textArea);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel_2.add(btnNewButton_10);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_5, null);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addGap(1))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
					.addGap(0))
		);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(78, 162, 89, 23);
		panel_6.add(btnNewButton_5);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setBounds(248, 162, 89, 23);
		panel_6.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		btnNewButton_9.setBounds(280, 202, 89, 23);
		panel_6.add(btnNewButton_9);
		setLayout(groupLayout);

	}
}
