package modelLayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.persistence.ImageEntity;

import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;
import com.ebay.soap.eBLBaseComponents.StoreCustomCategoryType;
import com.ebay.soap.eBLBaseComponents.VariationType;
import com.ebay.soap.eBLBaseComponents.VariationsType;

public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("DerbyJPA");
		// EntityManager em = emf.createEntityManager();
		VariationsType variations = new VariationsType();
		VariationType singleVariation = new VariationType();
		singleVariation.setSKU("gel_iphone6_clear");
		VariationType[] variationList = new VariationType[] { singleVariation };
		variations.setVariation(variationList);
		VariationsTypeTable table1 = new VariationsTypeTable();
		table1.insert(variations);

		NameValueListTypeTable table = new NameValueListTypeTable();
		NameValueListType nameValueList = new NameValueListType();
		nameValueList.setName("Model");
		nameValueList.setValue(new String[] { "Iphone 6" });
		table.insert(nameValueList);
		// StoreCustomCategoryTable table = new StoreCustomCategoryTable();
		// StoreCustomCategoryType newTest = new StoreCustomCategoryType();
		// table.insert(newTest);

		ItemType item = new ItemType();
		System.out.println(item.id);
		item.album = "abcd";
		ItemTypeTable itemTypeTable = new ItemTypeTable();
		itemTypeTable.insert(item);
		System.out.println(item.id);

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
		// -----------------------------------------------------------------------
		// ImageEntityTable imageTable = new ImageEntityTable();
		// ImageEntity image = new ImageEntity();
		// imageTable.insert(image);
		//
		// image = new ImageEntity();
		// imageTable.insert(image);
		// image = new ImageEntity();
		// imageTable.insert(image);
		// image = new ImageEntity();
		// imageTable.insert(image);
		// imageTable.delete(image);
		// -------------------------------------------------------------------
		// ImageLoader imageLoader = new ImageLoader();
		// imageLoader.loadNewImage(new File(".\\output"), "");
	}
}
