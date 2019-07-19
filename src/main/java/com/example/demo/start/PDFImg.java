package com.example.demo.start;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

public class PDFImg {
	
	public static void main(String[] args) throws IOException {
		File file=new File("D:/helloPDF.pdf");		
		if (!file.exists()) {
			file.createNewFile();
		}	
		
		PdfWriter writer=new PdfWriter(file);
		PdfDocument pdf=new PdfDocument(writer);
		Document document=new Document(pdf);	
		PdfFont font=PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
		URL url1=PDFImg.class.getResource("/image/miss.jpg");
//		URL url2=PDFImg.class.getResource("/image/2.jpg");
		Image image1=new Image(ImageDataFactory.create(url1));		
//		Image image2=new Image(ImageDataFactory.create(url2));		
		Paragraph paragraph=new Paragraph("The quick brown").add(image1).add(" jumps over the lazy ");
		document.add(paragraph);
		document.close();
		
	}
}
