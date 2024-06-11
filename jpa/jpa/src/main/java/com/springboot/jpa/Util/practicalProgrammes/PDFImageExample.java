package com.springboot.jpa.Util.practicalProgrammes;



	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;

	import javax.imageio.ImageIO;

	import org.apache.pdfbox.pdmodel.PDDocument;
	import org.apache.pdfbox.pdmodel.PDPage;
	import org.apache.pdfbox.pdmodel.PDPageContentStream;
	import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
	import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

	public class PDFImageExample {
	    public static void main(String[] args) {
	        String inputFile = "C:\\\\Users\\\\LavanyaGC\\\\Desktop\\\\PracticeFiles\\\\input.pdf"; // Path to the input PDF file
	        String outputFile = "C:\\Users\\LavanyaGC\\Desktop\\PracticeFiles\\output.pdf"; // Path to the output PDF file
	        String imagePath = "C:\\\\Users\\\\LavanyaGC\\\\Desktop\\\\PracticeFiles\\\\image1.jpg"; // Path to the image file

	        try {
	            PDDocument document = PDDocument.load(new File(inputFile));

	            // Load the image
	            BufferedImage image = ImageIO.read(new File(imagePath));
	           // PDImageXObject pdImage = LosslessFactory.createFromImage(document, image);
	            PDImageXObject pdImage =  PDImageXObject.createFromFile(imagePath, document);
	            // Add image to each page
	            for (PDPage page : document.getPages()) {
	                PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
	                contentStream.drawImage(pdImage, 100, 100); // Adjust the position as needed
	                contentStream.close();
	            }

	            // Save the modified document with image
	            document.save(outputFile);
	            document.close();

	            System.out.println("Image added successfully to the PDF.");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


