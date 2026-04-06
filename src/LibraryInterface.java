import java.rmi.Remote; // To provide the Remote interface 
import java.rmi.RemoteException;  // To handle remote invocation errors
import java.util.List;

public interface LibraryInterface extends Remote {

    // Method to get list of available books
    public List<Book> getInventory() throws RemoteException;

    // Method to borrow a book by title
    String borrowBook(String title) throws RemoteException;

    // Method to borrow a book by title and author
    String borrowBook(String title, String author) throws RemoteException;

    // Method to return a book
    String returnBook(Book book) throws RemoteException;
}