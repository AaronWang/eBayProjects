package defaultPackage;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class newCells {
	public static void main(String[] args) throws IOException {
		Workbook wb = new HSSFWorkbook();
		// Workbook wb = new XSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("new sheet");

		// Create a row and put some cells in it. Rows are 0 based.
		Row row = sheet.createRow((short) 0);
		// Create a cell and put a value in it.
		Cell cell = row.createCell(0);
		cell.setCellValue(1);

		// Or do it on one line.
		row.createCell(1).setCellValue(1.2);
		row.createCell(2).setCellValue(
				createHelper.createRichTextString("This is a string"));
		row.createCell(3).setCellValue(true);

		// Create a row and put some cells in it. Rows are 0 based.
		Row row1 = sheet.createRow((short) 1);
		// Create a cell and put a value in it.
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue(2);

		// Or do it on one line.
		row1.createCell(1).setCellValue(1.2);
		row1.createCell(2).setCellValue(
				createHelper.createRichTextString("This is a string in second row"));
		row1.createCell(3).setCellValue(false);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("workbookNewCells.xls");
		wb.write(fileOut);
		fileOut.close();

	}
}
