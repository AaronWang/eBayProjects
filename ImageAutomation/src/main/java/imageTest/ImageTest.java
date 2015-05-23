package imageTest;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

public class ImageTest {

	public ImageTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		File f = new File("IMG.jpg");

		BufferedImage bi = ImageIO.read(f);

		// for(String s:ImageIO.getReaderFormatNames())
		// System.out.println(s);

		Iterator readers = ImageIO.getImageReadersByFormatName("jpg");
		ImageReader reader = (ImageReader) readers.next();

		File newF = new File("IMG.jpg");
		// FileInputStream source = new FileInputStream(newF);

		System.out.println(newF.getAbsolutePath());
		ImageInputStream iis = ImageIO.createImageInputStream(newF);

		reader.setInput(iis, false);
		reader.getNumImages(true);
		System.out.println(reader.getWidth(0));
		// System.out.println(reader.getWidth(1));
		ImageReadParam param = reader.getDefaultReadParam();

		Iterator writers = ImageIO.getImageWritersByFormatName("png");
		ImageWriter writer = (ImageWriter) writers.next();

		File ff = new File("myimage.png");
		ImageOutputStream ios = ImageIO.createImageOutputStream(ff);
		writer.setOutput(ios);
		BufferedImage bi1 = new BufferedImage(300, 300,
				BufferedImage.TYPE_3BYTE_BGR);
		writer.write(bi1);

		File path = new File("");
		System.out.println(path.getAbsolutePath());
		// load source images
		BufferedImage image = ImageIO.read(new File("IMG.jpg"));
		BufferedImage overlay = ImageIO.read(new File("Lilies.jpg"));

		// create the new image, canvas size is the max. of both image sizes
		int w = Math.max(image.getWidth(), overlay.getWidth());
		int h = Math.max(image.getHeight(), overlay.getHeight());
		BufferedImage combined = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);

		// paint both images, preserving the alpha channels
		Graphics g = combined.getGraphics();
		g.drawImage(image, 0, 0, null);
		g.drawImage(overlay, 0, 0, null);
		// Save as new image
		ImageIO.write(combined, "JPG", new File("combined.jpg"));
	
		int newImageWidth = w / 2;
		int newImageHeight = h / 2;
		BufferedImage resizedImage = new BufferedImage(newImageWidth, newImageHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g1 = resizedImage.createGraphics();
		g1.drawImage(image, 0, 0, newImageWidth , newImageHeight , null);
//		g1.drawImage(image, 0, 0, newImageWidth*2 , newImageHeight*2 , null);
		g1.dispose();
		
		// Save as new image
		ImageIO.write(resizedImage, "JPG", new File("scale.jpg"));
	}
}
