package printingOrders;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import bean.BuyerAddress;
import ExcelIO.AddressList;

public class GeneratePDF {

	PDDocument document;
	public AddressList addressList;
	PDPage page;
	PDFont font = PDType1Font.TIMES_ROMAN;
	PDPageContentStream contentStream;

	String currentTime;

	public GeneratePDF() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneratePDF pdf = new GeneratePDF();

		// pdf.currentTime();

		// pdf.openExcel("SalesHistory.xlsx");
		pdf.openExcel("SalesHistory.xlsx");
		pdf.addressList.sortOrders();
		pdf.currentTime();

		pdf.pdfStyleB();
	}

	public void setCurrentTime(String s) {
		currentTime = s;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setAddressList(AddressList list) {
		addressList = list;
	}

	public String currentTime() {
		String time = "";
		Calendar cal = Calendar.getInstance();
		String month;
		String date;
		String hour;
		String minute;
		String second;
		int month1, date1, hour1, minute1, second1;
		month1 = cal.get(Calendar.MONTH) + 1;
		date1 = cal.get(Calendar.DAY_OF_MONTH);
		hour1 = cal.get(Calendar.HOUR_OF_DAY);
		minute1 = cal.get(Calendar.MINUTE);
		second1 = cal.get(Calendar.SECOND);

		if (month1 < 10)
			month = "0" + month1;
		else
			month = "" + month1;

		if (date1 < 10)
			date = "0" + date1;
		else
			date = "" + date1;
		if (hour1 < 10)
			hour = "0" + hour1;
		else
			hour = "" + hour1;
		if (minute1 < 10)
			minute = "0" + minute1;
		else
			minute = "" + minute1;
		if (second1 < 10)
			second = "0" + second1;
		else
			second = "" + second1;

		time += cal.get(Calendar.YEAR) + "-" + month + "-" + date + "-" + hour + "-" + minute + "-" + second;
		System.out.println(time);
		currentTime = time;
		return time;
	}

	public void openExcel(String fileName) {
		addressList = new AddressList(fileName);
	}

	public void pdfStyleA() {
		document = new PDDocument();

		int count = 0; // number on each page;
		int position = 0;
		for (BuyerAddress address : addressList.addresslist) {
			position = count % 8;
			if (position == 0) {
				page = new PDPage(PDPage.PAGE_SIZE_A4);
				// Make sure that the content stream is closed:
				// if(contentStream!= null)contentStream.close();

				document.addPage(page);
				try {
					contentStream = new PDPageContentStream(document, page);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				printAddressA(30, 800 - position * 100, address);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (position == 7) {
				try {
					contentStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			count++;
		}

		try {
			contentStream.close();
			document.save(currentTime + ".pdf");
			document.close();
		} catch (IOException | COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pdfStyleB() {
		document = new PDDocument();

		int count = 0; // number on each page;
		int position = 0;
		for (BuyerAddress address : addressList.addresslist) {
			position = count % 9;
			if (position == 0) {
				page = new PDPage(PDPage.PAGE_SIZE_A4);
				// Make sure that the content stream is closed:
				// if(contentStream!= null)contentStream.close();

				document.addPage(page);
				try {
					contentStream = new PDPageContentStream(document, page);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				printAddressA(155, 815 - position * 93, address);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (position == 8) {
				try {
					contentStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			count++;
		}

		try {
			contentStream.close();
			document.save(currentTime + ".pdf");
			document.close();
		} catch (IOException | COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pdfStyleC() {
		document = new PDDocument();
	}

	public void printAddressA(int x, int y, BuyerAddress address) throws IOException {

		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(x, y);
		contentStream.drawString("To:  " + address.buyername);
		contentStream.moveTextPositionByAmount(0, -13);
		contentStream.drawString(address.address1);

		if (address.address2 != null && !address.address2.equals("")) {
			contentStream.moveTextPositionByAmount(0, -13);
			contentStream.drawString(address.address2);
		}
		contentStream.moveTextPositionByAmount(0, -13);
		contentStream.drawString(address.city);
		contentStream.moveTextPositionByAmount(0, -13);
		contentStream.drawString(address.state);
		contentStream.moveTextPositionByAmount(0, -13);
		contentStream.drawString(address.postcode);

		contentStream.setFont(font, 6);
		contentStream.moveTextPositionByAmount(70, 5);
		contentStream.drawString(address.salesRecordNumber);
		contentStream.endText();

		// drawing quantity
		contentStream.beginText();
		if (!address.quantity.equals("1")) {
			contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC, 14);
			contentStream.moveTextPositionByAmount(x + 235, y - 13);
			contentStream.drawString(address.quantity);
			// contentStream.moveTextPositionByAmount(0, -11);
		} else
			contentStream.moveTextPositionByAmount(x + 235, y - 13);
		contentStream.moveTextPositionByAmount(-50, -11);
		contentStream.setFont(font, 12);

		// drawing custom label
		// contentStream.moveTextPositionByAmount(x + 250, y);
		if (address.customLabel.contains("+")) {
			String[] customerlables = address.customLabel.split("\\+");
			for (int i = 0; i < customerlables.length; i++) {
				contentStream.drawString(customerlables[i]);
				contentStream.moveTextPositionByAmount(0, -12);
			}
		} else
			contentStream.drawString(address.customLabel);
		contentStream.endText();

	}

	public void printAddressB(int x, int y, BuyerAddress address) {

	}

	public void printAddressC(int x, int y, BuyerAddress address) {

	}
}
