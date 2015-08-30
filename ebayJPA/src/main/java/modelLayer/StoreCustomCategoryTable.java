package modelLayer;

import java.util.List;
import java.util.Vector;

import com.ebay.soap.eBLBaseComponents.StoreCustomCategoryType;

public class StoreCustomCategoryTable extends table {

	@Override
	public Object insert(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.insertRecord(entity);
		return (StoreCustomCategoryType) entity;
	}

	@Override
	public Object update(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.merge(entity);
		return (StoreCustomCategoryType) entity;
	}

	@Override
	public Object delete(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.delete(entity);
		return (StoreCustomCategoryType) entity;
	}

	@Override
	public Object find(Object primarykey) {
		// TODO Auto-generated method stub
		return (StoreCustomCategoryType) DatabaseContext.find(StoreCustomCategoryType.class, primarykey);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return DatabaseContext.findAll(StoreCustomCategoryType.class);
	}

	public void deleteAll() {
		List<StoreCustomCategoryType> list = getAll();
		for (int i = 0; i < list.size(); i++) {
			delete(list.get(i));
		}
	}
}
