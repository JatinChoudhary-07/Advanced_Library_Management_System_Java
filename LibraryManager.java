import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class LibraryManager {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    // Constructor
    public LibraryManager() {
        loadBooksFromFile();
    }

    // Add a member
    public void addMember(Member member) {
        for (Member m : members) {
            if (m.getMemberId() == member.getMemberId()) {
                System.out.println("Member with same ID already exists. Allocate a new Member ID");
                return;
            }
        }
        members.add(member);
        System.out.println("Member" + member.getName() + "added Successfully");
    }

    // Show all members
    public void showAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No active members.");
            return;
        }
        for (Member m : members) {
            m.displayMember();
        }
    }

    // Search member by ID
    public String searchMember(int memberId) {
        for (Member m : members) {
            if (m.getMemberId() == memberId) {
                StringBuilder output = new StringBuilder();
                output.append(m.getMemberId()).append(" | ").append(m.getName()).append("\n");
                if (m.getIssuedBooks().isEmpty()) {
                    output.append("No books issued");
                } else {
                    output.append("Issued Books:\n");
                    for (Book b : m.getIssuedBooks()) {
                        output.append("- ").append(b.getTitle()).append("\n");
                    }
                }
                return output.toString();
            }
        }
        return "Member not found.";
    }

    // Add a book
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getBookId() == book.getBookId()) {
                System.out.println("Book with same ID already exists. Allocate a new Book ID");
                return;
            }
        }
        books.add(book);
        saveBooksToFile();
    }

    // Delete a book
    public String deleteBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                books.remove(b);
                saveBooksToFile();
                return "Book deleted successfully.";
            }
        }
        return "Invalid Book ID.";
    }

    // Check if empty
    public boolean isEmpty() {
        return books.isEmpty();
    }

    // Show all books
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found");
            return;
        }
        for (Book b : books) {
            b.displayBook();
        }
    }

    // Issue a book
    public String issueBook(int bookId, int memberId) {
        Book targetBook = null;
        Member targetMember = null;
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                targetBook = b;
                break;
            }
        }
        for (Member m : members) {
            if (m.getMemberId() == memberId) {
                targetMember = m;
                break;
            }
        }
        if (targetBook == null) {
            return "Invalid Book Id";
        }
        if (targetMember == null) {
            return "Invalid Member Id";
        }
        targetBook.setIssued(true);
        targetBook.setIssueDate(LocalDate.now());
        targetBook.setExpectedReturnDate(LocalDate.now().plusDays(14));
        targetMember.issueBook(targetBook);
        saveBooksToFile();
        return "Book issued successfully to " + targetMember.getName();
    }

    // Return a book
    public String returnBook(int bookId, int memberId) {
        Book targetBook = null;
        Member targetMember = null;
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                targetBook = b;
                break;
            }
        }
        for (Member m : members) {
            if (m.getMemberId() == memberId) {
                targetMember = m;
                break;
            }
        }
        if (targetBook == null) {
            return "Invalid Book Id";
        }
        if (targetMember == null) {
            return "Invalid Member Id";
        }
        if (!targetMember.getIssuedBooks().contains(targetBook)) {
            return "This member did no issue this book.";
        }
        targetBook.setIssued(false);
        targetBook.setIssueDate(null);
        targetBook.setExpectedReturnDate(null);
        targetMember.returnBook(targetBook);
        saveBooksToFile();
        return "Book returned successfully to " + targetMember.getName();
    }

    // Search by title
    public String searchByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                String status = b.isIssued() ? "Issued" : "Available";
                return b.getBookId() + " | " + b.getTitle() + " | " + b.getAuthor() + " | " + status;
            }
        }
        return "Book not found.";
    }

    // Show available books
    public String showAvailableBooks() {
        StringBuilder output = new StringBuilder();
        boolean found = false;
        for (Book b : books) {
            if (!b.isIssued()) {
                found = true;
                output.append(b.getBookId()).append(" | ").append(b.getTitle()).append(" | ").append(b.getAuthor()).append(" | Available\n");
            }
        }
        if (!found) {
            return "No available books.";
        }
        return output.toString();
    }

    // Show issued books
    public String showIssuedBooks() {
        StringBuilder output = new StringBuilder();
        boolean found = false;
        for (Book b : books) {
            if (b.isIssued()) {
                found = true;
                output.append(b.getBookId()).append(" | ").append(b.getTitle()).append(" | ").append(b.getAuthor()).append(" | Issued\n");
            }
        }
        if (!found) {
            return "No issued books.";
        }
        return output.toString();
    }

    // Update a book
    public String updateBook(int bookId, String newTitle, String newAuthor) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                b.setTitle(newTitle);
                b.setAuthor(newAuthor);
                saveBooksToFile();
                return "Book updated successfully.";
            }
        }
        return "Invalid Book ID.";
    }

    // Get overdue days
    public long getOverdueDays(Book book) {
        if (!book.isIssued() || book.getExpectedReturnDate() == null || !LocalDate.now().isAfter(book.getExpectedReturnDate())) {
            return 0;
        }
        return ChronoUnit.DAYS.between(book.getExpectedReturnDate(), LocalDate.now());
    }

    // Show overdue books
    public String showOverDueBooks() {
        StringBuilder output = new StringBuilder();
        boolean found = false;
        for (Book b : books) {
            long overdueDays = getOverdueDays(b);
            if (overdueDays > 0) {
                found = true;
                output.append(b.getBookId()).append(" | ").append(b.getTitle()).append(" | Overdue by ").append(overdueDays).append(" days\n");
            }
        }
        if (!found) {
            return "No overdue books.";
        }
        return output.toString();
    }

    // Calculate fine
    public String calculateFine(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                long overdueDays = getOverdueDays(b);
                if (overdueDays > 0) {
                    long fine = overdueDays * 10;
                    return "Book: " + b.getTitle() + "\nOverdue Days: " + overdueDays + "\nFine: ₹" + fine;
                }
                return "No fine pending.";
            }
        }
        return "Invalid Book ID.";
    }

    // Get all books
    public String getAllBooks() {
        if (books.isEmpty()) {
            return "No books found.";
        }
        StringBuilder output = new StringBuilder();
        for (Book b : books) {
            output.append(b.getBookId()).append(" | ").append(b.getAuthor()).append(" | ");
            if (b.isIssued()) {
                output.append("Issued");
            } else {
                output.append("Available");
            }
            output.append("\n");
        }
        return output.toString();
    }

    // Get all members
    public String getAllMembers() {
        if (members.isEmpty()) {
            return "No members found.";
        }
        StringBuilder output = new StringBuilder();
        for (Member m : members) {
            output.append(m.getMemberId()).append(" | ").append(m.getName()).append("\n");
            if (m.getIssuedBooks().isEmpty()) {
                output.append("No books issued\n");
            } else {
                output.append("Issued Books:\n");
                for (Book b : m.getIssuedBooks()) {
                    output.append("- ").append(b.getTitle()).append("\n");
                }
            }
            output.append("\n");
        }
        return output.toString();
    }

    // Save books to file
    public void saveBooksToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"));
            for (Book b : books) {
                writer.write(b.getBookId() + "," + b.getTitle() + "," + b.getAuthor() + "," + b.isIssued() + "," + b.getIssueDate() + "," + b.getExpectedReturnDate());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving books");
        }
    }

    // Load books from file
    public void loadBooksFromFile() {
        try {
            File file = new File("books.txt");
            if (!file.exists()) {
                return;
            }
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] data = line.split(",");
                int bookId = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                boolean isIssued = Boolean.parseBoolean(data[3]);
                LocalDate issueDate = null;
                LocalDate expectedReturnDate = null;
                if (!data[4].equals("null")) {
                    issueDate = LocalDate.parse(data[4]);
                }
                if (!data[5].equals("null")) {
                    expectedReturnDate = LocalDate.parse(data[5]);
                }
                Book book = new Book(title, author, bookId, isIssued, issueDate, expectedReturnDate);
                books.add(book);
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println("Error loading books");
        }
    }
}