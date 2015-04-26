package defaultPackage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

//import org.apache.commons.net.ntp.NTPUDPClient; 

public class TestMain {
	public static void main(String[] args) {
		String TIME_SERVER = "time-a.nist.gov";
		// NTPUDPClient timeClient = new NTPUDPClient();
		// InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
		// TimeInfo timeInfo = timeClient.getTime(inetAddress);
		// long returnTime = timeInfo.getMessage().getTransmitTimeStamp()
		// .getTime();
		// Date time = new Date(returnTime);

	}

	public void travelSheet() {
		Workbook wb = new HSSFWorkbook(); // or new XSSFWorkbook();
		Sheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				// Do something here
			}
		}
	}

	public void getCellContent() {
		Workbook wb = new HSSFWorkbook(); // or new XSSFWorkbook();
		Sheet sheet1 = wb.getSheetAt(0);
		for (Row row : sheet1) {
			for (Cell cell : row) {
				CellReference cellRef = new CellReference(row.getRowNum(),
						cell.getColumnIndex());
				System.out.print(cellRef.formatAsString());
				System.out.print(" - ");

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
					System.out.println(cell.getCellFormula());
					break;
				default:
					System.out.println();
				}
			}
		}
	}

	public void DifferentTypeCells() throws IOException {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("new sheet");
		Row row = sheet.createRow((short) 2);
		row.createCell(0).setCellValue(1.1);
		row.createCell(1).setCellValue(new Date());
		row.createCell(2).setCellValue(Calendar.getInstance());
		row.createCell(3).setCellValue("a string");
		row.createCell(4).setCellValue(true);
		row.createCell(5).setCellType(Cell.CELL_TYPE_ERROR);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("workbook.xls");
		wb.write(fileOut);
		fileOut.close();

	}
}
