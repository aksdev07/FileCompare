# PDF Comparator (Java + Maven)

A Java application to compare two PDF files **word-by-word** and **page-by-page**, and report any differences with exact word positions. Designed to work efficiently with large PDFs (e.g. 50+ pages).

---

## 🚀 Features

- 📄 Compares **each page individually**
- 📝 Tracks **word-level differences**
- 📌 Reports page number and word position
- 💪 Handles large PDFs gracefully
- ❗ Shows missing content when PDFs differ in length

---

## 🧰 Technologies Used

- Java 8+
- Apache PDFBox `2.0.30`
- Maven

---

## 📦 Project Structure
pdf-comparator/
├── pom.xml
├── README.md
└── src/
└── main/
└── java/
└── com/
└── pdfcompare/
└── LargePDFComparator.java
└── resources/
├── pdf1.pdf
└── pdf2.pdf

---

## 📄 How It Works

1. Loads both PDFs using PDFBox.
2. Iterates through each page.
3. Extracts text and tokenizes it into words.
4. Compares each word by index.
5. Logs any mismatches along with:
   - Page number
   - Word position
   - Word from PDF1 vs. PDF2

---

## 🛠 Setup Instructions

### Prerequisites
- Java 8 or higher
- Maven installed

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/yourname/pdf-comparator.git
   cd pdf-comparator
