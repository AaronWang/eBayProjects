package modelLayer;

import java.util.List;

import org.persistence.ImageEntity;

public class ImageEntityTable extends table {

	@Override
	public ImageEntity insert(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.insertRecord(entity);
		return (ImageEntity) entity;
	}

	@Override
	public ImageEntity update(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.merge(entity);
		return (ImageEntity) entity;
	}

	@Override
	public ImageEntity delete(Object entity) {
		// TODO Auto-generated method stub
		DatabaseContext.delete(entity);
		return (ImageEntity) entity;
	}

	@Override
	public ImageEntity find(Object primarykey) {
		// TODO Auto-generated method stub
		return (ImageEntity) DatabaseContext.find(ImageEntity.class, primarykey);
	}

	@Override
	public List<ImageEntity> getAll() {
		// TODO Auto-generated method stub
		return DatabaseContext.findAll(ImageEntity.class);
	}

	@Override
	public ImageEntity getByID(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
