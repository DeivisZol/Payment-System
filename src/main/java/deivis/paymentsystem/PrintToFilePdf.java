package deivis.paymentsystem;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import javafx.scene.text.Font;

import java.io.FileOutputStream;
import java.io.IOException;

public class PrintToFilePdf implements PrintToFile {

    @Override
    public void printToFile(TableDataRow[] groups) {
        try {
            FileOutputStream fos = new FileOutputStream("AtaskaitaPDF.pdf");
            PdfWriter writer = new PdfWriter(fos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            String pdfHeader = "";
            for (String s : new String[]{"Id", "Vardas", "Pavarde", "Grupe", "Menesis", "Suma"}) {
                String head = String.format("%-20s", s);
                pdfHeader += head;
            }
            document.add(new Paragraph(String.valueOf(pdfHeader)));
            for (int i = 0; i < groups.length; i++) {
                String line = String.format("%-22s", groups[i].getId());
                line += String.format("%-22s", groups[i].getName());
                line += String.format("%-22s", groups[i].getSurname());
                line += String.format("%-22s", groups[i].getGroup());
                line += String.format("%-22s", groups[i].getMonth());
                line += String.format("%-22s", groups[i].getPaymentAmount());
                document.add(new Paragraph(String.valueOf(line)));
            }
        document.close();
        }
        catch(IOException e) {}
    }
    }

