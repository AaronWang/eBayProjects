package UI.Tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelLayer.NameValueListTypeTable;

import com.ebay.soap.eBLBaseComponents.NameValueListType;

public class VariationSingleTableModel extends AbstractTableModel {
	List<NameValueListType> nameValueListType;

	VariationSingleTableModel() {
		nameValueListType = new ArrayList<NameValueListType>();
		// Collections.sort(nameValueListType, NameComparator);
	}

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
		default:
			return null;
		}
	}

	public void insertData(NameValueListType record) {
		nameValueListType.add(record);
	}

	public void removeRow(int row) {
		// TODO Auto-generated method stub
		if (row >= 0 && row < nameValueListType.size())
			nameValueListType.remove(row);

	}

	public void moveUp(int row) {
		if (row == 0)
			return;
		NameValueListType tmp;
		tmp = nameValueListType.get(row - 1);
		nameValueListType.set(row - 1, nameValueListType.get(row));
		nameValueListType.set(row, tmp);

	}

	public void moveDown(int row) {
		if (row < 0)
			return;
		if (row < nameValueListType.size() - 1) {
			NameValueListType tmp;
			tmp = nameValueListType.get(row + 1);
			nameValueListType.set(row + 1, nameValueListType.get(row));
			nameValueListType.set(row, tmp);
		}
	}

	public List<NameValueListType> getVariation() {
		// TODO Auto-generated method stub
		return nameValueListType;
	}
}
