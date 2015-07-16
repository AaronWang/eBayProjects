package IO.ItemType;

import java.util.ArrayList;

public class NameValueList {
	String name;
	ArrayList<NameValue> values;

	public NameValueList() {
		name = "";
		values = new ArrayList<NameValue>();
	}

	public String[] getValueList(String format) {
		String[] list;
		list = format.split("/");
		String[] result = new String[list.length];
		int i = 0;
		for (String s : list) {
			result[i] = values.get(Integer.valueOf(s)).value;
			i++;
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<NameValue> getValues() {
		return values;
	}

	public void setValues(ArrayList<NameValue> values) {
		this.values = values;
	}

}
