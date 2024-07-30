// FactoryMethodPatternExample.java

public class FactoryMethodPatternExample {

    // Step 2: Define Document Interface
    public interface Document {
        void create();
    }

    // Step 3: Create Concrete Document Classes
    public static class WordDocument implements Document {
        @Override
        public void create() {
            System.out.println("Creating a Word Document");
        }
    }

    public static class PdfDocument implements Document {
        @Override
        public void create() {
            System.out.println("Creating a PDF Document");
        }
    }

    public static class ExcelDocument implements Document {
        @Override
        public void create() {
            System.out.println("Creating an Excel Document");
        }
    }

    // Step 4: Implement the Factory Method
    public static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    public static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    public static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    public static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Step 5: Test the Factory Method Implementation
    public static void main(String[] args) {
        // Creating a Word Document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.create();

        // Creating a PDF Document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.create();

        // Creating an Excel Document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.create();
    }
}
