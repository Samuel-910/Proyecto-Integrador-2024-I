package com.example.mscoordinador.util;

import com.example.mscoordinador.entity.Convocatoria;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
public class PdfUtils {
    public static ByteArrayOutputStream generatePdfStream(List<Convocatoria> convocatorias
    ) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        for (Convocatoria convocatoria : convocatorias) {
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Paragraph paragraph = new Paragraph(convocatoria.getTitulo(), boldFont);
            document.add(paragraph);
        }
        document.add(new Paragraph("\n"));
        // Write data rows
        /*for (Map<String, Object> row : queryResults) {
            for (Object value : row.values()) {
                Paragraph paragraph = new Paragraph(value.toString());
                document.add(paragraph);
            }
            document.add(new Paragraph("\n"));
        }*/
        document.close();
        return outputStream;
    }
}