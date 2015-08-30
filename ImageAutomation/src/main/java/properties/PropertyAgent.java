package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyAgent {
	Properties properties;

	public PropertyAgent() {
		// TODO Auto-generated constructor stub
		properties = new Properties();
		try {
			properties.load(new FileInputStream("keys.properties"));
			// ClassLoader classLoader =
			// Thread.currentThread().getContextClassLoader();
			// System.out.println(File.separator);
			// properties.load(classLoader.getResourceAsStream("keys.properties"));

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key, "");
	}

	public void setProperty(String key, String value) {
		properties.setProperty(key, value);
	}

	public void saveProperty() {
		try {
			properties.store(new FileOutputStream("keys.properties"), "");
			// ClassLoader classLoader = getClass().getClassLoader();
			// File file = new
			// File(classLoader.getResource("keys.properties").getFile());
			// properties.store(new FileOutputStream(file), "");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
