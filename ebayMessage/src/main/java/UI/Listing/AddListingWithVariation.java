package UI.Listing;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;

import modelLayer.ItemTypeTable;
import modelLayer.StoreCustomCategoryTable;
import bean.BuyerAddress;

import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.StoreCustomCategoryType;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddListingWithVariation extends JPanel {
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Create the panel.
	 */
	public AddListingWithVariation() {

		JScrollPane scrollPane = new JScrollPane();

		JScrollPane scrollPane_1 = new JScrollPane();

		JButton btnCreateListing = new JButton("Create Listing");
		btnCreateListing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton btnUpdateListing = new JButton("Update Listing");

		JButton btnCopyListing = new JButton("Copy Listing");

		JScrollPane scrollPane_2 = new JScrollPane();

		JScrollPane scrollPane_3 = new JScrollPane();
		
		JButton button = new JButton("<-");
		
		JButton btnRemove = new JButton("Remove");
		
		JButton btnAdd = new JButton("add");
		
		JButton btnNewListing = new JButton("New Listing");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCopyListing, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnNewListing)
							.addPreferredGap(ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
							.addComponent(btnCreateListing)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnUpdateListing))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnRemove)
							.addGap(70)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAdd)))
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
						.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(btnCopyListing)
						.addComponent(btnRemove)
						.addComponent(button)
						.addComponent(btnAdd)
						.addComponent(btnNewListing)
						.addComponent(btnUpdateListing)
						.addComponent(btnCreateListing))
					.addGap(29))
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnCreateListing, btnUpdateListing, btnCopyListing});

		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		table_3.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null }, }, new String[] { "Name", "Value", "SKU" }));

		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null }, }, new String[] { "Name", "Value", "SKU" }));

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null }, }, new String[] { "SKU", "Price", "Quantity" }));

		ItemsTableModel items = new ItemsTableModel();
		table = new JTable(items);
		// table = new JTable();
		// table.setModel(new DefaultTableModel(new Object[][] { { null, null,
		// null }, { null, null, null }, { null, null, null }, { null, null,
		// null }, { null, null, null },
		// { null, null, null }, { null, null, null }, { null, null, null }, {
		// null, null, null }, }, new String[] { "Custom Label", "Price",
		// "Quantity" }));
		// ------------------------------------------------------------------------
		setUpColumn(table);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}

	public void setUpColumn(JTable table) {
		// Set up the editor for the sport cells.
		TableColumn categoryColumn = table.getColumnModel().getColumn(2);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Cases, Covers, Skins");
		comboBox.addItem("Cables, Adapters");
		comboBox.addItem("Armbands");
		comboBox.addItem("Screen Protectors");
		categoryColumn.setCellEditor(new DefaultCellEditor(comboBox));

		// Set up tool tips for the sport cells.
		// DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		// renderer.setToolTipText("Click for combo box");
		// sportColumn.setCellRenderer(renderer);
		// -------------------------------------------------------------------------------
		List<StoreCustomCategoryType> storeCategory = null;
		StoreCustomCategoryTable storeCategoryTable = new StoreCustomCategoryTable();
		storeCategory = storeCategoryTable.getAll();

		TableColumn storeCategoryColumn = table.getColumnModel().getColumn(3);
		JComboBox storeCategorycomboBox = new JComboBox();
		for (int i = 0; i < storeCategory.size(); i++) {
			storeCategorycomboBox.addItem(storeCategory.get(i).getName());
		}
		storeCategoryColumn.setCellEditor(new DefaultCellEditor(storeCategorycomboBox));
		// -------------------------------------------------------------------------------
		// JTextField jtf = new JTextField();
		// jtf.setDocument(new LimitedPlainDocument(80));
		// table.getColumnModel().getColumn(4).setCellEditor(new
		// DefaultCellEditor(jtf));
	}

	class LimitedPlainDocument extends javax.swing.text.PlainDocument {
		private int maxLen = -1;

		/** Creates a new instance of LimitedPlainDocument */
		public LimitedPlainDocument() {
		}

		public LimitedPlainDocument(int maxLen) {
			this.maxLen = maxLen;
		}

		public void insertString(int param, String str, javax.swing.text.AttributeSet attributeSet) throws javax.swing.text.BadLocationException {
			if (str != null && maxLen > 0 && this.getLength() + str.length() > maxLen) {
				java.awt.Toolkit.getDefaultToolkit().beep();
				return;
			}
			super.insertString(param, str, attributeSet);
		}
	}
}
