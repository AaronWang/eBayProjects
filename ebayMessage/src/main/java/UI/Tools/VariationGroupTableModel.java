package UI.Tools;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelLayer.NameValueListTypeTable;

import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.NameValueListArrayType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;
import com.ebay.soap.eBLBaseComponents.VariationType;

public class VariationGroupTableModel extends AbstractTableModel {
	List<VariationType> variationList = new ArrayList<VariationType>();

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return variationList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		VariationType variationType = variationList.get(row);
		switch (col) {
		case 0:
			return variationType.getSKU();
		case 1:
			return variationType.getStartPrice().getValue();
		case 2:
			return variationType.getQuantity();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		VariationType variationType = variationList.get(row);
		switch (column) {
		// case 0:
		// variationType.setSKU(aValue.toString());
		// break;
		case 1:
			AmountType value = new AmountType();
			value.setCurrencyID(CurrencyCodeType.AUD);
			try {
				value.setValue(Double.parseDouble(aValue.toString()));
			} catch (Exception e) {
				value.setValue(100);
			}
			variationType.setStartPrice(value);
			break;
		case 2:
			variationType.setQuantity(Integer.parseInt(aValue.toString()));
			break;
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 0)
			return false;
		return true;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "SKU";
		case 1:
			return "Price";
		case 2:
			return "Quantity";
		default:
			return null;
		}
	}

	public void addVariation(List<NameValueListType> variation) {
		// TODO Auto-generated method stub
		if (variation.size() == 0)
			return;

		VariationType variationType = new VariationType();
		NameValueListArrayType elementArray = new NameValueListArrayType();
		elementArray.setNameValueList(new NameValueListType[variation.size()]);
		String newSKU = "";
		for (int i = 0; i < variation.size(); i++) {
			NameValueListType newElement = new NameValueListType();
			newElement.setName(variation.get(i).getName());

			newElement.setValue(new String[] { variation.get(i).getValue(0) });
			newElement.sku = "";
			newElement.sku += (variation.get(i).sku);
			elementArray.setNameValueList(i, newElement);
			newSKU += "_" + variation.get(i).sku;
			// variationType.
		}
		variationType.setVariationSpecifics(elementArray);
		variationType.setSKU(newSKU);
		AmountType amount = new AmountType();
		amount.setCurrencyID(CurrencyCodeType.AUD);
		amount.setValue(100);
		variationType.setStartPrice(amount);
		variationType.setQuantity(10);
		variationList.add(variationType);
	}
}
