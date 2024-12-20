import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

// Step 1: Create a remote interface
interface Calculator extends java.rmi.Remote {
    int add(int a, int b) throws RemoteException; // Method to be called remotely
}

// Step 2: Implement the server
public class CalculatorServer extends UnicastRemoteObject implements Calculator {
    
    protected CalculatorServer() throws RemoteException {
        super();
    }

    // Implementation of the remote method
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b; // Return the sum of a and b
    }

    public static void main(String[] args) {
        try {
            // Step 3: Create and export the remote object
            CalculatorServer server = new CalculatorServer();
            // Step 4: Create RMI registry
            LocateRegistry.createRegistry(1099);
            // Step 5: Bind the remote object in the registry
            Naming.rebind("CalculatorService", server);
            System.out.println("Calculator Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
