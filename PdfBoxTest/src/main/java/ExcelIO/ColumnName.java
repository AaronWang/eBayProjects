package ExcelIO;

public enum ColumnName {
	SalesRecordNumber(0),BuyerFullname(2),BuyerAddress1(5), BuyerAddress2(6),BuyerCity(7),BuyerState(8),BuyerPostcode(9),CustomLabel(13),Quantity(14);
	int number;

	ColumnName(int num) {
		number = num;
	}

	int getNumber() {
		return number;
	}

}
