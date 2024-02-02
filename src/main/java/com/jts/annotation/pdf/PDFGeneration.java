package com.jts.annotation.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGeneration {
	
	public static void main(String[] args) throws DocumentException, MalformedURLException, URISyntaxException, IOException {
		Document doc = new Document();
		
		PdfWriter.getInstance(doc, new FileOutputStream("sample.pdf"));
		
		doc.open();
		
		Paragraph par = new Paragraph("Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image.\n");
		doc.add(par);
		
		PdfPTable table = new PdfPTable(3);
		tableHeader(table);
		addRow(table);
		addCustomRow(table);
		
		doc.add(table);
		
		doc.close();
		
	}
	
	private static void tableHeader(PdfPTable table) {
		Stream.of("Id", "First Name", "Last Name").forEach( title -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.CYAN);
			header.setBorderWidth(1);
			header.setPhrase(new Phrase(title));
			table.addCell(header);
		});
	}
	
	private static void addRow(PdfPTable table) {
		table.addCell("1");
		table.addCell("PDF");
		table.addCell("Generation");
	}
	
	private static void addCustomRow(PdfPTable table) throws URISyntaxException, BadElementException, MalformedURLException, IOException {
		Path path = Paths.get(ClassLoader.getSystemResource("p3.jpg").toURI());
		
		Image img = Image.getInstance(path.toAbsolutePath().toString());
		img.scalePercent(10);
		
		PdfPCell imageCell = new PdfPCell(img);
		table.addCell(imageCell);
		
		PdfPCell desc = new PdfPCell(new Phrase("Description"));
		desc.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(desc);
		
		PdfPCell remarks = new PdfPCell(new Phrase("Reamrks"));
		remarks.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(remarks);
	}

}
