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

    public LibraryManager() {
        loadBooksFromFile();
    }

    public void addMember(Member member) {
        for (Member m : members) {
            if (m.getMemberId() == member.getMemberId()) {
                System.out.println("Member with same ID already exists. Allocate a new Member ID");
                return;
            }
        }members.add(member);
        System.out.println("Member" + member.getName() + "added Successfully");
    }

    public void showAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No active members.");
            return;
        }
        for (Member m : members) {
            m.displayMember();
        }
    }

    public void searchMember(int memberId) {
        for (Member m : members) {
            if (m.getMemberId() == memberId) {
                m.displayMember();
                return;
            }
        }
        System.out.println("Member not found");
    }

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

    public void deleteBook(int index) {
        if (books.isEmpty()) {
            System.out.println("No books found");
            return;
        } else {
            books.remove(index);
            System.out.println("Book deleted successfully");
            saveBooksToFile();
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

    public void issueBook(int bookId, int memberId) {
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
            System.out.println("Invalid Book Id");
            return;
        }
        if (targetMember == null) {
            System.out.println("Invalid Member Id");
            return;
        }
        
        targetBook.setIssued(true);
        targetBook.setIssueDate(LocalDate.now());
        targetBook.setExpectedReturnDate(LocalDate.now().plusDays(14));
        targetMember.issueBook(targetBook);
        saveBooksToFile();
        System.out.println("Book issued successfully to " + targetMember.getName());
    }

    public void returnBook(int bookId, int memberId) {
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
            System.out.println("Invalid Book Id");
            return;
        }
        if (targetMember == null) {
            System.out.println("Invalid Member Id");
            return;
        }
        if (!targetMember.getIssuedBooks().contains(targetBook)){
            System.out.println("This member did no issue this book.");
        }
        targetBook.setIssued(false);
        targetBook.setIssueDate(null);
        targetBook.setExpectedReturnDate(null);
        targetMember.returnBook(targetBook);
        saveBooksToFile();
        System.out.println("Book returned successfully to " + targetMember.getName());
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
                saveBooksToFile();
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

    public void saveBooksToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"));
            for (Book b : books) {
                writer.write(
                        b.getBookId() + "," +
                                b.getTitle() + "," +
                                b.getAuthor() + "," +
                                b.isIssued() + "," +
                                b.getIssueDate() + "," +
                                b.getExpectedReturnDate());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving books");
        }
    }

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