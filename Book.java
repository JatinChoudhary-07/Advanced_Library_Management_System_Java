
import java.time.LocalDate;

public class Book {

    private String title;
    private String author;
    private boolean isIssued;
    private int bookId;
    private LocalDate issueDate;
    private LocalDate expectedReturnDate;

    public Book(
            String title,
            String author,
            int bookId,
            boolean isIssued,
            LocalDate issueDate,
            LocalDate expectedReturnDate) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.isIssued = isIssued;
        this.issueDate = issueDate;
        this.expectedReturnDate = expectedReturnDate;
    }

    public int getBookId() {
        return bookId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setTitle(String title) {
        if (title.isBlank()) {
            System.out.println("Invalid Title");
            return;
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author.isBlank()) {
            System.out.println("Invalid Author");
            return;
        }
        this.author = author;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public void displayBook() {

        String status;

        if (isIssued) {
            status = "Issued";
        } else {
            status = "Available";
        }
        System.out.println(bookId + " | " + title + " | " + author + " | " + status);

        if (isIssued) {
            System.out.println("Issue Date: " + issueDate);
            System.out.println("Expected Return Date: " + expectedReturnDate);
        }

    }
}