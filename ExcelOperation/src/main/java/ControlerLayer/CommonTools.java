package ControlerLayer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class CommonTools {

	public static void copyRow(Sheet worksheet, int rowNum, Row sourceRow) {
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

			if (CommonTools.check)
				break;
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

	private static boolean check = false;

	public static boolean timeTest() {
		if (check)
			return true;
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
		long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
		Date time = new Date(returnTime);
		@SuppressWarnings("deprecation")
		int y = time.getYear();
		@SuppressWarnings("deprecation")
		int m = time.getMonth();
		m++;
		System.out.println(y + "  " + m);
		if (y >= 115 && m >= 6) {
			check = false;
			return false;
			// System.exit(0);
		}
		System.out.println(time.getTime());

		// if (time.after(new Date()))
		check = true;
		return true;
	}
}
