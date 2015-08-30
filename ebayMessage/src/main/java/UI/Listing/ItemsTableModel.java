package UI.Listing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelLayer.ItemTypeTable;
import modelLayer.StoreCustomCategoryTable;

import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.StoreCustomCategoryType;
import com.ebay.soap.eBLBaseComponents.StorefrontType;

public class ItemsTableModel extends AbstractTableModel {
	ItemTypeTable itemsTable = new ItemTypeTable();

	ArrayList<ItemType> items;
	List<StoreCustomCategoryType> storeCategory;

	ItemsTableModel() {
		items = itemsTable.getAll();
		StoreCustomCategoryTable storeCategoryTable = new StoreCustomCategoryTable();
		storeCategory = storeCategoryTable.getAll();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class clazz = String.class;
		switch (columnIndex) {
		case 0:
			clazz = String.class;
			break;

		case 8:
			clazz = String.class;
			break;
		}
		return clazz;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		switch (column) {
		case 0:// applicationData;
			return true;
		case 1:// item ID;
			return false;
		case 2:// ebay Category;
			return true;
		case 3:// custom store category;
			return true;
		case 4:// Item Title;
			return true;
		case 5:// Description Preparation;
			return true;
		case 8:// sku
			return true;
		case 9:// album
			return true;
		}
		return false;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub

		ItemType item = items.get(row);
		switch (col) {
		case 0:
			return item.getApplicationData();
		case 1:
			return item.getItemID();
		case 2:
			if (item.getPrimaryCategory() == null || item.getPrimaryCategory().getCategoryID() == null)
				return null;
			if (item.getPrimaryCategory().getCategoryID().equals("20349"))
				return "Cases, Covers, Skins";
			if (item.getPrimaryCategory().getCategoryID().equals("123422"))
				return "Cables, Adapters";
			if (item.getPrimaryCategory().getCategoryID().equals("166030"))
				return "Armbands";
			if (item.getPrimaryCategory().getCategoryID().equals("58540"))
				return "Screen Protectors";
			return item.getPrimaryCategory();
		case 3:
			if (item.getStorefront() == null)
				return null;
			for (int i = 0; i < storeCategory.size(); i++) {
				if (item.getStorefront().getStoreCategoryID() == storeCategory.get(i).getCategoryID()) {
					return storeCategory.get(i).getName();
				}
			}
			return null;// ...........
		case 4:
			return item.getTitle();
		case 5:
			return item.descriptionPreparation;
		case 6:
			return item.getListingDuration();
		case 7:
			return item.getVariations();
		case 8:
			return item.getSKU();
			// return item.getSKU();
		case 9:
			return item.album;

		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		ItemType item = items.get(row);
		switch (column) {
		case 0:
			item.setApplicationData(aValue.toString());
			break;
		case 1:
			break;
		case 2:
			if (item.getPrimaryCategory() == null)
				item.setPrimaryCategory(new CategoryType());
			if (aValue == null)
				break;
			if (aValue.toString().equals("Cases, Covers, Skins")) {
				item.getPrimaryCategory().setCategoryID("20349");
				break;
			}
			if (aValue.toString().equals("Cables, Adapters")) {
				item.getPrimaryCategory().setCategoryID("123422");
				break;
			}
			if (aValue.toString().equals("Armbands")) {
				item.getPrimaryCategory().setCategoryID("166030");
				break;
			}
			if (aValue.toString().equals("Screen Protectors")) {
				item.getPrimaryCategory().setCategoryID("58540");
				break;
			}
			// item.getPrimaryCategory().setCategoryID("20349");
			break;
		case 3:
			if (item.getStorefront() == null)
				item.setStorefront(new StorefrontType());
			if (aValue == null)
				break;

			for (int i = 0; i < storeCategory.size(); i++) {
				if (aValue.toString().equals(storeCategory.get(i).getName())) {
					item.getStorefront().setStoreCategoryID(storeCategory.get(i).getCategoryID());
					// item.getStorefront().setStoreCategoryName(aValue.toString());
					break;
				}
			}
			break;
		case 4:
			item.setTitle(aValue.toString());
			break;
		case 5:
			item.descriptionPreparation = aValue.toString();
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			item.setSKU(aValue.toString());
			break;
		case 9:
			item.album = aValue.toString();
			break;
		case 10:
			break;
		case 11:
			break;
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "eBayID";
		case 1:
			return "ItemID";
		case 2:
			return "Category";
		case 3:
			return "Store Category";
		case 4:
			return "Title";
		case 5:
			return "Description";
		case 6:
			return "Duration";
		case 7:
			return "Variations";
		case 8:
			return "SKU";
		case 9:
			return "Album";
		case 10:
			return "Update";
		case 11:
			return "Insert";
		default:
			return null;
		}
	}
}
