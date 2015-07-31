package modelLayer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NamedQuery;

import com.ebay.soap.eBLBaseComponents.ItemType;

public class ItemTypeTable {

	// ItemType
//	@NamedQuery(name = "findAllCustomersWithName", query = "SELECT c FROM Customer c WHERE c.name LIKE :custName")
	
	public static List getItems() {
		return DatabaseContext.em.createQuery("SELECT i FROM ItemType i").getResultList();
	}

	public void setItemType(List<ItemType> itemList) {

	}

}
