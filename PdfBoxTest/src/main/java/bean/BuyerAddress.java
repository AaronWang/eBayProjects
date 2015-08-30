package bean;

import java.util.Comparator;

public class BuyerAddress {

	public BuyerAddress() {
		// TODO Auto-generated constructor stub
	}

	public String myEbayID;
	public String orderID;
	public String salesRecordNumber;
	public String buyername;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String postcode;
	public String quantity;
	public String customLabel;

	public static Comparator<BuyerAddress> CustomLabelComparator = new Comparator<BuyerAddress>() {
		@Override
		public int compare(BuyerAddress arg0, BuyerAddress arg1) {
			// TODO Auto-generated method stub
			return arg0.customLabel.compareTo(arg1.customLabel);
		}
	};
	public static Comparator<BuyerAddress> SalesRecordsComparator = new Comparator<BuyerAddress>() {
		@Override
		public int compare(BuyerAddress arg0, BuyerAddress arg1) {
			// TODO Auto-generated method stub
			return arg0.salesRecordNumber.compareTo(arg1.salesRecordNumber);
		}
	};
}
