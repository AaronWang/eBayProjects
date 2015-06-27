package modules;

import java.util.HashMap;
import java.util.Map;

import bean.Bean;

public class StorageBox extends AbstractModule {
	Map<String, Bean> box;

	public StorageBox() {
		box = new HashMap<String, Bean>();
	}

	public Bean getBean(String s) {
		return box.get(s);
	}

	public void setBean(String s, Bean bean) {
		box.put(s, bean);
	}
}
