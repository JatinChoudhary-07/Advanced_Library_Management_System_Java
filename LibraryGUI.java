import javax.swing.*;
import java.awt.*;

public class LibraryGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame(
                "Advanced Library Management System");

        frame.setSize(1200, 750);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        // ==== Title = ===

        JLabel title = new JLabel(
                "Advanced Library Management System",
                SwingConstants.CENTER);

        title.setFont(
                new Font("Arial", Font.BOLD, 30));

        title.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 10, 15, 10));

        frame.add(title, BorderLayout.NORTH);

        // ===== LEFT SIDEBAR =====

        JPanel sidebar = new JPanel();

        sidebar.setLayout(
                new GridLayout(3, 1, 10, 10));

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

        JButton addBookBtn = new JButton("Add Book");

        JButton deleteBookBtn = new JButton("Delete Book");

        JButton updateBookBtn = new JButton("Update Book");

        JButton searchBookBtn = new JButton("Search Book");

        JButton showBooksBtn = new JButton("Show Books");

        addBookBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteBookBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateBookBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchBookBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        showBooksBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        // ================= MEMBER PANEL =================

        JPanel memberPanel = new JPanel();

        memberPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Member Management"));

        memberPanel.setLayout(
                new BoxLayout(
                        memberPanel,
                        BoxLayout.Y_AXIS));

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

        sidebar.add(memberPanel);

        sidebar.add(transactionPanel);

        frame.add(sidebar, BorderLayout.WEST);

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
    }
}