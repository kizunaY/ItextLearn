package com.example.demo.start;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class HelloPDF {
	public static void main(String[] args) throws IOException {
		File file=new File("D:/helloPDF.p");
		
		if (!file.exists()) {
			file.createNewFile();
		}
		PdfWriter writer = new PdfWriter(file);
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);
		document.add(new Paragraph("Hello World!"));
		document.close();
	}
	
	
	
}
