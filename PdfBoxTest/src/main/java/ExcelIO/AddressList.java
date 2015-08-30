package ExcelIO;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.ss.formula.functions.Column;

import bean.BuyerAddress;

public class AddressList {
	public ArrayList<BuyerAddress> addresslist = new ArrayList<BuyerAddress>();

	String excelFileName = "";

	public AddressList() {
	}

	public AddressList(String fileName) {
		// TODO Auto-generated constructor stub
		excelFileName = fileName;
		updateAddressList();
	}

	public void updateFileName(String fileName) {
		excelFileName = fileName;
		updateAddressList();
	}

	//read address for excel file.
	private void updateAddressList() {
		OrderDetails od = new OrderDetails(excelFileName);
		int count = 3;
		do {
			BuyerAddress newAddress = new BuyerAddress();
			newAddress.salesRecordNumber = od.getOrderDetails(count, ColumnName.SalesRecordNumber.getNumber());
			newAddress.buyername = od.getOrderDetails(count, ColumnName.BuyerFullname.getNumber());
			newAddress.customLabel = od.getOrderDetails(count, ColumnName.CustomLabel.getNumber());
			newAddress.address1 = od.getOrderDetails(count, ColumnName.BuyerAddress1.getNumber());
			newAddress.address2 = od.getOrderDetails(count, ColumnName.BuyerAddress2.getNumber());
			newAddress.city = od.getOrderDetails(count, ColumnName.BuyerCity.getNumber());
			newAddress.state = od.getOrderDetails(count, ColumnName.BuyerState.getNumber());
			newAddress.postcode = od.getOrderDetails(count, ColumnName.BuyerPostcode.getNumber());
			newAddress.quantity = od.getOrderDetails(count, ColumnName.Quantity.getNumber());
			addresslist.add(newAddress);
			count++;
		} while (!od.getOrderDetails(count, ColumnName.SalesRecordNumber.getNumber()).equals(""));
	}

	public void sortBySalesRecords() {
		Collections.sort(addresslist, BuyerAddress.SalesRecordsComparator);
	}

	public void sortOrders() {
		combineOrders();
		CombineOrdersExtra();
		Collections.sort(addresslist, BuyerAddress.CustomLabelComparator);
	}

	private void combineOrders() {
		ArrayList<BuyerAddress> emptyCustomeLabel = new ArrayList<BuyerAddress>();
		// orders with empty custom label;
		for (int i = 0; i < addresslist.size(); i++) {
			if (addresslist.get(i).customLabel == null || addresslist.get(i).customLabel.equals("")) {
				emptyCustomeLabel.add(addresslist.get(i));
			}
		}
		for (int i = 0; i < emptyCustomeLabel.size(); i++) {
			BuyerAddress empty = emptyCustomeLabel.get(i);
			for (int j = 0; j < addresslist.size(); j++) {
				BuyerAddress left = addresslist.get(j);
				if (empty.salesRecordNumber.equals(left.salesRecordNumber) && left.address1.equals("") && left.buyername.equals("")) {
					if (empty.customLabel == null || empty.customLabel.equals(""))
						empty.customLabel = left.customLabel + " x" + left.quantity;
					else
						empty.customLabel += " +" + left.customLabel + " x" + left.quantity;
				}
			}
		}

		for (int i = 0; i < addresslist.size(); i++) {
			if ((addresslist.get(i).address1 == null || addresslist.get(i).address1.equals("")) && (addresslist.get(i).address2 == null || addresslist.get(i).address2.equals(""))) {
				addresslist.remove(i);
				i--;
			}
		}
	}

	private void CombineOrdersExtra() {
		for (int i = 0; i < addresslist.size() - 1; i++) {
			for (int j = i + 1; j < addresslist.size(); j++) {
				// System.out.println("i = " + i + " j =" + j + " size = " +
				// addresslist.size());
				if (addresslist.get(i).buyername.equals(addresslist.get(j).buyername) && addresslist.get(i).address1.equals(addresslist.get(j).address1)
						&& addresslist.get(i).postcode.equals(addresslist.get(j).postcode)) {
					addresslist.get(i).customLabel += "+" + addresslist.get(j).customLabel + " x" + addresslist.get(j).quantity;
					addresslist.get(i).quantity += "+" + addresslist.get(j).quantity;
					addresslist.remove(j);
					j--;
				}
			}
		}
	}

	public void displayOrders() {
		for (BuyerAddress address : addresslist) {
			System.out.println(address.salesRecordNumber + "-" + address.customLabel);
		}
	}

	public static void main(String[] args) {
		AddressList addressList = new AddressList("test.xlsx");
		addressList.sortOrders();
		addressList.displayOrders();
		System.out.println();
	}

	public ArrayList<BuyerAddress> getAddresslist() {
		return addresslist;
	}

	public void setAddresslist(ArrayList<BuyerAddress> addresslist) {
		this.addresslist = addresslist;
	}

}
