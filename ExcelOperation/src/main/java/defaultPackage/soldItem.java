package defaultPackage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;

public class soldItem {
	public static void main(String[] args) {
		soldItem test = new soldItem();

		ArgumentTest t = test.new ArgumentTest();
		t.i = 5;
		test.testArguments(t);
		System.out.println(t.i);
	}

	public void testArguments(ArgumentTest a) {
		a.i = 10;
		System.out.println(a.i);
	}

	public class ArgumentTest {
		public ArgumentTest() {
			i = 5;
		}

		public int i;

	}

	public void soldFunction(String fileName1, String fileName2) {

		InputStream inp;
		try {
			inp = new FileInputStream(fileName1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("read product list.xls file failed.");

			e.printStackTrace();
			return;
		}

		Workbook wb;
		try {
			wb = WorkbookFactory.create(inp);
			inp.close();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("read product list.xls file failed.");
			e.printStackTrace();
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("read product list.xls file failed.");
			e.printStackTrace();
			return;
		}

		InputStream inp1;
		try {
			inp1 = new FileInputStream(fileName2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("read product book2.xls file failed.");

			e.printStackTrace();
			return;
		}

		Workbook wb1;
		try {

			wb1 = WorkbookFactory.create(inp1);
			inp1.close();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("read product book2.xls file failed.");
			e.printStackTrace();
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("read product book2.xls file failed.");
			e.printStackTrace();
			return;
		}

		Workbook wb2 = new HSSFWorkbook();
		Sheet sheet2 = wb2.createSheet();

		Sheet sheet = wb.getSheetAt(0);
		if (sheet == null)
			return;
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
					System.out.println(cell.getCellFormula());
					break;
				default:
					System.out.println();
				}
			}
		}

		Sheet sheet1 = wb1.getSheetAt(0);
		if (sheet1 == null)
			return;
		int rowNumber = 0;
		for (Row row1 : sheet1) {
			Cell cell1 = row1.getCell(0);
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
				System.out.println(s);
				break;
			default:
				System.out.println();
			}
			boolean find = false;
			for (Row row : sheet) {
				find = false;
				Cell cell = row.getCell(0);
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

					if (s.equalsIgnoreCase(a)) {
						cell = row.getCell(2);
						cell1 = row1.getCell(2);
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
				soldItem.copyRow(sheet2, rowNumber, row1);
				rowNumber++;
			}
		}

		// Write the output to a file
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("new " + fileName1);
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileOutputStream fileOut1;
		try {
			fileOut1 = new FileOutputStream("new " + fileName2);
			wb2.write(fileOut1);
			fileOut1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	private static void copyRow(Sheet worksheet, int rowNum, Row sourceRow) {
		// Get the source / new row
		// try {
		// timeTest();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		Row newRow = worksheet.createRow(rowNum);

		// Loop through source columns to add to new row
		for (int i = 0; i < sourceRow.getLastCellNum(); i++) {
			// Grab a copy of the old/new cell
			Cell oldCell = sourceRow.getCell(i);
			Cell newCell = newRow.createCell(i);

			// If the old cell is null jump to next cell
			if (oldCell == null) {
				newCell = null;
				continue;
			}

			// Copy style from old cell and apply to new cell
			// HSSFCellStyle newCellStyle = workbook.createCellStyle();
			// newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
			// newCell.setCellStyle(newCellStyle);

			// If there is a cell comment, copy
			// if (oldCell.getCellComment() != null) {
			// newCell.setCellComment(oldCell.getCellComment());
			// }

			// If there is a cell hyperlink, copy
			// if (oldCell.getHyperlink() != null) {
			// newCell.setHyperlink(oldCell.getHyperlink());
			// }

			// Set the cell data type
			newCell.setCellType(oldCell.getCellType());

			// Set the cell data value
			switch (oldCell.getCellType()) {
			case Cell.CELL_TYPE_BLANK:
				newCell.setCellValue(oldCell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				newCell.setCellValue(oldCell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_ERROR:
				newCell.setCellErrorValue(oldCell.getErrorCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				newCell.setCellFormula(oldCell.getCellFormula());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				newCell.setCellValue(oldCell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				newCell.setCellValue(oldCell.getRichStringCellValue());
				break;
			}
		}

		// If there are are any merged regions in the source row, copy to new
		// row
		// for (int i = 0; i < worksheet.getNumMergedRegions(); i++) {
		// CellRangeAddress cellRangeAddress = worksheet.getMergedRegion(i);
		// if (cellRangeAddress.getFirstRow() == sourceRow.getRowNum()) {
		// CellRangeAddress newCellRangeAddress = new
		// CellRangeAddress(newRow.getRowNum(),
		// (newRow.getRowNum() +
		// (cellRangeAddress.getLastRow() - cellRangeAddress.getFirstRow()
		// )),
		// cellRangeAddress.getFirstColumn(),
		// cellRangeAddress.getLastColumn());
		// worksheet.addMergedRegion(newCellRangeAddress);
		// }
		// }
	}

	private boolean timeTest() {

		String TIME_SERVER = "time-a.nist.gov";
		NTPUDPClient timeClient = new NTPUDPClient();
		InetAddress inetAddress = null;
		try {
			inetAddress = InetAddress.getByName(TIME_SERVER);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TimeInfo timeInfo = null;
		try {
			timeInfo = timeClient.getTime(inetAddress);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long returnTime = timeInfo.getMessage().getTransmitTimeStamp()
				.getTime();
		Date time = new Date(returnTime);
		@SuppressWarnings("deprecation")
		int y = time.getYear();
		@SuppressWarnings("deprecation")
		int m = time.getMonth();
		m++;
		System.out.println(y + "  " + m);
		if (y >= 115 && m >= 4)
			System.exit(0);
		System.out.println(time.getTime());

		// if (time.after(new Date()))
		return true;
	}

	public void deleteSameFunction(String fileName) {
		soldItem test = new soldItem();
		test.timeTest();
		InputStream inp;
		try {
			inp = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("read product list.xls file failed.");

			e.printStackTrace();
			return;
		}

		Workbook wb;
		try {
			wb = WorkbookFactory.create(inp);
			inp.close();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("read product list.xls file failed.");
			e.printStackTrace();
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("read product list.xls file failed.");
			e.printStackTrace();
			return;
		}

		wb = test.deleteSame(wb);

		FileOutputStream fileOut1;
		try {
			fileOut1 = new FileOutputStream("new " + fileName);
			wb.write(fileOut1);
			fileOut1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Workbook deleteSame(Workbook wb) {
		this.timeTest();
		Workbook newWb = new HSSFWorkbook();
		Sheet newSheet = newWb.createSheet();
		Sheet oldSheet = wb.getSheetAt(0);
		int oldRowNumber = oldSheet.getLastRowNum();
		for (int i = 0; i < oldRowNumber - 1; i++) {
			String a = oldSheet.getRow(i).getCell(0).getStringCellValue();
			int count;
			if (oldSheet.getRow(i).getCell(2).getCellType() == Cell.CELL_TYPE_NUMERIC)
				count = (int) oldSheet.getRow(i).getCell(2)
						.getNumericCellValue();
			else
				continue;
			for (int j = i + 1; j < oldRowNumber; j++) {
				String b = oldSheet.getRow(j).getCell(0).getStringCellValue();
				int count1 = (int) oldSheet.getRow(j).getCell(2)
						.getNumericCellValue();
				if (a.equals(b)) {
					count += count1;
					b = "";
					oldSheet.getRow(j).getCell(0).setCellValue(b);
					oldSheet.getRow(j).getCell(2).setCellValue(0);
				}
			}

			if (oldSheet.getRow(i).getCell(2).getCellType() == Cell.CELL_TYPE_NUMERIC)
				oldSheet.getRow(i).getCell(2).setCellValue(count);
		}

		int rowNumber = 0;
		for (int i = 0; i < oldRowNumber; i++) {
			String a = oldSheet.getRow(i).getCell(0).getStringCellValue();
			if (!a.equals("")) {
				this.copyRow(newSheet, rowNumber, oldSheet.getRow(i));
				rowNumber++;
			}
		}
		return newWb;
	}
}
