package modelLayer;

import java.util.List;

import org.persistence.ImageEntity;

public class ImageUploader {

	public static void uploadImages() {
		ImageEntityTable imageEntityTable = new ImageEntityTable();
		List<ImageEntity> imageList = imageEntityTable.getAll();
		
	}
}
