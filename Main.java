import java.util.*;

// Interface (Abstraction)
interface LibraryOperations {
    void issueBook(int studentId, int bookId);
    void returnBook(int studentId, int bookId);
}

// Parent Class
class Person {
    protected int id;
    protected String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

// Book Class
class Book {
    private int bookId;
    private String bookName;
    private String authorName;
    private boolean available;

    public Book(int bookId, String bookName, String authorName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.available = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        available = status;
    }

    public void displayBook() {
        System.out.println("\nBook ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + authorName);
        System.out.println("Status: " + 
                (available ? "Available" : "Issued"));
    }
}

// Student Class (Inheritance)
class Student extends Person {

    private String department;
    private ArrayList<Book> borrowedBooks;

    public Student(int id, String name, String department) {
        super(id, name);
        this.department = department;
        borrowedBooks = new ArrayList<>();
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Method overriding (Polymorphism)
    @Override
    public void displayDetails() {
        System.out.println("\nStudent Details");
        super.displayDetails();
        System.out.println("Department: " + department);

        System.out.println("Borrowed Books:");
        if (borrowedBooks.isEmpty()) {
            System.out.println("None");
        } else {
            for (Book b : borrowedBooks) {
                System.out.println(b.getBookName());
            }
        }
    }
}

// Librarian Class (Inheritance)
class Librarian extends Person {

    public Librarian(int id, String name) {
        super(id, name);
    }

    @Override
    public void displayDetails() {
        System.out.println("\nLibrarian Details");
        super.displayDetails();
    }
}

// Library Class
class Library implements LibraryOperations {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book added successfully");
    }

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available");
            return;
        }

        for (Book b : books) {
            b.displayBook();
        }
    }

    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.id == id)
                return s;
        }
        return null;
    }

    public Book findBook(int id) {
        for (Book b : books) {
            if (b.getBookId() == id)
                return b;
        }
        return null;
    }

    @Override
    public void issueBook(int studentId, int bookId) {

        try {

            Student s = findStudent(studentId);
            Book b = findBook(bookId);

            if (s == null)
                throw new Exception("Student not found");

            if (b == null)
                throw new Exception("Book not found");

            if (!b.isAvailable())
                throw new Exception("Book already issued");

            if (s.getBorrowedBooks().size() >= 3)
                throw new Exception("Borrow limit exceeded");

            s.getBorrowedBooks().add(b);
            b.setAvailable(false);

            System.out.println("Book issued successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void returnBook(int studentId, int bookId) {

        try {

            Student s = findStudent(studentId);
            Book b = findBook(bookId);

            if (s == null || b == null)
                throw new Exception("Invalid ID");

            if (!s.getBorrowedBooks().contains(b))
                throw new Exception(
                        "Student didn't borrow this book");

            s.getBorrowedBooks().remove(b);
            b.setAvailable(true);

            System.out.println("Book returned successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library lib = new Library();

        while (true) {

            System.out.println("\n===== Library Menu =====");
            System.out.println("1.Add Book");
            System.out.println("2.View Books");
            System.out.println("3.Add Student");
            System.out.println("4.Issue Book");
            System.out.println("5.Return Book");
            System.out.println("6.View Student Details");
            System.out.println("7.Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Book Name: ");
                    String bname = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    lib.addBook(
                        new Book(bid, bname, author));
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String sname = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    lib.addStudent(
                        new Student(sid, sname, dept));
                    break;

                case 2:
                    lib.viewBooks();
                    break;

                case 4:
                    System.out.print("Student ID: ");
                    sid = sc.nextInt();

                    System.out.print("Book ID: ");
                    bid = sc.nextInt();

                    lib.issueBook(sid, bid);
                    break;

                case 5:
                    System.out.print("Student ID: ");
                    sid = sc.nextInt();

                    System.out.print("Book ID: ");
                    bid = sc.nextInt();

                    lib.returnBook(sid, bid);
                    break;

                case 6:
                    System.out.print("Student ID: ");
                    sid = sc.nextInt();

                    Student s = lib.findStudent(sid);

                    if (s != null)
                        s.displayDetails();
                    else
                        System.out.println("Student not found");

                    break;

                case 7:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}