package defaultPackage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readAndRewrite {
	public static void main(String[] args) throws IOException,
			InvalidFormatException {
		InputStream inp = new FileInputStream("workbook.xls");
		// InputStream inp = new FileInputStream("workbook.xlsx");

		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);
		
		Row row = sheet.getRow(2);
		if (row == null)
			row = sheet.createRow(2);
		row = sheet.createRow(2);//creating new Row, will delete the old row. others don't change.
		
		Cell cell = row.getCell(3);

		if (cell == null)
			cell = row.createCell(3);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue("a test");
		sheet.removeRow(row);
		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("workbook.xls");
		wb.write(fileOut);
		fileOut.close();
	}
}
