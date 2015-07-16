package ControlerLayer;

import ioSection.ReadWriteImplement;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class DeleteDuplicate {
	public boolean delete(String fileName, boolean ignoreCase) {
		ReadWriteImplement rw = new ReadWriteImplement();
		Workbook wb = rw.Read(fileName);
		if (wb == null)
			return false;

		wb = deleteSame(wb, ignoreCase);

		return rw.Write(fileName, wb);
	}

	private Workbook deleteSame(Workbook wb, boolean ignoreCase) {
		Workbook newWb = new HSSFWorkbook();
		Sheet newSheet = newWb.createSheet();
		Sheet oldSheet = wb.getSheetAt(0);
		int oldRowNumber = oldSheet.getLastRowNum();
		for (int i = 0; i < oldRowNumber - 1; i++) {
			Row row = oldSheet.getRow(i);
			if (row == null)
				continue;
			Cell cell = row.getCell(12);
			if (cell == null)
				continue;
			String a = cell.getStringCellValue();
			if (a.equals("aaaaa") || a.equals(""))
				continue;
			int count;
			if (oldSheet.getRow(i).getCell(13).getCellType() == Cell.CELL_TYPE_NUMERIC)
				count = (int) oldSheet.getRow(i).getCell(13).getNumericCellValue();
			else
				continue;
			for (int j = i + 1; j < oldRowNumber; j++) {
				row = oldSheet.getRow(j);
				if (row == null)
					continue;
				cell = row.getCell(12);
				if (cell == null)
					continue;
				String b = cell.getStringCellValue();
				if (b.equals(""))
					continue;
				int count1 = (int) oldSheet.getRow(j).getCell(13).getNumericCellValue();
				a = a.replace(",", "");
				a = a.replace(" ", "");
				a = a.replace(".", "");
				a = a.replace("+", "");
				b = b.replace(",", "");
				b = b.replace(" ", "");
				b = b.replace(".", "");
				b = b.replace("+", "");

				if (a.equalsIgnoreCase(b) && ignoreCase) {
					count += count1;
					b = "aaaaa";
					oldSheet.getRow(j).getCell(12).setCellValue(b);
					oldSheet.getRow(j).getCell(13).setCellValue(0);
				} else if (a.equals(b)) {
					count += count1;
					b = "aaaaa";
					oldSheet.getRow(j).getCell(12).setCellValue(b);
					oldSheet.getRow(j).getCell(13).setCellValue(0);
				}
			}

			if (oldSheet.getRow(i).getCell(13).getCellType() == Cell.CELL_TYPE_NUMERIC)
				oldSheet.getRow(i).getCell(13).setCellValue(count);
		}
		int rowNumber = 0;
		for (int i = 0; i < oldRowNumber; i++) {
			Row row = oldSheet.getRow(i);
			if (row == null)
				continue;
			Cell cell = row.getCell(12);
			if (cell != null) {
				String a = cell.getStringCellValue();
				if (!a.equals("aaaaa")) {
					CommonTools.copyRow(newSheet, rowNumber, oldSheet.getRow(i));
					rowNumber++;
				}
			}
		}
		return newWb;
	}
}
