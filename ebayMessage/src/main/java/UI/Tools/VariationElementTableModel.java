package UI.Tools;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ebay.soap.eBLBaseComponents.NameValueListType;
import com.ebay.soap.eBLBaseComponents.StoreCustomCategoryType;

import modelLayer.ItemTypeTable;
import modelLayer.NameValueListTypeTable;

public class VariationElementTableModel extends AbstractTableModel {
	NameValueListTypeTable nameValueListTypeTable = new NameValueListTypeTable();
	List<NameValueListType> nameValueListType;

	VariationElementTableModel() {
		nameValueListType = nameValueListTypeTable.getAll();
		Collections.sort(nameValueListType, NameComparator);
	}

	public static Comparator<NameValueListType> NameComparator = new Comparator<NameValueListType>() {
		@Override
		public int compare(NameValueListType arg0, NameValueListType arg1) {
			// TODO Auto-generated method stub
			return arg0.getName().compareTo(arg1.getName());
		}
	};

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return nameValueListType.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		NameValueListType nameValueList = nameValueListType.get(row);
		switch (col) {
		case 0:
			return nameValueList.getName();

		case 1:
			return nameValueList.getValue(0);

		case 2:
			return nameValueList.sku;
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		NameValueListType nameValueList = nameValueListType.get(row);
		switch (column) {
		case 0:
			nameValueList.setName(aValue.toString());
			break;
		case 1:
			nameValueList.setValue(0, aValue.toString());
			break;
		case 2:
			nameValueList.sku = aValue.toString();
			break;
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return true;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Name";
		case 1:
			return "Value";
		case 2:
			return "SKU";
		}
		return null;
	}

	public void insertData() {
		NameValueListType newRecord = new NameValueListType();
		newRecord.setValue(new String[] { "" });
		nameValueListType.add(newRecord);
	}

	public void saveRow(int row) {
		nameValueListTypeTable.insert(nameValueListType.get(row));
	}

	public void saveAll() {
		// TODO Auto-generated method stub
		for (int i = 0; i < nameValueListType.size(); i++) {
			nameValueListTypeTable.insert(nameValueListType.get(i));
		}
	}

	public void removeRow(int row) {
		// TODO Auto-generated method stub
		nameValueListTypeTable.delete(nameValueListType.get(row));
		nameValueListType.remove(row);
	}

	public NameValueListType getRowData(int row) {
		// TODO Auto-generated method stub
		// System.out.println("Row : " + row);
		if (row >= 0)
			return nameValueListType.get(row);
		return null;
	}
}
