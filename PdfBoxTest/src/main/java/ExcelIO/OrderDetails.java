package ExcelIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

public class OrderDetails {

	Workbook wb;
	Sheet orderSheet;

	public static void main(String[] args) {
		OrderDetails od = new OrderDetails("SalesHistoryPrinting.xlsx");
		// i = 8
		od.getOrderDetails(2, ColumnName.SalesRecordNumber.getNumber());
		od.getOrderDetails(2, ColumnName.BuyerAddress1.getNumber());
		od.getOrderDetails(2, ColumnName.BuyerAddress2.getNumber());
		od.getOrderDetails(2, ColumnName.BuyerCity.getNumber());
		od.getOrderDetails(2, ColumnName.BuyerState.getNumber());
		od.getOrderDetails(2, ColumnName.BuyerPostcode.getNumber());
		od.getOrderDetails(2, ColumnName.Quantity.getNumber());
	}

	public OrderDetails() {

	}

	public OrderDetails(String excelFileName) {
		openOrders(excelFileName);
	}

	public void openOrders(String excelFileName) {
		ReadWriteImplement read = new ReadWriteImplement();
		wb = read.Read(excelFileName);
		orderSheet = wb.getSheetAt(0);
	}

	public String getOrderDetails(int orderNumber, int cellColumnNumber) {
		Row row = orderSheet.getRow(orderNumber);
		if (row == null) {
			return "";
		}
		Cell cell = row.getCell(cellColumnNumber);

//		CellReference cellRef = new CellReference(orderNumber, cellColumnNumber);
//		System.out.print(cellRef.formatAsString());
//		System.out.print(" - ");
		if (cell == null) {
//			System.out.println();
			return "";
		}

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
//			System.out.println(cell.getRichStringCellValue().getString());
			return cell.getRichStringCellValue().getString();
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				System.out.println(cell.getDateCellValue());
			} else {
//				System.out.println((int) cell.getNumericCellValue());
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
//			System.out.println();
		}
		return "";
	}
}
