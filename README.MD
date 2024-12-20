### Programming Exercise: Remote Procedure Call (RPC) with Java on Render

#### Exercise Definition:
In this exercise, you will create a simple Java-based remote procedure call (RPC) service that performs addition and subtraction of two integers. You will deploy this service on Render, a cloud platform, to demonstrate your understanding of RPC and cloud deployment.

#### Objectives:
1. Create a Java application that exposes remote methods for addition and subtraction.
2. Deploy the application on Render.
3. Create a client to call these remote methods.

#### Step-by-Step Instructions:

**Step 1: Setting Up Your Java Project**
1. Create a new directory for your project.
2. Inside this directory, create the following structure:
   ```
   rpc-example/
      ├── src/
      │   ├── server/
      │   │   └── RpcServer.java
      │   ├── client/
      │   │   └── RpcClient.java
      └── pom.xml
   ```

**Step 2: Write the RPC Server Code**
- Open `RpcServer.java` and write the following code:

```java
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Define the remote interface
interface MathService extends Remote {
    int add(int a, int b) throws RemoteException; // Method for addition
    int subtract(int a, int b) throws RemoteException; // Method for subtraction
}

// Implement the remote interface
public class RpcServer extends UnicastRemoteObject implements MathService {
    // Constructor
    protected RpcServer() throws RemoteException {
        super();
    }

    // Implement the addition method
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b; // Return the sum of a and b
    }

    // Implement the subtraction method
    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b; // Return the difference of a and b
    }

    // Method to start the server
    public static void main(String[] args) {
        try {
            // Create an instance of the server
            RpcServer server = new RpcServer();
            // Bind the server to the RMI registry
            java.rmi.Naming.rebind("MathService", server);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
```

**Step 3: Write the RPC Client Code**
- Open `RpcClient.java` and write the following code:

```java
package client;

import java.rmi.Naming;

public class RpcClient {
    public static void main(String[] args) {
        try {
