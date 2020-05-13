package com.cg.wallet.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.wallet.entity.WalletTransaction;
import com.cg.wallet.exceptions.WalletTXNNotFouException;
import com.cg.wallet.service.ViewWalletService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@RestController
public class PDFController {
	@Autowired
	private ViewWalletService service;
	
	@CrossOrigin
	@GetMapping("/viewpdf/{walletId}")
	public void downloadPdf(HttpServletResponse response, @PathVariable String walletId) throws WalletTXNNotFouException {
		List<WalletTransaction> lst = service.getSixMonthsTxn(walletId);
		Document document = new Document();
		
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			document.add(new Paragraph("List of transactions"));
			PdfPTable table = new PdfPTable(4);
			table.setWidthPercentage(100);
			table.setSpacingAfter(10f);
			table.setSpacingBefore(10f);
			
			PdfPCell cell1 = new PdfPCell(new Paragraph("Date of Transaction"));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Description"));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Amount"));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Transaction Type"));
			
			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			
			for(WalletTransaction transactions: lst) {
				cell1 = new PdfPCell(new Paragraph(transactions.getDateOfTranscation().toString()));
				cell2 = new PdfPCell(new Paragraph(transactions.getDescription()));
				cell3 = new PdfPCell(new Paragraph(String.valueOf(transactions.getAmount())));
				cell4 = new PdfPCell(new Paragraph(transactions.getTxType()));
				
				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				
			}
			document.add(table);
			document.close();
			pdfWriter.close();
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
}
