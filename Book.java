
import java.time.LocalDate;

public class Book {

    private String title;
    private String author;
    private boolean isIssued;
    private int bookId;
    private LocalDate issueDate;
    private LocalDate expectedReturnDate;

    // Constructor
    public Book(String title, String author, int bookId, boolean isIssued, LocalDate issueDate, LocalDate expectedReturnDate) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.isIssued = isIssued;
        this.issueDate = issueDate;
        this.expectedReturnDate = expectedReturnDate;
    }

    // Getter for book ID
    public int getBookId() {
        return bookId;
    }

    // Getter for issue date
    public LocalDate getIssueDate() {
        return issueDate;
    }

    // Getter for expected return date
    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Getter for issued status
    public boolean isIssued() {
        return isIssued;
    }

    // Setter for title
    public void setTitle(String title) {
        if (title.isBlank()) {
            System.out.println("Invalid Title");
            return;
        }
        this.title = title;
    }

    // Setter for author
    public void setAuthor(String author) {
        if (author.isBlank()) {
            System.out.println("Invalid Author");
            return;
        }
        this.author = author;
    }

    // Setter for issued status
    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    // Setter for issue date
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    // Setter for expected return date
    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    // Display book details
    public void displayBook() {
        String status = isIssued ? "Issued" : "Available";
        System.out.println(bookId + " | " + title + " | " + author + " | " + status);
        if (isIssued) {
            System.out.println("Issue Date: " + issueDate);
            System.out.println("Expected Return Date: " + expectedReturnDate);
        }
    }
}