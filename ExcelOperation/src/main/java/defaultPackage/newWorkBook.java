package defaultPackage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
		FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}
}
