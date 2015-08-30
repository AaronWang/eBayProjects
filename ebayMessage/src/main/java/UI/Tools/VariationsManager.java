package UI.Tools;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;

public class VariationsManager extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VariationsManager frame = new VariationsManager();
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
	public VariationsManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1315, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Variation Elements");

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblVariationsGroup = new JLabel("Single Variation");

		JScrollPane scrollPane_1 = new JScrollPane();

		JLabel lblNewLabel_1 = new JLabel("Group Variations");

		JScrollPane scrollPane_2 = new JScrollPane();

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((VariationElementTableModel) table.getModel()).insertData();
				table.updateUI();
			}
		});

		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row < 0)
					return;
				((VariationElementTableModel) table.getModel()).removeRow(row);
				table.updateUI();
			}
		});

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row < 0)
					return;
				((VariationElementTableModel) table.getModel()).saveRow(row);
			}
		});

		JButton btnSaveAll = new JButton("Save All");
		btnSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((VariationElementTableModel) table.getModel()).saveAll();
			}
		});

		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				((VariationSingleTableModel) table_1.getModel()).insertData(((VariationElementTableModel) table.getModel()).getRowData(table.getSelectedRow()));
				table_1.updateUI();
			}
		});

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((VariationSingleTableModel) table_1.getModel()).removeRow(table_1.getSelectedRow());
				table_1.updateUI();
			}
		});

		JButton btnNewButton_2 = new JButton(">>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((VariationGroupTableModel)table_2.getModel()).addVariation(((VariationSingleTableModel) table_1.getModel()).getVariation());
				
				table_2.updateUI();
			}
		});

		JButton btnNewButton_3 = new JButton("Remove");

		JButton btnAdd = new JButton("Add");

		JButton btnSave_1 = new JButton("Save");

		JButton button_1 = new JButton("↑");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if (row <= 0)
					return;
				((VariationSingleTableModel) table_1.getModel()).moveUp(table_1.getSelectedRow());
				if (row - 1 >= 0)
					table_1.setRowSelectionInterval(row - 1, row - 1);
				table_1.updateUI();
			}
		});

		JButton button_2 = new JButton("↓");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if (row < 0)
					return;
				((VariationSingleTableModel) table_1.getModel()).moveDown(table_1.getSelectedRow());
				if (row + 1 < table_1.getRowCount())
					table_1.setRowSelectionInterval(row + 1, row + 1);
				table_1.updateUI();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(button))
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(btnNewButton).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSave)
														.addGap(4).addComponent(btnSaveAll).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_1)))
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_contentPane
														.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(
																gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblVariationsGroup)))
										.addGroup(
												gl_contentPane.createSequentialGroup().addGap(67).addComponent(button_1).addGap(18).addComponent(btnRemove).addGap(18)
														.addComponent(button_2)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNewButton_2)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_contentPane.createSequentialGroup().addGap(65).addComponent(btnAdd).addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(btnSave_1).addGap(18).addComponent(btnNewButton_3))
										.addGroup(
												gl_contentPane
														.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(
																gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblNewLabel_1)))).addGap(367)));
		gl_contentPane.setVerticalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.LEADING)
												.addGroup(
														gl_contentPane
																.createSequentialGroup()
																.addGap(18)
																.addGroup(
																		gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
																				.addComponent(lblVariationsGroup).addComponent(lblNewLabel_1))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(
																		gl_contentPane.createParallelGroup(Alignment.LEADING)
																				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
																				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
																				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)).addGap(30))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(306).addComponent(button).addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton).addComponent(btnSave))
												.addGroup(
														gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_1).addComponent(btnSaveAll)
																.addComponent(btnRemove).addComponent(button_1).addComponent(button_2))
												.addGroup(
														gl_contentPane
																.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(
																		gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnAdd).addComponent(btnSave_1)
																				.addComponent(btnNewButton_3)))).addGap(19))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(309).addComponent(btnNewButton_2).addContainerGap(392, Short.MAX_VALUE)));
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] { lblNewLabel, lblVariationsGroup, lblNewLabel_1 });
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] { lblNewLabel, lblVariationsGroup, lblNewLabel_1 });

		table_2 = new JTable(new VariationGroupTableModel());
		scrollPane_2.setViewportView(table_2);

		table_1 = new JTable(new VariationSingleTableModel());
		scrollPane_1.setViewportView(table_1);

		table = new JTable(new VariationElementTableModel());
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
