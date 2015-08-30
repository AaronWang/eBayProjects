package modelLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.ebay.soap.eBLBaseComponents.ItemType;

public class ItemTypeTable extends table {

	Vector<ItemType> table;

	// ItemType
	// @NamedQuery(name = "findAllCustomersWithName", query =
	// "SELECT c FROM Customer c WHERE c.name LIKE :custName")

	@Override
	public ItemType insert(Object entity) {
		// TODO Auto-generated method stub
		ItemType newItem = (ItemType) entity;
		if (table == null)
			getAll();
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).getApplicationData() == null || table.get(i).getItemID() == null)
				continue;
			if (table.get(i).getApplicationData().equals(newItem.getApplicationData()) && table.get(i).getItemID().equals(newItem.getItemID())) {
				delete(table.get(i));
				break;
			}
		}
		DatabaseContext.insertRecord(entity);
		table.add(newItem);
		return (ItemType) entity;
	}

	@Override
	public ItemType update(Object entity) {
		// TODO Auto-generated method stub
		ItemType newItem = (ItemType) entity;
		if (table == null)
			getAll();
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).getApplicationData() == null || table.get(i).getItemID() == null)
				continue;
			if (table.get(i).getApplicationData().equals(newItem.getApplicationData()) && table.get(i).getItemID().equals(newItem.getItemID())) {
				newItem.id = table.get(i).id;
				table.remove(i);
				break;
			}
		}
		DatabaseContext.merge(entity);
		table.add(newItem);
		return (ItemType) entity;
	}

	@Override
	public ItemType delete(Object entity) {
		// TODO Auto-generated method stub
		ItemType newItem = (ItemType) entity;
		if (table == null)
			getAll();
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).id == newItem.id) {
				table.remove(i);
				break;
			}
		}
		DatabaseContext.delete(entity);
		return (ItemType) entity;
	}

	@Override
	public ItemType find(Object primarykey) {
		// TODO Auto-generated method stub
		if (table == null)
			getAll();
		for (int j = 0; j < table.size(); j++) {
			if (table.get(j).id == primarykey) {
				return table.get(j);
			}
		}
		return null;
		// return (ItemType) DatabaseContext.find(ItemType.class, primarykey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ItemType> getAll() {
		// TODO Auto-generated method stub
		table = (Vector<ItemType>) DatabaseContext.findAll(ItemType.class);
		ArrayList<ItemType> returnList = new ArrayList<ItemType>();
		for (int i = 0; i < table.size(); i++)
			returnList.add(table.get(i));
		return returnList;
	}

	public ItemType getByEbayIDAndItemID(String ebayID, String itemID) {
		if (table == null)
			getAll();
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).getApplicationData() == null || table.get(i).getItemID() == null)
				continue;
			if (table.get(i).getApplicationData().equals(ebayID) && table.get(i).getItemID().equals(itemID))
				return table.get(i);
		}
		return null;
	}

	public List<ItemType> getTable() {
		if (table == null)
			getAll();
		return table;
	}
}
