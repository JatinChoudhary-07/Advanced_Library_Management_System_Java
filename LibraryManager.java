import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryManager {

    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {

        for (Book b : books) {
            if (b.getBookId() == book.getBookId()) {
                System.out.println("Book with same ID already exists. Allocate a new Book ID");
                return;
            }
        }
        books.add(book);
    }

    public void deleteBook(int index) {
        if (books.isEmpty()) {
            System.out.println("No books found");
            return;
        } else {
            books.remove(index);
            System.out.println("Book deleted successfully");
        }
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found");
            return;
        }
        for (Book b : books) {
            b.displayBook();
        }
    }

    public void issueBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                if (b.isIssued()) {
                    System.out.println("Book already issued.\nTry Again On " + b.getExpectedReturnDate());
                } else {
                    b.setIssued(true);
                    b.setIssueDate(LocalDate.now());
                    b.setExpectedReturnDate(LocalDate.now().plusDays(14));
                    System.out.println("Book issued successfully.\nKindly Return By: " + b.getExpectedReturnDate());
                }
                return;
            }
        }
        System.out.println("Invalid bookId");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                if (b.isIssued()) {
                    b.setIssued(false);
                    b.setIssueDate(null);
                    b.setExpectedReturnDate(null);
                    System.out.println("Book returned successfully.\nThank You");
                } else {
                    System.out.println("Book already available in library.");
                }
                return;
            }
        }
        System.out.println("Invalid bookId");
    }

    public void searchByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.displayBook();
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void showAvailableBooks() {
        boolean found = false;
        for (Book b : books) {
            if (!b.isIssued()) {
                b.displayBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books");
        }
    }

    public void showIssuedBooks() {
        boolean found = false;
        for (Book b : books) {
            if (b.isIssued()) {
                b.displayBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No issued books");
        }
    }

    public void updateBook(int bookId, String newTitle, String newAuthor) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                b.setTitle(newTitle);
                b.setAuthor(newAuthor);
                System.out.println("Book updated successfully");
                return;
            }
        }
        System.out.println("Invalid Book ID");
    }

    public long getOverdueDays(Book book) {
        if (!book.isIssued() || book.getExpectedReturnDate() == null
                || !LocalDate.now().isAfter(book.getExpectedReturnDate())) {
            return 0;
        }
        return ChronoUnit.DAYS.between(book.getExpectedReturnDate(), LocalDate.now());
    }

    public void showOverDueBooks() {
        boolean found = false;
        for (Book b : books) {
            if (getOverdueDays(b) > 0) {
                b.displayBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No overdue books");
        }
    }

    public void calculateFine(int bookId) {
        boolean found = false;
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                found = true;
                if (getOverdueDays(b) > 0) {
                    long fine = getOverdueDays(b) * 10;
                    System.out.println("OVERDUE days: " + getOverdueDays(b) + "\nFINE: " + fine);
                } else {
                    System.out.println("No overdue.");
                }
                return;
            }
        }
        if (!found) {
            System.out.println("Invalid bookId");
        }
    }

}