package UI.Tools;

import imageAutomation.ImageAutomation;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import examples.java.UploadPhotoSimple;
import modelLayer.ImageLoader;

public class PhotoProcessSequence {
	ImageAutomation tool = new ImageAutomation();

	public void processPhoto(Map<String, File> accountWatermark) {
		// add watermark;

		for (String account : accountWatermark.keySet())
			addWatermark(account, accountWatermark.get(account));
		// load to database;
		loadImage();
		// upload to flikr server; update database url;
		uploadImage();
	}

	private void addWatermark(String account, File watermark) {
		tool.AddWarterMark(account, watermark);
	}

	private void loadImage() {
		ImageLoader imageLoader = new ImageLoader();
		imageLoader.loadNewImage(new File(".\\output"), "");
	}

	private void uploadImage() {
		// JOptionPane.showMessageDialog(null, "upload to Flikr failed.",
		// "Error Message", JOptionPane.ERROR_MESSAGE);
		try {
			UploadPhotoSimple.main(null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "upload to Flikr failed.", "Error Message", JOptionPane.ERROR_MESSAGE);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Seccessful!!","Message", JOptionPane.PLAIN_MESSAGE);
	}
}
