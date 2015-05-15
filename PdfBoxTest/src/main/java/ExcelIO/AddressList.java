package ExcelIO;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.Column;

public class AddressList {
	public ArrayList<BuyerAddress> addresslist = new ArrayList<BuyerAddress>();

	String excelFileName = "";

	public AddressList(String fileName) {
		// TODO Auto-generated constructor stub
		excelFileName = fileName;
		updateAddressList();
	}

	public void updateFileName(String fileName) {
		excelFileName = fileName;
		updateAddressList();
	}

	private void updateAddressList() {
		OrderDetails od = new OrderDetails(excelFileName);
		int count = 1;
		do {
			BuyerAddress newAddress = new BuyerAddress();
			newAddress.salesRecordNumber = od.getOrderDetails(count,
					ColumnName.SalesRecordNumber.getNumber());
			newAddress.buyername = od.getOrderDetails(count,
					ColumnName.BuyerFullname.getNumber());
			newAddress.customLabel = od.getOrderDetails(count,
					ColumnName.CustomLabel.getNumber());
			newAddress.address1 = od.getOrderDetails(count,
					ColumnName.BuyerAddress1.getNumber());
			newAddress.address2 = od.getOrderDetails(count,
					ColumnName.BuyerAddress2.getNumber());
			newAddress.city = od.getOrderDetails(count,
					ColumnName.BuyerCity.getNumber());
			newAddress.state = od.getOrderDetails(count,
					ColumnName.BuyerState.getNumber());
			newAddress.postcode = od.getOrderDetails(count,
					ColumnName.BuyerPostcode.getNumber());
			newAddress.quantity = od.getOrderDetails(count,
					ColumnName.Quantity.getNumber());
			addresslist.add(newAddress);
			count++;
		} while (!od.getOrderDetails(count,
				ColumnName.SalesRecordNumber.getNumber()).equals(""));
		
	}

	public static void main(String[] args) {
		AddressList addressList = new AddressList("SalesHistoryPrinting.xlsx");
		System.out.println();
	}

}
