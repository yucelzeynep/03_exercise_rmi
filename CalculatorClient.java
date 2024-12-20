import java.rmi.Naming;

// Step 1: Create the client
public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Step 2: Look up the remote object in the registry
            Calculator calculator = (Calculator) Naming.lookup("//localhost/CalculatorService");
            // Step 3: Call the remote method
            int result = calculator.add(5, 10);
            // Step 4: Display the result
            System.out.println("Result of addition: " + result); // Should print 15
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
