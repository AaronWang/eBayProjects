package modelLayer;

import java.util.ArrayList;
import java.util.List;

import org.persistence.ImageEntity;

import com.ebay.soap.eBLBaseComponents.NameValueListType;

public class NameValueListTypeTable extends table {

	ArrayList<NameValueListType> table = new ArrayList<NameValueListType>();

	@Override
	public NameValueListType insert(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.insertRecord(entity);
		return (NameValueListType) entity;
	}

	@Override
	public NameValueListType update(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.merge(entity);
		return (NameValueListType) entity;
	}

	@Override
	public NameValueListType delete(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.delete(entity);
		return (NameValueListType) entity;
	}

	@Override
	public NameValueListType find(Object primarykey) {
		// TODO Auto-generated method stub
		return (NameValueListType) DatabaseContext.find(NameValueListType.class, primarykey);
	}

	@Override
	public List<NameValueListType> getAll() {
		// TODO Auto-generated method stub
		return DatabaseContext.findAll(NameValueListType.class);
	}
}
