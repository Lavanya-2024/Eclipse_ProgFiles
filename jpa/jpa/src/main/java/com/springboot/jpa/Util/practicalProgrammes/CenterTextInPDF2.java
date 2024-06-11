package com.springboot.jpa.Util.practicalProgrammes;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.util.Matrix;

public class CenterTextInPDF2 {

	public static void main(String[] args) {
        String outputPath = "C:\\Users\\LavanyaGC\\Desktop\\PracticeFiles\\output.pdf";

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            String text = "MemkoSystems2024";
            float fontSize = 12; // Font size in points

            // Get text width
            float textWidth = PDType1Font.HELVETICA.getStringWidth(text) / 1000 * fontSize;

            // Calculate center coordinates
            float centerX = (page.getMediaBox().getWidth() - textWidth) / 2;
            float centerY = (page.getMediaBox().getHeight() - fontSize) / 2;

            // Begin text rendering
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, fontSize);
            contentStream.setTextMatrix(Matrix.getTranslateInstance(centerX, centerY));
            contentStream.showText(text);
            contentStream.endText();

            contentStream.close();

            document.save(new File(outputPath));
            System.out.println("PDF with centered text created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
