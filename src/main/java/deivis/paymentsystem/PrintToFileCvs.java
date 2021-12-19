package deivis.paymentsystem;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class PrintToFileCvs implements PrintToFile{

    @Override
    public void printToFile(TableDataRow[] results) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Ataskaita.csv"), StandardCharsets.UTF_8))) {
            writer.write("sep=,");
            writer.newLine();
            writer.write("Id,Vardas,Pavarde,Grupe,Menesis,Suma");
            writer.newLine();

            for (TableDataRow result : results) {
                writer.write(result.getId() + "," + result.getName() + "," + result.getSurname() + "," + result.getGroup() + "," + result.getMonth() + "," + result.getPaymentAmount());
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
