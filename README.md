# 📚 Advanced Library Management System (Java)

<div align="center">




A feature rich desktop based Library Management System built using Java, Object Oriented Programming principles, persistent file storage, and Java Swing GUI architecture.

This project simulates real world library workflows including:
book management, member management, issue-return lifecycle, overdue tracking, fine calculation, validation systems, persistent storage, and modular GUI driven architecture.

</div>

---

# ✨ Features

## 📖 Book Management

* Add Books
* Delete Books
* Update Book Details
* Search Books by Title
* Show All Books
* Show Available Books
* Show Issued Books

---

## 👤 Member Management

* Add Members
* Search Members
* Show All Members
* Track Issued Books Per Member

---

## 🔄 Transaction System

* Issue Books To Members
* Return Books
* Automatic Return Deadline
* Duplicate Book ID Prevention
* Duplicate Member ID Prevention

---

## 📊 Smart Tracking Features

* Overdue Book Detection
* Fine Calculation System
* Real Time Overdue Day Tracking
* Persistent Runtime State

### Example Output

```text
OVERDUE by 5 days
FINE: 50
```

---

# 🧠 OOP Concepts Used

* Classes and Objects
* Constructors
* Encapsulation
* Getters and Setters
* Object Relationships
* Multi Entity Coordination
* Modular Design
* State Management
* Helper Methods
* Lifecycle Tracking

---

# ⚙️ Java Concepts Used

* ArrayList
* LocalDate
* ChronoUnit
* File Handling
* BufferedWriter
* Scanner
* Swing GUI
* Event Driven Design
* Layout Managers
* Validation Logic

---

# 🏗️ Project Structure

```text
Advanced_Library_Management_System_Java
│
├── Book.java
├── Member.java
├── LibraryManager.java
├── LibraryGUI.java
├── README.md
├── .gitignore
└── books.txt
```

---

# 📌 System Architecture

```text
                     +----------------------+
                     |      LibraryGUI      |
                     |----------------------|
                     | Swing Frontend       |
                     | Panels               |
                     | Buttons              |
                     | Output Area          |
                     +----------+-----------+
                                |
                                |
                                v
                    calls backend methods
                                |
                                v
                    +----------------------+
                    |    LibraryManager    |
                    |----------------------|
                    | ArrayList<Book>      |
                    | ArrayList<Member>    |
                    | addBook()            |
                    | addMember()          |
                    | issueBook()          |
                    | returnBook()         |
                    | overdueTracking()    |
                    | filePersistence()    |
                    +----------+-----------+
                               |
            +------------------+------------------+
            |                                     |
            v                                     v
     +---------------+                    +---------------+
     |     Book      |                    |    Member     |
     |---------------|                    |---------------|
     | title         |                    | memberId      |
     | author        |                    | name          |
     | bookId        |                    | issuedBooks   |
     | isIssued      |                    +---------------+
     | issueDate     |
     | returnDate    |
     +---------------+
```

---

# 📚 Book Lifecycle Flow

```text
Available
   |
   | issueBook()
   v
Issued
   |
   | returnBook()
   v
Available
```

---

# 🔄 Issue Workflow

```text
Find Book
    ↓
Find Member
    ↓
Validate Availability
    ↓
Update Book State
    ↓
Add Book To Member
    ↓
Save To File
```

---

# 🔁 Return Workflow

```text
Find Book
    ↓
Find Member
    ↓
Validate Ownership
    ↓
Reset Book State
    ↓
Remove Book From Member
    ↓
Save To File
```

---

# 💾 Persistence Workflow

```text
Program Starts
      ↓
loadBooksFromFile()
      ↓
Reconstruct Book Objects
      ↓
User Performs Operations
      ↓
saveBooksToFile()
      ↓
books.txt Updated
```

---

# 🖥️ GUI Layout Design

```text
 ---------------------------------------------------------
|            Advanced Library Management System           |
 ---------------------------------------------------------

 ---------------------------------------------------------
|  Book Panel  |                                         |
|  Member      |             Output Area                 |
|  Transactions|                                         |
|              |                                         |
 ---------------------------------------------------------

 ---------------------------------------------------------
| Refresh | Clear Output | Exit                          |
 ---------------------------------------------------------
```

---

# 🔒 Encapsulation

Critical fields are protected using:

```java
private
```

and accessed through:

* getters
* setters

This improves:

* data safety
* maintainability
* validation handling
* controlled state updates

---

# 🧪 Sample Workflow

```text
Add Book
    ↓
Add Member
    ↓
Issue Book
    ↓
Assign Return Deadline
    ↓
Detect Overdue
    ↓
Calculate Fine
    ↓
Return Book
    ↓
Persist Updated State
```

---

# 🚀 Current Functionalities

| Feature              | Status |
| -------------------- | ------ |
| Book CRUD            | ✅      |
| Member System        | ✅      |
| Issue / Return       | ✅      |
| Overdue Detection    | ✅      |
| Fine Calculation     | ✅      |
| File Persistence     | ✅      |
| Swing GUI Layout     | ✅      |
| Encapsulation        | ✅      |
| Object Relationships | ✅      |

---

# 📌 Development Approach

This project was manually implemented using an architecture first workflow.

The codebase was not blindly generated or directly copied.
Each subsystem was incrementally:

* designed
* implemented
* validated
* refactored
* integrated

during development.

Focus areas included:

* backend architecture
* object relationships
* persistence systems
* GUI structuring
* modular design
* scalable workflows

---

# 🔮 Planned Improvements

* Full GUI Event Integration
* Database Integration
* Authentication System
* Quantity Based Inventory
* Search Filters
* Book Categories
* Admin Dashboard
* Statistics Panel

---

# 📈 Learning Outcomes

This project strengthened understanding of:

* Object Oriented Programming
* Backend Logic Design
* Java Swing GUI
* Persistent Storage
* Multi Entity Architecture
* Event Driven Programming
* Software Layering
* Real World Application Modeling

---

# ▶️ How To Run

## Compile

```bash
javac *.java
```

## Run

```bash
java LibraryGUI
```

---

# 👨‍💻 Author

## JatinChoudhary-07

Built as part of Java backend, OOP, persistence, and GUI progression journey.
