# 📚 Advanced Library Management System (Java)

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-Concepts-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Active-success?style=for-the-badge)
![Version](https://img.shields.io/badge/Version-V2-orange?style=for-the-badge)

## Advanced_Library_Management_System_Java

A feature rich console based Library Management System built using Java and Object Oriented Programming principles.

This project simulates real world library workflows including:
book issuing, return tracking, overdue detection, fine calculation, validations, filtering systems, and modular backend architecture.

</div>

---

# ✨ Features

## 📖 Core Library Features

* Add Books
* Delete Books
* Update Book Details
* Search Books by Title
* Show All Books

---

## 🔄 Book Lifecycle Management

* Issue Books
* Return Books
* Automatic Return Deadline
* Duplicate Book ID Prevention

---

## 📊 Smart Tracking Features

* Show Available Books
* Show Issued Books
* Overdue Book Detection
* Fine Calculation System

---

# 🧠 OOP Concepts Used

* Classes and Objects
* Constructors
* Encapsulation
* Getters and Setters
* Modular Design
* State Management
* Helper Methods
* Object Lifecycle Tracking

---

# ⚙️ Java Concepts Used

* ArrayList
* LocalDate
* ChronoUnit
* Scanner
* Loops
* Conditional Logic
* Validation Logic
* Method Abstraction

---

# 🏗️ Project Structure

```text
Advanced_Library_Management_System_Java
│
├── Book.java
├── LibraryManager.java
├── Main.java
├── README.md
└── .gitignore
```

---

# 📌 System Design

```text
                +------------------+
                |      Main        |
                |------------------|
                | Menu System      |
                | Scanner Input    |
                | User Interaction |
                +--------+---------+
                         |
                         |
                         v
              calls manager methods
                         |
                         v
              +-------------------+
              |  LibraryManager   |
              |-------------------|
              | ArrayList<Book>   |
              | addBook()         |
              | removeBook()      |
              | searchBook()      |
              | issueBook()       |
              | returnBook()      |
              | overdueTracking() |
              +---------+---------+
                        |
                        |
                        v
                 manages Book objects
                        |
                        v
                +----------------+
                |      Book      |
                |----------------|
                | title          |
                | author         |
                | bookId         |
                | isIssued       |
                | issueDate      |
                | returnDate     |
                +----------------+
```

---

# 📚 Book State Flow

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

# 📅 Overdue & Fine System

The project uses:

```java
LocalDate
ChronoUnit
```

for real time date tracking and overdue calculations.

### Example Output

```text
OVERDUE by 5 days
FINE: 50
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
* controlled state updates
* validation handling

---

# 🧪 Sample Workflow

```text
Add Book
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
```

---

# 🚀 Current Functionalities

| Feature                 | Status |
| ----------------------- | ------ |
| Add Books               | ✅      |
| Delete Books            | ✅      |
| Update Books            | ✅      |
| Search By Title         | ✅      |
| Issue Books             | ✅      |
| Return Books            | ✅      |
| Overdue Detection       | ✅      |
| Fine Calculation        | ✅      |
| Encapsulation           | ✅      |
| Duplicate ID Prevention | ✅      |

---

# 📌 Current Limitations

This version currently uses:

* in memory storage
* console based UI

Data resets after program termination.

---

# 🔮 Planned Improvements

* File Handling Persistence
* Quantity Based Inventory
* Member Management System
* GUI Version
* Database Integration
* Authentication System
* Search Filters
* Book Categories

---

# 📈 Learning Outcomes

This project strengthened understanding of:

* Object Oriented Programming
* Backend Logic Design
* Java Collections Framework
* Date & Time APIs
* State Driven Systems
* Validation Logic
* Real World Software Modeling
* Modular Backend Architecture

---

# ▶️ How To Run

## Compile

```bash
javac Main.java
```

## Run

```bash
java Main
```

---

# 👨‍💻 Author

## JatinChoudhary-07

Built as part of Java backend and OOP progression journey.
