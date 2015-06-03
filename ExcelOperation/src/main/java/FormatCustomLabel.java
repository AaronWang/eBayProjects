import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import ioSection.ReadWriteImplement;

public class FormatCustomLabel {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("text.txt"));
		ArrayList<String> stringList = new ArrayList<String>();
		while (sc.hasNext()) {
			stringList.add(sc.next());

		}
		for (String each : stringList) {
			System.out.println(each);
		}

		ReadWriteImplement excelIO = new ReadWriteImplement();
		File f;
		ArrayList<File> fileList;
		fileList = new ArrayList<File>();
		f = new File(".\\");
		System.out.println(f.getAbsolutePath());

		File[] files = f.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				if (name.contains("xls")) {
					return true;
				}
				return false;
			}
		});
		fileList.addAll(Arrays.asList(files));
		for (File each : fileList) {
			System.out.println(each.getAbsolutePath());
			Workbook wb = excelIO.Read(each.getName());
			if (wb == null)
				continue;
			Sheet sheet1 = wb.getSheetAt(0);
			if (sheet1 == null)
				continue;
			for (Row row1 : sheet1) {
				Cell cell1 = row1.getCell(12);
				if (cell1 == null)
					continue;
				String s = "";
				switch (cell1.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					s = cell1.getRichStringCellValue().getString();
					for (String replace : stringList) {
						s = s.replace(replace, "");
					}
					cell1.setCellValue(s);
					break;
				default:
					System.out.println();
				}
			}
			excelIO.Write(each.getName(), wb);
		}
	}
}
