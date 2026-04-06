// The instances of the book class should be serializable
import java.io.Serializable;

public class Book implements Serializable {
    /*
    In Java, private fields of a class are not accessible directly 
    by its subclasses.

    Thus, serialVersionUID of the Book class is a private field, so it is not 
    part of the its public API and is not inherited by subclasses (EBook, 
    PrintedBook)in the way instance fields are.

    It is used internally by the Java serialization mechanism to verify class 
    compatibility during deserialization.
    */ 
    private static final long serialVersionUID = 1L;

    /*
    Here are the protected fields. Protected is an access modifier that controls 
    the visibility of class members (fields, methods, etc.). It provides a level 
    of access that is more restrictive than public but less restrictive than private.

    These are common to all subclasses of Book and thus will be inherited by them.
    */
    protected String title;
    protected String author;
    protected boolean isBorrowed; 

    // Constructor for the Book class
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false; // All books are initially not borrowed
    }

    public String getDetails() {
        // Basic details with fixed widths
        // Each field will be printed in a 15-character-wide left-aligned column.
        return String.format("%-15s %-15s %-15s", title, author, (isBorrowed ? "Borrowed" : "Available"));
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }
}
