package modelLayer;

import java.util.List;

import com.ebay.soap.eBLBaseComponents.ItemType;

public class ItemTypeTable extends table {

	// ItemType
	// @NamedQuery(name = "findAllCustomersWithName", query =
	// "SELECT c FROM Customer c WHERE c.name LIKE :custName")

	@Override
	public ItemType insert(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.insertRecord(entity);
		return (ItemType) entity;
	}

	@Override
	public ItemType update(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.merge(entity);
		return (ItemType) entity;
	}

	@Override
	public ItemType delete(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.delete(entity);
		return (ItemType) entity;
	}

	@Override
	public ItemType find(Object primarykey) {
		// TODO Auto-generated method stub
		return (ItemType) DatabaseContext.find(ItemType.class, primarykey);
	}

	@Override
	public List<ItemType> getAll() {
		// TODO Auto-generated method stub
		return DatabaseContext.findAll(ItemType.class);
	}

	@Override
	public ItemType getByID(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
