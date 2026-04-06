import java.rmi.Naming; // To look up remote objects via RMI registry
import java.rmi.RemoteException; // To handle remote invocation exceptions
import java.util.List;

public class RMIClient {
    public static void main(String[] args) {
        // Check if no command-line arguments are provided
        if (args.length == 0) {
        // If no arguments, print usage instructions to guide the user
            printUsage();
            return;
        }

        try {
            // Lookup the remote Library object from RMI registry at localhost:2100
            // The string "//localhost:2100/Library" specifies the host, port, and object name
            // The object returned by Naming.lookup() is a remote object (or proxy).
            LibraryInterface library = (LibraryInterface) Naming.lookup("//localhost:2100/Library");
            String command = args[0];

            // The first argument is expected to be the command
            // Use a switch statement to handle different commands
            switch (command) {
                case "getInventory":
                    printInventory(library);
                    break;

                case "borrowBook":
                    handleBorrowBook(library, args);
                    break;

                case "returnBook":
                    handleReturnBook(library, args);
                    break;

                default:
                    System.out.println("Unknown command: " + command);
                    printUsage();
            }
        } catch (Exception e) {
            // Catch any exceptions during RMI lookup or remote method calls
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /*
    * Prints usage instructions for how to run the client
    */
    private static void printUsage() {
        System.out.println("Usage: java RMIClient <command> [parameters...]");
        System.out.println("Commands:");
        System.out.println("  getInventory");
        System.out.println("  borrowBook <title>");
        System.out.println("  borrowBook <title> <author>");
        System.out.println("  returnBook <title> <author>");
    }

    /*
    * Fetches and displays the current inventory of books in the library
    * getInventory is the server side method, and printInventory is the
    * client side method.
    */
    private static void printInventory(LibraryInterface library) throws RemoteException {
        /*
        Call the getInventory() method on the library object.
        Since the method involves an RMI, it can throw a RemoteException.
        */
       List<Book> books = library.getInventory();
        System.out.println("Library Inventory:");
        for (Book book : books) {
            // Call the getDetails method of the subclass
            System.out.println(" - " + book.getDetails());
        }
    }
    /*
    * Handles the process of borrowing a book on client side
    * On the server side method, we can call different methods based on 
    * the number of args.
    */
    private static void handleBorrowBook(LibraryInterface library, String[] args) throws RemoteException {
        if (args.length == 2) {
            String title = args[1];
            String result = library.borrowBook(title);
            System.out.println(result);
        } else if (args.length == 3) {
            String title = args[1];
            String author = args[2];
            String result = library.borrowBook(title, author);
            System.out.println(result);
        } else {
            System.out.println("Invalid arguments for borrowBook");
            printUsage();
        }
    }

    private static void handleReturnBook(LibraryInterface library, String[] args) throws RemoteException {
        if (args.length != 3) {
            System.out.println("Invalid arguments for returnBook. Usage: returnBook <title> <author>");
            return;
        }

        String title = args[1];
        String author = args[2];

        Book bookToReturn = createBookBasedOnDetails(title, author);
        if (bookToReturn != null) {
            String result = library.returnBook(bookToReturn);
            System.out.println(result);
        }
    }

    /*
    * Factory method to create either an EBook or PrintedBook based on the details.
    */
    private static Book createBookBasedOnDetails(String title, String author) {
        return new Book(title, author);
    }
}
