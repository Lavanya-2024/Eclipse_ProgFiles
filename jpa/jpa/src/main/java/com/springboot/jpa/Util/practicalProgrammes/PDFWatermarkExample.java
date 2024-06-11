package com.springboot.jpa.Util.practicalProgrammes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.text.Document;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;

	public class PDFWatermarkExample {
	    public static void main(String[] args) throws IOException {
	        String inputFile = "C:\\Users\\LavanyaGC\\Desktop\\PracticeFiles\\input.pdf"; // Path to the input PDF file
	        String outputFile = "C:\\Users\\LavanyaGC\\Desktop\\PracticeFiles\\output.pdf"; // Path to the output PDF file
	        String watermarkText = "MemkoSystems"; // Watermark text
	        String imagePath = "C:\\\\Users\\\\LavanyaGC\\\\Desktop\\\\PracticeFiles\\\\image1.jpg"; // Path to the image file
	        try {
	            PDDocument document = PDDocument.load(new File(inputFile));
	            PDPage page = new PDPage(PDRectangle.A4);
	            document.addPage(page);
            
	            
	            // Add watermark to each page
	            for (PDPage page1 : document.getPages()) {
	            	
	                PDPageContentStream contentStream = new PDPageContentStream(document, page1, PDPageContentStream.AppendMode.APPEND, true, true);
	             
	                contentStream.beginText();
	                contentStream.setFont(PDType1Font.TIMES_ROMAN, 60);
	                contentStream.setNonStrokingColor(200, 200, 200); 
	                contentStream.setTextRotation (Math.PI / 4, 150, 300); //(Math.PI / 4, 300, 300); 
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
	        
	       /* PDDocument document = PDDocument.load(new File(inputFile));

            // Load the image
            BufferedImage image = ImageIO.read(new File(imagePath));
            PDImageXObject pdImage = LosslessFactory.createFromImage(document, image);

            // Add image to each page
            for (PDPage page : document.getPages()) {
                PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
                contentStream.drawImage(pdImage, 50, 50); // Adjust the position as needed
                contentStream.close();
            }

            // Save the modified document with image
            document.save(outputFile);
            document.close();

            System.out.println("Image added successfully to the PDF.");
                    
	       */   
	       
	        
	    }
	}


