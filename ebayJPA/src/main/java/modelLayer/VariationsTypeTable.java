package modelLayer;

import java.util.ArrayList;
import java.util.List;

import org.persistence.ImageEntity;

import com.ebay.soap.eBLBaseComponents.VariationsType;

public class VariationsTypeTable extends table {
	ArrayList<VariationsType> table = new ArrayList<VariationsType>();

	@Override
	public VariationsType insert(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.insertRecord(entity);
		return (VariationsType) entity;
	}

	@Override
	public VariationsType update(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.merge(entity);
		return (VariationsType) entity;
	}

	@Override
	public VariationsType delete(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.delete(entity);
		return (VariationsType) entity;
	}

	@Override
	public VariationsType find(Object primarykey) {
		// TODO Auto-generated method stub
		return (VariationsType) DatabaseContext.find(VariationsType.class, primarykey);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return DatabaseContext.findAll(VariationsType.class);
	}
}
