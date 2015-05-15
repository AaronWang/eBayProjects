package pdfBox;

import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws COSVisitorException,
			IOException {
		// TODO Auto-generated method stub

		// Create a new empty document
		PDDocument document = new PDDocument();

		PDPage page = new PDPage(PDPage.PAGE_SIZE_A4);

		// document.addPage(blankPage);
		document.addPage(page);

		PDFont font = PDType1Font.TIMES_ROMAN;
		PDPageContentStream contentStream = new PDPageContentStream(document,
				page);
		
		// Define a text content stream using the selected font, moving the
		// cursor and drawing the text "Hello World"
		contentStream.beginText();
		contentStream.setFont(font, 12);
//		contentStream.moveTextPositionByAmount(200, 700);
		contentStream.setTextRotation(-90*Math.PI/180, 200,700);//弧度 角度 转化
		contentStream.drawString("Hello World");
	
		contentStream.endText();

		// Make sure that the content stream is closed:
		contentStream.close();
		// Save the newly created document
		document.save("BlankPage.pdf");

		// finally make sure that the document is properly
		// closed.
		document.close();
	}
}




