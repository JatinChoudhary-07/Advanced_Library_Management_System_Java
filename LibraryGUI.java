import javax.swing.*;
import java.awt.*;

public class LibraryGUI {

    // Helper method to connect button action
    public static void connectButton(JButton button, Runnable action) {
        button.addActionListener(e -> action.run());
    }

    public static void main(String[] args) {

        LibraryManager manager = new LibraryManager();

        JFrame frame = new JFrame(
                "Advanced Library Management System");

        frame.setSize(1200, 750);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        // Create title label
        JLabel title = new JLabel("Advanced Library Management System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        frame.add(title, BorderLayout.NORTH);

        // ===== LEFT SIDEBAR =====

        JPanel sidebar = new JPanel();

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS));

        sidebar.setPreferredSize(
                new Dimension(420, 700));

        sidebar.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 10, 10, 10));

        // ================= BOOK PANEL =================

        JPanel bookPanel = new JPanel();

        bookPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Book Management"));

        bookPanel.setLayout(
                new BoxLayout(
                        bookPanel,
                        BoxLayout.Y_AXIS));

        bookPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        340));

        JButton addBookBtn = new JButton("Add Book");

        JButton deleteBookBtn = new JButton("Delete Book");

        JButton updateBookBtn = new JButton("Update Book");

        JButton searchBookBtn = new JButton("Search Book");

        JButton showBooksBtn = new JButton("Show Books");

        JButton availableBooksBtn = new JButton("Available Books");

        JButton issuedBooksBtn = new JButton("Issued Books");

        addBookBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteBookBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateBookBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchBookBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        showBooksBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        availableBooksBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        issuedBooksBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        bookPanel.add(Box.createVerticalStrut(10));
        bookPanel.add(addBookBtn);

        bookPanel.add(Box.createVerticalStrut(10));
        bookPanel.add(deleteBookBtn);

        bookPanel.add(Box.createVerticalStrut(10));
        bookPanel.add(updateBookBtn);

        bookPanel.add(Box.createVerticalStrut(10));
        bookPanel.add(searchBookBtn);

        bookPanel.add(Box.createVerticalStrut(10));
        bookPanel.add(showBooksBtn);

        bookPanel.add(Box.createVerticalStrut(10));
        bookPanel.add(availableBooksBtn);

        bookPanel.add(Box.createVerticalStrut(10));
        bookPanel.add(Box.createVerticalStrut(10));
        bookPanel.add(issuedBooksBtn);

        // ================= MEMBER PANEL =================

        JPanel memberPanel = new JPanel();

        memberPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Member Management"));

        memberPanel.setLayout(
                new BoxLayout(
                        memberPanel,
                        BoxLayout.Y_AXIS));

        memberPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        220));

        JButton addMemberBtn = new JButton("Add Member");

        JButton showMembersBtn = new JButton("Show Members");

        JButton searchMemberBtn = new JButton("Search Member");

        addMemberBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        showMembersBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchMemberBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        memberPanel.add(Box.createVerticalStrut(10));
        memberPanel.add(addMemberBtn);

        memberPanel.add(Box.createVerticalStrut(10));
        memberPanel.add(showMembersBtn);

        memberPanel.add(Box.createVerticalStrut(10));
        memberPanel.add(searchMemberBtn);

        // ================= TRANSACTION PANEL =================

        JPanel transactionPanel = new JPanel();

        transactionPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Transactions"));

        transactionPanel.setLayout(
                new BoxLayout(
                        transactionPanel,
                        BoxLayout.Y_AXIS));

        transactionPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        240));

        JButton issueBookBtn = new JButton("Issue Book");

        JButton returnBookBtn = new JButton("Return Book");

        JButton overdueBtn = new JButton("Overdue Books");

        JButton fineBtn = new JButton("Calculate Fine");

        issueBookBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnBookBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        overdueBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        fineBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        transactionPanel.add(Box.createVerticalStrut(10));
        transactionPanel.add(issueBookBtn);

        transactionPanel.add(Box.createVerticalStrut(10));
        transactionPanel.add(returnBookBtn);

        transactionPanel.add(Box.createVerticalStrut(10));
        transactionPanel.add(overdueBtn);

        transactionPanel.add(Box.createVerticalStrut(10));
        transactionPanel.add(fineBtn);

        // ================= ADD PANELS TO SIDEBAR =================

        sidebar.add(bookPanel);
        sidebar.add(
                Box.createVerticalStrut(15));

        sidebar.add(memberPanel);
        sidebar.add(
                Box.createVerticalStrut(15));

        sidebar.add(transactionPanel);

        frame.add(sidebar, BorderLayout.WEST);
        JScrollPane sidebarScroll = new JScrollPane(sidebar);

        sidebarScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(
                sidebarScroll,
                BorderLayout.WEST);

        // ================= TOP TOOLBAR =================

        JToolBar toolBar = new JToolBar();

        toolBar.setFloatable(false);

        JButton refreshBtn = new JButton("Refresh");

        JButton clearBtn = new JButton("Clear Output");

        JButton exitBtn = new JButton("Exit");

        toolBar.add(refreshBtn);

        toolBar.addSeparator();

        toolBar.add(clearBtn);

        toolBar.addSeparator();

        toolBar.add(exitBtn);

        frame.add(toolBar, BorderLayout.SOUTH);

        // ================= CENTER OUTPUT AREA =================

        JTextArea outputArea = new JTextArea();

        outputArea.setEditable(false);

        outputArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        16));

        outputArea.setMargin(
                new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.add(scrollPane, BorderLayout.CENTER);

        // ================= FINAL =================

        frame.setVisible(true);

        connectButton(showBooksBtn, () -> outputArea.setText(manager.getAllBooks()));

        connectButton(addBookBtn, () -> {

            String bookTitle = JOptionPane.showInputDialog(
                    frame,
                    "Enter Book Title:");

            if (bookTitle == null ||
                    bookTitle.isBlank()) {

                return;
            }

            String author = JOptionPane.showInputDialog(
                    frame,
                    "Enter Author Name:");

            if (author == null ||
                    author.isBlank()) {

                return;
            }

            String idInput = JOptionPane.showInputDialog(
                    frame,
                    "Enter Book ID:");

            if (idInput == null ||
                    idInput.isBlank()) {

                return;
            }

            int bookId;

            try {

                bookId = Integer.parseInt(idInput);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Book ID.");

                return;
            }

            Book book = new Book(
                    bookTitle,
                    author,
                    bookId,
                    false,
                    null,
                    null);

            manager.addBook(book);

            outputArea.setText(
                    "Book added successfully.");
        });

        connectButton(showMembersBtn, () -> outputArea.setText(manager.getAllMembers()));

        connectButton(addMemberBtn, () -> {

            String memberName = JOptionPane.showInputDialog(
                    frame,
                    "Enter Member Name:");

            if (memberName == null ||
                    memberName.isBlank()) {

                return;
            }

            String idInput = JOptionPane.showInputDialog(
                    frame,
                    "Enter Member ID:");

            if (idInput == null ||
                    idInput.isBlank()) {

                return;
            }

            int memberId;

            try {

                memberId = Integer.parseInt(idInput);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Member ID.");

                return;
            }

            Member member = new Member(
                    memberName,
                    memberId);

            manager.addMember(member);

            outputArea.setText(
                    "Member added successfully.");
        });

        connectButton(issueBookBtn, () -> {

            String bookInput = JOptionPane.showInputDialog(
                    frame,
                    "Enter Book ID:");

            if (bookInput == null ||
                    bookInput.isBlank()) {

                return;
            }

            String memberInput = JOptionPane.showInputDialog(
                    frame,
                    "Enter Member ID:");

            if (memberInput == null ||
                    memberInput.isBlank()) {

                return;
            }

            try {

                int bookId = Integer.parseInt(bookInput);
                int memberId = Integer.parseInt(memberInput);

                outputArea.setText(manager.issueBook(bookId, memberId));

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Input");
            }
        });

        connectButton(returnBookBtn, () -> {

            String bookInput = JOptionPane.showInputDialog(
                    frame,
                    "Enter Book ID:");

            if (bookInput == null ||
                    bookInput.isBlank()) {

                return;
            }

            String memberInput = JOptionPane.showInputDialog(
                    frame,
                    "Enter Member ID:");

            if (memberInput == null ||
                    memberInput.isBlank()) {

                return;
            }

            try {

                int bookId = Integer.parseInt(bookInput);

                int memberId = Integer.parseInt(memberInput);

                outputArea.setText(
                        manager.returnBook(
                                bookId,
                                memberId));

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Input");
            }
        });

        connectButton(searchBookBtn, () -> {

            String titleInput = JOptionPane.showInputDialog(
                    frame,
                    "Enter Book Title:");

            if (titleInput == null ||
                    titleInput.isBlank()) {

                return;
            }

            outputArea.setText(
                    manager.searchByTitle(
                            titleInput));
        });

        connectButton(searchMemberBtn, () -> {

            String memberInput = JOptionPane.showInputDialog(
                    frame,
                    "Enter Member ID:");

            if (memberInput == null ||
                    memberInput.isBlank()) {

                return;
            }

            try {

                int memberId = Integer.parseInt(
                        memberInput);

                outputArea.setText(
                        manager.searchMember(
                                memberId));

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Member ID");
            }
        });

        connectButton(availableBooksBtn, () -> outputArea.setText(manager.showAvailableBooks()));

        connectButton(issuedBooksBtn, () -> outputArea.setText(manager.showIssuedBooks()));

        connectButton(overdueBtn, () -> outputArea.setText(manager.showOverDueBooks()));

        connectButton(fineBtn, () -> {

            String input = JOptionPane.showInputDialog(
                    frame,
                    "Enter Book ID:");

            if (input == null ||
                    input.isBlank()) {

                return;
            }

            try {

                int bookId = Integer.parseInt(input);

                outputArea.setText(
                        manager.calculateFine(
                                bookId));

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Book ID");
            }
        });

        connectButton(clearBtn, () -> outputArea.setText(""));

        connectButton(exitBtn, () -> System.exit(0));

        connectButton(deleteBookBtn, () -> {

            String input = JOptionPane.showInputDialog(
                    frame,
                    "Enter Book ID:");

            if (input == null ||
                    input.isBlank()) {

                return;
            }

            try {

                int bookId = Integer.parseInt(input);

                outputArea.setText(
                        manager.deleteBook(bookId));

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Book ID");
            }
        });

        connectButton(updateBookBtn, () -> {

            String input = JOptionPane.showInputDialog(
                    frame,
                    "Enter Book ID:");

            if (input == null ||
                    input.isBlank()) {

                return;
            }

            try {

                int bookId = Integer.parseInt(input);

                String newTitle = JOptionPane.showInputDialog(
                        frame,
                        "Enter New Title:");

                if (newTitle == null ||
                        newTitle.isBlank()) {

                    return;
                }

                String newAuthor = JOptionPane.showInputDialog(
                        frame,
                        "Enter New Author:");

                if (newAuthor == null ||
                        newAuthor.isBlank()) {

                    return;
                }

                outputArea.setText(
                        manager.updateBook(
                                bookId,
                                newTitle,
                                newAuthor));

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Input");
            }
        });

        connectButton(
                refreshBtn,

                () -> outputArea.setText(
                        manager.getAllBooks()));
    }
}