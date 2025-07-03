package com.pdfcompare;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class CompareBigPDF {

    public static void main(String[] args) throws IOException {
        String pdf1Path = "src/main/resources/pdf1.pdf";
        String pdf2Path = "src/main/resources/pdf2.pdf";

        try (PDDocument doc1 = PDDocument.load(new File(pdf1Path));
             PDDocument doc2 = PDDocument.load(new File(pdf2Path))) {

            int numPages1 = doc1.getNumberOfPages();
            int numPages2 = doc2.getNumberOfPages();
            int maxPages = Math.max(numPages1, numPages2);

            PDFTextStripper stripper = new PDFTextStripper();

            for (int page = 1; page <= maxPages; page++) {
                stripper.setStartPage(page);
                stripper.setEndPage(page);

                String text1 = (page <= numPages1) ? stripper.getText(doc1) : "";
                String text2 = (page <= numPages2) ? stripper.getText(doc2) : "";

                String[] words1 = text1.trim().split("\\s+");
                String[] words2 = text2.trim().split("\\s+");

                int maxWords = Math.max(words1.length, words2.length);
                boolean mismatchFound = false;

                for (int i = 0; i < maxWords; i++) {
                    String w1 = (i < words1.length) ? words1[i] : "[MISSING]";
                    String w2 = (i < words2.length) ? words2[i] : "[MISSING]";

                    if (!w1.equals(w2)) {
                        if (!mismatchFound) {
                            System.out.println("---- Differences on Page " + page + " ----");
                            mismatchFound = true;
                        }
                        System.out.printf("Word %d:\nPDF1: \"%s\"\nPDF2: \"%s\"\n\n", i + 1, w1, w2);
                    }
                }
            }
        }
    }
}