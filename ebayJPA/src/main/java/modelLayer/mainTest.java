package modelLayer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.persistence.ImageEntity;

import com.ebay.soap.eBLBaseComponents.ItemType;

public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("DerbyJPA");
		// EntityManager em = emf.createEntityManager();
		// ItemType item = new ItemType();

		ItemTypeTable itemTypeTable = new ItemTypeTable();
		// List l = itemTypeTable.getAll();
		//
		// ItemType newItem = new ItemType();
		// itemTypeTable.insert(newItem);
		// newItem = new ItemType();
		// itemTypeTable.insert(newItem);
		//
		// System.out.println(newItem.id);
		// newItem.setApplicationData("test");
		// newItem.setAutoPay(true);
		// itemTypeTable.update(newItem);
		//
		// newItem = new ItemType();
		// itemTypeTable.insert(newItem);
		// itemTypeTable.delete(newItem);
		// l = itemTypeTable.getAll();

		ImageEntityTable imageTable = new ImageEntityTable();
		ImageEntity image = new ImageEntity();
		imageTable.insert(image);

		image = new ImageEntity();
		imageTable.insert(image);
		image = new ImageEntity();
		imageTable.insert(image);
		image = new ImageEntity();
		imageTable.insert(image);
		imageTable.delete(image);

	}
}
