package ControlerLayer;

import ioSection.ReadWriteImplement;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

public class SoldItem {
	public boolean minusItem(String fileName1, String fileName2) {
		ReadWriteImplement rw = new ReadWriteImplement();
		Workbook wb = rw.Read(fileName1); // inventory
		if (wb == null)
			return false;
		Workbook wb1 = rw.Read(fileName2);// sold item
		if (wb1 == null)
			return false;

		Workbook wb2 = new HSSFWorkbook(); // new sold item
		Sheet sheet2 = wb2.createSheet();

		Sheet sheet = wb.getSheetAt(0);
		// print out all inventory
		if (sheet == null) {
			return false;
		}
		for (Row row : sheet) {
			for (Cell cell : row) {
				// Do something here
				CellReference cellRef = new CellReference(row.getRowNum(),
						cell.getColumnIndex());
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.println(cell.getRichStringCellValue()
							.getString());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						System.out.println(cell.getDateCellValue());
					} else {
						System.out.println(cell.getNumericCellValue());
					}
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_FORMULA:
					System.out.println("11111" + cell.getCellFormula());
					break;
				default:
					System.out.println("a");
				}
			}
		}
		// print out all inventory above.
		
		Sheet sheet1 = wb1.getSheetAt(0);
		if (sheet1 == null)
			return false;
		int rowNumber = 0;
		for (Row row1 : sheet1) {
			Cell cell1 = row1.getCell(12);
			if (cell1 == null)
				continue;
			String s = "";
			// Do something here
			// CellReference cellRef = new CellReference(row.getRowNum(),
			// cell.getColumnIndex());

			switch (cell1.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				s = cell1.getRichStringCellValue().getString();
				s = s.replace(",", "");
				s = s.replace(" ", "");
				s = s.replace(".", "");
				s = s.replace("+", "");
				// System.out.println(s);
				break;
			default:
				System.out.println();
			}
			boolean find = false;
			for (Row row : sheet) {
				find = false;
				Cell cell = row.getCell(12);
				if (cell == null)
					continue;
				// Do something here
				// CellReference cellRef = new CellReference(row.getRowNum(),
				// cell.getColumnIndex());
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:

					String a = cell.getRichStringCellValue().getString();
					a = a.replace(",", "");
					a = a.replace(" ", "");
					a = a.replace(".", "");
					s = s.replace("+", "");

					if (s.equalsIgnoreCase(a)) {
						cell = row.getCell(13);
						cell1 = row1.getCell(13);
						if (cell == null || cell1 == null)
							break;
						if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
								&& cell1.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							cell.setCellValue(cell.getNumericCellValue()
									- cell1.getNumericCellValue());
							find = true;
						}
					}
					break;
				default:
					System.out.println();
				}
				if (find)
					break;
			}
			if (!find) {
				CommonTools.copyRow(sheet2, rowNumber, row1);
				rowNumber++;
			}
		}

		// Write the output to a file
		if (!rw.Write(fileName1, wb)) {
			return false;
		}
		if (!rw.Write(fileName2, wb2))// sold left
			return false;
		return true;
	}
}
