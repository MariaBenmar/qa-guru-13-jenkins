package guru.qa.hw13_8;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class ZipFilesParse {
    ClassLoader classLoader = ZipFilesParse.class.getClassLoader();

    @Test
    @DisplayName("Reading files (pdf, csv, xls) from ZIP archive")
    void zipUnpackTest() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("files.zip")) {
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains("csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis, UTF_8));
                    List<String[]> csvList = csvReader.readAll();
                    assertThat(csvList).contains(
                            new String[]{"John", "Doe", "120 jefferson st.", "Riverside", " NJ", " 08075"});
                    System.out.println("CSV file is checked");
                } else if (entry.getName().contains("pdf")) {
                    PDF pdf = new PDF(zis);
                    assertThat(pdf.text).contains("This is a small demonstration .pdf file");
                    System.out.println("PDF file is checked");
                } else if (entry.getName().contains("xls")) {
                    XLS xls = new XLS(zis);
                    assertThat(xls.excel.getSheetAt(0).
                            getRow(2).
                            getCell(1).
                            getStringCellValue()
                    ).contains("Mara");
                    assertThat(xls.excel.getSheetAt(0).
                            getRow(4).
                            getCell(6).
                            getStringCellValue()
                    ).contains("15/10/2017");
                    System.out.println("XLS file is checked");
                }
            }
        }
    }
}
