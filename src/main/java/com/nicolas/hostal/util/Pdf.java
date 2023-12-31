package com.nicolas.hostal.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pdf {

    public void exportarAPdf(String mensaje) {
        Document document = new Document(PageSize.A6);
        try {
            // Obtener la marca de tiempo actual
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            // Crear el nombre de archivo con el formato "Boleta_TIMESTAMP.pdf"
            String filePath = "Boleta_" + timestamp + ".pdf";

            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(new Paragraph(mensaje));
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(e);
        } finally {
            document.close();
        }
    }
}