
package com.pdfcompare;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class ComparePDF {

    public static void main(String[] args) throws IOException {
        String pdf1Path = "src/main/resources/pdf1.pdf";
        String pdf2Path = "src/main/resources/pdf2.pdf";

        String[] lines1 = extractLinesFromPDF(pdf1Path);
        String[] lines2 = extractLinesFromPDF(pdf2Path);

        int maxLines = Math.max(lines1.length, lines2.length);

        for (int i = 0; i < maxLines; i++) {
            String line1 = (i < lines1.length) ? lines1[i].trim() : "";
            String line2 = (i < lines2.length) ? lines2[i].trim() : "";

            if (!line1.equals(line2)) {
                System.out.println("Difference at Line " + (i + 1));
                System.out.println("PDF1 Line " + (i + 1) + ": \"" + line1 + "\"");
                System.out.println("PDF2 Line " + (i + 1) + ": \"" + line2 + "\"");
                System.out.println();
            }
        }
    }

    private static String[] extractLinesFromPDF(String path) throws IOException {
        try (PDDocument document = PDDocument.load(new File(path))) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            return text.split("\\r?\\n");
        }
    }
}
