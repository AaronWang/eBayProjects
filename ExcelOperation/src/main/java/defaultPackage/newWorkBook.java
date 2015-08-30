package defaultPackage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class newWorkBook {
	public static void main(String[] args) throws IOException {
		//  xls  97-07
//		Workbook wb = new HSSFWorkbook();
//		FileOutputStream fileOut = new FileOutputStream("workbook.xls");
//		wb.write(fileOut);
//		fileOut.close();

		//xlsx  07-
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("test");
		
		FileOutputStream fileOut = new FileOutputStream("111111workbook.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}
}
