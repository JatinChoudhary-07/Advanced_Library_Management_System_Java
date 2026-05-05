
import java.util.ArrayList;

public class Member {
    
    private int memberId;
    private String name;
    
    private ArrayList<Book> issuedBooks;

    public Member(String name, int memberId){
        this.name = name;
        this.memberId = memberId;

        issuedBooks = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public int getMemberId(){
        return memberId;
    }
    public ArrayList<Book> getIssuedBooks(){
        return issuedBooks;
    }
    public void issueBook(Book book){
        issuedBooks.add(book);
    }
    public void returnBook(Book book){
        issuedBooks.remove(book);
    }

    public void displayMember(){
        System.out.println(memberId + " | " + name);
        if (issuedBooks.isEmpty()){
            System.out.println(name + " has no issued books.");
            return;
        }System.out.println("Issued Books: ");
        for (Book b : issuedBooks){
            System.out.println("- " + b.getTitle());
        }
    }
}
