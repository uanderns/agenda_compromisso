package br.com.cotiinformatica.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.cotiinformatica.dto.RelatorioCompromissoDTO;
import br.com.cotiinformatica.entities.Compromisso;

public class CompromissoReport {

	// m�todo para retornar um relat�rio PDF em formato byte
	public static ByteArrayInputStream getPdf(RelatorioCompromissoDTO dto) throws Exception {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, out);
		
		document.open(); //documento aberto!
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		document.add(new Paragraph("Relatorio de Compromissos"));
		document.add(new Paragraph("Per�odo de: " + sdf.format(dto.getDataInicio())));
		document.add(new Paragraph("At�: " + sdf.format(dto.getDataFim())));
		
		document.add(new Paragraph("Nome do Usu�rio: " + dto.getUsuario().getNome()));
		document.add(new Paragraph("Email: " + dto.getUsuario().getEmail()));
		
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
		
		table.addCell("Nome do Compromisso");
		table.addCell("Data");
		table.addCell("Hora");
		table.addCell("Tipo");
		table.addCell("Prioridade");
		
		for (Compromisso item : dto.getCompromissos()) {
			
			table.addCell(item.getNome());
			table.addCell(sdf.format(item.getData()));
			table.addCell(item.getHora());
			table.addCell(item.getTipo().toString());
			table.addCell(item.getPrioridade().toString());
		}
		
		document.add(table); //incluindo a tabela no documento PDF
		
		document.add(new Paragraph("Registros obtidos: " + dto.getCompromissos().size()));
		
		document.close();
		writer.close();
		
		return new ByteArrayInputStream(out.toByteArray());
	}
}





