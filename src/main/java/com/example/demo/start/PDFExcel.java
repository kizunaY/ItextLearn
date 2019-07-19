package com.example.demo.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

public class PDFExcel {
	
	public static void main(String[] args) throws IOException {
		File file=new File("D:/helloPDF.pdf");		
		if (!file.exists()) {
			file.createNewFile();
		}	
		PdfWriter writer=new PdfWriter(file);
		PdfDocument pdf=new PdfDocument(writer);
		Document document=new Document(pdf,PageSize.A4.rotate());
		document.setMargins(20, 20, 20, 20);
		PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
		PdfFont bord=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		Table table=new Table(new float[]{4, 1, 3, 4, 3, 3, 3, 3, 1});
		table.setWidth(UnitValue.createPercentValue(100));
		BufferedReader br = new BufferedReader(new FileReader("D:\\test.csv"));
		String line = br.readLine();
		process(table, line, bord, true);
		while ((line = br.readLine()) != null) {
		    process(table, line, font, false);
		}
		br.close();
		document.add(table);
		document.close();
	}
	
	
	public static void process(Table table, String line, PdfFont font, boolean isHeader) {
	    StringTokenizer tokenizer = new StringTokenizer(line, ";");
	    while (tokenizer.hasMoreTokens()) {
	        if (isHeader) {
	            table.addHeaderCell(
	                new Cell().add(
	                    new Paragraph(tokenizer.nextToken()).setFont(font)));
	        } else {
	            table.addCell(
	                new Cell().add(
	                    new Paragraph(tokenizer.nextToken()).setFont(font)));
	        }
	    }
	}
}
