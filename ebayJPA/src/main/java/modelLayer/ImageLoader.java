package modelLayer;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.persistence.ImageEntity;

//insert image information from disk to database
public class ImageLoader {
	// static File f = new File("./output");

	static ImageEntityTable imageEntityTable = new ImageEntityTable();
	static List<ImageEntity> imageList = imageEntityTable.getAll();

	public ImageLoader() {
		imageList = imageEntityTable.getAll();
		//need improvement here, get image by album name and file name.
	}

	static void readImage() {
		imageList = (ArrayList<ImageEntity>) imageEntityTable.getAll();
	}

	public void loadNewImage(File folder, String album) {
		if (!folder.getName().equals("output")) {
			if (!album.equals(""))
				album += "-";
			album += folder.getName();
		}
		final String albumRecurse = album;

		File[] files = folder.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				// System.out.println(name);
				if (name.contains(".jpg") || name.contains(".JPG") || name.contains(".JPEG") || name.contains(".jpeg")) {
					return true;
				}
				if (new File(file.getPath() + "\\" + name).isDirectory()) {
					// System.out.println("albumT: " + albumRecurse);
					loadNewImage(new File(file.getPath() + "\\" + name), albumRecurse);
				}
				return false;
			}
		});

		boolean exsit = false;
//		System.out.println("album:" + album);
		for (int i = 0; i < files.length; i++) {
//			System.out.println(files[i].getPath());
			// System.out.println(files[i].getName() + "  name");
			// System.out.println("--------------------------");
			for (ImageEntity image : imageList) {
				if (image.getName().equals(files[i].getName()) && image.getAlbum().equals(album) && image.getPath().equals(files[i].getPath())) {
					exsit = true;
					break;
				}
			}
			if (exsit) {
				exsit = false;
				continue;
			} else {
				ImageEntity entity = new ImageEntity();
				
				entity.setAlbum(album);
				entity.setName(files[i].getName());
				entity.setPath(files[i].getPath());
				entity.setFolder(files[i].getParent());
				imageEntityTable.insert(entity);
			}
		}
		// fileList.addAll(Arrays.asList(files));
	}

	public void loadAllImage() {
	}
}
