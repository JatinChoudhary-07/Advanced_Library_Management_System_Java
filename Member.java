
import java.util.ArrayList;

public class Member {

    private int memberId;
    private String name;
    private ArrayList<Book> issuedBooks;

    // Constructor
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        issuedBooks = new ArrayList<>();
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for member ID
    public int getMemberId() {
        return memberId;
    }

    // Getter for issued books
    public ArrayList<Book> getIssuedBooks() {
        return issuedBooks;
    }

    // Issue a book
    public void issueBook(Book book) {
        issuedBooks.add(book);
    }

    // Return a book
    public void returnBook(Book book) {
        issuedBooks.remove(book);
    }

    // Display member details
    public void displayMember() {
        System.out.println(memberId + " | " + name);
        if (issuedBooks.isEmpty()) {
            System.out.println(name + " has no issued books.");
            return;
        }
        System.out.println("Issued Books: ");
        for (Book b : issuedBooks) {
            System.out.println("- " + b.getTitle());
        }
    }
}
