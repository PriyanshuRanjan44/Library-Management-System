# 📚 Library Management System

A Java-based console application developed using Object-Oriented Programming (OOP) concepts to manage library operations such as adding books, adding students, issuing books, returning books, and viewing student details.

This project demonstrates practical implementation of core Java concepts including:

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Interfaces
- Exception Handling
- Collections Framework

---

## 🚀 Features

✅ Add new books to library  
✅ View available books  
✅ Add students  
✅ Issue books to students  
✅ Return issued books  
✅ View student details and borrowed books  
✅ Borrow limit restriction (Maximum: 3 books)  
✅ Book availability tracking  
✅ Exception handling for invalid operations  

---

## 🛠️ Technologies Used

- Java
- OOP Concepts
- Collections Framework (`ArrayList`)
- Exception Handling
- Scanner Class

---

## 📂 Project Structure

```text
Library-Management-System/
│
├── Main.java
├── Person.java
├── Student.java
├── Librarian.java
├── Book.java
├── Library.java
├── LibraryOperations.java
│
└── README.md
```

*(If all classes are inside a single file, keep only `Main.java`.)*

---

## 🏗️ OOP Concepts Implemented

### Encapsulation
- Book class keeps fields private
- Getter and Setter methods are used for controlled access

### Inheritance
- `Student` and `Librarian` classes inherit from `Person`

### Polymorphism
- `displayDetails()` method is overridden in child classes

### Abstraction
- `LibraryOperations` interface defines library functions

### Exception Handling
Handles cases like:

- Student not found
- Book not found
- Book already issued
- Borrow limit exceeded
- Invalid return requests

---

## ⚙️ How to Run

### Clone Repository

```bash
git clone https://github.com/PriyanshuRanjan44/Library-Management-System.git
```

### Open project

Open in:

- VS Code
- IntelliJ IDEA
- Eclipse

### Compile Java program

```bash
javac Main.java
```

### Run program

```bash
java Main
```

---

## 📋 Menu Options

```text
===== Library Menu =====

1. Add Book
2. View Books
3. Add Student
4. Issue Book
5. Return Book
6. View Student Details
7. Exit
```

---

## 💻 Sample Execution

```text
===== Library Menu =====

1.Add Book
2.View Books
3.Add Student
4.Issue Book
5.Return Book
6.View Student Details
7.Exit

Enter choice: 1

Book ID: 101
Book Name: Java Programming
Author: James Gosling

Book added successfully
```

---

## 🔒 Constraints

- A student can borrow a maximum of 3 books
- A book cannot be issued if already borrowed
- Invalid IDs are handled using exceptions

---

## 🎯 Future Improvements

- Database integration (MySQL)
- GUI using Java Swing/JavaFX
- Admin login system
- Fine calculation system
- Search books feature
- File handling for persistent storage

---

## 👨‍💻 Author

**Priyanshu Ranjan**

GitHub:
https://github.com/PriyanshuRanjan44

---

## ⭐ Support

If you found this project useful, consider giving it a star ⭐