package imageAutomation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageAutomation {

	File f;
	ArrayList<File> fileList;

	File output;

	public ImageAutomation() {
		// TODO Auto-generated constructor stub
		fileList = new ArrayList<File>();
		f = new File("input");
		output = new File(".\\output");
		if (output.exists() == false)
			output.mkdir();
		System.out.println(f.getAbsolutePath());

		// if (f.isDirectory())
		// System.out.println("f is a directory.");
		// else
		// System.out.println("f isn't a directory.");

		// Initialize();
		GetJpegFileList(f);
		// for (File each : fileList)
		// System.out.println(each.getAbsolutePath());
	}

	public static void main(String[] args) {
		// System.out.println("test");
		ImageAutomation tool = new ImageAutomation();
		File waterMarkAaronCollection2015 = new File(".\\overlayer\\watermark.png");
		File waterMarkOnlyleaf520 = new File(".\\overlayer\\watermark.png");
		tool.AddWarterMark("AaronCollection2015", waterMarkAaronCollection2015);
		tool.AddWarterMark("Onlyleaf520", waterMarkOnlyleaf520);
	}

	private void Initialize() {
		File[] files = f.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				// System.out.println(name);
				if (name.contains(".jpg") || name.contains(".JPG") || name.contains(".JPEG") || name.contains(".jpeg")) {
					return true;
				}
				return false;
			}
		});
		fileList.addAll(Arrays.asList(files));
	}

	private void GetJpegFileList(File folder) {
		File[] files = folder.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				// System.out.println(name);
				if (name.contains(".jpg") || name.contains(".JPG") || name.contains(".JPEG") || name.contains(".jpeg")) {
					return true;
				}
				// System.out.println(file.getAbsolutePath() + "\\" + name);
				// System.out.println(file.getPath() + "\\" + name);
				if (new File(file.getPath() + "\\" + name).isDirectory())
					GetJpegFileList(new File(file.getPath() + "\\" + name));
				return false;
			}
		});
		fileList.addAll(Arrays.asList(files));
	}

	public void AddWarterMark(String accountName, File watermarkPath) {
		if (accountName.equals(""))
			return;
		BufferedImage waterMark;
		try {
			waterMark = ImageIO.read(watermarkPath);
			for (File one : fileList) {
				File exsitCheck = new File(one.getPath().replaceFirst("input", "output/" + accountName));
				if (exsitCheck.exists())
					continue;

				BufferedImage image = ImageIO.read(one);
				int w = image.getWidth();
				int h = image.getHeight();
				BufferedImage resizedWaterMark = new BufferedImage((int) (w * 2.0 / 3.0), (int) (h * 1.0 / 3.0), BufferedImage.TYPE_INT_ARGB);
				Graphics2D g1 = resizedWaterMark.createGraphics();
				g1.drawImage(waterMark, 0, 0, (int) (w * 2.0 / 3.0), (int) (h * 1.0 / 3.0), null);
				// g1.drawImage(image, 0, 0, newImageWidth*2 , newImageHeight*2
				// , null);
				g1.dispose();

				BufferedImage combined = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

				// paint both images, preserving the alpha channels
				Graphics g = combined.getGraphics();
				g.drawImage(image, 0, 0, null);
				g.drawImage(resizedWaterMark, image.getWidth() / 6, image.getHeight() / 3, null);
				// Save as new image
				// ImageIO.write(
				// combined,
				// "jpg",
				// new File(output.getAbsolutePath() + "\\"
				// + one.getName()));
				File outputFolder = new File(one.getParent().replaceFirst("input", "output/" + accountName));
				if (outputFolder.exists() == false)
					outputFolder.mkdirs();

				ImageIO.write(combined, "jpg", new File(one.getPath().replaceFirst("input", "output/" + accountName)));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
