import java.util.Arrays;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book(id=" + bookId + ", title=" + title + ", author=" + author + ")";
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {
        // Create an array of books
        Book[] books = {
            new Book(1, "Java Programming", "Alice"),
            new Book(2, "Data Structures", "Bob"),
            new Book(3, "Algorithms", "Charlie"),
            new Book(4, "Operating Systems", "Diana"),
            new Book(5, "Database Systems", "Eve")
        };

        // Sort books by title for binary search
        Arrays.sort(books, (b1, b2) -> b1.title.compareTo(b2.title));

        // Perform linear search
        String searchTitleLinear = "Algorithms";
        Book resultLinear = linearSearch(books, searchTitleLinear);
        System.out.println("Linear Search Result: " + (resultLinear != null ? resultLinear : "Book not found"));

        // Perform binary search
        String searchTitleBinary = "Algorithms";
        Book resultBinary = binarySearch(books, searchTitleBinary);
        System.out.println("Binary Search Result: " + (resultBinary != null ? resultBinary : "Book not found"));
    }

    // Linear Search Implementation
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search Implementation
    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = books[mid].title.compareTo(title);
            
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
