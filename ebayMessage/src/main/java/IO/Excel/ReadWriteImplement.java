package IO.Excel;

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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteImplement implements ExcelReadWrite {

	@Override
	public Workbook Read(String fileName) {
		// TODO Auto-generated method stub
		try {
			InputStream inp = new FileInputStream(fileName);

			Workbook wb = WorkbookFactory.create(inp);
			inp.close();
			return wb;
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean Write(String fileName, Workbook wb) {
		// TODO Auto-generated method stub
		FileOutputStream fileOut;

		// CommonTools.timeTest();
		try {
			fileOut = new FileOutputStream(fileName);
			wb.write(fileOut);
			fileOut.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
