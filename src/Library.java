import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Library extends UnicastRemoteObject implements LibraryInterface {
    /*
    Here we set up a variable (books) without allocating memory.
    The variable is accessible only within the class in which it is declared.
    The type of the variable is List<Book>, i.e. a list that holds objects of type Book.
    Declaring the variable as List<Book> (the interface) rather than ArrayList<Book>
    (the concrete class) allows you to change the implementation later, if necessary, 
    without changing the rest of the code. This is a common best practice in Java 
    promoting loose coupling.
    */
    private List<Book> books = new ArrayList<>();

    public Library() throws RemoteException {
        super();
        
        // Add some books
        books.add(new PrintedBook("Assembly", "Alice", 100));
        books.add(new PrintedBook("Assembly", "Arthur", 1000));
        books.add(new PrintedBook("BASIC", "Bob", 200));
        books.add(new PrintedBook("C", "Carol", 300));

        books.add(new EBook("Python", "Paul", 1));
        books.add(new EBook("Ruby", "Robert", 2));
        books.add(new EBook("SQL", "Sarah", 3));
    }
    /*
    The @Override annotation indicates that this method overrides a method declared 
    in a superclass or interface.
    It ensures compile-time checking; if no such method exists in the 
    superclass/interface, the compiler will generate an error.
    */
    @Override
    public List<Book> getInventory() throws RemoteException {
        /* Creates and returns a new ArrayList containing all elements 
        from the internal books list (to avoid exposing internal list)
        */
        return new ArrayList<>(books); 
    }

    @Override
    public String borrowBook(String title) {
        // Borrows the (first) book in the inventory with the matching title 
        // Loop through the list of books in the inventory
        for (Book book : books) {
            // Check if the current book's title matches the provided title (case-insensitive)
            if (book.title.equalsIgnoreCase(title)) {
                // If the book is found, check if it is already borrowed
                if (!book.isBorrowed()) {
                    // If not borrowed, mark it as borrowed
                    book.setBorrowed(true);
                    // Return a confirmation message along with the book's details
                    return "Borrowed: " + book.getDetails();
                } else {
                    // If the book is already borrowed, inform the user
                    return "Book is already borrowed.";
                }
            }
        }
        // If no matching book is found in the inventory, inform the user
        return "Book not found.";
    }
    
    /*
    Below we have a method with the same name as the one above. 
    This is a classic example of method overloading, where multiple methods 
    share the same name but differ in the number or types of parameters.
    Overloading allows you to provide different ways to perform a similar action 
    in different input scenarios. The Java compiler determines which method to 
    invoke based on the method signature during compile time.
    */

    @Override
    public String borrowBook(String title, String author) {
        // Borrows the (first) book in the inventory with the matching title and author
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.author.equalsIgnoreCase(author)) {
                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    return "Borrowed: " + book.getDetails();
                } else {
                    return "Book is already borrowed.";
                }
            }
        }
        return "Book not found.";
    }

    @Override
    public String returnBook(Book bookToReturn) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(bookToReturn.title) &&
                book.author.equalsIgnoreCase(bookToReturn.author)) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    return "Returned: " + book.getDetails();
                } else {
                    return "Book was not borrowed.";
                }
            }
        }
        return "Book not found.";
    }
}