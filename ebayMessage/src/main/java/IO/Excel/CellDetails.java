package IO.Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

public class CellDetails {
	String excelFileName;

	Workbook wb;
	Sheet sheet;

	public static void main(String[] args) {
		CellDetails od = new CellDetails("SalesHistoryPrinting.xlsx", 0);
		// i = 8
		// BuyerAddress address = new BuyerAddress();
		// address.buyername = od.getOrderDetails(3,
		// ColumnName.BuyerFullname.getNumber());
		// address.salesRecordNumber = od.getOrderDetails(3,
		// ColumnName.SalesRecordNumber.getNumber());
		// address.address1 = od.getOrderDetails(3,
		// ColumnName.BuyerAddress1.getNumber());
		// address.address2 = od.getOrderDetails(3,
		// ColumnName.BuyerAddress2.getNumber());
		// address.city = od.getOrderDetails(3,
		// ColumnName.BuyerCity.getNumber());
		// address.state = od.getOrderDetails(3,
		// ColumnName.BuyerState.getNumber());
		// address.postcode = od.getOrderDetails(3,
		// ColumnName.BuyerPostcode.getNumber());
		// address.quantity = od.getOrderDetails(3,
		// ColumnName.Quantity.getNumber());
	}

	public CellDetails() {

	}

	public int getRowNumber() {
		return sheet.getLastRowNum();
	}

	public CellDetails(String excelFileName, int sheetNumber) {
		this.excelFileName = excelFileName;
		openFile(excelFileName, sheetNumber);
	}

	public void openFile(String excelFileName, int sheetNumber) {
		this.excelFileName = excelFileName;
		ReadWriteImplement read = new ReadWriteImplement();
		wb = read.Read(excelFileName);
		sheet = wb.getSheetAt(sheetNumber);
		

	}

	public String getCellDetails(int cellRowNumber, int cellColumnNumber) {
		Row row = sheet.getRow(cellRowNumber);
		if (row == null) {
			return "";
		}
		Cell cell = row.getCell(cellColumnNumber);

		// CellReference cellRef = new CellReference(orderNumber,
		// cellColumnNumber);
		// System.out.print(cellRef.formatAsString());
		// System.out.print(" - ");
		if (cell == null) {
			// System.out.println();
			return "";
		}

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			// System.out.println(cell.getRichStringCellValue().getString());
			return cell.getRichStringCellValue().getString();
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				System.out.println(cell.getDateCellValue());
			} else {
				// System.out.println((int) cell.getNumericCellValue());
				return Integer.toString((int) cell.getNumericCellValue());
			}
			break;
		// case Cell.CELL_TYPE_BOOLEAN:
		// System.out.println(cell.getBooleanCellValue());
		// break;
		// case Cell.CELL_TYPE_FORMULA:
		// System.out.println(cell.getCellFormula());
		// break;
		default:
			// System.out.println();
		}
		return "";
	}

	public void setCellDetails(int cellRowNumber, int cellColumnNumber, String value) {
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
			row.createCell(cellColumnNumber);
			// return "";
		}
		cell.setCellValue(value);
		saveFile();
	}

	public void saveFile() {
		ReadWriteImplement write = new ReadWriteImplement();
		write.Write(excelFileName, wb);
	}
}
