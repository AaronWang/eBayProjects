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
	AddressList addressList;
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

		pdf.openExcel("SalesHistory.xlsx");
		pdf.addressList.sortOrders();
		pdf.currentTime();

		try {
			pdf.pdfStyleA();
		} catch (IOException | COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void pdfStyleA() throws IOException, COSVisitorException {
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
				contentStream = new PDPageContentStream(document, page);
			}

			printAddressA(60, 800 - position * 100, address);
			if (position == 7) {
				contentStream.close();
			}
			count++;
		}

		contentStream.close();

		document.save(currentTime + ".pdf");
		document.close();
	}

	public void pdfStyleB() {
		document = new PDDocument();
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

		if (!address.address2.equals("")) {
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

		contentStream.beginText();
		if (!address.quantity.equals("1")) {
			contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC, 14);
			contentStream.moveTextPositionByAmount(x + 250, y);
			contentStream.drawString(address.quantity);
		} else
			contentStream.moveTextPositionByAmount(x + 250, y + 15);
		contentStream.setFont(font, 12);
		// contentStream.moveTextPositionByAmount(x + 250, y);
		contentStream.moveTextPositionByAmount(0, -15);
		contentStream.drawString(address.customLabel);
		contentStream.endText();

	}

	public void printAddressB(int x, int y, BuyerAddress address) {

	}

	public void printAddressC(int x, int y, BuyerAddress address) {

	}
}
