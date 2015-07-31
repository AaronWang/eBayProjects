package printingOrders;

import java.io.IOException;
import java.util.Calendar;

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

	public GeneratePDF() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneratePDF pdf = new GeneratePDF();
		// pdf.currentTime();

		pdf.openExcel("SalesHistory.xlsx");
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

		time += cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH) + "-" + cal.get(Calendar.HOUR_OF_DAY) + "-"
				+ cal.get(Calendar.MINUTE) + "-" + cal.get(Calendar.SECOND);
		System.out.println(time);

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

		document.save(currentTime() + ".pdf");
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
