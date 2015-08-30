package modelLayer;

import java.util.List;

public abstract class table {
	public abstract Object insert(Object entity);

	public abstract Object update(Object entity);

	public abstract Object delete(Object entity);

	public abstract Object find(Object primarykey);

	public abstract List getAll();

	// public abstract Object getByID(Object entity);
}
