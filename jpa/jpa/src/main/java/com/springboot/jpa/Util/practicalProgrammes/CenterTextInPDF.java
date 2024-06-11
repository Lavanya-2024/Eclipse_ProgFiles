package com.springboot.jpa.Util.practicalProgrammes;

	import java.io.File;
	import java.io.IOException;

	import org.apache.pdfbox.pdmodel.PDDocument;
	import org.apache.pdfbox.pdmodel.PDPage;
	import org.apache.pdfbox.pdmodel.PDPageContentStream;
	import org.apache.pdfbox.pdmodel.font.PDType1Font;
	import org.apache.pdfbox.util.Matrix;

	public class CenterTextInPDF {
	    public static void main(String[] args) {
	        String filePath = "C:\\Users\\LavanyaGC\\Desktop\\PracticeFiles\\output.pdf"; // Path to the output PDF file
	        String text = "Centered Text"; // Text to be centered
	        
	        try (PDDocument document = new PDDocument()) {
	            PDPage page = new PDPage();
	            document.addPage(page);

	            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
	                contentStream.setFont(PDType1Font.HELVETICA, 12);

	                float textWidth = PDType1Font.HELVETICA.getStringWidth(text) / 1000 * 12; // Calculate text width
	                float pageWidth = page.getMediaBox().getWidth();
	                float textX = (pageWidth - textWidth) / 2; // Calculate x-coordinate for centering text

	                float pageHeight = page.getMediaBox().getHeight();
	                float textY = (pageHeight - 12) / 2; // Calculate y-coordinate for centering text (assuming font size of 12)

	                contentStream.beginText();
	                contentStream.setTextMatrix(Matrix.getTranslateInstance(textX, textY));
	                contentStream.showText(text);
	                contentStream.endText();
	            }

	            document.save(filePath);
	            System.out.println("PDF created successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


