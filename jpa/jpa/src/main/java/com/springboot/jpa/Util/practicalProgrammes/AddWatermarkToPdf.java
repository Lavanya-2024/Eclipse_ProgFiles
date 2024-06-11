package com.springboot.jpa.Util.practicalProgrammes;
import java.io.File;
import java.io.IOException;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class AddWatermarkToPdf {

	public static void main(String[] args) {
        String inputFile = "input.pdf"; // Path to the input PDF file
        String outputFile = "output.pdf"; // Path to the output PDF file
        String watermarkText = "CONFIDENTIAL"; // Watermark text

        try {
            PDDocument document = PDDocument.load(new File(inputFile));

            // Add watermark to each page
            for (PDPage page : document.getPages()) {
                PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 48);
                contentStream.setLeading(48 * 1.5f);
                contentStream.newLineAtOffset(100, 300);
                contentStream.showText(watermarkText);
                contentStream.endText();
                contentStream.close();
            }

            // Save the modified document with watermark
            document.save(outputFile);
            document.close();

            System.out.println("Watermark added successfully to the PDF.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
