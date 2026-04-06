import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {

            Library library = new Library();

            LocateRegistry.createRegistry(2100);
            Naming.rebind("//localhost:2100/Library", library);

            //registry.rebind("LibraryService", library);
            System.out.println("Library RMI Server is ready.");
        } catch (Exception e) {
            System.out.println("RMIServer error: " + e.getMessage());
        }
    }
}