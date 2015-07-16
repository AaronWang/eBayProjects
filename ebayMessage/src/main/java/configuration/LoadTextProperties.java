package configuration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

//doesn't work
public class LoadTextProperties {
	Properties keys;

	public LoadTextProperties() {
		keys = new Properties();
		try {
			keys.load(new FileInputStream(LoadProperty.propertiFile));
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public String getProperty(String property) {
		// TODO Auto-generated method stub
		return keys.getProperty(property);
	}

	public void setProperty(String property, String value) {
		keys.setProperty(property, value);
		saveFile();
	}

	public void saveFile() {
		// TODO Auto-generated method stub
		try {
			keys.store(new FileOutputStream(LoadProperty.propertiFile), "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
