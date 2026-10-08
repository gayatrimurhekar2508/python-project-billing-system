import java.util.ArrayList;
import java.util.List;

class Book {
    private String id, title, author;
    private boolean issued;

    public Book(String id, String title, String author) {
        this.id = id; this.title = title; this.author = author;
    }
    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIssued() { return issued; }
    public void setIssued(boolean issued) { this.issued = issued; }

    public String toString() {
        return String.format("%-6s %-28s %-20s %-10s", id, title, author,
                issued ? "Issued" : "Available");
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book.getTitle());
    }

    public void removeBook(String id) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                if (book.isIssued()) { System.out.println("Cannot remove an issued book."); return; }
                books.remove(book); System.out.println("Book removed."); return;
            }
        }
        System.out.println("Book not found.");
    }

    public void issueBook(String id) {
        for (Book book : books) if (book.getId().equalsIgnoreCase(id)) {
            if (book.isIssued()) System.out.println("Book already issued.");
            else { book.setIssued(true); System.out.println("Book issued: " + book.getTitle()); }
            return;
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String id) {
        for (Book book : books) if (book.getId().equalsIgnoreCase(id)) {
            if (!book.isIssued()) System.out.println("Book is already available.");
            else { book.setIssued(false); System.out.println("Book returned: " + book.getTitle()); }
            return;
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
        System.out.println("\nID     Title                        Author               Status");
        System.out.println("---------------------------------------------------------------------");
        for (Book book : books) System.out.println(book);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");
        library.addBook(new Book("B101", "Java Programming", "James Gosling"));
        library.addBook(new Book("B102", "Python Basics", "Mark Lutz"));
        library.addBook(new Book("B103", "Clean Code", "Robert Martin"));
        library.displayBooks();
        library.issueBook("B101");
        library.returnBook("B101");
        library.removeBook("B103");
        library.displayBooks();
    }
}
