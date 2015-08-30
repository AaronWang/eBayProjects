package IO.Excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {
	Workbook wb;
	Sheet sheet;

	String excelFileName;

	public ExcelFile(String fileName) {
		excelFileName = fileName;
		File f = new File(fileName);
		if (f.exists() == false) {
			// try {
			// f.createNewFile();
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			wb = new XSSFWorkbook();
			sheet = wb.createSheet();

		} else {
			ReadWriteImplement read = new ReadWriteImplement();
			wb = read.Read(excelFileName);
			sheet = wb.getSheetAt(0);
		}
	}

	public void setCellDetails(int cellRowNumber, int cellColumnNumber, String value) {
//		System.out.println("row:" + cellRowNumber + "column:" + cellColumnNumber + "value:" + value);
		Row row = sheet.getRow(cellRowNumber);
		if (row == null) {
			row = sheet.createRow(cellRowNumber);
		}
		Cell cell = row.getCell(cellColumnNumber);

		// CellReference cellRef = new CellReference(orderNumber,
		// cellColumnNumber);
		// System.out.print(cellRef.formatAsString());
		// System.out.print(" - ");
		if (cell == null) {
			// System.out.println();
			cell = row.createCell(cellColumnNumber);
			// return "";
		}
		cell.setCellValue(value);

	}

	public void saveFile() {
		ReadWriteImplement write = new ReadWriteImplement();
		write.Write(excelFileName, wb);
	}
}
