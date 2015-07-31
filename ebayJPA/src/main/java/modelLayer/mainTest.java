package modelLayer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ebay.soap.eBLBaseComponents.ItemType;

public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.onlyleaf_mavenproject2_jar_1.0-SNAPSHOTPU2");
		EntityManager em = emf.createEntityManager();
		ItemType item = new ItemType();

		List l = ItemTypeTable.getItems();

	}
}
